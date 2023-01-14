package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;
import main.Main;
import model.Brand;

<<<<<<< HEAD
public class ManageBrand{
	
	public static ManageBrand ManageBrand;
=======
public class ManageBrand {
>>>>>>> cbbfd9293f70ece0e160be6001f0d019ab5039de
	
	Button btinsertbrand, btupdatebrand, btdeletebrand;
	Label lbbrand;
	TextField tfnameinput;
	TableView<Brand> branddetail;
	ArrayList<Brand> brandList;
	ScrollPane spbrand;
	
	HBox hbisi;
	HBox hbutton;
	VBox vbmanage;
	
	Scene sc;
	GridPane gpmanage;
	GridPane gpmanage2;
	BorderPane bpmanage;
	
	Window window;
	
	int BrandID;
	
	public static ManageBrand getInstance() {
		if (ManageBrand == null) {
			ManageBrand = new ManageBrand();
		}
		return ManageBrand;
	}
	
	@SuppressWarnings("unchecked")
	public void table() {
		branddetail = new TableView<Brand>();
		TableColumn<Brand,Integer> 	brandid = new TableColumn<Brand, Integer>("Brand ID");
		brandid.setMinWidth(100);
		brandid.setCellValueFactory(new PropertyValueFactory<Brand, Integer>("BrandID"));
		
		
		TableColumn<Brand,String> 	brandname = new TableColumn<Brand, String>("Brand Name");
		brandname.setMinWidth(300);
		brandname.setCellValueFactory(new PropertyValueFactory<Brand, String>("BrandName"));
		
		branddetail.getColumns().addAll(brandid, brandname);
		
		bpmanage.setTop(branddetail);
	}
	
	public void refreshTable() {
		brandList.clear();
		getBrand();
		ObservableList<Brand> brandObs = FXCollections.observableArrayList(brandList);
		branddetail.setItems(brandObs);
	}
	
	public void getBrand() {
		DBConnect dbConnect = DBConnect.getInstance();
		ResultSet rs = null;
		rs = dbConnect.executeQuery("SELECT * FROM `brand`");
		try {
			while(rs.next()) {
				int BrandID = rs.getInt("BrandID");
				String BrandName = rs.getString("BrandName");
				brandList.add(new Brand(BrandID,BrandName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init() {
		bpmanage= new BorderPane();
		gpmanage = new GridPane();
		gpmanage2 = new GridPane();
		brandList = new ArrayList<>();
		
		btinsertbrand = new Button("Insert Brand");
		btupdatebrand = new Button("Update Brand");
		btdeletebrand = new Button("Delete Brand");
		
		tfnameinput = new TextField("Brand Name");
		lbbrand = new Label("Brand Name: ");
		
		
		bpmanage.setPadding(new Insets(10, 10, 0, 10));
		sc= new Scene(bpmanage, 400, 500);
		gpmanage.add(lbbrand, 0, 0);
		gpmanage.add(tfnameinput, 1, 0);

		gpmanage.setVgap(5);
		gpmanage.setHgap(5);
		
		hbutton = new HBox(10);
		hbutton.getChildren().addAll(btinsertbrand,btupdatebrand, btdeletebrand);
		gpmanage2.add(hbutton, 0, 0);
		gpmanage2.setAlignment(Pos.CENTER);
		gpmanage2.setPadding(new Insets(10, 0, 20, 0));
//		bpmanage.setCenter(hbutton);
//		gpmanage.add(hbutton, 0, 1);
		gpmanage.setAlignment(Pos.CENTER_LEFT);
		gpmanage.setPadding(new Insets(10, 0, 0, 0));
		
		
		bpmanage.setCenter(gpmanage);
		bpmanage.setBottom(gpmanage2);
		
		window = new Window("Manage Brand");
		window.getRightIcons().add(new CloseIcon(window));
		window.getContentPane().getChildren().add(bpmanage);
	}

	public void setEvent() {
		btinsertbrand.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				DBConnect dbConnect = DBConnect.getInstance();
				dbConnect.execute(String.format("INSERT INTO `brand` (`BrandID`, `BrandName`) VALUES (NULL, '%s');", tfnameinput.getText()));
				
				refreshTable();
			}
			
		});
		
		branddetail.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				TableSelectionModel<Brand> selectedBrand = branddetail.getSelectionModel();
				selectedBrand.setSelectionMode(SelectionMode.SINGLE);
				
				Brand brand = selectedBrand.getSelectedItem();
				
				if (brand != null){
					tfnameinput.setText(brand.getBrandName());
					BrandID = brand.getBrandID();
				}
			}
		});
		
		btupdatebrand.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				DBConnect dbConnect = DBConnect.getInstance();
				
				PreparedStatement ps = dbConnect.prepareStatement("update brand set BrandName = ? where BrandID = ?");
				
				try {
					ps.setString(1, tfnameinput.getText());
					ps.setInt(2, BrandID);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				refreshTable();
			}
		});
		
		btdeletebrand.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				DBConnect dbConnect = DBConnect.getInstance();
				
				PreparedStatement ps = dbConnect.prepareStatement("delete from brand where BrandID = ?");
				
				try {
					ps.setInt(1, BrandID);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refreshTable();
			}
			
		});
		
	}
	
	public Window getWindow() {
		init();
		table();
		refreshTable();
		setEvent();
		return window;
	}
}


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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;
import model.Brand;
import model.Watch;

public class ManageProduct{

	public static ManageProduct ManageProduct;
	
	Scene scene;
	BorderPane bp;
	GridPane gp;
	FlowPane fp;
	TableView<Watch> watchTable;
	ArrayList<Watch> watchList;
	Label watchNameLbl;
	TextField watchNameTF;
	Label watchPriceLbl;
	TextField watchPriceTF;
	Label watchStockLbl;
	Spinner<Integer> watchStockSp;
	Label watchBrandLbl;
	ComboBox<String> watchBrandCB;
	Button insertBtn;
	Button updateBtn;
	Button deleteBtn;
	
	DBConnect dbConnect = DBConnect.getInstance();
	
	Window window;
	
	int WatchID; 
	
	public static ManageProduct getInstance() {
		if (ManageProduct == null) {
			ManageProduct = new ManageProduct();
		}
		return ManageProduct;
	}
	
	public void init() {
		gp = new GridPane();
		bp = new BorderPane();
		fp = new FlowPane();
		
		watchTable = new TableView<Watch>();
		watchList = new ArrayList<>();

		watchNameLbl = new Label("Watch Name: ");
		watchNameTF = new TextField();
		watchNameTF.setPromptText("Name");
		
		watchPriceLbl = new Label("Watch Price: ");
		watchPriceTF = new TextField();
		watchPriceTF.setPromptText("Price");
		
		watchStockLbl = new Label("Watch Stock: ");
		watchStockSp = new Spinner<Integer>(0, 100, 0);
		
		watchBrandLbl = new Label("Watch Brand: ");
		watchBrandCB = new ComboBox<>();
		watchBrandCB.getItems().add("Choose One");
		watchBrandCB.getSelectionModel().selectFirst();
		
		insertBtn = new Button("Insert Watch");
		updateBtn = new Button("Update Watch");
		deleteBtn = new Button("Delete Watch");
		
		
		gp.add(watchNameLbl, 0, 0);
		gp.add(watchNameTF, 1, 0);
		gp.add(watchPriceLbl, 2, 0);
		gp.add(watchPriceTF, 3, 0);
		gp.add(watchStockLbl, 0, 1);
		gp.add(watchStockSp, 1, 1);
		gp.add(watchBrandLbl, 2, 1);
		gp.add(watchBrandCB, 3, 1);
		
		gp.setVgap(10);
		gp.setHgap(10);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setPadding(new Insets(20, 10, 0, 10));
		
		fp.getChildren().addAll(insertBtn, updateBtn, deleteBtn);
		fp.setAlignment(Pos.TOP_CENTER);
		fp.setHgap(30);
		fp.setPadding(new Insets(0, 0, 30, 0));
		
		bp.setCenter(gp);
		bp.setBottom(fp);
		
//		scene = new Scene(bp, 700, 550);
		
		window = new Window("Manage Product");
		window.getRightIcons().add(new CloseIcon(window));
		window.getContentPane().getChildren().add(bp);
	}
	
	@SuppressWarnings("unchecked")
	public void table() {
		TableColumn<Watch, Integer> watchID = new TableColumn<Watch, Integer>("Watch ID");
		watchID.setMinWidth(40);
		TableColumn<Watch, String> watchName = new TableColumn<Watch, String>("Watch Name");
		watchName.setMinWidth(300);
		TableColumn<Watch, Integer> watchBrand = new TableColumn<Watch, Integer>("Brand ID");
		watchBrand.setMinWidth(110);
		TableColumn<Watch, Integer> watchPrice = new TableColumn<Watch, Integer>("Watch Price");
		watchPrice.setMinWidth(110);
		TableColumn<Watch, Integer> watchStock = new TableColumn<Watch, Integer>("Watch Stock");
		watchStock.setMinWidth(110);
		
		watchID.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchID"));
		watchName.setCellValueFactory(new PropertyValueFactory<Watch, String>("WatchName"));
		watchBrand.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("BrandID"));
		watchPrice.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchPrice"));
		watchStock.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchStock"));
		
		watchTable.getColumns().addAll(watchID, watchName, watchBrand, watchPrice, watchStock);
		
		bp.setTop(watchTable);
	}
	
	public void refreshTable() {
		watchList.clear();
		getWatch();
		ObservableList<Watch> watchObs = FXCollections.observableArrayList(watchList);
		watchTable.setItems(watchObs);
	}
	
//	public void getWatch(){
////		getBrand();
//		
//		DBConnect dbConnect = DBConnect.getInstance();
//		ResultSet rs = null;
//		rs = dbConnect.executeQuery("SELECT * FROM `watch`");
//		
//		try {
//			while(rs.next()) {
//				int WatchID = rs.getInt("WatchID");
//				String WatchName = rs.getString("WatchName");
//				int WatchBrand = rs.getInt("BrandID");
//				int WatchPrice = rs.getInt("WatchPrice");
//				int WatchStock = rs.getInt("WatchStock");
//				
//				watchList.add(new Watch(WatchID, WatchName, WatchBrand, WatchPrice, WatchStock));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void getWatch() {
		
		ResultSet rs = null;
		rs = dbConnect.executeQuery("SELECT * FROM `watch`");
		
		try {
			while(rs.next()) {
				int watchID = rs.getInt("WatchID");
				String watchName = rs.getString("WatchName");
				int brandID = rs.getInt("BrandID");
				int watchPrice = rs.getInt("WatchPrice");
				int watchStock = rs.getInt("WatchStock");
				
				Watch watch = new Watch(watchID, watchName, brandID, watchPrice, watchStock);
				watchList.add(watch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEvent() {
		watchTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				TableSelectionModel<Watch> selectedWatch = watchTable.getSelectionModel();
				selectedWatch.setSelectionMode(SelectionMode.SINGLE);
				
				Watch watch = selectedWatch.getSelectedItem();
				
				if (watch != null){
					watchNameTF.setText(watch.getWatchName());
					watchPriceTF.setText(String.valueOf(watch.getWatchPrice()));
					watchStockSp.setPromptText(String.valueOf(watch.getWatchStock()));
					
					WatchID = watch.getWatchID();
//					watchBrandCB.setPromptText(String.valueOf(watch.getBrandID()));
//					int brandID = watch.getWatchID();
					
//					for(int i = 0; i<watchList.size(); i++) {
//						if(watchList.get(i).getBrandID() == brandID) {
//							watchBrandCB.getSelectionModel().select(i+1);
//						}
//					}
				}
			}
		});
		
		deleteBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				
				PreparedStatement ps = dbConnect.prepareStatement("delete from watch where WatchID = ?");
				
				try {
					ps.setInt(1, WatchID);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				refreshTable();
			}
			
		});
		
		updateBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				DBConnect dbConnect = DBConnect.getInstance();
				
				PreparedStatement ps = dbConnect.prepareStatement("update watch set WatchName = ? where WatchID = ?");
				
				try {
					ps.setString(1, watchNameTF.getText());
					ps.setInt(2,  WatchID);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				refreshTable();
			}
		});
		
		insertBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				DBConnect dbConnect = DBConnect.getInstance();
				dbConnect.execute(String.format("INSERT INTO `watch` (`WatchID`, `BrandID`, `WatchName`, `WatchPrice`, `WatchStock`) VALUES (NULL, '%d', '%s', '%s', '%s');", 2, watchNameTF.getText(), watchPriceTF.getText(), watchStockSp.getValue()));
				
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

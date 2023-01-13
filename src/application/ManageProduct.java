package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Brand;

public class ManageProduct extends Application{

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
	
	public void init() {
		gp = new GridPane();
		bp = new BorderPane();
		fp = new FlowPane();

		watchNameLbl = new Label("Watch Name: ");
		watchNameTF = new TextField();
		watchNameTF.setPromptText("Name");
		
		watchPriceLbl = new Label("Watch Price: ");
		watchPriceTF = new TextField();
		watchPriceTF.setPromptText("Price");
		
		watchStockLbl = new Label("Watch Stock: ");
		watchStockSp = new Spinner<Integer>();
		
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
		
		scene = new Scene(bp, 700, 550);
	}
	
	@SuppressWarnings("unchecked")
	public void table() {
		watchTable = new TableView<Watch>();
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
	
	public void getWatch(){
//		getBrand();
		
		DBConnect dbConnect = DBConnect.getInstance();
		ResultSet rs = null;
		rs = dbConnect.executeQuery("SELECT * FROM `watch`");
		
		try {
			while(rs.next()) {
				int WatchID = rs.getInt("WatchID");
				int WatchBrand = rs.getInt("BrandID");
				String WatchName = rs.getString("WatchName");
				int WatchPrice = rs.getInt("WatchPrice");
				int WatchStock = rs.getInt("WatchStock");
				
				watchList.add(new Watch(WatchID, BrandID, WatchName, WatchPrice, WatchStock));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void getBrand() {
//		brandList = new ArrayList<>();
//		
//		DBConnect dbConnect = DBConnect.getInstance();
//		ResultSet rs = null;
//		rs = dbConnect.executeQuery("SELECT * FROM `brand`");
//		
//		try {
//			while(rs.next()) {
//				int BrandID = rs.getInt("BrandID");
//				String BrandName = rs.getString("BrandName");
//				
//				Brand brand = new Brand(BrandID, BrandName);
//				brandList.add(brand);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		table();
		refreshTable();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

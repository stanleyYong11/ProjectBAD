package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.Refreshable;

import connect.DBConnect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Watch;

public class BuyProductForms extends Application{
	
	Scene scene;
	BorderPane bp;
	GridPane gp;
	
	BorderPane bp2;
	GridPane gp2;
	
	TableView<Watch> watchTable;
	ArrayList<Watch> watchList;
	
	Label select;
	Label selectValue;
	
	Label qty;
	Spinner<Integer> qtySP;
	Button addBtn;
	
	public void init() {
		bp = new BorderPane();
		gp = new GridPane();
		
		bp2 = new BorderPane();
		gp2 = new GridPane();
		
		watchTable = new TableView<>();
		watchTable.setMaxHeight(250);
		watchList = new ArrayList<>();
		
		select = new Label("Selected Watch: ");
		selectValue = new Label("None");
		
		qty = new Label("Quantity: ");
		qtySP = new Spinner<>();
		addBtn = new Button("Add Watch To Cart");
		
		scene = new Scene(bp, 1000, 700);
	}
	
	public void setLayout() {
		gp.add(select, 0, 0);
		gp.add(selectValue, 1, 0);
		gp.setAlignment(Pos.TOP_LEFT);
		gp.setPadding(new Insets(10, 10, 10, 10));
		
		gp2.add(qty, 1, 0);
		gp2.add(qtySP, 1, 1);
		gp2.add(addBtn, 1, 2);
		gp2.setAlignment(Pos.CENTER);
		
		bp.setTop(watchTable);
		bp.setCenter(gp);
		bp.set(gp2);
	}
	
	@SuppressWarnings("unchecked")
	public void setTable() {
		TableColumn<Watch, Integer> watchIDColumn = new TableColumn<Watch, Integer>("Watch ID");
		TableColumn<Watch, String> watchNameColumn = new TableColumn<Watch, String>("Watch Name");
		TableColumn<Watch, String> watchBrandColumn = new TableColumn<Watch, String>("Watch Brand");
		TableColumn<Watch, Integer> watchPriceColumn = new TableColumn<Watch, Integer>("Watch Price");
		
		watchIDColumn.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchID"));
		watchNameColumn.setCellValueFactory(new PropertyValueFactory<Watch, String>("WatchName"));
		watchBrandColumn.setCellValueFactory(new PropertyValueFactory<Watch, String>("WatchBrand"));
		watchPriceColumn.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchPrice"));
		
		watchTable.getColumns().addAll(watchIDColumn, watchNameColumn, watchBrandColumn, watchPriceColumn);
	}
	
	public void refreshTable() {
		watchList.clear();
		getWatch();
		ObservableList<Watch> watchObs = FXCollections.observableArrayList(watchList);
		watchTable.setItems(watchObs);
	}
	
	public void getWatch() {
		DBConnect dbConnect = DBConnect.getInstance();
		ResultSet rs = dbConnect.executeQuery("SELECT * FROM `ujicoba`");
		
		try {
			while(rs.next()) {
				Integer watchID = rs.getInt("WatchID");
				String watchName = rs.getString("WatchName");
				String watchBrand = rs.getString("WatchBrand");
				Integer watchPrice = rs.getInt("WatchPrice");
				watchList.add(new Watch(watchID, watchName, watchBrand, watchPrice));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		setLayout();
		setTable();
		refreshTable();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
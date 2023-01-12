package application;

import javafx.application.Application;
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
	
	Label 
	selectWatchLbl, 
	quantityLbl,
	watchNameLbl;
	Button 
	addWatchToCartBtn, 
	clearCartBtn, 
	checkOutBtn;
	Spinner<Integer> 
	quantitySp;
	TableView<Watch> 
	watchTable, 
	cartTable;
	
	Scene 
	scene;
	BorderPane 
	bPanes, 
	bPanequantity;
	GridPane 
	gPane;
	FlowPane 
	bottomBtn;

	public void setTableWatch() {
		watchTable = new TableView<>();
		TableColumn<Watch, String> column1 = new TableColumn<Watch, String>("Watch ID");
		TableColumn<Watch, String> column2 = new TableColumn<Watch, String>("Watch Name");
		TableColumn<Watch, String> column3 = new TableColumn<Watch, String>("Watch Brand");
		TableColumn<Watch, Integer> column4 = new TableColumn<Watch, Integer>("Watch Price");
		TableColumn<Watch, Integer> column5 = new TableColumn<Watch, Integer>("Watch Stock");
		
		column1.setCellValueFactory(new PropertyValueFactory<Watch, String>("WatchID"));
		column2.setCellValueFactory(new PropertyValueFactory<Watch, String>("WatchName"));
		column3.setCellValueFactory(new PropertyValueFactory<Watch, String>("WatchBrand"));
		column4.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchPrice"));
		column5.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchStock"));
		
		//add ke table pakai colom
		watchTable.getColumns().addAll(column1, column2, column3, column4, column5);
		bPanes.setTop(watchTable);
	}
	
	public void setTableCart() {
		cartTable = new TableView<>();
	}
	
	public void init() {
		bPanes = new BorderPane();
		bPanequantity = new BorderPane();
		gPane = new GridPane();
		bottomBtn = new FlowPane();
		
//		watch namenya nanti ganti ke get text
		watchNameLbl = new Label("Submariner 300 Watch");
		
		selectWatchLbl = new Label("Selected Watch: " + watchNameLbl.getText());
		bPanequantity.setTop(selectWatchLbl);
		selectWatchLbl.setAlignment(Pos.TOP_LEFT);
		
		quantityLbl = new Label("Quantity: ");
		bPanequantity.setCenter(quantityLbl);
		gPane.add(quantityLbl, 0, 0);
		
		quantitySp = new Spinner<>(0, 100, 0, 1);
		bPanequantity.setCenter(quantitySp);
		gPane.add(quantitySp, 1, 0);
		
		addWatchToCartBtn = new Button("Add Watch To Cart");
		bPanequantity.setCenter(addWatchToCartBtn);
		gPane.add(addWatchToCartBtn, 2, 0);
		
		gPane.setHgap(10);
		gPane.setAlignment(Pos.CENTER);
		bPanequantity.setCenter(gPane);
		
		clearCartBtn = new Button("Clear Cart");
		bottomBtn.getChildren().add(clearCartBtn);
		
		checkOutBtn = new Button("Checkout");
		bottomBtn.getChildren().add(checkOutBtn);
		
		bottomBtn.setHgap(15);
		
		bPanes.setCenter(bPanequantity);

		bPanes.setBottom(bottomBtn);
		bottomBtn.setAlignment(Pos.BOTTOM_CENTER);
		
		scene = new Scene(bPanes, 600, 600);
	}
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		setTableWatch();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
package application;

import javafx.application.Application;
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
	
	Label quantityLbl;
	Label selectWatchLbl;
	Label watchNameLbl;
	Button addWatchToCartBtn;
	Button clearCartBtn; 
	Button checkOutBtn;
	Spinner<Integer> quantitySp;
	TableView<Watch> watchTable;
	TableView<Watch> cartTable;
	
	Scene scene;
	BorderPane bp1; 
	BorderPane bp2;
	GridPane gPane;
	FlowPane bottomBtn;

	public void setTableWatch() {
		watchTable = new TableView<>();
		watchTable.setMaxHeight(200);
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
		bp1.setTop(watchTable);
	}
	
	public void setTableCart() {
		cartTable = new TableView<>();
	}
	
	public void init() {
		bp1 = new BorderPane();
		bp2 = new BorderPane();
		gPane = new GridPane();
		bottomBtn = new FlowPane();
		
		watchNameLbl = new Label("None");
		watchNameLbl.setPadding(new Insets(10,10,10,10));
		
		selectWatchLbl = new Label("Selected Watch: " + watchNameLbl.getText());
		selectWatchLbl.setPadding(new Insets(10,10,10,10));
		bp2.setTop(selectWatchLbl);
		selectWatchLbl.setAlignment(Pos.TOP_LEFT);
		
		quantityLbl = new Label("Quantity: ");
		bp2.setCenter(quantityLbl);
		gPane.add(quantityLbl, 0, 0);
		quantityLbl.setAlignment(Pos.TOP_CENTER);
		
		quantitySp = new Spinner<>();
		bp2.setCenter(quantitySp);
		gPane.add(quantitySp, 1, 0);
		
		addWatchToCartBtn = new Button("Add Watch To Cart");
		bp2.setCenter(addWatchToCartBtn);
		gPane.add(addWatchToCartBtn, 2, 0);
		
		gPane.setHgap(10);
		gPane.setAlignment(Pos.CENTER);
		bp2.setCenter(gPane);
		
		clearCartBtn = new Button("Clear Cart");
		bottomBtn.getChildren().add(clearCartBtn);
		
		checkOutBtn = new Button("Checkout");
		bottomBtn.getChildren().add(checkOutBtn);
		
		bottomBtn.setHgap(15);
		
		bp1.setCenter(bp2);

		bp1.setBottom(bottomBtn);
		bottomBtn.setAlignment(Pos.BOTTOM_CENTER);
		
		scene = new Scene(bp1, 600, 600);
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
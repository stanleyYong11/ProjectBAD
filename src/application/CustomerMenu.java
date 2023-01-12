package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CustomerMenu extends Application{

	Label userlb;
	Label transactionlb;
	
	MenuBar barcust;
	Menu menucust;
	Menu menutransaction;
	MenuItem itemcust;
	MenuItem itemtransaction;
	MenuItem itemtransaction1;
	
	GridPane gpcust;
	BorderPane bpcust;
	
	Scene sc;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void init() {
		gpcust = new GridPane();
		sc = new Scene(gpcust, 1000,900);
		
		barcust = new MenuBar();
		menucust = new Menu("User");
		itemcust = new MenuItem("Logout");
		
		menutransaction = new Menu("Transaction");
		itemtransaction = new MenuItem("Buy Watch");
		itemtransaction1 = new MenuItem("My Transaction History");
		
		barcust.getMenus().add(menucust);
		menucust.getItems().add(itemcust);
		
		barcust.getMenus().add(menutransaction);
		menutransaction.getItems().add(itemtransaction);
		menutransaction.getItems().add(itemtransaction1);
		
		gpcust.add(barcust, 0, 0);
		bpcust = new BorderPane();
		bpcust.setTop(barcust);
		
		sc = new Scene(bpcust, 900, 1000);
	}
	
	

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init();

		primaryStage.setScene(sc);
		primaryStage.setTitle("Main Page");
		primaryStage.show();
	}

}

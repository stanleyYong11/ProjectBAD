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

public class Admin extends Application{

	Label userlb;
	Label transactionlb;
	
	MenuBar baradmin;
	Menu menuadmin;
	Menu menumanagementaction;
	MenuItem itemadmin;
	MenuItem itemmanagement;
	MenuItem itemmanagement1;
	
	GridPane gpadmin;
	BorderPane bpadmin;
	
	Scene sc;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void init() {
		gpadmin = new GridPane();
		
		baradmin = new MenuBar();
		menuadmin = new Menu("User");
		itemadmin = new MenuItem("Logout");
		
		menumanagementaction = new Menu("Management");
		itemmanagement = new MenuItem("Manage Product");
		itemmanagement1 = new MenuItem("Manage Brand");
		
		baradmin.getMenus().add(menuadmin);
		menuadmin.getItems().add(itemadmin);
		
		baradmin.getMenus().add(menumanagementaction);
		menumanagementaction.getItems().add(itemmanagement);
		menumanagementaction.getItems().add(itemmanagement1);
		
		gpadmin.add(baradmin, 0, 0);
		bpadmin = new BorderPane();
		bpadmin.setTop(baradmin);
		
		sc = new Scene(bpadmin, 1000, 700);
		
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
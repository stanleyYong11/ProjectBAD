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
import main.Main;

public class Admin{

	private static Admin AdminPage;
	
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
	
	public static Admin getInstance() {
		if (AdminPage == null) {
			AdminPage = new Admin();
		}
		return AdminPage;
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
	
	public void adminPage() {
		init();
		
		itemadmin.setOnAction((event) -> {
			Login lg = Login.getInstance();
			lg.loginPage();
		});
		
		itemmanagement1.setOnAction((event) -> {
			ManageBrand mb = ManageBrand.getInstance();
			bpadmin.setCenter(mb.getWindow());
		});
		
		itemmanagement.setOnAction((event) -> {
			ManageProduct mp = ManageProduct.getInstance();
			bpadmin.setCenter(mp.getWindow());
		});
		
		Main.changeScene(sc, "Admin");
	}

}
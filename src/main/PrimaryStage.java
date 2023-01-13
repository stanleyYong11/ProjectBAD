package main;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryStage {
	private Stage primaryStage;

	private static PrimaryStage instance;

	public static PrimaryStage getInstance() {
		if (instance == null) {
			instance = new PrimaryStage();
		}
		return instance;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public static void setInstance(PrimaryStage instance) {
		PrimaryStage.instance = instance;
	}

	public void setTitle(String title) {
		this.primaryStage.setTitle(title);
	}
	
	public void setScene(Scene sc) {
		this.primaryStage.setScene(sc);
	}
	
	public void show() {
		this.primaryStage.show();
	}
}

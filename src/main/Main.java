package main;

import application.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	public static void changeScene(Scene sc, String title) {
		PrimaryStage mainStage = PrimaryStage.getInstance();
		mainStage.setTitle(title);
		mainStage.setScene(sc);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		PrimaryStage myStage = PrimaryStage.getInstance();
		myStage.setPrimaryStage(primaryStage);
		
		Login lg = Login.getInstance();
		lg.loginPage();
		
		myStage.show();
	}
}

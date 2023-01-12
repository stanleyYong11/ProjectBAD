package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.Window;

public class Main extends Application {
Label titleloginLBL;
Label emailLBL;
Label passwordLBL;
Button loginBtn;
Button registerBtn;
BorderPane bp;
BorderPane luarBP;
GridPane gp;
Scene scene;
VBox MenuLogBtn;
TextField emailTF;
PasswordField passPF;
Window window;

	public static void main(String[]args) {
		launch(args);
	}
	
	public void init() {
		gp = new GridPane();
		bp = new BorderPane();
		window = new Window("Main");
		
		luarBP = new BorderPane();
		titleloginLBL = new Label("Watches Dealer Login");
		emailLBL = new Label("Email :");
		passwordLBL = new Label("Password :");
		
		emailTF = new TextField();
		emailTF.setPromptText("Email Address");
		
		loginBtn = new Button("Login");
		registerBtn = new Button("Register Instead");
		passPF = new PasswordField();
		
		emailTF.setPromptText("Email Address");
		passPF.setPromptText("Password");
		
		emailLBL.setMinWidth(250);
		passwordLBL.setMinWidth(250);
		
		emailTF.setMinWidth(250);
		passPF.setMinWidth(250);
		
		loginBtn.setMinWidth(250);
		registerBtn.setMinWidth(250);
		
		titleloginLBL.setAlignment(Pos.CENTER);
		MenuLogBtn = new VBox(10);
		MenuLogBtn.getChildren().addAll(loginBtn,registerBtn);
		
		gp.setVgap(20);
		gp.add(titleloginLBL, 1, 0);
		gp.add(emailLBL, 1, 1);
		gp.add(emailTF, 1, 2);
		gp.add(passwordLBL, 1, 3);
		gp.add(passPF, 1, 4);
		gp.add(MenuLogBtn, 1, 5);
		bp.setTop(titleloginLBL);
		bp.setCenter(gp);
		luarBP.setCenter(bp);
		BorderPane.setAlignment(bp, Pos.CENTER);
		BorderPane.setAlignment(luarBP, Pos.CENTER);
		BorderPane.setAlignment(titleloginLBL, Pos.CENTER);
		titleloginLBL.setMinWidth(150);
		bp.setPadding(new Insets(50,50,50,50));
		luarBP.setPadding(new Insets(50, 50, 75, 75));
		
		window.setPrefSize(300, 300);
		window.getContentPane().getChildren().add(bp);
		
		scene = new Scene(window,500,500);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		loginBtn.setOnAction((event) -> {
			if(emailTF.getText().equals("")) {
			Alert warningEmail = new Alert(AlertType.ERROR);
				warningEmail.setHeaderText("Error");
				warningEmail.setContentText("Email harus diisi");
				warningEmail.show();
			
			} else if(passPF.getText().equals("")){
			Alert warningPassword = new Alert(AlertType.ERROR);
				warningPassword.setHeaderText("Error");
				warningPassword.setContentText("Password harus diisi");
				warningPassword.show();
			}
		}
		
				);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
}

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {

	Scene 
	scene;
	BorderPane
	bp,
	titleLogBp;
	VBox
	pageVB;
	Label
	titleLogLbl,
	emailLbl,
	passLbl;
	TextField
	emailTF;
	PasswordField
	passPF;
	Button
	logBtn,
	registBtn;
	Background 
	backg,
	backg1,
	backg2;
	BackgroundFill
	backFill,
	backFill1,
	backFill2;
	
	public static void main(String[]args) {
		launch(args);
	}
	public void init() {
		bp = new BorderPane();
		titleLogBp = new BorderPane();
		titleLogLbl = new Label("Watches Dealer Login");
		emailLbl = new Label("Email:");
		passLbl = new Label("Password");
		emailTF = new TextField();
		passPF = new PasswordField();
		logBtn = new Button("Login");
		registBtn = new Button("Register Instead");
		backg = new Background(backFill);
		backg1 = new Background(backFill1);
		backg2 = new Background(backFill2);
		backFill1 = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
		backFill2 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	}
	private void display() {
		pageVB = new VBox(20);
		scene = new Scene(bp,600,600);
	}
	private void position() {
		titleLogBp.setTop(titleLogLbl);
		pageVB.getChildren().addAll
		(titleLogBp,emailLbl,emailTF,passLbl,passPF,logBtn,registBtn);
		bp.setCenter(pageVB);
		
		titleLogLbl.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		logBtn.setBackground(backg1);
		logBtn.setTextFill(Color.WHITE);
		registBtn.setBackground(backg1);
		registBtn.setTextFill(Color.WHITE);
		emailTF.setPromptText("Email Address");
		passPF.setPromptText("Password");
		
		emailLbl.setMinWidth(300);
		emailLbl.setMaxWidth(300);
		
		passLbl.setMinWidth(300);
		passLbl.setMaxWidth(300);
		
		emailTF.setMinWidth(300);
		emailTF.setMaxWidth(300);
		
		passPF.setMinWidth(300);
		passPF.setMaxWidth(300);
		
		logBtn.setMinWidth(300);
		logBtn.setMaxWidth(300);
		
		registBtn.setMinWidth(300);
		registBtn.setMaxWidth(300);
		
		 pageVB.setMinWidth(500);
		  pageVB.setMaxWidth(500);
		  
		  pageVB.setMinHeight(400);
		  pageVB.setMaxHeight(400);
		  
		  pageVB.setStyle("-fx-background-color: white;");
		  BackgroundFill backfills = new BackgroundFill(Color.PALETURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
			Background backgrnd = new Background(backfills);
			bp.setBackground(backgrnd);
		  
		  pageVB.setAlignment(Pos.CENTER);
			BorderPane.setAlignment(titleLogLbl, Pos.CENTER);
	}
	public void start(Stage primaryStage) throws Exception {
		init();
		display();
		position();
		logBtn.setOnAction((event) -> {
			if(emailTF.getText().equals("")) {
			Alert warningEmail = new Alert(AlertType.ERROR);
				warningEmail.setHeaderText("Error");
				warningEmail.setContentText("Email must be filled");
				warningEmail.show();
			
			} else if(passPF.getText().equals("")){
			Alert warningPassword = new Alert(AlertType.ERROR);
				warningPassword.setHeaderText("Error");
				warningPassword.setContentText("Password must be filled");
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
	


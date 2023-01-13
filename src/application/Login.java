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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.Main;


public class Login{

	private static Login loginPage;
	
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
	Background 
	backg,
	backg1,
	backg2;
	BackgroundFill
	backFill,
	backFill1,
	backFill2;
	
	public static Login getInstance() {
		if (loginPage == null) {
			loginPage = new Login();
		}
		return loginPage;
	}
	
	public void init() {
		backg = new Background(backFill);
		backg1 = new Background(backFill1);
		backg2 = new Background(backFill2);
		backFill1 = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
		backFill2 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		
		gp = new GridPane();
		bp = new BorderPane();
		luarBP = new BorderPane();
		titleloginLBL = new Label("Watches Dealer Login");
		titleloginLBL.setFont(Font.font("Verdana",FontWeight.BOLD,14));
		emailLBL = new Label("Email :");
		passwordLBL = new Label("Password :");
		
		emailTF = new TextField();
		emailTF.setPromptText("Email Address");
		
		loginBtn = new Button("Login");
		loginBtn.setBackground(backg1);
		loginBtn.setTextFill(Color.WHITE);
		registerBtn = new Button("Register Instead");
		registerBtn.setBackground(backg1);
		registerBtn.setTextFill(Color.WHITE);
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
		scene = new Scene(luarBP,500,500);
		
		BackgroundFill backfills = new BackgroundFill(Color.PALETURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
		Background backgrnd = new Background(backfills);
		bp.setBackground(backgrnd);
	}
//	private void display() {
//		pageVB = new VBox(20);
//		scene = new Scene(bp,600,600);
//	}
//	private void position() {
//		
//		titleLogLbl.setFont(Font.font("Verdana",FontWeight.BOLD,20));
//		logBtn.setBackground(backg1);
//		logBtn.setTextFill(Color.WHITE);
//		registBtn.setBackground(backg1);
//		registBtn.setTextFill(Color.WHITE);
//		emailTF.setPromptText("Email Address");
//		passPF.setPromptText("Password");
//		
//		emailLbl.setMinWidth(300);
//		emailLbl.setMaxWidth(300);
//		
//		passLbl.setMinWidth(300);
//		passLbl.setMaxWidth(300);
//		
//		emailTF.setMinWidth(300);
//		emailTF.setMaxWidth(300);
//		
//		passPF.setMinWidth(300);
//		passPF.setMaxWidth(300);
//		
//		logBtn.setMinWidth(300);
//		logBtn.setMaxWidth(300);
//		
//		registBtn.setMinWidth(300);
//		registBtn.setMaxWidth(300);
//		
//		titleLogBp.setTop(titleLogLbl);
//		pageVB.getChildren().addAll
//		(titleLogLbl,emailLbl,emailTF,passLbl,passPF,logBtn,registBtn);
//		bp.setCenter(pageVB);
//		
//		pageVB.setMinWidth(500);
//		pageVB.setMaxWidth(500);
//		  
//		pageVB.setMinHeight(400);
//		pageVB.setMaxHeight(400);
//		  
//		pageVB.setStyle("-fx-background-color: white;");
//		BackgroundFill backfills = new BackgroundFill(Color.PALETURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
//		Background backgrnd = new Background(backfills);
//		bp.setBackground(backgrnd);
//		  
//		pageVB.setAlignment(Pos.CENTER);
//		BorderPane.setAlignment(titleLogLbl, Pos.CENTER);
//	}

	
	public void loginPage() {
		init();
//		display();
//		position();
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
				
			} else if (emailTF.equals("a@b.com")){
				Admin ad = Admin.getInstance();
				ad.adminPage();
				
			} else if (emailTF.equals("gavrey@gmail.com")){
				CustomerMenu cm = CustomerMenu.getInstance();
				cm.customerMenuPage();
			}
		});
		
		registerBtn.setOnAction((event) -> {
			Register rg = Register.getInstance();
			rg.registerPage();
		});

		Main.changeScene(scene, "Login");
		
	}
}



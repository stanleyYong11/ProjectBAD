package application;

import javafx.application.Application;
import javafx.geometry.HPos;
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
	
	Scene scene;
	BorderPane bp;
	GridPane gp;
	
	Label title;
	Label emailLbl;
	TextField emailTF;
	Label passwordLbl;
	PasswordField passwordPF;
	Button loginBtn;
	Button registerBtn;
	
	BackgroundFill bgBorderColor;
	BackgroundFill bgButtonColor;
	BackgroundFill bgKotakColor;
	
	
	Background bgBorderSet;
	Background bgButtonSet;
	Background bgKotakSet;
	
	public static Login getInstance() {
		if (loginPage == null) {
			loginPage = new Login();
		}
		return loginPage;
	}
	
	public void init() {
		bp = new BorderPane();
		gp = new GridPane();
		
		bgBorderColor = new BackgroundFill(Color.PALETURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
		bgBorderSet = new Background(bgBorderColor);
		
		bgButtonColor = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
		bgButtonSet = new Background(bgButtonColor);
		
		bgKotakColor = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		bgKotakSet = new Background(bgKotakColor);
		
		gp.setBackground(bgKotakSet);
		BorderPane.setMargin(gp, new Insets(80));
		
		title = new Label("Watches Dealer Login");
		
		emailLbl = new Label("Emal: ");
		emailTF = new TextField();
		emailTF.setPromptText("Email Address");
		
		passwordLbl = new Label("Password: ");
		passwordPF = new PasswordField();
		passwordPF.setPromptText("Password");
		
		loginBtn = new Button("Login");
		loginBtn.setBackground(bgButtonSet);
		loginBtn.setTextFill(Color.WHITE);
		
		registerBtn = new Button("Register Instead");
		registerBtn.setBackground(bgButtonSet);
		registerBtn.setTextFill(Color.WHITE);
		
		scene = new Scene(bp, 500, 500);
	}
	private void setLayout() {
		gp.add(title, 0, 0);
		gp.add(emailLbl, 0, 1);
		gp.add(emailTF, 0, 2);
		gp.add(passwordLbl, 0, 3);
		gp.add(passwordPF, 0, 4);
		gp.add(loginBtn, 0, 5);
		gp.add(registerBtn, 0, 6);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(20);
		
		title.setFont(Font.font("Verdana",FontWeight.BOLD,15));
		GridPane.setHalignment(title, HPos.CENTER);
		loginBtn.setMinWidth(230);
		registerBtn.setMinWidth(230);
		
		bp.setCenter(gp);
		bp.setBackground(bgBorderSet);
	}

	
	public void loginPage() {
		init();
		setLayout();
		loginBtn.setOnAction((event) -> {
			if(emailTF.getText().equals("")) {
			Alert warningEmail = new Alert(AlertType.ERROR);
				warningEmail.setHeaderText("Error");
				warningEmail.setContentText("Email harus diisi");
				warningEmail.show();
			
			} else if(passwordPF.getText().equals("")){
			Alert warningPassword = new Alert(AlertType.ERROR);
				warningPassword.setHeaderText("Error");
				warningPassword.setContentText("Password harus diisi");
				warningPassword.show();
				
			} else if (emailTF.getText().equals("gavrey@gmail.com")) {
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





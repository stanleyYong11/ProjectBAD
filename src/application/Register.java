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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Register extends Application {
Label regLBL;
Label nameLBL;
Label genderLBL;
Label emailLBL;
Label passwordLBL;
Label coPasswordLBL;
Label BackloginLBL;

ToggleGroup grGender;

TextField nameTF;
TextField emailTF;

RadioButton maleRB;
RadioButton femaleRB;

PasswordField passPF;
PasswordField coPassPF;

Button regBtn;
Button backLoginBtn;

BorderPane regBPane;
BorderPane luarBPane;

GridPane gp;
Scene scenes;

VBox YaregBtn;
HBox genderRadBtn;

	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void init() {
		regLBL = new Label("Register");
		nameLBL = new Label("Name: ");
		genderLBL = new Label("Gender : ");
		emailLBL = new Label("Email :");
		passwordLBL = new Label("Password :");
		coPasswordLBL = new Label("Confirm Password :");
		
		maleRB = new RadioButton("Male");
		femaleRB = new RadioButton("Female");
		grGender = new ToggleGroup();
		maleRB.setToggleGroup(grGender);
		femaleRB.setToggleGroup(grGender);
		
		genderRadBtn = new HBox(10);
		genderRadBtn.getChildren().add(maleRB);
		genderRadBtn.getChildren().add(femaleRB);

		nameTF = new TextField();
		nameTF.setPromptText("Name");
		emailTF = new TextField();
		emailTF.setPromptText("Email Address");	
				
		passPF = new PasswordField();
		passPF.setPromptText("Password");
		coPassPF = new PasswordField();
		coPassPF.setPromptText("Confirm Password");

		regBtn = new Button("Register");
		YaregBtn = new VBox(15);
		backLoginBtn = new Button("Back to Login");
		regBtn.setMinWidth(250);
		backLoginBtn.setMinWidth(250);

		YaregBtn.getChildren().add(regBtn);
		YaregBtn.getChildren().add(backLoginBtn);

		gp = new GridPane();
		gp.add(nameLBL, 0, 1);
		gp.add(nameTF, 0, 2);
		gp.add(genderLBL, 0, 3);
		gp.add(genderRadBtn, 0, 4);
		gp.add(emailLBL, 0, 5);
		gp.add(emailTF, 0, 6);
		gp.add(passwordLBL, 0, 7);
		gp.add(passPF, 0, 8);
		gp.add(coPasswordLBL, 0, 9);
		gp.add(coPassPF, 0, 10);
		gp.add(YaregBtn, 0, 11);
		gp.setVgap(20);
		regBPane = new BorderPane();
		regBPane.setTop(regLBL);
		regBPane.setCenter(gp);
		BorderPane.setAlignment(regLBL, Pos.BOTTOM_CENTER);
		regLBL.setAlignment(Pos.BOTTOM_CENTER);
		gp.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(gp, Pos.CENTER);
		regBPane.setPadding(new Insets(100, 50, 100, 50));
		scenes = new Scene(regBPane, 600, 700);

	}
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		regBtn.setOnAction((event) -> {
		String pass = passPF.getText();
			System.out.println(pass);
			int words = emailTF.getText().length();
			int count = 0;
		if(words !=0) {
		for(int i = 0; i < words; i++){
			if(emailTF.getText().charAt(i) == '@') {
				count++;
	};
		}
	}
		////Name length must be between 5 - 40 characters.
		if (nameTF.getText().length() < 5 || nameTF.getText().length() > 40) {
		Alert nameFill = new Alert(AlertType.ERROR);
			nameFill.setHeaderText("Name Error!");
			nameFill.setContentText("Your name must be between 5-40 Characters!");
			nameFill.show();
	}
		//		Gender must be chosen, either “Male” or “Female”.
		else if(!maleRB.isSelected() && !femaleRB.isSelected()) {
		Alert selectgender = new Alert(AlertType.ERROR);
			selectgender.setHeaderText("Gender Error!");
			selectgender.setContentText("Choose a gender");
			selectgender.show();
		}
		//Character ‘@’ must not be next to ‘.’.
		else if(emailTF.getText().contains("@.")) {
		Alert namaemail = new Alert(AlertType.ERROR);
			namaemail.setHeaderText("Email Error!");
			namaemail.setContentText("Character '@' must not be next to" );
			namaemail.show();
		}
		//Must not starts and ends with ‘@’ nor ‘.’.
		else if (emailTF.getText().startsWith("@") || emailTF.getText().endsWith("@")) {
		Alert namaemail = new Alert(AlertType.ERROR);
			namaemail.setHeaderText("Email Error!");
			namaemail.setContentText("Email must not starts and ends with '@'");
			namaemail.show();
		}else if (emailTF.getText().startsWith(".") || emailTF.getText().endsWith(".")) {
		Alert namaemail = new Alert(AlertType.ERROR);
			namaemail.setHeaderText("Email Error!");
			namaemail.setContentText("Email must not starts and ends with '.'");
			namaemail.show();
		}
//		Must contain exactly one ‘@’.
		else if(count != 1) {
		Alert namaemail = new Alert(AlertType.ERROR);
			namaemail.setHeaderText("Email Error!");
			namaemail.setContentText("Email must contain exactly 1 '@'");
			namaemail.show(); 
		}
//Must contain exactly one ‘.’ after ‘@’ for separating [provider] and “com” BELOM
		
		//Must ends with ‘.com’
		else if (!emailTF.getText().endsWith(".com")) {
		Alert com = new Alert(AlertType.ERROR);
			com.setHeaderText("Email Error!");
			com.setContentText("Email must end with '.com'!");
			com.show();
		
		}else if(passPF.getText().length() < 6 || passPF.getText().length() > 20 ) {
			Alert passcount = new Alert(AlertType.ERROR);
			passcount.setHeaderText("Password Error!");
			passcount.setContentText("Your password's Length must be between 6 - 20 Characters!");
			passcount.show();
		}else if(!coPassPF.getText().equals(coPassPF.getText())) {
			Alert passMiss = new Alert(AlertType.ERROR);
			passMiss.setHeaderText("Password Error!");
			passMiss.setContentText("The confirmation password must be same with inputed password!");
			passMiss.show();
		}
		});
			primaryStage.setScene(scenes);
			primaryStage.setTitle("Register");
			primaryStage.show();
	}
}



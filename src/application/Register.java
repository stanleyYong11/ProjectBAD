package application;

import connect.DBConnect;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.Main;

public class Register{
	
	private static Register RegisterPage;
	
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
String gender;

PasswordField passPF;
PasswordField coPassPF;

Button regBtn;
Button backLoginBtn;

BorderPane regBPane;

GridPane gp;
Scene scenes;

VBox forregBtn;
HBox genderRadBtn;
Background 
backg,
backg1,
backg2;
BackgroundFill
backFill,
backFill1,
backFill2;
	

	public static Register getInstance() {
		if (RegisterPage == null) {
			RegisterPage = new Register();
		}
		return RegisterPage;
	}

	public void init() {
		backFill1 = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
		backFill2 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		backg = new Background(backFill);
		backg1 = new Background(backFill1);
		backg2 = new Background(backFill2);
		
		regLBL = new Label("Register");
		regLBL.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
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
		regBtn.setBackground(backg1);
		regBtn.setTextFill(Color.WHITE);
		
		forregBtn = new VBox(15);
		
		backLoginBtn = new Button("Back to Login");
		backLoginBtn.setBackground(backg1);
		backLoginBtn.setTextFill(Color.WHITE);
		
		regBtn.setMinWidth(250);
		backLoginBtn.setMinWidth(250);

		forregBtn.getChildren().add(regBtn);
		forregBtn.getChildren().add(backLoginBtn);
	}
	
		public void positions() {
		gp = new GridPane();
		gp.add(regLBL, 0, 0);
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
		gp.add(regBtn, 0, 11);
		gp.add(backLoginBtn, 0, 12);
		gp.setVgap(15);
		
		regBPane = new BorderPane();
		regBPane.setCenter(gp);
		
		GridPane.setHalignment(regLBL, HPos.CENTER);
        gp.setAlignment(Pos.CENTER);
        
        BorderPane.setAlignment(gp, Pos.CENTER);
		gp.setAlignment(Pos.CENTER);
	}
		
		public void display() {	
		regBPane.setMargin(gp, new Insets(100));;
		scenes = new Scene(regBPane, 600, 800);
		
		gp.setStyle("-fx-background-color: white;");
		BackgroundFill backfills = new BackgroundFill(Color.PALETURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
		Background backgrnd = new Background(backfills);
		regBPane.setBackground(backgrnd);
	}
		
	public void registerPage() {
		init();
		positions();
		display();
		
		maleRB.setOnAction((event) -> {
			gender = maleRB.getText();
		});
		
		femaleRB.setOnAction((event) -> {
			gender = femaleRB.getText();
		});
		
		regBtn.setOnAction((event) -> {
			DBConnect dbConnect = DBConnect.getInstance();
			dbConnect.execute(String.format("INSERT INTO `user` (`UserID`, `UserName`, `UserEmail`, `UserPassword`, `UserGender`, `UserRole`) VALUES (NULL, '%s', '%s', '%s', '%s', '%s');", nameTF.getText(), emailTF.getText(), passPF.getText(), gender, "Customer"));
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
//			Must contain exactly one ‘@’.
			else if(count != 1) {
			Alert namaemail = new Alert(AlertType.ERROR);
				namaemail.setHeaderText("Email Error!");
				namaemail.setContentText("Email must contain exactly 1 '@'");
				namaemail.show(); 
			}
			
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
			}else {
				Login lg = Login.getInstance();
				lg.loginPage();
			}
			
			
			});

		backLoginBtn.setOnAction((event) -> {
			Login lg = Login.getInstance();
			lg.loginPage();
		});
		
		Main.changeScene(scenes, "Register");
	}
}

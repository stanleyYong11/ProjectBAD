package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Brand;

public class ManageBrand extends Application{
	
	Button btinsertbrand, btupdatebrand, btdeletebrand;
	Label lbbrand;
	TextField tfnameinput;
	TableView<Brand> branddetail;
	ScrollPane spbrand;
	
	HBox hbisi;
	HBox hbutton;
	VBox vbmanage;
	
	Scene sc;
	GridPane gpmanage;
	GridPane gpmanage2;
	BorderPane bpmanage;
	
	public void table() {
		branddetail = new TableView<Brand>();
		TableColumn<Brand,Integer> 	brandid = new TableColumn<Brand, Integer>("Brand ID");
		brandid.setMinWidth(100);
		brandid.setCellValueFactory(new PropertyValueFactory<Brand, Integer>("Brand ID"));
		
		
		TableColumn<Brand,String> 	brandname = new TableColumn<Brand, String>("Brand Name");
		brandname.setMinWidth(300);
		brandname.setCellValueFactory(new PropertyValueFactory<Brand, String>("Brand Name"));
		
		branddetail.getColumns().addAll(brandid, brandname);
		
		bpmanage.setTop(branddetail);
	}
	
	public void init() {
		bpmanage= new BorderPane();
		gpmanage = new GridPane();
		gpmanage2 = new GridPane();
		
		btinsertbrand = new Button("Insert Brand");
		btupdatebrand = new Button("Update Brand");
		btdeletebrand = new Button("Delete Brand");
		
		tfnameinput = new TextField("Brand Name");
		lbbrand = new Label("Brand Name: ");
		
		
		bpmanage.setPadding(new Insets(10, 10, 0, 10));
		sc= new Scene(bpmanage, 400, 500);
		gpmanage.add(lbbrand, 0, 0);
		gpmanage.add(tfnameinput, 1, 0);

		gpmanage.setVgap(5);
		gpmanage.setHgap(5);
		
		hbutton = new HBox(10);
		hbutton.getChildren().addAll(btinsertbrand,btupdatebrand, btdeletebrand);
		gpmanage2.add(hbutton, 0, 0);
		gpmanage2.setAlignment(Pos.CENTER);
		gpmanage2.setPadding(new Insets(10, 0, 20, 0));
//		bpmanage.setCenter(hbutton);
//		gpmanage.add(hbutton, 0, 1);
		gpmanage.setAlignment(Pos.CENTER_LEFT);
		gpmanage.setPadding(new Insets(10, 0, 0, 0));
		
		
		bpmanage.setCenter(gpmanage);
		bpmanage.setBottom(gpmanage2);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init();
		table();
		primaryStage.setScene(sc);
		primaryStage.setTitle("Manage Brand");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
}


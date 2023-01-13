package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.HeaderTransaction;
import model.WrapperView;

public class ViewTransactionHistory extends Application{
	
	Scene scene;
	BorderPane bpane, bpaneLabel;
	GridPane gpane;
	Label selectedTransaction, transactionName;
	TableView<HeaderTransaction> transactionHeader;
	TableView<WrapperView> transactionDetail;
	
	private void setViewHeader() {
		// TODO Auto-generated method stub
		transactionHeader = new TableView<>();
		TableColumn<HeaderTransaction, Integer> transactID = new TableColumn<HeaderTransaction, Integer>("Transaction ID");
		TableColumn<HeaderTransaction, Integer> userID = new TableColumn<HeaderTransaction, Integer>("User ID");
		TableColumn<HeaderTransaction, String> transactDate = new TableColumn<HeaderTransaction, String>("Transaction Date");
		
		transactID.setCellValueFactory(new PropertyValueFactory<HeaderTransaction, Integer>("Transaction ID"));
		userID.setCellValueFactory(new PropertyValueFactory<HeaderTransaction, Integer>("User ID"));
		transactDate.setCellValueFactory(new PropertyValueFactory<HeaderTransaction, String>("Transaction Date"));
		
		transactID.setPrefWidth(300);
		userID.setPrefWidth(300);
		transactDate.setPrefWidth(500);
		
		transactionHeader.getColumns().addAll(transactID, userID, transactDate);
		bpane.setTop(transactionHeader);
		
		transactionHeader.setPrefHeight(300);
		transactionHeader.setPrefWidth(600);
	}
	
	private void setViewDetail() {
		// TODO Auto-generated method stub
		transactionDetail = new TableView<>();
		TableColumn<WrapperView, Integer> transactID = new TableColumn<WrapperView, Integer>("Transaction ID");
		TableColumn<WrapperView, Integer> watchID = new TableColumn<WrapperView, Integer>("Watch ID");
		TableColumn<WrapperView, String> watchName = new TableColumn<WrapperView, String>("Watch Name");
		TableColumn<WrapperView, String> watchBrand = new TableColumn<WrapperView, String>("Watch Brand");
		TableColumn<WrapperView, Integer> watchPrice = new TableColumn<WrapperView, Integer>("Watch Price");
		TableColumn<WrapperView, Integer> quantity = new TableColumn<WrapperView, Integer>("Quantity");
		TableColumn<WrapperView, Integer> subTotal = new TableColumn<WrapperView, Integer>("Sub Total");
		
		transactID.setCellValueFactory(new PropertyValueFactory<WrapperView, Integer>("Transaction ID"));
		watchID.setCellValueFactory(new PropertyValueFactory<WrapperView, Integer>("User ID"));
		watchName.setCellValueFactory(new PropertyValueFactory<WrapperView, String>("Watch Name"));
		watchBrand.setCellValueFactory(new PropertyValueFactory<WrapperView, String>("Watch Brand"));
		watchPrice.setCellValueFactory(new PropertyValueFactory<WrapperView, Integer>("Watch Price"));
		quantity.setCellValueFactory(new PropertyValueFactory<WrapperView, Integer>("Quantity"));
		subTotal.setCellValueFactory(new PropertyValueFactory<WrapperView, Integer>("Sub Total"));
		
		transactID.setPrefWidth(100);
		watchID.setPrefWidth(100);
		watchName.setPrefWidth(200);
		watchBrand.setPrefWidth(200);
		watchPrice.setPrefWidth(100);
		quantity.setPrefWidth(100);
		subTotal.setPrefWidth(100);
		
		
		transactionDetail.getColumns().addAll(transactID, watchID, watchName, watchBrand, watchPrice, quantity, subTotal);
		bpane.setBottom(transactionDetail);
		
		transactionDetail.setPrefHeight(300);
		transactionDetail.setPrefWidth(600);
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		bpane = new BorderPane();
		bpaneLabel = new BorderPane();
		gpane = new GridPane();
		selectedTransaction = new Label("Selected Transaction: None");
		
		bpaneLabel.setPadding(new Insets(10, 10, 10, 10));
		
		bpaneLabel.setCenter(selectedTransaction);
		bpaneLabel.setAlignment(selectedTransaction, Pos.BOTTOM_LEFT);
		bpaneLabel.setMinHeight(15);
		
		bpane.setCenter(bpaneLabel);
		
		BackgroundFill backfills = new BackgroundFill(Color.TURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
		Background backgrnd = new Background(backfills);
		bpane.setBackground(backgrnd);

		
		scene = new Scene(bpane, 1000, 700);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initialize();
		setViewHeader();
		setViewDetail();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}


package application;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.HeaderTransaction;
import model.ViewTransaction;
import model.WrapperView;

public class ViewTransactionHistory extends Application{
	
	Scene scene;
	BorderPane bpane, bpaneLabel, bpaneHeader, bpaneDetail;
	GridPane gpane;
	Label selectedTransaction, transactionName;
	TableView<HeaderTransaction> headerTable;
	ArrayList<HeaderTransaction> headerList;
	TableView<ViewTransaction> detailTable;
	ArrayList<ViewTransaction> detailList;
	DBConnect dbConnect = DBConnect.getInstance();
	
	@SuppressWarnings("unchecked")
	private void setViewHeader() {
		// TODO Auto-generated method stub
		headerTable = new TableView<>();
		headerList = new ArrayList<>();
		
		TableColumn<HeaderTransaction, Integer> transactID = new TableColumn<HeaderTransaction, Integer>("Transaction ID");
		TableColumn<HeaderTransaction, Integer> userID = new TableColumn<HeaderTransaction, Integer>("User ID");
		TableColumn<HeaderTransaction, Date> transactDate = new TableColumn<HeaderTransaction, Date>("Transaction Date");
		
		transactID.setCellValueFactory(new PropertyValueFactory<HeaderTransaction, Integer>("TransactionID"));
		userID.setCellValueFactory(new PropertyValueFactory<HeaderTransaction, Integer>("UserID"));
		transactDate.setCellValueFactory(new PropertyValueFactory<HeaderTransaction, Date>("TransactionDate"));
		
		transactID.setPrefWidth(300);
		userID.setPrefWidth(300);
		transactDate.setPrefWidth(500);
		
		headerTable.getColumns().addAll(transactID, userID, transactDate);
		bpaneHeader.setCenter(headerTable);
		
		headerTable.setPrefHeight(300);
		headerTable.setPrefWidth(300);
	}
	
	public void refreshHeaderTable() {
		headerList.clear();
		detailList.clear();
		getHeaderData();
		ObservableList<HeaderTransaction> headerObs = FXCollections.observableArrayList(headerList);
		headerTable.setItems(headerObs);
	}
	
	private void getHeaderData() {
		DBConnect dbConnect = DBConnect.getInstance();
		ResultSet rs = dbConnect.executeQuery("SELECT * FROM `headertransaction`");
		
		try {
			while(rs.next()) {
				Integer transactionID = rs.getInt("TransactionID");
				Integer userID = rs.getInt("TransactionID");
				Date transactionDate = rs.getDate("TransactionDate");		
				
				headerList.add(new HeaderTransaction(transactionID, userID, transactionDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void setViewDetail() {
		// TODO Auto-generated method stub
		detailTable = new TableView<>();
		TableColumn<ViewTransaction, Integer> transactID = new TableColumn<ViewTransaction, Integer>("Transaction ID");
		TableColumn<ViewTransaction, Integer> watchID = new TableColumn<ViewTransaction, Integer>("Watch ID");
		TableColumn<ViewTransaction, String> watchName = new TableColumn<ViewTransaction, String>("Watch Name");
		TableColumn<ViewTransaction, String> watchBrand = new TableColumn<ViewTransaction, String>("Watch Brand");
		TableColumn<ViewTransaction, Integer> watchPrice = new TableColumn<ViewTransaction, Integer>("Watch Price");
		TableColumn<ViewTransaction, Integer> quantity = new TableColumn<ViewTransaction, Integer>("Quantity");
		TableColumn<ViewTransaction, Integer> subTotal = new TableColumn<ViewTransaction, Integer>("Sub Total");
		
		transactID.setCellValueFactory(new PropertyValueFactory<ViewTransaction, Integer>("TransactionID"));
		watchID.setCellValueFactory(new PropertyValueFactory<ViewTransaction, Integer>("WatchID"));
		watchName.setCellValueFactory(new PropertyValueFactory<ViewTransaction, String>("WatchName"));
		watchBrand.setCellValueFactory(new PropertyValueFactory<ViewTransaction, String>("WatchBrand"));
		watchPrice.setCellValueFactory(new PropertyValueFactory<ViewTransaction, Integer>("WatchPrice"));
		quantity.setCellValueFactory(new PropertyValueFactory<ViewTransaction, Integer>("Quantity"));
		subTotal.setCellValueFactory(new PropertyValueFactory<ViewTransaction, Integer>("SubTotal"));
		
		transactID.setPrefWidth(100);
		watchID.setPrefWidth(100);
		watchName.setPrefWidth(200);
		watchBrand.setPrefWidth(200);
		watchPrice.setPrefWidth(150);
		quantity.setPrefWidth(100);
		subTotal.setPrefWidth(150);
		
		
		detailTable.getColumns().addAll(transactID, watchID, watchName, watchBrand, watchPrice, quantity, subTotal);
		bpaneDetail.setCenter(detailTable);
		detailTable.autosize();
		
		detailTable.setPrefHeight(300);
		detailTable.setPrefWidth(300);
	}
	
//	private void refreshDetailTable() {
//		detailList.clear();
//		getDetailData();
//		ObservableList<ViewTransaction> detailObs = FXCollections.observableArrayList(detailList);
//		detailTable.setItems(detailObs);
//	}
	
//	private void getDetailData() {
//		DBConnect dbConnect = DBConnect.getInstance();
//		ResultSet rs = dbConnect.executeQuery("SELECT ht.TransactionID, dt.WatchID,wt.WatchName, br.BrandName, wt.WatchPrice, dt.Quantity, SUM(dt.Quantity * wt.WatchPrice) AS SubTotal FROM headertransaction ht JOIN detailtransaction dt ON ht.TransactionID = dt.TransactionID JOIN watch wt ON dt.WatchID = wt.WatchID JOIN brand br ON wt.BrandID = br.BrandID GROUP BY ht.TransactionID, dt.WatchID, wt.WatchName, br.BrandName, wt.WatchPrice, dt.Quantity;");
//		
//		try {
//			while(rs.next()) {
//				Integer transactionID = rs.getInt("ht.TransactionID");
//				Integer watchID = rs.getInt("dt.WatchID");
//				String watchName = rs.getString("wt.WatchName");
//				String watchBrand = rs.getString("br.BrandName");
//				Integer watchPrice = rs.getInt("wt.WatchPrice");
//				Integer quantity = rs.getInt("dt.Quantity");
//				Integer subTotal = rs.getInt("SUM(dt.Quantity * wt.WatchPrice) AS SubTotal");
//				
//				detailList.add(new ViewTransaction(transactionID, watchID, watchName, watchBrand, watchPrice, quantity, subTotal));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		bpane = new BorderPane();
		bpaneLabel = new BorderPane();
		bpaneHeader = new BorderPane();
		bpaneDetail = new BorderPane();
		gpane = new GridPane();
		
		
		selectedTransaction = new Label("Selected Transaction: ");
		transactionName = new Label("None");
		
		gpane.add(selectedTransaction, 0, 0);
		gpane.add(transactionName, 1, 0);
		
		bpaneLabel.setPadding(new Insets(10, 10, 10, 10));
		
		bpaneLabel.setCenter(gpane);
		bpaneLabel.setAlignment(selectedTransaction, Pos.BOTTOM_LEFT);
		bpaneLabel.setMinHeight(15);
		
		bpaneHeader.setMinWidth(300);
		bpaneDetail.setMinWidth(300);
		
		bpane.setTop(bpaneHeader);
		bpane.setCenter(bpaneLabel);
		bpane.setBottom(bpaneDetail);
		
		BackgroundFill backfills = new BackgroundFill(Color.TURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(backfills);
		bpane.setBackground(bg);

		
		scene = new Scene(bpane, 1000, 700);
	}
	
	private void setEvent() {
		headerTable.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				TableSelectionModel<HeaderTransaction> selectedHeader = headerTable.getSelectionModel();
				selectedHeader.setSelectionMode(SelectionMode.SINGLE);
				
				HeaderTransaction headerTransact = selectedHeader.getSelectedItem();
				
				if (headerTransact != null) {
					transactionName.setText("Transaction " + String.valueOf(headerTransact.getTransactionID()));
					detailList.clear();
					
					ResultSet rs = dbConnect.executeQuery("SELECT ht.TransactionID, dt.WatchID,wt.WatchName, br.BrandName, wt.WatchPrice, dt.Quantity, SUM(dt.Quantity * wt.WatchPrice) AS SubTotal FROM headertransaction ht JOIN detailtransaction dt ON ht.TransactionID = dt.TransactionID JOIN watch wt ON dt.WatchID = wt.WatchID JOIN brand br ON wt.BrandID = br.BrandID GROUP BY ht.TransactionID, dt.WatchID, wt.WatchName, br.BrandName, wt.WatchPrice, dt.Quantity;");
					
					try {
						while(rs.next()) {
							Integer transactionID = rs.getInt("ht.TransactionID");
							Integer watchID = rs.getInt("dt.WatchID");
							String watchName = rs.getString("wt.WatchName");
							String watchBrand = rs.getString("br.BrandName");
							Integer watchPrice = rs.getInt("wt.WatchPrice");
							Integer quantity = rs.getInt("dt.Quantity");
							Integer subTotal = rs.getInt("SUM(dt.Quantity * wt.WatchPrice) AS SubTotal");
							
							detailList.add(new ViewTransaction(transactionID, watchID, watchName, watchBrand, watchPrice, quantity, subTotal));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ObservableList<ViewTransaction> detailObs = FXCollections.observableArrayList(detailList);
				detailTable.setItems(detailObs);
			}
		});
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
		refreshHeaderTable();
//		refreshDetailTable();
		setEvent();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}


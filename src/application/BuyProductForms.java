package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.Refreshable;

import connect.DBConnect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Cart;
import model.Watch;
import model.WrapperWatch;

public class BuyProductForms extends Application{
	
	Scene scene;
	BorderPane bp;
	GridPane gp;
	FlowPane fp;
	
	BorderPane bp2;
	GridPane gp2;
	
	BorderPane bp3;
	
	TableView<WrapperWatch> watchTable;
	ArrayList<WrapperWatch> watchList;
	
	 TableView<Cart> cartTable;
	 ArrayList<Cart> cartList;
 	
	Label select;
	Label selectValue;
	
	Label qty;
	Spinner<Integer> qtySP;
	Button addBtn;
	Button clearBtn;
	Button checkoutBtn;
	
	public void init() {
		bp = new BorderPane();
		gp = new GridPane();
		fp = new FlowPane();
		
		bp2 = new BorderPane();
		gp2 = new GridPane();
		
		bp3 = new BorderPane();
		
		watchTable = new TableView<>();
		watchTable.setMaxHeight(250);
		watchList = new ArrayList<>();
		
		cartTable = new TableView<>();
		cartTable.setMaxHeight(250);
		watchList = new ArrayList<>();
		
		select = new Label("Selected Watch: ");
		selectValue = new Label("None");
		
		qty = new Label("Quantity: ");
		qtySP = new Spinner<>();
		addBtn = new Button("Add Watch To Cart");
		clearBtn = new Button("Clear Cart");
		checkoutBtn = new Button("Checkout");
		
		scene = new Scene(bp, 1000, 700);
	}
	
	public void setLayout() {
		gp.add(select, 0, 0);
		gp.add(selectValue, 1, 0);
		gp.setAlignment(Pos.TOP_LEFT);
		gp.setPadding(new Insets(10, 10, 10, 10));
		
		gp2.add(qty, 1, 0);
		gp2.add(qtySP, 1, 1);
		gp2.add(addBtn, 1, 2);
		gp2.setAlignment(Pos.CENTER);
		
		bp2.setTop(gp);
		bp2.setBottom(gp2);
		bp2.setAlignment(gp, Pos.TOP_LEFT);
		bp2.setAlignment(gp2, Pos.CENTER);
		
		fp.getChildren().add(clearBtn);
		fp.getChildren().add(checkoutBtn);
		fp.setHgap(10);
		fp.setVgap(10);
		fp.setPadding(new Insets(10, 10, 10, 10));
		
		fp.setAlignment(Pos.CENTER);
		
		bp3.setCenter(cartTable);
		bp3.setBottom(fp);
		
		bp3.setAlignment(cartTable, Pos.TOP_CENTER);
		
		bp.setTop(watchTable);
		bp.setCenter(bp2);
		bp.setBottom(bp3);

	}
	
	@SuppressWarnings("unchecked")
	public void setTable() {
		TableColumn<WrapperWatch, Integer> watchIDColumn = new TableColumn<WrapperWatch, Integer>("Watch ID");
		TableColumn<WrapperWatch, String> watchNameColumn = new TableColumn<WrapperWatch, String>("Watch Name");
		TableColumn<WrapperWatch, String> watchBrandColumn = new TableColumn<WrapperWatch, String>("Watch Brand");
		TableColumn<WrapperWatch, Integer> watchPriceColumn = new TableColumn<WrapperWatch, Integer>("Watch Price");
		
		watchIDColumn.setCellValueFactory(new PropertyValueFactory<WrapperWatch, Integer>("WatchID"));
		watchNameColumn.setCellValueFactory(new PropertyValueFactory<WrapperWatch, String>("WatchName"));
		watchBrandColumn.setCellValueFactory(new PropertyValueFactory<WrapperWatch, String>("WatchBrand"));
		watchPriceColumn.setCellValueFactory(new PropertyValueFactory<WrapperWatch, Integer>("WatchPrice"));
		
		watchTable.getColumns().addAll(watchIDColumn, watchNameColumn, watchBrandColumn, watchPriceColumn);
		
		watchIDColumn.setPrefWidth(200);
		watchPriceColumn.setPrefWidth(200);
		watchBrandColumn.setPrefWidth(300);
		watchNameColumn.setPrefWidth(300);
		
		TableColumn<Cart, Integer> cartUserIDColumn = new TableColumn<Cart, Integer>("User ID");
		TableColumn<Cart, Integer> cartWatchIDColumn = new TableColumn<Cart, Integer>("Watch ID");
		TableColumn<Cart, Integer> cartQuantity = new TableColumn<Cart, Integer>("Quantity");
		
		cartUserIDColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("UserID"));
		cartWatchIDColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("WatchID"));
		cartQuantity.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("Quantity"));
		
		cartTable.getColumns().addAll(cartUserIDColumn, cartWatchIDColumn, cartQuantity);
		
		cartUserIDColumn.setPrefWidth(1000/3);
		cartWatchIDColumn.setPrefWidth(1000/3);
		cartQuantity.setPrefWidth(1000/3);
	}
	
//	public void refreshTable() {
//		watchList.clear();
//		getWatch();
//		ObservableList<WrapperWatch> watchObs = FXCollections.observableArrayList(watchList);
//		watchTable.setItems(watchObs);
//	}
//	
//	public void getWatch() {
//		DBConnect dbConnect = DBConnect.getInstance();
//		ResultSet rs = dbConnect.executeQuery("SELECT * FROM `ujicoba`");
//		
//		try {
//			while(rs.next()) {
//				Integer watchID = rs.getInt("WatchID");
//				String watchName = rs.getString("WatchName");
//				String watchBrand = rs.getString("WatchBrand");
//				Integer watchPrice = rs.getInt("WatchPrice");
//				Integer watchStock = rs.getInt("Stock");
//				watchList.add(new WrapperWatch(watchID, watchPrice, watchStock, watchName, watchBrand));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		setLayout();
		setTable();
//		refreshTable();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
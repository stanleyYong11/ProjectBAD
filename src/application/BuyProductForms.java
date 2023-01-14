package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.Refreshable;

import connect.DBConnect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;
import model.Cart;
import model.Watch;
import model.WrapperWatch;

public class BuyProductForms{
	
	public static BuyProductForms BuyProduct;
	
	Scene scene;
	BorderPane bp;
	GridPane gp;
	FlowPane fp;
	
	BorderPane bp2;
	GridPane gp2;
	
	BorderPane bp3;
	
	TableView<Watch> watchTable;
	ArrayList<Watch> watchList;
	
	 TableView<Cart> cartTable;
	 ArrayList<Cart> cartList;
 	
	Label select;
	Label selectValue;
	
	Label qty;
	Spinner<Integer> qtySP;
	Button addBtn;
	Button clearBtn;
	Button checkoutBtn;
	
	Window window;
	
	int WatchID;
	
	public static BuyProductForms getInstance() {
		if (BuyProduct == null) {
			BuyProduct = new BuyProductForms();
		}
		return BuyProduct;
	}
	
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
		qtySP = new Spinner<>(0, 100, 0);
		addBtn = new Button("Add Watch To Cart");
		clearBtn = new Button("Clear Cart");
		checkoutBtn = new Button("Checkout");
		
//		scene = new Scene(bp, 1000, 700);
		
		window = new Window("Buy Product");
		window.getRightIcons().add(new CloseIcon(window));
		window.getContentPane().getChildren().add(bp);
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
		TableColumn<Watch, Integer> watchID = new TableColumn<Watch, Integer>("Watch ID");
		TableColumn<Watch, String> watchName = new TableColumn<Watch, String>("Watch Name");
		TableColumn<Watch, Integer> watchBrand = new TableColumn<Watch, Integer>("Brand ID");
		TableColumn<Watch, Integer> watchPrice = new TableColumn<Watch, Integer>("Watch Price");
		TableColumn<Watch, Integer> watchStock = new TableColumn<Watch, Integer>("Watch Stock");
		
		watchID.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchID"));
		watchName.setCellValueFactory(new PropertyValueFactory<Watch, String>("WatchName"));
		watchBrand.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("BrandID"));
		watchPrice.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchPrice"));
		watchStock.setCellValueFactory(new PropertyValueFactory<Watch, Integer>("WatchStock"));
		
		watchTable.getColumns().addAll(watchID, watchName, watchBrand, watchPrice, watchStock);
		
		watchID.setPrefWidth(150);
		watchName.setPrefWidth(300);
		watchBrand.setPrefWidth(270);
		watchPrice.setPrefWidth(150);
		watchStock.setPrefWidth(130);
		
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
	
	public void refreshTable() {
		watchList.clear();
		getWatch();
		ObservableList<Watch> watchObs = FXCollections.observableArrayList(watchList);
		watchTable.setItems(watchObs);
	}
	
	public void getWatch() {
		DBConnect dbConnect = DBConnect.getInstance();
		ResultSet rs = dbConnect.executeQuery("SELECT * FROM `watch`");
		
		try {
			while(rs.next()) {
				int watchID = rs.getInt("WatchID");
				String watchName = rs.getString("WatchName");
				int brandID = rs.getInt("BrandID");
				int watchPrice = rs.getInt("WatchPrice");
				int watchStock = rs.getInt("WatchStock");
				
				Watch watch = new Watch(watchID, watchName, brandID, watchPrice, watchStock);
				watchList.add(watch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEvent() {
		watchTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				TableSelectionModel<Watch> selectedWatch = watchTable.getSelectionModel();
				selectedWatch.setSelectionMode(SelectionMode.SINGLE);
				
				Watch watch = selectedWatch.getSelectedItem();
				
				if (watch != null){
					selectValue.setText(watch.getWatchName());
				}
			}
		});
	}
	
	public Window getWindow() {
		init();
		setLayout();
		setTable();
		refreshTable();
		setEvent();
		
		return window;
	}

}
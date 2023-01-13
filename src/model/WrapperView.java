package model;

public class WrapperView extends DetailTransaction{
	private int ViewTransactionID, ViewWatchID, ViewQuantity, ViewWatchPrice, SubTotal;
	private String ViewWatchName, ViewBrandName;
	
	public WrapperView(int transactionID, int watchID, int quantity, int viewTransactionID, int viewWatchID,
			int viewQuantity, int viewWatchPrice, String viewWatchName, String viewBrandName, int subTotal) {
		super(transactionID, watchID, quantity);
		ViewTransactionID = viewTransactionID;
		ViewWatchID = viewWatchID;
		ViewQuantity = viewQuantity;
		ViewWatchPrice = viewWatchPrice;
		ViewWatchName = viewWatchName;
		ViewBrandName = viewBrandName;
		SubTotal = subTotal;
	}

	public int getViewTransactionID() {
		return ViewTransactionID;
	}

	public void setViewTransactionID(int viewTransactionID) {
		ViewTransactionID = viewTransactionID;
	}

	public int getViewWatchID() {
		return ViewWatchID;
	}

	public void setViewWatchID(int viewWatchID) {
		ViewWatchID = viewWatchID;
	}

	public int getViewQuantity() {
		return ViewQuantity;
	}

	public void setViewQuantity(int viewQuantity) {
		ViewQuantity = viewQuantity;
	}

	public String getViewWatchName() {
		return ViewWatchName;
	}

	public void setViewWatchName(String viewWatchName) {
		ViewWatchName = viewWatchName;
	}

	public String getViewBrandName() {
		return ViewBrandName;
	}

	public void setViewBrandName(String viewBrandName) {
		ViewBrandName = viewBrandName;
	}

	public int getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(int subTotal) {
		SubTotal = subTotal;
	}

	public int getViewWatchPrice() {
		return ViewWatchPrice;
	}

	public void setViewWatchPrice(int viewWatchPrice) {
		ViewWatchPrice = viewWatchPrice;
	}

}
 

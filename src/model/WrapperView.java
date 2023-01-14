package model;

public class WrapperView extends DetailTransaction{
	private int 
	TransactionID, 
	WatchID, 
	Quantity, 
	WatchPrice, 
	SubTotal;
	
	private String 
	WatchName, 
	BrandName;

	public WrapperView(int transactionID, int watchID, int quantity, int transactionIDView, int watchIDView, int quantityView,
			int watchPrice, int subTotal, String watchName, String brandName) {
		super(transactionID, watchID, quantity);
		TransactionID = transactionIDView;
		WatchID = watchIDView;
		Quantity = quantityView;
		WatchPrice = watchPrice;
		SubTotal = subTotal;
		WatchName = watchName;
		BrandName = brandName;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public int getWatchID() {
		return WatchID;
	}

	public void setWatchID(int watchID) {
		WatchID = watchID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getWatchPrice() {
		return WatchPrice;
	}

	public void setWatchPrice(int watchPrice) {
		WatchPrice = watchPrice;
	}

	public int getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(int subTotal) {
		SubTotal = subTotal;
	}

	public String getWatchName() {
		return WatchName;
	}

	public void setWatchName(String watchName) {
		WatchName = watchName;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}
	
	
	
}

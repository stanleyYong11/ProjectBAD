package model;

public class DetailTransaction {
	private int TransactionID;
	private int WatchID;
	private int Quantity;
	
	public DetailTransaction(int transactionID, int watchID, int quantity) {
		super();
		TransactionID = transactionID;
		WatchID = watchID;
		Quantity = quantity;
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
}

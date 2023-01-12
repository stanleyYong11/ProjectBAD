package model;

public class HeaderTransaction {
	private int TransactionID;
	private int UserID;
	private String transactionDate;
	
	public HeaderTransaction(int transactionID, int userID, String transactionDate) {
		super();
		TransactionID = transactionID;
		UserID = userID;
		this.transactionDate = transactionDate;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}

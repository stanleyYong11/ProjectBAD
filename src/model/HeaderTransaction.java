package model;

import java.sql.Date;

public class HeaderTransaction {
	private int TransactionID;
	private int UserID;
	private Date TransactionDate;
	
	public HeaderTransaction(int transactionID, int userID, Date transactionDate) {
		super();
		this.TransactionID = transactionID;
		this.UserID = userID;
		this.TransactionDate = transactionDate;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		this.TransactionID = transactionID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		this.UserID = userID;
	}

	public Date getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.TransactionDate = transactionDate;
	}
	
}

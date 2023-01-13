package model;

public class ViewTransaction {
	private Integer TransactionID;
	private Integer WatchID;
	private String WatchName;
	private String WatchBrand;
	private Integer WatchPrice;
	private Integer Quantity;
	private Integer SubTotal;
	
	public ViewTransaction(Integer transactionID, Integer watchID, String watchName, String watchBrand,
			Integer watchPrice, Integer quantity, Integer subTotal) {
		TransactionID = transactionID;
		WatchID = watchID;
		WatchName = watchName;
		WatchBrand = watchBrand;
		WatchPrice = watchPrice;
		Quantity = quantity;
		SubTotal = subTotal;
	}

	public Integer getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(Integer transactionID) {
		TransactionID = transactionID;
	}

	public Integer getWatchID() {
		return WatchID;
	}

	public void setWatchID(Integer watchID) {
		WatchID = watchID;
	}

	public String getWatchName() {
		return WatchName;
	}

	public void setWatchName(String watchName) {
		WatchName = watchName;
	}

	public String getWatchBrand() {
		return WatchBrand;
	}

	public void setWatchBrand(String watchBrand) {
		WatchBrand = watchBrand;
	}

	public Integer getWatchPrice() {
		return WatchPrice;
	}

	public void setWatchPrice(Integer watchPrice) {
		WatchPrice = watchPrice;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Integer getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(Integer subTotal) {
		SubTotal = subTotal;
	}
	
}

package model;

public class WrapperView extends DetailTransaction{
	
	private String WatchName;
	private String WatchBrand;
	private String WatchPrice;
	private int SubTotal;

	public WrapperView(int transactionID, int watchID, int quantity, String watchName, String watchBrand,
			String watchPrice, int subTotal) {
		super(transactionID, watchID, quantity);
		this.WatchName = watchName;
		this.WatchBrand = watchBrand;
		this.WatchPrice = watchPrice;
		this.SubTotal = subTotal;
	}

	public String getWatchName() {
		return WatchName;
	}

	public void setWatchName(String watchName) {
		this.WatchName = watchName;
	}

	public String getWatchBrand() {
		return WatchBrand;
	}

	public void setWatchBrand(String watchBrand) {
		this.WatchBrand = watchBrand;
	}

	public String getWatchPrice() {
		return WatchPrice;
	}

	public void setWatchPrice(String watchPrice) {
		this.WatchPrice = watchPrice;
	}

	public int getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(int subTotal) {
		this.SubTotal = subTotal;
	}

	
}
 

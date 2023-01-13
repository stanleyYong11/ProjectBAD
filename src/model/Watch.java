package model;

public class Watch {
	private int WatchID;
	private String WatchName;
	private int BrandID;
	private int WatchPrice;
	private int WatchStock;
	
	public Watch(int watchID, String watchName, int brandID, int watchPrice, int watchStock) {
		this.WatchID = watchID;
		this.WatchName = watchName;
		this.BrandID = brandID;
		this.WatchPrice = watchPrice;
		this.WatchStock = watchStock;
	}

	public int getWatchID() {
		return WatchID;
	}

	public void setWatchID(int watchID) {
		this.WatchID = watchID;
	}

	public int getBrandID() {
		return BrandID;
	}

	public void setBrandID(int brandID) {
		this.BrandID = brandID;
	}

	public String getWatchName() {
		return WatchName;
	}

	public void setWatchName(String watchName) {
		this.WatchName = watchName;
	}

	public int getWatchPrice() {
		return WatchPrice;
	}

	public void setWatchPrice(int watchPrice) {
		this.WatchPrice = watchPrice;
	}

	public int getWatchStock() {
		return WatchStock;
	}

	public void setWatchStock(int watchStock) {
		this.WatchStock = watchStock;
	}
}

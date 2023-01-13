package model;

public class WrapperWatch {
	private int watchID, watchPrice, watchStock;
	private String watchName, watchBrand;
	public WrapperWatch(int watchID, int watchPrice, int watchStock, String watchName, String watchBrand) {
		super();
		this.watchID = watchID;
		this.watchPrice = watchPrice;
		this.watchStock = watchStock;
		this.watchName = watchName;
		this.watchBrand = watchBrand;
	}
	public int getWatchID() {
		return watchID;
	}
	public void setWatchID(int watchID) {
		this.watchID = watchID;
	}
	public int getWatchPrice() {
		return watchPrice;
	}
	public void setWatchPrice(int watchPrice) {
		this.watchPrice = watchPrice;
	}
	public int getWatchStock() {
		return watchStock;
	}
	public void setWatchStock(int watchStock) {
		this.watchStock = watchStock;
	}
	public String getWatchName() {
		return watchName;
	}
	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	public String getWatchBrand() {
		return watchBrand;
	}
	public void setWatchBrand(String watchBrand) {
		this.watchBrand = watchBrand;
	}
	
	
	
}

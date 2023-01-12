package application;

public class Watch {
	private Integer WatchID;
	private String BrandName;
	private String WatchName;
	private Integer WatchPrice;
	private Integer WatchStock;
	
	public Watch(Integer watchID, String brandName, String watchName, Integer watchPrice, Integer watchStock) {
		super();
		this.WatchID = watchID;
		this.BrandName = brandName;
		this.WatchName = watchName;
		this.WatchPrice = watchPrice;
		this.WatchStock = watchStock;
	}

	public Integer getWatchID() {
		return WatchID;
	}

	public void setWatchID(Integer watchID) {
		this.WatchID = watchID;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		this.BrandName = brandName;
	}

	public String getWatchName() {
		return WatchName;
	}

	public void setWatchName(String watchName) {
		this.WatchName = watchName;
	}

	public Integer getWatchPrice() {
		return WatchPrice;
	}

	public void setWatchPrice(Integer watchPrice) {
		this.WatchPrice = watchPrice;
	}

	public Integer getWatchStock() {
		return WatchStock;
	}

	public void setWatchStock(Integer watchStock) {
		this.WatchStock = watchStock;
	}
	
}
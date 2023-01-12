package model;

public class Brand {
	private int BrandID;
	private String BrandName;
	
	public Brand(int brandID, String brandName) {
		this.BrandID = brandID;
		this.BrandName = brandName;
	}

	public int getBrandID() {
		return BrandID;
	}

	public void setBrandID(int brandID) {
		this.BrandID = brandID;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		this.BrandName = brandName;
	}
	
	
}

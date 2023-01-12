package model;

public class BrandDete {
	protected int brandid;
	protected String brandname;
	
	
	public BrandDete(int brandid, String brandname) {
		super();
		this.brandid = brandid;
		this.brandname = brandname;
	}
	
	public int getBrandid() {
		return brandid;
	}
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
	
	
}

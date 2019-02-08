package com.cap.mobileApplication.bean;

public class Mobile
{
	private String mobileid;
	private String mobileName;
	private int mobilePrice;
	private int mobileQuantity;
	public Mobile(String mobileid,String mobileName,int mobilePrice,int mobileQuantity)
	{
		this.mobileid = mobileid;
		this.mobileName = mobileName;
		this.mobilePrice=mobilePrice;
		this.mobileQuantity=mobileQuantity;
	}
	
	
	
	public String getMobileid() {
		return mobileid;
	}
	public void setMobileid(String mobileid) {
		this.mobileid = mobileid;
	}
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public int getMobilePrice() {
		return mobilePrice;
	}
	public void setMobilePrice(int mobilePrice) {
		this.mobilePrice = mobilePrice;
	}
	public int getMobileQuantity() {
		return mobileQuantity;
	}
	public void setMobileQuantity(int mobileQuantity) {
		this.mobileQuantity = mobileQuantity;
	}
	
	

}

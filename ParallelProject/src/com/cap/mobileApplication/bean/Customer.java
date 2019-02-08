package com.cap.mobileApplication.bean;

import java.time.LocalDate;

public class Customer 
{ 
	private String customerName;
	private String customerMailId; 
	private String customerPhoneNo;
	private String mobileid;
	private static int purchaseId=800;
	private LocalDate purchaseDate;
	
	public Customer(String mobileid,String customerName,String customerEmail,String customerPhone)
	{
		this.mobileid=mobileid;
		this.customerName=customerName;
		this.customerMailId=customerEmail;
		this.customerPhoneNo=customerPhone;
		Customer.purchaseId++;
		
		this.purchaseDate=LocalDate.now();
		
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMailId() {
		return customerMailId;
	}
	public void setCustomerMailId(String customerMailId) {
		this.customerMailId = customerMailId;
	}
	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public String getMobileid() {
		return mobileid;
	}
	public void setMobileid(String mobileid) {
		this.mobileid = mobileid;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		Customer.purchaseId = purchaseId;
	}
	public LocalDate getPurchasedate() {
		return purchaseDate;
	}
	public void setPurchasedate(LocalDate purchasedate) {
		this.purchaseDate = purchasedate;
	}
	
	

}

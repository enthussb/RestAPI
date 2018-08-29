package com.rest.api;

public class Customer 
{

	String CustomerName;
	String CustomerCity;
	String CustomerCountry;
	long CustomerPhoneNo;
	
	
	public Customer(String customerName, String customerCity, String customerCountry, long customerPhoneNo) 
	{
		CustomerName = customerName;
		CustomerCity = customerCity;
		CustomerCountry = customerCountry;
		CustomerPhoneNo = customerPhoneNo;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerCity() {
		return CustomerCity;
	}
	public void setCustomerCity(String customerCity) {
		CustomerCity = customerCity;
	}
	public String getCustomerCountry() {
		return CustomerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		CustomerCountry = customerCountry;
	}
	public long getCustomerPhoneNo() {
		return CustomerPhoneNo;
	}
	public void setCustomerPhoneNo(long customerPhoneNo) {
		CustomerPhoneNo = customerPhoneNo;
	}
	@Override
	   public String toString() {
	        return ("CustomerName:"+this.getCustomerName()+
	                    "CustPhoneNo: "+ this.getCustomerPhoneNo() +
	                    "CustCity: "+ this.getCustomerCity()+
	                    " CustCountry : " + this.getCustomerCity());
	   }
	
}

package com.ilp04.entity;

public class Customer {
	private int customerCode;
	private String customerFirstName;
	private String customerSecondName;
	private String address;
	private long phNumber;
	private long adharNo;
	
	public Customer(int customerCode, String customerFirstName, String customerSecondName, String address,
			long phNumber, long adharNo) {
		super();
		this.customerCode = customerCode;
		this.customerFirstName = customerFirstName;
		this.customerSecondName = customerSecondName;
		this.address = address;
		this.phNumber = phNumber;
		this.adharNo = adharNo;
	}

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerSecondName() {
		return customerSecondName;
	}

	public void setCustomerSecondName(String customerSecondName) {
		this.customerSecondName = customerSecondName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}
}

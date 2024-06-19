package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Customer;
//this is an interface
public interface CustomerService {
	public ArrayList <Customer> getAllCustomers();
	public int insertIntoCustomer(Customer customer);
	public int updateCustomer(int customerCode, String field, String newValue);
}

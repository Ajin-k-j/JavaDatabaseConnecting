package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        Connection connection = CustomerDAO.getConnection();
        customerList = CustomerDAO.getAllCustomers(connection);
        CustomerDAO.closeConnection(connection);
        return customerList;
    }

    public int insertIntoCustomer(Customer customer) {
        Connection connection = CustomerDAO.getConnection();
        int result = CustomerDAO.insertCustomer(connection, customer);
        CustomerDAO.closeConnection(connection);
        return result;
    }

    public int updateCustomer(int customerCode, String field, String newValue) {
        Connection connection = CustomerDAO.getConnection();
        int result = CustomerDAO.updateCustomer(connection, customerCode, field, newValue);
        CustomerDAO.closeConnection(connection);
        return result;
    }
}

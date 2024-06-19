package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {

    // Get connection
    public static Connection getConnection() {
        String connectionURL = "jdbc:mysql://localhost:3306/bankdb?useSSL=false";
        String userName = "root";
        String password = "experion@123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Close connection
    public static Connection closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Get all customer details
    public static ArrayList<Customer> getAllCustomers(Connection connection) {
        ArrayList<Customer> customerList = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from customer");
            while (resultSet.next()) {
                int customerCode = resultSet.getInt("customer_code");
                String customerFirstName = resultSet.getString("customer_firstname");
                String customerSecondName = resultSet.getString("customer_lastname");
                String address = resultSet.getString("address");
                long phNumber = resultSet.getLong("phonenumber");
                long adharNo = resultSet.getLong("adharno");

                Customer customer = new Customer(customerCode, customerFirstName, customerSecondName, address, phNumber, adharNo);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    // Insert customer
    public static int insertCustomer(Connection connection, Customer customer) {
        String query = "INSERT INTO customer (customer_firstname, customer_lastname, address, phonenumber, adharno) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getCustomerFirstName());
            preparedStatement.setString(2, customer.getCustomerSecondName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, customer.getPhNumber());
            preparedStatement.setLong(5, customer.getAdharNo());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Update customer
    public static int updateCustomer(Connection connection, int customerCode, String field, String newValue) {
        String query = "UPDATE customer SET " + field + " = ? WHERE customer_code = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (field.equalsIgnoreCase("phonenumber") || field.equalsIgnoreCase("adharno")) {
                preparedStatement.setLong(1, Long.parseLong(newValue));
            } else {
                preparedStatement.setString(1, newValue);
            }
            preparedStatement.setInt(2, customerCode);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

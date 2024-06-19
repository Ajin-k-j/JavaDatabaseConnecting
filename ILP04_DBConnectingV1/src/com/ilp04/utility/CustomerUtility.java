package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerServiceImpl();
        int choice;

        do {
            System.out.println("\n1) Display all customers");
            System.out.println("2) Insert into customer");
            System.out.println("3) Update customer");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    displayAllCustomers(customerService);
                    break;
                case 2:
                    insertCustomer(scanner, customerService);
                    break;
                case 3:
                    updateCustomer(scanner, customerService);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayAllCustomers(CustomerService customerService) {
        ArrayList<Customer> customerList = customerService.getAllCustomers();

        // Print the details of customerList formatted as a table
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        String format = "%-15s %-18s %-18s %-15s %-12s %-13s %n";
        System.out.printf(format, "Customer Code", "Customer Firstname", "Customer Lastname", "Address", "Phonenumber", "Adhar No");
        printSeparator(format);

        for (Customer customer : customerList) {
            System.out.printf(format,
                    customer.getCustomerCode(),
                    customer.getCustomerFirstName(),
                    customer.getCustomerSecondName(),
                    customer.getAddress(),
                    customer.getPhNumber(),
                    customer.getAdharNo());
        }
    }

    private static void printSeparator(String format) {
        System.out.printf(format,
                "--------------", "-----------------", "-----------------", "---------------", "-----------", "------------");
    }

    private static void insertCustomer(Scanner scanner, CustomerService customerService) {
        System.out.print("Enter customer first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter customer last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        long phNumber = scanner.nextLong();
        System.out.print("Enter adhar number: ");
        long adharNo = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Customer customer = new Customer(0, firstName, lastName, address, phNumber, adharNo);
        int result = customerService.insertIntoCustomer(customer);

        if (result > 0) {
            System.out.println("Customer inserted successfully.");
        } else {
            System.out.println("Failed to insert customer.");
        }
    }

    private static void updateCustomer(Scanner scanner, CustomerService customerService) {
        System.out.print("Enter customer code: ");
        int customerCode = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Which parameter do you want to update?");
        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Address");
        System.out.println("4) Phone Number");
        System.out.println("5) Adhar No");
        System.out.print("Enter your choice: ");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String field = "";
        String newValue = "";

        switch (updateChoice) {
            case 1:
                field = "customer_firstname";
                System.out.print("Enter new first name: ");
                newValue = scanner.nextLine();
                break;
            case 2:
                field = "customer_lastname";
                System.out.print("Enter new last name: ");
                newValue = scanner.nextLine();
                break;
            case 3:
                field = "address";
                System.out.print("Enter new address: ");
                newValue = scanner.nextLine();
                break;
            case 4:
                field = "phonenumber";
                System.out.print("Enter new phone number: ");
                newValue = scanner.nextLine();
                break;
            case 5:
                field = "adharno";
                System.out.print("Enter new adhar number: ");
                newValue = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        int result = customerService.updateCustomer(customerCode, field, newValue);

        if (result > 0) {
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Failed to update customer.");
        }
    }
}

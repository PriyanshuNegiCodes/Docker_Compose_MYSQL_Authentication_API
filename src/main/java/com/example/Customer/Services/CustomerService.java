package com.example.Customer.Services;

import com.example.Customer.Domain.Customer;
import com.example.Customer.Exception.CustomerAlreadyExsistException;
import com.example.Customer.Exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    boolean deleteCustomerById(String customerName) throws CustomerNotFoundException;
    Customer checkLogin(Customer customer);
    Customer insertCustomer(Customer customer) throws CustomerAlreadyExsistException;
}

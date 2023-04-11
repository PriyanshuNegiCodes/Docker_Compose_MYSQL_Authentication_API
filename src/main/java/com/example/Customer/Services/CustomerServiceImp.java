package com.example.Customer.Services;

import com.example.Customer.Domain.Customer;
import com.example.Customer.Exception.CustomerAlreadyExsistException;
import com.example.Customer.Exception.CustomerNotFoundException;
import com.example.Customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

//    @Override
//    public boolean deleteCustomerById(String customerName) throws CustomerNotFoundException {
//        if(customerRepository.findById(customerName).isEmpty()){
//            throw new CustomerNotFoundException();
//        }else {
//            customerRepository.deleteById(customerName);
//            return true;
//        }
//    }

    @Override
    public Customer checkLogin(Customer customer) {
        return customerRepository.findByCustomerNameAndCustomerPassword(customer.getCustomerName(), customer.getCustomerPassword());
    }

    @Override
    public Customer insertCustomer(Customer customer) throws CustomerAlreadyExsistException {
        if(customerRepository.findById(customer.getCustomerName()).isEmpty()){
            return customerRepository.save(customer);
        }else{
            throw new CustomerAlreadyExsistException();
        }
    }
}

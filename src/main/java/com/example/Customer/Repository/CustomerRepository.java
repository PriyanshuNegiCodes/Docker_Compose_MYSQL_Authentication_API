package com.example.Customer.Repository;

import com.example.Customer.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, String> {
    Customer findByCustomerNameAndCustomerPassword(String customerName, String customerPassword);
}

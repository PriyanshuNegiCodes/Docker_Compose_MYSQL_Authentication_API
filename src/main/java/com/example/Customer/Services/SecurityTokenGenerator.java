package com.example.Customer.Services;

import com.example.Customer.Domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(Customer customer);
}

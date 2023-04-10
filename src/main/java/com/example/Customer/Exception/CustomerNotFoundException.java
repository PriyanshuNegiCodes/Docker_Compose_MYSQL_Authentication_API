package com.example.Customer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Customer not found exception")

public class CustomerNotFoundException extends Exception{
}

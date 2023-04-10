package com.example.Customer.Controller;

import com.example.Customer.Domain.Customer;
import com.example.Customer.Exception.CustomerAlreadyExsistException;
import com.example.Customer.Exception.CustomerNotFoundException;
import com.example.Customer.Services.CustomerService;
import com.example.Customer.Services.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    SecurityTokenGenerator securityTokenGenerator;

    //http.localhost:4444/api/customer/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) throws CustomerAlreadyExsistException {
        return new ResponseEntity<>(customerService.insertCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer customer){
        Customer recivedCustomer =customerService.checkLogin(customer);
        if(recivedCustomer!=null){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(customer), HttpStatus.OK);
        } else{
            return new ResponseEntity<>("The Authentication was failed", HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{customerName}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerName) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.deleteCustomerById(customerName), HttpStatus.OK);
    }
}

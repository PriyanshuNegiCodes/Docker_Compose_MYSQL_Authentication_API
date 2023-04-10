package com.example.Customer.Services;

import com.example.Customer.Domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImp implements SecurityTokenGenerator{


    @Override
    public Map<String, String> generateToken(Customer customer) {
        Map<String, String> result=new HashMap<>();
        Map<String, Object> userData=new HashMap<>();
        userData.put("customerName", customer.getCustomerName());
        userData.put("customerPassword", customer.getCustomerPassword());
        String myToken = Jwts.builder().setClaims(userData)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "SecretKey")
                .compact();
        result.put("Token", myToken);
        result.put("Message", "Customer loggedIn Successfully");
        return result;
    }
}

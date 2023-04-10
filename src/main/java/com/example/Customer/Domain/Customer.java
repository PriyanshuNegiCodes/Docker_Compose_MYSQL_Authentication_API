package com.example.Customer.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data

@ToString
@Entity
public class Customer {
    private int customerId;
    @Id
    private String customerName;
    private long customerPhoneNumber;
    private String customerPassword;
}

//{
//    "customerId":1,
//    "customerName":"Priyanshu",
//    "customerPhoneNumber":123457,
//    "customerPassword":"HiiPwd"
//}


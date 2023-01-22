package com.example.demo.service;

import com.example.demo.model.Customer;

public interface CustomerService {
 void createCustomer(Customer customer)   ;
 void updateCustomer(long id,Customer customer);
 void deleteCustomer(long id);
 Customer readCustomer(long id);
}

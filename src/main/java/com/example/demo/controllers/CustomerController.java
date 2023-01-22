package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/customers")

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping(value="/customers")
    void createCustomer(@RequestBody Customer customer){
     customerService.createCustomer(customer);
    }
    @PutMapping(value="/customers/{id}")
    void updateCustomer(@PathVariable(name="id") int id, @RequestBody Customer customer){
     customerService.updateCustomer(id,customer);
    }
    @DeleteMapping(value="/customers/{id}")
    void deleteCustomer(@PathVariable(name="id" )int id){
        customerService.deleteCustomer(id);
    }
    @GetMapping(value="/customers/{id}")
    Customer readCustomer(@PathVariable(name="id")int id){
        return customerService.readCustomer(id) ;
    }
    }


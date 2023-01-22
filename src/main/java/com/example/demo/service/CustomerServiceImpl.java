package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
   private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer) ;
    }

    @Override
    public void updateCustomer(long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
                customerRepository.save(customer);
            }
        }

    @Override
    public void deleteCustomer(long id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }

    }

    @Override
    public Customer readCustomer(long id) {
        return customerRepository.findById(id).orElse(null);
    }
}

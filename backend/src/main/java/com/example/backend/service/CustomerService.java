package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Customer;
import com.example.backend.repository.CustomerRepository;
import java.util.List;


@Service
public class CustomerService{

   @Autowired
    private CustomerRepository customerRepository;

    public boolean postLead(Customer customer) {
        this.customerRepository.save(customer);
        return true;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
    public Customer getCustomerById(long id){
        return this.customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer not found"));
    }
    public void updateLeadById(long id,Customer customer){
        Customer updateCustomer=customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer not found"));
        updateCustomer.setName(customer.getName());
        updateCustomer.setEmail(customer.getEmail());
        updateCustomer.setPhone(customer.getPhone());
        updateCustomer.setAddress(customer.getAddress());
        updateCustomer.setCommunicationHistory(customer.getCommunicationHistory());
        updateCustomer.setPurchaseHistory(customer.getPurchaseHistory());
        this.customerRepository.save(updateCustomer);
    }
    public void deleteLeadById(long id) {
        this.customerRepository.deleteById(id);

    }
}
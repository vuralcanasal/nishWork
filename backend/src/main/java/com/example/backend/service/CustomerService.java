package com.example.backend.service;

import com.example.backend.entity.Customer;
import com.example.backend.entity.Document;
import com.example.backend.repository.CustomerRepository;
import com.example.backend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    @Autowired
    DocumentRepository documentRepository;

    public Customer addCustomer(Customer customer){
        return repository.save(customer);
    }

    public List<Customer> addCustomers(List<Customer> customers){
        return repository.saveAll(customers);
    }

    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = repository.findById(customer.getId()).orElse(null);
        if(existingCustomer.equals(null))
            return  null;
        existingCustomer.setName(customer.getName());
        existingCustomer.setSurname(customer.getSurname());
        existingCustomer.setEmail(customer.getEmail());
        return repository.save(existingCustomer);
    }

    public String deleteCustomerById(int id){
        List<Integer>documentIds = documentRepository.findByCustomerId(id);
        for (int documentId : documentIds) {
            documentRepository.deleteById(documentId);
        }
        repository.deleteById(id);
        return "The customer with id: " + id + " was deleted!!";
    }
}

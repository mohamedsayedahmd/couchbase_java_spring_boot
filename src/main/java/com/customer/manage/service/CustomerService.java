package com.customer.manage.service;

import com.customer.manage.model.Customer;
import com.customer.manage.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public void intCustomerRepo(){
        repo.saveAll(Stream.of(
                new Customer(111,"John",new String[]{ "Banglore","mar"}),
                    new Customer(222,"bshar",new String[]{ "sakhnin","aa"}))
                .collect(Collectors.toList()));
    }
    public Iterable<Customer> getAllCustomers(){
        return repo.findAll();
    }
    public void save1(Customer c){
        repo.save(c);
    }


}

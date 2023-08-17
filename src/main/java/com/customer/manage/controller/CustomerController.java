package com.customer.manage.controller;

import com.customer.manage.model.Customer;
import com.customer.manage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody Customer customer){
        customerService.save1(customer);
        return "Customer saved successfully!";
    }
    @GetMapping("/fetchAllCustomers")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Customer> getAll(){
        return customerService.getAllCustomers();
    }
}

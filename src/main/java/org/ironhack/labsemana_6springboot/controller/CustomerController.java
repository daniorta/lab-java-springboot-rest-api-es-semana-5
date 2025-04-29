package org.ironhack.labsemana_6springboot.controller;

import org.ironhack.labsemana_6springboot.model.Customer;
import org.ironhack.labsemana_6springboot.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public Customer newCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }



}

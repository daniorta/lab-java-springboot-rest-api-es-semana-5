package org.ironhack.labsemana_6springboot.service;

import org.ironhack.labsemana_6springboot.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    List<Customer> customerList = new ArrayList<>();

//Crea un nuevo cliente con validación
    public  Customer createCustomer(Customer customer){
       customerList.add(customer);
       return customer;
    }

    //listar todos los clientes con validación
        public List<Customer> getAllCustomer(){
            return customerList;
        }



}

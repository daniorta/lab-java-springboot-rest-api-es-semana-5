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

    //Buscar cliente por email
    public Customer getCustomerEmail(String email){
        for(Customer customerEmail : customerList){
            if(customerEmail.getEmail().equalsIgnoreCase(email)){
                return customerEmail;
            }
        }
        return null;
    }

    //Actualiza un cliente
    public Customer updateCustomer(String email, Customer customer){
        //LLamamos al metodo que busca por email
           Customer newCustomerEmail = getCustomerEmail(email);

           if(newCustomerEmail != null && !newCustomerEmail.getEmail().isEmpty()){//Si el email es null
                newCustomerEmail.setName(customer.getName());
                newCustomerEmail.setEmail(customer.getEmail());
                newCustomerEmail.setAge(customer.getAge());
                newCustomerEmail.setAddress(customer.getAddress());
           }
        return newCustomerEmail;
    }

    //Eliminar cliente
    public void removeCustomer(String email){

        for(int i = 0; i < customerList.size();i++){
            Customer customer = customerList.get(i);

            if(customer.getEmail().equalsIgnoreCase(email)){
                customerList.remove(i);
                break;
            }
        }
    }


}

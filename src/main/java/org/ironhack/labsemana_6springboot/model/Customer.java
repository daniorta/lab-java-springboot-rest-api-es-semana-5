package org.ironhack.labsemana_6springboot.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public class Customer {
    //Asegurar que el nombre no esté vacío.
    @NotBlank
    private String name;

    //Verificar que el email tenga un formato válido.
    @Email
    private String email;

    //Garantizar que la edad mínima sea de 18 años
    @Min(18)
    private Integer age;

    //Validar que la dirección no esté vacía.
    @NotBlank
    private String address;

    public Customer(String name, String email, Integer age, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

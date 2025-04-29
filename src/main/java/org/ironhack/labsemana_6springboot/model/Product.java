package org.ironhack.labsemana_6springboot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Product {

    //Validar que el nombre no esté vacío y tenga una longitud mínima.
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min=3,message= "El nombre debe tener al menos 3 caracteres." )
    private String name;

    //Asegurar que el precio sea un número positivo.
    @Positive(message = "El número debe ser positivo.")
    private Integer price;

    //Verificar que la categoría no esté vacía.
    @NotBlank(message = "La category no puede estar vacío.")
    private String category;

    //Garantizar que la cantidad sea un número válido y positivo.
    @NotNull(message = "La quantity debe ser un número válido.")
    @Positive(message = "La quantity debe ser un número positivo.")
    private int quantity;

    public Product(String name, Integer price, String category, double quantity){
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

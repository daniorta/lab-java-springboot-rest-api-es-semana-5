package org.ironhack.labsemana_6springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)//No es necesari9 con nuestra exeptionHandler
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super("Producto con nombre " + name + ", no encontrado.");
    }
}

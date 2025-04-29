package org.ironhack.labsemana_6springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

//Se encarga de manejar las excepciones en mi aplicación
@RestControllerAdvice//para decirle que escuche al Rest Controller y a las excepciones
public class GlobalExceptionHandler {

    //ERROR DE VALIDACIÓN al crear u producto
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handlerValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    //Falta del encabezado en la API-KEY
    @ExceptionHandler(MissingApiKeyException.class)
    public ResponseEntity<String> handleMissingApiKey(MissingApiKeyException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }




    //PRODUCTO NO ENCONTRADO
    //Metodo que me devuelve HTTP 404 + mensaje cuando no encuentra el producto
    //cada vez que lanzamos un metodo para recuperar una exception: @ExceptionHandler
    @ExceptionHandler//Métodos dentro del Handler que indican QUÉ hacer cuando se lanza X exception
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());//llama al super de ProductNotFoundException: super("Producto con nombre " + name + ", no encontrado.");
    }

    //Rango de precios inválido → Maneja solicitudes con valores incorrectos.
    @ExceptionHandler(InvalidPriceRangeException.class)
    public ResponseEntity<String> handleInvalidPriceRange(InvalidPriceRangeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}

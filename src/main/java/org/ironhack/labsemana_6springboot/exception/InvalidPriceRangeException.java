package org.ironhack.labsemana_6springboot.exception;

public class InvalidPriceRangeException extends RuntimeException {
    public InvalidPriceRangeException() {
        super("The price is invalid.");
    }
}

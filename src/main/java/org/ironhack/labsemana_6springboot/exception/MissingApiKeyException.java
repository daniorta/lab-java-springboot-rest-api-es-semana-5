package org.ironhack.labsemana_6springboot.exception;

public class MissingApiKeyException extends RuntimeException {
    public MissingApiKeyException() {

        super("API-KEY header is missing");
    }
}

package org.example.Exceptions;

public class WrongTypeException extends RuntimeException {
    public WrongTypeException(String message) {
        super(message);
    }
}

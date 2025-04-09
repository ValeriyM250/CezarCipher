package org.example.Exceptions;

public class WrongActionException extends RuntimeException {
    public WrongActionException(String message) {
        super(message);
    }
}
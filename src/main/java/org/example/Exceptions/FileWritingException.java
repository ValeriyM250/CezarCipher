package org.example.Exceptions;

public class FileWritingException extends RuntimeException {
    public FileWritingException(String message) {
        super(message);
    }
}

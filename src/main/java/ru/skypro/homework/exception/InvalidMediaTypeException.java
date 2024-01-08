package ru.skypro.homework.exception;

public class InvalidMediaTypeException extends RuntimeException{
    public InvalidMediaTypeException() {
    }

    public InvalidMediaTypeException(String message) {
        super(message);
    }

    public InvalidMediaTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMediaTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidMediaTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

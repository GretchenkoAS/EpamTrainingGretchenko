package com.nyha.task3shape.exeption;

public class ShapeException extends Exception{
    public ShapeException() {
    }

    public ShapeException(String message) {
        super(message);
    }

    public ShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeException(Throwable cause) {
        super(cause);
    }
}
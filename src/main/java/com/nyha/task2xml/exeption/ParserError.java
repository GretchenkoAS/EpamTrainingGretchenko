package com.nyha.task2xml.exeption;

public class ParserError extends Exception {
    public ParserError() {
    }

    public ParserError(String message) {
        super(message);
    }

    public ParserError(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserError(Throwable cause) {
        super(cause);
    }
}

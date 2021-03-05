package com.nyha.task4.composite;

public enum CompositeType {
    TEXT("\r\n", 2), PARAGRAPH(" ", 1), SENTENCE(" ", 1), LEXEME("", 0);

    private final String delimiter;
    private final int cutLength;

    CompositeType(String childDelimiter, int cutLength) {
        this.delimiter = childDelimiter;
        this.cutLength = cutLength;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public int getCutLength() {
        return cutLength;
    }
}

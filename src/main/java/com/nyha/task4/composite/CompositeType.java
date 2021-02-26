package com.nyha.task4.composite;

public enum CompositeType {
    TEXT("\r\n", 2), PARAGRAPH(" ", 1), SENTENCE(" ", 1), LEXEME("", 0);

    private final String childDelimiter;
    private final int cutLength;

    CompositeType(String childDelimiter, int cutLength) {
        this.childDelimiter = childDelimiter;
        this.cutLength = cutLength;
    }

    public String getChildDelimiter() {
        return childDelimiter;
    }

    public int getCutLength() {
        return cutLength;
    }
}

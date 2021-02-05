package com.nyha.task2xml.entity;

import java.util.Arrays;
import java.util.Optional;

public enum PaperType {
    NEWSPAPERS("newspapers"),
    BOOKLET("booklet"),
    MAGAZINE("magazine");

    private String type;

    PaperType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Optional<PaperType> getTypeByValue(String value) {
        return Arrays.stream(PaperType.values()).
                filter(o -> o.getType().equals(value)).findAny();
    }
}

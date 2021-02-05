package com.nyha.task2xml.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Assigment {
    FASHION("fashion"),
    CULINARY("culinary"),
    FOR_KIDS("for-kids"),
    NEWS("news"),
    HOME_TIPS("home-tips");

    private String type;

    Assigment(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Optional<Assigment> getTypeByValue(String value) {
        return Arrays.stream(Assigment.values()).
                filter(o -> o.getType().equals(value)).findAny();
    }
}

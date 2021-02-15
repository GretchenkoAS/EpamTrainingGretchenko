package com.nyha.task3shape.util;

public class IdGenerator {
    private static int id;

    private IdGenerator() {
    }

    public static int generateId(){
        return ++id;
    }
}
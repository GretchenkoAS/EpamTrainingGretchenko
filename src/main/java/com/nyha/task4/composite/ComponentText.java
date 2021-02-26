package com.nyha.task4.composite;

public interface ComponentText {
    void add(ComponentText component);
    void remove(ComponentText component);
    int countSymbol();
}

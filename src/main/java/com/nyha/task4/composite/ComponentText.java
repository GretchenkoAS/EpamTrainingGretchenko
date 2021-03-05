package com.nyha.task4.composite;

import java.util.List;

public interface ComponentText {
    void add(ComponentText component);
    void remove(ComponentText component);
    List<ComponentText> getComponents();
    int countSymbol();
}

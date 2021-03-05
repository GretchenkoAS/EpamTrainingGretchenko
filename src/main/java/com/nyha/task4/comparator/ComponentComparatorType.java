package com.nyha.task4.comparator;

import com.nyha.task4.composite.ComponentText;
import com.nyha.task4.composite.CompositeText;

import java.util.Comparator;

public enum ComponentComparatorType {
    COMPONENT_NUMBER((o1, o2) -> ((CompositeText)o1).componentNumber() - ((CompositeText)o2).componentNumber());

    private final Comparator<ComponentText> comparator;

    ComponentComparatorType(Comparator<ComponentText> comparator) {
        this.comparator = comparator;
    }

    public Comparator<ComponentText> getComparator() {
        return comparator;
    }
}

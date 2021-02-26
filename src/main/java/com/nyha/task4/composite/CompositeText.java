package com.nyha.task4.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements ComponentText{
    private final CompositeType type;
    private final List<ComponentText> components = new ArrayList<>();

    public CompositeText(CompositeType type) {
        this.type = type;
    }

    public CompositeType getType() {
        return type;
    }

    @Override
    public void add(ComponentText component) {
        components.add(component);
    }

    @Override
    public void remove(ComponentText component) {
        components.remove(component);
    }

    @Override
    public int countSymbol() {
        int counter = 0;
        for (ComponentText component : this.components) {
            counter += component.countSymbol();
        }
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompositeText compositeText = (CompositeText) o;
        if (type != compositeText.type) {
            return false;
        }
        return components.equals(compositeText.components);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = type.hashCode();
        result = prime * result + components.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String delimiter = type.getChildDelimiter();
        int cutLength = type.getCutLength();
        for (ComponentText component : components) {
            String childText = String.join(delimiter, component.toString());
            builder.append(childText).append(delimiter);
        }
        builder.delete(builder.length() - cutLength, builder.length());
        return builder.toString();
    }
}

package com.nyha.task3shape.repository.impl;

import com.nyha.task3shape.entity.Shape;
import com.nyha.task3shape.repository.Specification;

public class IdSpecification implements Specification<Shape> {
    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Shape shape) {
        boolean result = shape.getId() == id;
        return result;
    }
}

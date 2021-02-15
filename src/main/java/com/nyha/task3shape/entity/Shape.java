package com.nyha.task3shape.entity;

import com.nyha.task3shape.util.IdGenerator;

public abstract class Shape {
    private int id;
    public Shape() {
        id = IdGenerator.generateId();
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shape shape = (Shape) o;
        if (shape.id != id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        return sb.toString();
    }
}
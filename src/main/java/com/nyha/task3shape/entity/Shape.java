package com.nyha.task3shape.entity;

import com.nyha.task3shape.util.IdGenerator;

import java.util.UUID;

public abstract class Shape {
    private UUID id;
    public Shape() {
        id = IdGenerator.generateId();
    }
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Shape shape = (Shape) obj;
        if (shape.id != id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        return sb.toString();
    }
}
package com.nyha.task3shape.repository;

import com.nyha.task3shape.entity.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class ShapeRepository {
    private List<Shape> shapes;

    public ShapeRepository() {
        shapes  = new ArrayList<>();
    }

    public List<Shape> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public Shape get(int index) {
        return shapes.get(index);
    }

    public Shape set(int index, Shape element) {
        return shapes.set(index, element);
    }

    public List<Shape> query(Specification<Shape> specification) {
        List<Shape> list = shapes.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return list;
    }

    public List<Shape> sort(Comparator<Shape> type) {
        List<Shape> sortedList = shapes.stream().sorted(type).collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ShapeRepository\n");
        sb.append(shapes);
        return sb.toString();
    }
}

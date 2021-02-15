package com.nyha.task3shape.factory;

import com.nyha.task3shape.entity.Shape;
import com.nyha.task3shape.exeption.ShapeException;

import java.util.List;

public abstract class BaseFactory {
    public abstract Shape getInstance(List<Integer> coordinates) throws ShapeException;
}

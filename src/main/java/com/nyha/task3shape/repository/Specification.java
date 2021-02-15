package com.nyha.task3shape.repository;

import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.Shape;

public interface Specification <T extends Shape>{
    boolean specify(T t);
}

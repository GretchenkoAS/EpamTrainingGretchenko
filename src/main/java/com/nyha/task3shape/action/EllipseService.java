package com.nyha.task3shape.action;

import com.nyha.task3shape.entity.Ellipse;

public interface EllipseService {
    double calculatePerimeter(Ellipse ellipse);
    double calculateSquare(Ellipse ellipse);
    boolean isCrossOx(Ellipse ellipse);
    boolean isCrossOy(Ellipse ellipse);
    boolean isCircle(Ellipse ellipse);
}
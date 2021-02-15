package com.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.EllipseRecorder;
import com.nyha.task3shape.entity.EllipseWareHouse;
import com.nyha.task3shape.repository.Specification;

public class SquareBetweenEllipseSpecification implements Specification<Ellipse> {
    private double from;
    private double to;

    public SquareBetweenEllipseSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();
        EllipseRecorder ellipseRecorder = wareHouse.getData(ellipse.getId());
        double square = ellipseRecorder.getSquare();
        boolean result = square >= from && square <= to;
        return result;
    }
}

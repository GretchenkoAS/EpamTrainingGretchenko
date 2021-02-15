package com.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.EllipseRecorder;
import com.nyha.task3shape.entity.EllipseWareHouse;
import com.nyha.task3shape.repository.Specification;

public class PerimeterBetweenEllipseSpecification implements Specification<Ellipse> {
    private double from;
    private double to;

    public PerimeterBetweenEllipseSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();
        EllipseRecorder ellipseRecorder = wareHouse.getData(ellipse.getId());
        double perimeter = ellipseRecorder.getPerimeter();
        boolean result = perimeter >= from && perimeter <= to;
        return result;
    }
}

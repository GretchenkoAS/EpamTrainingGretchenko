package com.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.action.impl.EllipseServiceImpl;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.Specification;

public class CrossOyEllipseSpecification implements Specification<Ellipse> {
    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseServiceImpl service = new EllipseServiceImpl();
        boolean result = service.isCrossOy(ellipse);
        return result;
    }
}

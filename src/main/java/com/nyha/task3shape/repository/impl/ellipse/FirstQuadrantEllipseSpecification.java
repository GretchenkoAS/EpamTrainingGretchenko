package com.nyha.task3shape.repository.impl.ellipse;

import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.repository.Specification;

public class FirstQuadrantEllipseSpecification implements Specification<Ellipse> {
    @Override
    public boolean specify(Ellipse ellipse) {
        boolean result = ellipse.getBeginPoint().getX() > 0 &&
                ellipse.getEndPoint().getY() > 0;
        return result;
    }
}

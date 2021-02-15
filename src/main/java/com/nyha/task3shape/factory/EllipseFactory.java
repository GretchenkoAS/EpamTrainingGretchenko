package com.nyha.task3shape.factory;

import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.CustomPoint2d;
import com.nyha.task3shape.exeption.ShapeException;
import com.nyha.task3shape.validator.PointValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EllipseFactory extends BaseFactory{
    static Logger logger = LogManager.getLogger();

    @Override
    public Ellipse getInstance(List<Integer> coordinates) throws ShapeException {
        CustomPoint2d beginPoint = new CustomPoint2d(coordinates.get(0), coordinates.get(1));
        CustomPoint2d endPoint = new CustomPoint2d(coordinates.get(2), coordinates.get(3));
        PointValidator pointValidator = new PointValidator();
        if(!pointValidator.isPointsFromEllipse(beginPoint, endPoint)){
            logger.error("Incorrect point values");
            throw new ShapeException("Incorrect point values");
        }
        Ellipse ellipse = new Ellipse(beginPoint, endPoint);
        logger.info("Ellipse was creating successful.");
        return ellipse;
    }
}

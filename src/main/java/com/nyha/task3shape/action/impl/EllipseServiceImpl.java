package com.nyha.task3shape.action.impl;

import com.nyha.task3shape.action.EllipseService;
import com.nyha.task3shape.entity.Ellipse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseServiceImpl implements EllipseService {
    static Logger logger = LogManager.getLogger();

    @Override
    public double calculatePerimeter(Ellipse ellipse) {
        double perimeter = 2 * Math.PI *
                Math.sqrt((Math.pow((double)(ellipse.getEndPoint().getX()
                        - ellipse.getBeginPoint().getX()) / 2, 2)
                        + Math.pow((double)(ellipse.getEndPoint().getY()
                        - ellipse.getBeginPoint().getY()) / 2, 2)) / 2);
        logger.debug("Perimeter calculated: " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateSquare(Ellipse ellipse) {
        double square = Math.PI
                * Math.abs((double)(ellipse.getEndPoint().getX()
                - ellipse.getBeginPoint().getX()) / 2)
                * Math.abs((double)(ellipse.getEndPoint().getY()
                - ellipse.getBeginPoint().getY()) / 2);
        logger.debug("Square calculated: " + square);
        return square;
    }

    @Override
    public boolean isCrossOx(Ellipse ellipse) {
        boolean result = (ellipse.getBeginPoint().getY() >= 0
                && ellipse.getEndPoint().getY() <= 0)
                || (ellipse.getBeginPoint().getY() <= 0
                && ellipse.getEndPoint().getY() >= 0);
        return result;
    }

    @Override
    public boolean isCrossOy(Ellipse ellipse) {
        boolean result = (ellipse.getBeginPoint().getX() >= 0
                && ellipse.getEndPoint().getX() <= 0)
                || (ellipse.getBeginPoint().getX() <= 0
                && ellipse.getEndPoint().getX() >= 0);
        return result;
    }

    @Override
    public boolean isCircle(Ellipse ellipse) {
        boolean result = Math.abs(ellipse.getEndPoint().getX()
                - ellipse.getBeginPoint().getX())
                == Math.abs(ellipse.getEndPoint().getY()
                - ellipse.getBeginPoint().getY());
        return result;
    }
}

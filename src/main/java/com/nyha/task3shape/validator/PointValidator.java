package com.nyha.task3shape.validator;

import com.nyha.task3shape.entity.CustomPoint2d;

public class PointValidator {
    private static final int MAX_COORDINATE = 1000;
    private static final int MIN_COORDINATE = -1000;

    public static boolean isPointsFromEllipse(CustomPoint2d beginPoint, CustomPoint2d endPoint){
        boolean result = validateValuesPoint(beginPoint) && validateValuesPoint(endPoint);
        if (beginPoint.getX() == endPoint.getX()
                || beginPoint.getY() == endPoint.getY()){
            result = false;
        }
        return result;
    }

    private static boolean validateValuesPoint(CustomPoint2d point) {
        boolean result = validateValue(point.getX()) && validateValue(point.getY());
        return result;
    }

    private static boolean validateValue(int value) {
        return value < MAX_COORDINATE && value > MIN_COORDINATE;
    }
}

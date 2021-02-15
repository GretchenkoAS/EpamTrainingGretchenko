package com.nyha.task3shape.comparator;

import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.EllipseWareHouse;
import com.nyha.task3shape.entity.Shape;

import java.util.Comparator;

public enum EllipseComparatorType {
    ID((ellipse1, ellipse2) ->  ellipse1.getId() - ellipse2.getId()),
    BEGIN_POINT_X((ellipse1, ellipse2) -> ((Ellipse)ellipse1).getBeginPoint().getX() -
            ((Ellipse)ellipse2).getBeginPoint().getX()),
    BEGIN_POINT_Y((ellipse1, ellipse2) -> ((Ellipse)ellipse1).getBeginPoint().getY() -
            ((Ellipse)ellipse2).getBeginPoint().getY()),
    END_POINT_X((ellipse1, ellipse2) -> ((Ellipse)ellipse1).getEndPoint().getX() -
            ((Ellipse)ellipse2).getEndPoint().getX()),
    END_POINT_Y((ellipse1, ellipse2) -> ((Ellipse)ellipse1).getEndPoint().getY() -
            ((Ellipse)ellipse2).getEndPoint().getY()),
    PERIMETER((ellipse1, ellipse2) -> Double.compare(EllipseWareHouse.getInstance().
                    getData(ellipse1.getId()).getPerimeter(),
            EllipseWareHouse.getInstance().getData(ellipse2.getId()).getPerimeter())),
    SQUARE((ellipse1, ellipse2) -> Double.compare(EllipseWareHouse.getInstance().
                    getData(ellipse1.getId()).getSquare(),
            EllipseWareHouse.getInstance().getData(ellipse2.getId()).getSquare()));

    private final Comparator<Shape> comparator;

    EllipseComparatorType(Comparator<Shape> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Shape> getComparator() {
        return comparator;
    }
}

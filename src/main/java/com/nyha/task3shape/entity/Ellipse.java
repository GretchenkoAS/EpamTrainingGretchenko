package com.nyha.task3shape.entity;

import com.nyha.task3shape.exeption.ShapeException;

public class Ellipse extends Shape{
    private Point2d beginPoint;
    private Point2d endPoint;

    public Ellipse(Point2d beginPoint, Point2d endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point2d getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(Point2d beginPoint) throws ShapeException {
        if (beginPoint == null){
            throw new ShapeException("Point is null");
        }
        this.beginPoint = beginPoint;
    }

    public Point2d getEndPoint() {
        return endPoint;
    }

    public void setEndPointPoint(Point2d endPoint) throws ShapeException {
        if (endPoint == null){
            throw new ShapeException("Point is null");
        }
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ellipse ellipse = (Ellipse) obj;
        if (beginPoint == null) {
            if (ellipse.beginPoint != null) {
                return false;
            }
        } else if (!beginPoint.equals(ellipse.beginPoint)) {
            return false;
        }
        if (endPoint == null) {
            if (ellipse.endPoint != null) {
                return false;
            }
        } else if (!endPoint.equals(ellipse.endPoint)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((beginPoint != null) ? beginPoint.hashCode() : 0);
        result = prime * result + ((endPoint != null) ? endPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ellipse{");
        sb.append("Begin ").append(beginPoint);
        sb.append(", End ").append(endPoint);
        sb.append('}');
        return sb.toString();
    }
}

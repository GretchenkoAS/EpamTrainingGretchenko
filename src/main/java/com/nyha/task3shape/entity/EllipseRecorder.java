package com.nyha.task3shape.entity;

public class EllipseRecorder {
    private double perimeter;
    private double square;

    public EllipseRecorder(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EllipseRecorder that = (EllipseRecorder) o;

        if (Double.compare(that.perimeter, perimeter) != 0) {
            return false;
        }
        return Double.compare(that.square, square) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)perimeter ;
        result = prime * result + (int)square ;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("perimeter: ").append(perimeter);
        sb.append(", square: ").append(square);
        return sb.toString();
    }
}

package com.nyha.task3shape.entity;

public class CustomPoint2d {
    private int x;
    private int y;

    public CustomPoint2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomPoint2d customPoint2D = (CustomPoint2d) o;

        if (customPoint2D.x != x) {
            return false;
        }
        if (customPoint2D.y != y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("point{");
        sb.append("x= ").append(x);
        sb.append(", y= ").append(y);
        sb.append('}');
        return sb.toString();
    }
}
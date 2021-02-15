package com.nyha.task3shape.entity;

import com.nyha.task3shape.exeption.ShapeException;
import com.nyha.task3shape.observer.EllipseEvent;
import com.nyha.task3shape.observer.ObservableEllipse;
import com.nyha.task3shape.observer.ObserverEllipse;
import com.nyha.task3shape.observer.impl.EllipseObserver;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends Shape implements ObservableEllipse {
    private List<ObserverEllipse> observers;
    private CustomPoint2d beginPoint;
    private CustomPoint2d endPoint;

    public Ellipse(CustomPoint2d beginPoint, CustomPoint2d endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        observers = new ArrayList<>();
        this.attach(new EllipseObserver());
        notifyObservers();
    }

    public CustomPoint2d getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(CustomPoint2d beginPoint) throws ShapeException {
        if (beginPoint == null){
            throw new ShapeException("Point is null");
        }
        this.beginPoint = beginPoint;
        notifyObservers();

    }

    public CustomPoint2d getEndPoint() {
        return endPoint;
    }

    public void setEndPointPoint(CustomPoint2d endPoint) throws ShapeException {
        if (endPoint == null){
            throw new ShapeException("Point is null");
        }
        this.endPoint = endPoint;
        notifyObservers();
    }

    @Override
    public void attach(ObserverEllipse observer) {
        if(observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(ObserverEllipse observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        EllipseEvent event = new EllipseEvent(this);
        observers.forEach(observer -> observer.parameterChanged(event));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ellipse ellipse = (Ellipse) o;
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

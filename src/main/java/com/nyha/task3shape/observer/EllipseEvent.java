package com.nyha.task3shape.observer;

import com.nyha.task3shape.entity.Ellipse;

import java.util.EventObject;

public class EllipseEvent extends EventObject {

    public EllipseEvent(Ellipse inputSource) {
        super(inputSource);
    }

    public Ellipse getSource() {
        return (Ellipse) super.getSource();
    }
}
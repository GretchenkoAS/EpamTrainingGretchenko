package com.nyha.task3shape.observer.impl;

import com.nyha.task3shape.action.impl.EllipseServiceImpl;
import com.nyha.task3shape.entity.Ellipse;
import com.nyha.task3shape.entity.EllipseRecorder;
import com.nyha.task3shape.entity.EllipseWareHouse;
import com.nyha.task3shape.observer.EllipseEvent;
import com.nyha.task3shape.observer.ObserverEllipse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseObserver implements ObserverEllipse {
    static Logger logger = LogManager.getLogger();

    @Override
    public void parameterChanged(EllipseEvent event) {
        Ellipse ellipse = event.getSource();
        EllipseServiceImpl service = new EllipseServiceImpl();
        EllipseWareHouse wareHouse = EllipseWareHouse.getInstance();

        double currentPerimeter = service.calculatePerimeter(ellipse);
        double currentSquare = service.calculateSquare(ellipse);

        EllipseRecorder recorder = wareHouse.getData(ellipse.getId());
        if (recorder == null) {
            recorder = new EllipseRecorder(currentPerimeter, currentSquare);
        } else {
            recorder.setPerimeter(currentPerimeter);
            recorder.setSquare(currentSquare);
        }
        wareHouse.add(ellipse.getId(), recorder);
        logger.debug("Data was updated.");
    }
}

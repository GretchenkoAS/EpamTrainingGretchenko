package com.nyha.task3shape.observer;

public interface ObservableEllipse {
    void attach(ObserverEllipse observer);

    void detach(ObserverEllipse observer);

    void notifyObservers();
}

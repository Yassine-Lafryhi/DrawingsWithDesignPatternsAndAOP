package com.drawings.with.design.patterns.and.aop.classes;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
    double getEpaisseurDuContour();
    String getCouleurDuContour();
    String getCouleurDeRemplissage();
}

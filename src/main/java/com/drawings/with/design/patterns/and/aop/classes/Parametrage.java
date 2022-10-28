package com.drawings.with.design.patterns.and.aop.classes;

import java.util.ArrayList;
import java.util.List;

public class Parametrage implements Observable {
    List<Observer> observers = new ArrayList<>();
    double epaisseurDuContour;
    String couleurDuContour;
    String couleurDeRemplissage;

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public double getEpaisseurDuContour() {
        return epaisseurDuContour;
    }

    public String getCouleurDuContour() {
        return couleurDuContour;
    }

    public String getCouleurDeRemplissage() {
        return couleurDeRemplissage;
    }

    public void setEpaisseurDuContour(double epaisseurDuContour) {
        this.epaisseurDuContour = epaisseurDuContour;
        this.notifyObservers();
    }

    public void setCouleurDeRemplissage(String couleurDeRemplissage) {
        this.couleurDeRemplissage = couleurDeRemplissage;
        this.notifyObservers();
    }

    public void setCouleurDuContour(String couleurDuContour) {
        this.couleurDuContour = couleurDuContour;
        this.notifyObservers();
    }
}

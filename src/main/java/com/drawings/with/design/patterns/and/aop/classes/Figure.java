package com.drawings.with.design.patterns.and.aop.classes;

import java.io.Serializable;

public abstract class Figure implements Observer, Serializable {
    protected String nom;
    protected double epaisseurDuContour;
    protected String couleurDuContour;
    protected String couleurDeRemplissage;

    public Figure(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract void dessiner();

    public abstract double calculerSurface();

    public abstract double calculerPerimetre();

    public void setEpaisseurDuContour(double epaisseurDuContour) {
        this.epaisseurDuContour = epaisseurDuContour;
    }

    public void setCouleurDuContour(String couleurDuContour) {
        this.couleurDuContour = couleurDuContour;
    }

    public void setCouleurDeRemplissage(String couleurDeRemplissage) {
        this.couleurDeRemplissage = couleurDeRemplissage;
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

    @Override
    public void update(Observable observable) {
        String couleurDeRemplissage = observable.getCouleurDeRemplissage();
        String couleurDuContour = observable.getCouleurDuContour();
        double epaisseurDuContour = observable.getEpaisseurDuContour();

        this.setCouleurDeRemplissage(couleurDeRemplissage);
        this.setCouleurDuContour(couleurDuContour);
        this.setEpaisseurDuContour(epaisseurDuContour);
    }
}

package com.drawings.with.design.patterns.and.aop.classes;

public class Cercle extends Figure {
    private Point centre;
    private double rayon;

    public Cercle(String nom) {
        super(nom);
    }

    @Override
    public void dessiner() {
        System.out.println("Un cercle est dessiné avec la couleur du contour :" + this.getCouleurDuContour() + " et  la couleur de remplissage :" + this.getCouleurDeRemplissage()+
        " et l'épaisseur du contour :" + this.getEpaisseurDuContour());
    }

    @Override
    public double calculerSurface() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
}

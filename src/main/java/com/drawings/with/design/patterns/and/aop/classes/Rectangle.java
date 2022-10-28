package com.drawings.with.design.patterns.and.aop.classes;

public class Rectangle extends Figure {
    private Point coinSuperieurGauche;
    private double hauteur;
    private double largeur;

    public Rectangle(String nom) {
        super(nom);
    }

    public Point getCoinSuperieurGauche() {
        return coinSuperieurGauche;
    }

    public void setCoinSuperieurGauche(Point coinSuperieurGauche) {
        this.coinSuperieurGauche = coinSuperieurGauche;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    @Override
    public void dessiner() {
        System.out.println("Un cercle est dessiné avec la couleur du contour :" + this.getCouleurDuContour() + " et  la couleur de remplissage :" + this.getCouleurDeRemplissage()+
                " et l'épaisseur du contour :" + this.getEpaisseurDuContour());
    }

    @Override
    public double calculerSurface() {
        return largeur * hauteur;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * (largeur + hauteur);
    }
}

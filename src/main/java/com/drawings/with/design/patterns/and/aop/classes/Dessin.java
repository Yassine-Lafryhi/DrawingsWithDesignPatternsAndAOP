package com.drawings.with.design.patterns.and.aop.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dessin extends Figure {
    private List<Figure> figures = new ArrayList<>();

    public Dessin(String nom) {
        super(nom);
    }

    public Traitement traitement;

    @Override
    public void dessiner() {
        for (Figure figure : figures) {
            figure.dessiner();
        }
    }

    @Override
    public double calculerSurface() {
        double surface = 0;
        for (Figure figure : figures) {
            surface += figure.calculerSurface();
        }
        return surface;
    }

    @Override
    public double calculerPerimetre() {
        double perimetre = 0;
        for (Figure figure : figures) {
            perimetre += figure.calculerPerimetre();
        }
        return perimetre;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }

    public Traitement getTraitement() {
        return traitement;
    }

    public void ajouterFigure(Figure figure) {
        figures.add(figure);
    }

    public void supprimerFigure(Figure C) {
        figures.remove(C);
    }

    public List<Figure> getAllFigures() {
        return figures;
    }

    public void serialiser(String filePath) throws IOException {
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this.getAllFigures());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public void afficher() {
        System.out.println("Le dessin : " + this.getNom() + " contient les figures suivantes :");
        for (Figure figure : figures) {
            System.out.println("\tFigure : " + figure.getNom());
            System.out.print("\t\t");
            figure.dessiner();
        }
    }

}

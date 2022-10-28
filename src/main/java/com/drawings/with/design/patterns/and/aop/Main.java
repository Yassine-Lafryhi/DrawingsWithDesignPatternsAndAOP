package com.drawings.with.design.patterns.and.aop;

import com.drawings.with.design.patterns.and.aop.classes.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Dessin dessin1 = new Dessin("Dessin 1");

        Traitement traitement1 = new Traitement1();
        dessin1.setTraitement(traitement1);

        Cercle cercle1 = new Cercle("Cercle 1");
        cercle1.setCentre(new Point(1, 2));
        cercle1.setRayon(5);
        System.out.println("Surface du cercle 1 : " + cercle1.calculerSurface());
        System.out.println("Périmètre du cercle 1 : " + cercle1.calculerPerimetre());
        System.out.println();

        Cercle cercle2 = new Cercle("Cercle 2");
        cercle2.setCentre(new Point(8, 9.25));
        cercle2.setRayon(13);
        System.out.println("Surface du cercle 2 : " + cercle2.calculerSurface());
        System.out.println("Périmètre du cercle 2 : " + cercle2.calculerPerimetre());
        System.out.println();

        Rectangle rectangle1 = new Rectangle("Rectangle 1");
        rectangle1.setHauteur(5);
        rectangle1.setLargeur(2);
        rectangle1.setCoinSuperieurGauche(new Point(4.5, -3));
        System.out.println("Surface du rectangle 1 : " + rectangle1.calculerSurface());
        System.out.println("Périmètre du rectangle 1 : " + rectangle1.calculerPerimetre());
        System.out.println();

        dessin1.ajouterFigure(cercle1);
        dessin1.ajouterFigure(rectangle1);
        dessin1.ajouterFigure(cercle2);
        System.out.println("Surface du dessin 1 : " + dessin1.calculerSurface());
        System.out.println("Périmètre du dessin 1 : " + dessin1.calculerPerimetre());
        System.out.println();

        dessin1.getTraitement().traiter();
        dessin1.supprimerFigure(cercle2);

        Dessin dessin2 = new Dessin("Dessin 2");
        dessin2.ajouterFigure(dessin1);

        Traitement traitement2 = new Traitement2();
        dessin2.setTraitement(traitement2);
        dessin2.getTraitement().traiter();


        Parametrage parametrage1 = new Parametrage();
        parametrage1.setCouleurDeRemplissage("RED");
        parametrage1.setCouleurDuContour("PURPLE");
        parametrage1.setEpaisseurDuContour(4.25);
        parametrage1.subscribe(cercle1);
        parametrage1.subscribe(rectangle1);

        dessin1.afficher();
        System.out.println();

        parametrage1.unsubscribe(rectangle1);

        Parametrage parametrage2 = new Parametrage();
        parametrage2.setCouleurDeRemplissage("PINK");
        parametrage2.setCouleurDuContour("GREEN");
        parametrage2.setEpaisseurDuContour(1.25);
        parametrage2.subscribe(rectangle1);

        dessin2.afficher();

        dessin1.serialiser("files/dessin1.dat");

        dessin2.serialiser("files/dessin2.dat");
    }

}

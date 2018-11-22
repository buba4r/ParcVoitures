package main;

import java.util.ArrayList;

import visiteur.VisiteurVoiture;
import voiture.impl.Moteur;
import voiture.impl.Pneu;
import voiture.impl.Voiture;

public class Prog2 {

  /**
   * progamme main2
   * 
   * @param args
   */
  public static void main(String[] args) {

    Voiture voiture = new Voiture();
    voiture.setMarque("Audi");
    voiture.setModele("A3");

    Moteur moteur = new Moteur();
    moteur.setNumeroSerie(14021994);
    moteur.getNumeroSerie();

    Pneu pneu = new Pneu();
    pneu.setHauteur(2.3);
    pneu.setLargeur(2);
    pneu.setMarque("Michelin");
    voiture.getPneus().add(pneu);

    VisiteurVoiture visiteurVoiture = new VisiteurVoiture();
    voiture.applique(visiteurVoiture);

    // System.out.println(voiture.toString());

  }

}

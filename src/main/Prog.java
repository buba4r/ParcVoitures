package main;

import visiteur.VisiteurVoiture;
import voiture.factory.FactoryVoiture;
import voiture.impl.Voiture;

public class Prog {

  /**
   * programme Main.
   * 
   * @param args ..
   */
  public static void main(String[] args) {

    Voiture voiture = new Voiture();
    Voiture vehicule = new Voiture();

    
    FactoryVoiture vfac = new FactoryVoiture();
    Double hauteur = 2.5;

    voiture = vfac.creerVoiture("peugeot", "208", 345645, hauteur, 1.0, "Michelin", false);
    
    hauteur = 3.5;
    vehicule = vfac.creerVoiture("Audi", "A1", 4569745, hauteur, 1.0, "Continantale", true);

    VisiteurVoiture visiteur = new VisiteurVoiture();
    voiture.applique(visiteur);
    System.out.println();

    vehicule.applique(visiteur);
    System.out.println();

    System.out.println("le nombres Voitures créérs est de:  " + visiteur.nombreVoiture());
    

  }

}

package main;

import visiteur.VisiteurVoiture;
import voiture.factory.FactoryVoiture;
import voiture.impl.Voiture;

public class Prog {

  /**
   * programme Main.
   * 
   * @param args
   */
  public static void main(String[] args) {

    Voiture voiture = new Voiture();
    
    VisiteurVoiture visiteur = new VisiteurVoiture();
    FactoryVoiture vfac = new FactoryVoiture();
    
    voiture = vfac.creerVoiture("peugeot", "208", 345645, "Michelin", 2.0, 1.0, true);
    
    voiture.applique(visiteur);
    
    System.out.println("le nombres Voitures créérs est: => " + visiteur.nombreVoiture());

  }

}

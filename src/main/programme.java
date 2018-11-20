package main;

import voiture.impl.*;

public class programme {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {

    int nbVoitures = 0;

    Voiture maVoiture = new Voiture();
    maVoiture.setMarque("Simca");
    maVoiture.setModele("1100");
    Moteur monMoteur = new Moteur();
    monMoteur.setNumeroSerie(12345);
    maVoiture.setMoteur(monMoteur);
    Pneu monPneuAvantGauche = new Pneu();
    monPneuAvantGauche.setMarque("bonneAnnee");
    monPneuAvantGauche.setHauteur(20.0);
    monPneuAvantGauche.setLargeur(10.0);
    monPneuAvantGauche.setHiver(false);
    maVoiture.getPneus().add(monPneuAvantGauche);
    Pneu monPneuAvantDroit = new Pneu();
    monPneuAvantDroit.setMarque("bonneAnnee");
    monPneuAvantDroit.setHauteur(20.0);
    monPneuAvantDroit.setLargeur(10.0);
    monPneuAvantDroit.setHiver(false);
    maVoiture.getPneus().add(monPneuAvantDroit);
    Pneu monPneuArriereGauche = new Pneu();
    monPneuArriereGauche.setMarque("bonneAnnee");
    monPneuArriereGauche.setHauteur(20.0);
    monPneuArriereGauche.setLargeur(10.0);
    monPneuArriereGauche.setHiver(false);
    maVoiture.getPneus().add(monPneuArriereGauche);
    Pneu monPneuArriereDroit = new Pneu();
    monPneuArriereDroit.setMarque("bonneAnnee");
    monPneuArriereDroit.setHauteur(20.0);
    monPneuArriereDroit.setLargeur(10.0);
    monPneuArriereDroit.setHiver(false);
    maVoiture.getPneus().add(monPneuArriereDroit);

    nbVoitures++;

    System.out.println("nouvelle production : " + nbVoitures + " voitures");

    System.out.println(maVoiture.toString());
  }
}

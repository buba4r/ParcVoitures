package facade;

import java.util.ArrayList;
import java.util.HashMap;

import visiteur.VisiteurVoiture;
import voiture.factory.FactoryVoiture;
import voiture.factory.FactoryXml;
import voiture.impl.ChangePneu;
import voiture.impl.Voiture;
import vue.Vue;

public class GestionParkVoitures {

  private final FactoryVoiture factoryVoiture;
  private final FactoryXml factoryXml;
  private final VisiteurVoiture visiteurVoiture;
  private final ChangePneu changePneu;
  private final HashMap<Integer, Voiture> voitures;
  private final int index;
  ArrayList<Vue> listVue;

  /**
   * constructeur GestionParkVoitures.
   */
  public GestionParkVoitures() {
    this.factoryVoiture = new FactoryVoiture();
    this.factoryXml = new FactoryXml();
    this.visiteurVoiture = new VisiteurVoiture();
    this.changePneu = new ChangePneu();
    this.voitures = new HashMap<>();
    this.index = 0;
    this.listVue = new ArrayList<>();

  }

  public void creerVoiture() {

  }

  public void creerVoitureApartirXml() {

  }

  public void supprimerVoiture() {

  }

  public HashMap<Integer, Voiture> getVoitures() {
    return voitures;
  }

  public void register(Vue vue) {

  }

  public void notifyObserver() {

  }

  public void afficherListVoitures() {

  }

  public void afficherListPneux() {

  }

  public void changerPneu() {

  }

  public int nombresVoitures() {
    return 0;
  }

}

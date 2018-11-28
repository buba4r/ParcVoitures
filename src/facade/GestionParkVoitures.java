package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import parc.ParcAutomobile;
import visiteur.VisiteurVoiture;
import voiture.factory.FactoryVoiture;
import voiture.factory.FactoryXml;
import voiture.impl.ChangePneu;
import voiture.impl.EmplacementRoues;
import voiture.impl.Voiture;
import vue.Vue;

/**
 * GestionParkVoitures.
 * @author Boubacar
 *
 */
public class GestionParkVoitures {

  ParcAutomobile parcAuto;

  private final FactoryVoiture factoryVoiture;
  private final FactoryXml factoryXml;
  private final VisiteurVoiture visiteurVoiture;
  private final ChangePneu changePneu;
  private final HashMap<Integer, Voiture> voitures;
  private int index;
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

  /**
   * Creeation d'une voiture.
   * 
   * @param marque la marque du voiture
   * @param model le model du voiture
   * @param numeroSerie numero de serie
   * @param largeur la largeur du pneu
   * @param hauteur la hauteur du pneu
   * @param marquePneu la marque du pneu
   * @param isHiver type.
   */
  public void creerVoiture(String marque, String model, int numeroSerie,
      double largeur, double hauteur,String marquePneu, Boolean isHiver) {
    Voiture voiture = factoryVoiture.creerVoiture(marque, model, numeroSerie,
        largeur, hauteur, marquePneu, isHiver);

    voitures.put(index, voiture);
    index++;
    this.notifyObserver();

  }

  /**
   * ajouter ou modifier une voiture existante.
   * @param key la cle
   * @param voiture la valeur
   * @return
   */
  public Voiture ajouterOuModifierVoiture(Integer key, Voiture voiture) {
    Voiture vehicule = parcAuto.ajouterOuModifierVoiture(key, voiture);

    return vehicule;
  }

  /**
   * La methode permet de creer des voitures a partir d'un fichier xml. la Final
   * permet d'indiquer que ta variable n'est pas modifiable. Ca gagne enprincipe
   * de la place en mémoire
   * 
   * @param nomFichier le nom du fichier.
   */
  public void creerVoitureApartirXml(final String nomFichier) {
    factoryXml.parseXml(nomFichier);
    for (Voiture vehicule : factoryXml.getVoitures()) {
      voitures.put(index, vehicule);
      index++;
    }
    this.notifyObserver();

  }

  /**
   * la methode permet de supprimer une voiture a partir de son index.
   * 
   * @param index l'index
   */
  public void supprimerVoiture(Integer index) {
    this.voitures.remove(index);
    this.notifyObserver();

  }

  public HashMap<Integer, Voiture> getVoitures() {
    return voitures;
  }

  /**
   * suppresion d'une voiture.
   * 
   * @return
   */
  public Voiture removeVoiture() {
    Voiture maVoiture = new Voiture();
    maVoiture = parcAuto.removeVoiture(index);
    index--;
    return maVoiture;
  }

  public void register(Vue vue) {
    this.listVue.add(vue);

  }

  /**
   * Clears the observer list so that this object no longer has any observers.
   */
  public void notifyObserver() {
    for (int i = 0; i < this.listVue.size(); i++) {
      this.listVue.get(i).update(this);
    }

  }

  /**
   * Affichage de la liste des voitures.
   */
  public void afficherListVoitures() {
    Iterator<?> itr = voitures.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry coupleVoiture = (Entry<Integer, Voiture>) itr.next();
      int indexVoiture = (int) coupleVoiture.getKey();
      System.out.println("Index Voiture : " + indexVoiture);
      Voiture voitureRecupere = voitures.get(indexVoiture);
      visiteurVoiture.agitSur(voitureRecupere);

    }
    this.notifyObserver();

  }

  /**
   * affiche la liste des Pneux.
   */
  public void afficherListPneux() {
    Iterator itr = voitures.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry coupleVoiture = (Entry) itr.next();
      int indexVoiture = (int) coupleVoiture.getKey();
      System.out.println("Index Voiture : " + indexVoiture);
      Voiture newVoiture = voitures.get(indexVoiture);
      visiteurVoiture.agitSur(newVoiture);

    }
    this.notifyObserver();

  }

  /**
   * changer les Pneux en fonction de l'emplacement.
   * 
   * @param position la position
   * @param marquePneu  la marque du pneu
   * @param hauteur la hauteur du pneu
   * @param largeur la largeur du pneu
   * @param isHiver type du pneu
   * @param voiture .
   */
  public void changerPneu(EmplacementRoues position, String marquePneu,
      double hauteur, double largeur, boolean isHiver,Voiture voiture) {
    changePneu.changePneuAvantDroit(marquePneu, hauteur, largeur, isHiver, voiture);
    changePneu.changePneuAvantGauche(marquePneu, hauteur, largeur, isHiver, voiture);
    changePneu.changePneuArrieretDroit(marquePneu, hauteur, largeur, isHiver, voiture);
    changePneu.changePneuArriereGauche(marquePneu, hauteur, largeur, isHiver, voiture);

  }

  public int nombresVoitures() {
    int nbVoitures = factoryVoiture.nombresVoitures();
    return nbVoitures;
  }

}

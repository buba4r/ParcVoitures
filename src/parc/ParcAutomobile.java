package parc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import voiture.impl.Voiture;

/**
 * Parc autoMobile.
 * @author Boubacar.
 *
 */
public class ParcAutomobile implements MapParcAuto<Integer, Voiture> {

  Couple<Integer, Voiture>[] listeVoitures;
  protected int taille;

  public ParcAutomobile(int capacity) {
    this.taille = capacity;
  }

  @SuppressWarnings("unchecked")
  public ParcAutomobile() {
    this.taille = 100;
    listeVoitures = new Couple[taille];
  }

  /**
   * fonction permettant de retourner la position.
   * @param key la cle.
   * @return 
   */
  public int getPosition(Integer key) {
    return key.hashCode() % listeVoitures.length;
  }

  /**
   *  Fonction permettant l'ajout ou la modification de la voiture.
   */
  @Override
  public Voiture ajouterOuModifierVoiture(Integer key, Voiture voiture) {
    int position = getPosition(key);
    Voiture vehicule = null;
    if (this.containsIdVoiture(key)) { // cas cle deja existante
      for (int i = 0; i < taille; i++) {
        if (listeVoitures[position].getKey().equals(key)) {
          vehicule = listeVoitures[position].getValue();
          listeVoitures[position].setValue(voiture);
          return vehicule;
        }
        position = (position + 1) % taille;
      }
    }
    if (size() == taille) {
      return null; // cas tableau plein
    }
    for (int i = 0; i < taille; i++) { // cas ajout d'elements
      if (listeVoitures[position] == null) {
        listeVoitures[position] = new Couple<Integer, Voiture>(key, voiture);
        return voiture;
      }
      position = (position + 1) % taille;
    }

    return null;
  }

  /**
   * Fonction permettant de retourner une voiture en fonction de son Identifiant.
   */
  @Override
  public Voiture getVoiture(Integer key) {
    int position = getPosition(key);
    if (isEmpty()) {
      return null;
    }
    for (int i = 0; i < taille; i++) {
      if (listeVoitures[position] != null && listeVoitures[position].getKey().equals(key)) {
        return listeVoitures[position].getValue();
      }
      position = (position + 1) % taille;
    }
    return null;
  }

  /**
   * Fonction permettant de supprimer une voiture.
   */
  @Override
  public Voiture removeVoiture(Integer key) {
    int position = getPosition(key);
    if (isEmpty()) {
      return null;
    }
    for (int i = 0; i < taille; i++) {
      if (listeVoitures[position] != null && listeVoitures[position].getKey().equals(key)) {
        Couple<Integer, Voiture> couple = listeVoitures[position];
        listeVoitures[position] = null;
        return couple.getValue();
      }
      position = (position + 1) % taille;

    }
    return null;
  }

  /**
   * Tester l'existance d'un Identifiant.
   */
  @Override
  public boolean containsIdVoiture(Integer key) {
    int position = getPosition(key);
    for (int i = 0; i < taille; i++) {
      if (listeVoitures[position] != null && listeVoitures[position].getKey().equals(key)) {
        return true;
      }
      position = (position + 1) % taille;
    }
    return false;
  }

  /**
   * Tester l'existance d'une voiture.
   */
  @Override
  public boolean containsVoiture(Voiture voiture) {
    for (int i = 0; i < taille; i++) {
      if (listeVoitures[i] != null && listeVoitures[i].getValue().equals(voiture)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int size() {
    int nb = 0;
    for (int i = 0; i < listeVoitures.length; i++) {
      if (listeVoitures[i] != null) {
        nb++;
      }
    }

    return nb;
  }

  @Override
  public boolean isEmpty() {
    for (int i = 0; i < taille; i++) {
      if (listeVoitures[i] != null) {
        return false;
      }

    }
    return false;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void clear() {
    listeVoitures = new Couple[taille];

  }

  /**
   * Fonction qui permet de retourner l'ensembles des Identifiants associ�s � chaque voiture.
   */
  @Override
  public Set<Integer> keySet() {
    Set<Integer> set = new HashSet<Integer>();
    if (isEmpty()) {
      return null;
    }
    for (int i = 0; i < taille; i++) {
      if (listeVoitures[i] != null) {
        set.add((Integer) listeVoitures[i].getKey());
      }
    }
    return set;
  }

  /**
   * La methode permet de retourner l'ensemble des Voitures.
   */
  @Override
  public Collection<Voiture> values() {
    Collection<Voiture> col = new ArrayList<Voiture>();
    if (isEmpty()) {
      return null;
    }
    for (int i = 0; i < taille; i++) {
      if (listeVoitures[i] != null) {
        col.add((Voiture) listeVoitures[i].getValue());
      }
    }
    return col;
  }

  /**
   * La methode entrySet permet de retourner chaque voiture associer � son Identifiant.
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<Entry<Integer, Voiture>> entrySet() {
    Set<parc.MapParcAuto.Entry<Integer, Voiture>> set = new HashSet<Entry<Integer, Voiture>>();
    if (isEmpty()) {
      return null;
    }

    for (int i = 0; i < taille; i++) {
      if (listeVoitures[i] != null) {
        set.add((parc.MapParcAuto.Entry<Integer, Voiture>) listeVoitures[i]);
      }
    }
    return set;
  }

}

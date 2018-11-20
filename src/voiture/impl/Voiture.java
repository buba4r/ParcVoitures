/*
* Nom de classe : Voitures
*
* Description   : gestion de voitures
*
* Version       : 1.0
*
* Date          : 07/11/2017
*
* Copyright     : GNU GPL
*/

package voiture.impl;

import java.util.ArrayList;
import java.util.List;

import visiteur.ElementVisitableVoiture;
import visiteur.Visiteur;
import visiteur.VisiteurVoiture;

public class Voiture implements ElementVisitableVoiture {

  protected static final String MARQUE_EDEFAULT = null;
  protected String marque = MARQUE_EDEFAULT;

  protected static final String MODELE_EDEFAULT = null;
  protected String modele = MODELE_EDEFAULT;

  // le moteur de la voiture
  protected Moteur moteur;
  // les pneus de la voiture
  protected List<Pneu> pneus;

  public Voiture() {
    super();
    pneus = new ArrayList<Pneu>();
  }

  public String getMarque() {
    return marque;
  }

  public void setMarque(String newMarque) {
    marque = newMarque;
  }

  public String getModele() {
    return modele;
  }

  public void setModele(String newModele) {
    modele = newModele;
  }

  public Moteur getMoteur() {
    return moteur;
  }

  public void setMoteur(Moteur newMoteur) {
    moteur = newMoteur;
  }

  public List<Pneu> getPneus() {
    return pneus;
  }

  public void setPneus(List<Pneu> pneus) {
    this.pneus = pneus;
  }

  public void setPneu(Pneu pneu) {
    this.pneus.add(pneu);
  }
  /**
   * @return
   */
  public String toString() {

    StringBuffer result = new StringBuffer("voiture : ");
    result.append("marque ");
    result.append(marque);
    result.append(", modele ");
    result.append(modele);

    result.append(", " + moteur.toString());

    for (Pneu pneu : pneus) {
      result.append(", " + pneu.toString());
    }
    return result.toString();
  }

  public void applique(Visiteur unvisiteur) {
    unvisiteur.agitSur(this);
    
  }

} // VoitureImpl

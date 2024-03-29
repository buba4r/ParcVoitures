/*
* Nom de classe : Moteur
*
* Description   : gestion de moteurs
*
* Version       : 1.0
*
* Date          : 07/11/2017
*
* Copyright     : GNU GPL
*/

package voiture.impl;

import visiteur.ElementVisitableVoiture;
import visiteur.Visiteur;

public class Moteur implements ElementVisitableVoiture {
  protected static final int NUMERO_SERIE_EDEFAULT = 0;
  protected int numeroSerie = NUMERO_SERIE_EDEFAULT;

  public Moteur() {
    super();
  }

  public Moteur(int numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  public int getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(int newNumeroSerie) {
    numeroSerie = newNumeroSerie;
  }

  /** methode toString.
   * @return 
   */
  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append("numeroSerie: ");
    result.append(numeroSerie);
    return result.toString();
  }
  
  public void applique(Visiteur unvisiteur) {
    unvisiteur.agitSur(this);
    
  }

} // Moteur

package voiture.impl;

/**
 * 
 * @author Boubacar
 *
 */
public enum EmplacementRoues {

  AVANT_GAUCHE(0),
  AVANT_DROIT(1),
  ARRIERE_GAUCHE(2),
  ARRIERE_DROIT(3);

  int pos = 0;

  private EmplacementRoues(int position) {
    this.pos = position;
  }

}

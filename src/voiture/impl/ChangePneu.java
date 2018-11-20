package voiture.impl;

/**
 * 
 * @author Boubacar
 *
 */
public class ChangePneu {

  // changer la postion quelconque du pneu
  /**
   * 
   * @param position
   * @param marquePneu
   * @param hauteur
   * @param largeur
   * @param isHiver
   * @param voiture
   */
  private void changePneus(EmplacementRoues position, String marquePneu,
      double hauteur, double largeur,boolean isHiver, Voiture voiture) {

    voiture.pneus.get(position.pos).setMarque(marquePneu);
    voiture.pneus.get(position.pos).setHauteur(hauteur);
    voiture.pneus.get(position.pos).setLargeur(largeur);
    voiture.pneus.get(position.pos).setHiver(isHiver);
  }

  /**
   * 
   * @param marquePneu
   * @param hauteur
   * @param largeur
   * @param isHiver
   * @param voiture
   */
  public void changePneuAvantGauche(String marquePneu, double hauteur, double largeur,
      boolean isHiver, Voiture voiture) {

    this.changePneus(EmplacementRoues.AVANT_GAUCHE, marquePneu, hauteur, largeur, isHiver, voiture);

  }

  /**
   * 
   * @param marquePneu
   * @param hauteur
   * @param largeur
   * @param isHiver
   * @param voiture
   */
  public void changePneuAvantDroit(String marquePneu, double hauteur, double largeur,
      boolean isHiver, Voiture voiture) {

    this.changePneus(EmplacementRoues.AVANT_DROIT, marquePneu, hauteur, largeur, isHiver, voiture);

  }

  /**
   * 
   * @param marquePneu
   * @param hauteur
   * @param largeur
   * @param isHiver
   * @param voiture
   */
  public void changePneuArrieretDroit(String marquePneu, double hauteur, double largeur,
      boolean isHiver,Voiture voiture) {

    this.changePneus(EmplacementRoues.ARRIERE_DROIT,
        marquePneu, hauteur, largeur, isHiver, voiture);

  }

  /**
   * 
   * @param marquePneu
   * @param hauteur
   * @param largeur
   * @param isHiver
   * @param voiture
   */
  public void changePneuArriereGauche(String marquePneu, double hauteur, double largeur,
      boolean isHiver, Voiture voiture) {

    this.changePneus(EmplacementRoues.ARRIERE_GAUCHE,
        marquePneu, hauteur, largeur, isHiver, voiture);

  }

}

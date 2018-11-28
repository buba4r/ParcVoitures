package voiture.impl;

/**
 * class change pneu qui permet de changer les pneu.
 * @author Boubacar
 *
 */
public class ChangePneu {

  /**
   * changer la postion quelconque du pneu.
   * 
   * @param position la position du pneu
   * @param marquePneu la marque du pneu
   * @param hauteur la hateur du pneu
   * @param largeur la largeur du pneu
   * @param isHiver type
   * @param voiture .
   */
  private void changePneus(EmplacementRoues position, String marquePneu,
      double hauteur, double largeur,boolean isHiver, Voiture voiture) {

    voiture.pneus.get(position.pos).setMarque(marquePneu);
    voiture.pneus.get(position.pos).setHauteur(hauteur);
    voiture.pneus.get(position.pos).setLargeur(largeur);
    voiture.pneus.get(position.pos).setHiver(isHiver);
  }

  /**
   * Methode de changement du pneu  avant gauche.
   * 
   * @param marquePneu la marque du pneu
   * @param hauteur la hauteur du pneu
   * @param largeur la largeur du pneu
   * @param isHiver si le type de pneu
   * @param voiture la voiture
   */
  public void changePneuAvantGauche(String marquePneu, double hauteur, double largeur,
      boolean isHiver,Voiture voiture) {

    this.changePneus(EmplacementRoues.AVANT_GAUCHE, marquePneu, hauteur, largeur, isHiver, voiture);

  }

  /**
   * changer les pneu avant droit.
   * @param marquePneu la marque du pneu
   * @param hauteur la hauteur du pneu
   * @param largeur la largeur du pneu
   * @param isHiver type du pneu
   * @param voiture .
   */
  public void changePneuAvantDroit(String marquePneu, double hauteur, double largeur,
      boolean isHiver,Voiture voiture) {

    this.changePneus(EmplacementRoues.AVANT_DROIT, marquePneu, hauteur, largeur, isHiver, voiture);

  }

  /**
   * methode qui permet de changer les pneu arriere droit.
   * @param marquePneu la marque du pneu
   * @param hauteur la hauteur du pneu
   * @param largeur la largeur du pneu
   * @param isHiver type.
   * @param voiture .
   */
  public void changePneuArrieretDroit(String marquePneu, double hauteur, double largeur,
      boolean isHiver,Voiture voiture) {

    this.changePneus(EmplacementRoues.ARRIERE_DROIT, marquePneu,
        hauteur, largeur, isHiver, voiture);

  }

  /**
   * methode qui permet de changer les pneu arriere gauche .
   * @param marquePneu  la marque du pneu
   * @param hauteur la hauteur du pneu
   * @param largeur   la largeur du pneu
   * @param isHiver type
   * @param voiture .
   */
  public void changePneuArriereGauche(String marquePneu, double hauteur, double largeur,
      boolean isHiver,Voiture voiture) {

    this.changePneus(EmplacementRoues.ARRIERE_GAUCHE, marquePneu,
        hauteur, largeur, isHiver, voiture);

  }

}


package vue;

import facade.GestionParkVoitures;

/**
 *
 * @author Boubacar DIALLO
 */
public class Main {

  /**
   * 
   * @param args
   */
  public static void main(String... args) {
    GestionParkVoitures facade = new facade.GestionParkVoitures();
    Accueil accueil = new Accueil(facade);
    accueil.setVisible(true);
  }
}

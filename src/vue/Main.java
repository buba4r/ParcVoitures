
package vue;

import facade.GestionParkVoitures;

/**
 *programme main.
 * @author Boubacar DIALLO
 */
public class Main {

  /**
   *  main.
   * @param args ..
   */
  public static void main(String... args) {
    GestionParkVoitures facade = new facade.GestionParkVoitures();
    Accueil accueil = new Accueil(facade);
    accueil.setVisible(true);
  }
}

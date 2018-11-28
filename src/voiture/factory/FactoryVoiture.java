package voiture.factory;

import java.util.ArrayList;
import java.util.List;

import voiture.impl.Moteur;
import voiture.impl.Pneu;
import voiture.impl.Voiture;


/**
 * class FactoryVoiture.
 * @author Boubacar
 *
 */
public class FactoryVoiture {

  private final int nbPneu = 4;
  static int nbVoiture = 0;

  /**
 * methode creer voiture.
 * 
 * @param marque la marque de la voiture.
 * @param model  le model
 * @param numeroSerie numero de serie
 * @param marquePneu la marque du pneu
 * @param largeur la  largeur du pneu
 * @param hauteur la hauteur du pneu
 * @param isHiver type.
 * @return
 */
  public Voiture creerVoiture(String marque, String model, int numeroSerie,
      double largeur,double hauteur,  String marquePneu, boolean isHiver) {

    Moteur moteur = new Moteur(numeroSerie);
    Voiture voiture = new Voiture();
    voiture.setMarque(marque);
    voiture.setModele(model);
    voiture.setMoteur(moteur);
    for (int i = 0; i < nbPneu; i++) {
      Pneu pneu = new Pneu();
      pneu.setMarque(marquePneu);
      pneu.setLargeur(largeur);
      pneu.setHauteur(hauteur);
      pneu.setHiver(false);

      voiture.setPneu(pneu);
    }
    nbVoiture++;
    return voiture;
  }

  /**
   * lister les voitures.
   * @param listesVoitures une liste des voitures.
   * @return
   */
  public List<Voiture> affichageVoitures(List<Voiture> listesVoitures) {
    ArrayList<Voiture> vehicule = new ArrayList<>();
    for (Voiture vh : listesVoitures) {
      vehicule.add(vh);
    }
    return vehicule;
  }

  public int nombresVoitures() {
    return nbVoiture;
  }

}

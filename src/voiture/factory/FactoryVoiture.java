package voiture.factory;

import java.util.ArrayList;
import java.util.List;

import voiture.impl.Moteur;
import voiture.impl.Pneu;
import voiture.impl.Voiture;


/**
 * 
 * @author Boubacar
 *
 */
public class FactoryVoiture {

  private final int nbPneu = 4;
  static int nbVoiture = 0;

  /**
 * 
 * @param marque
 * @param model
 * @param numeroSerie
 * @param marquePneu
 * @param largeur
 * @param hauteur
 * @param isHiver
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
   * 
   * @param listesVoitures
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

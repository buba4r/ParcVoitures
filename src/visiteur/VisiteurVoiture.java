package visiteur;

import voiture.impl.Moteur;
import voiture.impl.Pneu;
import voiture.impl.Voiture;

public class VisiteurVoiture implements Visiteur {
  static int nombresVoitures = 0;

  @Override
  public void agitSur(ElementVisitableVoiture voiture) {
    if (voiture == null) {
      throw new NullPointerException();
    }
    Voiture vehicule = (Voiture) voiture;

    System.out.println("Voiture: " + vehicule.getMarque() + " " + vehicule.getModele());
    System.out.println("Moteur: " + vehicule.getMoteur());
    System.out.println("Pneu: " + vehicule.getPneus());

    nombresVoitures++;

  }

  @Override
  public void agitSur(Pneu unPneu) {
    if (unPneu == null) {
      throw new NullPointerException();
    }
  
    System.out.println("Pneu: " + unPneu.toString());

  }

  @Override
  public void agitSur(Moteur unMoteur) {
    System.out.println("Moteur: " + unMoteur.getNumeroSerie());

  }

  public int nombreVoiture() {
    return nombresVoitures;
  }

}

package visiteur;

import voiture.impl.Voiture;

public class VisiteurVoiture implements Visiteur {
  static int nombresVoitures = 0;

  @Override
  public void agitSur(ElementVisitableVoiture voiture) {
    if (voiture == null) {
      throw new NullPointerException();
    }
    Voiture vh = (Voiture) voiture;

    System.out.println("Voiture: " + vh.getMarque() + " " + vh.getModele());
    System.out.println("Moteur: " + vh.getMoteur());
    System.out.println("Pneu: " + vh.getPneus());

    nombresVoitures++;

  }

  public int nombreVoiture() {
    return nombresVoitures;
  }

}

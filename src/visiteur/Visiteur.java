package visiteur;

import voiture.impl.Moteur;
import voiture.impl.Pneu;

public interface Visiteur {
  void agitSur(ElementVisitableVoiture uneVoiture);
  void agitSur(Pneu unPneu);
  void agitSur(Moteur unMoteur);

}

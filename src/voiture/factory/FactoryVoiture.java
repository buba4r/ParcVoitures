package voiture.factory;

import java.util.ArrayList;
import java.util.List;

import voiture.impl.Moteur;
import voiture.impl.Pneu;
import voiture.impl.Voiture;

public class FactoryVoiture extends Voiture {

	private final int nbPneu = 4;
	static int nbVoiture = 0;

	public Voiture creerVoiture(String marque, String model, int numeroSerie, String marquePneu, double largeur,
			double hauteur, boolean isHiver) {

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

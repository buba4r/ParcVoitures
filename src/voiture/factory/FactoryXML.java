package voiture.factory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import voiture.impl.*;

public class FactoryXML {

	List<Voiture> voitures;
	FactoryVoiture factoryVoiture;
	private String model;
	private String marque;

	public FactoryXML() {
		voitures = new ArrayList<>();
		factoryVoiture = new FactoryVoiture();
	}

	public void parseXMl(String fichier) {

		/* Création du parseur */
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = null;
		fichierXML = new File(fichier);
		Document document;
		try {
			/* Parsing du fichier */
			document = builder.build(fichierXML);
			/* Racine du document XML : dans notre cas <diagramme> */
			Element rootNode = document.getRootElement();
			/* On récupère tous les élément classe du fichier XML */
			List<Element> liste = rootNode.getChildren("voiture");
			String largeur = null;
			Boolean hiver = null;
			String hauteur = null;
			String marquePneu = null;
			String marqueVoiture = null;
			String modeleVoiture = null;
			String numeroSerie = null;

			/* Boucle sur tous les éléments "classe" du fichier XML */
			for (Element eVoiture : liste) {
				/* Parcour des voitures du fichiers XML */
				marqueVoiture = eVoiture.getChild("marque").getText();
				modeleVoiture = eVoiture.getChild("modele").getText();
				numeroSerie = eVoiture.getChild("moteur").getText();
				/* Récupération de tous les attributs du pneu */
				List<Element> pneux = eVoiture.getChildren("pneu");
				for (Element eAttribut : pneux) {
					largeur = eAttribut.getChildText("largeur");
					hauteur = eAttribut.getChildText("hauteur");
					hiver = new Boolean(eAttribut.getChildText("hiver"));
					marquePneu = eAttribut.getChildText("marque");
				}

				Voiture voiture = factoryVoiture.creerVoiture(marque, model, Integer.parseInt(numeroSerie), marquePneu,
						Integer.parseInt(largeur), Double.parseDouble(hauteur), true);
				voitures.add(voiture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public FactoryVoiture getFactoryVoiture() {
	        return factoryVoiture;
	    }

	    public List<Voiture> getVoitures() {
	        return voitures;
	    }

}

package voiture.factory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import voiture.impl.Voiture;

/**
 * FactoryXml permet de d'ecrire une voiture a partir d'un fichier xml.
 * 
 * @author Boubacar
 *
 */
public class FactoryXml {

  List<Voiture> voitures;
  FactoryVoiture factoryVoiture;
  private String model;
  private String marque;

  /**
   * constructeur.
   */
  public FactoryXml() {
    voitures = new ArrayList<>();
    factoryVoiture = new FactoryVoiture();
  }

  /**
   * 
   * @param fichier
   */
  public List<Voiture> parseXml(String fichier) {

    /* Création du parseur */
    SAXBuilder builder = new SAXBuilder();
    File fichierXml = null;
    fichierXml = new File(fichier);
    Document document;
    try {
      /* Parsing du fichier */
      document = builder.build(fichierXml);
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
      for (Element evoiture : liste) {
        /* Parcour des voitures du fichiers XML */
        marqueVoiture = evoiture.getChild("marque").getText();
        modeleVoiture = evoiture.getChild("modele").getText();
        numeroSerie = evoiture.getChild("moteur").getText();

        /* Récupération de tous les attributs du pneu */
        List<Element> pneux = evoiture.getChildren("pneu");
        for (Element eattribut : pneux) {
          largeur = eattribut.getChildText("largeur");
          hauteur = eattribut.getChildText("hauteur");
          hiver = new Boolean(eattribut.getChildText("hiver"));
          marquePneu = eattribut.getChildText("marque");
        }

        Voiture voiture = factoryVoiture.creerVoiture(marqueVoiture, modeleVoiture,
            Integer.parseInt(numeroSerie),Double.parseDouble(largeur), Double.parseDouble(hauteur),
            marquePneu, true);
        voitures.add(voiture);

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return voitures;
  }

  public FactoryVoiture getFactoryVoiture() {
    return factoryVoiture;
  }

  public List<Voiture> getVoitures() {
    return voitures;
  }

}

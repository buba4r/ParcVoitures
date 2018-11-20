package junit;

import java.util.ArrayList;

import org.junit.Test;

import voiture.factory.FactoryVoiture;
import voiture.factory.FactoryXml;
import voiture.impl.Voiture;




public class ParcVoituresTestJunit {
  
  FactoryVoiture vfac = new FactoryVoiture();
  
  
  Voiture maVoiture = vfac.creerVoiture("peugeot", "208", 345645, 2.0, 1.0, "Michelin", true);
  Voiture mavoiture1 = vfac.creerVoiture("Porsche", "Gt", 812345, 3.2, 1.3, "michelin", true);
  Voiture mavoiture2 = vfac.creerVoiture("Audi", "SportBack", 71125, 2.3, 1.2, "continental", true);
  Voiture mavoiture3 = vfac.creerVoiture("Bmw", "320", 22345, 1.1, 1.4, "michelin", false);
  
  
  // Test Factory Xml 
  @Test 
  public void testXmlFile() {
    FactoryXml file = new FactoryXml();
    ArrayList<Voiture> voitures = new ArrayList<>();
    voitures = (ArrayList<Voiture>) file.parseXml("fichier.xml");
    System.out.println("les voitures dans le xml:" + voitures);
 
    
  }




}

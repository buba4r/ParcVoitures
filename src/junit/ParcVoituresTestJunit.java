package junit;

import java.util.ArrayList;

import org.junit.Test;

import voiture.factory.FactoryVoiture;
import voiture.factory.FactoryXml;
import voiture.impl.Voiture;




public class ParcVoituresTestJunit {
  
  FactoryVoiture vfac = new FactoryVoiture();
  
  
  Voiture maVoiture = vfac.creerVoiture("peugeot", "208", 345645, "Michelin", 2.0, 1.0, true);
  Voiture mavoiture1 = vfac.creerVoiture("Porsche", "Gt", 812345, "michelin", 3.2, 1.3, true);
  Voiture mavoiture2 = vfac.creerVoiture("Audi", "SportBack", 71125, "continental", 2.3, 1.2, true);
  Voiture mavoiture3 = vfac.creerVoiture("Bmw", "320", 22345, "michelin", 1.1, 1.4, false);
  
  
  // Test Factory Xml 
  @Test 
  public void testXmlFile() {
    FactoryXml file = new FactoryXml();
    ArrayList<Voiture> voitures = new ArrayList<>();
    Voiture voiture = new Voiture();
    voiture = file.parseXml("fichier.xml");
    System.out.println("les voitures dans le xml:" + voiture);
 
    
  }




}

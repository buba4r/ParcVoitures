package junit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import facade.GestionParkVoitures;
import parc.Couple;
import parc.ParcAutomobile;
import voiture.factory.FactoryVoiture;
import voiture.factory.FactoryXml;
import voiture.impl.EmplacementRoues;
import voiture.impl.Voiture;

public class ParcVoituresTestJunit {

  FactoryVoiture vfac = new FactoryVoiture();
  GestionParkVoitures facade = new GestionParkVoitures();
  ParcAutomobile parc = new ParcAutomobile();

  Voiture maVoiture = vfac.creerVoiture("peugeot", "208", 345645, 2.0, 1.0, "Michelin", true);
  Voiture mavoiture1 = vfac.creerVoiture("Porsche", "Gt", 812345, 3.2, 1.3, "michelin", true);
  Voiture mavoiture2 = vfac.creerVoiture("Audi", "SportBack", 71125, 2.3, 1.2, "continental", true);
  Voiture mavoiture3 = vfac.creerVoiture("Bmw", "320", 22345, 1.1, 1.4, "michelin", false);
  Voiture mavoiture4 = vfac.creerVoiture("Ford", "Mustang", 9612345, 2.2, 1.2, "best", false);

  // Test Factory Xml
  @Test
  public void testXmlFile() {
    FactoryXml file = new FactoryXml();
    ArrayList<Voiture> voitures = new ArrayList<>();
    voitures = (ArrayList<Voiture>) file.parseXml("fichier.xml");
    System.out.println("les voitures dans le xml:" + voitures);

  }

  @Test
  public void testCreerVoiture() {
    parc.ajouterOuModifierVoiture(1, maVoiture);
    parc.ajouterOuModifierVoiture(2, mavoiture1);

    assertTrue(parc.containsIdVoiture(1));
    assertTrue(parc.containsVoiture(mavoiture1));

  }

  @Test
  public void testContainsIdVoiture() {
    parc.ajouterOuModifierVoiture(1, mavoiture2);
    parc.ajouterOuModifierVoiture(2, mavoiture4);

    assertTrue(parc.containsIdVoiture(2));
    assertFalse(parc.containsIdVoiture(200));

  }

  @Test
  public void testContainsVoiture() {
    parc.ajouterOuModifierVoiture(1, mavoiture1);
    parc.ajouterOuModifierVoiture(2, mavoiture3);

    assertTrue(parc.containsVoiture(mavoiture3));
    assertFalse(parc.containsVoiture(mavoiture4));
    Voiture maVoiture100 = null;
    assertFalse(parc.containsVoiture(maVoiture100));
  }

  @Test
  public void tesRemouveVoiture() {
    parc.ajouterOuModifierVoiture(1, mavoiture1);
    parc.ajouterOuModifierVoiture(2, mavoiture2);
    parc.ajouterOuModifierVoiture(3, mavoiture3);

    assertEquals(parc.removeVoiture(1), mavoiture1);
    assertEquals(parc.size(), 2);
    assertEquals(parc.removeVoiture(2), mavoiture2);
    assertEquals(parc.removeVoiture(3), mavoiture3);
    assertEquals(parc.size(), 0);

  }

  @Test
  public void testIsempty() {
    parc.ajouterOuModifierVoiture(2, mavoiture4);
    assertEquals(parc.size(), 1);
    assertFalse(parc.isEmpty());
  }

  @Test
  public void testSize() {
    parc.ajouterOuModifierVoiture(1, mavoiture1);
    parc.ajouterOuModifierVoiture(2, mavoiture2);

    assertEquals(parc.size(), 2);

    parc.removeVoiture(1);
    parc.removeVoiture(2);

    assertEquals(parc.size(), 0);
  }

  @Test
  public void testClear() {
    parc.ajouterOuModifierVoiture(1, mavoiture1);
    parc.ajouterOuModifierVoiture(2, mavoiture2);
    parc.clear();
    assertEquals(parc.size(), 0);

  }

  @Test
  public void testSetKey() {
    parc.ajouterOuModifierVoiture(4, mavoiture4);
    parc.ajouterOuModifierVoiture(3, mavoiture3);

    Set<Integer> set = new HashSet<Integer>();
    set.add(4);
    set.add(3);

    assertEquals(parc.keySet(), set);
    System.out.println("la liste des Identifiants " + set);

  }

  @Test
  public void testListesVoitures() {
    parc.ajouterOuModifierVoiture(1, mavoiture1);
    parc.ajouterOuModifierVoiture(2, mavoiture2);
    parc.ajouterOuModifierVoiture(3, mavoiture3);
    Collection<Voiture> s = new ArrayList<Voiture>();
    s.add(mavoiture1);
    s.add(mavoiture2);
    s.add(mavoiture3);
    System.out.println("la liste des voitures " + s);
    assertTrue(parc.values().containsAll(s));

  }

  @Test
  public void testListesCoupleIdentifiant() {
    parc.ajouterOuModifierVoiture(1, mavoiture1);
    parc.ajouterOuModifierVoiture(2, mavoiture2);
    parc.ajouterOuModifierVoiture(3, mavoiture3);
    Set<Couple<Integer, Voiture>> s = new HashSet<Couple<Integer, Voiture>>();
    s.add(new Couple<Integer, Voiture>(1, mavoiture1));
    s.add(new Couple<Integer, Voiture>(2, mavoiture2));
    s.add(new Couple<Integer, Voiture>(3, mavoiture3));
    System.out.println("la liste des couples ID/Voiture " + s);

  }

  @Test
  public void testChangePneu() {

    facade.changerPneu(EmplacementRoues.AVANT_DROIT, "best", 2.1, 1.1, false, maVoiture);
    facade.changerPneu(EmplacementRoues.AVANT_GAUCHE, "best", 2.1, 1.1, false, maVoiture);

    facade.changerPneu(EmplacementRoues.ARRIERE_DROIT, "best", 2.5, 1.5, false, maVoiture);
    facade.changerPneu(EmplacementRoues.ARRIERE_GAUCHE, "best", 2.5, 1.5, false, maVoiture);
    
    Voiture ancienVoiture = vfac.creerVoiture("peugeot", "208", 345645, 2.0, 1.0, "Michelin", true);
    
    assertNotEquals(maVoiture.getPneus(), ancienVoiture.getPneus());
    System.out.println("new pneux: " + maVoiture.getPneus());

  }

}

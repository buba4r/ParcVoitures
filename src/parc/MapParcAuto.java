package parc;

import java.util.Collection;
import java.util.Set;

/**
 * ...
 * @author Boubacar.
 *
 * @param <Integer> ...
 * @param <Voiture> ...
 */
public interface MapParcAuto<Integer, Voiture> {
  // creer un couple ('key','value') et le stocker dans la table
  Voiture ajouterOuModifierVoiture(Integer key, Voiture voiture);

  // retrouver la valeur associee a la cle 'key'
  Voiture getVoiture(Integer key);

  // supprimer le couple dont la cle est 'key'
  Voiture removeVoiture(Integer key);

  // tester l'existance d'un couple dont la cle est 'key'
  boolean containsIdVoiture(Integer key);

  // tester l'existance d'un couple dont la valeur est 'value'
  boolean containsVoiture(Voiture voiture);

  int size();

  boolean isEmpty();

  // vider la table
  void clear();

  // retourner un Set contenant toutes les cles
  Set<Integer> keySet();

  // retourner une Collection contenant toutes les valeurs
  Collection<Voiture> values();

  // retourner un Set contenant tous les couples
  Set<MapParcAuto.Entry<Integer, Voiture>> entrySet();

  // la classe interne decrivant un couple
  public interface Entry<Integer, Voiture> {
    // retourner la cle
    Integer getIdVoiture();

    // retourner la valeur
    Voiture getValue();

    // modifier la valeur
    Voiture setVoiture(Voiture value);
  }

}

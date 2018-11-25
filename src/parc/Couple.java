package parc;

import java.util.Map.Entry;

public class Couple<Integer, Voiture> implements Entry<Integer, Voiture> {
  Integer key;
  Voiture value;

  public Couple(Integer idVoiture, Voiture voiture) {
    this.key = idVoiture;
    this.value = voiture;
  }

  public Couple() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Integer getKey() {
    return key;
  }

  @Override
  public Voiture getValue() {
    return value;
  }

  @Override
  public Voiture setValue(Voiture value) {
    if (value instanceof String) {
      value = value;
    }
    return value;
  }

  public String toString() {
    return "{ " + key + " ; " + value + " }";
  }

}

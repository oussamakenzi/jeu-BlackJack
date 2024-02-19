package org.example;
public class Carte {
  private int valeur;
  private String enseigne;

  public Carte(int valeur, String enseigne) {
    this.valeur = valeur;
    this.enseigne = enseigne;
  }

  public int getValeur() {
    return valeur;
  }

  @Override
  public String toString() {
    return valeur + " de " + enseigne;
  }
}

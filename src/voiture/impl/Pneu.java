/*
* Nom de classe : Pneu
*
* Description   : gestion de pneus
*
* Version       : 1.0
*
* Date          : 07/11/2017
*
* Copyright     : GNU GPL
*/

package voiture.impl;

public class Pneu {

	protected static final double LARGEUR_EDEFAULT = 0.0;
	protected double largeur = LARGEUR_EDEFAULT;

	protected static final boolean HIVER_EDEFAULT = false;
	protected boolean hiver = HIVER_EDEFAULT;

	protected static final double HAUTEUR_EDEFAULT = 0.0;
	protected double hauteur = HAUTEUR_EDEFAULT;

	protected static final String MARQUE_EDEFAULT = null;
	protected String marque = MARQUE_EDEFAULT;

	public Pneu() {
		super();
	}
	
	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double newLargeur) {
		largeur = newLargeur;
	}

	public boolean isHiver() {
		return hiver;
	}
	public void setHiver(boolean newHiver) {
		hiver = newHiver;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double newHauteur) {
		hauteur = newHauteur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String newMarque) {
		marque = newMarque;
	}

	public String toString() {
		
		StringBuffer result = new StringBuffer();
		result.append("(largeur: ");
		result.append(largeur);
		result.append(", hiver: ");
		result.append(hiver);
		result.append(", hauteur: ");
		result.append(hauteur);
		result.append(", marque: ");
		result.append(marque);
		result.append(')');
		return result.toString();
	}

} //Pneu

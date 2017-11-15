package com.ocr.garage;

import java.io.Serializable;

/**
 * On tente la généricité :
 * https://openclassrooms.com/courses/apprenez-a-programmer-en-java/la-genericite-en-java
 * @author John
 * @param <T>
 */
//
public class Moteur<T>  implements Serializable {

	  //Variable d'instance
	  private T type;


	private static final long serialVersionUID = -346490467227222006L;
	//private TypeMoteur type;
	private String cylindre;
	private double prix;
	
	public Moteur(String cylindre, double prix, T type) {
		
		this.cylindre = cylindre;
		this.prix = prix;
		this.type = type;

		
	}
	
	public double getPrix() {
		
		return prix;
		
	}

	@Override
	public String toString() {
		
		//Retourne la valeur déjà « castée » par la signature de la méthode ! :  type.toString()
		
		return "Moteur [type=" + type.toString() + ", cylindre=" + cylindre + ", prix=" + String.valueOf(prix)  + "]";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cylindre == null) ? 0 : cylindre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moteur<?> other = (Moteur<?>) obj;
		if (cylindre == null) {
			if (other.cylindre != null)
				return false;
		} else if (!cylindre.equals(other.cylindre))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}

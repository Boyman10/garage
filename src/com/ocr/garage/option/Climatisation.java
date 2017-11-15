package com.ocr.garage.option;

import com.ocr.garage.Option;
import java.io.Serializable;
public class Climatisation implements Option,Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -863246360272426533L;
	private double prix = 347.30d;
	
	public double getPrix() {
		
		return prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Climatisation other = (Climatisation) obj;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}
	
}

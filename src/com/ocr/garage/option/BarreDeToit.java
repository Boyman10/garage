package com.ocr.garage.option;

import java.io.Serializable;
import com.ocr.garage.Option;

public class BarreDeToit implements Option,Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8626218933357981738L;
	private double prix = 29.90d;
	
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
		BarreDeToit other = (BarreDeToit) obj;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}
	
	
}

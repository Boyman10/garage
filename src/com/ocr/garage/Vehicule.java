package com.ocr.garage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Vehicule  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double prix;
	private String nom;

	private Moteur<TypeMoteur> engine;
	
	// Collection d'objet sous forme de liste
	//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-collections-d-objets
	private List<Option> options;

	private Marque nomMarque;
	
	private static Logger logger = LogManager.getRootLogger();
	
	// constructor
	public Vehicule() {
		
		
		options = new ArrayList<Option>();
	}
	
	public Vehicule(Marque m, String name) {
		
		logger.info("This is an info message : calling my vehicule ...");
		options = new ArrayList<Option>();
		nomMarque = m;
		nom = name;
	}

	@Override
	public String toString() {
		
		String str;
		str = "\n\nVehicule [prix total = " + getPrix() + ", nom=" + getName()  + " marque : " + getMarque() + "]";
	   
		str += "\nMoteur : " + getEngine().toString();
		// iteration sur la liste pour en afficher les éléments :
		for(int i = 0; i < getOptions().size(); i++)
	    {
	      str += "\n- Option " + getOptions().get(i).getClass().getSimpleName() +  " au prix de : " + String.valueOf(getOptions().get(i).getPrix());
	    }     	
		
		
		
		return str;
		
	}
	
	// Méthode pour ajouter un objet option à la liste
	public void addOption(Option opt) {
		
		options.add(opt);
		
	}
	
	public Marque getMarque() {
		
		return nomMarque;
	}
	
	public String getName() {
		
		return nom;
	}
	// return the list of options
	public List<Option> getOptions() {
		
		return options;
		
	}	
	
	public double getPrix() {
		
		// prix moteur 
		prix = getEngine().getPrix();
		
		// prix options :
		for(Option opt : getOptions()) {
			
			prix += opt.getPrix();
			
		}
		
		return Math.round(prix);
	}	
	public void setEngine(Moteur<TypeMoteur> eng) {
		
		engine = eng;
		
	}

	public Moteur<TypeMoteur> getEngine() {
		return engine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((nomMarque == null) ? 0 : nomMarque.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
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
		Vehicule other = (Vehicule) obj;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (nomMarque != other.nomMarque)
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		
		// Beware here we need to compare rounded values  :
		if (Double.doubleToLongBits(getPrix()) != Double.doubleToLongBits(other.getPrix()))
			return false;
		return true;
	}


}

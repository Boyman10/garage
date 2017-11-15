package com.ocr.garage;

public enum TypeMoteur {

	DIESEL("Moteur Diesel"),
	ESSENCE("Moteur Essence"),
	HYBRIDE("Moteur Hybride"),
	ELECTRIQUE("Moteur Eléctrique");
	
	  private String name = "";
	   
	  //Constructeur
	  TypeMoteur(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
	
}

package com.ocr.garage;

public enum Marque {

	RENO("RENO"),
	PIGEOT("PEUGEOT"),
	TROEN("CITROEN");
	
	  private String name = "";
	   
	  //Constructeur
	  Marque(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
	
}

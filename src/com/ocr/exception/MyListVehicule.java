package com.ocr.exception;


/**
 * Exception personnalisée pour afficher une erreure quand le listing des véhicules du fichier n en est pas un
 * @author John
 */
public class MyListVehicule extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -965425950459496111L;

	public MyListVehicule(){
		System.out.println("Listing pas de type véhicule !");
	}  
	
	public MyListVehicule(String msg){
		super(msg);
	}  
}

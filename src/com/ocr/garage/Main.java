package com.ocr.garage;

//http://syncor.blogspot.fr/2013/09/getting-started-with-log4j-2-in-eclipse.html
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ocr.garage.option.BarreDeToit;
import com.ocr.garage.option.Climatisation;
import com.ocr.garage.option.GPS;
import com.ocr.garage.option.SiegeChauffant;
import com.ocr.garage.option.VitreElectrique;
import com.ocr.garage.vehicule.A300B;
import com.ocr.garage.vehicule.D4;
import com.ocr.garage.vehicule.Lagouna;

/**
 * Main class to put my garage instance and add vehicules and options
 * @author John
 * @version 1.2.0 adding generic to engine !
 *
 */
public class Main {
	
	/**
	 * Still fixing log4j2
	 * */
	public static void main(String[] args) {

		Logger logger = LogManager.getRootLogger();
		logger.trace("Configuration File Defined To Be :: "+ System.getProperty("garage"));
		

		Garage garage = new Garage();   
		logger.info("This is an info message : garage instance created");
		
		System.out.println(garage);

		Vehicule lag1 = new Lagouna();
				
		lag1.setEngine(new Moteur<TypeMoteur>("150 Chevaux", 10256d, TypeMoteur.ESSENCE));
		
		lag1.addOption(new GPS());
		lag1.addOption(new SiegeChauffant());
		lag1.addOption(new VitreElectrique());
		garage.addVoiture(lag1);
		
		
		Vehicule A300B_2 = new A300B();
		A300B_2.setEngine(new Moteur<TypeMoteur>("1500 W", 1234d,TypeMoteur.ELECTRIQUE));
		A300B_2.addOption(new Climatisation());
		A300B_2.addOption(new BarreDeToit());
		A300B_2.addOption(new SiegeChauffant());
		garage.addVoiture(A300B_2);

		Vehicule d4_1 = new D4();
		d4_1.setEngine(new Moteur<TypeMoteur>("200 Hdi", 25684.80d,TypeMoteur.DIESEL));
		d4_1.addOption(new BarreDeToit());
		d4_1.addOption(new Climatisation());
		d4_1.addOption(new GPS());
		garage.addVoiture(d4_1);   	 

		Vehicule lag2 = new Lagouna();
		lag2.setEngine(new Moteur<TypeMoteur>("500 Hdi", 456987d,TypeMoteur.DIESEL));
		garage.addVoiture(lag2);

		Vehicule A300B_1 = new A300B();
		A300B_1.setEngine(new Moteur<TypeMoteur>("ESSENCE/Electrique", 12345.95d,TypeMoteur.HYBRIDE));
		A300B_1.addOption(new VitreElectrique());
		A300B_1.addOption(new BarreDeToit());
		garage.addVoiture(A300B_1);

		Vehicule d4_2 = new D4();
		d4_2.setEngine(new Moteur<TypeMoteur>("100 KW", 1224d,TypeMoteur.ELECTRIQUE));
		d4_2.addOption(new SiegeChauffant());
		d4_2.addOption(new BarreDeToit());
		d4_2.addOption(new Climatisation());
		d4_2.addOption(new GPS());
		d4_2.addOption(new VitreElectrique());
		garage.addVoiture(d4_2);   			
		

	}
}
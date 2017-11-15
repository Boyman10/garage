package com.ocr.garage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ocr.exception.MyFileException;
import com.ocr.exception.MyListVehicule;

public class Garage {

	private List<Vehicule> voitures;
	private static Logger logger = LogManager.getRootLogger();

	public Garage() {

		voitures = getVoitures();

	}

	/**
	 * Methode pour obtenir la liste des voitures depuis le fichier - ne s'appelle que depuis le constructeur.
	 * @return
	 */
	private List<Vehicule> getVoitures() {

		List<Vehicule> cars = new ArrayList<Vehicule>();

		// Récupération informations au sein du fichier garage.txt
		//ObjectInputStream
		//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-flux-d-entree-sortie
		// Vérification de l'existence du fichier :
		ObjectInputStream ois;

		/* cas si non existant : 
		 * on remplace par gestion erreur */
		File f = new File("garage.txt");


		try {

			// Check if file exists
			testException(f);

			//On récupère maintenant les données !
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(f)));

			try {

				// on lit la liste en tant qu'objet depuis le fichier
				Object obj = ois.readObject();
				//checkTypeObject(obj);

				cars = (List<Vehicule>)obj;

				/*
			} catch (MyListVehicule e) {

				System.err.println(e.getMessage());
				 */			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			ois.close();

		} catch (MyFileException e) {
			//IDEs like Eclipse show System.err in red text and System.out in black text by default.
			System.err.println(e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
		}     			      		




		return cars;
	}


	public void addVoiture(Vehicule voit) {

		// catch error if already existing this voiture :
		if(!voitures.contains(voit)) {


			voitures.add(voit);  

			//ADD the new list to the file :
			ObjectOutputStream oos;

			try {
				oos = new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(
										new File("garage.txt"))));

				//Nous allons écrire chaque objet VEhicile dans le fichier directement sous forme de liste :
				oos.writeObject(voitures);

				logger.info("This is an info message : on écrit la liste " + voit.getMarque());

				//Ne pas oublier de fermer le flux !
				oos.close();		

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}   

		} else {
			logger.info("This is an info message : vehicule " + voit.getMarque() + " déjà présent  ...");

		}
	}	
	// On ajoute le nouvel objet voit au fichier garage en utilisant la sérialisation :
	//ObjectOutputStream


	@Override
	public String toString() {


		String str = "*************************\n" + "Garage de voitures\n" + "*************************\n";



		// iterate through the list and display :
		for(int i = 0; i < voitures.size(); i++)
		{
			str += voitures.get(i).toString();
		}  	    	



		return str;		
	}

	/**
	 * Méthode pour vérifier le type d'objet venant du fichier
	 * @param <T>
	 * @param obj
	 */
	private <T> void checkTypeObject(T obj) throws MyListVehicule {
		// Si pas de type list<Vehicule> alors on balance une erreur :
		if (obj instanceof List<?>) {

			throw new MyListVehicule("Contenu du fichier incorrect !");
		}

	}


	private void testException(File f) throws MyFileException
	{

		if (!f.exists()) {

			throw new MyFileException("Fichier pourri");

		} 


	}

}

package com.ineat.chiffreRomain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.ineat.constantes.Constantes;
import com.ineat.exception.ConversionException;
import com.ineat.utils.Utils;

/**
 * Conversion de nombres arabes en chiffres romain. <br/>
 * Les données d’entrée sont chargées depuis un fichier texte et un fichier de sortie est généré avec les couples convertis<br/>
 * Exemple : 123 donnera (123, CXXIII)
 *
 */
public class App {
	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		
		/** Initialisation des variables */
		// Texte de sortie
		StringBuilder TxtSortie = new StringBuilder();
		// Chemin du fichier à lire
		String fichierEntree = "entree.txt";
		// Chemin du fichier à générer
		String fichierSortie = "sortie.txt";
		// Buffer correspondant à chaque ligne lu du fichier en entrée
		String ligne = "";

		try {

			// lecture du fichier d'entrée
			BufferedReader br = Utils.readFile(fichierEntree);
			
			// On effectue la conversion ligne par ligne
			while ((ligne = br.readLine()) != null) {

				// Suppression des éventuels "espaces" présents sur la ligne
				ligne = ligne.trim();

				// Formatage de la ligne de sortie pour correcpondre au format "(123, CXXIII)"
				TxtSortie.append(Constantes.PARANTHESE_OUVRANTE);
				TxtSortie.append(ligne);
				TxtSortie.append(Constantes.VIRGULE);
				TxtSortie.append(Constantes.SPACE);
				
				try {
					// Conversion de la ligne
					TxtSortie.append(Utils.convertArabicNumberToRomanNumber(ligne));
				} catch (ConversionException e) {
					TxtSortie.append(e.getMessage());
				}

				TxtSortie.append(Constantes.PARANTHESE_FERMANTE);
				TxtSortie.append(Constantes.RETOUR);
			}

		} catch (FileNotFoundException e) {
			logger.error("Le fichier " + fichierEntree + " est introuvable", e);
		} catch (IOException e) {
			logger.error("Erreur lors de la lecture du fichier " + fichierEntree, e);
		}

		try {
			// création ou ajout dans le fichier de sortie 
			Utils.writeFile(fichierSortie, TxtSortie.toString());

			logger.debug("Le fichier " + fichierSortie + " a bien été généré.");
		} catch (IOException e) {
			logger.error("Erreur lors de la lecture ou ecriture du fichier " + fichierSortie, e);
		}
	}

}

package skipper;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;

/*
 * 
 * INACHEVE !!!!!
 */


public class Navigation_Sk_Affectation_ch_rap {
	
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static void click_trt_par_lots_affectation(String jur) throws InterruptedException, IOException, AWTException {
		if(jur=="TA") {
		//Click onglet "TRAITEMENT PAR LOTS"
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Trts_par_lots_ Onget - Skipper - TA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"TRAITEMENT PAR LOTS\" ...."+MesFonctions.extractCurrentHeure());
		Thread.sleep(100);
		
		//Sélection de la fonction "AFFECTATION" 
		int nbr = 1;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
		
		Thread.sleep(50);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Sélection de la mesure \"AFFECTATION\" ...."+MesFonctions.extractCurrentHeure());
		}
	}
	
	public static void effectation_dossier(String jur, String dossier) throws Throwable {
	//Entrer le numéro de dossier
		switch (jur) {
		case "TA":
			Keyboard.maStringToKeyboard(dossier);
			
			//Choisir l'entité de jugement
			//Définir un rectangle d'observation
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Entite_jugement - Mesure collective _ Affectation - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+110, coords.getFirst().getSecond(), 157, 16);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
				
				//Accéder à la liste des entités
				while(!result.contains("1ère Section - Tère Chambre")) {
					//Déplacement du curseur
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
					Thread.sleep(70);
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Entite_jugement - Mesure collective _ Affectation - TA.png";
					coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
					coords = MesFonctions.waitObject(fileImage);
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+110, coords.getFirst().getSecond(), 157, 16);
					image = MesFonctions.screenshot(bounds);
					result = MesFonctions.OCR_decryptage(image);
					}
				
				System.out.println("L'entité de jugement est sélectionnée....."+MesFonctions.extractCurrentHeure());
			
			//Choisir un rapporteur
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Rapporteur - Mesure collective _ Affectation - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+12, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(1, 1);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+106, coords.getFirst().getSecond(), 157, 14);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
				
				//Accéder à la liste des entités
				while(!result.contains("BARONNET")) {
					//Déplacement du curseur
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
					Thread.sleep(70);
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Rapporteur - Mesure collective _ Affectation - TA.png";
					coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
					coords = MesFonctions.waitObject(fileImage);
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+106, coords.getFirst().getSecond(), 160, 22);
					image = MesFonctions.screenshot(bounds);
					result = MesFonctions.OCR_decryptage(image);
					}
				System.out.println("Le rapporteur est sélectionné....."+MesFonctions.extractCurrentHeure());
				
			//Click sur le sélecteur 
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Selection - Mesure collective _ Affectation - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Le dossier est sélectionné ...."+MesFonctions.extractCurrentHeure()+"\r");
			
			//Click sur le bouton "VALIDER"
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn valider - Mesure collective _ Affectation - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"VALIDER\" ...."+MesFonctions.extractCurrentHeure()+"\r");
			
			//Confirmation de la validation, click sur le bouton "OUI"
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn confirmation validation - Mesure collective Dossier _ Affectation - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Confirmation de la validation, click sur le bouton \"OUI\" ...."+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "CAA":
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, dossier);
			Navigation_Sk_Ajout_Mesure.mesure_affectation_chambre(jur);
			Navigation_Sk_Ajout_Mesure.mesure_affectation_rapporteur(jur);
			
			break;
			
		case "CTX":
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, dossier);
			Navigation_Sk_Ajout_Mesure.mesure_affectation_chambre(jur);
			Navigation_Sk_Ajout_Mesure.mesure_affectation_rapporteur(jur);
			
			break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
	}
}

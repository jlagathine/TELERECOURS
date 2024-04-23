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
import net.sourceforge.tess4j.TesseractException;

public class Navigation_Skipper_Creation_Defendeur {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static Object selectionActeur_defendeur_requerant(String jur) throws Throwable {
		//Accès onglet acteur
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_Acteur-Skipper - TA.png";
			}
			else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_acteur 1- Cour Administrative d'Appel - Acteur.png";
				}
				else{
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_Acteur-Skipper contentieux -CE.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès à l'onglet \"Acteur\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Ajouter des acteur _ Accéder au bouton créer
				if(jur=="TA") {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur 1 - TA - creer.png";
					}
					else if(jur=="CAA") {
						fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur - Cour Administrative d'Appel - creer.png";
						}
						else{
							fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur 1 - CE- creer.png";
						}
				
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
		return null;
	}
	
	public static Object SelectionTypeActeur(String type, String jur) throws TesseractException, Throwable {
		switch (type) {
		case "avocat":
			//Sélectionner la qualité
			//click bouton selecteur
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
		
		//Créer un défendeur
		result = "";
		while(!result.contains("Avocat")) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			Thread.sleep(100);
			image = MesFonctions.screenshot(bounds);
			Thread.sleep(100);
			result = MesFonctions.OCR_decryptage(image);
			}
		System.out.println("La qualité requérant est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Keyboard.keyBoard(KeyEvent.VK_TAB);
			break;
			
			
		case "defendeur":
			//Sélectionner la qualité
			//click bouton selecteur
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
		
		//Créer un défendeur
		result = "";
		while(!result.contains("Defendeur")) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			Thread.sleep(100);
			image = MesFonctions.screenshot(bounds);
			Thread.sleep(100);
			result = MesFonctions.OCR_decryptage(image);
			}
		System.out.println("La qualité requérant est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Keyboard.keyBoard(KeyEvent.VK_TAB);
			
			break;

		default:System.err.println("Ce type d'acteur n'est pas identifié....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		return null;
	}
	
	public static String fiche_acteur(String jur, String leNom ) throws TesseractException, Throwable {
		Navigation_Skipper_InscriptionTR_Avocat.boutonAnnuaire(jur);
		nom = Navigation_Skipper_Creation_Defendeur.recherche_acteur(jur, leNom);
		return nom;
	}
	
	public static Object boutonAnnuaire(String jur) throws InterruptedException, IOException, AWTException {
		//Click bouton annuaire
		if(jur=="CAA" || jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuaire-Fiche acteur_CAA.png";
				}
				else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuaire-Fiche acteur.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Clic bouton annuaire...."+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String recherche_acteur(String jur, String leNom) throws TesseractException, Throwable {
		//Inscrit à TR décoché
		if(jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\InscritaTr-coche_CAA.png";
			}
			else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\InscritaTr-coche_CTX.png";
			}
			else {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\InscritaTr-coche.png";
			}
		
		
		//définir un rectangle d'observation
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+23, coords.getFirst().getSecond(), 278, 18);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		
		//Accéder à la liste des destinataires
//		nom = "BOUILLY";//"AMNACHE";"QUILIOT";
		while(!result.contains(leNom)) {
			//Déplacement du curseur
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+23, coords.getFirst().getSecond(), 278, 18);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			Thread.sleep(50);
			}
		
		//Validation de l'acteur
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("L'acteur est validé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
}

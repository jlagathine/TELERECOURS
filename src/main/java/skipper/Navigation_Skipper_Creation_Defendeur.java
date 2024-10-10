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
	
	public static void click_Btn_Creer (String jur) throws AWTException, InterruptedException, IOException {
		//Ajouter des acteur _ Accéder au bouton créer
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur 1 - TA - creer.png";
			}
			else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur - Cour Administrative d'Appel - creer.png";
				}
				else{
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\btn_creer-Skipper contentieux.png";
				}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

	}
	
	public static void selection_Acteur_defendeur_requerant_Constitution(String jur) throws Throwable {
		//Accès onglet acteur
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA_Btn_Acteur_Constitution.png";
			}
			else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CAA_Btn_Acteur_Constitution.png";
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
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA_Btn_Creer_Constitution.png";
			}
			else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur - Cour Administrative d'Appel - creer.png";
				}
				else{
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CTX_Btn_Creer_Constitution.png";
				}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
	public static Object SelectionQualiteActeur(String qualite, String jur) throws TesseractException, Throwable {
		switch (qualite) {
		case "avocat":
//			//Sélectionner la qualité
//			//click bouton selecteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
//		image = MesFonctions.screenshot(bounds);
//		result = MesFonctions.OCR_decryptage(image);
//		
//		//Créer un défendeur
//		while(!result.contains("Avocat")) {
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//			Thread.sleep(100);
//			image = MesFonctions.screenshot(bounds);
//			Thread.sleep(100);
//			result = MesFonctions.OCR_decryptage(image);
//			}
//		System.out.println("La qualité requérant est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
//		
//		Keyboard.keyBoard(KeyEvent.VK_TAB);
			if(jur=="CTX") {
				int nbr = 3;
				for(int i=0; i<nbr; i++) {
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			}else if(jur=="TA" || jur=="CAA") {
					int nbr = 10;
					for(int i=0; i<nbr; i++) {
						Keyboard.keyBoard(KeyEvent.VK_DOWN);
					}
			}
					
		System.out.println("La qualité avocat est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
			
		case "defendeur":
			//Sélectionner la qualité
//			//click bouton selecteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 150, 13);
//		image = MesFonctions.screenshot(bounds);
//		result = MesFonctions.OCR_decryptage(image);
//		
//		//Créer un défendeur
//		while(!result.contains("Defendeur")) {
//			Thread.sleep(100);
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 150, 13);
//			image = MesFonctions.screenshot(bounds);
//			result = MesFonctions.OCR_decryptage(image);
//			}
		if(jur=="CTX") {
				int nbr = 2;
				for(int i=0; i<nbr; i++) {
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			}else if(jur=="TA" || jur=="CAA") {
					int nbr = 3;
					for(int i=0; i<nbr; i++) {
						Keyboard.keyBoard(KeyEvent.VK_DOWN);
					}
		}
		
	
		System.out.println("La qualité défendeur est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
//		Keyboard.keyBoard(KeyEvent.VK_TAB);
			
			break;
			
		case "observateur":
//			//Sélectionner la qualité
//			//click bouton selecteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 150, 13);
//		image = MesFonctions.screenshot(bounds);
//		result = MesFonctions.OCR_decryptage(image);
//		
//		//Créer un défendeur
//		while(!result.contains("Observateur")) {
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//			Thread.sleep(100);
//			image = MesFonctions.screenshot(bounds);
//			Thread.sleep(100);
//			result = MesFonctions.OCR_decryptage(image);
//			}
			
			if(jur=="CTX") {
				int nbr = 10;
				for(int i=0; i<nbr; i++) {
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			}else if(jur=="TA" || jur=="CAA") {
					int nbr = 3;
					for(int i=0; i<nbr; i++) {
						Keyboard.keyBoard(KeyEvent.VK_DOWN);
					}
		}
			
		System.out.println("La qualité observateur est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
//		Keyboard.keyBoard(KeyEvent.VK_TAB);
			
			break;
			
		case "intervenant":
			//Sélectionner la qualité
			//click bouton selecteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
//		
//		//Créer un défendeur
//		result = "";
//		while(!result.contains("Intervenant")) {
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//			Thread.sleep(100);
//			image = MesFonctions.screenshot(bounds);
//			Thread.sleep(100);
//			result = MesFonctions.OCR_decryptage(image);
//			}
			
			if(jur=="CTX") {
				int nbr = 5;
				for(int i=0; i<nbr; i++) {
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			}else if(jur=="TA" || jur=="CAA") {
					int nbr = 3;
					for(int i=0; i<nbr; i++) {
						Keyboard.keyBoard(KeyEvent.VK_DOWN);
					}
		}
			
		System.out.println("La qualité intervenant en défense est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
//		Keyboard.keyBoard(KeyEvent.VK_TAB);
			
			break;
			
		case "requérant":
			
			if(jur=="CTX") {
				int nbr = 1;
				for(int i=0; i<nbr; i++) {
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			}else if(jur=="TA" || jur=="CAA") {
					int nbr = 3;
					for(int i=0; i<nbr; i++) {
						Keyboard.keyBoard(KeyEvent.VK_DOWN);
					}
		}
			
		System.out.println("La qualité requérant est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

		default:System.err.println("Ce type d'acteur n'est pas identifié....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		return null;
	}
	
	public static void fiche_acteur(String jur, String leNom, String type) throws TesseractException, Throwable {
		Navigation_Skipper_InscriptionTR_Avocat.boutonAnnuaire(jur);
		Navigation_Skipper_Creation_Defendeur.decoche_non_inscrit_TR(jur);
		Navigation_Skipper_Creation_Defendeur.type_juridiction(jur, type);
		Navigation_Skipper_Creation_Defendeur.Click_btn_Rechreche(jur);
		Navigation_Skipper_Creation_Defendeur.recherche_acteur(jur, leNom);
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
	
	public static void Click_btn_Rechreche(String jur) throws AWTException, IOException, InterruptedException {
		//Click bouton "RECHERCHER"
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA_Btn_Rechercher - Recherche d'une grande partie dans l'annuaire.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn_Rechercher - Recherche d'une grande partie dans l'annuaire.png";
		}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"RECHERCHER\"...."+MesFonctions.extractCurrentHeure()+"\r");
		
	}
	
	public static void recherche_acteur(String jur, String leNom) throws TesseractException, Throwable {
		//Inscrit à TR décoché
		//définir un rectangle d'observation
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(16, 258);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+22, coords.getFirst().getSecond(), 278, 18);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		
		//Accéder à la liste des destinataires
//		nom = "BOUILLY";//"AMNACHE";"QUILIOT";
		while(!result.contains(leNom)) {
			//Déplacement du curseur
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+22, coords.getFirst().getSecond(), 278, 18);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			Thread.sleep(50);
			}
		
		//Validation de l'acteur
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("L'acteur est validé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
	}
		
	public static void type_juridiction(String jur, String type) throws TesseractException, Throwable {
	//Type juridiction
	fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Type_Admin - Recherche d'une grande partie dans l'annuaire.png";
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 31, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	MesFonctions.mouveSouris(1, 1);
	bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+34, coords.getFirst().getSecond(), 127, 15);
	image = MesFonctions.screenshot(bounds);
	result = MesFonctions.OCR_decryptage(image);
	
	//Accéder à la liste des destinataires
	int cnt = 0;
	while(!result.contains(type)) {
		//Déplacement du curseur
		Thread.sleep(70);
		if(cnt == 0) {
			Keyboard.keyBoard(KeyEvent.VK_UP);
		}else {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+34, coords.getFirst().getSecond(), 127, 15);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		cnt++;
		}
	
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 31, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	System.out.println("Le type de la juridiction est sélectionné ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}

	public static void decoche_non_inscrit_TR(String jur) throws InterruptedException, IOException, AWTException {
	//Décocher l'option "Non inscrit à TR"
	fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Coche_non_inscrit_TR - Recherche d'une grande partie dans l'annuaire.png";
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	
	System.out.println("L'option \"Non inscrit à TR\" est décochée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
	public static void fiche_acteur_constitution(String jur, String leNom, String type) throws TesseractException, Throwable {
		Navigation_Skipper_InscriptionTR_Avocat.boutonAnnuaire(jur);
		Navigation_Skipper_Creation_Defendeur.decoche_non_inscrit_TR(jur);
		Navigation_Skipper_Creation_Defendeur.Click_btn_Rechreche_Constitution(jur);
		Navigation_Skipper_Creation_Defendeur.recherche_acteur_constitution(jur, leNom);
	}
	
	public static void Click_btn_Rechreche_Constitution(String jur) throws AWTException, IOException, InterruptedException {
		//Click bouton "RECHERCHER"
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA_Btn_Recherche_Constitution-Recherche d'un avocat dans l'annuaire.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CAA_Btn_Recherche_Constitution-Recherche d'un avocat dans l'annuaire.png";
		}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"RECHERCHER\"...."+MesFonctions.extractCurrentHeure()+"\r");
		
	}
	
	public static void recherche_acteur_constitution(String jur, String leNom) throws TesseractException, Throwable {
		//Inscrit à TR décoché
		//définir un rectangle d'observation
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(16, 258);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+13, coords.getFirst().getSecond(), 278, 18);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		
		//Accéder à la liste des destinataires
//		nom = "BOUILLY";//"AMNACHE";"QUILIOT";
		while(!result.contains(leNom)) {
			//Déplacement du curseur
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+13, coords.getFirst().getSecond(), 278, 18);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			Thread.sleep(50);
			}
		
		//Validation de l'acteur
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("L'acteur est validé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
}

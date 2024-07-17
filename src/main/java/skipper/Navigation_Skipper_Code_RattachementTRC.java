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

public class Navigation_Skipper_Code_RattachementTRC {
	
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static Object creationActeurRequerant_Defendeur(String jur) throws Throwable {
		switch (jur) {
		case "CAA":
			//Accès onglet acteur
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_acteur 1- Cour Administrative d'Appel - Acteur.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Accès à l'onglet \"Acteur\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Ajouter des acteur _ Accéder au bouton créer
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur - Cour Administrative d'Appel - creer.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Remplissage de la fiche acteur
			Navigation_Skipper_Code_RattachementTRC.ficheActeurPhysiqueMoral(jur);
			
			break;
			
		case "CTX":
			//Accès onglet acteur
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_Acteur-Skipper contentieux -CE.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Accès à l'onglet \"Acteur\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Ajouter des acteur _ Accéder au bouton créer
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur 1 - CE- creer.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Remplissage de la fiche acteur
			Navigation_Skipper_Code_RattachementTRC.ficheActeurPhysiqueMoral(jur);
			
			break;
			
		case "TA":
			//Accès onglet acteur
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_Acteur-Skipper - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Accès à l'onglet \"Acteur\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Ajouter des acteur _ Accéder au bouton créer
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur 1 - TA - creer.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Remplissage de la fiche acteur
			Navigation_Skipper_Code_RattachementTRC.ficheActeurPhysiqueMoral(jur);
			
			break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		return null;
	}
	
	public static Object ficheActeurPhysiqueMoral(String jur) throws Throwable {
		Navigation_Skipper_Code_RattachementTRC.selectionQualiteActeurMoral(jur);
		Navigation_Skipper_Code_RattachementTRC.nomActeurMoral(jur);
		if(jur=="CTX" || jur=="CAA") {
			Navigation_Sk_Choix_Civ.choix_civ_fiche_acteur_moral(jur);
//			Navigation_Sk_Choix_Civ.choix_civ_acteur_phys(jur, "monsieur");
		}
//		Navigation_Skipper.prenomActeurPhysique(jur);
		Navigation_Skipper_Code_RattachementTRC.adresseActeurMoral(jur);
		Navigation_Skipper_Code_RattachementTRC.villeActeurMoral(jur);
		Navigation_Skipper_Code_RattachementTRC.CPActeurMoral(jur);
		
		
		//Valider la fiche acteur
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Fiche acteur validée ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		if(jur=="TA") {
			Thread.sleep(100);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA2 - bouton_Annuler - Skipper - Liste des dossiers rapprochés.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
			
			while(!coords.equals(coords1)) {
				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				Thread.sleep(1000);
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA2 - bouton_Annuler - Skipper - Liste des dossiers rapprochés.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//				coords = MesFonctions.waitObject(fileImage);
//				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				System.out.println("Fiche de rapprochement des acteurs - Click sur le bouton \"Annuler\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			}
		}
		return null;
	}
	
	public static Object selectionQualiteActeurPhys(String jur) throws InterruptedException, IOException, AWTException {	
	//Sélectionner la qualité
		//click bouton selecteur
	fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite1 - Fiche acteur.png";
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	
	//Créer un requérant
	int nbr = 1;
	for(int i=0; i<nbr; i++) {
		Keyboard.keyBoard(KeyEvent.VK_DOWN);
	}
	System.out.println("La qualité requérant est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
	Keyboard.keyBoard(KeyEvent.VK_TAB);
	
	return null;
	}
	
	public static Object selectionQualiteActeurMoral(String jur) throws TesseractException, Throwable {	
	//Sélectionner la qualité
		//click bouton selecteur
	fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
//	mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	
	//Créer un défendeur
	result = "";
	while(!result.contains("Defendeur")) {
		Keyboard.keyBoard(KeyEvent.VK_DOWN);
		Thread.sleep(100);
		image = MesFonctions.screenshot(bounds);
		Thread.sleep(100);
		result = MesFonctions.OCR_decryptage(image);
		}
	System.out.println("La qualité \"Dédfendeur\" est sélectionnée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
	Keyboard.keyBoard(KeyEvent.VK_TAB);
	
	return null;
	}
	
	//ACTEUR MORAL
	public static Object nomActeurMoral(String jur) throws Exception {
		//Remplir la fiche requérant NOM
		if(jur=="CTX" ) {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Acteur_moral-Skipper_CTX - Fiche acteur.png";
			}
			else if(jur=="TA"){
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Acteur_moral-Skipper_TA1 - Fiche acteur.png";
					}
					else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Acteur_moral-Skipper - Fiche acteur.png";//Nom_Acteur_moral-Skipper_CAA1 - Fiche acteu
					}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ NOM ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		nom = "DOLANTO";
		Keyboard.maStringToKeyboard(nom);
		
		return null;	
		}
	
	
	public static Object adresseActeurMoral(String jur) throws Exception {
		//Remplir la fiche requérant_ADRESSE
		if(jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Adresse_Acteur_Moral - Skipper_CTX - Fiche acteur.png";
			}
			else if(jur=="TA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Adresse_Acteur_Moral - Skipper_TA - Fiche acteur.png";
					}
					else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Adresse_Acteur_Moral - Skipper - Fiche acteur.png";
					}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ ADRESSE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		String str = "9, rue de la charnière";
		Keyboard.pressPapier(str);
		
		return null;
	}
	
	public static Object villeActeurMoral(String jur) throws Exception {
		//Remplir la fiche requérant_VILLE
		if(jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ville_Acteur_Moral-Skipper_CTX - Fiche acteur.png";
			}else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ville_Acteur_Phys-Skipper CAA- Fiche acteur.png";
				}
				else {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ville_Acteur_Moral-Skipper TA- Fiche acteur.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ VILLE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		String str = "PARIS";
		Keyboard.maStringToKeyboard(str);
		Thread.sleep(700);
		
		return null;
	}
	
	public static Object CPActeurMoral(String jur) throws Exception {
		//Remplir la fiche requérant_CP
		if(jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CP_Acteur_moral - Skipper_CTX - Fiche acteur.png";
			}
			else if(jur=="TA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CP_Acteur_moral - Skipper_TA - Fiche acteur.png";//CP_Acteur_moral - Skipper_TA - Fiche acteur ; CP_Acteur_moral - Skipper_TA1 - Fiche acteur
				}
				else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CP_Acteur_moral - Skipper - Fiche acteur.png";//CP_Acteur_moral - Skipper - Fiche acteur
					}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick((coords.getFirst().getFirst() + coords.getSecond().getFirst()/2)+10, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ CP ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(500);
		String str = "75002";
		Keyboard.maStringToKeyboard(str);
	
		return null;
	}
	
	
	//ACTEUR PHYSIQUE
	public static Object nomActeurPhysique(String jur) throws Exception {
		//Remplir la fiche requérant NOM
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Acteur-Skipper - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ NOM ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		nom = "DOKAN";
		Keyboard.maStringToKeyboard(nom);
		
		return null;	
		}
	
	public static Object prenomActeurPhysique(String jur) throws Exception {
		switch (jur) {
		case "TA":
		//Remplir la fiche requérant PRENOM
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Prenom_Acteur-Skipper -TA - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ PRENOM ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		String str = "Mireille";
		Keyboard.maStringToKeyboard(str);
		
		break;
		
		case "CAA":
		//Remplir la fiche requérant PRENOM
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Prenom_Acteur-Skipper - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ PRENOM ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		str = "Mireille";
		Keyboard.maStringToKeyboard(str);
		
		break;
		
		case "CTX":
		//Remplir la fiche requérant PRENOM
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Prenom_Acteur-Skipper - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ PRENOM ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		str = "Mireille";
		Keyboard.maStringToKeyboard(str);
		
		break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
	return null;
	}
	
	public static Object adresseActeurPhysique(String jur) throws Exception {
		//Remplir la fiche requérant_ADRESSE
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Adresse_Acteur-Skipper - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ ADRESSE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		String str = "9, rue de la charnière";
		Keyboard.pressPapier(str);
		
		return null;
	}
	
	public static Object villeActeurPhysique(String jur) throws Exception {
		//Remplir la fiche requérant_VILLE
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ville_Acteur_Phys-Skipper - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ VILLE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		String str = "PARIS";
		Keyboard.maStringToKeyboard(str);
		Thread.sleep(500);
		
		return null;
	}
	
	public static Object CPActeurPhysique(String jur) throws Exception {
		//Remplir la fiche requérant_CP
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CP_Acteur-Skipper - Fiche acteur.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au champ CP ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		String str = "75002";
		Keyboard.maStringToKeyboard(str);
		
		Thread.sleep(500);
		
		return null;
	}
	
	public static Object mesureRattachementTRC(String jur) throws Throwable {
		switch (jur) {
		case "TA":
			//Click onglet mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - TA - Mesure.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setRectangle(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(0, 0);
			System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Top_famile_mesure_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setRectangle(fileImage);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			break;
			
		case "CTX":
			//Click onglet mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - CE - Mesure.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setRectangle(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(0, 0);
			System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Top_famile_mesure_CE.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setRectangle(fileImage);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			break;
			
		case "CAA":
			//Click onglet mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - Cour Administrative d'Appel - Mesure.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setRectangle(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(0, 0);
			System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure1.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setRectangle(fileImage);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			break;

		default:System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		//Accès à la famille de mesure
		switch (jur) {
		case "TA" :
			int nbr = 12;//Famille de mesure AUTRES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
			break;
			
		case "CAA" :
			nbr = 13;//Famille de mesure AUTRES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
			break;
			
		case "CTX" :
			nbr = 11;//Famille de mesure AUTRES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			}
		
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Recherche d'une mesure
			//Choix d'une de la mesure
		switch (jur) {
		case "TA":
			int nbr = 4;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CAA":
			nbr = 2;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 15;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		//Valider la mesure
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à la MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
			
	}
	
	public static Object aValiderDansTr(String jur) throws Exception, IOException, AWTException {
		switch (jur) {
		case "TA":
			//Décocher "A valider dans TR"
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Valider dans TR_coche-TA1.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			
			System.out.println("A valider dans TR, décoché ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "CAA":
			//Décocher "A valider dans TR"
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Valider dans TR_coche-CAA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			
			System.out.println("A valider dans TR, décoché ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "CTX":
			//Décocher "A valider dans TR"
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Valider dans TR_coche-TA1.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			
			System.out.println("A valider dans TR, décoché ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			}
	
	return null;
	}
	
	public static Object traitementDeTexte(String jur) throws InterruptedException, IOException, AWTException {
		//Choisir l'imprimante
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choisir_imprimante-Communication du code Télérecours citoyens.png";
		}else if(jur=="CTX"){
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choisir_imprimante-CE.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choisir_imprimante-CAA.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton CHOISIR L'IMPRIMANTE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Choisir le traitement de texte
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Traitement_Texte-Configuration de la sortie.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Coche TRAITEMENT DE TEXTE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Valider le traitement de texte 
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider_dossier-Skipper - Ouverture de dossier.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Validation du type de TRAITEMENT DE TEXTE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Thread.sleep(700);
		return null;
	}
	
	
	public static Object gererDestinataireCourrier() throws TesseractException, IOException, AWTException, Throwable {
		//Passer tous les acteurs dans l'encart ACTEUR
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\retrait_Acteur_grise-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
		Thread.sleep(100);
		while(coords.equals(coords1)) {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Retrait d'un acteur depuis destinataire-Communication du code Télérecours citoyens.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(0, 0);
			Thread.sleep(500);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\retrait_Acteur_grise-Communication du code Télérecours citoyens.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		}
		
		System.out.println("Tous les acteurs sont passés dans la case ACTEUR...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//définir un rectangle d'observation
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 221, 18);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		
		//Accéder à la liste des destinataires
		while(!result.contains(nom)) {
			//Déplacement du curseur
			Thread.sleep(50);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 221, 18);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
		
		//Ajout acteur dana la case destinataire
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ajout_Acteur_Destinataire-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("L'acteur ciblé est dans la case destinataire...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Valider l'envoi de la mesure
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OK-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Validation de l'envoi de la mesure ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object creationFichierRTF(String jur) throws InterruptedException, IOException, AWTException {
		//PopUp de validation du fichier
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OUI-Fichier c__temp_RATACTRC.rtf.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Supression du précédent fichier de rattachement ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		if(jur=="TA") {
			//PopUp de validation de la création du fichier
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Valider-Fichier c__temp_RATACTRC.rtf.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Validation de la création du fichier ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
		
		//Attente de la génération du fichier RTF
		Thread.sleep(100);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier c__temp_RATACTRC.rtf.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		
		while(!coords.equals(coords1)) {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier c__temp_RATACTRC.rtf.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			}
		}
		System.out.println("Le fichier a été généré....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
}

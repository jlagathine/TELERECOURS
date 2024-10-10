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

public class Navigation_Skipper_InscriptionTR_Adm {
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
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
//		
//		//Créer un défendeur
//		result = "";
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
			//click bouton selecteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
//		
//		//Créer un défendeur
//		result = "";
//		while(!result.contains("Defendeur")) {
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
			
			break;

		default:System.err.println("Ce type d'acteur n'est pas identifié....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		return null;
	}
	
	public static String fiche_acteur(String jur, String nomAdm, String type) throws TesseractException, Throwable {
		Navigation_Skipper_InscriptionTR_Adm.boutonAnnuaire(jur);
		nom = Navigation_Skipper_InscriptionTR_Adm.recherche_acteur(jur, nomAdm, type);
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
		System.out.println("Clic bouton ANNUAIRE...."+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String recherche_acteur(String jur, String nomAdm, String type) throws TesseractException, Throwable {
		//Inscrit à TR décoché
		if(jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\InscritaTr-coche_CAA.png";
			}
			else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\InscritaTr-coche_CTX1.png";
			}
			else {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\InscritaTr-coche.png";
			}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("\"Inscrit à TR\" décoché...."+MesFonctions.extractCurrentHeure());
		
		
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
			int count = 0;
			while(!result.contains(type)) {
				//Déplacement du curseur
				Thread.sleep(70);
				if(count == 0 ) {
				Keyboard.keyBoard(KeyEvent.VK_UP);
				}else {
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Type_Admin - Recherche d'une grande partie dans l'annuaire.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+34, coords.getFirst().getSecond(), 127, 15);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
			}
			
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 31, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Le type de la juridiction est sélectionné ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Rechercher_Nom-Recherche d'une grande partie dans l'annuaire.png";
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Rechercher_Nom1-Recherche d'une grande partie dans l'annuaire.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"Rechercher\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		
		//définir un rectangle d'observation
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
//		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+22, coords.getFirst().getSecond(), 281, 18);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+306, coords.getFirst().getSecond(), 75, 16);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		
		//Accéder à la liste des destinataires
		while(!result.contains(nomAdm)) {
			//Déplacement du curseur
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+22, coords.getFirst().getSecond(), 281, 16);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+306, coords.getFirst().getSecond(), 75, 16);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			Thread.sleep(50);
			}
		
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+306, coords.getFirst().getSecond(), 72, 18);
		image = MesFonctions.screenshot(bounds);
		nom = MesFonctions.OCR_decryptage(image);
		
		//Validation de l'acteur
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("L'acteur est validé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return nom;
	}
	
	public static Object accesMesuresContextuelles(String jur) throws Throwable {
		//Click onglet "HISTORIQUE"
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ongle_Historique-Skipper-TA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"HISTORIQUE\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		
		//Déplacement du curseur vers le haut de l'historique - > Recherche ligne "requête nouvelle"
		String nomHist = "ouvel";
		if(jur=="TA" || jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur1-Skipper.png";
			MesFonctions.OCR_champ_text_up(fileImage, coords, bounds, image, result, nomHist, 84, 208, 18);
		
		//click MESURES CONTEXTUELLES
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesures_contextuelles-Skipper - TA.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesures_contextuelles-Skipper - CAA.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"MESURES CONTEXTUELLES\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		}else {
			nomHist = "Mémoire introductif";
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
			MesFonctions.OCR_champ_text_up(fileImage, coords, bounds, image, result, nomHist, 79, 187, 16);
		
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesures_contextuelles-Skipper - CTX.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"MESURES CONTEXTUELLES\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		}
			
		//Accès mesures contextuelles
			//Choix d'une de la mesure
		switch (jur) {
		case "TA":
			int nbr = 16;
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
			nbr = 3;
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

	public static Object validationCourrierDansTr(String jur) throws IOException, AWTException, Exception {
		return Navigation_Skipper_Code_RattachementTRC.aValiderDansTr(jur);
	}
		
	public static Object traitementDeTexte_courrier(String jur) throws InterruptedException, IOException, AWTException {
		return Navigation_Skipper_Code_RattachementTRC.traitementDeTexte(jur);
	}
	
	public static Object selectionDestinataireCourrier(String jur) throws TesseractException, IOException, AWTException, Throwable {
		//Passer tous les acteurs dans l'encart ACTEUR
		if(jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Defendeur_CAA-Communication req-invitations à consulter et à s'inscrire.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Choix destinataire effectué ...."+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(700);
		}
		
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\retrait_Acteur_grise-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
		Thread.sleep(100);
		while(coords.equals(coords1)) {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Retrait d'un acteur depuis destinataire-Communication du code Télérecours citoyens.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//			coords = mesFonctions.waitObject(fileImage);
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
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		coords = mesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+12, coords.getFirst().getSecond(), 221, 18);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image).trim();
		
		//Accéder à la liste des destinataires
		while(!result.contains(nom.trim())) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			//Déplacement du curseur
			Thread.sleep(500);
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+12, coords.getFirst().getSecond(), 221, 18);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			System.out.println(result+"******"+nom);
			}
		
		System.out.println("L'acteur est selectionné....."+MesFonctions.extractCurrentHeure());
		
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
	
	public static Object genererFichierRTF(String jur) throws InterruptedException, IOException, AWTException {
		Thread.sleep(800);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Invitation Inscription Télérecours_TA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage) ;
		
		if(coords.equals(coords1)) {
			System.out.println("Pas de fenêtre d'alerte");
		}
		else {
			//PopUp 
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Validation de la création du fichier ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		Thread.sleep(200);
		//PopUp de validation du fichier
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OUI-Fichier c__temp_RATACTRC.rtf.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Supression du précédent fichier d'inscription ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Attente de la génération du fichier RTF
		Thread.sleep(1000);
		if(jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier_temp_RATACTRC_CAA.rtf.png";
		}else if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier c__temp_RATACTRC2.rtf.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier_temp_RATACTRC_CTX.rtf.png";
		}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		
		while(!coords.equals(coords1)) {
			if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier_temp_RATACTRC_CAA.rtf.png";
			}else if(jur=="TA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier c__temp_RATACTRC2.rtf.png";
			}else {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier_temp_RATACTRC_CTX.rtf.png";
			}
			
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			System.out.println("Fichier en cours de création...");
		}
		
		//valider
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Valider-Fichier_temp_INSCRTR_TA.png";
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Fichier généré ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
}

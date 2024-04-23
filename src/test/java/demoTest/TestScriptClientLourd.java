package demoTest;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;
import pdfGeneration.PdfCreationEtEcriture;
import skipper.Navigation_Skipper_Code_RattachementTRC;

public class TestScriptClientLourd {
	static BufferedImage image;
	static String fileImage;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Rectangle bounds;
	static String result;

	public static void main(String[] args) throws AWTException, IOException, Throwable {
		//Recherche icone
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\logoBAMO.png";
//		Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords = captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		
////		Pair<BufferedImage, BufferedImage> images  = captureIcone.captureSceen(fileImage);
////		Pair<Pair<Integer, Integer>, Pair<Integer,Integer>> coords = captureIcone.coordinatesPixels(images);
//		
//		//Click sur l'icone
//		mesFonctions.doubleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Click icone BAMO ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Récupération des coordonnées de l'image afin d'en prendre une capture(screenshot)
//		fileImage  = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Selecteur-Lanceur Skipper - BAMO.png";
//		Rectangle bounds = mesFonctions.setRectangle(fileImage);
//		
//		//pointer le curseur sur l'application via la tabulation
//		Keyboard.keyBoard(KeyEvent.VK_TAB);
//		System.out.println("Positionnement du curseur sur l'application");
//		Thread.sleep(1000);
//		
//		//Défilement de la liste déroulante
//		String result = "";
//		@SuppressWarnings("unused")
//		int tr = 0;
//		while(!result.contains("RECETTE SKIPPER CAA75")) {
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//			Thread.sleep(50);
//			image = mesFonctions.screenshot(bounds);
//			result = mesFonctions.OCR_decryptage(image);
//			tr++;
//			}
//		System.out.println("juridiction trouvée ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Identification de l'image + def des coordonnées
////		Thread.sleep(2000);
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKCA75-Lanceur Skipper - BAMO.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		
//		//Click sur l'icone
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Click sur le bouton \"Skipper contentieux\" ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		Thread.sleep(1000);
		
		
		
		//vérification de la fenêtre
//		Thread.sleep(5000);
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper - Connexion.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
//		
//		System.out.println(bounds);
//
//			//cature de l'emplacement
//			image = mesFonctions.screenshot(bounds);
//			result = mesFonctions.OCR_decryptage(image);
//			
//			if(result.contains("Cours")) {
//				System.out.println("Juridiction : "+result);
//			}
//		
		
		
		
//		//Renseigner les identifiants
//		String str = "lb";
//		Keyboard.maStringToKeyboard(str);	
//
//		System.out.println("Identifiant renseigné...."+mesFonctions.extractCurrentHeure());
//		
//		Keyboard.keyBoard(KeyEvent.VK_TAB);
//		
//		Keyboard.maStringToKeyboard(str);
//		System.out.println("Mot de passe renseigné...."+mesFonctions.extractCurrentHeure());
//		
//		//Identification de l'image + def des coordonnées
//		Thread.sleep(2000);
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bout_valider1-Skipper - Connexion.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		
//		//Click sur le bouton valider
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Validation des identifiants...."+mesFonctions.extractCurrentHeure());
		
		
		
		//Click icone dossier
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\IconeDossier-Skipper CAA - Cour Administrative d'Appel.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Click sur l'icone dossier ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure());
//		
//		//Indiquer le numéro du dossier
//		String str = "23138";
//		Keyboard.maStringToKeyboard(str);
//		System.out.println("nNuméro de dossier renseigné ...."+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Valider le choix du dossier
//		Thread.sleep(200);
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider_dossier3-Skipper - Ouverture de dossier.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Choix du dossier valider ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		

		
		//Clicquer sur l'onglet acteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_acteur 1- Cour Administrative d'Appel - Acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès à l'onglet acteur ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
//		//Ajouter des acteur _ Accéder au bouton créer
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur - Cour Administrative d'Appel - creer.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Sélectionner la qualité
//			//click bouton selecteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite1 - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		
//		//Créer un défendeur
//		int nbr = 3;
//		for(int i=0; i<nbr; i++) {
//			mesFonctions.keyBoard(KeyEvent.VK_DOWN);
//		}
//		System.out.println("La qualité défendeur est sélectionnée....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//accéderà l'annuaire des administrations
//		nbr = 2;
//		for(int i=0; i<nbr; i++) {
//			mesFonctions.keyBoard(KeyEvent.VK_TAB);
//		}
//		System.out.println("la fenêtre de l'annuaire est ouverte ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Cliquer sur le bouton annuaire
//		mesFonctions.keyBoard(KeyEvent.VK_ENTER);
//		
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Champ_code_nom-Recherche d'une grande partie dans l'annuaire.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès au champ \"CODE NOM\" ...."+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Taper le code nom de l'administration
//		mesFonctions.keyBoard(KeyEvent.VK_CAPS_LOCK );
//		
//		str = "adp";
//		Keyboard.maStringToKeyboard(str);
//		
//		mesFonctions.keyBoard(KeyEvent.VK_CAPS_LOCK );
//		
//		System.out.println("Le code nom du défendeur est renseigné ...."+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Rechercher
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Rechercher_Nom1-Recherche d'une grande partie dans l'annuaire.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Le code nom du défendeur est recherché ...."+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Valider la sélection
//		mesFonctions.keyBoard(KeyEvent.VK_ENTER);
//		System.out.println("Le code nom du défendeur est validé...."+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Annuler le choix de du défendeur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Annuler-Skipper - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("La fiche du défendeur est refusée ...."+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
		//Ajouter des acteur _ Accéder au bouton créer
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_creer_acteur - Cour Administrative d'Appel - creer.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Ajout d'un acteur - Click sur le bouton \"Créer\" ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		//Sélectionner la qualité
			//click bouton selecteur
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bouton_Selecteur_qualite1 - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		//Créer un requérant
//		int nbr = 1;
//		for(int i=0; i<nbr; i++) {
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//		}
//		System.out.println("La qualité requérant est sélectionnée ...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		Keyboard.keyBoard(KeyEvent.VK_TAB);
		
		//Remplir la fiche requérant
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Acteur-Skipper - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès au champ NOM ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		String nom = "TENONE";
//		Keyboard.maStringToKeyboard(nom);
		
		//Remplir la fiche requérant_PRENOM
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Prenom_Acteur-Skipper - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès au champ PRENOM ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		String str = "Fabrice";
//		Keyboard.maStringToKeyboard(str);
		
		
		
		//Remplir la fiche requérant_ADRESSE
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Adresse_Acteur-Skipper - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès au champ ADRESSE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		String str = "9, rue de la charnière";
//		Keyboard.pressPapier(str);
		
		//Remplir la fiche requérant_VILLE
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ville_Acteur_Phys-Skipper - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès au champ VILLE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		str = "PARIS";
//		Keyboard.maStringToKeyboard(str);
		
		//Remplir la fiche requérant_CP
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CP_Acteur-Skipper - Fiche acteur.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès au champ CP ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		str = "75002";
//		Keyboard.maStringToKeyboard(str);
//		
//		Thread.sleep(500);
		
		//Valider la fiche acteur
//		Keyboard.keyBoard(KeyEvent.VK_ENTER);
//		System.out.println("Fiche acteur validée ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
		//Click onglet mesure
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - Cour Administrative d'Appel - Mesure.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		bounds = mesFonctions.setRectangle(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		mesFonctions.mouveSouris(0, 0);
//		System.out.println("Accès à l'onglet MESURE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		Keyboard.keyBoard(KeyEvent.VK_DOWN);
//		
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure1.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		bounds = mesFonctions.setRectangle(fileImage);
//		image = mesFonctions.screenshot(bounds);
//		result = mesFonctions.OCR_decryptage(image);
//		
//		//Recherche d'une mesure
//		int nbr = 13;//rattachement TRC)
//		for(int i=0; i<nbr; i++) {
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//		}
//		//Validation 
//		Keyboard.keyBoard(KeyEvent.VK_ENTER);
//		System.out.println("Accès à la FAMILLE DE MESURE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
		//Choix d'une de la mesure
//		int nbr = 2;
//		for(int i=0; i<nbr; i++) {
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//		}
		//Validation 
//		Keyboard.keyBoard(KeyEvent.VK_ENTER);
//		System.out.println("Accès à la MESURE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
		//Décocher "A valider dans TR"
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Valider dans TR_coche-Communication du code Télérecours citoyens.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("A valider dans TR, décoché ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
//		//Choisir l'imprimante
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choisir_imprimante-Communication du code Télérecours citoyens.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Click bouton CHOISIR L'IMPRIMANTE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Choisir le traitement de texte
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Traitement_Texte-Configuration de la sortie.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Coche TRAITEMENT DE TEXTE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Valider le traitement de texte 
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider_dossier-Skipper - Ouverture de dossier.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Validation du type de TRAITEMENT DE TEXTE ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
//		//Passer tous les acteurs dans l'encart ACTEUR
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\retrait_Acteur_grise-Communication du code Télérecours citoyens.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
		Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
//		Thread.sleep(100);
//		while(coords.equals(coords1)) {
//			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Retrait d'un acteur depuis destinataire-Communication du code Télérecours citoyens.png";
//			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//			coords = mesFonctions.waitObject(fileImage);
//			mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//			mesFonctions.mouveSouris(0, 0);
//			Thread.sleep(500);
//			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\retrait_Acteur_grise-Communication du code Télérecours citoyens.png";
//			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		}
//		
//		System.out.println("Tous les acteurs sont passés dans la case ACTEUR...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//définir un rectangle d'observation
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		bounds = mesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 221, 18);
//		image = mesFonctions.screenshot(bounds);
//		result = mesFonctions.OCR_decryptage(image);
//		
//		//Accéder à la liste des destinataires
//		String nom = "";
//		int tr = 0;
//		while(!result.contains(nom)) {
//			//Déplacement du curseur
//			Thread.sleep(50);
//			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
//			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//			coords = mesFonctions.waitObject(fileImage);
//			bounds = mesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 221, 18);
//			image = mesFonctions.screenshot(bounds);
//			result = mesFonctions.OCR_decryptage(image);
//			Keyboard.keyBoard(KeyEvent.VK_DOWN);
//			tr++;
//			}
//		
//		//Ajout acteur dana la case destinataire
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ajout_Acteur_Destinataire-Communication du code Télérecours citoyens.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("L'acteur ciblé est dans la case destinataire...."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Valider l'envoi de la mesure
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OK-Communication du code Télérecours citoyens.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Validation de l'envoi de la mesure ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
//		//PopUp de validation du fichier
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OUI-Fichier c__temp_RATACTRC.rtf.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Validation de la création du fichier ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//		//Attente de la génération du fichier RTF
//		Thread.sleep(2000);
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier c__temp_RATACTRC.rtf.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		
//		while(!coords.equals(coords1)) {
//			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_Annuler-Génération du fichier c__temp_RATACTRC.rtf.png";
//			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		}
		
		//Récupération du code de rattachement
//		String code = pdfCreationEtEcriture.convertionRTFtoPDF();
		
//		//Fermeture de l'application
//			//Accès à l'onglet du dossier
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_Dossier- Cour Administrative d'Appel.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès à l'onglet DOSSIER ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//			//Click sur le menu QUITTER
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Quitter_Application.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Accès au bouton QUITTER ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//			//Confirmation de la fermeture de l'application
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OUI-Fichier c__temp_RATACTRC.rtf.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Confirmation de la fermeture de l'application ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
		
		
			//Réduction de la fenêtre word
//		mesFonctions.singleClick(255, 515);
//		Thread.sleep(200);
//		Keyboard.keyBoardShortCut(KeyEvent.VK_WINDOWS, KeyEvent.VK_DOWN);
//		System.out.println("La fenêtre word est réduite....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
//		//Fermeture de lanceur BAMO
//			//Accès bouton "Quitter le programme" du lanceur BAMO
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Quitter_Lanceur_BAMO-Lanceur Skipper - BAMO.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Click bouton : QUITTER LE PROGRAMME ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//		
//			//Confirmation de la fermeture de l'application
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Confirmation-Quitter_BAMO.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) captureIcone.capture(fileImage);
//		coords = mesFonctions.waitObject(fileImage);
//		mesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Confirmation de la fermeture du lanceur BAMO ....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
		
//		Navigation_Skipper.ouvertureBAMO();
	}

}

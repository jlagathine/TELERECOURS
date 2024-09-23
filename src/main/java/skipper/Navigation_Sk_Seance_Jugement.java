package skipper;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;
import net.sourceforge.tess4j.TesseractException;

public class Navigation_Sk_Seance_Jugement {

	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static String creation_seance(String jur, String heure, String dossier) throws Throwable {
		//Click onglet SEANCE
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Seance - Skipper contentieux.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"SEANCE\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Choix de la fonction - Séance de jugement 
		int nbr = 3;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		System.out.println("Choix de la fonction - Séance de jugement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		
		//Création de la séance de jugement
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn_CREER - Liste des séances de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"CREER\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//inscription de la date
		Keyboard.maStringToKeyboard(MesFonctions.extractCurrentDate().replaceAll("/", ""));
		Thread.sleep(150);
		Keyboard.keyBoard(KeyEvent.VK_TAB);
		Thread.sleep(150);
		Keyboard.maStringToKeyboard(heure);
		Thread.sleep(150);
		Keyboard.keyBoard(KeyEvent.VK_TAB);
		
		System.out.println("Inscription de la date......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Formation de jugement 
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Formation_jugement - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+115, coords.getFirst().getSecond(), 220, 15);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		
		//Accéder à la liste des destinataires
		while(!result.contains("1ère chambre jugeant seule")) {
			//Déplacement du curseur
			Thread.sleep(70);
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Formation_jugement - Fiche de séance de jugement.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+115, coords.getFirst().getSecond(), 220, 15);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			}
		
		System.out.println("Choix de l'Entité Organisationnelle réalisé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		
		//Choix du commissaire
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choix_Commissaire - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 180, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		nbr = 1;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 180, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Choix du commisaire réalisé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
		//Choix du dossier
		nbr = 2;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_TAB);
		}
		Keyboard.maStringToKeyboard(dossier);
		System.out.println("Dossier renseigné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Choix du rapporteur
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choix_rapporteur - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 180, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		nbr = 3;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 180, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Choix du rapporteur effectué......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Enrolement du dossier
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Enrolement_dossier - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Confirmation_Enrolement_Dossier.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Confirmation-1_Enrolement_Dossier.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Enrolement du dossier......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Validation_fiche_audience - Fiche d'audience.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Validation fiche enrôlement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Validation_sauveguarde - Fiche de séance de jugement.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		System.out.println("Validation fiche enrôlement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Validation_Enrolement - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Validation de l'enrolement du dossier......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Récupération ID role
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Colonne_Id_Role - Liste des séances de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+27, coords.getFirst().getSecond(), 47, 16);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		
		System.out.println("Numero de rôle : "+result+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Fermeture de la fiche d'enrolement
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Fermer_Fiche_Enrolement - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Fermeture de la fiche d'enrôlement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		
		
		Thread.sleep(200);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Fermeture_liste_seance_jugement - Liste des séances de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Fermeture de la liste des séances de jugement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return result;
	}
	
	public static void saisie_sens_decision(String jur, String date, String heure, String dossier, String role) throws TesseractException, Throwable {
		//Click onglet SEANCE
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Seance - Skipper contentieux.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"SEANCE\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Choix de la fonction - Séance de jugement 
		int nbr = 6;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		System.out.println("Choix de la fonction - Séance de jugement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		
		//Click sur le rôle d'audience
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur-Liste des audiences pour mise à disposition.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(0, 0);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+97, coords.getFirst().getSecond(), 45, 18);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		//Accéder à la liste des destinataires
		int cnt = 0;
		while(!result.contains(role)) {
			//Déplacement du curseur
			Thread.sleep(70);
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur-Liste des audiences pour mise à disposition.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+97, coords.getFirst().getSecond(), 45, 18);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			cnt++;
			}
		
		System.out.println("trouvé");
		
		//Click onglet SEANCE
		if(cnt==0) {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn_Dossier - Liste des audiences pour mise à disposition.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"DOSSIER\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn_Dossier1 - Liste des audiences pour mise à disposition.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click bouton \"DOSSIER\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		//Choix du président
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choix_president - Liste_audience.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 180, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		nbr = 3;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 180, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Choix du président effectué......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Choix de la date de mise à disposition
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Date - Mise à disposition.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 70, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		Keyboard.maStringToKeyboard(MesFonctions.extractCurrentDate().replaceAll("/", ""));
		
		System.out.println("Date fixée......"+MesFonctions.extractCurrentHeure()+"\r");
		
		Keyboard.keyBoard(KeyEvent.VK_TAB);
		Thread.sleep(150);
		Keyboard.maStringToKeyboard(heure);
		
		//Appliquer la date de mise à disposition 
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Appliquer_Date - Mise_a_disposition.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		System.out.println("Date de mise à disposition appliquée......"+MesFonctions.extractCurrentHeure()+"\r");
		
		//Confirmation de la mise à disposition
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Confirmation_Enrolement_Dossier.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		
		//Renseigner l'issue dde jugement
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Issue_decision_CTX.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		//Renseigner l'issue 
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Emplacement_Dispositif.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		Keyboard.maStringToKeyboard("REJET");
		System.out.println("Issue renseignée......"+MesFonctions.extractCurrentHeure()+"\r");
		
		
		//Définir l'issue
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Issue_par_rapport_a_la_demande.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2+312, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+312, coords.getFirst().getSecond(), 186, 15);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		//Accéder à la liste des destinataires
		while(!result.contains("Rejet")) {
			//Déplacement du curseur
			Thread.sleep(70);
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Issue_par_rapport_a_la_demande.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+312, coords.getFirst().getSecond(), 186, 15);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			}
		
		//Validation de l'issue 
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Validation_Issue.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Date de mise à disposition appliquée......"+MesFonctions.extractCurrentHeure()+"\r");
		
		//Fermeture de la fiche d'enrolement
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Fermer_Fiche_Enrolement - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Fermeture de la fiche d'enrôlement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Validation_sauveguarde - Fiche de séance de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Validation fiche enrôlement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Thread.sleep(200);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Fermeture_liste_seance_jugement - Liste des séances de jugement.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Fermeture de la liste des sénaces de jugement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
}

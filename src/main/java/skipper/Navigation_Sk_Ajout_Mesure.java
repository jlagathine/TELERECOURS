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

public class Navigation_Sk_Ajout_Mesure {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static String acces_onglet_historique() throws InterruptedException, AWTException, IOException {
		//Click onglet "HISTORIQUE"
//		if(jur=="TA" || jur=="CAA") {
//			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ongle_Historique-Skipper-TA.png";
//		}else {
//			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ongle_Historique-Skipper-CTX.png";
//		}
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ongle_Historique-Skipper-TA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"HISTORIQUE\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(800);
		
		return null;
	}
	
	public static String menu_contextuel_Accuse_Recep_Req (String jur, String env) throws Throwable {
		//Déplacement du curseur vers le haut de l'historique - > Recherche ligne "requête nouvelle"
		String nomHist = "ouvel";
		if(jur=="TA" || jur=="CAA") {
			if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur1-Skipper.png";
			MesFonctions.OCR_champ_text_up(fileImage, coords, bounds, image, result, nomHist, 89, 185, 12);
			}
			if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur1-Skipper.png";
				MesFonctions.OCR_champ_text_up(fileImage, coords, bounds, image, result, nomHist, 79, 185, 12);
				}
		
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
			int nbr = 2;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CAA":
			nbr = 0;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 0;
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
		Thread.sleep(300);
		
		//Vérification de l'alerte imprimante non valide
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesures_contextuelles-Skipper - CTX.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
		if(!coords.equals(coords1)) {
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Alerte imprimante validée...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		//Valider le destinataire
		Thread.sleep(700);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		if(env=="int1") {
		Keyboard.keyBoard(KeyEvent.VK_ENTER);//envir integration
		}
		Thread.sleep(200);
		System.out.println("Destinataire validé...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Click bouton définitif
		if(env=="rec") {
		if(jur=="TA" || jur=="CAA") {
		Navigation_Sk_Ajout_Mesure.bouton_definif(jur);
			}
		}
		
		return null;
				
	}
	
	public static String Mesure_Contextuelle_Communication_Req(String jur) throws Throwable {
		//Déplacement du curseur vers le haut de l'historique - > Recherche ligne "requête nouvelle"
		String nomHist = "réception";
		if(jur=="TA" || jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur1-Skipper.png";
			MesFonctions.OCR_champ_text_up(fileImage, coords, bounds, image, result, nomHist, 90, 208, 18);
			
		
		//click MESURES CONTEXTUELLES
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure_contextuelle - Skipper - TA1.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure_contextuelle - Skipper - CAA2.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"MESURES CONTEXTUELLES\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		}else {
			nomHist = "réception";
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointer-destinataire-Communication du code Télérecours citoyens.png";
			MesFonctions.OCR_champ_text_up(fileImage, coords, bounds, image, result, nomHist, 90, 187, 16);
		
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
			
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
			
		//Accès mesures contextuelles
			//Choix d'une de la mesure
		switch (jur) {
		case "TA":
			int nbr = 0;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CAA":
			nbr = 1;
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
		Thread.sleep(1200);
		
		//Valider le destinataire
		Navigation_Sk_Ajout_Mesure.ajout_piece_mesure(jur);
		Navigation_Sk_Ajout_Mesure.bouton_OK_communication_req(jur);
		Navigation_Sk_Ajout_Mesure.bouton_definif2(jur);

		return null;
	}
	
	public static String acces_onglet_synthese(String jur) throws InterruptedException, AWTException, IOException {
		//Retour onglet "SYNTHESE"
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_synthèse-Skipper - TA.png";
		}else if(jur=="CAA" || jur=="CTX"){
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_synthèse-Skipper - CAA.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_synthèse-Skipper - CTX.png";
		}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Retour sur l'onglet \"SYNTHESE\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		
		return null;
	}
	
	public static String bouton_definif(String jur) throws InterruptedException, AWTException, IOException {
		//Click bouton  "DEFINIF"
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Definitif - Skipper - TA.png";
		}else if(jur=="CAA" || jur=="CTX"){
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Definitif - Skipper - CAA.png";
		}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		Thread.sleep(800);
		System.out.println("Click bouton \"DEFINIF\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		
		
		return null;
	}
	
	public static String bouton_definif1(String jur) throws InterruptedException, AWTException, IOException {
		//Click bouton  "DEFINIF"
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Definitif - Skipper - TA1.png";
		}else if(jur=="CAA"){
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Definitif - Skipper - CAA1.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		Thread.sleep(800);
		System.out.println("Click bouton \"DEFINIF\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		
		
		return null;
	}
	
	public static String bouton_definif2(String jur) throws InterruptedException, AWTException, IOException {
		//Click bouton  "DEFINIF"
		if(jur=="TA" || jur=="CAA") {
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Definitif - Skipper - TA1.png";
		}else if(jur=="CAA"){
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Definitif - Skipper - CAA1.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		Thread.sleep(800);
		System.out.println("Click bouton \"DEFINIF\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
	
	public static String ajout_piece_mesure(String jur) throws TesseractException, Throwable {
		//Click bouton PIECES
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_piece-Communication de la requête - TA.png";
			}else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_piece-Communication de la requête - CAA.png";
				}else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_piece-Communication de la requête - CTX.png";
					}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"PIECES\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		
		//Click bouton INSERER
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_inserer - Pièces jointes au courrier - TA1.png";
			}else if(jur=="CAA" || jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_inserer - Pièces jointes au courrier - CAA.png";
			}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"INSERER\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		
		//Insertion d'une pièce
		switch (jur) {
		case "TA":
			int nbr = 1;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CAA":
			nbr = 1;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 1;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
	
		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		
		//Click bouton INSERER
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_inserer - Pièces jointes au courrier - TA.png";
			}else if(jur=="CAA" || jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_inserer - Pièces jointes au courrier - CAA1.png";
			}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"INSERER\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		
		//Insertion d'une pièce
		switch (jur) {
		case "TA":
			int nbr = 1;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CAA":
			nbr = 1;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 1;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
	
		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		//Click bouton VALIDER
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider -Pièces jointes au courrier - TA.png";
			}else if(jur=="CAA" || jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider -Pièces jointes au courrier - CAA.png";
			}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"VALIDER\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
		
		System.out.println("Toutes les pièces sont insérées ...."+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String bouton_OK_communication_req(String jur) throws InterruptedException, AWTException, IOException {
		//Click bouton "OK"
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OK-Communication de la requête - TA.png";
		}else if(jur=="CAA" || jur=="CTX"){
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OK-Communication de la requête - TA.png";
		}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click bouton \"OK\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(1000);
		
		return null;
	}
	
	public static Object ajout_mesure_reception_DPI(String jur, String jur_annuaire, String type) throws InterruptedException, IOException, Throwable {
		//Accès à l'onglet mesure
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - TA - Mesure.png";
			}else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - Cour Administrative d'Appel - Mesure.png";
				}else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - CE - Mesure.png";
					}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setRectangle(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(0, 0);
		System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Accès à la famille de mesure	
		int nbr = 1;//Famille de mesure AUTRES)
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
					
		//Validation
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
		//Recherche d'une mesure
			//Choix d'une de la mesure
		switch (jur) {
		case "TA":
			nbr = 48;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CAA":
			nbr = 26;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 41;
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
		
		//Gestion des destinataires
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Réception d'une requête - Renvoi PMI - TA.png";
			}else if(jur=="CAA" || jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Réception d'une requête - Renvoi PMI - CAA.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Sélection de la checkbox \"AUTRES\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		
		//Sélection de l'annuaire
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Annuaire - Réception d'une requête - Renvoi PMI - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Sélection de la checkbox \"ANNUAIRE\" ...."+MesFonctions.extractCurrentHeure()+"\r");
			
			}else if(jur=="CAA" || jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Annuaire - Réception de requête - Renvoi PMI - CAA.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				System.out.println("Sélection de l'émétteur :  \"ANNUAIRE\" ...."+MesFonctions.extractCurrentHeure()+"\r");
				
				//Type juridiction
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Type_Admin_DPI - Recherche d'une grande partie dans l'annuaire.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 31, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				MesFonctions.mouveSouris(1, 1);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+34, coords.getFirst().getSecond(), 127, 15);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				//Accéder à la liste des destinataires
				while(!result.contains(type)) {
					//Déplacement du curseur
					Thread.sleep(70);
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Type_Admin_DPI - Recherche d'une grande partie dans l'annuaire.png";
					coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
					coords = MesFonctions.waitObject(fileImage);
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+34, coords.getFirst().getSecond(), 127, 15);
					image = MesFonctions.screenshot(bounds);
					result = MesFonctions.OCR_decryptage(image);
					}
				
				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2 + 31, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				System.out.println("Le type de la juridiction est sélectionné ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				Navigation_Skipper_Creation_Defendeur.Click_btn_Rechreche(jur);
				
				//Sélection de la juridiction
					//définir un rectangle d'observation
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Selecteur_Annuaire_CAA.png";
					coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
					coords = MesFonctions.waitObject(fileImage);
					MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+12, coords.getFirst().getSecond(), 228, 18);
					image = MesFonctions.screenshot(bounds);
					result = MesFonctions.OCR_decryptage(image);
						
						//Accéder à la liste des destinataires
						while(!result.contains(jur_annuaire)) {
							//Déplacement du curseur
							Keyboard.keyBoard(KeyEvent.VK_DOWN);
							Thread.sleep(70);
							fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Selecteur_Annuaire_CAA.png";
							coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
							coords = MesFonctions.waitObject(fileImage);
							bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+12, coords.getFirst().getSecond(), 228, 18);
							image = MesFonctions.screenshot(bounds);
							result = MesFonctions.OCR_decryptage(image);
							}
						
				//Ajout acteur dana la case destinataire
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				MesFonctions.doubleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				System.out.println("La juridiction ciblée est dans la case destinataire...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
		
		//Sélection du type d'émetteur
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Juridiction - Réception d'une requête - Renvoi PMI - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Sélection du émétteur :  \"JURIDICTION\" ...."+MesFonctions.extractCurrentHeure()+"\r");
			
		//Sélection de la juridiction
			//définir un rectangle d'observation
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur - Réception d'une requête - Renvoi PMI - TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 233, 18);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
				
				//Accéder à la liste des destinataires
				while(!result.contains(jur_annuaire)) {
					//Déplacement du curseur
					Keyboard.keyBoard(KeyEvent.VK_DOWN);
					Thread.sleep(50);
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Pointeur - Réception d'une requête - Renvoi PMI - TA.png";
					coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
					coords = MesFonctions.waitObject(fileImage);
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+12, coords.getFirst().getSecond(), 233, 18);
					image = MesFonctions.screenshot(bounds);
					result = MesFonctions.OCR_decryptage(image);
					}
				
				//Ajout acteur dana la case destinataire
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				MesFonctions.doubleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				System.out.println("La juridiction ciblée est dans la case destinataire...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
				
		//Valider la mesure
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn_OK - Réception d'une requête - Renvoi PMI - TA.png";
			}else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn_OK - Réception d'une requête - Renvoi PMI - CTX.png";
				}else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn_OK - Réception d'une requête - Renvoi PMI - CAA.png";
					}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("La mesure est validée...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
		return null;	
	}
	
	public static String mesure_ajout_memoire_defense(String jur) throws InterruptedException, AWTException, IOException {
		//Accès à l'onglet mesure
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - TA - Mesure.png";
			}else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - Cour Administrative d'Appel - Mesure.png";
				}else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - CE - Mesure.png";
					}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setRectangle(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(0, 0);
		System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Accès à la famille de mesure	
		int nbr = 2;//Mémoire et pièces
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
					
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
		//Recherche d'une mesure
			//Choix d'une de la mesure
		switch (jur) {
		case "TA":
			nbr = 32;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CAA":
			nbr = 27;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 34;
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
		
		//Sélection 
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\checkbox_defendeur - Réception d'un mémoire - TA.png";
			}else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\checkbox_defendeur - Réception d'un mémoire - CAA.png";
				}else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\checkbox_defendeur - Réception d'un mémoire - CAA.png";
					}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("La Checkbox \"DEFENDEUR\"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Ajout acteur dana la case destinataire
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ajout_Acteur_Destinataire-Communication du code Télérecours citoyens.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("L'acteur ciblé est dans la case destinataire...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Ajout acteur dana la case destinataire
		if(jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn OK - Réception d'un mémoire - CTX.png";
			}else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn OK - Réception d'un mémoire - CAA.png";
				}else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Btn OK - Réception d'un mémoire - TA.png";
					}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("La mesure a été validée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static void mesure_affectation_chambre(String jur) throws TesseractException, Throwable {
		//Accès à l'onglet mesure
		if(jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - Cour Administrative d'Appel - Mesure.png";
			}else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - CE - Mesure.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setRectangle(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(0, 0);
		System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Accès à la famille de mesure
		switch (jur) {
		case "CAA":
			int nbr = 6;//Famille de mesure AUTRES)
			for(int i=0
					; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 6;//Famille de mesure AUTRES)
			for(int i=0
					; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;

		default:
			break;
		}
		
					
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Recherche d'une mesure
		//Choix d'une de la mesure
	switch (jur) {
	case "CAA":
		int nbr = 1;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
		break;
		
	case "CTX":
		nbr = 0;
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
		
		//Choisir une chambre
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure_Affectation à chambre - CAA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+12, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(1, 1);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+105, coords.getFirst().getSecond(), 157, 14);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
			
			//Accéder à la liste des entités
		String str = "";
		if(jur=="CAA") {
			str = "1ère Chambre";
		}else {
			str = "Tère chambre";
		}
			while(!result.contains(str)) {
				//Déplacement du curseur
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(70);
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure_Affectation à chambre - CAA.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+105, coords.getFirst().getSecond(), 157, 14);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("La chambre est sélectionnée....."+MesFonctions.extractCurrentHeure());
			
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Le choix de la chambre est validé ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
	public static void mesure_affectation_rapporteur(String jur) throws TesseractException, Throwable {
		//Accès à l'onglet mesure
		if(jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - Cour Administrative d'Appel - Mesure.png";
			}else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - CE - Mesure.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setRectangle(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(0, 0);
		System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Accès à la famille de mesure
		switch (jur) {
		case "CAA":
			int nbr = 6;//Famille de mesure AUTRES)
			for(int i=0
					; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;
			
		case "CTX":
			nbr = 6;//Famille de mesure AUTRES)
			for(int i=0
					; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			break;

		default:
			break;
		}
		
					
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Recherche d'une mesure
		//Choix d'une de la mesure
	switch (jur) {
	case "CAA":
		int nbr = 2;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
		break;
		
	case "CTX":
		nbr = 1;
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
		
		//Choisir un rapporteur
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure_Affectation au Rapporteur - CAA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+12, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(1, 1);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+105, coords.getFirst().getSecond(), 157, 14);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
			
			//Accéder à la liste des entités
		String str = "";
		if(jur=="CAA") {
			str = "AL";
		}else {
			str = "Al";
		}
			while(!result.contains(str)) {
				//Déplacement du curseur
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(70);
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Mesure_Affectation au Rapporteur - CAA.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+105, coords.getFirst().getSecond(), 157, 14);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("Le rapporteur est sélectionné....."+MesFonctions.extractCurrentHeure());
			
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Le choix du rapporteur est validé ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
	
}

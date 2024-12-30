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

public class Navigation_Skipper_creation_dossier {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static String date;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	

	public static Object nouveau_recours_papier_sk(String jur) throws InterruptedException, IOException, Throwable  {
	//Click icone NOUVEAU DOSSIER
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\creation_recour_skipperTA.png";
		}else if(jur=="CAA" || jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\creation_recour_skipperCAA.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click icone \"NOUVEAU DOSSIER\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;	
	}
	
	public static Object champ_nature(String jur) throws TesseractException, Throwable {	
	//Renseigner le champ nature
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_nature_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+65/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+68, coords.getFirst().getSecond()+3, 186, 16);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			
			}else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_nature_CAA.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+65/2, coords.getFirst().getSecond()+ coords.getSecond().getSecond()/2);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+76, coords.getFirst().getSecond(), 186, 16);//65
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				}else if(jur=="CAA") {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_nature_CAA.png";
					coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
					coords = MesFonctions.waitObject(fileImage);
					MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+65/2, coords.getFirst().getSecond()+ coords.getSecond().getSecond()/2);
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+67, coords.getFirst().getSecond()+2, 186, 16);//65
					image = MesFonctions.screenshot(bounds);
					result = MesFonctions.OCR_decryptage(image);
					}
		
	String nature = "";
	if(jur=="TA" || jur=="CTX") {
		nature = "Excès";
	}else if(jur=="CAA") {
		nature = "excès";
	}
	while(!result.contains(nature)) {
	//Déplacement du curseur
	Keyboard.keyBoard(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	image = MesFonctions.screenshot(bounds);
	Thread.sleep(100);
	result = MesFonctions.OCR_decryptage(image);
	Thread.sleep(50);
				}
	System.out.println("La \"NATURE\" a été renseignée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
	Keyboard.keyBoard(KeyEvent.VK_TAB);
	return null;
	}
	
	public static Object champ_saisine(String jur) throws TesseractException, Throwable {	
	//Renseigner le champ saisine
	if(jur=="TA" || jur=="CTX") {
	if(jur=="TA") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_saisine_TA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+65/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+65, coords.getFirst().getSecond()+1, 186, 16);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
		}
		else if(jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_saisine_CAA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+65/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(1, 1);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+75, coords.getFirst().getSecond()+2, 120, 16);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
		}
		String saisine ="";
		if(jur=="TA") {
			saisine = "via";
		}
		else if(jur=="CTX") {
			saisine = "Cassation CAA";
		}
		while(!result.contains(saisine)) {
		//Déplacement du curseur
		Keyboard.keyBoard(KeyEvent.VK_DOWN);
		Thread.sleep(100);
		image = MesFonctions.screenshot(bounds);
		Thread.sleep(100);
		result = MesFonctions.OCR_decryptage(image);
		Thread.sleep(50);
					}
		System.out.println("La \"SAISINE\" a été renseignée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Keyboard.keyBoard(KeyEvent.VK_TAB);
	}else {
		System.out.println("Cette juridiction n'est pas concernée par l'information liée à la \"SAISINE\"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
	return null;
		}
	
	public static Object champ_dpt_ressort_TA(String jur) throws TesseractException, Throwable {
		if(jur=="TA") {
			//Renseigner le champ dpt ressort
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_dpt_ressort_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+65/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+67, coords.getFirst().getSecond()+1, 186, 16);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			
			String nature = "PARIS";//;
			while(!result.contains(nature)) {
			//Déplacement du curseur
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			Thread.sleep(100);
			image = MesFonctions.screenshot(bounds);
			Thread.sleep(100);
			result = MesFonctions.OCR_decryptage(image);
			Thread.sleep(50);
						}
			System.out.println("Le \"DEPT_RESSORT\" a été renseigné ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			Keyboard.keyBoard(KeyEvent.VK_TAB);
			
		}else {
			System.out.println("Cette juridiction n'est pas concernée par l'information liée au \"DEPT_RESSORT\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		return null;
	}
	
	public static Object champ_rapporteur_TA(String jur) throws TesseractException, Throwable {
		if(jur=="TA") {
			//Renseigner le champ Rapporteur
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_rapporteur_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+65/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+65, coords.getFirst().getSecond()+2, 186, 20);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			
			String nature = "ADROT";//;
			while(!result.contains(nature)) {
			//Déplacement du curseur
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			Thread.sleep(100);
			image = MesFonctions.screenshot(bounds);
			Thread.sleep(100);
			result = MesFonctions.OCR_decryptage(image);
			Thread.sleep(50);
						}
			System.out.println("La \"RAPPORTEUR\" a été renseignée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			Keyboard.keyBoard(KeyEvent.VK_TAB);
				}else {
					System.out.println("Cette juridiction n'est pas concernée par l'information liée au \"RAPPORTEUR\"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
	return null;
			}
	
	public static Object champ_date_TA(String jur) throws TesseractException, Throwable {
		if(jur=="TA") {
			//Renseigner le champ nature
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_enregistrement_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+120/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			
			//Renseigner la date d'enregistrement
			date = MesFonctions.extractCurrentDate().replaceAll("/", "");
			Keyboard.maStringToKeyboard(date);

			System.out.println("La \"DATE et HEURE\" ont été renseigné ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
			System.out.println("Cette juridiction n'est pas concernée par l'information liée à la \"DATE et HEURE\"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}

	return null;
	}
	
	public static Object champ_matiere(String jur) throws TesseractException, Throwable {	
	//Renseigner le champ la matière
	
	if(jur=="TA") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_matière_TA.png";
	}else if(jur=="CAA") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_matière_CAA.png";
	}else {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_matière_CTX.png";
	}
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick((coords.getFirst().getFirst() + coords.getSecond().getFirst()+260/2), (coords.getFirst().getSecond() + coords.getSecond().getSecond()+30/2));
	if(jur=="TA") {
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+120, coords.getFirst().getSecond()+26, 203, 16);
	}else if(jur=="CTX") {
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+120, coords.getFirst().getSecond()+23, 203, 16);//+26
	}else if(jur=="CAA") {
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+120, coords.getFirst().getSecond()+23, 203, 16);
	}
	
	image = MesFonctions.screenshot(bounds);
	result = MesFonctions.OCR_decryptage(image);
	
	String nature = "AGRICUL";
	while(!result.contains(nature)) {
	//Déplacement du curseur
	Keyboard.keyBoard(KeyEvent.VK_DOWN);
	Thread.sleep(100);
	image = MesFonctions.screenshot(bounds);
	Thread.sleep(100);
	result = MesFonctions.OCR_decryptage(image);
	Thread.sleep(50);
				}
	
	//Renseigner le champ la sous-matière
	if(jur=="TA") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_matière_TA.png";
	}else if(jur=="CAA") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_matière_CAA.png";
	}else {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\champ_matière_CTX.png";
	}
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick((coords.getFirst().getFirst() + coords.getSecond().getFirst()+260/2), (coords.getFirst().getSecond() + coords.getSecond().getSecond()+70/2));
	if(jur=="TA") {
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+120, coords.getFirst().getSecond()+50, 203, 20);
	}else if(jur=="CAA" || jur=="CTX") {
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+120, coords.getFirst().getSecond()+42, 203, 20);//+50
	}
	image = MesFonctions.screenshot(bounds);
	result = MesFonctions.OCR_decryptage(image);
	
	nature = "AGRICUL";//;
	while(!result.contains(nature)) {
	//Déplacement du curseur
	Keyboard.keyBoard(KeyEvent.VK_DOWN);
	coords = Navigation_Skipper_creation_dossier.warning_matiere(jur);
	coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
	if(!coords.equals(coords1)){
		Thread.sleep(100);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		Thread.sleep(100);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
	}else {
		Thread.sleep(100);
		image = MesFonctions.screenshot(bounds);
		Thread.sleep(100);
		result = MesFonctions.OCR_decryptage(image);
		Thread.sleep(50);	
		}
				}
	System.out.println("La \"MATIERE et SS-MATIERE\" ont été sélectionnées ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
	return null;
				}
	
	public static Object valider_nouveau_dossier(String jur) throws InterruptedException, IOException, AWTException {
	//Valider l'envoi de la mesure
	
	if(jur=="TA") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\valider_nouveau_dossier_TA.png";
	}else if(jur=="CAA" || jur=="CTX") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\valider_nouveau_dossier_CAA.png";
	}
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	System.out.println("Validation des informations génériques ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> warning_matiere(String jur) throws InterruptedException, IOException, AWTException {
	//Vérification de la présence d'une fenêtre
	
	if(jur=="TA") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\waning-Matière niveau 2_TA.png";
	}else if(jur=="CAA" || jur=="CTX") {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\waning-Matière niveau 2_CAA.png";
	}
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	
	return coords;
	}
	
	public static Object création_acteur_physique(String jur) throws Throwable {
	//Création de l'acteur
	Navigation_Skipper_Code_RattachementTRC.nomActeurPhysique(jur);
	Navigation_Skipper_Code_RattachementTRC.prenomActeurPhysique(jur);
	Navigation_Skipper_Code_RattachementTRC.adresseActeurPhysique(jur);
	Navigation_Skipper_Code_RattachementTRC.villeActeurPhysique(jur);
	Navigation_Skipper_Code_RattachementTRC.CPActeurPhysique(jur);
		
	//Valider la fiche acteur
	Keyboard.keyBoard(KeyEvent.VK_ENTER);
	System.out.println("Fiche acteur validée ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
	if(jur=="CTX"){
		Thread.sleep(200);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Validation alerte \"Lecture donnée\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
	
	if(jur=="CAA" || jur=="CTX") {
		Thread.sleep(500);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA - bouton_Annuler - Skipper - Liste des dossiers rapprochés.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
		
		
		while(!coords.equals(coords1)) {
			Thread.sleep(500);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA - bouton_Annuler - Skipper - Liste des dossiers rapprochés.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Fiche de rapprochement des acteurs - Click sur le bouton \"Annuler\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
			}
	
			else {
			Thread.sleep(500);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA1 - bouton_Annuler - Skipper - Liste des dossiers rapprochés.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
			
			while(!coords.equals(coords1)) {
				Thread.sleep(500);
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA1 - bouton_Annuler - Skipper - Liste des dossiers rapprochés.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
				System.out.println("Fiche de rapprochement des acteurs - Click sur le bouton \"Annuler\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					}
				}
	
	return null;
	}
	
	public static Object finalisation_creation_dossier(String jur) throws IOException, AWTException, Throwable {
	//Click bouton annuler fiche
	fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\btn_Annuler-Fiche acteur_TA.png";
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	System.out.println("Annulation de la nouvelle fiche acteur ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");	
	
	//Valider la création du dossier
	if(jur=="CTX"){
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\btn_valider_creation_dossier_CTX.png";
	}else {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\btn_valider_creation_dossier.png";
	}
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	System.out.println("La création du dossier papier est validée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
	return null;
	}
	
	public static Object passage_mode_TR(String jur) throws Throwable {
		//Accès à la famille de mesure
		switch (jur) {
		case "TA" :
			//Click onglet mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - TA - Mesure.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);//élément important !!!
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(0, 0);
			System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			
			int nbr = 11;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
			
			//Validation 
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Mesure Passage mode TR
			nbr = 13;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
			
			//Validation 
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Accès à la MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Valider la mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\btn_valider-Passage du dossier en mode Télérecours_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);//élément important !!!
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			
			break;
			
		case "CAA" :
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - Cour Administrative d'Appel - Mesure.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(0, 0);
			System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			nbr = 13;//Famille de mesure AUTRES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
			
			//Validation 
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Mesure Passage mode TR
			nbr = 8;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
			
			//Validation 
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Accès à la MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Valider la mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\btn_valider-Passage du dossier en mode Télérecours_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			
			break;
			
		case "CTX" :
			//Click onglet mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_mesure - CE - Mesure.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			MesFonctions.mouveSouris(0, 0);
			System.out.println("Accès à l'onglet MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			nbr = 11;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			
			//Validation 
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Accès à la FAMILLE DE MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Mesure Passage mode TR
			nbr = 10;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
			
			//Validation 
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Accès à la MESURE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Valider la mesure
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\btn_valider-Passage du dossier en mode Télérecours_TA.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			}	
	return null;
	}
	
	public static String num_dossier_cree(String jur) throws Throwable {
		//Navigation vers l'onglet "GENERIQUE"
		
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_generique_TA.png";
			}else {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\onglet_generique_CTX.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Navigation vers l'onglet \"GENERIQUE\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Récupération de la donnée numero de dossier
		
		if(jur=="CAA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\num_req_CAA.png";		
			}else if(jur=="CTX") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\num_req_CTX.png";
				}else {
					fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\num_req_TA.png";
					}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		
		if(jur=="CAA") {
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+67, coords.getFirst().getSecond(), 48, 20);		
			}else if(jur=="CTX") {
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+65, coords.getFirst().getSecond(), 48, 20);
				}else {
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+65, coords.getFirst().getSecond(), 48, 20);
					}
		
		image = MesFonctions.screenshot(bounds);
		if(jur=="TA" || jur=="CAA") {
			result = (String) MesFonctions.regex_num_req(MesFonctions.OCR_decryptage(image), 7);
			}
				else if(jur=="CTX") {
					result = (String) MesFonctions.regex_num_req(MesFonctions.OCR_decryptage(image), 6);
				}
//		result = MesFonctions.OCR_decryptage(image);
		
		System.out.println("Récupération du numero de dossier : " +result+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return result.trim();
	}
	
	public static Object fermetureApplication(String jur) throws InterruptedException, IOException, AWTException {
		//Fermeture de l'application
			//Accès à l'onglet du dossier
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_Dossier- Cour Administrative d'Appel.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès à l'onglet DOSSIER ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Click sur le menu QUITTER
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Quitter_Application-TA.png";//Quitter_Application.png
		}else if(jur=="CTX") {
			int nbr = 15;//Quitter)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			//Validation 
			Thread.sleep(200);
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Click bouton \"QUITTER\" ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
			int nbr = 16;//Quitter)
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				}
			//Validation 
			Thread.sleep(200);
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Click bouton \"QUITTER\" ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		if(jur=="TA") {
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Accès au bouton QUITTER ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");	
		}
		
		//Confirmation de la fermeture de l'application
		if(jur=="CAA" || jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OUI-confirmation_quittter_CAA.png";
		}else{
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OUI-Fichier c__temp_RATACTRC.rtf.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Confirmation de la fermeture de l'application ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(600);
		
		return null;
	}
}

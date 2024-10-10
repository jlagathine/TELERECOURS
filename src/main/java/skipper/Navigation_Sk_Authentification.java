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

public class Navigation_Sk_Authentification {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	static public Object ouvertureBAMO() throws Throwable, IOException, AWTException {
		//Recherche icone
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\logoBAMO.png";
		coords = CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		
		//Click sur l'icone
		MesFonctions.doubleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click icone BAMO ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Récupération des coordonnées de l'image afin d'en prendre une capture(screenshot)
		fileImage  = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Selecteur-Lanceur Skipper - BAMO.png";
		coords = MesFonctions.waitObject(fileImage);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 406, 21);
//		bounds = MesFonctions.setRectangle(fileImage);
		
		//pointer le curseur sur l'application via la tabulation
		Keyboard.keyBoard(KeyEvent.VK_TAB);
		System.out.println("Positionnement du curseur sur l'application");
		Thread.sleep(700);
		
		//choix de la juridiction
//		String jur = "CE";
//		String numdoc = "366102";
//		
//		Navigation_Skipper.authentificationSK("lb", "lb");
//		Navigation_Skipper.selectDossierSk(jur, numdoc);
//		Navigation_Skipper.creationActeurRequerant(jur);
//		Navigation_Skipper.mesureRattachementTRC(jur);
//		Navigation_Skipper.aValiderDansTr(jur);
//		Navigation_Skipper.traitementDeTexte(jur);
//		Navigation_Skipper.gererDestinataireCourrier();
//		Navigation_Skipper.creationFichierRTF(jur);
//		String code = pdfCreationEtEcriture.convertionRTFtoPDF(jur);
//		Navigation_Skipper.fermetureApplication(jur);
//		Navigation_Skipper.fermetureLanceurBAMO();
		
		
		return null;
	}
	
	public static Object selectionApplicationContentieux(String jur) throws TesseractException, Throwable {
		switch (jur) {
		case "CAA":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("RECETTE SKIPPER CAA75")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 406, 21);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("Juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKCA75-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper contentieux\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
			
			//vérification de la fenêtre
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper CAA - Connexion.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
			
			System.out.println(bounds);

				//cature de l'emplacement
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				if(result.contains("Cours")) {
					System.out.println("Juridiction : "+result);
				}
			
			break;
			
		case "TA":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("RECETTE SKIPPER TA75")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 406, 21);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("Juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKTA75-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper contentieux\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
			
			//vérification de la fenêtre
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper TA - Connexion.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
			
			System.out.println(bounds);

				//cature de l'emplacement
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				if(result.contains("Tribunaux")) {
					System.out.println("Juridiction : "+result);
				}
			
			break;
			
		case "CTX":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("RECETTE SKIPPER CTX")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), 406, 21);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("Juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKCTX-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper Contentieux\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
			
			//vérification de la fenêtre
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper CTX- Connexion.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
			
			System.out.println(bounds);

				//cature de l'emplacement
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				if(result.contains("Section")) {
					System.out.println("Juridiction : "+result);
				}
			
			break;
			
		case "CNDA":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("CNDA RECETTE SKIPPER CNDA")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("Juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKCNDA-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper Contentieux\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
			
			//vérification de la fenêtre
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper CTX- Connexion.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
			
			System.out.println(bounds);

				//cature de l'emplacement
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				if(result.contains("Section")) {
					System.out.println("Juridiction : "+result);
				}
			
			break;
			
		case "CNDA_ADM":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("CNDA RECETTE SKIPPER CNDA")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("Juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKCNDA_ADM-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper Administration\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(2000);
			
			break;

		default:System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		return null;
	}
	
	public static Object authentificationSK(String ID, String mdp) throws Throwable {
		//Renseigner les identifiants
		Keyboard.maStringToKeyboard(ID);	

		System.out.println("Identifiant renseigné...."+MesFonctions.extractCurrentHeure());
		
		Keyboard.keyBoard(KeyEvent.VK_TAB);
		
		Keyboard.maStringToKeyboard(mdp);
		System.out.println("Mot de passe renseigné...."+MesFonctions.extractCurrentHeure());
		
		//Identification de l'image + def des coordonnées
		Thread.sleep(500);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bout_valider1-Skipper - Connexion.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		
		//Click sur le bouton valider
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Validation des identifiants...."+MesFonctions.extractCurrentHeure());
		return null;
	}
	
	public static Object selectionApplicationContentieux_int1(String jur) throws TesseractException, Throwable {
		switch (jur) {
		case "CAA":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("INTEGRATION SKIPPER CAA")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKCA75_int1-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper contentieux\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
			
			//vérification de la fenêtre
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper CAA - Connexion.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
			
			System.out.println(bounds);

				//cature de l'emplacement
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				if(result.contains("Cours")) {
					System.out.println("Juridiction : "+result);
				}
			
			break;
			
		case "TA":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("INTEGRATION SKIPPER TA")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKTA75_int1-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper contentieux\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
			
			//vérification de la fenêtre
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper TA - Connexion.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
			
			System.out.println(bounds);

				//cature de l'emplacement
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				if(result.contains("Tribunaux")) {
					System.out.println("Juridiction : "+result);
				}
			
			break;
			
		case "CTX":
			//Défilement de la liste déroulante
			result = "";
			while(!result.contains("INTEGRATION SKIPPER CTX")) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				Thread.sleep(50);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				}
			System.out.println("juridiction trouvée ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Choix de la juridiction
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\SKCTX_int1-Lanceur Skipper - BAMO.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			
			//Click sur la juridiction choisie
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur le bouton \"Skipper contentieux\" ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
			
			//vérification de la fenêtre
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Nom_Jur-Skipper CTX- Connexion.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
			
			System.out.println(bounds);

				//cature de l'emplacement
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				if(result.contains("Section")) {
					System.out.println("Juridiction : "+result);
				}
			
			break;

		default:System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		return null;
	}
	
	public static Object authentificationSK_int1(String ID, String mdp) throws Throwable {
		//Renseigner les identifiants
		Keyboard.maStringToKeyboard(ID);	

		System.out.println("Identifiant renseigné...."+MesFonctions.extractCurrentHeure());
		
		Keyboard.keyBoard(KeyEvent.VK_TAB);
		
		Keyboard.maStringToKeyboard(mdp);
		System.out.println("Mot de passe renseigné...."+MesFonctions.extractCurrentHeure());
		
		//Identification de l'image + def des coordonnées
		Thread.sleep(500);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\bout_valider1-Skipper - Connexion.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		
		//Click sur le bouton valider
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Validation des identifiants...."+MesFonctions.extractCurrentHeure());
		
		//Valider PopUp d'information
		Thread.sleep(700);
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Validation de la Pop-Up d'information ...."+MesFonctions.extractCurrentHeure());
		
		return null;
	}
	

	public static void authentification_rec(String jur, String id, String mdp) throws IOException, AWTException, Throwable {
		Navigation_Sk_Authentification.ouvertureBAMO();
		Navigation_Sk_Authentification.selectionApplicationContentieux(jur);
		Navigation_Sk_Authentification.authentificationSK(id, mdp);
	}
	
	public static void authentification_int1(String jur, String id, String mdp) throws IOException, AWTException, Throwable {
		Navigation_Sk_Authentification.ouvertureBAMO();
		Navigation_Sk_Authentification.selectionApplicationContentieux_int1(jur);
		Navigation_Sk_Authentification.authentificationSK_int1(id, mdp);
	}
	
	public static void authentification_env(String jur, String id, String mdp, String env) throws IOException, AWTException, Throwable{
	switch (env) {
	case "rec":
		Navigation_Sk_Authentification.authentification_rec(jur, id, mdp);
		break;
	case "int1":
		Navigation_Sk_Authentification.authentification_int1(jur, id, mdp);
		break;

	default: System.err.println("Cette environnement n'existe pas");
		break;
	}	
	}
}

package skipper;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;

public class Navigation_Sk_Ouverture_Dossier {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	
	public static Object selectDossierSk(String jur, String numDoc) throws Exception {
		switch (jur) {
		case "CAA":
			//Click icone dossier
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\IconeDossier-Skipper CAA - Cour Administrative d'Appel.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur l'icone dossier ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
			
			//Indiquer le numéro du dossier
			Keyboard.maStringToKeyboard(numDoc);
			System.out.println("Numéro de dossier renseigné : "+numDoc+"...."+MesFonctions.extractCurrentHeure()+"\r");
			
			//Valider le choix du dossier
			Thread.sleep(200);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider_dossier3-Skipper - Ouverture de dossier.png";//Bouton_valider_dossier3-Skipper - Ouverture de dossier_bis.png
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Choix du dossier validé ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(300);
			
			break;
			
		case "CTX":
			//Click icone dossier
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\IconeDossier-Skipper CTX - Contentieux.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur l'icone dossier ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
			
			//Indiquer le numéro du dossier
			Keyboard.maStringToKeyboard(numDoc);
			System.out.println("Numéro de dossier renseigné ...."+MesFonctions.extractCurrentHeure()+"\r");
			
			//Valider le choix du dossier
			Thread.sleep(200);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider_dossier3-Skipper - Ouverture de dossier.png";//Bouton_valider_dossier3-Skipper - Ouverture de dossier_bis.png
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Choix du dossier validé ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "TA":
			//Click icone dossier
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\IconeDossier-Skipper CTX - Contentieux.png";
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Click sur l'icone dossier ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
			
			//Indiquer le numéro du dossier
			Keyboard.maStringToKeyboard(numDoc);
			System.out.println("Numéro de dossier renseigné ...."+MesFonctions.extractCurrentHeure()+"\r");
			
			//Valider le choix du dossier
			Thread.sleep(200);
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_valider_dossier3-Skipper - Ouverture de dossier_bis.png";//Bouton_valider_dossier3-Skipper - Ouverture de dossier_bis.png ; //Bouton_valider_dossier3-Skipper - Ouverture de dossier.png
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
			System.out.println("Choix du dossier validé ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;

		default: System.err.println("Aucune juridiction à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		return null;
	}
}

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

public class Navigation_Sk_Choix_Civ {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static String date;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static void choix_civ_fiche_acteur_moral(String jur) throws InterruptedException, IOException, AWTException {
		//Click "Type personne morale"
		if(jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Type_Civ - Skipper - Fiche acteur - CTX.png";
			}else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Type_Civ - Skipper - Fiche acteur - CAA.png";
				}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst(), coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click \"Type personne morale\"");
		
		//Click "Type personne morale"
		int nbr = 1;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		System.out.println("Click \"Type personne morale\"");
	}
	
	public static void choix_civ_acteur_phys(String jur, String civ) throws AWTException, InterruptedException, IOException {
		if(jur=="CTX") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Choix_civilite - Fiche acteur - CTX.png";
			}else if(jur=="CAA") {
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\.png";
				}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()+15, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		if(civ=="monsieur") {
			//Click "Type personne physique" : MONSIEUR
			int nbr = 2;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
		}else {
			//Click "Type personne physique" : MONSIEUR
			int nbr = 1;
			for(int i=0; i<nbr; i++) {
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
			}
		}
	}
}

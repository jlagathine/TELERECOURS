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

public class Navigation_Sk_Constitution_Avocat {
	
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static void selection_qualite(String jur) throws AWTException, InterruptedException, IOException {
		//Sélection de la qualité
		Thread.sleep(800);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA_qualite_liste-Constitution de mandataire.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click sur la qualité de la partie à représentée...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(800);
	
		int nbr = 2;
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
			Thread.sleep(100);
		}
		
		System.out.println("La qualité est sélectionnée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}

	public static void selection_personne_representee(String jur) throws InterruptedException, IOException, AWTException {
		//Selection de la personne à représenter
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA_Ajout_Personne_Represente - Constitution de mandataire.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		System.out.println("La personne à représenter est sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TA_Validation_personne_representee - Constitution de mandataire.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CAA_Validation_personne_representee - Constitution de mandataire.png";
		}
		
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
		System.out.println("Validation de la personne représentée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(600);
	}
		
}

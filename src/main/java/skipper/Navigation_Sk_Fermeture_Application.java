package skipper;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;

public class Navigation_Sk_Fermeture_Application {
	

	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static void fermetureApplication(String jur) throws InterruptedException, IOException, AWTException {
		//Fermeture de l'application
			//Accès à l'onglet du dossier
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Onglet_Dossier- Cour Administrative d'Appel.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès à l'onglet DOSSIER ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Click sur le menu QUITTER
		if(jur=="TA") {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Quitter_Application-TA.png";
		}else {
			fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Quitter_Application-CAA.png";
		}
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Accès au bouton QUITTER ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Confirmation de la fermeture de l'application
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Bouton_OUI-Fichier c__temp_RATACTRC.rtf.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Confirmation de la fermeture de l'application ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(600);
	}
	
	public static Object fermetureLanceurBAMO() throws AWTException, InterruptedException, IOException {
		//Fermeture de lanceur BAMO
		//Accès bouton "Quitter le programme" du lanceur BAMO
	fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Quitter_Lanceur_BAMO-Lanceur Skipper - BAMO.png";
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	System.out.println("Click bouton : QUITTER LE PROGRAMME ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
		//Confirmation de la fermeture de l'application
	fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Confirmation-Quitter_BAMO.png";
	coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
	coords = MesFonctions.waitObject(fileImage);
	MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
	System.out.println("Confirmation de la fermeture du lanceur BAMO ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	Thread.sleep(700);
		return null;
	}
	
	public static void fermeture_sk(String jur) throws AWTException, InterruptedException, IOException {
		Navigation_Sk_Fermeture_Application.fermetureApplication(jur);
		Navigation_Sk_Fermeture_Application.fermetureLanceurBAMO();
	}
}

package skipper;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import captureTool.Recuper_Coleur_pixel;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;
import net.sourceforge.tess4j.TesseractException;

public class Navigation_Sk_Adm_TabledeReference {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static String date;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static void acces_table_referense() throws InterruptedException, IOException, AWTException {
		//Click onglet "Table de référence"
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\TbldeReference_CNDA-Skipper Administration.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst(), coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"Table de référence\"");
		
		//Sélection dans le menu "Annuaire"
		int nbr = 2;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à l'ANNUAIRE ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Sélection dans le menu "Annuaire"
		nbr = 1;//Famille de mesure MESURES ET DOCUMENTS INTERNES)
		for(int i=0; i<nbr; i++) {
			Keyboard.keyBoard(KeyEvent.VK_DOWN);
		}
		
		//Validation 
		Keyboard.keyBoard(KeyEvent.VK_ENTER);
		System.out.println("Accès à l'ANNUAIRE des AVOCATS ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
	}
	
	public static List<String> verification_Acteur_Statut_Actif() throws TesseractException, Throwable {
		//Choisir un rapporteur
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CNDA-Selecteur de l'annuaire des avocats.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst(), coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		MesFonctions.mouveSouris(1, 1);
		bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+13, coords.getFirst().getSecond(), 205, 16);
		image = MesFonctions.screenshot(bounds);
		result = MesFonctions.OCR_decryptage(image);
			
			//Accéder à la liste des entités
		List<String> avocat = new ArrayList<>();
		List<String> rpt = new ArrayList<>();
		int cnt = 0;
		boolean verif = true;
			while(verif) {
				//Déplacement du curseur
				fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\CNDA-Selecteur de l'annuaire des avocats.png";
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+13, coords.getFirst().getSecond(), 205, 16);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				//Vérification acteur inactif
				if(Recuper_Coleur_pixel.color(image)) {
					avocat.add(MesFonctions.sansAccents(result.trim()));
				};
				System.out.println(avocat);
				//Verification de doublon
				rpt.add(result.trim());
				int cnt_1 = cnt-56;
					if(cnt<58) {
						Keyboard.keyBoard(KeyEvent.VK_DOWN);
						Thread.sleep(70);
						cnt++;
							}
							else if(cnt>=58 && !MesFonctions.sansAccents(rpt.get(cnt-1).trim()).equals(MesFonctions.sansAccents(rpt.get(cnt_1).trim())) ) {
							Thread.sleep(70);
							verif= true;
							cnt++;
							System.out.println(cnt+" **** "+cnt_1);
							System.out.println(MesFonctions.sansAccents(rpt.get(cnt-1).trim()) +" **** "+MesFonctions.sansAccents(rpt.get(cnt_1).trim()));
							Keyboard.keyBoard(KeyEvent.VK_DOWN);
											}
											else {
												verif = false;
												System.err.println(MesFonctions.sansAccents(rpt.get(cnt-1).trim()) +" **** "+MesFonctions.sansAccents(rpt.get(cnt_1).trim()));
												}
						}
			System.out.println("La liste des avocats INACTIFS est complète....."+MesFonctions.extractCurrentHeure());
			return avocat;
	}
	

}

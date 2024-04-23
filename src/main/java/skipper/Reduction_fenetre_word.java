package skipper;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;

public class Reduction_fenetre_word {
	
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;

	public static void fermeture_fenetre_word() throws AWTException, InterruptedException, IOException {
		//Réduction de la fenêtre word
		MesFonctions.singleClick(655, 515);
		Thread.sleep(600);
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Croix_ferme_doc.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		Keyboard.keyBoardShortCut(KeyEvent.VK_WINDOWS, KeyEvent.VK_DOWN);
		System.out.println("La fenêtre word est réduite....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
	}
}

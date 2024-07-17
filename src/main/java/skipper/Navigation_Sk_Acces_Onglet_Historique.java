package skipper;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;

public class Navigation_Sk_Acces_Onglet_Historique {
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;

	public static void onglet_historique() throws InterruptedException, IOException, AWTException {
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Ongle_Historique-Skipper-TA.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click onglet \"HISTORIQUE\" ...."+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(300);
	}
}

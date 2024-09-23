package skipper;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.jgrapht.alg.util.Pair;

import captureTool.CaptureIcone;
import lesFonctions.MesFonctions;

public class Navigation_Sk_Fermeture_Dossier {

	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1;
	
	public static void fermerDossierSk(String jur) throws Exception {
		//Click icone fermeture dossier
		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\Icone_fermeture_dossier.png";
		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		System.out.println("Click sur l'icone fermeture dossier ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
	}
}

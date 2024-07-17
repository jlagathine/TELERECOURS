package demoTest;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.jgrapht.alg.util.Pair;

import skipper.Navigation_Sk_Affectation_ch_rap;
import skipper.Navigation_Sk_Authentification;

public class TestScriptClientLourd {
	static BufferedImage image;
	static String fileImage;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
	static Rectangle bounds;
	static String result;

	public static void main(String[] args) throws AWTException, IOException, Throwable {
		String jur = "CTX";
		String id = "lb";
		String mdp = "lb";
		String dossier = "367125";
	
	Navigation_Sk_Authentification.authentification_rec(jur, id, mdp);
	Navigation_Sk_Affectation_ch_rap.click_trt_par_lots_affectation(jur);
	Navigation_Sk_Affectation_ch_rap.effectation_dossier(jur, dossier);
	
	}

}

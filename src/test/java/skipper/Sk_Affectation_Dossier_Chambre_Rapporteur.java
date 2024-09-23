package skipper;

import org.testng.annotations.Test;

import captureTool.My_SreenShot;

public class Sk_Affectation_Dossier_Chambre_Rapporteur {
	
	String jur;
	String dossier;
	String id;
	String nom;
	String mdp;
	String env;
	
	@Test
	public void Skipper_affectation() throws Throwable {
		jur = "TA";
		dossier = "";
		env = "rec";
		mdp = "lb";
		id = "lb";
		
		try {
			
			//SKIPPER_ouverture
			Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
			
			
			//SKIPPER_affectation
			Navigation_Sk_Affectation_ch_rap.click_trt_par_lots_affectation(jur);
			Navigation_Sk_Affectation_ch_rap.affectation_dossier(jur, dossier);
			
			//SKIPPER_fermeture
			Navigation_Sk_Fermeture_Application.fermeture_sk(jur);
			
		} catch (Exception e) {
			
			My_SreenShot.screenshot();
			e.printStackTrace();
			
		}
		
	}

}

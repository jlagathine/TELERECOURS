package skipper;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import captureTool.My_SreenShot;
import lesFonctions.MesFonctions;
import requete_depot_enreg.Requete_TR_depot_enreg;

public class CreationDossier_navigationSK {
	
	String jur;
	String req;
	String id;
	String mdp;
	String type;
	String nom;
	String env;
	int mes;
	WebDriver driver;
	
	@Test
	public void creation_req_TR () throws Throwable {
		try {
			//Choix Navigateur
			String	browserName = "chrome";
			jur = "CTX";
			id = "lb";
			mdp = "lb";
			env = "rec";
			req = Requete_TR_depot_enreg.TR_depot(jur, browserName, env);
		    
		} catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void navigation_SK() throws AWTException, Throwable {
//	id = "lb";
//	mdp = "lb";
//	req = "367714";
//	jur = "CTX";
	
	try {
		//Ouverture SKIPPER
		Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
		
		//Choix dossier
		Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, req);//req
		
		//Ajout défendeur
		type = "defendeur"; //defendeur
		nom ="AEROPORTS";
		Navigation_Skipper_Creation_Defendeur.selectionActeur_defendeur_requerant(jur);
		Navigation_Skipper_Creation_Defendeur.SelectionTypeActeur(type, jur);
		Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom);
		
		//Ajout mesure
		Navigation_Sk_Ajout_Mesure.acces_onglet_historique();
		Navigation_Sk_Ajout_Mesure.menu_contextuel_Accuse_Recep_Req(jur, env);//jur

		Navigation_Sk_Ajout_Mesure.Mesure_Contextuelle_Communication_Req(jur);
		Navigation_Sk_Ajout_Mesure.acces_onglet_synthese(jur);
		
		//Déconnexion SKIPPER
		Navigation_Sk_Fermeture_Application.fermeture_sk(jur);
		System.out.println("LE TEST EST TERMINE !!!...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
	} catch (Exception e) {
		My_SreenShot.screenshot();
		e.printStackTrace();
	}
	
	}

}

package tr_skipper_bout_en_bout;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Juridictions.JurReqTr;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;
import skipper.Navigation_Sk_Ajout_Mesure;
import skipper.Navigation_Sk_Authentification;
import skipper.Navigation_Sk_Fermeture_Application;
import skipper.Navigation_Sk_Ouverture_Dossier;
import skipper.Navigation_Skipper_Creation_Defendeur;

public class CreationDossier_navigationSK {
	
	String jur;
	String req;
	String id;
	String mdp;
	String code;
	String password;
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
		    driver = Navigateur.choixBrowser(browserName);
		    System.out.println(driver);
		    
		    //Authentification TR
		    jur = "CTX";
		    JurReqTr.maJuridiction(driver, jur);
		    
		    //Dépot et enregistrement de la requête
		    JurReqTr.reqDepot(driver, jur);
		    req = JurReqTr.reqEnreg(driver, jur);
		    
		    //Deconnexion TR
		    MicroFonctions.deconnexionTrInt(driver);
		    driver.quit();
		    Thread.sleep(200);
		    
		} catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void navigation_SK() throws AWTException, Throwable {
	id = "lb";
	mdp = "lb";
	req = "367714";
	jur = "CTX";
	
	try {
		//Ouverture SKIPPER
		Navigation_Sk_Authentification.authentification(jur, id, mdp);
		
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
		Navigation_Sk_Ajout_Mesure.menu_contextuel_Accuse_Recep_Req(jur);//jur

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

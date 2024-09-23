package skipper;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import captureTool.My_SreenShot;
import net.sourceforge.tess4j.TesseractException;
import requete_depot_enreg.Requete_TR_depot_enreg;

public class Skipper_Ajout_Defendeur {
	String jur;
	String numdoc;
	String id;
	String mdp;
	String code;
	String browserName;
	String password;
	String type;
	String qualite;
	String saisine;
	String nom;
	String env;
	WebDriver driver;
	
	@BeforeSuite
	public void ouverture_Skipper() throws TesseractException, Throwable {
	try {
			jur = "CAA";
			id = "lb";
			mdp = "lb";
			env = "rec";
			browserName = "chrome";
			saisine = "Jugement";
			numdoc = Requete_TR_depot_enreg.TR_depot(jur, browserName, saisine, env);//366478, 22478
			
			//Authentification
			Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
			//Ouverture dossier
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, numdoc);
			
		} catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}
	}
	
	@Test
	public void Ajout_defendeur_dossier() throws Throwable {
		//SKIPPER
	try {
		
		//Ajout défendeur
			qualite = "defendeur"; //defendeur
			nom ="AEROPORTS";
			type = "Autres";
			Navigation_Skipper_Creation_Defendeur.selectionActeur_defendeur_requerant(jur);
			Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
			
			//Ajout mesure
			Navigation_Sk_Ajout_Mesure.acces_onglet_historique();
			Navigation_Sk_Ajout_Mesure.menu_contextuel_Accuse_Recep_Req(jur, env);//jur

			Navigation_Sk_Ajout_Mesure.Mesure_Contextuelle_Communication_Req(jur);
			Navigation_Sk_Ajout_Mesure.acces_onglet_synthese(jur);
			
		} catch (Exception e) {

			My_SreenShot.screenshot();
			e.printStackTrace();
		}	
	}
		
	@AfterSuite
	public void fin() throws AWTException, InterruptedException, IOException {
		Navigation_Sk_Fermeture_Application.fermeture_sk(jur);
		System.out.println("LE TEST EST TERMINE !!!");
	}
	
	
}

package skipper;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import captureTool.My_SreenShot;
import net.sourceforge.tess4j.TesseractException;

public class Skipper_Ajout_Defendeur {
	String jur;
	String numdoc;
	String id;
	String mdp;
	String code;
	String password;
	String type;
	String nom;
	String env;
	WebDriver driver;
	
	@BeforeSuite
	public void ouverture_Skipper() throws TesseractException, Throwable {
		jur = "TA";
		id = "lb";
		mdp = "lb";
		numdoc = "2400188";//366478, 22478
		
		//Authentification
		Navigation_Sk_Authentification.authentification(jur, id, mdp);
		//Ouverture dossier
		Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, numdoc);
	}
	
	@Test
	public void Ajout_defendeur_dossier() throws Throwable {
		//SKIPPER
	try {
		
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

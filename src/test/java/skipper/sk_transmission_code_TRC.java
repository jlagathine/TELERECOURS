package skipper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;
import pdfGeneration.PdfCreationEtEcriture;
import requete_depot_enreg.Requete_TR_depot_enreg;
import trc.EntrerCodeRattachement;

public class sk_transmission_code_TRC {
	String jur;
	String browserName;
	String numdoc;
	String id;
	String mdp;
	String env;
	String code;
	String DB_id;
	String DB_mdp;
	WebDriver driver;
	
	
	@Test(priority=1)
	public void navigation_skipper() throws Throwable {
		browserName = "chrome";
		env = "rec";
		jur = "CTX";
		id = "lb";
		mdp = "lb";
		numdoc = "367380";//Requete_TR_depot_enreg.TR_depot(jur, browserName, env); //CAA 2400070; CE 367628; TA 2400152
		
			//Skipper
			Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
			//selection dossier
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, numdoc);
		
			//Rattachement
			Navigation_Skipper_Code_RattachementTRC.creationActeurRequerant_Defendeur(jur);
			Navigation_Skipper_Code_RattachementTRC.mesureRattachementTRC(jur);
			Navigation_Skipper_Code_RattachementTRC.aValiderDansTr(jur);
			Navigation_Skipper_Code_RattachementTRC.traitementDeTexte(jur);
			Navigation_Skipper_Code_RattachementTRC.gererDestinataireCourrier();
			Navigation_Skipper_Code_RattachementTRC.creationFichierRTF(jur);
			code = PdfCreationEtEcriture.convertionRTFtoPDF_codeRattachementTRC(jur);
			
			//Fermeture de l'application
			Navigation_Sk_Fermeture_Application.fermetureApplication(jur);
			Reduction_fenetre_word.fermeture_fenetre_word();
			Navigation_Sk_Fermeture_Application.fermetureLanceurBAMO();
	}
			
			
	@Test(priority=2)	
	public void navigation_TRC() throws Throwable {
		try {	
			String mail = "sorin@yopmail.com";
			String password = "Lhommeest2019*";
			
			//TRC
			driver = Navigateur.choixBrowser("chrome");
			MicroFonctions.trcURl(driver, env);
			MicroFonctions.AuthentificationTrc(driver, mail, password);
			EntrerCodeRattachement.rattachementTRC(driver, code, jur);
			driver.close();
		}catch (Exception e) {
			
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
			}
	}
		
	@Test(priority=3)	
	public void verification_BD() throws Throwable {
		try {	
			//base de donnée
			switch (jur) {
			case "TA":
			if(env=="rec") {
				DB_id = "tr2_ta75";
				DB_mdp = "tr2_ta75";
			}else {
				DB_id = "tr2_ta69";
				DB_mdp = "tr2_ta69";
			}
			JdbcClass.conDBTR(DB_id, DB_mdp, env);
			break;
		case "CAA":
			if(env=="rec") {
				DB_id = "tr2_caa75";
				DB_mdp = "tr2_caa75";
			}else {
				DB_id = "tr2_caa69";
				DB_mdp = "tr2_caa69";
			}
			JdbcClass.conDBTR(DB_id, DB_mdp, env);
			break;
			case "CTX":
				JdbcClass.conDBTR("telerecours", "telerecours", env);
				break;

			default:  System.err.println("Aucune juridiction à ce nom");
				break;
			}
			
			JdbcClass.sqlVerificationRattachement(code.replaceAll(" ", "").replaceAll("-", "").trim());
			
			} catch (Exception e) {
			My_SreenShot.screenshot();
			e.printStackTrace();
		}
	}
		
	@AfterSuite
	public void fin() {
		System.out.println("LE TEST EST TERMINE !!!...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}

}

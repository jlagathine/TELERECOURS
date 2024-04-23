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
import trc.EntrerCodeRattachement;

public class sk_transmission_code_TRC {
	String jur;
	String numdoc;
	String id;
	String mdp;
	String env;
	String code;
	WebDriver driver;
	
	
	@Test
	public void navigation_skipper() throws Throwable {
		env = "rec";
		jur = "CAA";
		id = "lb";
		mdp = "lb";
		numdoc ="2400072"; //CAA 2400070; CE 367628; TA 2400152
		
			//Skipper
			Navigation_Sk_Authentification.authentification(jur, id, mdp);
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
			
			
	@Test	
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
		
	@Test	
	public void verification_BD() throws Throwable {
		try {	
			//base de donnée
			switch (jur) {
			case "TA":
				JdbcClass.conDBTR("tr2_ta75", "tr2_ta75", env);
				break;
			case "CAA":
				JdbcClass.conDBTR("tr2_caa75", "tr2_caa75", env);
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

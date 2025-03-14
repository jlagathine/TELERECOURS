package skipper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurDocTrc;
import lesFonctions.MesFonctions;
import pdfGeneration.PdfCreationEtEcriture;
import requete_depot_enreg.Requete_TR_depot_enreg;
import trc.EntrerCodeRattachement;

public class sk_transmission_code_TRC {
	String jur;
	String browserName;
	String dossier;
	String id;
	String mdp;
	String env;
	String saisine;
	String code;
	String DB_id;
	String DB_mdp;
	String mail;
	String password;
	WebDriver driver;
	
	
	@Test(priority=1)
	public void navigation_skipper() throws Throwable {
		browserName = "edge";
		env = "rec";
		jur = "CAA";
		saisine = "Jugement";
		if(env == "int1") {
			mail = "zaire@yopmail.com";
		}else {
			mail = "martial@yopmail.com";
		}
		password = "Lhommeest2019*";
		id = "lb";//lb en recette ; sice en intégration
		mdp = "lb";//lb en recette; sice en intégration
		dossier = "2500076";//Requete_TR_depot_enreg.TR_depot(jur, browserName, saisine, env); //CAA 2400070; CE 367628; TA 2400152
		
		
		try {
			//Skipper
			Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
			//selection dossier
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, dossier);
		
			//Rattachement
			Navigation_Skipper_Code_RattachementTRC.creationActeurRequerant_Defendeur(jur, env);
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
			
			} catch (Exception e) {
			My_SreenShot.screenshot();
			e.printStackTrace();
			throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}	
	}
					
	@Test(priority=2)	
	public void navigation_TRC() throws Throwable {
		try {	
//			String mail = "zaire@yopmail.com";
//			String password = "Lhommeest2019*";
//			code = "CE412202651435757";
//			jur= "CTX";
//			env = "int1";
			
			//TRC
			driver = Navigateur.choixBrowser("edge");
			MicroFonctions.trcURl(driver, env);
			MicroFonctions.AuthentificationTrc(driver, mail, password);
			EntrerCodeRattachement.rattachementTRC(driver, code, jur, env);
			driver.close();
			
			}catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
			throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
	}
		
	@Test(priority=3)	
	public void verification_BD() throws Throwable {	
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
	}
	
	@Test(priority=4)
	public void verification_rattachement_dossier_sk_tr() throws Throwable {
		switch (jur) {
		
		case "TA":
			JdbcClass.conDBTR(DB_id, DB_mdp, env);
			break;
		
		case "CAA":
			JdbcClass.conDBTR(DB_id, DB_mdp, env);
			break;
		
		case "CTX":
			JdbcClass.conDBTR("telerecours", "telerecours", env);
			break;

		default:  System.err.println("Aucune juridiction à ce nom");
			break;
		}
		
		//Connexion base de donnée TR
		   JdbcClass.conDBTRC(env);
		   JdbcClass.TRC_Verification_creation_dossier_BDTRC(dossier);
		   JdbcClass.TRC_Verification_creation_dossier_BDTR(dossier);
	}
	
	@Test(priority=5)
	   public void Trc_depot_documents() throws Throwable {
//		dossier = "412238";
//		mail = "zaire@yopmail.com";
//		jur = "CTX";
//		browserName = "edge";
//		env = "int1";
		
		driver = Navigateur.choixBrowser(browserName);
	   try {
		JurDocTrc.authentification(driver, env, mail);
		
		//Dépôt de document
		JurDocTrc.docDepotMem(driver, dossier, jur);
		
		//Vérification des mail
		JurDocTrc.verification_Mail_Depot_Doc_TRC(driver, mail, env);
			
		//Suppression mail
		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
		
	    }catch (Exception e) {
		
		My_SreenShot.takeScreenshot(driver);
		e.printStackTrace();
		throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   }
	    }
			
		@Test(priority=6)
		public void trc_enregistrement_doc() throws Throwable {
			try {
		//Enregistrement du documment
		JurDocTrc.docEnregTrc(driver, dossier, jur);	
		
		//Vérification des mail
		JurDocTrc.verification_Mail_Enreg_Doc_TRC(driver, mail, env);
		
		//Suppression mail
		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
		
			}catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
			throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
		}
		
		@Test(priority=7)
		public void fin() throws InterruptedException {
			MicroFonctions.deconnexionTrInt(driver);
			System.out.println("LE TEST EST TERMINE !!!...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			driver.quit();
		}

}

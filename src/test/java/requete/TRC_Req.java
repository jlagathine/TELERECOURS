package requete;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurReqTrc;
import lesFonctions.MesFonctions;
import trc.RefusTrc;

public class TRC_Req {
	
	   WebDriver driver;
	   String browserName;
	   String recours;
	   String jur;
	   String mail;
	   String env;
	   String dossier;
	   String formulaire;
	   String select;
	   String scn;


	   @BeforeSuite
	   public void InitialisationDoc() throws Throwable {
	   browserName = "chrome";//firefox ; chrome ; edge
	   recours = "seulRequerant";//les types de recours = "seulRequerant"; "autresRequerant"; "mandataire"
	   jur = "TA"; //les types de dépôt sont : "TA" ou "CAA" et "CTX"
	   formulaire = "NoForm"; //NoForm/Form /Form1 avec ou sans formulaire 
	   env = "int1";//int1 ou rec
	   
	   if(jur.equals("TA")) {
		   select = "DALO/DAHO"; //Autre ; DALO/DAHO - urgence TRC
		   scn = "1";// Ne fonctionne que si le select = 'DALO/DAHO' selectionné . nombre de scenarii : 1 ; 2 ; 3
	   }
	   
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }

	   @BeforeMethod
	   public void connexionTrc() throws Throwable  {
		   
			if(env == "int1") {
				mail = "zaire@yopmail.com";//mail = "zaire@yopmail.com";//"zaire@yopmail.com" pour l'INT1; "delvy@yopmail.com" pour la recette 
			}else {
				mail = "martial@yopmail.com";
			}
			
		JurReqTrc.firstSteps(driver, recours, env, mail);
		
	   }
	  
	   @Test//(enabled=true)
	   public void depotTrc() throws Throwable {
	   try {
	   //Dépôt de req
	   JurReqTrc.reqDepotTrc(driver, jur, formulaire, select, scn);
	   
   		//Vérification des mail
		JurReqTrc.verification_Mail_Depot_Req_TRC(driver, mail, env);
			
		//Suppression mail
		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
			
		//Vérification de la notification de la requête
		dossier = JurReqTrc.Verification_Req_Async_DB(env, jur, mail);
		
	   
		//Refuser la requête
//		RefusTrc.reqRefusTrc(driver, jur, dossier, env);
		
		//Vérification des mail
//		RefusTrc.verification_Mail_Refus_Req_TRC(driver, mail, env);
		
		//Suppression mail
//		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
		
		
		
		//Enregistrement de la req
		JurReqTrc.reqEnrgTrc(driver, jur, dossier, env, scn);
	   
   		//Vérification des mail
 		JurReqTrc.verification_Mail_Enreg_Req_TRC(driver, mail, env);
 		
 		//Suppression mail
 		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
	   
	   }catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
	   		}
	   }
	   
	   
	   @AfterMethod
		public void déconnexion() throws Exception {
			MicroFonctions.deconnexionTrInt(driver);
		}
		
	   @AfterSuite
	   public void fin() {
			System.out.println("LE TEST EST TERMINE !!!...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			driver.quit();
		}
}

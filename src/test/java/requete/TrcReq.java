package requete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurReqTrc;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class TrcReq {
	
	   WebDriver driver;
	   DesiredCapabilities caps;
	   ChromeOptions options;
	   WebElement element; 
	   String username;
	   String password;
	   String browserName;
	   boolean verif;
	   String myXpath;
	   String recours;
	   Select select;
	   String jur;
	   String mail;
	   String env;
	   String dossier;
	   String formulaire;


	@BeforeSuite
	   public void InitialisationDoc() {
		   browserName = "firefox";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
	   }

	   @BeforeMethod
	   public void connexionTrc() throws Throwable  {
		recours = "seulRequerant";//les types de recours = "seulRequerant"; "autresRequerant"; "mandataire"
//		mail = "zaire@yopmail.com";//"zaire@yopmail.com" pour l'INT1; "delvy@yopmail.com" pour la recette 
		env = "rec";//int1 ou rec
		if(env == "int1") {
			mail = "zaire@yopmail.com";
		}else {
			mail = "martial@yopmail.com";
		}
		JurReqTrc.firstSteps(driver, recours, env, mail);
		
	   }
	  
	   @Test//(enabled=true)
	   public void depotTrc() throws Throwable {
	   try {
	   jur = "TA"; //les types de dépôt sont : "TA" ou "CAA" et "CTX"
	   formulaire = "NoForm"; //NoForm/Form /Form1 avec ou sans formulaire 
	   
	   //Dépôt de req
	   JurReqTrc.reqDepotTrc(driver, jur, formulaire);
	   
   		//Vérification des mail
		JurReqTrc.verification_Mail_Depot_Req_TRC(driver, mail, env);
			
		//Suppression mail
		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
			
		//Vérification de la notification de la requête
		dossier = JurReqTrc.Verification_Req_Async_DB(env, jur, mail);
		
		
	   
		//Refuser la requête
//		RefusTrc.reqRefusTrc(driver, jur, dossier);
		
		//Vérification des mail
//		RefusTrc.verification_Mail_Refus_Req_TRC(driver, mail, env);
		
		//Suppression mail
//		microfonctions.suppression_Mail_MailHog(driver, mail, env);
		
		
		
		//Enregistrement de la req
		JurReqTrc.reqEnrgTrc(driver, jur, dossier);
	   
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

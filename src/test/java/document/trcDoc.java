package document;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurDocTrc;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

	public class trcDoc {
		
		 WebDriver driver;
		   DesiredCapabilities caps;
		   WebElement element; 
		   String username;
		   String password;
		   boolean verif;
		   String myXpath;
		   String browserName;
		   String value;
		   String jur;
		   String dossier;
		   String identifiant;
		   String mdp;
		   String mail;
		   String onglet;
		   String monUrl;
		   String env;
		   
		   
		   @BeforeSuite
		   public void InitialisationDoc () {
		   browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   }
		   
		   @BeforeMethod
		   public void connexionTrc() throws Throwable  {
			   env = "rec";//int1 ou rec
			   if(env == "int1") {
					mail = "zaire@yopmail.com";
				}else {
					mail = "sorin@yopmail.com";
				}
			 JurDocTrc.authentification(driver, env, mail);
		   }
				
			@Test
			public void depotPieceTrc () throws Throwable {
				
			//choix du dossier de dépôt de mémoires
			dossier = "367630";//dossier : est le numéro de dossier 
			jur = "CTX"; //"TA" ou "CAA" et "CTX"(solution de contournement quant aux numéros de dossiers à la fois présents dans les deux juridictions)
			
			try {
				
				//Dépôt de document
				JurDocTrc.docDepotMem(driver, verif, dossier, jur);
				
				//Vérification des mail
				JurDocTrc.verification_Mail_Depot_Doc_TRC(driver, mail, env);
					
				//Suppression mail
				MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
				
				
				
				//Enregistrement du documment
				JurDocTrc.docEnregTrc(driver, dossier, jur);
				
				//Vérification des mail
				JurDocTrc.verification_Mail_Enreg_Doc_TRC(driver, mail, env);
		 		
		 		//Suppression mail
		 		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
				
			} catch (Exception e) {
				
				My_SreenShot.takeScreenshot(driver);
				e.printStackTrace();
				
				}
			}		
			
		 	@AfterMethod
		 	public void déconnexion() throws Throwable {
				MicroFonctions.deconnexionTrInt(driver);
				
			}
				
			@AfterSuite
			public void fin() {
				System.out.println("LE TEST EST TERMINE !!!....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				driver.quit();
			}
}
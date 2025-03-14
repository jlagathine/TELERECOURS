package inscription;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

//la réalisation de ce test nécessite qu'un mail de récupération d'identifiant soit envoyé et que ce dernier
//arrive à expiration (vérifier dans les paramêtre le temps de validité du jeton) 
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurIdentMdpOublie;

public class Identifiant_Mdp_Oublies_Recovery_Lien_Expire {
	WebDriver driver; 
	   String browserName;
	   String mail;
	   String jur;
	
	
	   @Test//(invocationCount = 5)==loop i=5
		public void recuperation_identifiants_apres_expriration_jeton() throws Throwable {
		   try {
		   browserName = "firefox";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   
			mail = "boycarole@yopmail.com";
			jur = "TACAA";
		   JurIdentMdpOublie.recupIndentLienInvalideMdp(driver, jur, mail);
		   } 
		   catch (Exception e) {
			   My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
				}
		   }
	   
	   @AfterMethod
		public void deconnexion() throws Exception {
		   MicroFonctions.deconnexionTrExt(driver);

		}
				
		@AfterSuite
		public void fin() {
			System.out.println("LE TEST EST TERMINE !!!");
			driver.quit();
		}
}

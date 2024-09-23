package inscription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurIdentMdpOublie;
//la réalisation de ce test nécessite qu'un mail de récupération d'identifiant soit envoyé et que ce dernier
//arrive à expiration (vérifier dans les paramêtre le temps de validité du jeton) 
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;

public class IdentMdpOublie_Recovery {
	WebDriver driver;
	   DesiredCapabilities caps;
	   WebElement element; 
	   String username;
	   String password;
	   boolean verif;
	   String myXpath;
	   String browserName;
	   String value;
	   String identifiant;
	   String mail;
	   String choixJur;
	
	
	   @Test//(invocationCount = 5)==loop i=5
		public void recuperation_identifiants_apres_expriration_jeton() throws Throwable {
		   try {
		   browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   
			mail = "gianis@yopmail.com";
			choixJur = "TACAA";
		   JurIdentMdpOublie.recupIndentLienInvalideMdp(driver, element, choixJur, mail);
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

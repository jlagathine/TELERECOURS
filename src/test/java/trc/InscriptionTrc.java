package trc;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;
import trcFonctions.CreationCompteTrc;

public class InscriptionTrc {
	
	String browserName;
	WebDriver driver;
	WebElement element;
	String type ;
	String compagny;
	String env;
	
	@BeforeSuite
	 public void navigateur () throws IOException {
		   browserName = "edge";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   }
	
	 @BeforeMethod
	 public void getPageTrc () {
		 env = "int1";//Vérifier si le test est en int1 ou en recette
		 MicroFonctions.accueilPageTrc(driver, env);
	 }
	 
//	 @Ignore
	 @Test(priority = 1)
	 public void formulaireParticulierTrc() throws Throwable {
		 try {
			 
		 type = "ParticulierDefaut";//ParticulierDefaut; Particulier
		 CreationCompteTrc.inscriptionTypeTrc(driver, type, compagny);
		 CreationCompteTrc.activationCpt(driver, env);
		 String name = "chantale";
		 CreationCompteTrc.modificationCompteTrc(driver, name, env);
		 CreationCompteTrc.reinitialisationMdp(driver, env);
		 
	 	}catch(Exception e) {
	 	   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		   throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	   		}
//		 CreationCompte.delUser();//Inutile 
		
	 }
	 
//	 @Ignore
	 @Test(priority = 2)
	 public void formulaireMoralTrc () throws Throwable {
		 try {
			 
		 type = "Compagnie";
		 compagny = "Pizza";
		 CreationCompteTrc.inscriptionTypeTrc(driver, type, compagny);
		 CreationCompteTrc.activationCpt(driver, env);
		 String name = "TAPI";//TAPI ; YALU
		 CreationCompteTrc.modificationCompteTrc(driver, name, env);
		 CreationCompteTrc.reinitialisationMdp(driver, env);
		 
		 }catch(Exception e) {
			 My_SreenShot.takeScreenshot(driver);
			 e.printStackTrace();
			 throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   		}  
	 }
	 

	 @AfterSuite
		public void fin() {
			System.out.println("LE TEST EST TERMINE !!!");
			driver.close();
			driver.quit();
		}

}

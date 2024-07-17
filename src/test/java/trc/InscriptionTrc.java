package trc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import trcFonctions.CreationCompteTrc;

public class InscriptionTrc {
	
	String browserName;
	WebDriver driver;
	WebElement element;
	String type ;
	String compagny;
	
	@BeforeSuite
	 public void navigateur () {
		   browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   }
	
	 @BeforeMethod
	 public void getPageTrc () {
		 String env ="rec";//Vérifier si le test est en int1 ou en recette
		 MicroFonctions.accueilPageTrc(driver, env);
	 }
	 
	 @Test
	 public void formulaireParticulierTrc() throws Throwable {
		 try {
			 
		 type = "Particulier";//ParticulierDefaut; Particulier
		 CreationCompteTrc.inscriptionTypeTrc(driver, type, compagny);
		 CreationCompteTrc.activationCpt(driver);
		 String name = "chantale";
		 CreationCompteTrc.modificationCompteTrc(driver, name);
		 CreationCompteTrc.reinitialisationMdp(driver);
		 
	 	}catch(Exception e) {
	 		My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
	   		}
//		 CreationCompte.delUser();//Inutile 
		
	 }
	 
	 @Test
	 public void formulaireMoralTrc () throws Throwable {
		 try {
			 
		 type = "Compagnie";
		 compagny = "Pizza";
		 CreationCompteTrc.inscriptionTypeTrc(driver, type, compagny);
		 CreationCompteTrc.activationCpt(driver);
		 String name = "TAPI";//TAPI ; YALU
		 CreationCompteTrc.modificationCompteTrc(driver, name);
		 CreationCompteTrc.reinitialisationMdp(driver);
		 
		 }catch(Exception e) {
			 My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		   		}  
	 }
	 
	 
	 @AfterSuite
		public void fin() {
			System.out.println("LE TEST EST TERMINE !!!");
			driver.close();
			driver.quit();
		}

}

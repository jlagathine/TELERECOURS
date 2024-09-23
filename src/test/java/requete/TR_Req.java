package requete;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurReqTr;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;

public class TR_Req {

	WebDriver driver;
	   String browserName;
	   String env;
	   String dossier;
	   String choixJur;
	   String saisine;
	
	   @BeforeSuite
	   public void InitialisationDoc(){
	   browserName = "chrome";
	   env = "rec";
	   choixJur = "CAA";//CAA, CTX, TA
	   saisine = "Jugement"; //Premier ressort ; Jugement
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  JurReqTr.maJuridiction(driver, choixJur, env);
	   }
	   
	   @Test
		public void depotReq() throws Throwable {
	    try {
			   dossier = JurReqTr.reqDepot(driver, choixJur, saisine, env);
			   JurReqTr.reqEnreg(driver, choixJur, dossier, env);//attention à la méthode "refusEnrgReq()" et "reqEnreg()"
			   
		} catch (Exception e) {
			
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
			
			}
	   }
	   
	   @AfterMethod
		public void deconnexion() throws Exception {
		   MicroFonctions.deconnexionTrInt(driver);	
		}
				
		@AfterSuite
		public void fin() {
			System.out.println("LE TEST EST TERMINE !!!");
			driver.quit();
		}
	
}

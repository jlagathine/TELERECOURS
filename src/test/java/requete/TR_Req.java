package requete;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurReqTr;

public class TR_Req {

	WebDriver driver;
	   String browserName;
	   String env;
	   String dossier;
	   String jur;
	   String saisine;
	
	   @BeforeSuite
	   public void InitialisationDoc() throws IOException{
	   browserName = "chrome";
	   env = "rec";
	   jur = "TA";//CAA, CTX, TA
	   saisine = "Jugement"; //Premier ressort ; Jugement
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  JurReqTr.maJuridiction(driver, jur, env);
	   }
	   
	   @Test
		public void depotReq() throws Throwable {
	    try {
			   dossier = JurReqTr.reqDepot(driver, jur, saisine, env);
			   JurReqTr.reqEnreg(driver, jur, dossier, env);//attention à la méthode "refusEnrgReq()" et "reqEnreg()"
			   
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
			System.out.println("LE TEST EST TERMINE - !!!!");
			driver.quit();
		}
}

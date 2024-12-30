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

public class TR_Adm_Req {
	WebDriver driver;
	   String browserName;
	   String env;
	   String dossier;
	   String choixJur;
	
	   @BeforeSuite
	   public void InitialisationDoc() throws IOException{
	   browserName = "chrome";
	   env = "rec";
	   choixJur = "CTX";//CAA, CTX, TA
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  JurReqTr.maAdmJuridiction(driver, choixJur, env);
	   }
	   
	   @Test
		public void depotReq() throws Throwable {
	    try {
			   dossier = JurReqTr.reqAdmDepot(driver, choixJur, env); 
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

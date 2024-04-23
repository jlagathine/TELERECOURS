package requete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	   DesiredCapabilities caps;
	   WebElement element; 
	   String username;
	   String password;
	   boolean verif;
	   String myXpath;
	   String browserName;
	   String value;
	   String identifiant;
	   String mdp;
	   String choixJur;
	
	   @BeforeSuite
	   public void InitialisationDoc(){
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  choixJur = "TA";//CAA, CTX, TA
		  JurReqTr.maJuridiction(driver, choixJur);
	   }
	   
	   @Test
		public void depotReq() throws Throwable {
	    try {
			   JurReqTr.reqDepot(driver, choixJur);
			   
			   JurReqTr.reqEnreg(driver, choixJur);//attention à la méthode "refusEnrgReq()" et "reqEnreg()"
			   
		} catch (Exception e) {
			
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
			System.out.println("LE TEST EST TERMINE !!!");
			driver.quit();
		}
	
}

package requete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import juridictions.JurReqTr;
import juridictions.JurReqTrFlechage;

public class TR_ReqFlechage {
	
	WebDriver driver;
	   String browserName;
	   String env;
	   String jur;
	
	   @BeforeSuite
	   public void InitialisationDoc () throws Throwable{
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  jur = "TA";
		  env = "rec";
		  JurReqTr.maJuridiction(driver, jur, env);
	   }
	   
	   @Test
		public void depotReq() throws Throwable {
				
		   JurReqTrFlechage.reqDepotFlec(driver, jur);
		   
		   JurReqTrFlechage.reqEnreg(driver, jur, env);
		   
		   JurReqTrFlechage.reqJurVer(driver, jur);
		   }
	   
	   @AfterMethod
		public void déconnexion() throws Exception {
			Thread.sleep(100);


			driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
			System.out.println("Déconnexion réussie");
			Thread.sleep(200);
		}
			
		@AfterSuite
		public void fin() {
			System.out.println("LE TEST EST TERMINE !!!");
			driver.quit();
		}
	
}



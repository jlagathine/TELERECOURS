package refus;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import juridictions.JurRefusReqTR;

public class RefusReqTR {

	WebDriver driver;
	   String env;
	   String browserName;
	   String mdp;
	   String choixJur;
	
	   @BeforeSuite
	   public void InitialisationDoc () throws IOException{
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  choixJur = "CTX";
		  JurRefusReqTR.juridiction(driver, choixJur, env);  
	   }
	   
	   @Test
		public void depotReq() throws Throwable {
		   JurRefusReqTR.depot(driver, choixJur);
		   JurRefusReqTR.reqRefuser(driver, choixJur);
	   }
	   
	   @AfterMethod
		public void déconnexion() throws Exception {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
			System.out.println("Déconnexion réussie");
			Thread.sleep(2000);
		}
				
		@AfterSuite
		public void fin() {
			System.out.println("LE TEST EST TERMINE !!!");
			driver.quit();
		}
	
}

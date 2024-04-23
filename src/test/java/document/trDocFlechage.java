package document;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurDocTrFlechage;
import browser.Navigateur;

public class trDocFlechage {

	
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
	   public void InitialisationDoc (){
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  choixJur = "Tribunal";
		  JurDocTrFlechage.maJuridiction(driver, choixJur);
	   }
	  
	   @Test
	   public void depotDoc() throws Throwable {
		   JurDocTrFlechage.docDepotMem(driver, choixJur);
		   
		   JurDocTrFlechage.docEnregMem(driver, choixJur);
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

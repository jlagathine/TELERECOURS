package telechargement_archive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurTelechargementTr;
import browser.Navigateur;

public class DemArch {
	
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
	   String choiJur;
	   String dossier;

	 @BeforeSuite
	   public void navigateur () {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	 
	 @BeforeMethod 
	 public void initialisation () throws Throwable {
		 choiJur = "CTX";
		 dossier = "367856";//2300045 (TA) ;2300023 (CAA) ;366709 (CTX) 
		JurTelechargementTr.actExtConnexion(driver, choiJur); 
	 }
	 
	 @Test
	 public void exploitation() throws Throwable {
		
		JurTelechargementTr.telechargement(driver, dossier) ;
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

package document;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import juridictions.JurAnnulEnrgDocTr;
import juridictions.JurDocTr;

public class AnnulEnrgDocTr {
	
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
	   String dossier;
	   String env;
	   
	   @BeforeSuite
	   public void InitialisationDoc () throws IOException {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		  choixJur = "Conseil"; //Préciser le dossier
		  JurDocTr.maJuridiction(driver, choixJur, env);
	   }
	   
	   @Test
		public void annulDepotDoc() throws Throwable {
		dossier = "366531"; //Tribunal dossier = "2201014" ; cour dossier = "2200600" ; Conseil dossier = "366531"
		
		JurDocTr.docDepotMem(driver, choixJur, dossier);
		Thread.sleep(2000);
		
		String doc = JurDocTr.docEnregMem(driver, choixJur, dossier, env);
		
		JurAnnulEnrgDocTr.annulEnrgDoc(driver, element, choixJur, doc);
	   
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

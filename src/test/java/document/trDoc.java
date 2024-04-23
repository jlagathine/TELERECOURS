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

import Juridictions.JurDocTr;
import browser.Navigateur;

	public class trDoc {
		
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
		   public void InitialisationDoc () {
		   browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   }
		   
		   @BeforeMethod
		   public void connexionTr() throws Throwable  {
			  choiJur = "CTX"; //Ne pas oublier de mettre les autres juridiction en commentaire
			  JurDocTr.maJuridiction(driver, choiJur);
		   }
				
			@Test(enabled=false)
			public void depotDocTA() throws Throwable {
					dossier = "2400248";
					
					JurDocTr.docDepotMem(driver, choiJur, dossier);
					Thread.sleep(200);
					
					JurDocTr.docEnregMem(driver, choiJur, dossier);
			   }
			
			@Test(enabled=true)
			public void depotDocCAA() throws Throwable {
					dossier = "2300023";
					
					JurDocTr.docDepotMem(driver, choiJur, dossier);
					Thread.sleep(200);
					
					JurDocTr.docEnregMem(driver, choiJur, dossier);
			   }
			
			@Test
			public void depotDocCE() throws Throwable {
					dossier = "366709";
					
					JurDocTr.docDepotMem(driver, choiJur, dossier);
					Thread.sleep(200);
					
					JurDocTr.docEnregMem(driver, choiJur, dossier);
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

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
import requete_depot_enreg.Requete_TR_depot_enreg;
/*
 * MISE A NIVEAU IMPERATIVE !!!!!
 * 
 * 
 */
	public class trDoc {
		
		   WebDriver driver;
		   WebElement element; 
		   String browserName;
		   String choiJur;
		   String dossier;
		   String env;
		   
		   @BeforeSuite
		   public void InitialisationDoc () {
		   browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   }
		   
		   @BeforeMethod
		   public void connexionTr() throws Throwable  {
			  env = "int1"; 
			  choiJur = "CAA"; //Ne pas oublier de mettre les autres juridiction en commentaire
			  dossier = "2400070";//Requete_TR_depot_enreg.TR_depot(jur, browserName, env);
			  JurDocTr.maJuridiction(driver, choiJur, env);
		   }
				
			@Test
			public void depotDoc() throws Throwable {
					
					
					JurDocTr.docDepotMem(driver, choiJur, dossier);
					Thread.sleep(200);
					
					JurDocTr.docEnregMem(driver, choiJur, dossier, env);
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

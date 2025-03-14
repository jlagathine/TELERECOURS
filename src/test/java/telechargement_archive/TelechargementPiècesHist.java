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

import browser.Navigateur;
import juridictions.JurTelechargementTr;
import juridictions.Verif_ordre_pieces_apres_fusion;


public class TelechargementPiècesHist {
	
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
	
	   @BeforeSuite
	   public void InitialisationDoc () throws Throwable{
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod 
	   public void initialisation () throws Throwable {
		   choixJur = "CAA";
			JurTelechargementTr.actIntConnexion(driver, choixJur);//attention à "actIntConnexion" et "actExtConnexion" 
		 }
	   
	   @Test
	   public void téléchargementFichiersParEvent() throws Throwable {
		   dossier = "2400188";// bien choisir le dossier
		   JurTelechargementTr.telechgtOngletHisto(driver, choixJur, dossier);
		   Verif_ordre_pieces_apres_fusion.telechargement_de_la_fusion_des_pieces(driver);
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

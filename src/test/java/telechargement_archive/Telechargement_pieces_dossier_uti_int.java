package telechargement_archive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import fonctionnalites.MicroFonctions;
import juridictions.JurTelechargementTr;
import juridictions.Verif_ordre_pieces_apres_fusion;

public class Telechargement_pieces_dossier_uti_int {
	
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
	   String jur;
	   String dossier;

	 @BeforeSuite
	   public void navigateur () throws Throwable {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	 
	 @BeforeMethod 
	 public void initialisation () throws Throwable {
		 jur = "CTX";
		 dossier = "368007";//2300045 (TA) ; 2300023 (CAA) ; 366709 (CTX) 
		JurTelechargementTr.actIntConnexion(driver, jur); 
	 }
	 
	 @Test
	 public void exploitation() throws Throwable {
		
		JurTelechargementTr.telechargement(driver, dossier) ;
	 }
	 
	 @Test
	 public void verification_ordre_des_pieces_apres_fusion() throws InterruptedException{
		Verif_ordre_pieces_apres_fusion.conglet_telechargement(driver);
		Verif_ordre_pieces_apres_fusion.telechargement_de_la_fusion_des_pieces(driver);
	 }
	 
	 @AfterMethod
	 public void déconnexion() throws Exception {
		Thread.sleep(100);
		MicroFonctions.deconnexionTrInt(driver);
		System.out.println("Déconnexion réussie");
		Thread.sleep(200);
		}
				
	 @AfterSuite
	 public void fin() {
		System.out.println("LE TEST EST TERMINE !!!");
		driver.quit();
	}
}

package inscription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import juridictions.JurInscripTr;
import juridictions.JurInscriptAdmin;

public class Inscription_Administration {
	
	
	WebDriver driver;
	String identifiant;
	String mdp;
	String code;
	String motdepasse;
	String myXpath;
	boolean verif;
	WebElement element;
	String browserName;
	String choixJur;
	String nomCE;
	String nom;
	String prenom;
	String env;

	 @BeforeSuite
	   public void navigateur () throws Throwable {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	 
	 @BeforeMethod
		public void choixSite() throws Throwable {
			choixJur = "Conseil";//TACAA, Conseil
			env = "int1";//rec ou int1
			JurInscripTr.maJuridiction(driver, choixJur, env);
		}
	 
	 @Test
		public void inscription() throws Throwable {
			choixJur = "CE";
			
			mdp = "Lhommeest2019*";
			code = "CE-wc4adx" ;
			motdepasse = "czw5dn";
			nom = "";
			prenom = "";
			//ne pas oublier de définir les Strings "nom" et "prenom" dans "JuriInscriptAdmin"
			
			//Inscription
			JurInscriptAdmin.inscription(driver, choixJur, code, motdepasse, nom, prenom);
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

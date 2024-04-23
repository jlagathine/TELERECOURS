package inscription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurIdentMdpOublie;
//la réalisation de ce test nécessite qu'un mail de récupération d'identifiant soit envoyé et que ce dernier
//arrive à expiration (vérifier dans les paramêtre le temps de validité du jeton) 
import browser.Navigateur;

public class IdentMdpOublie {
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
	   String mail;
	   String choixJur;
	
	   @BeforeSuite
	   public void InitialisationDoc (){
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	   
	   @BeforeMethod
	   public void connexionTr() throws Throwable  {
		   choixJur = "TACAA";
		  JurIdentMdpOublie.identMdpLink(driver, choixJur);
	   }
	   
	   @Test//(invocationCount = 5)==loop i=5
		public void depotReqTA() throws Throwable {
		   
			mail = "bussy@yopmail.com";
			choixJur = "TACAA";
		   JurIdentMdpOublie.recupIndentLienInvalideMdp(driver, element, choixJur, mail);	
		   }
	   
	   @AfterMethod
		public void deconnexion() throws Exception {
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

package inscription;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Juridictions.JurInscripTr;
import browser.Navigateur;

public class inscriptAvo {
	
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
	String env;
	

	@BeforeSuite
	public void InitialisationDoc () throws IOException {
		 browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);	
	}
			
	@BeforeMethod
	public void choixSite() throws Throwable {
		choixJur = "Conseil";//TACAA, Conseil
		env = "rec"; //rec ou int1
		JurInscripTr.maJuridiction(driver, choixJur, env);
	}
	
	@Test
	public void inscription() throws Throwable {
		
		mdp = "Lhommeest2019*";
		code = "CE-4kfrwj" ;
		motdepasse = "8iktr7";
		nomCE = "";
		
		//Inscription
		JurInscripTr.obtenirCode(driver, choixJur, code, motdepasse, nomCE);
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

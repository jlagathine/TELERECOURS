package inscription;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import changement_PreferencesUtilisateur.Preferences_Utilisateur;
import fonctionnalites.MicroFonctions;
import juridictions.JurReqTr;

public class ModificationMDP_PreferencesUtilisateur {

	WebDriver driver;
	String browserName;
	String jur;
	String env;
	
	
	@BeforeSuite
	public void InitialisationDoc () throws Throwable{
	browserName = "chrome";
	env = "rec";
	driver = Navigateur.choixBrowser(browserName);
	System.out.println(driver);
	   }
	
	@BeforeMethod
    public void connexionTr() throws Throwable  {
	jur = "TA";
	JurReqTr.maJuridiction(driver, jur, env);
	   }
	
	@Test
	public void changemetMDP() throws Throwable {
	Preferences_Utilisateur.preferences_MDP(driver, jur);
	}
	
	
	@AfterMethod
	public void déconnexion() throws Exception {
	   MicroFonctions.deconnexionTrExt(driver);	
	}
			
	@AfterSuite
	public void fin() {
		System.out.println("LE TEST EST TERMINE !!!");
		driver.quit();
	}

	
}

package referentiel_poco;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browser.Navigateur;
import captureTool.My_SreenShot;
import referentiel.Authentication;
import referentiel.Profile;

public class Referentiel_Verification_Profile {
	String browserName;
	String username;
	String mdp;
	String profile;
	WebDriver driver;
	
	@Test(priority = 1)
	public void connexion() throws Throwable {
		browserName = "chrome";
		username = "balt";//"cetatadmin"; "Martial"; "Masse"; "balt"
		mdp = "Lhommeest2019*";//"@Ref45metrixware"; "Lhommeest2019*"
		profile = "admin_loc";//"lect"; "admin_tech"; "admin_loc"
		
		try {
			   driver = Navigateur.choixBrowser(browserName);
			   System.out.println(driver);
			   Authentication.seConnecter_referentiel(driver, username, mdp);
			   
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}	
	}
	
	@Test(priority = 2)
	public void verification_profile() throws Throwable {
		try {
				Profile.verification_profile(driver, profile);
				
		} catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
		}
		
	}
}

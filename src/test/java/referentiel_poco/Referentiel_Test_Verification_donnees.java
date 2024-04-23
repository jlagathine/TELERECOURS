package referentiel_poco;

import org.openqa.selenium.WebDriver;

import browser.Navigateur;
import captureTool.My_SreenShot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import referentiel.Authentication;
import referentiel.Verification_element_page_accueil;

public class Referentiel_Test_Verification_donnees {
	
	String browserName;
	String username;
	String mdp;
	WebDriver driver;
	
	@Given("connexion")
	public void connexion() throws Throwable {
		try {
			
			browserName = "chrome";
			   driver = Navigateur.choixBrowser(browserName);
			   System.out.println(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}
		
	}
	
	@When("Authentification")
	public void authentification() throws Throwable {
		username = "cetatadmin";
		mdp = "@Ref45metrixware";
		
		try {
			
			Authentication.seConnecter_referentiel(driver, username, mdp);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}
	}
	
	@Then("Je peux consulter l'ensemble des données enregistrées par référentiel")
	public void donneeRef() throws Throwable {
		try {
			
			Verification_element_page_accueil.verification_nomRef_nbrRef_actRef(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}
	}
}

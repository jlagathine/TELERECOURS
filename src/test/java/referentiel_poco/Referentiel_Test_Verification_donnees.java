package referentiel_poco;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browser.Navigateur;
import captureTool.My_SreenShot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import referentiel.Authentication;
import referentiel.Les_Referentiels_Pagination;
import referentiel.Verification_element_page_accueil;

public class Referentiel_Test_Verification_donnees {
	
	String browserName;
	String username;
	String mdp;
	WebDriver driver;
	
//	@Given("connexion")
	@Test(priority = 1)
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
	
//	@When("Authentification")
	@Test(priority = 2)
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
	
//	@Then("Je peux consulter l'ensemble des données enregistrées par référentiel")
	@Test(priority = 3)
	public void donnees_Ref() throws Throwable {
		try {
			
			Verification_element_page_accueil.verification_nomRef_nbrRef_actRef(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void pagination_ref() throws Throwable {
		try {
			
			Les_Referentiels_Pagination.verification_pagination(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}
	}
}

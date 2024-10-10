package referentiel_poco;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import browser.Navigateur;
import captureTool.My_SreenShot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import referentiel.Authentication;
import referentiel.List_Referentiel;

public class Referentiel_Authentication_Test {
		
		String browserName;
		String username;
		String mdp;
		WebDriver driver;
		
		
		@Given("Je me connecte")
		public void connexion() throws IOException {
			browserName = "chrome";
			   driver = Navigateur.choixBrowser(browserName);
			   System.out.println(driver);
		}
		
		@When("Je m'authentifie")
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
		
		@Then("Je peux consulter la liste des référentiels par ordre alphabétique")
		public void accesCompteRef() throws Throwable {
		  try {
			  
			List_Referentiel.Classement_ordre_alphabetique(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
			}
		}
}

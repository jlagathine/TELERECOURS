package referentiel_poco;

import browser.Navigateur;
import captureTool.My_SreenShot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import referentiel.Creer_Referenciel_Civilite;

public class Referentiel_Creation_Civilite extends Navigateur {
	

	@Given("Je clique sur le référentiel CIVILITE")
	public void je_clique_sur_le_référentiel_civilite() throws Throwable {
	    try {
	    	
	    	Creer_Referenciel_Civilite.click_civilite(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}

	}

	@When("Je clique sur le bouton CREER")
	public void je_clique_sur_le_bouton_creer() throws Throwable {
	    try {
	    	
	    	Creer_Referenciel_Civilite.clickBtn_CREER(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}

	}

	@And("J'ajoute un type de civilité")
	public void j_ajoute_un_type_de_civilité() throws Throwable {
	    try {
			
	    	Creer_Referenciel_Civilite.libelle_civilite_CREATION(driver);
	    	
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}

	}
	
	@And("J'ajoute le SUIVI")
	public void j_ajoute_le_suivi() throws Throwable {
		 try {
				
		    	Creer_Referenciel_Civilite.libelle_civilite_SUIVI(driver);
		    	
			} catch (Throwable e) {
				My_SreenShot.takeScreenshot(driver);
				   e.printStackTrace();
			}
	}

	@And("J'ajoute une juridiction")
	public void j_ajoute_une_juridiction() throws Throwable {
	    try {
	    	
	    	Creer_Referenciel_Civilite.choix_juridiction_CE(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}

	}
	
	@And("j'enregistre mon référentiel")
	public void j_enregistre_mon_référentiel() throws Throwable {
	    try {
	    	
	    	Creer_Referenciel_Civilite.clkBtn_VALIDER(driver);
			
		} catch (Throwable e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		}
	}


}

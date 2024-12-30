package changement_PreferencesUtilisateur;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class Preferences_Utilisateurs_Modification_MDP {
	
	public static void modifier_mdp(WebDriver driver, String mdp, String jur) throws InterruptedException {
		//Accès aux préférences utilisateur
		MicroFonctions.accesLienPreferencesUtilisateur(driver, jur);
		
		//Clic sur le lien change ment de mot de passe
		String myXpath = "//a[@id='linkChamgementMotDePasse']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Click sur le lien \"Changer mon mot de passe\"......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		Thread.sleep(300);
		MesFonctions.transitWindow(driver, 2);
		
		//Renseigner le champ "Mot de passe actuel"
		myXpath = "//input[@id='txtMotDePasseActuel']"; 
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(mdp);
		System.out.println("Mot de passe actuel renseigné......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure());
		
		//Renseigner le champ "Nouveau mot de passe"
		String mdp_1 = "Lhommeest2019*";
		myXpath = "//input[@id='txtNouveauMotDePasse']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(mdp_1);
		System.out.println("Nouveau mot de passe renseigné......"+MesFonctions.extractCurrentHeure());
		
		//Renseigner le champ "Confirmation nouveau mot de passe"
		myXpath = "//input[@id='txtConfirmation']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(mdp_1);
		System.out.println("Nouveau mot de passe confirmé......"+MesFonctions.extractCurrentHeure());
		
		//Valider le changement de mot de passe
		myXpath = "//input[@id='btnValider']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Changement de MDP validé......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Retour sur la fenêtre principale
		MesFonctions.transitWindow(driver, 1);
		Thread.sleep(200);
	}

}

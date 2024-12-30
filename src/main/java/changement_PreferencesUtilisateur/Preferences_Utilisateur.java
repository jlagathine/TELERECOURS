package changement_PreferencesUtilisateur;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class Preferences_Utilisateur {
	static String txtMotDePasseActuel;
	static String txtNouveauMotDePasse;
	static String identifiant;
	
	
	/* 	utilisateur utilisé pour ce test
		marc617
		Lhommeest2019* */
	
	public static String preferences_MDP(WebDriver driver, String jur) throws Throwable {
		for(int i=0; i<2 ;i++) {
		//Accès aux préférences utilisateur
		MicroFonctions.accesLienPreferencesUtilisateur(driver, jur);
		
		//Clic sur le lien change ment de mot de passe
		String myXpath = "//a[@id='linkChamgementMotDePasse']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Click sur le lien \"Changer mon mot de passe\"......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		Thread.sleep(1200);
		txtMotDePasseActuel = "Lhommeest2019*";
		txtNouveauMotDePasse = "Lhommeest2019**";	
		//Accès à la nouvelle fenêtre de changement de mot de passe
		MesFonctions.transitWindow(driver, 2);
		
		if(i==0) {
		//Renseigner le champ "Mot de passe actuel"
		myXpath = "//input[@id='txtMotDePasseActuel']"; 
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(txtMotDePasseActuel);
		System.out.println("Mot de passe actuel renseigné......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure());
		}else{
			//Renseigner le champ "Mot de passe actuel"
			myXpath = "//input[@id='txtNouveauMotDePasse']"; 
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(txtMotDePasseActuel);
			System.out.println("Mot de passe actuel renseigné......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure());
		}
		
		if(i==0) {
		//Renseigner le champ "Nouveau mot de passe"
		myXpath = "//input[@id='txtNouveauMotDePasse']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(txtNouveauMotDePasse);
		System.out.println("Nouveau mot de passe renseigné......"+MesFonctions.extractCurrentHeure());
		}else{
			//Renseigner le champ "Nouveau mot de passe"
			myXpath = "//input[@id='txtMotDePasseActuel']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(txtNouveauMotDePasse);
			System.out.println("Nouveau mot de passe renseigné......"+MesFonctions.extractCurrentHeure());
		}
		
		if(i==0) {
		//Renseigner le champ "Confirmation nouveau mot de passe"
		myXpath = "//input[@id='txtConfirmation']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(txtNouveauMotDePasse);
		System.out.println("Nouveau mot de passe confirmé......"+MesFonctions.extractCurrentHeure());
		}else {
			//Renseigner le champ "Confirmation nouveau mot de passe"
			myXpath = "//input[@id='txtConfirmation']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(txtMotDePasseActuel);
			System.out.println("Nouveau mot de passe confirmé......"+MesFonctions.extractCurrentHeure());
		}
		
		//Valider le changement de mot de passe
		myXpath = "//input[@id='btnValider']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Changement de MDP validé......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Retour sur la fenêtre principale
		MesFonctions.transitWindow(driver, 1);
		MicroFonctions.deconnexionTrExt(driver);
		Thread.sleep(2000);
		
		//Vérification de la mise à jour du MDP
		identifiant = "marc617";
		if(i==0) {
		MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, txtNouveauMotDePasse);
		MicroFonctions.choixJuridictionCAA(driver);
		}else {
			MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, txtMotDePasseActuel);
			MicroFonctions.choixJuridictionCAA(driver);
			}
		}
		
		return null;
	}

}

package inscription;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class Inscription_menu_superviseur {
	
	public static void gestion_utilisateur(WebDriver driver) {
		//Accès au menu superviseur
		String myXpath = "//a[text()=\"Afficher le menu Superviseur\"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		System.out.println("Accès au menu superviseur....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Accès à la gestion des utilisateurs
		myXpath = "//td[@id='Entete1_MenuActeur1_im1_AJ']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		System.out.println("Accès à la gestion des utilisateurs....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
	public static String création_nouvel_acteur(WebDriver driver, String id, int count) throws InterruptedException {
		//Clic bouton "Nouvel utilisateur"
		String myXpath = "//input[@id='btnCreer']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		System.out.println("Click bouton \"Nouvel utilisateur\" ....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Ajout d'un utilisateur
			//Civilité
			myXpath = "//select[@id='Mstr_cpMain_ddlCivilite']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.selection(driver, myXpath, "1");
			System.out.println("Civilité renseignée : ");
			
			//Nom
			myXpath = "//input[@id='Mstr_cpMain_txtNom']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String nom = "MONTEST";
			MesFonctions.objet(driver, myXpath).sendKeys(nom);
			System.out.println("Nom renseigné : "+nom);
			
			//Prénom
			myXpath = "//input[@id='Mstr_cpMain_txtPrenom']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String prenom = "Utilisateurs_"+count;
			MesFonctions.objet(driver, myXpath).sendKeys(prenom);
			System.out.println("Prénom renseignée : "+prenom);
			
			//Mail
			myXpath = "//input[@id='Mstr_cpMain_txtMail']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String mail = nom.toLowerCase()+prenom.toLowerCase()+"@yopmail.com";
			MesFonctions.objet(driver, myXpath).sendKeys(mail);
			System.out.println("Mail renseigné : "+mail);
			
			//Habilitation
			myXpath = "//select[@id='Mstr_cpMain_ddlHabilitations']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.selection(driver, myXpath, "TAV");
			System.out.println("Habilitation renseignée : ");
			
		//Enregistrement de de l'ajout de l'utilisateur
		myXpath = "//span[text()='Enregistrer']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		myXpath = "//div[@id='ui-id-2']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println(MesFonctions.objet(driver, myXpath).getText());
		
		myXpath = "//span[@class='ui-button-text' and text()='OK']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		//deconnexion
		MicroFonctions.deconnexionTrExt(driver);
		
		return mail; 
	}

}

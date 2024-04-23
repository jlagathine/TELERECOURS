package Juridictions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lesFonctions.MesFonctions;

public class JurAnnulEnrgDocTr {
	
	public static String annulEnrgDoc (WebDriver driver, WebElement element, String choixJur, String dossier) throws Throwable {
		switch (choixJur) {
		case "Tribunal":
			boolean turn = true;
			while (!turn) {
			//Retour sur l'onglet documents
			String myXpath = "//td[@id='Entete1_MenuActeur1_im1_AE']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Onglet Documents");
			
			//Checkbox enregistrer
			myXpath = "//input[@id='cbEtatEnregistresParJuridiction']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Filtre enregistré sélectionné");
			
			//Clic bouton Rechercher
			myXpath = "//span[@class = 'button-text' and text()= 'Rechercher']";
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Recherche en cours...");
			Thread.sleep(2000);
			turn = MesFonctions.objet(driver, myXpath).isDisplayed();
			}
			
			//Clic dossier
			String myXpath = "//a[@class='numDossier' and (text()='"+ dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Dossier sélectionné");
			
			//Annulation du doc
			myXpath = "//input[@id='btAnnuler']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Clic bouton Annuler l'enregistrement du document");
			
			//Confirmation de l'annulation
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			
			myXpath = "//input[@id='btEnregistrer']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Le document a bien été annulé");
			
			//Retour sur la liste des document "a traiter"
			myXpath = "//td[@id='Entete1_MenuActeur1_im1_AE']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Retour à la liste des documents");
			
			myXpath = "//a[@class='numDossier' and (text()='"+ dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Le document est désormais dans la liste des doc à traiter");
			break;
			
		case "Cour":

			//Checkbox enregistrer
			myXpath = "//input[@id='cbEtatEnregistresParJuridiction']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Filtre enregistré sélectionné");
			
			//Décocher "à traiter"
			myXpath = "//input[@id='cbEtatEnvoyes']";
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Coche à traiter décochée");
			
			//Clic bouton Rechercher
			myXpath = "//a[@id = 'lbRecherche']//span[@class = 'button-text' and text()= 'Rechercher']";
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Recherche en cours...");

			//Clic dossier
			myXpath = "//a[@class='numDossier' and (text()='"+ dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Dossier sélectionné");
			
			//Annulation du doc
			myXpath = "//input[@id='btAnnuler']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Clic bouton Annuler l'enregistrement du document");
			
			//Confirmation de l'annulation
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			
			myXpath = "//input[@id='btEnregistrer']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Le document a bien été annulé");
			
			//Retour sur la liste des document "a traiter"
			myXpath = "//td[@id='Entete1_MenuActeur1_im1_AE']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Retour à la liste des documents");
			
			myXpath = "//a[@class='numDossier' and (text()='"+ dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Le document est désormais dans la liste des doc à traiter");
			break;
			
		case "Conseil":
			//Checkbox enregistrer
			myXpath = "//input[@id='cbEtatEnregistresParJuridiction']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Filtre enregistré sélectionné");
			
			//Clic bouton Rechercher
			myXpath = "//a[@id = 'lbRecherche']//span[@class = 'button-text' and text()= 'Rechercher']";
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Recherche en cours...");
			
			//Clic dossier
			myXpath = "//a[@class='numDossier' and (text()='"+ dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Dossier sélectionné");
			
			//Annulation du doc
			myXpath = "//input[@id='btAnnuler']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Clic bouton Annuler l'enregistrement du document");
			
			//Confirmation de l'annulation
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			
			myXpath = "//input[@id='btEnregistrer']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Le document a bien été annulé");
			
			//Retour sur la liste des document "a traiter"
			myXpath = "//td[@id='Entete1_MenuActeur1_im1_AE']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Retour à la liste des documents");
			
			myXpath = "//a[@class='numDossier' and (text()='"+ dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Le document est désormais dans la liste des doc à traiter");
			break;

		default:System.err.println("Cette juridiction n'existe pas");
			break;
		}
		
		return null;
	}


}

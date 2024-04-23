package Juridictions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurRefusReqTR {
	static String choixJur;
	static String urg;
	static String mat;
	static String myXpath;
	static String value;
	static String auteur;
	static String dateDec;
	static String numero;
	static String identifiant;
	static String mdp;
	static String nom;
	
	public static String juridiction (WebDriver driver, WebElement element, String choixJur) throws Throwable {
		JurReqTr.maJuridiction(driver, choixJur);
		return null;
	}

	public static String depot (WebDriver driver, WebElement element, String choixJur) throws Throwable {
		switch (choixJur) {
		case "TA":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
		
			//Ajouter un requérant
			MicroFonctions.ajouterUnRequerant(driver, choixJur);

			//Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(2000);
			value = "01";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			//Requête
			MicroFonctions.depotFilesReqTr_req(driver);
			
			//Inventaire
			MicroFonctions.depotFilesReqTr_inv(driver);
			
			//Conversion PDF
			MicroFonctions.conversionPDF(driver);
			myXpath ="//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,  myXpath));
			MesFonctions.objet(driver,  myXpath).click();
			Thread.sleep(1000);
			System.out.println("Vérification du fichier effectuée");
			
			//Envoyer
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(2000);
			
			//Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);	
			break;
			
		case "CAA":
			//Préparer l'envoi d'une requête
			
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			
			//Ajouter un requérant
			MicroFonctions.ajouterUnRequerant(driver, choixJur);

			//Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(2000);
			value = "05";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			//Décision attaquée
			Thread.sleep(1000);
			value = "1";
			MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "22/06/2021";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(dateDec);// Date de décision
			
			value = "11027";
			MicroFonctions.choixJuridiction(driver, value, choixJur);
			
			numero = "2100541";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumeroDecision']")).sendKeys(numero);// numéro
			
			MicroFonctions.depotFilesReqTr_Dec(driver);
			
			//Requête
			MicroFonctions.depotFilesReqTr_req(driver);

			//Inventaire
			MicroFonctions.depotFilesReqTr_inv(driver);
			
			//Conversion PDF
			MicroFonctions.conversionPDF(driver);
			myXpath ="//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,  myXpath));
			MesFonctions.objet(driver,  myXpath).click();
			Thread.sleep(1000);
			System.out.println("Vérification du fichier effectuée");
			
			//Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(2000);
			
			//Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			break;
			
		case "CTX":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			
			//Ajouter un requérant
			MicroFonctions.ajouterUnRequerant(driver, choixJur);

			//Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(2000);
			value = "11";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			//Décision attaquée
			Thread.sleep(1000);
			value = "10";
			auteur = MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "07/06/2020";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(dateDec);// Date de décision
			
			value = "11074";
			MicroFonctions.choixJuridiction(driver, value, choixJur);
			
			numero = "2002541";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumeroDecision']")).sendKeys(numero);// numéro
			
			MicroFonctions.depotFilesReqTr_Dec(driver);
			
			//Requête
			MicroFonctions.depotFilesReqTr_req(driver);
			
			//Inventaire
			MicroFonctions.depotFilesReqTr_inv(driver);
			
			//Conversion PDF
			MicroFonctions.conversionPDF(driver);
			myXpath ="//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,  myXpath));
			MesFonctions.objet(driver,  myXpath).click();
			Thread.sleep(1000);
			System.out.println("Vérification du fichier effectuée");
			
			//Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(2000);
			
			//Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			break;

		default: System.err.println("Aucune juridiction trouvée avec ce paramètre");
			break;
		}
		return null;
	}
	
	public static String reqRefuser(WebDriver driver, WebElement element, String choixJur) throws Throwable {
		
		switch (choixJur) {
		case "TA":
			//Récupération du num de reqête
			String dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(2000);
			
			//Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			identifiant = "lb";
			mdp = "lb";
			
			//Authentification
			driver.get("https://www.telerecours.recette.juradm.fr/TA75");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			//Enregistrer le document
			MicroFonctions.accesEnregReq(driver, choixJur, dossier);
			MicroFonctions.formaterNomActeur(driver);
			
			//Refuser la Requête 
			MicroFonctions.refusReqTr(driver);  
		   	System.out.println("Dépôt refus réalisé");
		   	
		   	//Verification du texte
		   	MicroFonctions.verifTextRefus(driver, dossier);
			break;
			
		case "CAA":
			//Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(2000);
			
			//Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			identifiant = "lb";
			mdp = "lb";
			
			//Authentification
			driver.get("https://www.telerecours.recette.juradm.fr/CA75");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			//Enregistrer le document
			MicroFonctions.accesEnregReq(driver, choixJur, dossier);
			MicroFonctions.formaterNomActeur(driver);
			
			//Refuser la Requête 
			MicroFonctions.refusReqTr(driver);  
		   	System.out.println("Dépôt refus réalisé");
		   	
		   	//Verification du texte
		   	MicroFonctions.verifTextRefus(driver, dossier);
			break;
			
		case "CTX":
			//Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(2000);
			
			//Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			identifiant = "fm";
			mdp = "fm";
			
			//Authentification
			driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			//Enregistrer le document
			MicroFonctions.accesEnregReq(driver, choixJur, dossier);
			MicroFonctions.formaterNomActeur(driver);
			
			//Refuser la Requête 
			MicroFonctions.refusReqTr(driver);  
		   	System.out.println("Dépôt refus réalisé");
		   	
		   	//Verification du texte
		   	MicroFonctions.verifTextRefus(driver, dossier);
			break;
			
		default: System.err.println("Aucune juridiction trouvée avec ce paramètre");
		break;
		}
	return null;
	}
}

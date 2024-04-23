package Juridictions;

import java.sql.SQLException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import JDBC.JdbcClass;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurTelechargementTr {

	static WebDriver driver;
	static WebElement element;
	static String choixJur;
	static String identifiant;
	static String mdp;
	static String NUM_DOSSIER;
	static String mot;
	static String etat;
	static String env;
	static boolean verif;
	
	
	public static String actIntConnexion (WebDriver driver, String choixJur) throws SQLException {
		env = "rec";
		switch (choixJur) {
		case "TA":
			//Connexion à la table
			identifiant = "tr2_ta75";
			mdp = "tr2_ta75";
			JdbcClass.conDBTR(identifiant, mdp, env);
				
			//aller à la page de connexion et vérification 
			driver.get("https://www.telerecours.recette.juradm.fr/TA75");
			String myXpath = "//div//h1[text()='Télérecours']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
			//S'authentifier
			identifiant = "lb";
			mdp = "lb";			
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
		
			break;
			
		case "CAA":
			//Connexion à la table
			identifiant = "tr2_caa75";
			mdp = "tr2_caa75";
			JdbcClass.conDBTR(identifiant, mdp, env);
			
			//aller à la page de connexion et vérification 
			driver.get("https://www.telerecours.recette.juradm.fr/CA75");
			myXpath = "//div//h1[text()='Télérecours']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
			//S'authentifier
			identifiant = "lb";
			mdp = "lb";			
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			break;
			
		case "CTX":
			//Connexion à la table
			identifiant = "telerecours";
			mdp = "telerecours";
			JdbcClass.conDBTR(identifiant, mdp, env);
			
			//aller à la page de connexion et vérification 
			driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
			myXpath = "//div//h1[text()='Télérecours']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
			//S'authentifier
			identifiant = "fm";
			mdp = "fm";			
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			break;

		default: System.err.println("Aucune juridiction à ce nom");
			break;
		}
		return null;
	}
	
	public static String actExtConnexion (WebDriver driver, String choixJur) throws Throwable {
		env = "rec";
		switch (choixJur) {
		case "TA":
			//Connexion à la table
			identifiant = "tr2_ta75";
			mdp = "tr2_ta75";
			JdbcClass.conDBTR(identifiant, mdp, env);
				
			//aller à la page de connexion et vérification 
			driver.get("https://www.telerecours.recette.juradm.fr");
			
			//S'authentifier
			identifiant = "afl53e7";
			mdp = "Lhommeest2019*";			
			MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, mdp);
			MicroFonctions.choixJuridictionTA(driver);
		
			break;
			
		case "CAA":
			//Connexion à la table
			identifiant = "tr2_caa75";
			mdp = "tr2_caa75";
			JdbcClass.conDBTR(identifiant, mdp, env);
			
			//aller à la page de connexion et vérification 
			driver.get("https://www.telerecours.recette.juradm.fr");
			
			//S'authentifier
			identifiant = "bus5qtT";
			mdp = "Lhommeest2019*";			
			MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, mdp);
			MicroFonctions.choixJuridictionCAA(driver);
			
			break;
			
		case "CTX":
			//Connexion à la table
			identifiant = "telerecours";
			mdp = "telerecours";
			JdbcClass.conDBTR(identifiant, mdp, env);
			
			//aller à la page de connexion et vérification 
			driver.get("https://www.telerecours.recette.conseil-etat.fr");
			
			//S'authentifier
			identifiant = "dai5mQr";
			mdp = "Lhommeest2019*";			
			MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, mdp);
			MicroFonctions.choixJuridcitionCE(driver);
			
			break;

		default: System.err.println("Aucune juridiction à ce nom");
			break;
		}
		return null;
	}
	
	public static String telechargement(WebDriver driver, String NUM_DOSSIER) throws Throwable {
			//Champs de recherche 
			MicroFonctions.rechercheSimple(driver, NUM_DOSSIER);
			
			//Télécharger le fichier + alerte
			MicroFonctions.telechargementDossier(driver, element);
			
			//changement de window
			String onglet = MesFonctions.getWindow(driver, 1);
			driver.switchTo().window(onglet);
			System.out.println("Retour à la fenêtre principale...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Verification de la page
			String myXpath = "//span[text()='Téléchargements']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à l'onglet de \"TELECHARGEMENT\"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Vérification de l'état du téléchargement
				//vérification des données en table
			JdbcClass.telechargement(NUM_DOSSIER);
			
				//Vérification sur l'interface
			String myXpath3 = "//td[@id='Entete1_MenuActeur1_im1_AR']";
			MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath3).click();
			Thread.sleep(500);

			myXpath = "//tr//td[text()=\""+NUM_DOSSIER+"\"]//following-sibling::td/a";
			while(!MesFonctions.isElementPresent(driver, myXpath, verif)) {
			
				Thread.sleep(200);
				//Aller sur l'onglet "Message";
				String myXpath2 = "//td[@id='Entete1_MenuActeur1_im1_AH']";
				MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath2).click();
				System.out.println("Accès à l'onglet \"MESSAGES\"......."+MesFonctions.extractCurrentHeure());
				
				//onglet autres messages reçus
				String myXpath4 = "//input[@id='btRecu']";
				MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath4).click();
				System.out.println("Accès à l'onglet du tableau \"Autres messages reçus\"......."+MesFonctions.extractCurrentHeure());
//				String myXpath41 = "//a[text()=\"Notification de mise à disposition d'un fichier archive\"]";
//				mesFonctions.waiting2(driver, myXpath41, Duration.ofSeconds(3));
				
				//vérification de la présence du fichier d'archive dans message
				String myXpath1 = "//tr//td[contains(text(),\""+NUM_DOSSIER+"\")]//following-sibling::td/a[contains(text(),'archive')]";
				boolean verif1 = false;
						if(MesFonctions.isElementPresent(driver, myXpath1, verif1)==false) {
							Thread.sleep(100);
							MesFonctions.objet(driver, myXpath3).click();
							System.out.println("Retour à l'onglet TELECHARGEMENT......"+MesFonctions.extractCurrentHeure());
								}
						else
								{
									Thread.sleep(100);
									MesFonctions.objet(driver, myXpath3).click();
									System.out.println("Retour à l'onglet TELECHARGEMENT......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
									myXpath = "//tr//td[text()=\""+NUM_DOSSIER+"\"]//following-sibling::td/a";
									MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									mot = MesFonctions.objet(driver, myXpath).getText();
									System.out.println("Le fichier est à l'état : "+mot);
								}
							}
			//vérification des données en table
			Thread.sleep(200);
			JdbcClass.telechargement(NUM_DOSSIER);

		return null;
	}
	
	public static String telechgtOngletHisto(WebDriver driver, WebElement element, String choixJur, String numDossier) throws Throwable {
		switch (choixJur) {
		case "TA":
			//Champs de recherche 
			MicroFonctions.rechercheSimple(driver, numDossier);
			
			//Consultation onglet Historique
			MicroFonctions.consultationOngletHistoDossier(driver, element);
			
			//Téléchargement fichier depuis les événement de l'historique
			MicroFonctions.telechgtDossierOngletHisto(driver, element);
			break;
			
		case "CAA":
			//Champs de recherche 
			MicroFonctions.rechercheSimple(driver, numDossier);
			
			//Consultation onglet Historique
			MicroFonctions.consultationOngletHistoDossier(driver, element);
			
			//Téléchargement fichier depuis les événement de l'historique
			MicroFonctions.telechgtDossierOngletHisto(driver, element);
			break;
			
		case "CTX":
			//Champs de recherche 
			MicroFonctions.rechercheSimple(driver, numDossier);
			
			//Consultation onglet Historique
			MicroFonctions.consultationOngletHistoDossier(driver, element);
			
			//Téléchargement fichier depuis les événement de l'historique
			MicroFonctions.telechgtDossierOngletHisto(driver, element);
			break;

		default: System.err.println("Aucune juridiction à ce nom"); 
			break;
		}
		
		return null;
	}
	
	public static String chrgemtFichierOngletHisto(WebDriver driver, WebElement element, String choixJur, String numDossier) throws Throwable {
		switch (choixJur) {
		case "TA":
			//Champs de recherche 
			MicroFonctions.rechercheSimple(driver, numDossier);
			
			//Consultation onglet Historique
			MicroFonctions.consultationOngletHistoDossier(driver, element);
			
			//Chargement de dossier
			MicroFonctions.chgtDossierOngletHisto(driver, element);
			break;

		default:
			break;
		}
		
		
		return null;
	}
}

package juridictions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurDoc_Constitution {
	

	public static void choix_url(WebDriver driver, String jur, String env, String id, String mdp) throws Throwable {
	//Choix de l'URL fonction de l'environnement
		
		System.out.println(driver);
		
		switch (jur) {
		case "TA":
			if(env=="rec") {
				   driver.get("https://www.telerecours.recette.juradm.fr/");
			   }else {
				   driver.get("https://www.telerecours.int1.juradm.fr/");
			   }
			
			MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
			MicroFonctions.choixJuridictionTA(driver);
			   
			break;
			
		case "CAA":
			if(env=="rec") {
				   driver.get("https://www.telerecours.recette.juradm.fr/");
			   }else {
				   driver.get("https://www.telerecours.int1.juradm.fr/");
			   }
			
			MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
			MicroFonctions.choixJuridictionCAA(driver);
			
			break;
			
		case "CTX":
			if(env=="rec") {
				   driver.get("https://www.telerecours.recette.conseil-etat.fr/");
			   }else {
				   driver.get("https://www.telerecours.int1.conseil-etat.fr/");
			   }
			   
			MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
			
			break;
			
		default: System.err.println("Cette juridiction n'est pas reconnue....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
	}
	
	
	public static void depot_lettre_constituton(WebDriver driver, String dossier) throws Throwable {
			//Click lien "Me constituer sur une affaire"
			String myXpath = "//a[@id='ConsituterMandaaire']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Click lien \"Me constituer sur une affaire\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
			//Insertion du numéro dossier
			myXpath = "//input[@id='Mstr_cpMain_txtNumsaisi']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(dossier);
			System.out.println("Insertion du numéro dossier : "+dossier+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Validation de la sélection de dossier
			myXpath = "//a[@id='Mstr_cpMain_btnRechercherDossier']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Le choix du dossier : "+dossier+" est validé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Vérifier le message de la fenêtre d'alerte
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			Thread.sleep(300);
			boolean verif = false;
			if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				
				String alerte = "Ce dossier ne fait pas partie des dossiers dans lesquels vous êtes constitué. Souhaitez-vous vous constituer pour ce dossier et effectuer un versement ?";
				
				myXpath = "//div[@id='ui-id-2']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				String mess = MesFonctions.objet(driver, myXpath).getText();
				System.out.println(mess);
				
				if(mess.contains(alerte)) {
					myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.objet(driver, myXpath).click();
					System.out.println();
				}else {
					throw new Exception("Les messages sont différent....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
				
				//Renseigner la partie représentée
				myXpath = "//textarea[@id='Mstr_cpMain_txtReqPrincip']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).clear();
				MesFonctions.objet(driver, myXpath).sendKeys("DEFENDEUR");
				System.out.println("La partie représentée est renseignée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
			else {
				myXpath = "//span[@id='Mstr_cpMain_lblMessageAvertissement']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				String mess = MesFonctions.objet(driver, myXpath).getText();
				System.out.println(mess);
			}

			//Choix du document
			myXpath = "//input[@id='Mstr_cpMain_rbPj_2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Le choix du document réalisé : "+MesFonctions.objet(driver, myXpath).getDomAttribute("value")+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Type de lettre sélectionné
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeCourrier']";
			String value = "RECLETT";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.selection(driver, myXpath, value);
			System.out.println("Type de lettre sélectionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Insertion de la pièce 
			myXpath = "//input[@id='Mstr_cpMain_FileUploadFichierCourrier_fileUpload']";
			Thread.sleep(300);
			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La lettre de constitution.pdf");
			
			//Envoyer
			myXpath = "//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]";
			MesFonctions.objet(driver, myXpath).click();// Vérification
			
			//Envoi du dépôt après vérification
			MicroFonctions.envoiDepotTr(driver);
	
	}

	
}

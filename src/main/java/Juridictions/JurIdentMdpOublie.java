package Juridictions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurIdentMdpOublie {
	static String nomCE;
	static boolean verif;
	static String name;
	static String myXpath;
	static String onglet;
	static String env;
	
	public static String identMdpLink (WebDriver driver, String choixJur) throws Throwable {
		switch (choixJur) {
		case "TACAA":
			env = "rec"; //rec ou int1
			JurInscripTr.maJuridiction(driver, choixJur, env);
			Thread.sleep(1000);
			
			//Clic sur le lien 
			String myXpath = "//a[@href and text()='Identifiant et/ou mot de passe oublié ?']";
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Clic sur le lien Identifiant et/ou mot de passe oublié ?......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Accès page de récupération des indentifiants
			myXpath = "//h1[text()='Récupérer ses identifiants de connexion']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Page de récupération de ses identifiants......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "Conseil":
			env = "rec"; //rec ou int1
			JurInscripTr.maJuridiction(driver, choixJur, env);
			Thread.sleep(1000);
			
			//Clic sur le lien 
			myXpath = "//a[@href and text()='Identifiant et/ou mot de passe oublié ?']";
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Clic sur le lien Identifiant et/ou mot de passe oublié ?......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Accès page de récupération des indentifiants
			myXpath = "//h1[text()='Récupérer ses identifiants de connexion']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Page de récupération de ses identifiants......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		default: System.err.println("Cette juridiction n'existe pas");
			break;
		}
		return null;
	}

	public static String recupIndentMdp (WebDriver driver, String choixJur, String mail) throws Throwable {
		switch (choixJur) {
		case "TACAA":
		   //Renseigner son mail
		   String myXpath = "//input[@id='Email']";
		   MesFonctions.objet(driver,  myXpath).sendKeys(mail);
			
		   //Captcha
		   myXpath = "//input[@id='InputCaptcha']";
		   System.out.println("Captcha présent; 15s pour le renseigner");
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
		   Thread.sleep(15000);
		   
		   //Valider
		   myXpath = "//button[@id='recovery-submit']";
		   MesFonctions.objet(driver,  myXpath).click();
		   System.out.println("Clic bouton Valider");
		   
		   //page de confirmation
		   myXpath = "//h2[text()=\" Votre demande de récupération d'identifiant et mot de passe Télérecours est prise en compte.\"]";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   System.out.println("Envoi confirmé");
		   
		   //Clic bouton "Retour"
		   myXpath = "//a[@class='btn btn-primary']";
		   MesFonctions.objet(driver,  myXpath).click();
		   System.out.println("Retour à la page d'authentification");
		   myXpath = "//h1[text()='Se connecter']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  
		   //Page mail
		   MicroFonctions.mailYopRecovery(driver, mail);
		   
		   //Récupération de ses codes
		   MicroFonctions.InscriptionRecovery(driver);
			
		   //Choix de la juridiction
		   MicroFonctions.choixJuridictionTA(driver);
		   Thread.sleep(1000);
			
		   name = "Paris";
		   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
		   verif = name.contains(MesFonctions.objet(driver,  myXpath).getText());
		   Thread.sleep(1500);
		   System.out.println(verif);
		   if (!verif) {
				System.err.println("la redirection n\'a pas bien fonctionné");
			}
		   Thread.sleep(3000);
			
		   break;
			
		case "Conseil":
			//Renseigner son mail
			myXpath = "//input[@id='Email']";
			MesFonctions.objet(driver,  myXpath).sendKeys(mail);
			
			//Captcha
		   myXpath = "//input[@id='InputCaptcha']";
		   System.out.println("Captcha présent; 15s pour le renseigner");
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
		   Thread.sleep(15000);
		   
		   //Valider
		   myXpath = "//button[@id='recovery-submit']";
		   MesFonctions.objet(driver,  myXpath).click();
		   System.out.println("Clic bouton Valider");
		   
		   //page de confirmation
		   myXpath = "//h2[text()=\" Votre demande de récupération d'identifiant et mot de passe Télérecours est prise en compte.\"]";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   System.out.println("Envoi confirmé");
		   
		   //Page mail
		   MicroFonctions.mailYopRecovery(driver, mail);
		   
		   //Récupération de ses codes
		   MicroFonctions.InscriptionRecovery(driver);
			
		   name = "Télérecours - Conseil d'Etat";
		   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
		   verif = name.equals(MesFonctions.objet(driver,  myXpath).getText());
		   Thread.sleep(1500);
		   System.out.println(verif);
		   if (!verif) {
				System.err.println("la redirection n\'a pas bien fonctionné");
			}else {
				System.out.println("la redirection a bien fonctionné");
			}
			Thread.sleep(3000);
			
		   break;
		default: System.err.println("Désolé, cette juridiction n'existe pas");
		break;
	}
	
	return null;
	}
		   
   	public static String recupIndentLienInvalideMdp (WebDriver driver, WebElement element, String choixJur, String mail) throws Throwable {
		switch (choixJur) {
		case "TACAA":
		   
		   //Page mail
		   int email = MicroFonctions.mailYopRecovery(driver, mail);
		   
		   //Changer de window
		   driver.close();
		   int window = 1;
		   driver.switchTo().window(MesFonctions.getWindow(driver, window));
		   
		   //Recommencer
		   myXpath = "//a[@class='alert-link' and text()=\"Recommencer\"]";
		   MesFonctions.objet(driver,  myXpath).click();

		   //Renseigner son mail
		   myXpath = "//input[@id='Email']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   System.out.println("Retour sur la page de récupération de ses identifiants");
		   MesFonctions.objet(driver,  myXpath).sendKeys(mail);
			
		   //Captcha
		   myXpath = "//input[@id='InputCaptcha']";
		   System.out.println("Captcha présent; 15s pour le renseigner");
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
		   Thread.sleep(15000);
		   
		   //Valider
		   myXpath = "//button[@id='recovery-submit']";
		   MesFonctions.objet(driver,  myXpath).click();
		   System.out.println("Clic bouton Valider");
		   
		   //Clic bouton "Retour"
		   myXpath = "//a[@class='btn btn-primary']";
		   MesFonctions.objet(driver,  myXpath).click();
		   System.out.println("Retour à la page d'authentification");
		   myXpath = "//h1[text()='Se connecter']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  
		   //Page mail
		   MicroFonctions.recoveryII(driver, mail, email);
		   
		   //Récupération de ses codes
		   MicroFonctions.InscriptionRecovery(driver);
			
		   //Choix de la juridiction
		   MicroFonctions.choixJuridictionTA(driver);
		   Thread.sleep(100);
			
		   name = "TA";
		   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
		   verif = (MesFonctions.objet(driver,  myXpath).getText()).contains(name);
		   Thread.sleep(1500);
		   System.out.println(verif);
		   if (!verif) {
				System.err.println("la redirection n\'a pas bien fonctionné");
			}
		   Thread.sleep(3000);
				
		break;
				
		case "Conseil":
			
		   //Page mail
		   MicroFonctions.mailYopRecovery(driver, mail);
		   
		   //Changer de window
		   driver.close();
		   window = 1;
		   driver.switchTo().window(MesFonctions.getWindow(driver, window));
		   
		   //Recommencer
		   myXpath = "//a[@class='alert-link' and text()=\"Recommencer\"]";
		   MesFonctions.objet(driver,  myXpath).click();
		   
		   //Captcha
		   myXpath = "//input[@id='InputCaptcha']";
		   System.out.println("Captcha présent; 15s pour le renseigner");
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
		   Thread.sleep(15000);
		   
		   //Valider
		   myXpath = "//button[@id='recovery-submit']";
		   MesFonctions.objet(driver,  myXpath).click();
		   System.out.println("Clic bouton Valider");
		   
		   //Clic bouton "Retour"
		   myXpath = "//a[@class='btn btn-primary']";
		   MesFonctions.objet(driver,  myXpath).click();
		   System.out.println("Retour à la page d'authentification");
		   myXpath = "//h1[text()='Se connecter']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   
		   //Page mail
		   MicroFonctions.mailYopRecovery(driver, mail);
		   
		   //Récupération de ses codes
		   MicroFonctions.InscriptionRecovery(driver);
			
		   name = "Télérecours - Conseil d'Etat";
		   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
		   verif = name.equals(MesFonctions.objet(driver,  myXpath).getText());
		   Thread.sleep(1500);
		   System.out.println(verif);
		   if (!verif) {
				System.err.println("la redirection n\'a pas bien fonctionné");
			}else {
				System.out.println("la redirection a bien fonctionné");
			}
			Thread.sleep(3000);
			
		   break;

		default: System.err.println("Désolé, cette juridiction n'existe pas");
			break;
		}
		
		return null;
		
	}
}

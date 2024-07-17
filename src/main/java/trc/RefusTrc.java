package trc;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class RefusTrc {
	
	static String texte;
	static String identifiant;
	static String mdp;
	static String call;
	static String url;
	
	public static String reqRefusTrc(WebDriver driver, String choiJur, String numDos, String env) throws Throwable {
		switch (choiJur) {
		case "TA":
			
			//Vérification de l'envoi
			  String myXpath = "//span[contains(text(),\"nouvelle requête\")]";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   
			   //trouver le numero de la requête
			   myXpath = "//jhi-numero-dossier//span";
//			   String numReqTrc = mesFonctions.leTexte(driver, texte, myXpath);
			   Thread.sleep(1000); 
//			   System.out.println(numReqTrc);
			   
//			   call = numReqTrc.replace("*", "");
			   
			   //Authentification TA
			   if(driver.getCurrentUrl().contains(env)) {
				   identifiant = "lb";
				   mdp = "lb";
				   url ="https://www.telerecours.recette.juradm.fr/TA75";
			   }
			   else {
				   identifiant = "sice";
				   mdp = "sice";
				   url ="https://www.telerecours.int1.juradm.fr/TA75";
			   }
				   
			   driver.get(url);
			   myXpath = "//input[@id='txtIdentifiant']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
			   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			   System.out.println("Connexion TA réussie"); 
			   
			   //Traiter la requête
			   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.verifyPresenceOfElement(driver, myXpath, choiJur);
			   System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
			   
			   myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			   MesFonctions.objet(driver,  myXpath).click(); 
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   System.out.println("Requête sélectionnée");
			   
			   //Refuser la Requête 
			   MicroFonctions.refusReqTr(driver);  
			   System.out.println("Dépôt refus réalisé");
			
			break;
			
		case "CAA":
			
			//Vérification de l'envoi
			  myXpath = "//span[contains(text(),\"nouvelle requête\")]";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   
			   //trouver le numero de la requête
			   myXpath = "//jhi-numero-dossier//span";
//			   numReqTrc = mesFonctions.leTexte(driver, texte, myXpath);
			   Thread.sleep(1000); 
//			   System.out.println(numReqTrc);
			   
//			   call = numReqTrc.replace("*", "");
			   
			   //Authentification CA
			   if(driver.getCurrentUrl().contains("recette")) {
				   identifiant = "lb";
				   mdp = "lb";
				   url ="https://www.telerecours.recette.juradm.fr/CA75";
			   }
			   else {
				   identifiant = "sice";
				   mdp = "sice";
				   url ="https://www.telerecours.recette.juradm.fr/CA75";
			   }
			   driver.get(url);
			   myXpath = "//input[@id='txtIdentifiant']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
			   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			   System.out.println("Connexion TA réussie"); 
			   
			   //Traiter la requête
			   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.verifyPresenceOfElement(driver, myXpath, choiJur);
			   System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
			   
			   myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			   MesFonctions.objet(driver,  myXpath).click(); 
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   System.out.println("Requête sélectionnée");
			   
			   //Refuser la Requête 
			   MicroFonctions.refusReqTr(driver);  
			   System.out.println("Dépôt refus réalisé");
			
			break;
			
		case "CTX":
			
			//Vérification de l'envoi
			  myXpath = "//span[contains(text(),\"nouvelle requête\")]";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   
			   //trouver le numero de la requête
			   myXpath = "//jhi-numero-dossier//span";
//			   numReqTrc = mesFonctions.leTexte(driver, texte, myXpath);
			   Thread.sleep(1000); 
//			   System.out.println(numReqTrc);
			   
//			   call = numReqTrc.replace("*", "");
			   
			   //Authentification CE
			   if(driver.getCurrentUrl().contains("recette")) {
				   identifiant = "fm";
				   mdp = "fm";
				   url ="https://www.telerecours.recette.conseil-etat.fr/conseil";
			   }
			   else {
				   identifiant = "sice";
				   mdp = "sice";
				   url ="https://www.telerecours.recette.conseil-etat.fr/conseil";
			   }
			   driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
			   myXpath = "//input[@id='txtIdentifiant']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
			   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			   System.out.println("Connexion TA réussie"); 
			   
			   //Traiter la requête
			   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.verifyPresenceOfElement(driver, myXpath, choiJur);
			   System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
			   
			   myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			   MesFonctions.objet(driver,  myXpath).click(); 
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   System.out.println("Requête sélectionnée");
			   
			   //Refuser la Requête 
			   MicroFonctions.refusReqTr(driver);  
			   System.out.println("Dépôt refus réalisé");
			   System.out.println(driver.getCurrentUrl()); 
			
			break;
			

		default: System.err.println("Pas de juridiction à ce nom");
			break;
		}
		
		return null;
	}
	
	public static String verification_Mail_Refus_Req_TRC(WebDriver driver, String mail, String env) throws Throwable {
		//Vérification des mail
		MesFonctions.addTab(driver);
		MesFonctions.transitWindow(driver, 2);
		MicroFonctions.mailRefusReq(driver, mail, env);
		
		return null;
	}

}

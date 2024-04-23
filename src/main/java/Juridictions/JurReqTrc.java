package Juridictions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import JDBC.JdbcClass;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;
import trc.Trc_depot_formulaire;

public class JurReqTrc {
	static WebElement element; 
	static String username;
	static String password;
	static boolean verif;
	static String myXpath;
	static String nom;
	static Select select;
	static String value;
	static String texte;
	static String numReqTrc; 
	static String identifiant;
	static String dossier;
	static String mdp;
	static String call;
	static String caractSpec;
	static String ChbrMatCatTA;
	static String ChbrMatCatCAA;
	static String ChbrMatCatCTX;
	static List<WebElement> elements;
	static List<String> str = new ArrayList<>();
	static List<String> str1 = new ArrayList<>();
	
	public static String firstSteps(WebDriver driver, String recours, String monUrl, String idUser) throws Throwable {
		//choix de l'environnement
		switch (monUrl) {
		case "int1": 
			String url = "https://citoyens.int1.telerecours.fr/";
			driver.get(url);
			Thread.sleep(1000);
			System.out.println("Accès page "+driver.getCurrentUrl()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			username = "zaire@yopmail.com";
			password = "Lhommeest2019*";
			
			break;
			
		case "rec": 
			url = "https://citoyens.recette.telerecours.fr/";
			driver.get(url);
			Thread.sleep(1000);
			System.out.println("Accès page "+driver.getCurrentUrl()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			username = "sorin@yopmail.com";
			password = "Lhommeest2019*";
			
			break;
			
		default: System.err.println("Pas d'environnement à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		//Authentification
		myXpath = "//input[@id='username']";
		
		if(MesFonctions.isElementPresent(driver, myXpath, verif)) 
		
		{
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
		MicroFonctions.AuthentificationTrc(driver, idUser, password);
//		Thread.sleep(2000);
		}
		
		else {
			System.err.println("Authentification déjà effectuée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
							  
		//Action et CGU
		MicroFonctions.conditionsGeneralesTrcSansBrouillon(driver);
		Thread.sleep(2000);
		System.out.println("CGU validées......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Déposer un recours
		MicroFonctions.lesTypesRecoursTrc(driver, recours, verif);
		System.out.println("Acteur(s) renseigné(s)......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Thread.sleep(1000);
		return null;
	}
	
	public static String reqDepotTrc (WebDriver driver, String jur, String form) throws Throwable {
		switch (form) {
		case "NoForm":
	
			switch (jur) {
			case "TA" :
				   //choix du niveau juridiction
				   MicroFonctions.juridictionTATRC(driver);
				   
				   //Choix urgence 
				   MicroFonctions.choixUrgenceTATRC(driver);
				   
				   //dépôt fichiers (1 REQ, 1 DECACT, 4PC ou 97PC <= 99)
				   MicroFonctions.depotFilesReqTrc(driver);//depotFilesReqTrc_99Pieces ou depotFilesReqTrc
				   System.out.println("Dépôt de fichiers réalisé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   Thread.sleep(1000);
				   
				   //Récapitulation de l'envoi
				   MicroFonctions.recapitulatifTRC(driver);
				   
				   //Envoyer
				   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
				   MesFonctions.objet(driver,  myXpath).click();
				   Thread.sleep(2500);
				   System.out.println("Envoi réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   
				  
				break;
				
			case "CAA" :
				   //choix du niveau juridiction
				   MicroFonctions.juridictionCAATRC(driver);
				   
				   //Choix urgence 
				   MicroFonctions.choixUrgenceCAATRC(driver);
				   
				   //dépôt fichiers (1 REQ, 1 DECACT, 4PC ou 97PC <= 99)
				   MicroFonctions.depotFilesReqTrc(driver);//depotFilesReqTrc_99Pieces ou depotFilesReqTrc
				   System.out.println("Dépôt de fichiers réalisé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   Thread.sleep(1000);
				   
				   //Récapitulation de l'envoi
				   MicroFonctions.recapitulatifTRC(driver);
				   
				   //Envoyer
				   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
				   MesFonctions.objet(driver,  myXpath).click();
				   Thread.sleep(2500);
				   System.out.println("Envoi réussi......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   
				  
				break;
				
			case "CTX" :
				   //choix du niveau juridiction
				   MicroFonctions.juridictionCTXTRC(driver);
				   
				   //choix du type de requête
				   MicroFonctions.choixUrgenceCTXTRC(driver);
				   
				   //dépôt fichiers (1 REQ, 1 DECACT, 4PC ou 97PC <= 99)
				   MicroFonctions.depotFilesReqTrc(driver);//depotFilesReqTrc_99Pieces ou depotFilesReqTrc
				   System.out.println("Dépôt de fichiers réalisé......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   Thread.sleep(1000);
				   
				   //Récapitulation de l'envoi
				   MicroFonctions.recapitulatifTRC(driver);
				   
				   //Envoyer
				   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
				   MesFonctions.objet(driver,  myXpath).click();
				   Thread.sleep(2500);
				   System.out.println("Envoi réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   
				  
				break;
				
			default: System.err.println("ERROR");
				break;
			}
			
			break;
		
		case "Form":
		
		switch (jur) {
		case "TA" :
			
			//choix du niveau juridiction
			   myXpath = "//label[@for='radio-TA' and(contains(text(),\"Tribunal administratif\"))]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(1000);
			   System.out.println("Choix de juridition : TA");
			   
			   //choix de la juridiction
			   myXpath = "//select[@id='site-juridiction-id']";
			   value = "1";
			   MesFonctions.selection(driver, myXpath, value);
			   Thread.sleep(1500);
			   System.out.println("TA PARIS");
			   
			   myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   
			   //choix du type de requête
			   myXpath = "//select[@id='urgence-requete-id']";
			   value = "1";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.selection(driver, myXpath, value);
			   System.out.println("Une procédure normale......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   Thread.sleep(1000);
			   
			   //Votre requête concerne-t-elle un contentieux social ? 
			   Trc_depot_formulaire.Trc_formulaire_2_requete_DALO(driver);
			   		
			   //Valider (suivant)
   			   myXpath = "//div[contains(@class,\"alert alert-danger\")]";
			   List<WebElement> elements = MesFonctions.objets(driver, myXpath);
			   int nbr = elements.size();
			   if(nbr<2) {
				  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
				  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				  MesFonctions.objet(driver,  myXpath).click();
				  Thread.sleep(1000);
			   }else {
				   System.out.println("Des alertes sont présentes : \r");
				   for(int i=0;i<nbr;i++) {
					  System.err.println(elements.get(i).getText().trim()+"\r");
				   }
			   }
			   
			   //dépôt fichiers (1 REQ, 1 DECACT, 4PC ou 97PC <= 99)
			   MicroFonctions.depotFilesReqTrc(driver);//depotFilesReqTrc_99Pieces ou depotFilesReqTrc
			   System.out.println("Dépôt de fichiers réalisé......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   Thread.sleep(1000);
			   
			   //Récapitulation de l'envoi
			   MicroFonctions.recapitulatifTRC(driver);
			   
			   //Envoyer
			   
			   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2500);
			   System.out.println("Envoi réussi....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			  
			break;
			
		case "CAA" :
			   //choix du niveau juridiction
			   myXpath = "//label[@for='radio-CAA' and(contains(text(),\"Cour administrative\"))]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(1000);
			   System.out.println("Choix de juridition : CA");
			   
			   //choix de la juridiction
			   myXpath = "//select[@id='site-juridiction-id']";
			   value = "5";
			   MesFonctions.selection(driver, myXpath, value);
			   Thread.sleep(1500);
			   System.out.println("CA PARIS");
			   
			   //choix du type d'acte attaqué
			   myXpath = "//select[@id='type-acte-attaque-id']";
			   value = "AUTRES";
			   MesFonctions.selection(driver, myXpath, value);
			   System.out.println("Acte attaqué : AUTRES");
			   Thread.sleep(1000);
			   
			   myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   
			   //choix du type de requête
			   myXpath = "//select[@id='urgence-requete-id']";
			   value = "7";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.selection(driver, myXpath, value);
			   System.out.println("Une procédure normale......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   Thread.sleep(1000);
			   
				//Votre requête concerne-t-elle un contentieux social ? 
		   		Trc_depot_formulaire.Trc_formulaire_2_requete_DALO(driver);
		   		
			   //Valider (suivant)
				   myXpath = "//div[contains(@class,\"alert alert-danger\")]";
			   elements = MesFonctions.objets(driver, myXpath);
			   nbr = elements.size();
			   if(nbr<2) {
				  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
				  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				  MesFonctions.objet(driver,  myXpath).click();
				  Thread.sleep(1000);
			   }else {
				   System.out.println("Des alertes sont présentes : \r");
				   for(int i=0;i<nbr;i++) {
					  System.err.println(elements.get(i).getText().trim()+"\r");
				   }
			   }
			   
			   //dépôt fichiers (1 REQ, 1 DECACT, 4PC ou 97PC <= 99)
			   MicroFonctions.depotFilesReqTrc(driver);
			   System.out.println("Dépôt de fichiers réalisé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   Thread.sleep(1000);
			   
			   //Récapitulation de l'envoi
			   MicroFonctions.recapitulatifTRC(driver);
			   
			   //Envoyer
			   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2500);
			   System.out.println("Envoi réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			   break;
			   
		default:
			break;
		}
		
		break;
			
		case "Form1" :
			switch (jur) {
			case "TA":
				 myXpath = "//label[@for='radio-TA' and(contains(text(),\"Tribunal administratif\"))]";
				   MesFonctions.objet(driver,  myXpath).click();
				   Thread.sleep(1000);
				   System.out.println("Choix de juridition : TA");
				   
				   //choix de la juridiction
				   myXpath = "//select[@id='site-juridiction-id']";
				   value = "1";
				   MesFonctions.selection(driver, myXpath, value);
				   Thread.sleep(1500);
				   System.out.println("Tribunal administratif de "+MesFonctions.objet(driver, "//option[@value='"+value+"']").getText().trim());
				   
				   myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
				   MesFonctions.objet(driver,  myXpath).click();
				   
				   //choix du type de requête
				   myXpath = "//select[@id='urgence-requete-id']";
				   value = "1";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.selection(driver, myXpath, value);
				   System.out.println("Une procédure normale......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   Thread.sleep(1000);
				   
				 //Votre requête concerne-t-elle un contentieux social ? 
			   	   myXpath = "//input[@id='csr-non']";
			   	   MesFonctions.objet(driver, myXpath).click();
			   	   System.out.println("La requête ne concerne pas un contentieux social......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   
//				   Trc_depot_formulaire.Trc_formulaire_3_decision_administration(driver);
//				   Trc_depot_formulaire.Trc_formulaire_3_somme_argent(driver, "option1");
//				   Trc_depot_formulaire.Trc_formulaire_3_somme_argent(driver, "option2");
//				   Trc_depot_formulaire.Trc_formulaire_3_somme_argent(driver, "option3");
			   	   Trc_depot_formulaire.Trc_formulaire_3_requete_redige_sois_meme(driver);
				   
				   //Récapitulation de l'envoi
				   MicroFonctions.recapitulatifTRC(driver);
				   
				   //Envoyer
				   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.objet(driver,  myXpath).click();
//				   Thread.sleep(2500)
				   System.out.println("Envoi réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				break;
				
			case "CAA" :
				//choix du niveau juridiction
				   myXpath = "//label[@for='radio-CAA' and(contains(text(),\"Cour administrative\"))]";
				   MesFonctions.objet(driver,  myXpath).click();
				   Thread.sleep(1000);
				   System.out.println("Choix de juridition : CA");
				   
				   //choix de la juridiction
				   myXpath = "//select[@id='site-juridiction-id']";
				   value = "5";
				   MesFonctions.selection(driver, myXpath, value);
				   Thread.sleep(1500);
				   System.out.println("Cour administrative de "+MesFonctions.objet(driver, "//option[@value='"+value+"']").getText().trim());
				   
				   //choix du type d'acte attaqué
				   myXpath = "//select[@id='type-acte-attaque-id']";
				   value = "AUTRES";
				   MesFonctions.selection(driver, myXpath, value);
				   System.out.println("Acte attaqué : AUTRES");
				   Thread.sleep(1000);
				   
				   myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
				   MesFonctions.objet(driver,  myXpath).click();
				   
				   //choix du type de requête
				   myXpath = "//select[@id='urgence-requete-id']";
				   value = "7";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.selection(driver, myXpath, value);
				   System.out.println("Une procédure normale......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   Thread.sleep(1000);
				   
				  //Votre requête concerne-t-elle un contentieux social ? 
			   	   myXpath = "//input[@id='csr-non']";
			   	   MesFonctions.objet(driver,  myXpath).click();
			   	   System.out.println("La requête ne concerne pas un contentieux social......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   
				   Trc_depot_formulaire.Trc_formulaire_3_decision_administration(driver);
//				   Trc_depot_formulaire.Trc_formulaire_3_somme_argent(driver, "option1");
//				   Trc_depot_formulaire.Trc_formulaire_3_somme_argent(driver, "option2");
//				   Trc_depot_formulaire.Trc_formulaire_3_somme_argent(driver, "option3");
//			   	   Trc_depot_formulaire.Trc_formulaire_3_requete_redige_sois_meme(driver);
				   
				   //Récapitulation de l'envoi
				   MicroFonctions.recapitulatifTRC(driver);
				   
				   //Envoyer
				   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.objet(driver,  myXpath).click();
//				   Thread.sleep(2500);
				   System.out.println("Envoi réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				   break;
				   
			case "CTX":
				   //choix du niveau juridiction
				   myXpath = "//label[@for='radio-CE' and(contains(text(),\" Conseil d'État \"))]";
				   MesFonctions.objet(driver,  myXpath).click();
				   Thread.sleep(1000);
				   System.out.println("Choix de juridition : CE");
				   
				   myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.goToDown(driver, myXpath);
				   MesFonctions.objet(driver,  myXpath).click();
				   
				   //choix du type de requête
				   myXpath = "//select[@id='urgence-requete-id']";
				   value = "5";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.selection(driver, myXpath, value);
				   System.out.println("Une procédure normale......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   Thread.sleep(1000);
				   
				   Trc_depot_formulaire.Trc_formulaire_ctx_2_decision_administration(driver);
//				   Trc_depot_formulaire.Trc_formulaire_ctx_2_somme_argent(driver, "option2");
//				   Trc_depot_formulaire.Trc_formulaire_ctx_2_somme_argent(driver, "option3");
//				   Trc_depot_formulaire.Trc_formulaire_ctx_2_requete_redige_sois_meme(driver);
				   
				   //Récapitulation de l'envoi
				   MicroFonctions.recapitulatifTRC(driver);
				   
				   //Envoyer
				   myXpath = "//span[contains(@class,'label') and (contains(text(),\"Envoyer\"))]";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.objet(driver,  myXpath).click();
//				   Thread.sleep(2500);
				   System.out.println("Envoi réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				  
				break;
				   
			default:System.err.println("Ce formulaire n'existe pas...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				break;
			}
			break;
		}
		return null;
	}
	
	
	
	public static String reqEnrgTrc (WebDriver driver, String jur, String numDos) throws Throwable {
		switch (jur) {
		
		case "TA":
			
			   //Vérification de l'envoi
			   myXpath = "//span[contains(text(),\"nouvelle requête\")]";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   
			   //trouver le numero de la requête
//			   myXpath = "//jhi-numero-dossier//span";
//			   numReqTrc = mesFonctions.leTexte(driver, texte, myXpath);
			   Thread.sleep(1000); 
//	 		   System.out.println(numReqTrc);
	 		  
			   MicroFonctions.verifEnvoiTrc(driver);
			   
			   
			   myXpath = "//i//parent::button//parent::a/span";
			   str =  MesFonctions.nbrEtNomsObjetBrut(driver, myXpath);
			   Thread.sleep(1000);
			   driver.findElement(By.xpath("//span[text()=\"Déconnexion\"]")).click();
			   Thread.sleep(1000);
			   System.out.println(str+"\r");
			  
//			   call = numReqTrc.replace("*", "");
			   

				String TrUrl = "https://www.telerecours.recette.juradm.fr/TA75";
				String TrUrlInt = "https://www.telerecours.int1.juradm.fr/TA75"; 
				String currentUrl = "int1";
			   //Authentification TA
						
				boolean verif = driver.getCurrentUrl().contains(currentUrl);
				if(verif) {
					driver.get(TrUrlInt);
					identifiant = "sice";
					mdp = "sice";
					myXpath = "//input[@id='txtIdentifiant']";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				   System.out.println("Connexion TA réussie......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}else {
					driver.get(TrUrl);
					identifiant = "lb";
					mdp = "lb";
				   myXpath = "//input[@id='txtIdentifiant']";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				   System.out.println("Connexion TA réussie......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
					
			   //Traiter la requête
			   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.verifyPresenceOfElement(driver, myXpath, jur);
			   System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
			   
			   myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			   MesFonctions.objet(driver,  myXpath).click(); 
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   System.out.println("Onglet \"Requêtes\" sélectionné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			   myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
			   String auteur = MesFonctions.leTexte(driver, texte, myXpath);
			   System.out.println("Auteur du dépôt : "+auteur+"\r");
			   Thread.sleep(1000);
			   
			   //Vérification des fichiers
			   System.out.println("vérification des fichiers en cours...");
			   myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
			   caractSpec = "_";
			   String actAtt = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(actAtt);
			   Thread.sleep(1000);
			   
			   myXpath = "//a[contains(@id,'rptPiecesJointe_ct')]";
			   elements = driver.findElements(By.xpath(myXpath)); 
			   
			   int taille = elements.size();
			   for(int i = 1; i <=taille; i++) {
				   if(i<9) {
			   myXpath = "//a[contains(@id,'rptPiecesJointe_ctl0"+i+"')]";
				   }else {
					   myXpath = "//a[contains(@id,'rptPiecesJointe_ctl"+i+"')]";
				   }
			   caractSpec = "_";
			   String file = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(file);
			   Thread.sleep(1000);
				}
			   
			   myXpath = "//a[@id='fileLinkFichierCourrier_hplFichier']";
			   String req = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(req);
			   Thread.sleep(1000);
			   
			   myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			   String invPcs = MesFonctions.leNom(driver, myXpath, caractSpec);
			   Thread.sleep(1000);
			   
			   str1.add(invPcs);
			   Thread.sleep(1000);
			   
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
			   else {
				   System.err.println("Les tableaux sont différents \rtableau actuel : "+str1+" \rtableau attendu :"+str+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
			   }
			   
			   //Choix de la chambre
			   ChbrMatCatTA = "chambre"; 
			   value = "11"; 
			   MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
			   Thread.sleep(1000);
			   System.out.println("Chambre renseignée");
			   
			   //Choix de la matiere
			   ChbrMatCatTA = "matiere"; 
			   value = "03"; 
			   MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
			   Thread.sleep(1000);
			   ChbrMatCatTA = "ssmatiere"; 
			   value = "0303"; 
			   MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
			   System.out.println("Matière et sous-matière renseignées");
			   Thread.sleep(1000);
			   
			   //Choix de la catégorie
			   ChbrMatCatTA = "categorie"; 
			   value = "CC"; 
			   MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
			   System.out.println("Catégorie renseignée");
			   Thread.sleep(1000);
			   
			   //Sauvegarder et enregistrement de la requête 
			   MicroFonctions.sauvReq(driver);
			   Thread.sleep(3000);
			   
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   
			   MicroFonctions.enrgReqFlech(driver);
			   Thread.sleep(3000);
			   
			   str1.clear();
			   str.clear();
			   
			   System.out.println("Dépôt et enregistrement TRC TA terminés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");  
			
			break;
			
		case "CAA" :
			
			 //Vérification de l'envoi
			   myXpath = "//span[contains(text(),\"nouvelle requête\")]";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   
			   //trouver le numero de la requête
//			   myXpath = "//jhi-numero-dossier//span";
//			   numReqTrc = mesFonctions.leTexte(driver, texte, myXpath);
			   Thread.sleep(1000); 
//	 		   System.out.println(numReqTrc);
	 		  
			   MicroFonctions.verifEnvoiTrc(driver);
			   
			   
			  myXpath = "//i//parent::button//parent::a/span";
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  str =  MesFonctions.nbrEtNomsObjetBrut(driver, myXpath);
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//span[text()=\"Déconnexion\"]")).click();
			  Thread.sleep(1000);
			  System.out.println(str+"\r");
			  
//			   call = numReqTrc.replace("*", "");
			  
			  
			   TrUrl = "https://www.telerecours.recette.juradm.fr/CA75";
			   TrUrlInt = "https://www.telerecours.int1.juradm.fr/CA75"; 
			   currentUrl = "int1";
			   //Authentification CAA
			   verif = driver.getCurrentUrl().contains(currentUrl);
				if(verif) {
					driver.get(TrUrlInt);
					identifiant = "sice";
					mdp = "sice";
					myXpath = "//input[@id='txtIdentifiant']";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				   System.out.println("Connexion CA réussie......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}else {
					driver.get(TrUrl);
					identifiant = "lb";
					mdp = "lb";
					myXpath = "//input[@id='txtIdentifiant']";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
				   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				   System.out.println("Connexion CA réussie......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
			   
			   //Traiter la requête 
			   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.verifyPresenceOfElement(driver, myXpath, jur);
			   System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
			   
			   myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			   MesFonctions.objet(driver,  myXpath).click();
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   System.out.println("Onglet \"Requête\" sélectionné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			   myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
			   auteur = MesFonctions.leTexte(driver, texte, myXpath);
			   System.out.println("Auteur du dépôt : "+auteur+"\r");
			   Thread.sleep(1000);
			   
			   //Vérification des fichiers
			   System.out.println("vérification des fichiers en cours......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
			   caractSpec = "_";
			   String actAtt1 = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(actAtt1);
			   Thread.sleep(1000);
			   
			   myXpath = "//a[contains(@id,'rptPiecesJointe_ct')]";
			   elements = driver.findElements(By.xpath(myXpath)); 
			   
			   int taille1 = elements.size();
			   for(int i = 1; i <=taille1; i++) {
				   if(i<9) {
			   myXpath = "//a[contains(@id,'rptPiecesJointe_ctl0"+i+"')]";
				   }else {
					   myXpath = "//a[contains(@id,'rptPiecesJointe_ctl"+i+"')]";
				   }
			   caractSpec = "_";
			   String file = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(file);
			   Thread.sleep(1000);
				}
			   
			   myXpath = "//a[@id='fileLinkFichierCourrier_hplFichier']";
			   String req1 = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(req1);
			   Thread.sleep(1000);
			   
			   myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			   String invPcs1 = MesFonctions.leNom(driver, myXpath, caractSpec);
			   Thread.sleep(1000);
			   
			   str1.add(invPcs1);
			   Thread.sleep(1000);
			   
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
			   else {
				   System.err.println("Les tableaux sont différents \rtableau actuel : "+str1+" \rtableau attendu :"+str+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			   }
			   
			   //Choix de la chambre
			   ChbrMatCatCAA = "chambre"; 
			   value = "1"; 
			   MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
			   System.out.println("Chambre renseignée");
			   Thread.sleep(1000);
			   
			   //Choix de la matiere
			   ChbrMatCatCAA = "matiere"; 
			   value = "06"; 
			   MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
			   Thread.sleep(1000);
			   ChbrMatCatCAA = "ssmatiere"; 
			   value = "06010402"; 
			   MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
			   System.out.println("Matière et sous-matière renseignées");
			   Thread.sleep(1000);
			   
			   //Choix de la catégorie
			   ChbrMatCatCAA = "categorie"; 
			   value = "REC"; 
			   MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
			   System.out.println("Catégorie renseignée");
			   Thread.sleep(1000);
			   
			   //Sauvegarder et enregistrement de la requête 
			   MicroFonctions.sauvReq(driver);
			   Thread.sleep(3000);
			   
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   
			   MicroFonctions.enrgReqFlech(driver);
			   Thread.sleep(3000);
			   
			   str1.clear();
			   str.clear();
			   
			   System.out.println("Dépôt et enregistrement TRC CA terminés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");  
			
			break;
			
		case "CTX" :
			
			  //Vérification de l'envoi
			   myXpath = "//span[contains(text(),\"nouvelle requête\")]";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   
			   //trouver le numero de la requête
//			   myXpath = "//jhi-numero-dossier//span";
//			   numReqTrc = mesFonctions.leTexte(driver, texte, myXpath);
//			   Thread.sleep(1000); 
//	 		   System.out.println(numReqTrc);
	 		  
			   MicroFonctions.verifEnvoiTrc(driver);
			   
			   
			  myXpath = "//i//parent::button//parent::a/span";
			  str =  MesFonctions.nbrEtNomsObjetBrut(driver, myXpath);
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//span[text()=\"Déconnexion\"]")).click();
			  Thread.sleep(1000);
			  System.out.println(str);
			  
//			   call = "21476";//numReqTrc.replace("*", "");
			   
			   	TrUrl = "https://www.telerecours.recette.conseil-etat.fr/conseil";
				TrUrlInt = "https://www.telerecours.int1.conseil-etat.fr/conseil"; 
				currentUrl = "int1";
			   //Authentification CE
				verif = driver.getCurrentUrl().contains(currentUrl);
				if(verif) {
					driver.get(TrUrlInt);
					 myXpath = "//input[@id='txtIdentifiant']";
					 identifiant = "sice";
					   mdp = "sice";
					   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
					   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
					   System.out.println("Connexion CE réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}else {
					driver.get(TrUrl);
					identifiant = "fm";
					   mdp = "fm";
					 myXpath = "//input[@id='txtIdentifiant']";
					   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
					   MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
					   System.out.println("Connexion CE réussie......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
			  
			   
			   //Traiter la requête
			   myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.verifyPresenceOfElement(driver, myXpath, jur);
			   System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
			   
			   myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			   MesFonctions.objet(driver,  myXpath).click();
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   System.out.println("Onglet \"Requête\" sélectionné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			   myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
			   auteur = MesFonctions.leTexte(driver, texte, myXpath);
			   System.out.println("Auteur du dépôt : "+auteur+"\r");
			   Thread.sleep(1000);
			   
			   //Vérification des fichiers
			   System.out.println("vérification des fichiers en cours...");
			   myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
			   caractSpec = "_";
			   String actAtt2 = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(actAtt2);
			   Thread.sleep(1000);
			   
			   myXpath = "//a[contains(@id,'rptPiecesJointe_ct')]";
			   elements = driver.findElements(By.xpath(myXpath)); 
			   
			   int taille2 = elements.size();
			   for(int i = 1; i <=taille2; i++) {
				   if(i<9) {
			   myXpath = "//a[contains(@id,'rptPiecesJointe_ctl0"+i+"')]";
				   }else {
					   myXpath = "//a[contains(@id,'rptPiecesJointe_ctl"+i+"')]";
				   }
			   caractSpec = "_";
			   String file = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(file);
			   Thread.sleep(1000);
				}
			   
			   myXpath = "//a[@id='fileLinkFichierRequete_hplFichier']";
			   String req2 = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
			   str1.add(req2);
			   Thread.sleep(1000);
			   
			   myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			   String invPcs2 = MesFonctions.leNom(driver, myXpath, caractSpec);
			   Thread.sleep(1000);
			   
			   str1.add(invPcs2);
			   Thread.sleep(1000);
			   
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
			   else {
				   System.err.println("Les tableaux sont différents \rtableau actuel : "+str1+" \rtableau attendu :"+str+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
			   
			   //Choix de la chambre
			   ChbrMatCatCTX = "chambre"; 
			   value = "1"; 
			   MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
			   System.out.println("Chambre renseignée");
			   Thread.sleep(1000);
			   
			   //Choix de la matiere
			   ChbrMatCatCTX = "matiere"; 
			   value = "27"; 
			   MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
			   Thread.sleep(1000);
			   ChbrMatCatCTX= "ssmatiere"; 
			   value = "2701"; 
			   MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
			   System.out.println("Matière et sous-matière renseignées");
			   Thread.sleep(1000);
			   
			   //Choix de la catégorie
			   ChbrMatCatCTX = "categorie"; 
			   value = "CRS"; 
			   MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
			   System.out.println("Catégorie renseignée");
			   Thread.sleep(1000);
			   
			   //Sauvegarder et enregistrement de la requête 
			   MicroFonctions.sauvReq(driver);
			   Thread.sleep(3000);
			   
			   myXpath = "//a[@class='numDossier' and (text()='" + numDos +" (TRC)')]";
			   MesFonctions.objet(driver,  myXpath).click();
			   Thread.sleep(2000);
			   
			   MicroFonctions.enrgReqFlech(driver);
			   Thread.sleep(3000);
			   
			   str1.clear();
			   str.clear();
			   
			   System.out.println("Dépôt et enregistrement TRC CE terminés");  
			
			
			break;

		default:System.err.println("Cette juridiction n'est pas reconnue....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		return null;
	}
	
	public static String Verification_Req_Async_DB(String env, String jur, String mail) throws Throwable {
		switch (env) {
		case "rec":
			
				switch (jur) {
				case "TA":
					String id = "tr2_ta75";
					String mdp = "tr2_ta75";
					
					JdbcClass.conDBTR(id, mdp, env);
					JdbcClass.conDBTRC(env);
					
					dossier = JdbcClass.verification_etat_req_TRC_Async(mail);
					
					break;
					
				case "CAA":
					id = "tr2_caa75";
					mdp = "tr2_caa75";
					
					JdbcClass.conDBTR(id, mdp, env);
					JdbcClass.conDBTRC(env);
					
					dossier = JdbcClass.verification_etat_req_TRC_Async(mail);
					
					break;
					
				case "CTX":
					id = "telerecours";
					mdp = "telerecours";
					
					JdbcClass.conDBTR(id, mdp, env);
					JdbcClass.conDBTRC(env);
					
					dossier = JdbcClass.verification_etat_req_TRC_Async(mail);
					
					break;

				default:System.out.println("Cette juridiction n'est pas reconnue....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					break;
				}
			
			break;
			
		case "int1":
			
				switch (jur) {
				case "TA":
					String id = "tr2_ta69";
					String mdp = "tr2_ta69";
					
					JdbcClass.conDBTR(id, mdp, env);
					JdbcClass.conDBTRC(env);
					
					dossier = JdbcClass.verification_etat_req_TRC_Async(mail);
					
					break;
					
				case "CAA":
					id = "tr2_caa69";
					mdp = "tr2_caa69";
					
					JdbcClass.conDBTR(id, mdp, env);
					JdbcClass.conDBTRC(env);
					
					dossier = JdbcClass.verification_etat_req_TRC_Async(mail);
					
					break;
					
				case "CTX":
					id = "telerecours";
					mdp = "telerecours";
					
					JdbcClass.conDBTR(id, mdp, env);
					JdbcClass.conDBTRC(env);
					
					dossier = JdbcClass.verification_etat_req_TRC_Async(mail);
					
					break;
	
				default:System.out.println("Cette juridiction n'est pas reconnue....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					break;
				}
			
			break;

		default:System.err.println("Cet environnement n'est pas reconnu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		return dossier;
	}
	
	
	public static String verification_Mail_Depot_Req_TRC(WebDriver driver, String mail, String env) throws Throwable {
		//Vérification des mail
		MesFonctions.addTab(driver);
		MesFonctions.transitWindow(driver, 2);
		MicroFonctions.mailDepotReq(driver, mail, env);
		
		return null;
	}
	
	
	public static String verification_Mail_Enreg_Req_TRC(WebDriver driver, String mail, String env) throws Throwable {
		//Vérification des mail
		MesFonctions.addTab(driver);
 		MesFonctions.transitWindow(driver, 2);
 		MicroFonctions.mailEnregReq(driver, mail, env);
		
		return null;
	}
	

}

package trcFonctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import JDBC.JdbcClass;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class CreationCompteTrc {
	
	static String date;
	static String name;
	static String prenom;
	static String value;
	static String mail;
	static String onglet;
	static String password;
	static String env;
	
	 public static String inscriptionTypeTrc(WebDriver driver, String type, String compagnie) throws Throwable {
		 date = "16/05/1993";
		 name = "HOURMA";
		 prenom = "Sylviane";
		 value = "Madame";
		 password = "Lhommeest2019*";
		 
		 //Inscription compte particulier
		 
//			mesFonctions.objet(driver, myXpath).click();
		 
			switch (type) {
			case "Particulier":
				String myXpath = "//button[@class='btn big-outline-button' and text()=\"Compte particulier\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath);
				//Accès page d'inscription
				MesFonctions.objet(driver, myXpath).click();
				System.out.println("Accès formulaire d'inscription particulier....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				myXpath = "//legend[text()=\"Informations personnelles\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				
				//Saisie des différents champs
				myXpath = "//select[@id='civilite']";
				MesFonctions.selection(driver, myXpath, value);
				System.out.println("Civilité Ok");
				
					//Birthday
				myXpath = "//input[@id='birthDate']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).sendKeys(date);
				System.out.println("Date de naissance Ok");
				
					//Firstname
				myXpath = "//input[@id='firstName']";
				MesFonctions.objet(driver, myXpath).sendKeys(prenom);
				System.out.println("Prénom Ok");
				
					//Lastname
				myXpath = "//input[@id='lastName']";
				MesFonctions.objet(driver, myXpath).sendKeys(name);
				System.out.println("Nom Ok");
				
					//Mail
				myXpath = "//input[@id='email']";
				mail = name.toLowerCase()+"@yopmail.com";
				MesFonctions.objet(driver, myXpath).sendKeys(mail);
				System.out.println("Email Ok");
				
					//Confirmation mail
				myXpath = "//input[@id='confirmationEmail']";
				MesFonctions.objet(driver, myXpath).sendKeys(mail);
				System.out.println("Confirmation email Ok");
				
					//Mdp
				myXpath = "//input[@id='password']";
				MesFonctions.objet(driver, myXpath).sendKeys(password);
				System.out.println("Mot de passe Ok");
				
					//Confirmation mdp
				myXpath ="//input[@id='confirmPwd']";
				MesFonctions.objet(driver, myXpath).sendKeys(password);
				System.out.println("Confirmation du mot de passe Ok");
				
					//Adresse
				myXpath = "//input[@id='adresse1']"; 
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
				MesFonctions.objet(driver, myXpath).sendKeys("2, rue des Indes");
				
					//Adresse 1
				myXpath = "//input[@id='adresse2']"; 
				MesFonctions.objet(driver,  myXpath).sendKeys("BAT 2");
				System.out.println("Adresse Ok");
				
					//Adresse 2
				myXpath = "//input[@id='adresse3']"; 
				MesFonctions.objet(driver,  myXpath).sendKeys("Porte 136");
				System.out.println("Adresse 1 Ok");
				
					//Code Postal
				myXpath = "//input[@id='codePostal']";
				MesFonctions.objet(driver,  myXpath).sendKeys("29100");
				System.out.println("Adresse 2 Ok");
				
					//Ville
				myXpath = "//input[@id='ville']";
				MesFonctions.objet(driver,  myXpath).sendKeys("Poullan-sur-Mer");
				System.out.println("Ville Ok");
				
				//Captcha
			    String myXpath10 = "//input[@id='captcha-input']";
			   	System.out.println("Captcha présent; 15s pour le renseigner");
			    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath10));
			    Thread.sleep(15000);
			    
			    //Création compte
			    myXpath = "//span[text()=\"Créer mon compte\"]";
			    MesFonctions.objet(driver, myXpath).click();
			    System.out.println("Click bouton créaton......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    //Succès création
//			    myXpath = "//button//span[contains(@class,'label') and text()=\"Créer mon compte\"]";
//		
//			    mesFonctions.objet(driver, myXpath).click();

			    System.out.println("La création est réussie......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    
			    break;
			    
			case "ParticulierDefaut":
				//Accès page d'inscription
				myXpath = "//button[@class='btn big-outline-button' and text()=\"Compte particulier\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath);
				MesFonctions.objet(driver, myXpath).click();
				System.out.println("Accès formulaire d'inscription particulier......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				myXpath = "//legend[text()=\"Informations personnelles\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				
				//verification de la présence d'alerte
				myXpath = "//button//span[@class='label' and text()=\"Créer mon compte\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
				MesFonctions.objet(driver, myXpath).click();
				
			    myXpath = "//div[@aria-hidden='false']//div[@role='alert']//span";
			    List<WebElement> elts = driver.findElements(By.xpath(myXpath));
			    int nbr = elts.size();
			    
			    System.err.println("Nombre d'alertes présentes : "+nbr+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    int tr = 0;
			    
			    while(nbr>1) {
		    	//Itération
			    	System.out.println("Itération : "+tr+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    	Thread.sleep(1000);
			    	
				//Saisie des différents champs
			    	//Civilité
				myXpath = "//select[@id='civilite']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//				mesFonctions.goToUp(driver, myXpath);
				MesFonctions.selection(driver, myXpath, value);
				System.out.println("Civilité Ok");
				
					//Birthday
				if(tr>0) {
					System.out.println("Date de naissance OK");
				}else {
					myXpath = "//input[@id='birthDate']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					MesFonctions.objet(driver, myXpath).sendKeys(date);
					System.out.println("Date de naissance OK");
					}
				
					//Firstname
				if(tr<1) {
					myXpath = "//input[@id='firstName']";
					System.err.println("Prénom KO");
					}else {
						myXpath = "//input[@id='firstName']";
						MesFonctions.objet(driver, myXpath).sendKeys(prenom);
						System.out.println("Prénom OK");
					}
				
					//Lastname
				myXpath = "//input[@id='lastName']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys(name);
				System.out.println("Nom Ok");
				
					//Mail
				myXpath = "//input[@id='email']";
				mail = name.toLowerCase()+"@yopmail.com";
				if(tr<2) {
					String email = "daniel@yopmail.com";
					MesFonctions.objet(driver,  myXpath).clear();
					MesFonctions.objet(driver,  myXpath).sendKeys(email);
					System.err.println("Email : "+email);
				}else {
					MesFonctions.objet(driver,  myXpath).clear();
					MesFonctions.objet(driver,  myXpath).sendKeys(mail);
					System.out.println("Email Ok");
				}
				
					//Confirmation mail
				myXpath = "//input[@id='confirmationEmail']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys(mail);
				System.out.println("Confirmation email Ok");
				
					//Mdp
				myXpath = "//input[@id='password']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys(password);
				System.out.println("Mot de passe Ok");
				
					//Confirmation mdp
				myXpath ="//input[@id='confirmPwd']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys(password);
				System.out.println("Confirmation du mot de passe Ok");
				
					//Adresse
				myXpath = "//input[@id='adresse1']"; 
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys("2, rue des Indes");
				
					//Adresse 1
				myXpath = "//input[@id='adresse2']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys("BAT 2");
				System.out.println("Adresse Ok");
				
					//Adresse 2
				myXpath = "//input[@id='adresse3']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys("Porte 136");
				System.out.println("Adresse 1 Ok");
				
					//Code Postal
				myXpath = "//input[@id='codePostal']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys("29100");
				System.out.println("Adresse 2 Ok");
				
					//Ville
				myXpath = "//input[@id='ville']";
				MesFonctions.objet(driver,  myXpath).clear();
				MesFonctions.objet(driver,  myXpath).sendKeys("Poullan-sur-Mer");
				System.out.println("Ville Ok");
				
				//Captcha
			    myXpath10 = "//input[@id='captcha-input']";
			   	System.out.println("Captcha présent; 15s pour le renseigner");
			    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath10));
			    Thread.sleep(15000);
			    
			    //Création compte
			    myXpath = "//span[text()=\"Créer mon compte\"]";
			    MesFonctions.objet(driver,  myXpath).click();
			    System.out.println("Click bouton créaton......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    //Succès création
//			    myXpath = "//button//span[contains(@class,'label') and text()=\"Créer mon compte\"]";
//			    mesFonctions.objet(driver,  myXpath).click();

			    System.out.println("La création est réussie......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    myXpath = "//div[@aria-hidden='false']//div[@role='alert']//span";
			    elts = driver.findElements(By.xpath(myXpath));
			    nbr = elts.size();
			    System.err.println("Nombre d'alertes présentes après validation : "+nbr+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    tr++;
			    Thread.sleep(1500);
			    }
			    
			    break;
			    
			case "Compagnie":
				//Accès page d'inscription
				myXpath = "//button[@class='btn big-outline-button' and text()=\"Compte personne morale\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath);
				MesFonctions.objet(driver,  myXpath).click();
				System.out.println("Accès formulaire d'inscription des personnes morales");
				myXpath = "//legend[text()=\"Identité de l'organisme\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				
				//Saisie des différents champs
				 	//Forme sociale
				myXpath = "//input[@id='nomEntreprise']";
				MesFonctions.objet(driver,  myXpath).sendKeys(compagnie+" SARL");		
				
					//Civilité
				myXpath = "//select[@id='civilite']";
				value = "Monsieur le président directeur";
				MesFonctions.selection(driver, myXpath, value);
				System.out.println("Civilité Ok");
				
					//Fonction
				myXpath = "//input[@id='fonctionEntreprise']";
				MesFonctions.objet(driver,  myXpath).sendKeys("Directeur");
				System.out.println("Fonction Ok");
				
					//Firstname
				myXpath = "//input[@id='firstName']";
				MesFonctions.objet(driver,  myXpath).sendKeys(prenom);
				System.out.println("Prénom Ok");
				
					//Lastname
				myXpath = "//input[@id='lastName']";
				MesFonctions.objet(driver,  myXpath).sendKeys(name);
				System.out.println("Nom Ok");
				
					//Mail
				myXpath = "//input[@id='email']";
				mail = name.toLowerCase()+"@yopmail.com";
				MesFonctions.objet(driver,  myXpath).sendKeys(mail);
				System.out.println("Email Ok");
				
					//Confirmation mail
				myXpath = "//input[@id='confirmationEmail']";
				MesFonctions.objet(driver,  myXpath).sendKeys(mail);
				System.out.println("Confirmation email Ok");
				
					//Mdp
				myXpath = "//input[@id='password']";
				MesFonctions.objet(driver,  myXpath).sendKeys(password);
				System.out.println("Mot de passe Ok");
				
					//Confirmation mdp
				myXpath ="//input[@id='confirmPwd']";
				MesFonctions.objet(driver,  myXpath).sendKeys(password);
				System.out.println("Confirmation du mot de passe Ok");
				
					//Adresse
				myXpath = "//input[@id='adresse1']"; 
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
				MesFonctions.objet(driver,  myXpath).sendKeys("2, rue des Indes");
				
					//Adresse 1
				myXpath = "//input[@id='adresse2']"; 
				MesFonctions.objet(driver,  myXpath).sendKeys("BAT 2");
				System.out.println("Adresse Ok");
				
					//Adresse 2
				myXpath = "//input[@id='adresse3']"; 
				MesFonctions.objet(driver,  myXpath).sendKeys("Porte 136");
				System.out.println("Adresse 1 Ok");
				
					//Code Postal
				myXpath = "//input[@id='codePostal']";
				MesFonctions.objet(driver,  myXpath).sendKeys("29100");
				System.out.println("Adresse 2 Ok");
				
					//Ville
				myXpath = "//input[@id='ville']";
				MesFonctions.objet(driver,  myXpath).sendKeys("Poullan-sur-Mer");
				System.out.println("Ville Ok");
				
				//Captcha
			    myXpath10 = "//input[@id='captcha-input']";
			   	System.out.println("Captcha présent; 15s pour le renseigner");
			    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath10));
			    Thread.sleep(15000);
			    
			    //Création compte
			    myXpath = "//span[text()=\"Créer mon compte\"]";
			    MesFonctions.objet(driver,  myXpath).click();
			    System.out.println("Click bouton créaton......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    //Succès création
			    myXpath = "//button//span[@class='label' and text()=\"Créer mon compte\"]";
			    MesFonctions.objet(driver,  myXpath).click();

			    System.out.println("La création est réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
			    break;
			    
			default: System.err.println("Ce type n'existe pas....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				break;
			} 
			 
		 
		 return null;
	 }
	 
	 public static String activationCpt(WebDriver driver) throws Throwable {
		 //Accès MAilHog
//		 mail= "margot@yopmail.com";//juste pour le test sinon a commenter
		 MesFonctions.addTab(driver);
		 Thread.sleep(2000);
		 onglet =  MesFonctions.getWindow(driver, 2);
		 String url = driver.getCurrentUrl();
		 boolean verif = url.contains("int1");
		 if(!verif) {
			 driver.switchTo().window(onglet);
			 driver.get("https://mail.recette.conseil-etat.fr/"); 
		 }
		 else {
			 driver.switchTo().window(onglet);
			 driver.get("https://mail.int1.conseil-etat.fr/"); 
		 }
		 
		 String myXpath = "//a[@class='navbar-brand']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 
		 System.out.println("Accès MailHog......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Recherche du mail
		 myXpath = "//div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
		 verif = false;
		 while (MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
			 	
			 String myXpath0 = "//button[@title='Refresh']";
			 	MesFonctions.objet(driver,  myXpath0).click();
//				String myXpath1 = "//span[@class='pull-right']";
//				mesFonctions.objet(driver,  myXpath1).click();
			
		 }
		 
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Le mail est selectionné");
		 
		 myXpath = "//span[text()=\"Activez votre compte\"]";
		 driver.switchTo().frame("preview-html");
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();
//		 driver.switchTo().parentFrame();
		 System.out.println("le compte est activé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 if(!verif) {
			 driver.get("https://mail.recette.conseil-etat.fr/"); 
		 }
		 else {
			 driver.get("https://mail.int1.conseil-etat.fr/"); 
		 }
		 
		 onglet =  MesFonctions.getWindow(driver, 1);
		 driver.switchTo().window(onglet);
		 MicroFonctions.suppMailHog(driver, mail);
		 
		 
		 driver.close();
		 System.out.println("La fenêtre est fermée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 onglet =  MesFonctions.getWindow(driver, 2);
		 driver.switchTo().window(onglet);
		 System.out.println("changement de fenêtre......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 Thread.sleep(2000);
		 myXpath = "//h2[text()=\"Votre compte a été activé. \"]";
		 String myXpath1 = "//div[contains(@class,\"alert-danger\")]//span/strong";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
			 MesFonctions.objet(driver, myXpath).click();
		 }else {
			 throw new Exception (MesFonctions.objet(driver, myXpath1).getText().trim() +"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 }
		 
		 //Se connecter
		 myXpath = "//a[contains(text(),\"vous connecter\")]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Accès à la page d'authentification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 myXpath = "//input[@id='username']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("Page d'authentification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Authentification Trc
		 MicroFonctions.AuthentificationTrc(driver, mail, password);
		 

		 return null; 
	 }
	 
	 public static String modificationCompteTrc(WebDriver driver, String nom) throws Throwable {
		 
		 //Accéder à la page "Mon compte"
		 String myXpath = "//a//span[text()=\"Mon Compte\"]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();
		 
		 //Accès à mon compte
		 myXpath = "//h1[text()=\"Mon compte\"]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("Page Mon compte");
		 
		 //Modifications
		 	//Nom
		 myXpath = "//input[@id='lastName']";
		 name = nom;
		 MesFonctions.objet(driver,  myXpath).clear();
		 MesFonctions.objet(driver,  myXpath).sendKeys(name);
		 System.out.println("Nom Ok"); 
		 
			//Mail
		 myXpath = "//input[@id='email']";
		 MesFonctions.objet(driver,  myXpath).clear();
		 mail = name.toLowerCase()+"@yopmail.com";
		 MesFonctions.objet(driver,  myXpath).sendKeys(mail);
		 System.out.println("Email Ok");
			
			//Confirmation mail
		 myXpath = "//input[@id='confirmationEmail']";
		 MesFonctions.objet(driver,  myXpath).clear();
		 MesFonctions.objet(driver,  myXpath).sendKeys(mail);
		 System.out.println("Confirmation email Ok");
		 
//		 	//Old mdp
//		 myXpath = "//input[@id='oldPassword']";
//		 mesFonctions.objet(driver,  myXpath).clear();
//		 mesFonctions.objet(driver,  myXpath).sendKeys(password);
//		 System.out.println("Ancien mot de passe Ok");
//		 
//			//Mdp
//		 myXpath = "//input[@id='password']";
//		 mesFonctions.objet(driver,  myXpath).sendKeys(password);
//		 System.out.println("Mot de passe Ok");
//			
//			//Confirmation mdp
//		 myXpath ="//input[@id='confirmPwd']";
//		 mesFonctions.objet(driver,  myXpath).sendKeys(password);
//		 System.out.println("Confirmation du mot de passe Ok");
		 
		 //Enregistrement
		 myXpath = "//button[@type='submit']";
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Soumission du formulaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Confirmation
		 myXpath = "//button//span[contains(text(),\"Enregistrer quand même\")]";// Enregistrer quand même ; Confirmer
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();
		 
		 myXpath = "//button//span[contains(text(),'Confirmer')]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();
		 
		 myXpath = "//div[@role='alert']//span[contains(text(),\"Veuillez en choisir une autre.\")]";
		 boolean verif = false;
		 if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
			 throw new Exception(MesFonctions.objet(driver, myXpath).getText());
		 }
		 
//		 myXpath = "//button//span[contains(text()=\"Modifications enregistrées\")]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 //Confirmation du lien par email
		 onglet =  MesFonctions.getWindow(driver, 1);
		 driver.switchTo().window(onglet);
		 String url = driver.getCurrentUrl();
		 verif = url.contains("int1");
			 if(!verif) {
				 driver.get("https://mail.recette.conseil-etat.fr/");
				 System.out.println("URL sélectionnée : "+url);
				 System.out.println("Mail sélectionné : "+mail);
			 }
			 else {
				 driver.get("https://mail.int1.conseil-etat.fr/");
				 System.out.println("URL sélectionnée : "+url);
				 System.out.println("Mail sélectionné : "+mail);
			 }

		 myXpath = "//a[@class='navbar-brand']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 myXpath = "//div[@class='msglist-message row ng-scope']//child::span[text()=\"[Télérecours citoyens] Confirmez votre nouvelle adresse de messagerie\"]//parent::div//preceding-sibling::div[@class='col-md-3 col-sm-4 ng-binding']//child::div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
//		 String myXpath2 = "//span[text()=\"[Télérecours citoyens] Confirmez votre nouvelle adresse de messagerie\"]";
		 
		 verif = false;
		 boolean turn = false;
		 while (!turn) {
			 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			 	turn = true;
			 }else {
				 String myXpath0 = "//button[@title='Refresh']";
			 	MesFonctions.objet(driver,  myXpath0).click();
			 	System.out.println("click bouton refresh......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 	}
		 }
		 
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Le mail est selectionné......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 myXpath = "//span[text()=\"Confirmer mon adresse de messagerie électronique\"]";
		 driver.switchTo().frame("preview-html");
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();
//		 driver.switchTo().parentFrame();
		 System.out.println("le compte est activé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Se connecter
		 onglet =  MesFonctions.getWindow(driver, 2);
		 driver.switchTo().window(onglet);
		 driver.close();
		 System.out.println("Onglet fermé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 onglet =  MesFonctions.getWindow(driver, 2);
		 driver.switchTo().window(onglet);
		 myXpath = "//a[contains(text(),\"vous connecter\")]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Accès à la page d'authentification......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 myXpath = "//input[@id='username']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("Page d'authentification......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Authentification Trc
		 System.out.println(mail);
		 MicroFonctions.AuthentificationTrc(driver, mail, password);
		 MicroFonctions.deconnexionTrc(driver);
		 
		 return null; 
	 }
	 
	 public static String reinitialisationMdp(WebDriver driver) throws Throwable {
		 //Lien réinitialisation du mot de passe
		 String myXpath = "//a[contains(text(),\"passe\")]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 Thread.sleep(100);
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,  myXpath));
		 MesFonctions.objet(driver,  myXpath).click();
//		 mesFonctions.objet(driver,  myXpath).click();//pas de clic réalisé---à corriger
		 System.out.println("Click sur le lien mot de passe oublié......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //page de réinitialisatin
		 myXpath = "//input[@id='email']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 mail = name.toLowerCase()+"@yopmail.com";
		 MesFonctions.objet(driver,  myXpath).sendKeys(mail);
		 System.out.println("Email Ok......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Validation
		 myXpath = "//button//span[contains(text(),\"Réinitialiser le mot de passe\")]";
		 MesFonctions.objet(driver,  myXpath).click();
		 myXpath = "//div[@role='status']";//alert a été remplacé par 'statut
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 String att = "alert alert-success";
		 MesFonctions.verifyPresenceOfAttribute1(driver, myXpath, "class", att);
		 System.out.println("le mot de passe à bien été réinitialisé......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Retour page d'accueil
		 myXpath = "//a[contains(text(),\"Revenir à la page d'accueil\")]";
		 MesFonctions.objet(driver,  myXpath).click();
		 driver.close();
		 
		 //aller à la page MailHog
//		 mesFonctions.addTab(driver);
		 onglet = MesFonctions.getWindow(driver, 1);
		 driver.switchTo().window(onglet);
		 
		 String url = driver.getCurrentUrl();
		 boolean verif = url.contains("int1");
		 if(!verif) {
			 driver.get("https://mail.recette.conseil-etat.fr/"); 
		 }
		 else {
			 driver.get("https://mail.int1.conseil-etat.fr/"); 
		 }
		 myXpath = "//a[@class='navbar-brand']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 System.out.println("Accès MailHog......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Recherche du mail
		 myXpath = "//div[@class='msglist-message row ng-scope']//child::span[text()=\"[Télérecours citoyens] Réinitialisation de votre mot de passe Télérecours citoyens\"]"
		 		+ "//parent::div//preceding-sibling::div[@class='col-md-3 col-sm-4 ng-binding']//child::div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
		 @SuppressWarnings("unused")
		 int tr = 0;
		 verif = false;
		 while (MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
			
			 String myXpath0 = "//button[@title='Refresh']";
			 MesFonctions.objet(driver,  myXpath0).click();
			
			tr++;
		 }
		 
		 //Mail de réinitialisation
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Le mail est selectionné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 myXpath = "//span[text()=\"Configurer mon mot de passe\"]";
		 driver.switchTo().frame("preview-html");
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();;
		 
		 Thread.sleep(3000);
		 
		 //Page de réinitialisation
		 password = "Lhommeest2019**";
		 onglet = MesFonctions.getWindow(driver, 2);
		 driver.switchTo().window(onglet);
		 myXpath = "//input[@id='password']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(2));
		 MesFonctions.objet(driver,  myXpath).sendKeys(password);
		 myXpath = "//input[@id='confirmPwd']";
		 MesFonctions.objet(driver,  myXpath).sendKeys(password);
		 myXpath = "//button//span[contains(text(),'Réinitialiser')]";
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Mot de passe réinitialisé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 myXpath = "//a[contains(text(),\"vous connecter\")]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,  myXpath).click();
		 System.out.println("Connecté à la page d'accueil......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 
		 //Retour sur la page d'accueil
		 myXpath = "//input[@id='username']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("Retour à la page d'accueil......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 MicroFonctions.AuthentificationTrc(driver, mail, password);
		 MicroFonctions.deconnexionTrc(driver);
		 
		 //supprimer les données en base
		 if(driver.getCurrentUrl().contains("int")) {
			 env = "int1";
		 }else {
			 env = "rec"; 
		 }
		 System.out.println(name+"  "+mail);
		 JdbcClass.conDBTRC(env);
		 JdbcClass.deleteUserTrc(name, mail);
		 
		 //effacer les mails
		 onglet = MesFonctions.getWindow(driver, 1);
		 driver.switchTo().window(onglet);
		 url = driver.getCurrentUrl();
		 verif = url.contains("int1");
		 if(!verif) {
			 driver.get("https://mail.recette.conseil-etat.fr/"); 
		 }
		 else {
			 driver.get("https://mail.int1.conseil-etat.fr/"); 
		 }
		 MicroFonctions.suppMailHog(driver, mail);
		 
		 mail = "gradenait@yopmail.com";
		 MicroFonctions.suppMailHog(driver, mail);
		 driver.close();
		 onglet = MesFonctions.getWindow(driver, 1);
		 driver.switchTo().window(onglet);
		 
		 return null; 
	 }
	 
	 public static String delUser() throws Throwable {
		name = "Rouafa";
		mail = "hourma@yopmail.com";
		System.out.println(name+"  "+mail);
		JdbcClass.conDBTRC(env);
		JdbcClass.deleteUserTrc(name, mail);
		
		return null;
	 }
}

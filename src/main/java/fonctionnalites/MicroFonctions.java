package fonctionnalites;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import JDBC.JdbcClass;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;

	

public class MicroFonctions {

		public static String AuthentificationAdmin (WebDriver driver, String identifiant, String mdp) throws Throwable {
			driver.get("https://tr-admin.recette.telerecours.fr/");
			Thread.sleep(200);
			
			String myXpath = "//input[@id='UserName']";
			String myXpath1 = "//input[@id='Password']";
			String myXpath2 = "//input[@class='btn btn-green right']";
			
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(identifiant);
			MesFonctions.objet(driver, myXpath1).sendKeys(mdp);
			MesFonctions.objet(driver, myXpath2).click();
			return null;
		
	} 	
		public static String AuthentificationTaCaaCeExt (WebDriver driver, String identifiant, String mdp) throws Throwable {
			String myXpath1 = "//input[@id='Username']";
			String myXpath2 = "//input[@id='password-field']";
			String myXpath3 = "//button[@id='login-submit']";
			
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).clear();
			MesFonctions.objet(driver, myXpath1).sendKeys(identifiant);
			System.out.println("Insertion de l'identifiant : "+identifiant+"....."+MesFonctions.extractCurrentHeure());
			
			MesFonctions.objet(driver, myXpath2).clear();
			MesFonctions.objet(driver, myXpath2).sendKeys(mdp);
			System.out.println("Insertion du mot de passe : "+mdp+"......"+MesFonctions.extractCurrentHeure());
			
			MesFonctions.objet(driver, myXpath3).click();
			System.out.println("Validation des identifiants Username : "+identifiant+" mot de passe : "+mdp+"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
			return null;
	}	
		
		public static String AuthentificationTaCaaCeInt (WebDriver driver, String identifiant, String mdp) {
			String myXpath1 = "//input[@id='txtIdentifiant']";
			String myXpath2 = "//input[@id='txtPassword']";
			String myXpath3 = "//a[@id='ibOk']/span[@class='button-text' and (text()='Valider')]";
			
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).clear();
			MesFonctions.objet(driver, myXpath1).sendKeys(identifiant);
			System.out.println("Insertion de l'identifiant : "+identifiant+"....."+MesFonctions.extractCurrentHeure()+"\r");
			
			MesFonctions.objet(driver, myXpath2).clear();
			MesFonctions.objet(driver, myXpath2).sendKeys(mdp);
			System.out.println("Insertion du mot de passe : "+mdp+"......"+MesFonctions.extractCurrentHeure()+"\r");
			
			MesFonctions.objet(driver, myXpath3).click();
			System.out.println("Validation des identifiants Username : "+identifiant+" mot de passe : "+mdp+"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			
			//vérification de la page
			String myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println(MesFonctions.objet(driver, myXpath).getText().trim()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			return null;
	}
		public static String AuthentificationTrc (WebDriver driver, String username, String password) throws Throwable {
			//taper son adresse email
			String myXpath0 = "//input[@id='username']";
			MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath0).sendKeys(username);
			System.out.println("Insertion de l'identifiant : "+username+"....."+MesFonctions.extractCurrentHeure()+"\r");
			
			//taper son mot de passe
			String myXpath1 = "//input[@id='password']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath1).sendKeys(password);
			System.out.println("Insertion du mot de passe : "+password+"......"+MesFonctions.extractCurrentHeure()+"\r");
			
			//Soumettre
			String myXpath2 = "//button[@type='submit']";
			MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath2).click();
			System.out.println("Validation des identifiants Username : "+username+" mot de passe : "+password+"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			   
		  	   String myXpath = "//strong[contains(text(),\"générales d'utilisation\")]";
		  	   boolean verif = false;
			   if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				   //Acceptation des CGU
				   myXpath = "//input[@id='flexCheckDefault']";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.goToDown(driver, myXpath);
				   Thread.sleep(500);
				   MesFonctions.objet(driver, myXpath).click();
				   System.out.println("La coche a été cochée....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
				    
				   //Validation Status
				   myXpath = "//button//span[contains(text(),\"Accepter et accéder à mon compte\")]";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.goToDown(driver, myXpath);
				   Thread.sleep(500);
				   MesFonctions.objet(driver, myXpath).click();
				   System.out.println("Les CGU ont été validés....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r"); 	   
			   }
			 
			
			//Accès page d'accueil
			myXpath = "//h1[text()=\"Bienvenue sur Télérecours citoyens\"]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Validation des identifiants Username : "+username+" mot de passe : "+password+"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			
			return null;
			}
		
		public static void trcURl(WebDriver driver, String env) {
			switch (env) {
			case "int1":
				driver.get("https://citoyens.int1.telerecours.fr/#/authentication");
					System.out.println("Accès à l'URL TRC d'intégration......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
				break;
				
			case "rec":
				driver.get("https://citoyens.recette.telerecours.fr/#/authentication");
					System.out.println("Accès à l'URL TRC de recette......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
				
				break;

			default: System.err.println("Cet environnement n'est pas reconnu ....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
				break;
			} 
		}
		
		public static void bouton_requete_int(WebDriver driver, String jur) throws Throwable {
			 //Traiter la requête
			   String myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.verifyPresenceOfElement(driver, myXpath, jur);
			   System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
			   myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			   MesFonctions.objet(driver,  myXpath).click(); 
		}
		
		public static String accesLienPreferencesUtilisateur(WebDriver driver, String jur) {
			//Accès aux préférences utilisateurs
			if(jur=="TA"||jur=="CAA") {
				String myXpath = "//a[@id='lnkpref']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).click();
				System.out.println("Accès aux préférences utilisateur......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			}else {
				String myXpath = "//a[@id='Entete1_EnteteDonnee1_lnkpref']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).click();
				System.out.println("Accès aux préférences utilisateur......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			}
			
			//Atteindre la fenêtre des préférences
			MesFonctions.transitWindow(driver, 2);
			
			String myXpath = "//p[text()=\"Gérez vos préférences\"]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à la fenêtre ouverte......"+MesFonctions.extractCurrentHeure());
			return null;
		}
		
		public static String deconnexionTrc(WebDriver driver) {
			String myXpath = "//a[@class='nav-link logout']//span[text()=\"Déconnexion\"]";
			MesFonctions.objet(driver,myXpath).click();
			myXpath = "//input[@id='username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Déconnexion réussie......"+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			return null;
			
		}
		
	    public static String obtenirCodeTACAA (WebDriver driver, String code, String motdepasse) throws Throwable {
	    	String myXpath0 = "//a[@class='btn btn-outline-blue-ter ga-btn']";
	    	MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
	    	MesFonctions.objet(driver,myXpath0).click();
	    	Thread.sleep(2000);
	    	
	    	//Obtenir ses codes
	    	String myXpath1 = "//input[@id='RegistrationCode']";
	    	MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
	    	MesFonctions.objet(driver,myXpath1).sendKeys(code);
	    	
	    	//soumettre le code
	    	String myXpath2 = "//button[@id='registration-submit']";
	    	MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
	    	MesFonctions.objet(driver, myXpath2).click();
	    	Thread.sleep(200);
	    	String url = driver.getCurrentUrl();
	    	System.out.println(url);
	    	boolean verif = url.contains("https://www.telerecours.int1.juradm.fr/Inscription.aspx");
	    	boolean verif1 = url.contains("https://www.telerecours.recette.juradm.fr/Inscription.aspx");
	    	if(url.contains("int1") || url.contains("recette") && verif || verif1) {
	    		Thread.sleep(1000);
		    	System.out.println("La redirection a fonctionné = "+verif+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");	
	    	}else {
	    		System.err.println("La redirection n'a pas fonctionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	    	}
	    	
	    	//soumettre le mot de passe
	    	String myXpath4 = "//input[@id='ctl00_cphBody_txtPassword']";
	    	MesFonctions.objet(driver,myXpath4).sendKeys(motdepasse);
	    	
	    	//Valider
	    	String myXpath5 = "//input[@id='ctl00_cphBody_btnValider']";
	    	MesFonctions.objet(driver,myXpath5).click();
	    	Thread.sleep(1000);
	    	
	    	String myXpath6 = "//div[@class='erreurValidation']//span[@id='ctl00_cphBody_lblMsgErreur' and (text()=\"Le code d'accès saisi est invalide\")]";
	    	String myXpath7 = "//input[@id='ctl00_cphBody_btnAnnuler']";
	    	verif = false; 
	    	if (MesFonctions.isElementPresent(driver, myXpath6, verif) == true){
	    		MesFonctions.objet(driver,myXpath7).click();
	    	}
	    	return null;
	    }
	    
	    public static String obtenirCodeCE (WebDriver driver, String code, String motdepasse) throws Throwable {
	    	//Clic sur le bouton "Obtenir ses codes"
	    	String myXpath0 = "//a[@class='btn btn-outline-blue-ter ga-btn']";
	    	MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
	    	MesFonctions.objet(driver,myXpath0).click();
	    	Thread.sleep(2000);
	    	
	    	//Obtenir ses codes
	    	String myXpath1 = "//input[@id='RegistrationCode']";
	    	MesFonctions.objet(driver,myXpath1).sendKeys(code);
	    	
	    	//soumettre le code
	    	String myXpath2 = "//button[@id='registration-submit']";
	    	MesFonctions.objet(driver,myXpath2).click();
	    	Thread.sleep(2000);
	    	String url = driver.getCurrentUrl();
	    	System.out.println(url);
	    	boolean verif = url.contains("https://www.telerecours.int1.conseil-etat.fr/Inscription.aspx");
	    	boolean verif1 = url.contains("https://www.telerecours.recette.conseil-etat.fr/Inscription.aspx");
	    	if(url.contains("int1") || url.contains("recette") && verif || verif1) {
	    		Thread.sleep(1000);
		    	System.out.println("La redirection a fonctionné = "+verif+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");	
	    	}else {
	    		System.err.println("La redirection n'a pas fonctionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	    	}
	    	
	    	//soumettre le mot de passe
	    	String myXpath4 = "//input[@id='ctl00_cphBody_txtPassword']";
	    	MesFonctions.objet(driver,myXpath4).sendKeys(motdepasse);
	    	
	    	//Valider
	    	String myXpath5 = "//input[@id='ctl00_cphBody_btnValider']";
	    	MesFonctions.objet(driver,myXpath5).click();
	    	Thread.sleep(2000);
	    	
	    	String myXpath6 = "//div[@class='erreurValidation']//span[@id='ctl00_cphBody_lblMsgErreur' and (text()=\"Le code d'accès saisi est invalide\")]";
	    	String myXpath7 = "//input[@id='ctl00_cphBody_btnAnnuler']";
	    	verif = false; 
	    	if (MesFonctions.isElementPresent(driver, myXpath6, verif) == true){
	    		MesFonctions.objet(driver,myXpath7).click();
	    	}
	    	return null;
	    }
	    
	    public static String formulaireTACAA (WebDriver driver) throws Throwable {
		   //votre activité
		   String myXpath = "//input[@id='ctl00_cphBody_rblAvoCeCa_1']";
		   MesFonctions.objet(driver,myXpath).click();
		   System.out.println("Activité déclarée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   Thread.sleep(1000);
		   
		   //Votre identité et vos coordonées
		   String myXpath1 = "//input[@id='ctl00_cphBody_rblTypePersonne_1']";
		   MesFonctions.objet(driver,myXpath1).click();
		   Thread.sleep(1000);
		   
		   		//Civilité
		   String myXpath2 = "//select[@id='ctl00_cphBody_ddlCivilite']";
		   String value = "97";
		   MesFonctions.selection(driver, myXpath2, value);
		   System.out.println("CIVILITE renseigné...."+MesFonctions.extractCurrentHeure());
		   Thread.sleep(1000);
		   		//Nom
		   String myXpath3 = "//input[@id='ctl00_cphBody_tbNom']";
		   String nom = MesFonctions.objet(driver,myXpath3).getDomAttribute("value").toLowerCase();
		   System.out.println("NOM renseigné...."+MesFonctions.extractCurrentHeure());
		   		//Prenom
		   String myXpath4 = "//input[@id='ctl00_cphBody_tbPrenom']";
		   String prenom = MesFonctions.objet(driver,myXpath4).getDomAttribute("value").toLowerCase();
		   System.out.println("PRENOM renseigné...."+MesFonctions.extractCurrentHeure());
		   		//Barreau
		   String myXpath5 = "//select[@id='ctl00_cphBody_ddlBarreau']";
		   value = "121"; 
		   MesFonctions.selection(driver, myXpath5, value);
		   System.out.println("BARREAU renseigné...."+MesFonctions.extractCurrentHeure());
		   Thread.sleep(1000);
		   		//SIREN
		   Random rand = new Random();
		   int min = 590000000;
		   int max = 999999999;
		   int siren = rand.nextInt((max - min)+1) + min;
		   Thread.sleep(2000);
		   String myXpath6 = "//input[@id='ctl00_cphBody_tbSirenSiret']";
		   String sir = Integer.toString(siren);
		   MesFonctions.objet(driver,myXpath6).sendKeys(sir);
		   System.out.println("SIREN renseigné...."+MesFonctions.extractCurrentHeure());
		   Thread.sleep(1000);
		   		//NIC
		   min = 00200;
		   max = 99999;
		   int nic = rand.nextInt((max - min)+1) + min;
		   Thread.sleep(2000);
		   String myXpath7 = "//input[@id='ctl00_cphBody_tbNIC']";
		   String nc = Integer.toString(nic);
		   
		   Thread.sleep(1000);
		   if(nc.length()<5) {
			  String numic = "0"+nc ;
			  MesFonctions.objet(driver,myXpath7).sendKeys(numic);
		   }else {
			   MesFonctions.objet(driver,myXpath7).sendKeys(nc); 
		   }
		   System.out.println("NIC renseigné...."+MesFonctions.extractCurrentHeure());
		   		//Email
		   String myXpath8 = "//input[@id='ctl00_cphBody_tbCourrielPrincipal']";
		   String mail = nom+prenom+"@yopmail.com";
		   String email = MesFonctions.sansAccents(mail).replaceAll(" ", "").trim();
		   Thread.sleep(1000);
		   MesFonctions.objet(driver,myXpath8).sendKeys(email);
		   System.out.println("mail de l'utilisateur "+ email);
		   
		   String myXpath9 = "//input[@id='ctl00_cphBody_tbCourrielPrincipalConfirmation']";
		   MesFonctions.objet(driver,myXpath9).sendKeys(email);
		   Thread.sleep(1000);
		   System.out.println("MAIL confirmé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   
		   		//Captcha
		   String myXpath10 = "//input[@id='ctl00_cphBody_tbCaptcha']";
		   System.out.println("Captcha présent; 15s pour le renseigner....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath10));
		   Thread.sleep(15000);
		   
		   		//Accepter les conditions générales
		   String myXpath11 = "//input[@id='ctl00_cphBody_chkbAccordTeleprocedures']";
		   MesFonctions.objet(driver,myXpath11).click();
		   System.out.println("CONDITIONS GENERALES acceptées...."+MesFonctions.extractCurrentHeure());
		   
		   		//Valider
		   String myXpath12 = "//a[@id='ctl00_cphBody_linkButtonValider']";
		   MesFonctions.objet(driver,myXpath12).click();
		   boolean verif = false;
		   myXpath = "//div[@id='ctl00_cphBody_ValidationSummary1']";
		   if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			   myXpath = "//div//li"; 
				  List<WebElement> elt = driver.findElements(By.xpath(myXpath));
				  int nbr = elt.size();
				  for(int i=0;i<nbr;i++) {
					  System.err.println(elt.get(i).getText());
				  }
			  throw new Exception("Le formulaire n'est pas complet....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   }
		   
		   		//formulaire validé
		   String myXpath13 = "//div[@id='headerMasterCommun']";
		   MesFonctions.waiting2(driver, myXpath13, Duration.ofSeconds(3));
		   System.out.println("FORMULAIRE validé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   
		   return email; 
	   }
	   
	   	public static String formulaireAdmin (WebDriver driver, String nom, String prenom) throws Throwable {
		   
		   //Votre identité et vos coordonées
		   String myXpath1 = "//input[@id='ctl00_cphBody_rblTypePersonne_0']";
		   MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath1).click();
		   Thread.sleep(100);
		   
			//SIREN
		   Random rand = new Random();
		   int min = 590000000;
		   int max = 999999999;
		   int siren = rand.nextInt((max - min)+1) + min;
		   Thread.sleep(200);
		   String myXpath6 = "//input[@id='ctl00_cphBody_tbSirenSiret']";
		   MesFonctions.waiting2(driver, myXpath6, Duration.ofSeconds(3));
		   String sir = Integer.toString(siren);
		   
		   if(sir.length()<9) {
				  String sire = "0"+sir ;
				  MesFonctions.objet(driver, myXpath6).sendKeys(sire);
			   }else {
				   MesFonctions.objet(driver, myXpath6).sendKeys(sir); 
			   } 
		   System.out.println("SIREN renseigné : "+sir+"......"+MesFonctions.extractCurrentHeure());
		   Thread.sleep(100);
		   
	   		//NIC
		   min = 00200;
		   max = 99999;
		   int nic = rand.nextInt((max - min)+1) + min;
		   Thread.sleep(200);
		   String myXpath7 = "//input[@id='ctl00_cphBody_tbNIC']";
		   MesFonctions.waiting2(driver, myXpath7, Duration.ofSeconds(3));
		   String nc = Integer.toString(nic);
		   Thread.sleep(100);
		   
		   if(nc.length()<5) {
			  String numic = "0"+nc ;
			  MesFonctions.objet(driver, myXpath7).sendKeys(numic);
		   }else {
			   MesFonctions.objet(driver, myXpath7).sendKeys(nc); 
		   } 
		   System.out.println("NIC renseigné : "+nc+"......"+MesFonctions.extractCurrentHeure());
		   Thread.sleep(1000);
		   
			//Civilité
		   String myXpath2 = "//select[@id='ctl00_cphBody_ddlDestCaCivilite']";
		   MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
		   String value = "1" ;//madame (1) monsieur(2);
		   MesFonctions.selection(driver, myXpath2, value);
		   System.out.println("CIVILTE renseigné...."+MesFonctions.extractCurrentHeure());
		   Thread.sleep(100);
		   		//Nom
		   String myXpath3 = "//input[@id='ctl00_cphBody_tbDestCaNom']";
		   MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath3).sendKeys(nom);
		   System.out.println("NOM renseigné...."+MesFonctions.extractCurrentHeure());
		   		//Prenom
		   String myXpath4 = "//input[@id='ctl00_cphBody_tbDestCaPrenom']";
		   MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath4).sendKeys(prenom);
		   System.out.println("PRENOM renseigné...."+MesFonctions.extractCurrentHeure());
		   
			//Email
		   String myXpath8 = "//input[@id='ctl00_cphBody_tbDestCaCourriel']";
		   MesFonctions.waiting2(driver, myXpath8, Duration.ofSeconds(3));
		   String mail = nom.toLowerCase()+prenom.toLowerCase()+"@yopmail.com";
		   String email = MesFonctions.sansAccents(mail);
		   Thread.sleep(1000);
		   MesFonctions.objet(driver, myXpath8).sendKeys(email);
		   
		   System.out.println("mail de l'utilisateur : "+ email+" renseigné...."+MesFonctions.extractCurrentHeure());
		   
		   String myXpath9 = "//input[@id='ctl00_cphBody_tbDestCaCourrielConfirmation']";
		   MesFonctions.waiting2(driver, myXpath9, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath9).sendKeys(email);
		   Thread.sleep(1000);
		   System.out.println("MAIL confirmé...."+MesFonctions.extractCurrentHeure());
		   
			//Captcha
		   String myXpath10 = "//input[@id='ctl00_cphBody_tbCaptcha']";
		   System.err.println("Captcha présent; 15s pour le renseigner");
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath10));
		   Thread.sleep(15000);
		   
		   		//Accepter les conditions générales
		   String myXpath11 = "//input[@id='ctl00_cphBody_chkbAccordTeleprocedures']";
		   MesFonctions.objet(driver,myXpath11).click();
		   System.out.println("CONDITIONS GENERALES acceptées...."+MesFonctions.extractCurrentHeure());
		   
		   		//Valider
		   String myXpath12 = "//a[@id='ctl00_cphBody_linkButtonValider']";
		   MesFonctions.objet(driver,myXpath12).click();
		   Thread.sleep(2000);
		   boolean verif = false;
		   String myXpath = "//div[@id='ctl00_cphBody_ValidationSummary1']";
		   if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			   myXpath = "//div//li"; 
			  List<WebElement> elt = driver.findElements(By.xpath(myXpath));
			  int nbr = elt.size();
			  for(int i=0;i<nbr;i++) {
				  System.err.println(elt.get(i).getText());
			  }
			  throw new Exception("Le formulaire n'est pas complet....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   }
		   
		   		//formulaire validé
		   String myXpath13 = "//div[@id='headerMasterCommun']";
		   MesFonctions.waiting2(driver, myXpath13, Duration.ofSeconds(3));
		   System.out.println("FORMULAIRE validé....."+MesFonctions.extractCurrentHeure());
		   
		   return email;
	   }
	   
	   	public static String formulaireCE (WebDriver driver, String nomCE) throws Throwable {
		   //votre activité
		   String myXpath = "//input[@id='ctl00_cphBody_rblAvoCeCa_1']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath).click();
		   System.out.println("Activité déclarée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   Thread.sleep(100);
		   
		   //Votre identité et vos coordonées
		   String myXpath1 = "//input[@id='ctl00_cphBody_rblTypePersonne_1']";
		   MesFonctions.objet(driver,myXpath1).click();
		   Thread.sleep(100);
		   
		   		//Civilité
		   String myXpath2 = "//select[@id='ctl00_cphBody_ddlCivilite']";
		   String value = "97";
		   MesFonctions.selection(driver, myXpath2, value);
		   System.out.println("CIVILITE renseigné...."+MesFonctions.extractCurrentHeure());
		   Thread.sleep(100);
		   		//Nom
		   String myXpath3 = "//input[@id='ctl00_cphBody_tbNom']";
		   MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath3).clear();
		   MesFonctions.objet(driver,myXpath3).sendKeys(nomCE);
		   System.out.println("NOM renseigné...."+MesFonctions.extractCurrentHeure());
		   		//Prenom
		   String myXpath4 = "//input[@id='ctl00_cphBody_tbPrenom']";
		   String prenom = MesFonctions.objet(driver, myXpath4).getDomAttribute("value").toLowerCase();
		   System.out.println("PRENOM renseigné...."+MesFonctions.extractCurrentHeure());	
		   		//Barreau
		   String myXpath5 = "//select[@id='ctl00_cphBody_ddlBarreau']";
		   value = "121"; 
		   MesFonctions.selection(driver, myXpath5, value);
		   System.out.println("BARREAU renseigné...."+MesFonctions.extractCurrentHeure());	
		   Thread.sleep(100);
		   
		   		//SIREN
		   Random rand = new Random();
		   int min = 590000000;
		   int max = 999999999;
		   int siren = rand.nextInt((max - min)+1) + min;
		   Thread.sleep(200);
		   String myXpath6 = "//input[@id='ctl00_cphBody_tbSirenSiret']";
		   String sir = Integer.toString(siren);
		   
		   if(sir.length()<9) {
				  String sire = "0"+sir ;
				  MesFonctions.objet(driver,myXpath6).sendKeys(sire);
			   }else {
				   MesFonctions.objet(driver,myXpath6).sendKeys(sir); 
			   }
		   System.out.println("SIREN renseigné...."+MesFonctions.extractCurrentHeure());	
		   Thread.sleep(100);
		  
		   		//NIC
		   min = 00200;
		   max = 99999;
		   int nic = rand.nextInt((max - min)+1) + min;
		   Thread.sleep(100);
		   String myXpath7 = "//input[@id='ctl00_cphBody_tbNIC']";
		   MesFonctions.waiting2(driver, myXpath7, Duration.ofSeconds(3));
		   String nc = Integer.toString(nic);
		   
		   if(nc.length()<5) {
				  String numic = "0"+nc ;
				  MesFonctions.objet(driver,myXpath7).sendKeys(numic);
			   }else {
				   MesFonctions.objet(driver,myXpath7).sendKeys(nc); 
			   } 
		   System.out.println("NIC renseigné...."+MesFonctions.extractCurrentHeure());	   
		   Thread.sleep(100);
		   
	   		//Email
		   String myXpath8 = "//input[@id='ctl00_cphBody_tbCourrielPrincipal']";
		   String mail = nomCE+prenom+"@yopmail.com";
		   String email = MesFonctions.sansAccents(mail).replaceAll(" ", "").trim().toLowerCase();
		   MesFonctions.waiting2(driver, myXpath8, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath8).clear();
		   Thread.sleep(100);
		   MesFonctions.objet(driver,myXpath8).sendKeys(email);
		   System.out.println("mail de l'utilisateur : "+ email+" renseigné...."+MesFonctions.extractCurrentHeure());
		   
		   String myXpath9 = "//input[@id='ctl00_cphBody_tbCourrielPrincipalConfirmation']";
		   MesFonctions.waiting2(driver, myXpath9, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath9).sendKeys(email);
		   Thread.sleep(100);
		   System.out.println("MAIL confirmé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   
		   //Captcha
		   String myXpath10 = "//input[@id='ctl00_cphBody_tbCaptcha']";
		   System.out.println("Captcha présent; 15s pour le renseigner");
		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath10));
		   Thread.sleep(15000);
		   
		   //Accepter les conditions générales
		   String myXpath11 = "//input[@id='ctl00_cphBody_chkbAccordTeleprocedures']";
		   MesFonctions.waiting2(driver, myXpath11, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath11).click();
		   System.out.println("CONDITIONS GENERALES acceptées...."+MesFonctions.extractCurrentHeure());
		   
		   //Valider
		   String myXpath12 = "//a[@id='ctl00_cphBody_linkButtonValider']";
		   MesFonctions.waiting2(driver, myXpath12, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath12).click();
		   boolean verif = false;
		   myXpath = "//div[@id='ctl00_cphBody_ValidationSummary1']";
		   if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			   myXpath = "//div//li"; 
				  List<WebElement> elt = driver.findElements(By.xpath(myXpath));
				  int nbr = elt.size();
				  for(int i=0;i<nbr;i++) {
					  System.err.println(elt.get(i).getText());
				  }
			  throw new Exception("Le formulaire n'est pas complet......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   }
		   
		   //Formulaire validé
		   String myXpath13 = "//div[@id='headerMasterCommun']";
		   MesFonctions.waiting2(driver, myXpath13, Duration.ofSeconds(3));
		   System.out.println("FORMULAIRE validé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   
		   return email; 
	   }
	   
	   	public static String formulaireInscriptRPVA (WebDriver driver, WebElement element) throws Throwable {
		   //Vérification des informations de la 1ère page 
		   System.out.println("page 1");
		   
		   String myXpath = "//input[@id='FormModel_LastName']";
		   String myXpath1 = "//input[@id='FormModel_GivenName']";
		   String myXpath2 = "//input[@id='FormModel_Email']";
		   String myXpath3 = "//input[@id='FormModel_EmailConfirmation']";
		   
		   String mail = (MesFonctions.objet(driver,myXpath).getDomAttribute("value")+MesFonctions.objet(driver,myXpath1).getDomAttribute("value")).toLowerCase()+"@yopmail.com";
		   Thread.sleep(2000);
		   System.out.println(mail);
		   			//1ere méthode de vérification 
				   if(MesFonctions.objet(driver,myXpath).getDomAttribute("value") != null || MesFonctions.objet(driver,myXpath1).getDomAttribute("value") != null) {
					   MesFonctions.objet(driver,myXpath2).sendKeys(mail);
					   MesFonctions.objet(driver,myXpath3).sendKeys(mail);  
				   }
				   else {throw new Exception("Les champs ne sont pas renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");}
				   
		   	myXpath = "//button[@class='btn btn-primary stepper-next']";
		   	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   	MesFonctions.objet(driver,myXpath).click();
		   	
		   	//Vérification des informations de la 2ème page
		   	myXpath = "//h2[text()='Vos coordonnées']";
		   	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   	System.out.println("page 2");
		   	
		   	myXpath = "//select[@id='FormModel_BarreauId']//option[@selected='selected']";
		   	boolean verif = false;
		   	if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
		   	System.out.println(MesFonctions.objet(driver,myXpath).getDomAttribute("selected"));	
		   	}else {System.err.println("Valeur non renseignée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");}
		   	
		   	Thread.sleep(1000);
		   	myXpath = "//input[@id='FormModel_Name']";
		   	myXpath1 = "//input[@id='FormModel_Adress1']";
		   	myXpath2 = "//input[@id='FormModel_PostalCode']";
		   	myXpath3 = "//input[@id='FormModel_City']";	
		   	
		   	
		   	List<String> str = new ArrayList<>();
		   	str.add(myXpath);
		   	str.add(myXpath1);
		   	str.add(myXpath2);
		   	str.add(myXpath3);
		   			//2ème méthode de vérification		
				   	for(String e : str) {
				   		if(MesFonctions.objet(driver,e).getDomAttribute("value") != null) {
				   	System.out.println(MesFonctions.objet(driver,e).getDomAttribute("value"));
				   	Thread.sleep(1000);
				   	} else {
				   		System.err.println("élément non renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   		Thread.sleep(1000);
				   		}
				   	}
		   	
		   	myXpath = "//div[@id='registration-step-2']//button[@class='btn btn-primary stepper-next']";
		   	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
		   	MesFonctions.objet(driver,myXpath).click();
		   	
		   	//accès page 3
		   	myXpath = "//h1[text()='Inscription aux téléprocédures']";
		   	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   	System.out.println("page 3");
		   	Thread.sleep(3000);
		   	myXpath = "//div[@id='registration-step-3']//button[@class='btn btn-primary stepper-next']";
		   	MesFonctions.objet(driver,myXpath).click();
		   	
		   	//accès dernière page 
		   	myXpath = "//h1[text()='Inscription aux téléprocédures']";
		   	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   	System.out.println("page 4");
		   	myXpath = "//label[@class='custom-control-label bolded']";
		   	MesFonctions.objet(driver,myXpath).click();
		   	
		   	myXpath = "//input[@id='FormModel_InputCaptcha']";
		   	System.out.println("Captcha présent; 15s pour le renseigner");
		   	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath));
		   	Thread.sleep(15000);
		   	
		   	myXpath = "//input[@id='submit-registration-form']";
		   	MesFonctions.objet(driver,myXpath).click();
		   	
		   return mail;
	   }
	   
	   	public static String mailPrefUtiRpva (WebDriver driver, String mail, String choixJur) throws Throwable {
		   switch (choixJur) {
		case "TACAA":
			String myXpath = "//h1[text()='Inscription aux téléprocédures']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
			myXpath = "//input[@id='FormModel_Email']";
			MesFonctions.objet(driver,myXpath).sendKeys(mail);
			System.out.println("mail renseigné");
			
			Thread.sleep(1000);
			myXpath = "//input[@id='FormModel_EmailConfirmation']";
			MesFonctions.objet(driver,myXpath).sendKeys(mail);
			System.out.println("mail confirmé");
			
				//valider
			myXpath = "//span[@class='fa fa-check']";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Inscription validée");

			break;
			
		case "Conseil":
			//Vérification de la page 
			myXpath = "//h1[text()='Inscription aux téléprocédures']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
			myXpath = "//input[@id='FormModel_Email']";
			MesFonctions.objet(driver,myXpath).sendKeys(mail);
			System.out.println("mail renseigné");
			
			Thread.sleep(1000);
			myXpath = "//input[@id='FormModel_EmailConfirmation']";
			MesFonctions.objet(driver,myXpath).sendKeys(mail);
			System.out.println("mail confirmé");
			
				//valider
			myXpath = "//span[@class='fa fa-check']";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Inscription validée");
			
			//Vérification de la page
			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println(MesFonctions.objet(driver,myXpath).getText());
			Thread.sleep(2000);
			break;

		default: System.err.println("Pas de juridiction trouvée à ce nom");
			break;
		}
		   	
		   return null;   
	   }
	   
	   	public static String mailYop(WebDriver driver, String mail) throws Throwable {
		   	//Redirection vers la page mail
		   	MicroFonctions.changeWindowMail(driver);
		   		//Page mail
			driver.get("https://yopmail.com/fr/");
			System.out.println("Accèe à la page : \"https://yopmail.com/fr/\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			String myXpath = "//img[@id='logoacc']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				//Acceptation des cookies
			boolean verif = false;
			myXpath = "//button[@role='button']/p[contains(text(),'Autoriser')]";
			while(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(300);
			System.out.println("Acceptation des cookies......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
				//Accès à la boite mail
			System.out.println("Accès à la boite mail");
			String myXpath1 = "//input[@id='login']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath1).clear();
			MesFonctions.objet(driver,myXpath1).sendKeys(mail);
			Thread.sleep(100);
			System.out.println("Adresse "+mail+" renseignée dans la barre de recherche......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			myXpath = "//button[@class='md']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
				//Consultation des mails
			myXpath1 = "//div[@class='bname']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			
			System.out.println("Accès à la boite mail réussi....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				//Vérification de la présence du mail d'inscription
			Thread.sleep(200);
			driver.switchTo().frame("ifinbox");//Now if your textbox is in any of iframe use below code to go inside particular iframe first "driver.switch_to.frame("<name or Id of frame>")"
			String str = "Confirmation de votre inscription";
			myXpath = "//div[@class='lms' and contains(text(),'inscription')]";
//			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//			verif = str.contains(MesFonctions.objet(driver, myXpath).getText());
			if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				System.out.println(str+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				verif = true;
			}
//			driver.switchTo().parentFrame(); //come out to frame
			Thread.sleep(200);
			System.out.println(verif);
//			System.out.println(MesFonctions.objet(driver, myXpath).getText()+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			while (!verif) {
				String myXpath2 = "//button[@id='refresh']";
				driver.switchTo().parentFrame();
				//Accès bouton refresh
				MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath2).click();
				System.out.println("Accès bouton refresh....."+MesFonctions.extractCurrentHeure());
				Thread.sleep(200);
				//retour dans la liste des des mails
				driver.switchTo().frame("ifinbox");
				System.out.println("Véfirication de la liste des des mails....."+MesFonctions.extractCurrentHeure());
				if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
					verif = true;
					System.out.println(str+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}else {
					verif = false;
				}
			}
			
			//Clic sur le lien depuis le mail 
			driver.switchTo().parentFrame();
			driver.switchTo().frame("ifmail");
			myXpath = "//a[contains(@href,'telerecours')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Ouverture de la page des identifiants provisoires....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			driver.switchTo().parentFrame();
			
			//Changement de page -> page des codes provisoires
   		    Thread.sleep(200);
		    String onglet = MesFonctions.getWindow(driver, 1);
		    driver.switchTo().window(onglet);
		    driver.close();
		    System.out.println("fermeture de la page yopmail....."+MesFonctions.extractCurrentHeure());
		    onglet = MesFonctions.getWindow(driver, 1);
		    driver.switchTo().window(onglet);
		    System.out.println("Accès à la page des identifiants provisoires....."+MesFonctions.extractCurrentHeure()+"\r");
		    return null;
	   }
	   
	   	public static Integer mailYopRecovery (WebDriver driver, String mail) throws Throwable {
			//Redirection vers la page mail
		   	driver.navigate().to("https://yopmail.com/fr/");
		   	Thread.sleep(300);
		   		//Page mail
			String myXpath = "//img[@id='logoacc']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
			//Acceptation des cookies
			boolean verif = false;
			myXpath = "//button[@role='button']/p[contains(text(),'Autoriser')]";
			while(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(300);
			System.out.println("Acceptation des cookies......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
				//Accès à la boite mail
			System.out.println("Accès à la boite mail");
			String myXpath1 = "//input[@id='login']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).clear();
			Thread.sleep(100);
			MesFonctions.objet(driver, myXpath1).sendKeys(mail);
			Thread.sleep(100);
			myXpath = "//button[@class='md']";
			MesFonctions.objet(driver,myXpath).click();
				//Consultation des mails
			myXpath1 = "//div[@class='bname']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			
			System.out.println("Accès à la boite mail réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				//Vérification de la présence du mail d'inscription
			Thread.sleep(200);
			driver.switchTo().frame("ifinbox");//Now if your textbox is in any of iframe use below code to go inside particular iframe first "driver.switch_to.frame("<name or Id of frame>")"
			String str = "Confirmation de demande de réinitialisation de vos codes d'accès Télérecours";
			myXpath = "//div[@class='lms' and contains(text(),\"Confirmation de demande de réinitialisation de vos codes d'accès Télérecours\")]";
			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int emails = elements.size();
			
			System.out.println("Nombre de mail(s) lié(s) à la modification d'un mot de passe : "+emails);
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			verif = str.equals(MesFonctions.objet(driver, myXpath).getText());
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(150);
			driver.switchTo().parentFrame(); //come out to frame
			Thread.sleep(200);
			System.out.println(verif);
			while (!verif) {
				String myXpath2 = "//button[@id='refresh']";
				System.err.println(str +" est différent de "+verif);
				MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath2).click();
				Thread.sleep(200);
			}
				//Clic sur le lien depuis le mail 
			driver.switchTo().frame("ifmail");
			myXpath = "//a[contains(@href,'authentification.recette')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String idclient = MesFonctions.objet(driver,myXpath).getText();
			if(!idclient.contains("client_id")){
				System.err.println("il n'y a pas de client_id");
			}else {
			System.out.println("le client_id est " + idclient.substring(idclient.indexOf("client_id"), idclient.length()));
			}
			MesFonctions.objet(driver, myXpath).click();
			driver.switchTo().parentFrame();
		   
		   return emails;
	   }
	   
	   
	   	public static String recoveryII(WebDriver driver, String mail, Integer nbrEmail) throws Throwable {
		   	//Redirection vers la page mail
		   	driver.navigate().to("https://yopmail.com/fr/");
		   	Thread.sleep(300);
		   		//Page mail
			String myXpath = "//img[@id='logoacc']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
				//Acceptation des cookies
			boolean verif = false;
			myXpath = "//button[@role='button']/p[contains(text(),'Autoriser')]";
			while(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(300);
			System.out.println("Acceptation des cookies......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
				//Accès à la boite mail
			System.out.println("Accès à la boite mail");
			String myXpath1 = "//input[@id='login']";
			MesFonctions.objet(driver,myXpath1).clear();
			Thread.sleep(100);
			MesFonctions.objet(driver,myXpath1).sendKeys(mail);
			Thread.sleep(100);
			myXpath = "//button[@class='md']";
			MesFonctions.objet(driver,myXpath).click();
			
				//Consultation des mails
			myXpath1 = "//div[@class='bname']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			
			System.out.println("Accès à la boite mail réussi");
				//Vérification de la présence du mail d'inscription
			Thread.sleep(200);
			driver.switchTo().frame("ifinbox");//Now if your textbox is in any of iframe use below code to go inside particular iframe first "driver.switch_to.frame("<name or Id of frame>")"
			String str = "Confirmation de demande de réinitialisation de vos codes d'accès Télérecours";
			myXpath = "//div[@class='lms' and contains(text(),\"Confirmation de demande de réinitialisation de vos codes d'accès Télérecours\")]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			verif = str.equals(MesFonctions.objet(driver, myXpath).getText());
			
			//verification du nombre de mail de recovery

			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int emails = elements.size();

			System.out.println("Nombre de mail de récupération d'identifiant : "+emails);
			int tr = 0;
			while(emails == nbrEmail) {
				
				driver.switchTo().parentFrame();
				String myXpath2 = "//button[@id='refresh']";
				MesFonctions.objet(driver, myXpath2).click();
				System.out.println("liste des mails rafraîchie " + tr);
				Thread.sleep(200);
				driver.switchTo().frame("ifinbox");
				elements = driver.findElements(By.xpath(myXpath));
				emails = elements.size();
				Thread.sleep(3000);
				tr++;
			}
			
			//block de code pas très util !!!
			List<Date> horaire = new ArrayList<>();
			
				//horaire des emails
//			myXpath1 = "//div[@class='lms' and contains(text(),\"Confirmation de demande de réinitialisation de vos codes d'accès Télérecours\")]//preceding-sibling::div[@class='lmfd']//span[@class='lmh']";
//			List<WebElement> elements2 = mesFonctions.objets(driver, elements, myXpath1);
			
			String pattern = "HH:mm";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			
			//Identifiation des jours des envois des mails. Création d'un tableau de ces jours en retirant la valeur "aujourd'hui" 
			String myXpathDy = "//div[@class='mctn']//div[@class='mday']";
			List<WebElement> day = driver.findElements(By.xpath(myXpathDy));
			List<String> days = new ArrayList<>();
			int nbrdy = day.size();
			System.out.println("nombre de jours recensés : " + nbrdy);
			for(int i=0; i<nbrdy ; i++) {
				verif = day.get(i).getText().toString().equals("aujourd'hui");
				if (!verif) {
					System.out.println(day.get(i).getText());
					days.add(day.get(i).getText().trim());
					}
			}
			
			System.out.println(days);
			//Xpath remontant le nombre de mail de confirmation de demande de réinitialisation au jour "Aujourd'hui" (sachant que la valeur days.get(0) sera valorisé à la valeur précédent "Aujourd'hui")
			String myXpathTest = "//div[@class='mctn']//div[text()=\""+days.get(0)+"\"]//preceding-sibling::div//div[@class='lms' and contains(text(),\"Confirmation de demande de réinitialisation\")]";
			System.out.println(myXpathTest);
			//Xpath remontant l'horaire de confirmation de demande de réinitialisation au jour "Aujourd'hui"
			String myXpathTest1 = "//div[@class='mctn']//div[text()=\""+days.get(0)+"\"]//preceding-sibling::div//div[@class='lms' and contains(text(),\"Confirmation de demande de réinitialisation\")]//preceding-sibling::div/span[@class='lmh']";
			System.out.println(myXpathTest1);
			List<WebElement> elmt = driver.findElements(By.xpath(myXpathTest));
			List<WebElement> elmt1 = driver.findElements(By.xpath(myXpathTest1));
			int nbrElmt = elmt.size();
			System.out.println("nombre d'éléments recensés : " + nbrElmt);
			if(nbrElmt>1) {
				for(int i=0; i<nbrElmt; i++) {
					horaire.add(simpleDateFormat.parse(elmt1.get(i).getText()));
					System.out.println(elmt1.get(i).getText());
					System.out.println("Itération : "+i+" - "+horaire);
					}
				Date date1 = horaire.get(0);
				Date date = horaire.get(1);
				
				if(date.before(date1)) {
					System.out.println("Comparatif de date");
					
					MesFonctions.objets(driver, myXpathTest).get(0).click();
					Thread.sleep(1000);
				}	
			} else {
				elmt.get(0).click();
			}
			
			//fin de block de code pas très util !!!!
			
//			mesFonctions.objet(driver,myXpath).click();
//			Thread.sleep(1500);
//			driver.switchTo().parentFrame(); //come out to frame
//			Thread.sleep(2000);
//			System.out.println(verif);
//			while (!verif) {
//				String myXpath2 = "//button[@id='refresh']";
//				mesFonctions.objet(driver,myXpath2).click();
//				Thread.sleep(2000);
//			}
				//Clic sur le lien depuis le mail
			driver.switchTo().parentFrame();//come out to frame
			driver.switchTo().frame("ifmail");
			myXpath = "//a[contains(@href,'authentification.recette')]";
			String idclient = MesFonctions.objet(driver,myXpath).getText();
			if(!idclient.contains("client_id")){
				System.err.println("il n'y a pas de client_id");
			}else {
			System.out.println("le client_id est " + idclient.substring(idclient.indexOf("client_id"), idclient.length()));
			}
			MesFonctions.objet(driver,myXpath).click();
			driver.switchTo().parentFrame();
		   
		   return null;
	   }
	   
	   	public static String Inscription (WebDriver driver, String jur) throws Throwable {
//		   String myXpath = "//button[@id='refresh']";
//		   mesFonctions.objet(driver,myXpath).click();
//		   Thread.sleep(2000);
		   
		   //Récupération des codes provisoires
		   Thread.sleep(200);
		   String myXpath = "//span[@id='ctl00_cphBody_lblCodeAcces']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   String id = MesFonctions.objet(driver,myXpath).getText();
		   
		   String myXpath1 = "//span[@id='ctl00_cphBody_lblMotDePasse']";
		   MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
		   String mdp = MesFonctions.objet(driver,myXpath1).getText();
		   Thread.sleep(200);
		   System.out.println("Récupération de l'identifiant de l\'utilisateur "+id+" et du mot de passe provisoire "+mdp+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   //Quitter la page
		   String myXpath2 = "//input[@id='ctl00_cphBody_btnQuitter']";
		   MesFonctions.objet(driver, myXpath2).click();
		   
		   //Accepter l'alerte
		   myXpath = "//span[@class='ui-button-text' and text()='OK']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   MesFonctions.objet(driver,myXpath).click();
		   
		   //Clic sur le boutton de redirection -> page d'accueil TR
		   String myXpath3 = "//h1[text()='Se connecter']";
		   MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
		   
		   //Fin de la procédure d'inscription
		   MicroFonctions.inscriptionFin(driver, jur, id, mdp);
		   return id;
	   }
	   
	   	public static String InscriptionRecovery (WebDriver driver, String jur) throws Throwable {
		   //Changement de page -> page des codes provisoires
		   String onglet1 = MesFonctions.childWindow(driver);
		   driver.close();
		   Thread.sleep(300);
		   driver.switchTo().window(onglet1);
		   
		   //Récupération des codes provisoires
		   Thread.sleep(100);
		   String myXpath = "//input[@id='Username']";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   String id = MesFonctions.objet(driver,myXpath).getDomAttribute("value");
		   
		   String myXpath1 = "//input[@id='Password']";
		   MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
		   String mdp = MesFonctions.objet(driver,myXpath1).getDomAttribute("value");
		   Thread.sleep(100);
		   System.out.println("Récupération de l'identifiant de l'utilisateur "+id+" et du mot de passe provisoire "+mdp+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   //Quitter la page
		   String myXpath2 = "//a[@class='btn btn-lg btn-primary need-confirmation']";
		   MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
		   MesFonctions.objet(driver, myXpath2).click();
		   //Accepter l'alerte
//		   mesFonctions.waiting1(driver, Duration.ofSeconds(3));
		   Alert alert = driver.switchTo().alert();
		   alert.accept();
		   System.out.println("L'alerte est acceptée");
//		   myXpath = "//span[@class='ui-button-text' and text()='OK']";
//		   mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		   mesFonctions.objet(driver, myXpath).click();
		   //Clic sur le boutton de redirection -> page d'accueil TR
		   String myXpath3 = "//h1[text()='Se connecter']";
		   MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
		   System.out.println("Page d'authentification");
		   //Fin de la procédure d'inscription
		   MicroFonctions.inscriptionFin(driver, jur, id, mdp);
		   return id;
	   }
	   
	   	public static String inscriptionFin (WebDriver driver, String jur, String id, String mdp) throws Throwable {
		  //Authentification avec les codes provisoire
		  MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
		  String mdp2 = "Lhommeest2019*";
		  MicroFonctions.changementMdp(driver, jur, mdp, mdp2, id);
		  
		  return null;
	   }
	   	
	   	public static void changementMdp(WebDriver driver, String jur, String mdp, String mdp2, String id) throws Throwable {
	   		String myXpath = "//h1[@id='staticBackdropLabel']";
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  //Ouverture de la PopUp de modification de ses codes
			  		//Code provisoire
			  String myXpath1 = "//input[@id='password-field2']";
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  MesFonctions.objet(driver,myXpath1).sendKeys(mdp);
			  System.out.println("Insertion de l'ancien mot de passe : "+mdp +"....."+MesFonctions.extractCurrentHeure());
			  		//nouveau code
			  String myXpath2 = "//input[@id='password-field3']";
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  MesFonctions.objet(driver, myXpath2).sendKeys(mdp2);
			  System.out.println("Insertion du nouveau mot de passe : "+mdp2 +"....."+MesFonctions.extractCurrentHeure());
			  		//Confirmation du nouveau code
			  String myXpath3 = "//input[@id='password-field4']";
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  MesFonctions.objet(driver, myXpath3).sendKeys(mdp2);
			  System.out.println("Confirmation du nouveau mot de passe : "+mdp2 +"....."+MesFonctions.extractCurrentHeure());
			  Thread.sleep(1200);
			  
			  //Validation
			  myXpath = "//button[@id='updpass']";
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  MesFonctions.objet(driver,myXpath).click();
			  System.out.println("Validation des nouveaux identifiants....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			  
			  String myXpath4 = "//h1[text()='Se connecter']";
			  MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
			  System.out.println("Retour à la page d'authentification......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			  
			  //Vérification des nouveaux codes d'authentification
			  Thread.sleep(200);
			  myXpath = "//input[@id='Username']";
			  String myXpath5 = "//input[@id='password-field']";
			  String myXpath6 = "//button[@id='login-submit']";
			 
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  MesFonctions.objet(driver, myXpath).clear();
			  MesFonctions.objet(driver, myXpath).sendKeys(id);
			  
			  MesFonctions.waiting2(driver, myXpath5, Duration.ofSeconds(3));
			  MesFonctions.objet(driver, myXpath5).clear();
			  MesFonctions.objet(driver, myXpath5).sendKeys(mdp2);
			  System.out.println("Insertion du mot de passe : "+mdp2 +"....."+MesFonctions.extractCurrentHeure());
			  MesFonctions.objet(driver, myXpath6).click();
			  
			  
			  Thread.sleep(200);
			  boolean verif = false;
			  myXpath = "//li[text()=\"Nom d'utilisateur ou mot de passe invalide\"]";
			  if(MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
			  System.out.println("Authentification réussie......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			  }else {
				  System.out.println("Echec d'authentification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			  }
			  
			  //Choix de la juridiction
			  if(jur=="TA" || jur=="TACAA") {
				  MicroFonctions.choixJuridictionTA(driver);
			  		}else if (jur=="CAA" || jur=="TACAA") {
			  			MicroFonctions.choixJuridictionCAA(driver);
			  	}
			  		else {
			  			String name = "Télérecours - Conseil d'Etat";
						myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
						verif = name.equals(MesFonctions.objet(driver, myXpath).getText());
						Thread.sleep(300);
						
						if (!verif) {
							System.err.println("La redirection n'a pas bien fonctionné");
						}else {
							System.out.println("La redirection a bien fonctionné");
						}
						Thread.sleep(300);
			  		}
			  
	   	}
	  
	 
	  	public static String authentification_nouveau_Mdp (WebDriver driver, String jur, String id, String mdp) throws Throwable {
		  //Vérification des nouveaux codes d'authentification
		  Thread.sleep(200);
		  String myXpath = "//input[@id='Username']";
		  String myXpath5 = "//input[@id='password-field']";
		  String myXpath6 = "//button[@id='login-submit']";
//		  Integer lg = MesFonctions.objet(driver, myXpath).getText().length();
//		  if(lg == null) {
//			  MesFonctions.objet(driver, myXpath).sendKeys(id);
//		  }
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath).clear();
		  MesFonctions.objet(driver, myXpath).sendKeys(id);
		  System.out.println("Insertion du mot de l'identifiant : "+id +"....."+MesFonctions.extractCurrentHeure());
		  
		  MesFonctions.waiting2(driver, myXpath5, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath5).sendKeys(mdp);
		  System.out.println("Insertion du nouveau mot de passe : "+mdp+"....."+MesFonctions.extractCurrentHeure());
		  
		  //Validation des identifiants
		  MesFonctions.objet(driver, myXpath6).click();
		  System.out.println("Validation des identifiants......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  
		  
		  Thread.sleep(200);
		  boolean verif = false;
		  myXpath = "//li[text()=\"Nom d'utilisateur ou mot de passe invalide\"]";
		  if(MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
		  System.out.println("Authentification réussie");
		  }else {
			  System.err.println("Echec d'authentification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  }
		  
		  //Choix de la juridiction
		  if(jur=="TACAA") {
			  MicroFonctions.choixJuridictionTA(driver);
		  }
		
		  return null;
	  }
	  
	  	public static void mot_de_passe_passant_nonpassant(WebDriver driver, String mdp, String mdp2) throws Throwable {
  		 String myXpath = "//h1[@id='staticBackdropLabel']";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  //Ouverture de la PopUp de modification de ses codes
		  		//Code provisoire
		  String myXpath1 = "//input[@id='password-field2']";
		  MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath1).sendKeys(mdp);
		  System.out.println("Insertion de l'ancien mot de passe : "+mdp +"....."+MesFonctions.extractCurrentHeure());
		  		//nouveau code
		  String myXpath2 = "//input[@id='password-field3']";
		  MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath2).sendKeys(mdp2);
		  System.out.println("Insertion du nouveau mot de passe : "+mdp2 +"....."+MesFonctions.extractCurrentHeure());
		  		//Confirmation du nouveau code
		  String myXpath3 = "//input[@id='password-field4']";
		  MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath3).sendKeys(mdp2);
		  System.out.println("Confirmation du nouveau mot de passe : "+mdp2 +"....."+MesFonctions.extractCurrentHeure());
		  Thread.sleep(1200);
		  
		  //Validation
		  myXpath = "//button[@id='updpass']";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath).click();
		  System.out.println("Validation du nouveau mot de passe : "+mdp2+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  Thread.sleep(500);
	  	
		  boolean verif = false;
		  //Vérification de la présence de l'alerte
		  myXpath = "//div[@class='alert alert-info']//li";
		  if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  String alert = MesFonctions.objet(driver, myXpath).getText();
			  System.err.println("Le nouveau mot de passe "+mdp2+" n'a pas pu être validé");
			  System.err.println(alert);
			  
			  //Annulation de l'authentification
			  myXpath = "//button[@class='btn btn-secondary']";
			  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			  MesFonctions.objet(driver, myXpath).click();
			  System.out.println("Annulation du changement de mot de passe....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r"); 
		  }
		  
		  //Retour à la page d'acceuil
		  String myXpath4 = "//h1[text()='Se connecter']";
		  MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		  System.out.println("Retour à la page d'authentification......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  
	  	}
	  	
	  	public static void suppression_Brouillon_Trc(WebDriver driver) throws InterruptedException, Throwable {
	  				//Déposer une nouvelle requête
			   String myXpath0 = "//span[contains(text(),\"nouvelle requête\")]";
			   MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
			   String myXpath1 = "//span[contains(text(),\"Supprimer mon brouillon\")]";
			   String myXpath = "//span[contains(text(),\"supprime mon brouillon\")]";
			   MesFonctions.objet(driver, myXpath0).click();
			   		//vérification s'il y a un brouillon en cours (ne pas l'utiliser)
			   boolean verif = false;
			   if(MesFonctions.isElementPresent(driver, myXpath1, verif) == false) {
				   Thread.sleep(100);
				   System.out.println("Il n'y a aucun brouillon présent "+MesFonctions.extractCurrentHeure()+"\r");
			   }else {
				   MesFonctions.objet(driver, myXpath1).click();
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.objet(driver, myXpath).click();
				   String myXpath3 = "//div[@role='alert']";
				   MesFonctions.verifyPresenceOfAttribute1(driver, myXpath3, "class", "alert text-success border border-success");
				   System.out.println("Le brouillon a bien été supprimé");

				   MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
				   MesFonctions.objet(driver, myXpath0).click();
				   System.out.println("Accès à la page de validation des conditions générales......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
	  	}
	    
	  	public static String conditionsGeneralesTrcSansBrouillon (WebDriver driver) throws Throwable {
		   //Suppression brouillon
	  		MicroFonctions.suppression_Brouillon_Trc(driver);
	  		/*
	  		 * partie à revoir du fait de la nouvelle RG d'acceptation des CGU
	  		 */
		   //accepter les conditions générales
//		   String myXpath2 = "//input[@id='teleprocedureCheckbox']";
//		   MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
//		   MesFonctions.goToDown(driver, myXpath2);
//		   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath2));
//		   Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
//		   Thread.sleep(700);
//		   MesFonctions.objet(driver, myXpath2).click();
//
//		   String myXpath3 = "//input[@id='cguCheckbox']";
//		   MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
//		   MesFonctions.objet(driver, myXpath3).click();
		   /*
		    * partie à revoir du fait de la nouvelle RG d'acceptation des CGU
		    */
		   
		   //Valider (suivant)
		   String myXpath4 = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		   MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		   MesFonctions.goToDown(driver, myXpath4);
		   Thread.sleep(700);
		   MesFonctions.objet(driver, myXpath4).click();
		   System.out.println("Accès à la page suivante : "+MesFonctions.extractCurrentHeure());
		   
		   return null;
	   }
	  	
	  	public static String conditionsGeneralesTrc(WebDriver driver) throws Throwable {
	  	//Validation des CGU
	    String myXpath = "//strong[contains(text(),\"générales d'utilisation\")]";
	    boolean verif = false;
			   if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				   //Acceptation des CGU
				   myXpath = "//input[@id='flexCheckDefault']";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.goToDown(driver, myXpath);
				   Thread.sleep(500);
				   MesFonctions.objet(driver, myXpath).click();
				   System.out.println("La coche a été cochée....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
				    
				   //Validation Status
				   myXpath = "//button//span[contains(text(),\"Accepter et créer mon compte\")]";
				   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				   MesFonctions.goToDown(driver, myXpath);
				   Thread.sleep(500);
				   MesFonctions.objet(driver, myXpath).click();
				   System.out.println("Les CGU ont été validés....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r"); 	   
			   }
			 
			 //Valider (suivant)
			   String myXpath4 = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
			   MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
			   MesFonctions.goToDown(driver, myXpath4);
			   Thread.sleep(700);
			   MesFonctions.objet(driver, myXpath4).click();
			   System.out.println("Accès à la page suivante : "+MesFonctions.extractCurrentHeure());
			   
			   return null;
		   }
	  	
	  	public static String boutonAccueilTrc(WebDriver driver) throws InterruptedException {
	  		//Accès à l'accueil 
	  		String myXpath = "//a[@class='nav-link']/span[contains(text(),'Accueil')]";
	  		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	  		MesFonctions.goToUp(driver, myXpath);
	  		Thread.sleep(800);
	  		MesFonctions.objet(driver,myXpath).click();
	  		
	  		System.out.println("Accès à l'accueil......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	  		return null;
	  	}
	  	
	  	
	  	public static String repriseBrouillonTRC (WebDriver driver, String etape) throws Throwable {
			   
		    //Poursuivre le dépôt de la requête
	  		boolean verif = false;
	  		 String myXpath0 = "//span[contains(text(),\"nouvelle requête\")]";
		     MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
		     String myXpath ="(//p)[2]";
			 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 System.out.println("Date du dernier BROUILLON : "+MesFonctions.objet(driver, myXpath).getText());
		     myXpath = "//span[contains(text(),\"Reprendre mon brouillon\")]";
		     MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		     MesFonctions.objet(driver, myXpath0).click();
		   
   		    //vérification s'il y a un brouillon en cours (ne pas l'utiliser)
		    if(!MesFonctions.isElementPresent(driver, myXpath, verif)) {
			   Thread.sleep(100);
			   System.err.println("Il n'y a aucun brouillon présent "+MesFonctions.extractCurrentHeure()+"\r");
			   
		    }else {
			   MesFonctions.objet(driver, myXpath).click();
			   String myXpath3 = "//li[contains(@class,'active')]/span";
			   MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
			   
				   if(etape.equals(MesFonctions.objet(driver, myXpath3).getText().trim())) {
					   System.out.println("Le brouillon a bien été repris et se trouve sur la page : "+MesFonctions.objet(driver, myXpath3).getText().trim()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   }
				   else {
					  System.err.println("Le brouillon n'a pas été bien conservé : "+MesFonctions.objet(driver, myXpath3).getText().trim());
					  System.out.println(MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   }
		   }
		   
		   return null;
	   }
	  	
	  	
	  	public static void repriseBrouillonTRC1 (WebDriver driver, String etape) throws Throwable {
			   
		    //Poursuivre le dépôt de la requête
	  		boolean verif = false;
		    String myXpath0 = "//span[contains(text(),\"nouvelle requête\")]";
		    MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
		    String myXpath ="(//p)[2]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Date du dernier BROUILLON : "+MesFonctions.objet(driver, myXpath).getText());
		    myXpath = "//span[contains(text(),\"Reprendre mon brouillon\")]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.objet(driver, myXpath0).click();
		   
   		    //vérification s'il y a un brouillon en cours (ne pas l'utiliser)
		    if(!MesFonctions.isElementPresent(driver, myXpath, verif)) {
			   Thread.sleep(100);
			   System.err.println("Il n'y a aucun brouillon présent "+MesFonctions.extractCurrentHeure()+"\r");
			   
		    }else {
			   MesFonctions.objet(driver, myXpath).click();
			   String myXpath3 = "//li[contains(@class,'active')]/span";
			   MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
			   
//			   String etape ="";
				   if(etape.equals(MesFonctions.objet(driver, myXpath3).getText().trim())) {
					   System.out.println("Le brouillon a bien été repris et se trouve sur la page : "+MesFonctions.objet(driver, myXpath3).getText().trim()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
  
				   }
				   else {
					  System.err.println("Le brouillon n'a pas été bien conservé : "+MesFonctions.objet(driver, myXpath3).getText().trim());
					  System.out.println(MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   }
		   }
	   }
	  	
	  	public static String enregistrerBrouillonTRC(WebDriver driver, String etape) throws InterruptedException {
	  		//Enregistrer le brouillon
	  		String myXpath = "//button//span[contains(text(),\"Enregistrer le brouillon\")]";
	  		String myXpath1 = "//li[contains(@class,'active')]/span";
//	  		String myXpath1 = "//li[@class='col active']/span//parent::li//preceding-sibling::li[position()<2]/span";
	  		
	  		//Sauvegarde du brouillon
	  		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	  		MesFonctions.goToDown(driver, myXpath);
	  		Thread.sleep(800);
	  		MesFonctions.objet(driver, myXpath).click();
	  		//Vérification de la sauvegarde
	  		myXpath = "//span[contains(text(),\"Votre brouillon a bien été sauvegardé, votre requête n'a pas été envoyée.\")]";
	  		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	  		System.out.println("Le brouillon a bien été enregistré "+MesFonctions.extractCurrentHeure());
	  		
	  		//Fermeture du toaster
	  		myXpath = "//button[@class='close']";
	  		MesFonctions.objet(driver,myXpath).click();
	  		System.out.println("Fermeture du toaster "+MesFonctions.extractCurrentHeure()+"\r");
	  		
	  		//Etape enregistrée
	  		MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
	  		etape = MesFonctions.objet(driver, myXpath1).getText().trim();
	  		System.out.println("Mémorisation de l'étape : "+etape);
	  		
	  		return etape;
	  	}
	  	
	  	public static String enregistrerBrouillonTRC1(WebDriver driver, String etape) throws InterruptedException {
	  		//Enregistrer le brouillon
	  		String myXpath = "//button//span[contains(text(),\"Enregistrer le brouillon\")]";
	  		String myXpath1 = "//li[contains(@class,'active')]/span";
//	  		String myXpath1 = "//li[@class='col active']/span//parent::li//preceding-sibling::li[position()<2]/span";
	  		
	  		//Sauvegarde du brouillon
	  		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	  		MesFonctions.goToDown(driver, myXpath);
	  		Thread.sleep(500);
	  		MesFonctions.objet(driver, myXpath).click();
	  		//Vérification de la sauvegarde
	  		myXpath = "//span[contains(text(),\"Votre brouillon a bien été sauvegardé, votre requête n'a pas été envoyée.\")]";
	  		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	  		System.out.println("Le brouillon a bien été enregistré "+MesFonctions.extractCurrentHeure());
	  		
	  		//Fermeture du toaster
	  		myXpath = "//button[@class='close']";
	  		MesFonctions.objet(driver,myXpath).click();
	  		System.out.println("Fermeture du toaster "+MesFonctions.extractCurrentHeure()+"\r");
	  		
	  	//Etape enregistrée
	  		MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
	  		etape = MesFonctions.objet(driver, myXpath1).getText().trim();
	  		System.out.println("Mémorisation de l'étape : "+etape);
	  		
	  		return etape;
	  		
	  	}
	  	
	  	public static void pagePrecedentTrc(WebDriver driver) throws InterruptedException {
	  		//retour à la page précédente
	  		String myXpath = "//button//span[contains(text(),\"Page précédente\")]";
	  		String myXpath1 = "//li[contains(@class,'active')]/span";
	  		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	  		MesFonctions.goToDown(driver, myXpath);
	  		Thread.sleep(800);
	  		MesFonctions.objet(driver, myXpath).click();
	  		
	  		System.out.println("Click bouton page précédente....."+MesFonctions.extractCurrentHeure());
	  		MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
	  		
	  		System.out.println("Accès à la page....."+MesFonctions.objet(driver, myXpath1).getText().trim());
	  	}
	   
	   	public static String lesTypesRecoursTrc (WebDriver driver, String recours, boolean verif) throws Throwable {
		   
			switch (recours) {
			case "seulRequerant":
				String myXpath = "//input[@id='radio-REQUERANT_SEUL']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				
				myXpath = "//input[@id='captcha-input']"; 
				if (MesFonctions.isElementPresent(driver, myXpath, verif) == false) {
					Thread.sleep(100);
				}else {System.out.println("Captcha présent; 15s pour le renseigner");
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
				Thread.sleep(15000);
				}
				Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
				 myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
				 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				 MesFonctions.goToDown(driver, myXpath);
				 MesFonctions.objet(driver, myXpath).click();
				
				break;
				
			case "autresRequerant":
				myXpath = "//input[@id='radio-COLLECTIVE']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).click();
				Thread.sleep(100);
				System.out.println("Le bouton radio \"Avec d'autres requérants\" a été cliqué...."+MesFonctions.extractCurrentHeure());
				
//				Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
				myXpath = "//span[contains(@class,'label') and (contains(text(),\"Ajouter un requérant\"))]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Le bouton \"Ajouter un requérant\" a été cliqué...."+MesFonctions.extractCurrentHeure());
				Thread.sleep(150);
				
				String myXpath12 = "(//select[@class])[1]";
				String myXpath13 = "(//select[@class])[2]";
				String myXpath14 = "(//select[@class])[3]";
				
				//Premier requérant
				String value = "Monsieur";
				MesFonctions.waiting2(driver, myXpath12, Duration.ofSeconds(3));
				MesFonctions.selection(driver, myXpath12, value);
//				Thread.sleep(1500);
				System.out.println("Civilité OK");
				
				value = "PHYSIQUE";
				MesFonctions.waiting2(driver, myXpath13, Duration.ofSeconds(3));
				MesFonctions.selection(driver, myXpath13, value);
//				Thread.sleep(1500);
				System.out.println("Personnalité juridique OK");
				
				String myXpath15 = "//input[@id='firstName']";
				MesFonctions.waiting2(driver, myXpath15, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath15).sendKeys("Samuel");
//				Thread.sleep(1000);
				System.out.println("Prénom OK");
				
				String myXpath16 = "//input[@id='lastName']";
				MesFonctions.waiting2(driver, myXpath16, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath16);
				MesFonctions.objet(driver,myXpath16).sendKeys("VOGOU");
//				Thread.sleep(1000);
				System.out.println("Nom OK");
				
				String myXpath17 = "//input[@id='adresse1']";
				MesFonctions.waiting2(driver, myXpath17, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath17);
				MesFonctions.objet(driver,myXpath17).sendKeys("78 rue Richelieu");
//				Thread.sleep(1000);
				System.out.println("Adresse_1 OK");
				
				String myXpath18 = "//input[@id='adresse2']";
				MesFonctions.waiting2(driver, myXpath18, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath18);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath18).sendKeys("Bâtiment 6");
				
				System.out.println("Adresse_2 OK");
				
				String myXpath19 = "//input[@id='adresse3']";
				MesFonctions.waiting2(driver, myXpath19, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath19).sendKeys("Porte 14");
				MesFonctions.goToDown(driver, myXpath19);
				Thread.sleep(400);
				System.out.println("Adresse_3 OK");
				
				String myXpath110 = "//input[@id='codePostal']";
				MesFonctions.waiting2(driver, myXpath110, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath110).sendKeys("75002");
				MesFonctions.goToDown(driver, myXpath110);
				Thread.sleep(400);
				System.out.println("Code postal OK");
				
				String myXpath111 = "//input[@id='ville']";
				MesFonctions.waiting2(driver, myXpath111, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath111);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath111).sendKeys("Paris");
				
				System.out.println("Ville OK");
				
				value = "France";
				MesFonctions.waiting2(driver, myXpath14, Duration.ofSeconds(3));
				MesFonctions.selection(driver, myXpath14, value);
				MesFonctions.goToDown(driver, myXpath14);
				Thread.sleep(400);
				System.out.println("Pays OK");
				
				String myXpath112 = "//button[@type='submit']//span[contains(@class,'label') and (contains(text(),\"Ajouter\"))]";
				MesFonctions.waiting2(driver, myXpath112, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath112);
				MesFonctions.objet(driver,myXpath112).click();
//				Thread.sleep(2000);
				System.out.println("Requérant ajouté......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				String myXpath122 = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Réinitialiser\"))]";
				MesFonctions.goToDown(driver, myXpath112);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath122).click();
//				Thread.sleep(1000);
				System.out.println("Premier formulaire renseigné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

				//Deuxième requérant
				value = "MORALE";
				MesFonctions.waiting2(driver, myXpath13, Duration.ofSeconds(3));
				MesFonctions.selection(driver, myXpath13, value);
//				Thread.sleep(1500);
				System.out.println("Personnalité juridique OK");
				
				value = "Madame la directrice";
				MesFonctions.waiting2(driver, myXpath12, Duration.ofSeconds(3));
				MesFonctions.selection(driver, myXpath12, value);
//				Thread.sleep(1500);
				System.out.println("Civilité OK");
				
				String myXpath113 = "//input[@id='nomEntreprise']";
				MesFonctions.waiting2(driver, myXpath113, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath113).sendKeys("Cabinet bonne comptabilité SAS");
//				Thread.sleep(1000);
				System.out.println("Raison sociale OK");
				
				MesFonctions.waiting2(driver, myXpath15, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath15).sendKeys("Lindsay");
//				Thread.sleep(1000);
				System.out.println("Prénom OK");
				
				MesFonctions.waiting2(driver, myXpath16, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath16).sendKeys("ELISABETH");
//				Thread.sleep(1000);
				System.out.println("Nom OK");
				
				MesFonctions.waiting2(driver, myXpath17, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath17);
				MesFonctions.objet(driver, myXpath17).sendKeys("12 allée de l'Arche ");
//				Thread.sleep(1000);
				System.out.println("Adresse_1 OK");
				
				MesFonctions.waiting2(driver, myXpath18, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath18);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath18).sendKeys("Bâtiment 6");
				System.out.println("Adresse_2 OK");
				
				MesFonctions.waiting2(driver, myXpath19, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath19);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath19).sendKeys("Porte 14");
				
				System.out.println("Adresse_3 OK");
				
				MesFonctions.waiting2(driver, myXpath110, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath110);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath110).sendKeys("92800");
//				Thread.sleep(1000);
				System.out.println("CP OK");
				
				MesFonctions.waiting2(driver, myXpath111, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath111);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath111).sendKeys("Puteaux");
//				Thread.sleep(1000);
				System.out.println("Ville OK");
				
				value = "France";
				MesFonctions.waiting2(driver, myXpath14, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath14);
				Thread.sleep(400);
				MesFonctions.selection(driver, myXpath14, value);
//				Thread.sleep(1500);
				System.out.println("Pays OK");
				
				MesFonctions.waiting2(driver, myXpath112, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath112);
				MesFonctions.objet(driver,myXpath112).click();
//				Thread.sleep(1200);
				
				myXpath  = "//input[@id='captcha-input']"; 
				if (MesFonctions.isElementPresent(driver, myXpath, verif) == false) {
					Thread.sleep(1000);
				}else {System.out.println("Captcha présent; 15s pour le renseigner......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath));
				Thread.sleep(15000);
				}
				
				myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Formulaires des requérants renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\rAjout d'un autre formulaire....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
				
				break;

			case "mandataire":
				
				String mail = "";
				String nom = "";
				String prenom = "";
				if(driver.getCurrentUrl().contains("recette")) {
					mail = "jacob@yopmail.com";
					nom = "Eliouch";
					prenom = "Jacob";
				}
				else {
					mail = "balt@yopmail.com";
					nom = "Balt";
					prenom = "Lucien";
				}
				
				String myXpath2 = "//input[@id='radio-AVEC_MANDATAIRE']";
				MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath2);
				Thread.sleep(400);
				MesFonctions.objet(driver, myXpath2).click();
				System.out.println("Choix du type de dépôt \"Mandataire\"......"+MesFonctions.extractCurrentHeure());
//				Thread.sleep(2000);
				
				myXpath = "//button//span[contains(text(),\"Ajouter un requérant\")]";//span[contains(text(),'Ajouter un requérant')]//parent::button ; //button//span[contains(text(),"Ajouter un requérant")]
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath);
				Thread.sleep(400);
				MesFonctions.objet(driver, myXpath).click();
				System.out.println("Click bouton \"Ajout d'un requérant\"......"+MesFonctions.extractCurrentHeure());
//				Thread.sleep(1000);
				
				myXpath15 = "//input[@id='firstName']";
				MesFonctions.waiting2(driver, myXpath15, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath15);
				Thread.sleep(400);
				MesFonctions.objet(driver, myXpath15).sendKeys(prenom);
				System.out.println("Le prénom est renseigné......"+MesFonctions.extractCurrentHeure());
//				Thread.sleep(1000);
				
				myXpath16 = "//input[@id='lastName']";
				MesFonctions.waiting2(driver, myXpath16, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath16).sendKeys(nom);
				System.out.println("Le nom est renseigné......"+MesFonctions.extractCurrentHeure());
//				Thread.sleep(1000);
				
				String myXpath20 = "//input[@id='email']";
				MesFonctions.waiting2(driver, myXpath20, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath20).sendKeys(mail);
				System.out.println("L'email est renseigné......"+MesFonctions.extractCurrentHeure());
//				Thread.sleep(1000);
				
				String myXpath212 = "//button[@type='submit']//span[contains(@class,'label') and (contains(text(),\"Rechercher\"))]";
				MesFonctions.waiting2(driver, myXpath212, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath212);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath212).click();
				System.out.println("Click bouton \"Rechercher\"......"+MesFonctions.extractCurrentHeure());
//				Thread.sleep(2000);
				
				String myXpath21 = "//button[@title='Ajouter ce requérant']";
				MesFonctions.waiting2(driver, myXpath21, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath21);
				Thread.sleep(400);
				MesFonctions.objet(driver,myXpath21).click();
				System.out.println("Validdation - Ajout du requérant......"+MesFonctions.extractCurrentHeure()+"\r");
				Thread.sleep(1000);
				
				myXpath = "//input[@id='captcha-input']"; 
				if (MesFonctions.isElementPresent(driver, myXpath, verif) == false) {
					Thread.sleep(100);
				}else {System.out.println("Captcha présent; 15s pour le renseigner");
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
				Thread.sleep(15000);
				}
				
				myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.goToDown(driver, myXpath);
				Thread.sleep(400);
				MesFonctions.objet(driver, myXpath).click();
				
				break;

			default:
				System.err.println("ERROR !!!");
				break;
			}
		   
			return recours;
	   }
	   
	 //Fonction d'entrée d'annuaire SKIPPER
 		public static  boolean rattachement (WebDriver driver, boolean verif, String acteur) throws Throwable {
 			String myXpath = "//a[@id='btnCreerRattachement']/span[2]";
 			
 			
 		if (MesFonctions.isElementPresent(driver, myXpath, verif) == false) {
 			Thread.sleep(1000);
 			return verif;
 		}else {
 			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).click();
 			Thread.sleep(1000);
 			String childWindow = MesFonctions.childWindow(driver);
 			Thread.sleep(1000);
 			driver.switchTo().window(childWindow);
 			System.out.println("Accès à la fenêtre de rattachement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
 			
 			myXpath = "//input[@id='searchNom']";
 			driver.findElement(By.xpath(myXpath)).sendKeys(acteur);
 			System.out.println("Nom "+acteur);
 			Thread.sleep(1000);
 			driver.findElement(By.xpath("//input[@value='Rechercher']")).click();
 			Thread.sleep(1000);
 			System.out.println("Recherche "+acteur+" en cours......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
 			
 			boolean boolSearch = false ;
 			
 			if (boolSearch == true) {
 				try {
 					driver.findElement(By.xpath("//td[text()='Aucun résultat trouvé pour cette recherche.']"))
 							.isDisplayed();
 					System.out.println(boolSearch);
 				} catch (NoSuchElementException s) {
 					driver.findElement(By.xpath("//input[@name='cbxSel']")).click();
 					driver.findElement(By.xpath("//input[@id='btRattacher']")).click();
 					MesFonctions.transitWindow(driver, 1);
 				}
 			}else {
 				driver.findElement(By.xpath("//input[@id='btCreerEntreeSkipper']")).click();
//	 				Alert alert = driver.switchTo().alert();
//	 				alert.accept();
 				Thread.sleep(1000);
 				MesFonctions.transitWindow(driver, 1);
 				Thread.sleep(1000);
 				}
 		return boolSearch;
 			}
 		}
 		
 		public static String juridictionTATRC(WebDriver driver) throws Throwable {
		    //choix de la juridiction
		    String myXpath = "//label[@for='radio-TA' and(contains(text(),\"Tribunal administratif\"))]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(300);
		    MesFonctions.objet(driver,  myXpath).click();
//		    Thread.sleep(1000);
		    System.out.println("Choix de juridition : TA....."+MesFonctions.extractCurrentHeure());
		   
		    //choix de la juridiction de dépôt
		    myXpath = "//select[@id='site-juridiction-id']";
		    String value = "1";
//		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(300);
		    MesFonctions.selection(driver, myXpath, value);
//		    Thread.sleep(1500);
		    System.out.println("Tribunal administratif de "+MesFonctions.objet(driver, "//option[@value='"+value+"']").getText().trim());
		   
		    myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(500);
		    MesFonctions.objet(driver,  myXpath).click();
 			
 			return null;
 		}
 		
 		public static String juridictionCAATRC(WebDriver driver) throws Throwable {
		    //choix de la juridiction
		    String myXpath = "//label[@for='radio-CAA' and(contains(text(),\"Cour administrative\"))]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(300);
		    MesFonctions.objet(driver,  myXpath).click();
//		    Thread.sleep(1000);
		    System.out.println("Choix de juridition : CA......"+MesFonctions.extractCurrentHeure());
		   
		    //choix de la juridiction de dépôt
		    myXpath = "//select[@id='site-juridiction-id']";
		    String value = "5";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(300);
		    MesFonctions.selection(driver, myXpath, value);
//		    Thread.sleep(1500);
		    System.out.println("Cour administrative de "+MesFonctions.objet(driver, "//option[@value='"+value+"']").getText().trim());
		   
		    //choix du type d'acte attaqué
		    myXpath = "//select[@id='type-acte-attaque-id']";
		    value = "AUTRES";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(300);
		    MesFonctions.selection(driver, myXpath, value);
		    System.out.println("Acte attaqué : AUTRES");
//		    Thread.sleep(1000);
		   
		    myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(500);
		    MesFonctions.objet(driver,  myXpath).click();
			    
			return null;
 		}
 		
 		public static String juridictionCTXTRC(WebDriver driver) throws Throwable {
 			//choix du niveau juridiction
			String myXpath = "//label[@for='radio-CE' and(contains(text(),\"Conseil\"))]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath);
			Thread.sleep(500);
			MesFonctions.objet(driver,  myXpath).click();
//			Thread.sleep(1000);
			System.out.println("Choix de juridition : CE......"+MesFonctions.extractCurrentHeure());
			   
			myXpath = "//button[@type]//span[contains(text(),'Page suivante - Requête')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    Thread.sleep(500);
			MesFonctions.objet(driver,  myXpath).click();
 			return null;
 		}
 		
 		public static String choixUrgenceTATRC(WebDriver driver, String value, String scenario) throws Throwable {
 			//Votre requête concerne-t-elle un contentieux social ? 
 			String myXpath = "//select[@id='appeal-subject-id']";
	   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	   		MesFonctions.goToDown(driver, myXpath);
	   		Thread.sleep(300);
	   		MesFonctions.selection(driver, myXpath, value);
	   		
	   		myXpath = "//select[@id='appeal-subject-id']//option[contains(@value,'"+value+"')]";
	   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	   		String myValue = MesFonctions.objet(driver, myXpath).getText();
	   		System.out.println(myValue+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
 			
		    //choix du type de requête
	   		String txt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc a condimentum arcu. Mauris orci odio, vulputate ac mi id, convallis dapibus nulla. "
	   				+ "Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas egestas erat et faucibus egestas. Duis rhoncus orci in risus fringilla, quis aliquet dui efficitur. "
	   				+ "Etiam tincidunt erat lacinia faucibus vulputate. Phasellus ultricies fermentum consequat. Mauris vestibulum purus in sodales pharetra. "
	   				+ "Nunc consequat scelerisque urna nec malesuada. Etiam porttitor mauris non mi vehicula luctus.\r\n"
	   				+ "\r\n"
	   				+ "Nullam in lectus nibh. Duis consequat neque nec arcu sollicitudin consequat. "
	   				+ "Ut sit amet ligula vitae metus sollicitudin vestibulum nec et diam. Nullam rutrum enim nec consequat ultrices. Phasellus vel laoreet orci, sit amet placerat felis. "
	   				+ "Nunc eget dapibus nisi. Nunc rutrum lectus eu elit tincidunt rhoncus tempus nec mi. Donec non ultrices odio. Cras vel finibus justo. "
	   				+ "Phasellus ultrices, erat in luctus mattis, dolor quam venenatis libero, nec semper velit mi id arcu. Etiam eu ornare velit.\r\n"
	   				+ "\r\n"
	   				+ "Cras vel neque eget ante convallis elementum eu a est. Morbi id posuere risus. Sed rhoncus congue sapien, nec lacinia dolor porttitor non. Suspendisse ullamcorper risus ut turpis vehicula, at placerat dolor auctor. "
	   				+ "Maecenas at augue tortor. Nulla sed elit vitae dui hendrerit gravida. Nulla ut ipsum hendrerit nulla pharetra tempus non vitae massa. Sed placerat nisi erat, eget ultricies lorem eleifend fringilla. "
	   				+ "Ut purus quam, gravida eu lectus id, convallis finibus erat. Sed at lobortis libero, nec sodales elit. Vivamus malesuada accumsan nisl, ut aliquam sapien venenatis eget.\r\n"
	   				+ "\r\n"
	   				+ "Proin ornare massa ac metus sodales, ac dapibus eros efficitur. Aliquam varius pharetra enim, sed faucibus purus sollicitudin eget. Mauris non erat id diam fringilla egestas nec at nibh. "
	   				+ "Nam ullamcorper dui libero, eget faucibus ligula volutpat in. Proin sagittis malesuada diam, quis luctus purus faucibus vel. Donec mattis, magna sed vestibulum pellentesque, enim eros eleifend sapien, at rutrum ante enim vitae nisl. "
	   				+ "Quisque risus dui, finibus non elit vitae, tincidunt pulvinar felis. Vivamus eu urna eget nisi tristique faucibus quis consequat tortor. Pellentesque ut faucibus odio, vitae laoreet est. "
	   				+ "Nulla cursus, magna non eleifend malesuada, ligula eros ultricies tellus, non varius ex mi sed felis.\r\n"
	   				+ "\r\n"
	   				+ "Vivamus eu pulvinar sapien. Sed neque risus, convallis a sapien non, imperdiet condimentum mi. Fusce volutpat, diam quis viverra tincidunt, "
	   				+ "purus neque tincidunt quam, at porttitor nisi magna eget arcu. Proin et eros eget nunc fringilla tempus ac a felis. Aliquam id turpis sed lorem hendrerit vestibulum. "
	   				+ "Mauris vestibulum neque venenatis metus varius semper. Proin fermentum in quam at blandit. Etiam imperdiet nulla a nulla pharetra pellentesque.";
		    
		    if(myValue.contains("Autre")) {
		    	myXpath = "//select[@id='urgence-requete-id']";
		    	value = "1";
		    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			    MesFonctions.goToDown(driver, myXpath);
			    Thread.sleep(300);
			    MesFonctions.selection(driver, myXpath, value);
			    myXpath = "//select[@id='urgence-requete-id']//option[@value='1']";
			    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			    System.out.println(MesFonctions.objet(driver, myXpath).getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
		    		}else if(myValue.contains("DALO") && scenario.equals("1")) {
			    	value = "4";
		    		myXpath = "//input[@id='radio-situation "+value+"']";
			    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				    MesFonctions.goToDown(driver, myXpath);
				    Thread.sleep(300);
				    MesFonctions.objet(driver, myXpath).click();
				    System.out.println("le click a été fait sur l'option  : "+MesFonctions.objet(driver, myXpath).getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			    
		    			}else if(myValue.contains("DALO") && scenario.equals("2")) {
		    				//Choix du bouton radio
		    				value = "1";
				    		myXpath = "//input[@id='radio-situation "+value+"']";
					    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).click();
						    System.out.println("le click a été fait sur l'option  : "+MesFonctions.objet(driver, myXpath).getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						    
						    //Remplissage des différent champs
						    myXpath = "//input[@id='existed-appeal-no']";
						    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).sendKeys("Lorem ipsum dolor sit amet : 2403457/PLR90765 - A9");
						    System.out.println("Champ 1 renseigné....."+MesFonctions.extractCurrentHeure());
						    
						    myXpath = "//input[@id='commission-name']";           
						    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit Nunc condimentum arcu. Mauris orci odio, vulputate ac mi id, convallis dapibus nulla.\rCommission de médiation du Val-De-Marne/Commission de médiation du Val-D'Oise");
						    System.out.println("Champ 2 renseigné....."+MesFonctions.extractCurrentHeure());
						    
						    myXpath = "//input[@id='has-decision']";           
						    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).click();
						    System.out.println("Champ 3 renseigné....."+MesFonctions.extractCurrentHeure());
						    
						    myXpath = "//input[@id='has-decision']//following-sibling::label";
						    if(MesFonctions.objet(driver, myXpath).getText().contains("Oui")) {
						    	myXpath = "//input[@id='decisionFile']";
//						    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
							    MesFonctions.goToDown(driver, myXpath);
							    Thread.sleep(300);
							    MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\001 Decision commission de mediation.pdf");
							    System.out.println("Le fichier de la décision de la commission a été ajouté ......"+MesFonctions.extractCurrentHeure());
							    
						    }else {
						    	myXpath = "//textarea[@id='reason-no-decision']";
						    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
							    MesFonctions.goToDown(driver, myXpath);
							    Thread.sleep(300);
							    MesFonctions.objet(driver, myXpath).sendKeys(txt);
							    System.out.println("Justification de l'absence de la décision ajoutée....."+MesFonctions.extractCurrentHeure());
						    }
						    
						    myXpath = "//textarea[@id='family-situation']";           
						    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).sendKeys(txt);
						    System.out.println("Champ 4 renseigné....."+MesFonctions.extractCurrentHeure()+"\r");
						    
						    for(int i=1;i<6; i++) {
						    	myXpath = "//input[contains(@id,'piece-family-situation-adder')]";
//						    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
							    MesFonctions.goToDown(driver, myXpath);
							    Thread.sleep(300);
							    MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\TestTRC\\PJ000"+i+" pièces"+i+".pdf");
							    System.out.println("La pièce "+i+" a été ajoutée......"+MesFonctions.extractCurrentHeure());
							    myXpath = "//input[@aria-describedby='error-msg-family-situation-file' and contains(@class,'invalid')]";
							    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
							    MesFonctions.goToDown(driver, myXpath);
							    Thread.sleep(300);
							    MesFonctions.objet(driver, myXpath).sendKeys("Pièce "+i);
							    System.out.println("La pièce "+i+" a été nommée......"+MesFonctions.extractCurrentHeure());
						    }
						    
						    myXpath = "//textarea[@id='actual-accommodation-pb']";           
						    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).sendKeys(txt);
						    System.out.println("Champ 5 renseigné....."+MesFonctions.extractCurrentHeure());
						    
						    myXpath = "//textarea[@id='no-access-reason']";           
						    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).sendKeys(txt);
						    System.out.println("Champ 6 renseigné....."+MesFonctions.extractCurrentHeure());
						    
						    myXpath = "//textarea[@id='other-details']";           
						    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						    MesFonctions.goToDown(driver, myXpath);
						    Thread.sleep(300);
						    MesFonctions.objet(driver, myXpath).sendKeys(txt);
						    System.out.println("Champ 7 renseigné....."+MesFonctions.extractCurrentHeure());  
		    				
		    					}else if(myValue.contains("DALO") && scenario.equals("3")) {
		    						//Choix du bouton radio
		    						value = "2";
						    		myXpath = "//input[@id='radio-situation "+value+"']";
							    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).click();
								    System.out.println("le click a été fait sur l'option  : "+MesFonctions.objet(driver, myXpath).getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
								    
								    //Remplissage des différent champs
								    myXpath = "//input[@id='existed-appeal-no']";
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).sendKeys("Lorem ipsum dolor sit amet : 2403457/PLR90765 - A9");
								    System.out.println("Champ 1 renseigné....."+MesFonctions.extractCurrentHeure());
								    
								    myXpath = "//input[@id='commission-name']";           
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit Nunc condimentum arcu. Mauris orci odio, vulputate ac mi id, convallis dapibus nulla.\rCommission de médiation du Val-De-Marne/Commission de médiation du Val-D'Oise");
								    System.out.println("Champ 2 renseigné....."+MesFonctions.extractCurrentHeure());
								    
								    myXpath = "//input[@id='has-decision']";           
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).click();
								    System.out.println("La check box \"Oui\" est sélectionnée....."+MesFonctions.extractCurrentHeure());
								    
								    myXpath = "//input[@id='has-decision']//following-sibling::label";
								    if(MesFonctions.objet(driver, myXpath).getText().contains("Oui")) {
								    	for(int i=0;i<6;i++) {
								    		myXpath = "//input[contains(@id,'acte-attaque-document-"+i+"1')]";
//									    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
										    MesFonctions.goToDown(driver, myXpath);
										    Thread.sleep(600);
										    int j = i+1;
										    MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\TestTRC\\Acte attaque_"+j+".pdf");
										    System.out.println("Le fichier de la décision de la commission a été ajouté ......"+MesFonctions.extractCurrentHeure());
								    		}
								    }else {
								    	myXpath = "//textarea[@id='reason-no-decision']";
								    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									    MesFonctions.goToDown(driver, myXpath);
									    Thread.sleep(300);
									    MesFonctions.objet(driver, myXpath).sendKeys(txt);
									    System.out.println("Justification de l'absence de la décision ajoutée....."+MesFonctions.extractCurrentHeure());
								    	}
								    
								    myXpath = "//input[contains(@id,'decisionDate')]";           
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).sendKeys("30/11/2024");
								    System.out.println("La première date est renseignée....."+MesFonctions.extractCurrentHeure()+"\r");
								    
								    myXpath = "//input[contains(@id,'firstApplicationDate')]";           
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).sendKeys("06/04/2019");
								    System.out.println("La deuxième date est renseignée....."+MesFonctions.extractCurrentHeure()+"\r");
								    
								    myXpath = "//textarea[@id='family-situation']";           
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).sendKeys(txt);
								    System.out.println("Champ 3 renseigné....."+MesFonctions.extractCurrentHeure()+"\r");
								    
								    for(int i=1;i<6; i++) {
								    	myXpath = "//input[contains(@id,'piece-family-situation-adder')]";
//								    	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									    MesFonctions.goToDown(driver, myXpath);
									    Thread.sleep(500);
									    MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\TestTRC\\PJ000"+i+" pièces"+i+".pdf");
									    System.out.println("La pièce "+i+" a été ajoutée......"+MesFonctions.extractCurrentHeure());
									    myXpath = "//input[@aria-describedby='error-msg-family-situation-file' and contains(@class,'invalid')]";
									    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									    MesFonctions.goToDown(driver, myXpath);
									    Thread.sleep(500);
									    MesFonctions.objet(driver, myXpath).sendKeys("Pièce "+i);
									    System.out.println("La pièce "+i+" a été nommée......"+MesFonctions.extractCurrentHeure());
								    	}
								    
								    myXpath = "//textarea[@id='actual-accommodation-pb']";           
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).sendKeys(txt);
								    System.out.println("Champ 4 renseigné....."+MesFonctions.extractCurrentHeure());
								    
								    List<String> fichiers = new ArrayList<>();
								    fichiers.add("002 Demande de logement ICADE");
								    fichiers.add("002 Demande de logement 3F");
								    fichiers.add("002 Demande de logement VALOPHIS");
								    fichiers.add("002 Demande de logement VILOGIA");
								    fichiers.add("002 Demande de logement DOMNIS");
								    fichiers.add("002 Demande de logement IN'LI");
								    for(int i=0;i<6;i++) {
								    myXpath = "//input[contains(@id,'piece-accommodation-adder-"+i+"1')]";           
//								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(500);
								    MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\"+fichiers.get(i)+".pdf");
								    System.out.println("le fichier : "+fichiers.get(i)+" a été téléchargé....."+MesFonctions.extractCurrentHeure());
								    myXpath = "//input[@aria-describedby='error-msg-accommodation-file' and contains(@class,'invalid')]";
								    int j = i+1;
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(500);
								    MesFonctions.objet(driver, myXpath).sendKeys(fichiers.get(i)+"_Pièce_"+j);
								    System.out.println("La pièce "+i+" a été nommée......"+MesFonctions.extractCurrentHeure());
								    	}
								    
								    myXpath = "//textarea[@id='illigalized-decision-reason']";           
								    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
								    MesFonctions.goToDown(driver, myXpath);
								    Thread.sleep(300);
								    MesFonctions.objet(driver, myXpath).sendKeys(txt);
								    System.out.println("Champ 5 renseigné....."+MesFonctions.extractCurrentHeure());
								    
		    						}
		    
		    //Valider (suivant)
		    myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
//	   		Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
	   		Thread.sleep(300);
		    MesFonctions.objet(driver, myXpath).click();
		    System.out.println("Click bouton \"Suivant\"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
 			return null;
 		}
 		
 		public static String choixUrgenceCAATRC(WebDriver driver) throws Throwable {
 			//choix du type de requête
		    String myXpath = "//select[@id='urgence-requete-id']";
		    String value = "7";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
		    MesFonctions.selection(driver, myXpath, value);
		    System.out.println("Une procédure normale......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
//		    Thread.sleep(1000);
		    
		    /*
		     * non présent dans la nouvelle version TRCmig
		     */
//		    //Votre requête concerne-t-elle un contentieux social ? 
//	   		myXpath = "//input[@id='csr-non']";
//	   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	   		MesFonctions.goToDown(driver, myXpath);
//	   		Thread.sleep(300);
//	   		MesFonctions.objet(driver,  myXpath).click();
//	   		System.out.println("La requête concerne un contentieux social......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   
		    //Valider (suivant)
		    myXpath = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.goToDown(driver, myXpath);
	   		Thread.sleep(300);
//	   		Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
//	   		Thread.sleep(100);
		    MesFonctions.objet(driver, myXpath).click();
		
 			return null;
 		}
 		
 		public static String choixUrgenceCTXTRC(WebDriver driver) throws Throwable {
 			//choix du type de requête
		    String myXpath = "//select[@id='urgence-requete-id']";
		    String value = "5";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		    MesFonctions.selection(driver, myXpath, value);
		    System.out.println("Une procédure normale......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
//		    Thread.sleep(1000);
		    
//		    //Votre requête concerne-t-elle un contentieux social ? 
//	   		myXpath = "//input[@id='csr-non']";
//	   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	   		MesFonctions.objet(driver,  myXpath).click();
//	   		System.out.println("La requête concerne un contentieux social......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		   
		    //Valider (suivant)
		    myXpath = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	   		Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
		    MesFonctions.goToDown(driver, myXpath);
	   		Thread.sleep(300);
		    MesFonctions.objet(driver, myXpath).click();
		
 			return null;
 		}
 		
 		public static String recapitulatifTRC(WebDriver driver) throws Throwable {
 		   //Récapitulation de l'envoi
		   String myXpath = "//input[@id='requeteAbusifCheckbox']//following-sibling::label";
		   MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		   MesFonctions.goToDown(driver, myXpath);
   		   Thread.sleep(300);
		   MicroFonctions.recapDepotReqTrc(driver);
		   System.out.println("Vérification réalisée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");	
 		return null;
 		}
 		
 		
 		public static String choixJuridictionTA (WebDriver driver) throws Throwable {
 			// Choix de la juridiction
 			String myXpath = "//a[text()='TA Paris']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Page de choix de juridiction....."+MesFonctions.extractCurrentHeure());
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("La juridiction a été sélectionnée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//vérification de la page
			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau' and (contains (text(),\"Tribunal administratif de Paris\"))]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à la page d'accueil "+MesFonctions.objet(driver, myXpath).getText()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
 			
 			return null;
 		}
 		
 		public static String choixJuridictionCAA (WebDriver driver) throws Throwable {
 			// Choix de la juridiction
 			String myXpath = "//a[text()='CAA Paris']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Page de choix de juridiction");
			MesFonctions.objet(driver,myXpath).click();
			//vérification de la page
			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau' and (contains (text(),\"Cour administrative d'appel de Paris\"))]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println(MesFonctions.objet(driver, myXpath).getText());
			Thread.sleep(200);

 			return null;
 		}
 		
 		public static String choixJuridcitionCE (WebDriver driver) throws Throwable {
 			//Choix de juridiction CE et Vérification de la page
 			String myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println(MesFonctions.objet(driver, myXpath).getText());
 			Thread.sleep(300);
 			return null;
 		}
 		
 		public static String accesDepotDoc(WebDriver driver) throws Throwable {
 			// Onglet Document
			
			String myXpath = "//td[@id='Entete1_MenuActeur1_im1_AD']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(200);
 			
 			return null;
 		}
 		
 		public static String accesEnrDoc(WebDriver driver, String choixJur, String dossier) throws Throwable {
 		// Enregistrer le document
			String myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.verifyPresenceOfElement(driver, myXpath, choixJur);
			System.out.println(MesFonctions.objet(driver,myXpath).getText().trim()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
			
			myXpath = "//a[@class='numDossier' and (text()='" + dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(200);
			
			MesFonctions.objet(driver,myXpath).click();
			
			myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
			String caractSpec = " ";
			String strg = MesFonctions.leNom(driver, myXpath, caractSpec);
			int fin = strg.indexOf(strg.split(" ")[2]);
			String acteur = strg.substring(0, fin).trim();
			System.out.println(acteur);
 			
 			return acteur;
 		}
 		
 		public static String accesDepotReq(WebDriver driver, String choixJur) throws Throwable {
 			// Onglet requête 
 			String myXpath ="//td[@id='Entete1_MenuActeur1_im1_AB']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Accès onglet \"Requêtes\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
 			
 			return null;
 		}
 		
 		public static String accesEnregReq(WebDriver driver, String choixJur, String dossier ) throws Throwable {
 			// Onglet requête + click sur le num de la req
			String myXpath = "//td[@id='Entete1_MenuActeur1_im1_AC']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			driver.findElement(By.xpath(myXpath)).click();
			System.out.println("Accès à l'onglet requête....."+MesFonctions.extractCurrentHeure());
			
			myXpath = "//a[@class='numDossier' and (text()='" + dossier + "')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			driver.findElement(By.xpath(myXpath)).click();
			System.out.println("Accès au dossier : "+dossier+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//vérifier le numéro du dossier
			myXpath = "//span[@id='lblTRC']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.verifyPresenceOfElement(driver, myXpath, dossier);
			
//				String numDos = mesFonctions.objet(driver,myXpath).getText();
//				Thread.sleep(1000);
//				
//				if(!dossier.equals(numDos)) {
//					System.err.println("Le dossier n'est pas le bon");
//				}
			Thread.sleep(200);
				
				return null;
	 		}
				
		public static String formaterNomActeur(WebDriver driver) throws Throwable {
				//Formater nom auteur
				String myXpath = "//td[contains(text(),\"Déposé sur Télérecours par\")]//following-sibling::td";
				String nom = driver.findElement(By.xpath(myXpath)).getText().trim().replaceAll("\n", " ");
				System.out.println(nom);
				
				int deb = nom.indexOf(nom.split(" ")[1]);
				int fin = nom.indexOf(nom.split(" ")[2]);
				String acteur = nom.substring(deb, fin).trim();
				System.out.println(acteur);
				
	 			return acteur;
	 		}
				
		public static String code_postal (WebDriver driver) throws Throwable {
				String myXpath = "//td[contains(text(),\"Déposé sur Télérecours par\")]//following-sibling::td/br[2]" ;
				String tr = MesFonctions.objet(driver,myXpath).getText();
				Thread.sleep(1000);
				String CP = tr.substring(0, tr.indexOf(" ")).trim();
				System.out.println(tr);
				
				return CP;
			}
	 		
 		public static String ajouterUnRequerant (WebDriver driver, String choixJur) throws Throwable {
 			switch (choixJur) {
			case "TA":
				//Click bouton Ajout d'un requérant
				String myXpath = "//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Click bouton Ajout d'un requérant....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				myXpath = "//select[@id='Mstr_cpMain_requerantCivilite']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				String value = "1";
				Thread.sleep(300);
				MesFonctions.selection(driver, myXpath, value);
				
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys("CHEVINOT");
				System.out.println("Le champ NOM a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys("Eliane");
				System.out.println("Le champ PRENOM a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys("12 avenue du 8 mai 1945");
				System.out.println("Le champ ADRESSE a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("75003");
				System.out.println("Le champ CP a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("PARIS");
				System.out.println("Le champ VILLE a été renseigné ....."+MesFonctions.extractCurrentHeure());
				
				// Valider
				myXpath = "//span[@class='ui-button-text' and text()='Ajouter']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Requérant ajouté......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				break;
				
			case "CAA":
				
				myXpath = "//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Click bouton Ajout d'un requérant....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				myXpath = "//select[@id='Mstr_cpMain_requerantCivilite']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				value = "1";
				Thread.sleep(200);
				MesFonctions.selection(driver, myXpath, value);
				
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys("ECHILE");
				System.out.println("Le champ NOM a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys("Sylvie");
				System.out.println("Le champ PRENOM a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys("12 rue des Chevaliers");
				System.out.println("Le champ ADRESSE a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("94500");
				System.out.println("Le champ CP a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("CHAMPIGNY-SUR-MARNE");
				System.out.println("Le champ VILLE a été renseigné ....."+MesFonctions.extractCurrentHeure());
				
				// Valider
				myXpath = "//span[@class='ui-button-text' and text()='Ajouter']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Requérant ajouté......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				break;
				
			case "CTX":
				
				myXpath = "//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Click bouton Ajout d'un requérant....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				myXpath = "//select[@id='Mstr_cpMain_requerantCivilite']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				value = "1";
				Thread.sleep(200);
				MesFonctions.selection(driver, myXpath, value);
				
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys("BRIVET");
				System.out.println("Le champ NOM a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys("Karine");
				System.out.println("Le champ PRENOM a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys("12 rue des Chevaliers");
				System.out.println("Le champ ADRESSE a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("75014");
				System.out.println("Le champ CP a été renseigné ....."+MesFonctions.extractCurrentHeure());
				driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("PARIS");
				System.out.println("Le champ VILLE a été renseigné ....."+MesFonctions.extractCurrentHeure());
				
				// Valider
				myXpath = "//span[@class='ui-button-text' and text()='Ajouter']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Requérant ajouté......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				break;

			default:
				break;
			}
		return null;
	}
 		
 		public static String choixMatiere (WebDriver driver, String value) throws Throwable{
 			
			String myXpath = "//select[@id='Mstr_cpMain_ddlMatiere']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.selection(driver, myXpath, value);
			
			myXpath = "//select[@id='Mstr_cpMain_ddlMatiere']//option[@value= '"+ value +"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String mat = MesFonctions.objet(driver,myXpath).getText();
			System.out.println("Matière ajoutée : "+mat);
 			
 			return mat;
 		}
 		
 		public static String choixUrgence (WebDriver driver) throws Throwable{
 			String myXpath = "//input[@id='Mstr_cpMain_RadioButtonUrgence_0']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(200);
			String urg = MesFonctions.objet(driver,myXpath).getDomAttribute("value");
			System.out.println("Urgence renseignée : "+urg);
			
			return urg;
 		}
 		
 		public static String choixUrgence1 (WebDriver driver, String value) throws Throwable{
 			String myXpath = "//input[@id='Mstr_cpMain_RadioButtonUrgence_1']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(200);
			String urg = MesFonctions.objet(driver,myXpath).getDomAttribute("value");//getAttribute();
			
			myXpath = "//select[@id='Mstr_cpMain_ddlUrgence' and @style='display: inline-block;']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.selection(driver, myXpath, value);
			
			myXpath = "//select[@id='Mstr_cpMain_ddlUrgence' and @style='display: inline-block;']//option[@value= '"+ value +"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String typeUrg = MesFonctions.objet(driver,myXpath).getText().toLowerCase();
			String urgType = urg+" ("+typeUrg+")" ;
			System.out.println("Urgence type renseignée : "+urgType);
			
			return urgType;
 		}
 		
 		public static String choixSaisine (WebDriver driver, String value) throws Throwable{
 			String myXpath = "//select[@id='Mstr_cpMain_ddlSaisine']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.selection(driver, myXpath, value);
			
			myXpath = "//select[@id='Mstr_cpMain_ddlSaisine']//option[@value= '"+ value +"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String sai = MesFonctions.objet(driver,myXpath).getText();
			System.out.println("Saisine renseigné : "+sai);
			Thread.sleep(200);
			
			return sai;
 		}
 		
 		public static String choixJuridiction (WebDriver driver, String value, String choixJur) throws Throwable{
 			boolean verif = choixJur.equals("CTX");
			if(verif==true) {
				String myXpath = "//select[@id='Mstr_cpMain_ddlAuteurDecAtt']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				Thread.sleep(200);
				MesFonctions.selection(driver, myXpath, value);
				Thread.sleep(200);
				myXpath = "//select[@id='Mstr_cpMain_ddlAuteurDecAtt']//option[@value= '"+ value +"']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				String jur = MesFonctions.objet(driver,myXpath).getText();
				System.out.println(jur+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				Thread.sleep(200);
				return jur;
			}
			else{
 			String myXpath = "//select[@id='Mstr_cpMain_ddlJuridictionsDecision']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.selection(driver, myXpath, value);
			
			myXpath = "//select[@id='Mstr_cpMain_ddlJuridictionsDecision']//option[@value= '"+ value +"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String jur = MesFonctions.objet(driver,myXpath).getText();
			System.out.println(jur+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			return jur;
			}
 		}
 		
 		public static int depotFilesReqTr_Dec(WebDriver driver) throws Throwable{
 			
 		// Décisison attaquée
 			String myXpath = "//input[@id='Mstr_cpMain_FileUploadDecAttq_fileUpload']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			//Insertion de la pièce
 			String resourceName = "1 Acte attaque.pdf";
 			MesFonctions.insertion_file(driver, myXpath, resourceName);
 			
 			myXpath = "//a[@id='Mstr_cpMain_FileUploadDecAttq_DlFileLink_hplFichier']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrMem = elements.size();
			System.out.println("Nombre de fichier(s), chargé(s) : "+nbrMem+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
 			
 			return nbrMem;
 		}
 		
 		public static int depotFilesReqTr_req (WebDriver driver) throws Throwable{
 			
 		// Requête
 			String myXpath = "//input[@id='Mstr_cpMain_FileUploadRequeteFichier_fileUpload']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			String name = "La requete.docx";
 			MesFonctions.insertion_file(driver, myXpath, name);
// 			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.docx");
 			
 			myXpath = "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrMem = elements.size();
			System.out.println("Nombre de fichier(s), chargé(s) : "+nbrMem+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
 			
 			return nbrMem;
 		}
 		
 		public static int depotFilesReqTr_pics (WebDriver driver) throws Throwable{
 			
 		// Pièces complémentaires
 			String myXpath = "//input[@id='fileupload']";
// 			mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			String name = "001 Lettre du prefet.pdf";
 			MesFonctions.insertion_file(driver, myXpath, name);
// 			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Lettre du prefet.pdf");
 			Thread.sleep(500);
 			name = "002 deliberation du conseil municipal.pdf";
 			MesFonctions.insertion_file(driver, myXpath, name);
// 			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 deliberation du conseil municipal.pdf");
 			Thread.sleep(500);
 			name = "003 extrait des annexes graphique du PLU.pdf";
 			MesFonctions.insertion_file(driver, myXpath, name);
// 			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 extrait des annexes graphique du PLU.pdf");
 			Thread.sleep(500);
 			name = "004 Copie de la demande de permis de construire.docx";
 			MesFonctions.insertion_file(driver, myXpath, name);
// 			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\4 Copie de la demande de permis de construire.docx");
 			
 			
 			myXpath = "//a[contains(@id,'fileLinkFichierPJRequete_hplFichier')]";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrMem = elements.size();
			System.out.println("Nombre de fichier(s), chargé(s) : "+nbrMem+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
	 			
	 			return nbrMem;
	 		}
 		
 		public static int depotFilesReqTr_JA (WebDriver driver) throws Throwable{
 			
 			// AJ
 			String myXpath = "//input[@id='Mstr_cpMain_FileUploadAideJur_fileUpload']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			String name  = "Aide_Juridictionnelle.pdf";
 			MesFonctions.insertion_file(driver, myXpath, name);
// 			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
 			
 			myXpath = "//a[@id='Mstr_cpMain_FileUploadAideJur_DlFileLink_hplFichier']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrMem = elements.size();
			System.out.println("Nombre de fichier(s), chargé(s) : "+nbrMem+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
	 			
	 			return nbrMem;
	 		}
 		
 		public static int depotFilesReqTr_inv (WebDriver driver) throws Throwable{
 			
	 		//Inventaire
 			String myXpath = "//input[@id='Mstr_cpMain_FileUploadInv_fileUpload']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			String name = "Inventaire manuel.pdf";
 			MesFonctions.insertion_file(driver, myXpath, name);
// 			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Inventaire manuel.pdf");
 			
 			myXpath = "//a[@id='Mstr_cpMain_FileUploadInv_DlFileLink_hplFichier']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrMem = elements.size();
			System.out.println("Nombre de fichier(s), chargé(s) : "+nbrMem+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
	 			
	 			return nbrMem;
		 		}
 		
 		public static String actInfoCourriel(WebDriver driver) throws Throwable {
	 		// information par courriel
	 		String myXpath = "//a[@id='Mstr_cpMain_ucContactDossier_personneCourrielAdd']/span[@class='button-text' and (text()='Ajouter')]";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			MesFonctions.objet(driver,myXpath).click();
 			Thread.sleep(100);

 			String onglet = MesFonctions.getWindow(driver, 2);
 			driver.switchTo().window(onglet);
 			myXpath = "//select[@id='ddlContactsASelectionner']/option";
 			Thread.sleep(300);

 			List<WebElement> qte = driver.findElements(By.xpath(myXpath));

 			int opt = qte.size();
 			boolean verif = opt > 0;
 			System.out.println(opt);
 			System.out.println(verif);
 			
 			if (verif == true) {
 				myXpath ="//select[@id='ddlContactsASelectionner']" ;
 				WebElement name = MesFonctions.objet(driver,myXpath);
 				Select select = new Select(name);
		
			 				for (int i = 1; i <= opt; i++) {
			 					select.selectByIndex(0);
			 					myXpath = "//input[@id='btnFlecheDroite']";
			 					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 					MesFonctions.objet(driver, myXpath).click();
			 					Thread.sleep(200);
			 					}
			 	myXpath = "//input[@id='btnValider']";
			 	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 	MesFonctions.objet(driver, myXpath).click();
 			} 
 			else {
 				myXpath = "//input[@id='btnAnnuler']";
 				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 				MesFonctions.objet(driver, myXpath).click();
 			}
 			Thread.sleep(200);
 			onglet = MesFonctions.getWindow(driver, 1);
 			driver.switchTo().window(onglet);
 			Thread.sleep(100);
 			myXpath = "//textarea[@id='Mstr_cpMain_txtCourrielsComplementaires']"; 
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			MesFonctions.objet(driver,myXpath).sendKeys("johan.agathine@conseil-etat.fr");
 			Thread.sleep(100);
 			
 			System.out.println("Personne(s) à informer par courriel renseignée......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
 			
 			return null;
 		}
 		
 		public static String saisirNumDossierDepoTr(WebDriver driver, String dossier) throws Throwable {
 			//choix du dossier
			String myXpath = "//input[@id='Mstr_cpMain_txtNumsaisi']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).sendKeys(dossier);
			
			myXpath= "//a[@id='Mstr_cpMain_btnRechercherDossier']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			
			myXpath = "//input[@id='Mstr_cpMain_txtNumDossier']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.verifyPresenceOfAttribute(driver, myXpath, dossier);

			System.out.println("Choix du dossier effectué : "+dossier+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
 			
 			return dossier;
 		}
 		
 		public static int depotFilesDocTr_mem (WebDriver driver) throws Throwable{
 			//Dépôt mémoire
 			String myXpath = "//input[@id='Mstr_cpMain_FileUploadFichierMemoire_fileUpload']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 1.docx");
			Thread.sleep(100);
			
			myXpath = "//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrMem = elements.size();
			System.out.println("Nombre de fichier(s), chargé(s) : "+nbrMem+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
			
			return nbrMem;
 		}
 			
 		public static int depotFilesDocTr_pics (WebDriver driver) throws Throwable{
 			//Dépôt de pièces
			String myXpath = "//input[@id='fileupload']";
			
			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 5\\001 Le Mémoire.pdf");
			Thread.sleep(100);
			System.out.println("La 1ère pièce complémentaire a été ajoutée....."+MesFonctions.extractCurrentHeure());
			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 5\\002 Le Mémoire.pdf");
			Thread.sleep(100);
			System.out.println("La 2ème pièce complémentaire a été ajoutée....."+MesFonctions.extractCurrentHeure());
			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 5\\003 Le Mémoire.docx"); 
			Thread.sleep(100);
			System.out.println("La 3ème pièce complémentaire a été ajoutée....."+MesFonctions.extractCurrentHeure());
			myXpath = "//a[contains(@id,'fileLinkFichierPiecesMemoire_hplFichier')]";
			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrPc = elements.size();
			System.out.println("Nombre de pièces complémentaires : "+nbrPc+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(1000);
			
			return nbrPc;
 		}
 		
 		public static int depotFilesDocTr_inv (WebDriver driver) throws Throwable{
			//Dépôt Inventaire
			String myXpath = "//input[@id='Mstr_cpMain_FileUploadInventairePieces_fileUpload']";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
			Thread.sleep(1000);
			MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Inventaire.pdf");
			Thread.sleep(1000);
			myXpath = "//a[(@id='Mstr_cpMain_FileUploadInventairePieces_DlFileLink_hplFichier')]";
			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
			int nbrInv = elements.size();
			System.out.println("Nombre de fichier(s) inventaire, chargé(s) : "+nbrInv+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(2000);
 			
 			return nbrInv;
 		}
 		
 		public static String conversionPDF(WebDriver driver) throws Throwable {
 			//Click bouton de conversion PDF
 			String myXpath = "//a[@id='Mstr_cpMain_zonePDF_btConvertir']";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			MesFonctions.goToDown(driver, myXpath);
 			MesFonctions.objet(driver,myXpath).click();
 			System.out.println("Click bouton de conversion PDF......"+MesFonctions.extractCurrentHeure());
 			Thread.sleep(300);
 			
 			//Confirmamtion de la conversion
			myXpath = "//span[text()='OK']//parent::button[contains(@class,'ui-button-text')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Confirmamtion de la conversion......"+MesFonctions.extractCurrentHeure());
			
			System.out.println("Conversion PDF réalisée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
 			
 			return null;
 		}
 		
 		public static String pdfVerfication (WebDriver driver, String myXpath) throws Throwable {
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver, myXpath).click();
			
			String onglet = MesFonctions.getWindow(driver, 2);
			Thread.sleep(5000);
			driver.switchTo().window(onglet);
			driver.close();
			Thread.sleep(200);
			onglet = MesFonctions.getWindow(driver, 1);
			driver.switchTo().window(onglet);
			Thread.sleep(300);
		
			myXpath ="//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(500);
			System.out.println("Vérification du fichier effectuée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
 			
 			return null;
 		}
 		
 		public static String envoiDepotTr (WebDriver driver) throws Throwable {
 			
		String myXpath = "//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]";
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
		MesFonctions.objet(driver, myXpath).click();
		Thread.sleep(300);
		
		// Vérification succès envoi
			String mess = "";
			
				//alerte 1
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
//				Alert alert = driver.switchTo().alert();
//				alert.accept();
//				mesFonctions.waiting1(driver, Duration.ofSeconds(3));
				//alerte 2
			myXpath = "//div[contains(@id,'ui-id')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			mess = MesFonctions.objet(driver,myXpath).getText();
//			Thread.sleep(1000);
			System.out.println(mess+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.objet(driver,myXpath).click();
//				mess = alert.getText();
//				System.out.println(mess);
//				alert.accept();
			Thread.sleep(100);
			
				//Vérification de l'état de l'envoi
			String mess1 = "Opération effectuée avec succès !";

			if (mess.equals(mess1)) {
				Thread.sleep(300);

			} else {
				throw new Exception("ERREUR LORS DE L\'ENVOI : " + mess);
			}
	 			return null;
	 		}
 		
 		public static String recupEnvoiNumDocTr (WebDriver driver) {
 		// Récupération du num de reqête
 		String myXpath ="//td[contains(text(),'Envoy')]//preceding-sibling::td/a[@class='numDossier']";
 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		String numreq = MesFonctions.objet(driver,myXpath).getText();
		String numDoc = numreq.replace("/"," / ");
		System.out.println("Récupération du numéro provisoire de la requête : "+numDoc);
 			
 			return numDoc;
 		}
 		
 		public static String recupEnvoiNumReqTr (WebDriver driver) {
 		// Récupération du num de reqête
 		String myXpath ="//td[contains(text(),'Envoy')]//preceding-sibling::td/a[@class='numDossier']";
 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		String numReq = MesFonctions.objet(driver,myXpath).getText().trim();
		System.out.println("Récupération du numéro provisoire de la requête : "+numReq);
 			
 			return numReq;
 		}
 		// Récupération du num de reqête (dernière valeur du tableau - value)
 		public static String recupEnvoiNumReqTrFlch (WebDriver driver, WebElement element, String value) {
 		// Récupération du num de reqête
 		String myXpath ="(//td[contains(text(),'Envoyé')]//preceding-sibling::td/a[@class='numDossier'])["+value+"]";
 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		String numReq = MesFonctions.objet(driver,myXpath).getText().trim();
		System.out.println("Récupération du numéro provisoire de la requête : "+numReq);
 			
 			return numReq;
 		}
 		
 		// Récupération du num de reqête (dernière valeur du tableau - value)
 		public static String recupEnvoiNumDocTrFlch (WebDriver driver, String value) {
 		// Récupération du num de reqête
 		String myXpath ="(//td[contains(text(),'Envoyé')]//preceding-sibling::td/a[@class='numDossier'])["+value+"]";
 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		String numDoc = MesFonctions.objet(driver,myXpath).getText().trim();
		System.out.println("Récupération du numéro provisoire de la requête : "+numDoc);
 			
 			return numDoc;
 		}

 		public static String depotFilesReqTrc_WithForm(WebDriver driver) throws Throwable {
	 		//la requête
	 		String myXpath0 = "//input[contains(@class,\"valid\") and contains(@id,\"requete\")]";
	 		String myXpath00 ="//input[contains(@id,\"requete\")]";
	 		boolean verif = false;
	 		if(!MesFonctions.isElementPresent(driver, myXpath0, verif)) {
	 		MesFonctions.objet(driver,myXpath00).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La Requête 2.pdf");
	 		Thread.sleep(1200);
	 		System.out.println("Insertion d'une pièce : Requête......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		}
	 		else {System.out.println("la requête est déjà insérée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		}
	 		
	 		
	 		//L'acte attaqué
	 		String myXpath1 = "//input[@id='acte-attaque-document-31']";
	 		Thread.sleep(200);
	 		MesFonctions.objet(driver,myXpath1).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Acte attaqué.pdf");
	 		
	 		System.out.println("Insertion d'une pièce : Acte attaqué......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		
	 		//pièces complémentaires
	 		String myXpath2 = "//input[@id='piece-complementaire-adder-11']";
	 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath2));
	 		Thread.sleep(100);
	 		MesFonctions.objet(driver,myXpath2).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 2020 - 2022.pdf");
	 		Thread.sleep(200);
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 1
		 		String myXpath200 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath200, Duration.ofSeconds(3));
		 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath200));
		 		Thread.sleep(100);
		 		MesFonctions.objet(driver,myXpath200).sendKeys("1 La pièce 1");
		 		
		 		
	 		String myXpath21 = "//input[@id='piece-complementaire-adder-21']";
	 		Thread.sleep(200);
	 		MesFonctions.objet(driver,myXpath21).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 2
		 		String myXpath210 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath210, Duration.ofSeconds(3));
		 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath210));
		 		Thread.sleep(100);
		 		MesFonctions.objet(driver,myXpath210).sendKeys("2 La pièce 2");
		 		
		 		
	 		String myXpath22 = "//input[@id='piece-complementaire-adder-31']";
	 		MesFonctions.objet(driver,myXpath22).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 1.docx");
	 		Thread.sleep(1200);
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 3
		 		String myXpath220 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath220, Duration.ofSeconds(3));
		 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath220));
		 		MesFonctions.objet(driver,myXpath220).sendKeys("3 La pièce 3");
		 		Thread.sleep(300);
		 		
	 		String myXpath23 = "//input[@id='piece-complementaire-adder-41']";
	 		Thread.sleep(200);
	 		MesFonctions.objet(driver,myXpath23).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
	 		
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 4
		 		String myXpath230 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath230, Duration.ofSeconds(3));
		 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath230));
		 		Thread.sleep(100);
		 		MesFonctions.objet(driver,myXpath230).sendKeys("4 La pièce 4");
		 		
		 		
	 		//Cocher la case de vérification
		 	String	myXpath3 = "//input[@id='conditionRenommageCheckbox']//following-sibling::label";
		 	Thread.sleep(100);
		 	MesFonctions.objet(driver,myXpath3).click();
		 	
		 	
		 	//Valider (suivant)
		 	String myXpath4 = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivant\"))]";
		 	MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		 	MesFonctions.goToDown(driver, myXpath4);
		 	Thread.sleep(500);
			MesFonctions.objet(driver, myXpath4).click();
			
			System.out.println("Validation de l'envoi avant vérification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			return null;
	 		}
 		
 		public static String depotFilesReqTrc (WebDriver driver,String slct, String scn) throws Throwable {
	 		//la requête
 			if(slct==null || scn==null ||slct=="Autre" || scn.contains("1")){
	 		String myXpath0 = "//input[contains(@class,\"valid\") and contains(@id,\"requete\")]";
	 		String myXpath00 ="//input[contains(@id,\"requete\")]";
	 		boolean verif = false;
	 		if(!MesFonctions.isElementPresent(driver, myXpath0, verif)) {
	 		MesFonctions.objet(driver,myXpath00).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La Requête 2.pdf");
	 		Thread.sleep(500);
	 		System.out.println("Insertion d'une pièce : Requête......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		}
	 		else {System.out.println("la requête est déjà insérée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		}
	 		
	 		
	 		//L'acte attaqué
	 		String myXpath1 = "//input[@id='acte-attaque-document-01']";
	 		Thread.sleep(200);
	 		MesFonctions.objet(driver,myXpath1).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Acte attaqué.pdf");
	 		
	 		System.out.println("Insertion d'une pièce : Acte attaqué......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		
	 		//pièces complémentaires
	 		String myXpath2 = "//input[@id='piece-complementaire-adder-01']";
	 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath2));
	 		Thread.sleep(100);
	 		MesFonctions.objet(driver,myXpath2).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\003 extrait des annexes graphique du PLU.pdf");
	 		Thread.sleep(300);
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 1
		 		String myXpath200 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath200, Duration.ofSeconds(3));
		 		MesFonctions.goToDown(driver,myXpath200);
		 		Thread.sleep(300);
		 		MesFonctions.objet(driver,myXpath200).sendKeys("001 Plan cadastral maison");
		 		
		 		
	 		String myXpath21 = "//input[@id='piece-complementaire-adder-11']";
	 		Thread.sleep(300);
	 		MesFonctions.objet(driver,myXpath21).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\004 Copie de la demande de permis de construire.docx");
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 2
		 		String myXpath210 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath210, Duration.ofSeconds(3));
		 		MesFonctions.goToDown(driver, myXpath210);
		 		Thread.sleep(300);
		 		MesFonctions.objet(driver,myXpath210).sendKeys("002 Budget terrain et construction");
		 		
		 		
	 		String myXpath22 = "//input[@id='piece-complementaire-adder-21']";
	 		MesFonctions.objet(driver,myXpath22).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 1.docx");
	 		Thread.sleep(300);
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 3
		 		String myXpath220 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath220, Duration.ofSeconds(3));
		 		MesFonctions.goToDown(driver, myXpath220);
		 		MesFonctions.objet(driver, myXpath220).sendKeys("003 Buget materiaux et maitrise d'ouvrage");
		 		Thread.sleep(300);
		 		
		 		
	 		String myXpath23 = "//input[@id='piece-complementaire-adder-31']";
	 		Thread.sleep(200);
	 		MesFonctions.objet(driver, myXpath23).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
	 		
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 4
		 		String myXpath230 = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath230, Duration.ofSeconds(3));
		 		MesFonctions.goToDown(driver,myXpath230);
		 		Thread.sleep(300);
		 		MesFonctions.objet(driver, myXpath230).sendKeys("004 Analyse Office notorial");
		 		
	 		String myXpath = "//input[@id='piece-complementaire-adder-41']";
	 		Thread.sleep(200);
	 		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\10 Notice architecturale et plans de la demande.pdf");
	 		
	 		System.out.println("Insertion d'une pièce complémentaire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			//nom de la pièce 5
		 		myXpath = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		MesFonctions.goToDown(driver, myXpath);
		 		Thread.sleep(300);
		 		MesFonctions.objet(driver, myXpath).sendKeys("005 Notice architecturale et plans de la demande");
 		}
		 		
		 		
	 		//Cocher la case de vérification
		 	String	myXpath3 = "//input[@id='conditionRenommageCheckbox']//following-sibling::label";
		 	MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
		 	MesFonctions.goToDown(driver, myXpath3);
		 	Thread.sleep(500);
		 	MesFonctions.objet(driver, myXpath3).click();
		 	
		 	
		 	//Valider (suivant)
		 	String myXpath4 = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivant\"))]";
		 	MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
//		 	Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
		 	MesFonctions.goToDown(driver, myXpath3);
		 	Thread.sleep(300);
			MesFonctions.objet(driver, myXpath4).click();
			
			System.out.println("Validation de l'envoi avant vérification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			return null;
	 		}
 		
 		
 		public static String depotFilesReqTrc_99Pieces (WebDriver driver) throws InterruptedException {
	 		//la requête
	 		String myXpath0 = "//input[contains(@id,\"requete\")]";
	 		MesFonctions.objet(driver,myXpath0).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La Requête 2.pdf");
	 		Thread.sleep(200);
	 		
	 		//L'acte attaqué
	 		String myXpath1 = "//input[@id='acte-attaque-document-01']";
	 		MesFonctions.objet(driver,myXpath1).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Acte attaqué.pdf");
	 		Thread.sleep(200);
 		
	 	
 		
	 		//pièces complémentaires
	 		try {
	 		int nbr = 99;
	 		for(int i=0;i<nbr;i++ ) {
	 			int pcs = i+2;
	 		String myXpath2 = "(//input[contains(@id,\"piece-complementaire\")])[last()]";
	 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver,myXpath2));
	 		Thread.sleep(100);
	 		MesFonctions.objet(driver,myXpath2).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 5\\Le Mémoire 5 - Copie ("+pcs+").pdf");
	 		Thread.sleep(200);
	 			//nom de la pièce 1
		 		String myXpath = "//label[@class='nommer-piece-label']//following-sibling::div[@class='input-group']/input";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
		 		pcs = i+1;
		 		MesFonctions.objet(driver, myXpath).sendKeys("PJ"+MesFonctions.rewriteDigits(pcs, 4)+" La pièce justificative de ma requête "+pcs+"");
		 		Thread.sleep(100);
		 		System.out.println("la pièce "+pcs+" est chargée......"+MesFonctions.extractCurrentHeure());
	 		}
			
		} catch (Exception e) {
			System.err.println("Le total de pièces ne peut pas excéder 99......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
	 		//Cocher la case de vérification
		 	String	myXpath3 = "//input[@id='conditionRenommageCheckbox']//following-sibling::label";
		 	MesFonctions.objet(driver,myXpath3).click();
		 	Thread.sleep(1000);
		 	System.out.println("Case relative au nommage de pièces cochée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 	
		 	//Valider (suivant)
		 	String myXpath4 = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivant\"))]";
			MesFonctions.objet(driver,myXpath4).click();
			Thread.sleep(200);
			System.out.println("Accès à la page suivante validée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 	
	 			return null;
	 		}
 		
 		public static String depotMemCompDebray(WebDriver driver) throws Throwable {
 			//pièces complémentaires
	 		try {
	 		int nbr = 30;
	 		for(int i=16;i<nbr;i++ ) {
	 			int pcs = i+2;
	 		String myXpath2 = "(//trc-file-uploader[@inputname='piece-adder']//input[@type='file'])[last()]";
//	 		MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
	 		MesFonctions.goToDown(driver, myXpath2);
	 		Thread.sleep(300);
	 		MesFonctions.objet(driver, myXpath2).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 5\\Le Mémoire 5 - Copie ("+pcs+").pdf");
	 		Thread.sleep(200);
	 			//nom de la pièce 1
		 		String myXpath = "(//div[@class='form-group required name']//label//following-sibling::div/input)[last()]";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
		 		pcs = i+2;
		 		MesFonctions.objet(driver, myXpath).sendKeys("PJ"+MesFonctions.rewriteDigits(pcs, 4)+" La pièce justificative de ma requête, type mémoire "+pcs+"");
		 		Thread.sleep(200);
		 		System.out.println("la pièce "+pcs+" est chargée......"+MesFonctions.extractCurrentHeure());
	 		}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Le total de pièces ne peut pas excéder 99......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
	 		//Cocher la case de vérification
		 	String	myXpath3 = "//input[@id='conditionRenommage']//following-sibling::label";
		 	MesFonctions.objet(driver,myXpath3).click();
		 	Thread.sleep(100);
		 	System.out.println("Case relative au nommage de pièces cochée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 	
		 	//Valider (suivant)
		 	String myXpath4 = "//button//span[contains(text(),\" Envoyer les documents complémentaires \")]";
			MesFonctions.objet(driver,myXpath4).click();
			Thread.sleep(200);
			System.out.println("Accès à la page suivante validée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 	
	 			return null;
	 		
 			
 		}
	 		
 		public static String recapDepotReqTrc(WebDriver driver) throws InterruptedException, Throwable {
 			//avertissement
 			String	myXpath = "//input[@id='avertissement']//following-sibling::label";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	   		Keyboard.keyBoardShortCut(KeyEvent.VK_CONTROL, KeyEvent.VK_END);
 			MesFonctions.goToDown(driver, myXpath);
	   		Thread.sleep(300);
		    MesFonctions.objet(driver, myXpath).click();
		 	Thread.sleep(100);
		 	
		 	myXpath = "//input[@id='requeteAbusifCheckbox']//following-sibling::label";
		 	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 	MesFonctions.objet(driver, myXpath).click();
		 	Thread.sleep(100);
 			
 			return null;
	 		}
	 		
 		public static String verifEnvoiTrc (WebDriver driver) throws InterruptedException {	
 			//Vérifier le dépôt
 			String myXpath ="//button[@title='Visualiser mon dossier']/span";
 			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 			MesFonctions.objet(driver, myXpath).click();
 			Thread.sleep(5000);
 			
 			return null;
	 		}
 		
	 		//Selection de la chambre 
 		public static String chambreTa (WebDriver driver) {
	 		String myXpath0 = "//select[@id='ddlChambre']";
	 		String value = "11";
	 		MesFonctions.selection(driver, myXpath0, value);	
	 			return null;
	 		}
	 		
//	 		public static String numeReqTrc1 (WebDriver driver) throws InterruptedException {
//	 			
//	 			String myXpath = "//jhi-numero-dossier//span";//cdk-row//cdk-cell[contains(@class,'cdk-column-juridiction') and contains(text(),"")]//preceding-sibling::cdk-cell//jhi-numero-dossier//span
//	 			String caractSpec = "*";
//	 			List<WebElement> elements = driver.findElements(By.xpath(myXpath));
//				List<String> lesnum = new ArrayList<>();
//				for(WebElement e : elements) {
//					if(e.getText().contains(caractSpec) == true) {
//						String lesnum1 = e.getText();
//						Thread.sleep(500);
//							lesnum.add(lesnum1);
//					}
//				}
//				String trc = Collections.max(lesnum);
//				mesFonctions numTrc = new mesFonctions(trc);
//				//System.out.println(numTrc);
//				System.out.println(numTrc.getNumReq());
//				
//				return null;
//	 		}
	 		
 		public static String choixChbrMatCatTA (WebDriver driver, String ChbrMatCatTA, String value ) throws Throwable {
	 			
	 			switch (ChbrMatCatTA) {
				case "chambre":
					String myXpath = "//select[@id='ddlChambre']"; 
		 			   MesFonctions.selection(driver, myXpath, value);
		 			   System.out.println("Choix de la chambre effectué");
					break;
					
				case "matiere":
					String myXpath1 = "//select[@id='DdlMatierePrincipale']"; 
		 			   MesFonctions.selection(driver, myXpath1, value);
	 			   Thread.sleep(1000);
	 			  System.out.println("Choix de la matière effectué");
	 			   break;
				case "ssmatiere":
		 			String myXpath2 = "//select[@id='DdlMatiereSecondaire']"; 
		 			   MesFonctions.selection(driver, myXpath2, value);
		 			  System.out.println("Choix de la sous-matière effectué");
					break;
					
				case "categorie":
					String myXpath3 = "//select[@id='DdlCategorie']"; 
		 			   MesFonctions.selection(driver, myXpath3, value);
		 			  System.out.println("Choix de la catégorie effectué");
					break;

				default: System.err.println("ERROR"); 
					break;
				}
	 			
	 			return null;
	 		}
	 		
		public static String choixChbrMatCatCAA (WebDriver driver, String ChbrMatCatCAA, String value ) throws Throwable {
	 			
	 			switch (ChbrMatCatCAA) {
	 			case "chambre":
					String myXpath = "//select[@id='ddlChambre']"; 
		 			   MesFonctions.selection(driver, myXpath, value);
		 			   System.out.println("Choix de la chambre effectué");
					break;
					
				case "matiere":
					String myXpath1 = "//select[@id='DdlMatierePrincipale']"; 
		 			   MesFonctions.selection(driver, myXpath1, value);
	 			   Thread.sleep(1000);
	 			  System.out.println("Choix de la matière effectué");
	 			   break;
				case "ssmatiere":
		 			String myXpath2 = "//select[@id='DdlMatiereSecondaire']"; 
		 			   MesFonctions.selection(driver, myXpath2, value);
		 			  System.out.println("Choix de la sous-matière effectué");
					break;
					
				case "categorie":
					String myXpath3 = "//select[@id='DdlCategorie']"; 
		 			   MesFonctions.selection(driver, myXpath3, value);
		 			  System.out.println("Choix de la catégorie effectué");
					break;

				default: System.err.println("ERROR"); 
					break;
				}
	 			
	 			return null;
	 		}
	 		
 		public static String choixChbrMatCatCTX (WebDriver driver, String ChbrMatCatCTX, String value ) throws Throwable {
	 			
	 			switch (ChbrMatCatCTX) {
				case "chambre":
					String myXpath = "//select[@id='ddlSousSection']"; 
		 			   MesFonctions.selection(driver, myXpath, value);
					break;
					
				case "matiere":
					String myXpath1 = "//select[@id='DdlMatierePrincipale']"; 
		 			   MesFonctions.selection(driver, myXpath1, value);
	 			   Thread.sleep(1000);
	 			  System.out.println("Choix de la matière effectué");
	 			   break;
				case "ssmatiere":
		 			String myXpath2 = "//select[@id='DdlMatiereSecondaire']"; 
		 			   MesFonctions.selection(driver, myXpath2, value);
		 			  System.out.println("Choix de la sous-matière effectué");
					break;
					
				case "categorie":
					String myXpath3 = "//select[@id='DdlCategorie']"; 
		 			   MesFonctions.selection(driver, myXpath3, value);
		 			  System.out.println("Choix de la catégorie effectué");
					break;

				default: System.err.println("ERROR"); 
					break;
				}
	 			
	 			return null;
	 		}
	 		
	 	public static String sauvReq(WebDriver driver) throws Throwable {
	 		String myXpath = "//input[@id='btSauvegarder']"; 
	 		MesFonctions.objet(driver,myXpath);		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
			Thread.sleep(100);

			MesFonctions.objet(driver,myXpath).click();
			Thread.sleep(100);
			
					//Première alerte
					myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					MesFonctions.objet(driver,myXpath).click();
					
					Thread.sleep(200);
								
					//alerte 2
					myXpath = "//div[contains(@id,'ui-id')]";	
					String mess = MesFonctions.objet(driver,myXpath).getText();
					System.out.println(mess+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					String mess1 = "Requête sauvegardée";
					Thread.sleep(100);
					myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.objet(driver, myXpath).click();

					if (mess.equals(mess1)) {
						Thread.sleep(100);

					} else {
						throw new Exception("ERREUR LORS DE LA SAUVEGARDE : " + mess);
					}
	 		return null;
	 	}
	 	
	 	public static String enrgReq(WebDriver driver) throws Throwable {
	 		String myXpath = "//input[@id='btEnregistrer']"; 		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
			Thread.sleep(100);

			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(100);
			
					//Première alerte
					myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
					MesFonctions.objet(driver,myXpath).click();
						//alerte 2
					myXpath = "//div[contains(@id,'ui-id')]";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					String mess = MesFonctions.objet(driver,myXpath).getText();
					Thread.sleep(100);
					System.out.println(mess+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.objet(driver,myXpath).click();
					Thread.sleep(200);
								
					//alerte 2
//					String mess = alert.getText();
					String message = mess.substring(0, 32);
					System.out.println(message);
					
//					alert.accept();
					String mess1 = "Requête enregistrée dans Skipper";

					if (message.equals(mess1)) {
						Thread.sleep(100);

					} else {
						throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
					}
//					int rep = mess.indexOf(mess.split(":")[1]);
					String req = mess.split(":")[1];
					System.out.println(mess.substring(mess.indexOf(mess.split(":")[1]), mess.length()).trim());
	 		return req.trim();
	 	}
	 	
	 	public static String enrgReqFlech(WebDriver driver) throws Throwable {
	 		String myXpath = "//input[@id='btEnregistrer']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		MesFonctions.objet(driver, myXpath);		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
			Thread.sleep(100);
			
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(100);
			
			//Première alerte
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver,myXpath).click();
			
			//alerte 2 
			myXpath = "//div[contains(@id,'ui-id')]";
			
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String mess = MesFonctions.objet(driver, myXpath).getText();
			Thread.sleep(200);
			System.out.println(mess+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(200);
			
					int deb = mess.indexOf(mess.split(":")[1]);
					String message = mess.substring(0, 32);
					Thread.sleep(100);
					String requete = mess.substring(deb, mess.length()).trim();
					System.out.println(message+"/"+requete);
					
//					alert.accept();
					String mess1 = "Requête enregistrée dans Skipper";

					if (message.equals(mess1)) {
						Thread.sleep(100);

					} else {
						throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
					}
	 		return requete;
	 	}
	 	
	 	public static String enrgDoc (WebDriver driver) throws Throwable {
	 		
	 		String myXpath = "//input[@id='btEnregistrer']"; 
	 		MesFonctions.objet(driver,myXpath);		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
			Thread.sleep(1000);

			MesFonctions.objet(driver,myXpath).click();
			Thread.sleep(1000);
			
					//Première alerte
					myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					MesFonctions.objet(driver,myXpath).click();					
					Thread.sleep(200);
								
					//alerte 2

					myXpath = "//div[contains(@id,'ui-id')]";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					String mess = MesFonctions.objet(driver,myXpath).getText();
					Thread.sleep(100);
					System.out.println(mess+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.objet(driver, myXpath).click();
					Thread.sleep(200);
					
					String mess1 = "Le document a été enregistré avec succès.";

					if (mess.equals(mess1)) {
						Thread.sleep(100);

					} else {
						throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + mess);
					}
					
	 		return null;
	 	}
	 	
	 	public static void deconnexionTrExt (WebDriver driver) throws InterruptedException {
	 		String myXpath = "//a[@id='lnkdeconnecter']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		Thread.sleep(200);
	 		MesFonctions.objet(driver ,myXpath).click();
			myXpath = "//a[@class='alert-link ' and (text()='ici')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Déconnextion TR_LEG_EXT réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		}
	 	
	 	public static void deconnexionTrInt (WebDriver driver) throws InterruptedException {
	 		String myXpath = "//a[@id='lnkdeconnecter']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		MesFonctions.objet(driver, myXpath).click();
			System.out.println("Déconnextion TR_LEG_INTERNE réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		}
	 	
	 	public static boolean verifUrgence (WebDriver driver, String urg) throws Throwable{
	 		String myXpath = "//span[@id='txtUrgence']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		String verifUrg = MesFonctions.objet(driver,myXpath).getText().toLowerCase();
			System.out.println("Vérification de l'urgence : "+verifUrg+" réalisée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			boolean verif = verifUrg.equals(urg);
			if (!verif) {
				System.err.println("L\'URGENCE EST DIFFERENTE : " + verifUrg + "/" + urg);
			} 
			else {
				Thread.sleep(200);
			}
			return verif;
 		}
	 	
	 	public static boolean verifMatiere(WebDriver driver, String mat) throws Throwable{
	 		String myXpath = "//span[@id='txtMatiereRequerant']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		String verifMat = MesFonctions.objet(driver,myXpath).getText();
			System.out.println("Vérification de la matière : "+verifMat+" réalisée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			boolean verif = verifMat.equals(mat);
			if (!verif) {
				System.err.println("L\'URGENCE EST DIFFERENTE : " + verifMat + "/" + mat);
			} 
			else {
				Thread.sleep(100);
			}
			return verif;
 		}
	 	
	 	public static String verifSaisine(WebDriver driver) throws Throwable{
	 		String myXpath = "//input[@id='txtNiveauSaisine']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		String saisine = MesFonctions.objet(driver, myXpath).getDomAttribute("value").trim(); 
			System.out.println("Vérification de la saisine : "+saisine+" réalisée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			if(saisine.equals("Premier ressort")) {
				myXpath = "//input[@id='txtDateDecAtt']";
				boolean verif = MesFonctions.objet(driver, myXpath).getDomAttribute("value").trim().equals(MesFonctions.extractCurrentDate());
				if(verif) {
					System.out.println("La date est par défaut égale à la date du jour : "+MesFonctions.objet(driver, myXpath).getDomAttribute("value").trim());
				}
				else {
					System.err.println("La date n'est pas égale à la date du jour : "+MesFonctions.objet(driver, myXpath).getDomAttribute("value").trim());
				}
			}
			return saisine;
 		}
	 	
	 	public static int nombreFichiersCharges(List<Integer> nbr, int charge) {
	 		//Verifier nombre de fichiers chargés
			int sum = nbr.stream().mapToInt(Integer::valueOf).sum();
			if (sum == charge) {
				System.out.println("Le nombre de fichiers déposés est bien égale au nombre de fichiers chargés sur l'application : "+sum+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
			else {
				System.err.println("Le nombre de fichiers déposés est différent du nombre de fichiers chargés sur l'application : "+sum+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
	 		return sum;
	 	}
		
	 	public static String ajouterRequerantFlechTA(WebDriver driver, int i, int loop) throws Throwable {
	 		String myXpath = "//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			Thread.sleep(1000);
			
			String[] list = {"1", "2", "1"};
			List<String> value = Stream.of(list).map(Object::toString).collect(Collectors.toList());
			String[] list1 = {"BONNAUD", "GARROUX", "LECLERC"};
			List<String> nom = Stream.of(list1).map(Object::toString).collect(Collectors.toList());
			String[] list2 = {"Delphine", "Georges", "Sonia"};
			List<String> prenom = Stream.of(list2).map(Object::toString).collect(Collectors.toList());
			String[] list3 = {"5 avenue du 8 mai 1945", "13 avenue du 8 mai 1945", "56 avenue du 8 mai 1945"};
			List<String> adress = Stream.of(list3).map(Object::toString).collect(Collectors.toList());
			
			if(i < loop) {
			myXpath = "//select[@id='Mstr_cpMain_requerantCivilite']";
			MesFonctions.selection(driver, myXpath, value.get(i));
			Thread.sleep(100);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys(nom.get(i));
			Thread.sleep(100);
		
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys(prenom.get(i));
			Thread.sleep(100);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys(adress.get(i));
			Thread.sleep(100);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("75003");
			Thread.sleep(100);
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("PARIS");
			Thread.sleep(100);
			
			// Valider
			Thread.sleep(100);
			myXpath = "//span[@class='ui-button-text' and text()='Ajouter']";
			MesFonctions.objet(driver,myXpath).click();
			}
	 		return null;	
		}
	 	
	 	public static String ajouterRequerantFlechCAA(WebDriver driver, int i, int loop) throws Throwable {
	 		String myXpath = "//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			Thread.sleep(1000);
			
			String[] list = {"1", "2", "1"};
			List<String> value = Stream.of(list).map(Object::toString).collect(Collectors.toList());
			String[] list1 = {"DUPUIS", "DELCOURT", "VOLTAIRE"};
			List<String> nom = Stream.of(list1).map(Object::toString).collect(Collectors.toList());
			String[] list2 = {"Ariette", "Fabrice", "Irène"};
			List<String> prenom = Stream.of(list2).map(Object::toString).collect(Collectors.toList());
			String[] list3 = {"68 rue des coquelicots", "34 rue des coquelicots", "3 rue des coquelicots"};
			List<String> adress = Stream.of(list3).map(Object::toString).collect(Collectors.toList());
			
			if(i < loop) {
			myXpath = "//select[@id='Mstr_cpMain_requerantCivilite']";
			MesFonctions.selection(driver, myXpath, value.get(i));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys(nom.get(i));
			Thread.sleep(1000);
		
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys(prenom.get(i));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys(adress.get(i));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("94500");
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("CHAMPIGNY-SUR-MARNE");
			Thread.sleep(1000);
			
			// Valider
			Thread.sleep(1000);
			myXpath = "//span[@class='ui-button-text' and text()='Ajouter']";
			MesFonctions.objet(driver,myXpath).click();
			}
	 		return null;	
		}
	 	
	 	public static String ajouterRequerantFlechCE(WebDriver driver, int i, int loop) throws Throwable {
	 		String myXpath = "//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			Thread.sleep(1000);
			
			String[] list = {"1", "1", "1"};
			List<String> value = Stream.of(list).map(Object::toString).collect(Collectors.toList());
			String[] list1 = {"BOURGOIN", "FAUDEL", "QUERROT"};
			List<String> nom = Stream.of(list1).map(Object::toString).collect(Collectors.toList());
			String[] list2 = {"Sandrine", "Marie", "Aline"};
			List<String> prenom = Stream.of(list2).map(Object::toString).collect(Collectors.toList());
			String[] list3 = {"20 rue de Vanves", "12 rue de Vanves", "28 rue de Vanves"};
			List<String> adress = Stream.of(list3).map(Object::toString).collect(Collectors.toList());
			
			if(i < loop) {
			myXpath = "//select[@id='Mstr_cpMain_requerantCivilite']";
			MesFonctions.selection(driver, myXpath, value.get(i));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys(nom.get(i));
			Thread.sleep(1000);
		
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys(prenom.get(i));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys(adress.get(i));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("75014");
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("PARIS");
			Thread.sleep(1000);
			
			// Valider
			Thread.sleep(1000);
			myXpath = "//span[@class='ui-button-text' and text()='Ajouter']";
			MesFonctions.objet(driver,myXpath).click();
			}
	 		return null;
	 	}
	 	
	 	public static String findReq (WebDriver driver, String requete) throws Throwable {
	 		String myXpath = "//a[@id='gvDossierEnCours_ctl01_LinkButton2']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		
	 		boolean verif = false;
	 		String myXpath1 = "//a[@class='numDossier' and contains(text(),\""+requete+"\")]";
	 		int turn = 2;
	 			while(MesFonctions.isElementPresent(driver, myXpath1, verif)==false) {
	 				
	 			String myXpath2 = "//a[@id='rptPager_ctl0"+turn+"_lnkPage']";
	 			Thread.sleep(1000);
	 			MesFonctions.objet(driver,myXpath2).click();
	 			System.out.println("click....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			turn++;	
	 			}
	 		
//			myXpath1 = "//a[@class='numDossier' and contains(text(),\""+requete+"\")]";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath1).click();
	 			
	 		String myXpath3 = "//h1[contains(text(),'DOSSIER')]";
	 		MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
	 		System.out.println(MesFonctions.objet(driver,myXpath3).getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		Thread.sleep(2000);
	 		
	 		return null;
	 	}
	 	
	 	public static String changeWindow (WebDriver driver) throws Throwable {
			
 			MesFonctions.addTab(driver);
 			Thread.sleep(2000);
 			driver.close();
 			Thread.sleep(2000);
			String parentWindow = MesFonctions.parentWindow(driver);
			driver.switchTo().window(parentWindow);
	 		
	 		return null;
	 	}
	 	
	 	public static String changeWindowMail (WebDriver driver) throws Throwable {
			
// 			MesFonctions.addTab(driver);
	 		MesFonctions.addTabII(driver);//Ne fonctionnne pas avec Chrome en navigation privée !!!!
 			Thread.sleep(1000);
 			driver.close();
 			Thread.sleep(200);
			String parentWindow = MesFonctions.getWindow(driver, 1);
			driver.switchTo().window(parentWindow);
	 		
	 		return null;
	 	}
	 	
	 	public static String searchDossierRequerant(WebDriver driver, String name) throws Throwable {
 		String myXpath = "//a[@id='gvDossierEnCours_ctl01_LinkButton2']";
 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
 		//Classement des dossier par order desc 
 		MesFonctions.objet(driver,myXpath).click();
 		Thread.sleep(1000);
 		MesFonctions.objet(driver,myXpath).click();
	 	
 		//vérification de la présence du dossier
	 	String myXpath1 = "//span[text()='"+name+"']//parent::td//preceding-sibling::td//child::a[@class='numDossier']";
	 	boolean verif = false;
	 	int turn = 2;
			while(MesFonctions.isElementPresent(driver, myXpath1, verif)==false) {
				
			String myXpath2 = "//a[@id='rptPager_ctl0"+turn+"_lnkPage']";
			MesFonctions.objet(driver,myXpath2).click();
			System.out.println("Click......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			turn++;	
			}
	 	
		MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
		String dossier = MesFonctions.objet(driver,myXpath1).getText().trim();
		MesFonctions.objet(driver,myXpath1).click();
		//Vérification de la page dossier
		String myXpath3 = "//h1[contains(text(),'DOSSIER')]";
 		MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
 		System.out.println(MesFonctions.objet(driver,myXpath3).getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		//clic sur le bouton "préparer l'envoi d'un document"
 		String myXpath4 = "//a[@id='Mstr_cpMain_hlDeposerDocument']//span[@class='button-text no-busy-loader']";
 		MesFonctions.objet(driver,myXpath4).click();
	 		
	 		return dossier;
	 	}
	 	
	 	public static String typeDoc (WebDriver driver, int index) throws Throwable {
	 		//index 0 > mémoire avec ou sans pièce ; index 1 > piece sans mémoire ; index 2 > courrier seul
	 		String myXpath = "//div[@id='Mstr_cpEntete_Entete1_EnteteDonnee1_divAll']";
	 		String str = MesFonctions.objet(driver,myXpath).getText();
	 		Thread.sleep(1000);
	 		int deb = str.indexOf(str.split(" ")[1]);
	 		String name = str.substring(0, deb).trim();
	 		myXpath = "//input[@id='Mstr_cpMain_rbPj_"+index+"']";
			MesFonctions.objet(driver,myXpath).click();
			Thread.sleep(1000);
			//Message du dépositaire
			String text = "Ce dépôt doit être pris en compte dans les plus brefs délais.\nCordialement,\nMaître "+name+"";
			myXpath = "//textarea[@id='Mstr_cpMain_txtMessage']";
			MesFonctions.objet(driver,myXpath).sendKeys(text);
			Thread.sleep(1000);
			//Vérification du Type de document
			myXpath = "//input[@id='Mstr_cpMain_rbPj_"+index+"']//following-sibling::label";
			System.out.println("Document : "+MesFonctions.objet(driver,myXpath).getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(1000);
	 		
	 		return text;
	 	}
	 	
	 	public static String typeMem (WebDriver driver, String value) throws Throwable {
	 		String myXpath = "//select[@id='Mstr_cpMain_ddlTypeDocument']";
			MesFonctions.selection(driver, myXpath, value);
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeDocument']//option[@value='"+value+"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String typeMem = MesFonctions.objet(driver,myXpath).getText();//la valeur selected n'et pas définie sur le bon attribut(value)
			System.out.println("Type de mémoire choisi : "+ typeMem+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(1000);
	 		return null;
	 	}
	 	
	 	public static String PrépaTachSyncAnnRpva(WebDriver driver, String heure) throws ParseException, Throwable {
	 		//Vérification de la page TR-Admin
	 		String myXpath = "//h1[@class='inbl']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		System.out.println("Page TR-Admin......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		//Accès à l'onglet "Tâche"
	 		myXpath = "//a[@class='  no-preloader' and text()='Tâches']";
	 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	 		MesFonctions.souriOver(driver, myXpath);
	 			//accès à l'onglet "Planifier"
	 		myXpath = "//a[text()='Planifier']";
	 		MesFonctions.objet(driver,myXpath).click();
	 		System.out.println("Accès à la liste des tâches......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		Thread.sleep(2000);
	 				
	 		//Choix de la Tâche à planifier
	 		myXpath = "//select[@id='Job']";
	 		String value = "RPVA-SYNCHRO";
	 		MesFonctions.selection(driver, myXpath, value);
	 		Thread.sleep(2000);
	 		System.out.println("Tâche sélectionnée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		//Date d'exécution
	 		String pattern = "dd/MM/yyyy HH:mm";
	 		String timing = MesFonctions.time(heure, pattern);
	 		System.out.println(timing);
	 		Thread.sleep(2000);
	 		myXpath = "//input[@id='StartTime']";
	 		MesFonctions.objet(driver,myXpath).sendKeys(timing);
	 		Thread.sleep(1000);
	 		myXpath = "//input[@id='Priority']";
	 		MesFonctions.objet(driver,myXpath).click();
	 		System.out.println("Horaire de la tâche définie "+timing);
	 		
	 		//Insérer le fichier XML
	 		myXpath = "//input[@id='Parameters_DATA__Value']";
	 		MesFonctions.objet(driver,myXpath).sendKeys("D:\\DataTelerecours\\Donnees\\temp\\Telerecours-2022-01-05.xml");
	 		Thread.sleep(2000);
	 		System.out.println("Insertion du fichier XML");
	 		
	 		//Valider
	 		myXpath = "//a[@class='btn btn-green']";
	 		MesFonctions.objet(driver,myXpath).click();
	 		System.out.println("Tâche validée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		Thread.sleep(1000);
	 		boolean verif = false;
	 		myXpath = "//div[@class='successNotification']";
	 		if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
	 		String txt = MesFonctions.objet(driver,myXpath).getText();
	 		System.out.println(txt);
	 		}else {throw new Exception("La tâche n'a pas pu être planifiée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 			}
	 		return null;
	 	}
	 	
	 	public static String Edentitas (WebDriver driver, String choixJur) throws Throwable {
	 		//Connexion à la page edentitas
			String myXpath = "//img[@class='ll-img']";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Click bouton page e-Dentitas......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Vérification de la page 
			myXpath = "//h1[@class='text-center']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Page e-Dentitas......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(1000);
			
			//Sélection de la structure principale.
			myXpath = "//a[@class='btn btn-primary']";
			boolean verif = false;
			if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Click bouton structure principale......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
			else {System.out.println("Aucune structure");}
	 		
	 		return null;
	 	}
	 	
	 	public static String mdpFinValidite(WebDriver driver, String id, String mdp, String jur) throws Throwable {
	 		switch (jur) {
			case "TACAA":
				//Connexion à la page juradfm.fr
		 		driver.get("https://www.telerecours.recette.juradm.fr/");
		 		
		 		//Vérification de la page 
		 		String myXpath4 = "//h1[text()='Se connecter']";
		 		MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		 		
		 		//Authentification  
		 		MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
		 		
		 		boolean verif = false;
		 		String myXpath1 = "//h1[contains(text(),\"Modification du mot de passe\")]";		
		 		if(!MesFonctions.isElementPresent(driver, myXpath1, verif)) {
		 			String myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					String mess = MesFonctions.objet(driver,myXpath).getText();
									
		 			System.out.println(mess);
		 			MesFonctions.objet(driver, myXpath).click();	
			 			
		 			//Choix de la juridiction
		 			MicroFonctions.choixJuridictionTA(driver);
		 		}
		 		else {
		 			MicroFonctions.changementMdp(driver, jur,  mdp, "Lhommeest2019**", id);
		 			}
		 		
				break;
				
			case "CE":
				//Connexion à la page juradfm.fr
		 		driver.get("https://www.telerecours.recette.conseil-etat.fr/ ");
		 		
		 		//Vérification de la page 
		 		myXpath4 = "//h1[text()='Se connecter']";
		 		MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		 		
		 		//Authentification  
		 		MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
		 		
		 		verif = false;
		 		myXpath1 = "//h1[contains(text(),\"Modification du mot de passe\")]";		
		 		if(!MesFonctions.isElementPresent(driver, myXpath1, verif)) {
		 			String myXpath = "//span[@class='ui-button-text' and text()='OK']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					String mess = MesFonctions.objet(driver,myXpath).getText();
		 			System.out.println(mess);
		 			Thread.sleep(1000);
		 			MesFonctions.objet(driver, myXpath).click();
		 			Thread.sleep(2000);
			 			
		 			//Choix de juridiction CE et Vérification de la page
		 			MicroFonctions.choixJuridcitionCE(driver);
		 		}else {
		 			MicroFonctions.changementMdp(driver, jur, mdp, "Lhommeest2019**", id);
		 			}
		 		
		 		
		 		
				break;

			default: System.err.println("Aucune juridiction sélectionnée");
				break;
			}
	 		return null;
	 	}
	 	
	 	public static String mdpExpire(WebDriver driver, String id, String mdp, String jur) throws Throwable{
	 		switch (jur) {
			case "TACAA":
				//Connexion à la page juradfm.fr
		 		driver.get("https://www.telerecours.recette.juradm.fr/ ");
		 		
		 		//Vérification de la page 
		 		String myXpath4 = "//h1[text()='Se connecter']";
		 		MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		 		
		 		//Authentification  
		 		MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
		 		String mdp2 = "Lhommeest2019**";
		 		MicroFonctions.changementMdp(driver, jur, mdp, mdp2, id);
		 		
		 		//Choix de juridiction 
		 		MicroFonctions.choixJuridictionCAA(driver);
				break;
				
			case "CE":
				//Connexion à la page juradfm.fr
		 		driver.get("https://www.telerecours.recette.conseil-etat.fr/ ");
		 		
		 		//Vérification de la page 
		 		myXpath4 = "//h1[text()='Se connecter']";
		 		MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
		 		
		 		//Authentification  
		 		MicroFonctions.AuthentificationTaCaaCeExt(driver, id, mdp);
		 		mdp2 = "Lhommeest2019**";
		 		MicroFonctions.changementMdp(driver, jur,  mdp, mdp2, id);
		 		
		 		//Choix de juridiction CE et Vérification de la page
	 			MicroFonctions.choixJuridcitionCE(driver);
				break;

			default:System.err.println("Aucune juridiction sélectionnée");
				break;
			}
	 		
	 		return null;
	 	}
	 	
	 	public static String PrefUserChangeMdp (WebDriver driver, String mdp, String choixjur) throws Throwable {
	 		switch (choixjur) {
			case "TACAA":
				//Clic sur le lien "Vos préférences"
		 		String myXpath = "//a[@id='lnkpref']"; 
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		MesFonctions.objet(driver,myXpath).click();
		 		
		 		String mdp2 = "Lhommeest2019*";
		 		
		 		//Changer de window
		 		String childWindow = MesFonctions.childWindow(driver);
		 		driver.switchTo().window(childWindow);
		 		
		 		//Vérification de la page
		 		myXpath = "//div//p[text()='Gérez vos préférences']";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		System.out.println("PopUp Vos Préférences affichée......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 		
		 		//Clic sur le lien Changer votre mot de passe
		 		myXpath = "//a[@id='linkChamgementMotDePasse']";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		MesFonctions.objet(driver,myXpath).click();
		 		System.out.println("Clic lien de changement de mot de passe......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 		Thread.sleep(200);
		 		
		 		//changement de fenêtre
		 		String onglet = MesFonctions.childWindow(driver);
		 		driver.switchTo().window(onglet);
		 		myXpath = "//span[@id='labelMessage']";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		
		 		//Changement de mot de passe
		 		myXpath = "//input[@id='txtMotDePasseActuel']";
		 		String myXpath1 = "//input[@id='txtNouveauMotDePasse']";
		 		String myXpath2 = "//input[@id='txtConfirmation']";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).sendKeys(mdp);
				MesFonctions.objet(driver,myXpath1).sendKeys(mdp2);
				MesFonctions.objet(driver,myXpath2).sendKeys(mdp2);
				
				//valider
				driver.findElement(By.xpath("//input[@value='Valider']")).click();
				
				//Changer de window
		 		String parentdWindow = MesFonctions.parentWindow(driver);
		 		driver.switchTo().window(parentdWindow);
		 		
				break;

			case "CE":
				//Clic sur le lien "Vos préférences"
		 		myXpath = "//a[@id='Entete1_EnteteDonnee1_lnkpref']"; 
		 		MesFonctions.objet(driver,myXpath).click();
		 		
		 		mdp2 = "Lhommeest2019*";
		 		
		 		//Changer de window
		 		childWindow = MesFonctions.childWindow(driver);
		 		driver.switchTo().window(childWindow);
		 		
		 		//Vérification de la page
		 		myXpath = "//div//p[text()='Gérez vos préférences']";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		System.out.println("PopUp Vos Préférences affichée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 		
		 		//Clic sur le lien Changer votre mot de passe
		 		myXpath = "//a[@id='linkChamgementMotDePasse']"; 
		 		MesFonctions.objet(driver,myXpath).click();
		 		System.out.println("Clic lien de changement de mot de passe......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 		Thread.sleep(2000);
		 		
		 		//changement de fenêtre
		 		onglet = MesFonctions.childWindow(driver);
		 		driver.switchTo().window(onglet);
		 		myXpath = "//span[@id='labelMessage']";
		 		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 		
		 		//Changement de mot de passe
		 		myXpath = "//input[@id='txtMotDePasseActuel']";
		 		myXpath1 = "//input[@id='txtNouveauMotDePasse']";
		 		myXpath2 = "//input[@id='txtConfirmation']";
				MesFonctions.objet(driver,myXpath).sendKeys(mdp);
				MesFonctions.objet(driver,myXpath1).sendKeys(mdp2);
				MesFonctions.objet(driver,myXpath2).sendKeys(mdp2);
				
				//Valider
				driver.findElement(By.xpath("//input[@value='Valider']")).click();
				
				//Changer de window
		 		parentdWindow = MesFonctions.parentWindow(driver);
		 		driver.switchTo().window(parentdWindow);
		 		
				break;

			default:System.err.println("Aucune juridiction sélectionnée");
				break;
			}
	 		
	 		return null;
	 	}
	 	
	 	public static String rechercheSimple (WebDriver driver, String NUM_DOSSIER) throws Throwable {
	 		//Champs de recherche 
			String myXpath = "//input[@id='Entete1_MenuRecherche1_txtNumDossierRech']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).sendKeys(NUM_DOSSIER); 
			System.out.println("Le numéro de dossier "+NUM_DOSSIER+" a été renseigné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Clic sur le bouton Rechercher
			myXpath = "//a[@id='Entete1_MenuRecherche1_btn_rech_ok']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Click bouton \"RECHERCHER\" (écran de consultation de dossier)......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Vérification du num de dossier
			myXpath ="//a[@id='Mstr_cpMain_hlAccueil']/following-sibling::h1";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			boolean verif = MesFonctions.objet(driver,myXpath).getText().contains(NUM_DOSSIER);
			if(!verif) {
				System.err.println("Le dossier cherché n'est pas celui retourné par l'application....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				};
			System.out.println(NUM_DOSSIER +"?:"+verif);
	 		return null;
	 	}
	 	
	 	public static String telechargementDossier (WebDriver driver, WebElement element) throws Throwable {
	 		String message = "Vous avez atteint la limite autorisée";
	 		
	 		//Télécharger le fichier
			String myXpath = "//span[@class='button-text no-busy-loader' and (contains(text(),'Télécharger des pièces'))]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Clic sur \"Télécharger des pièces\"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//changement de fenêtre
			Thread.sleep(500);
			String onglet = MesFonctions.getWindow(driver, 2);
			driver.switchTo().window(onglet);
			
			//vérification de la fenêtre
			myXpath = "//div//p[text()='Télécharger des pièces']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à la fenêtre de téléchargment....."+MesFonctions.extractCurrentHeure());
			
			//Clic sur le bouton "Tous"
			myXpath = "//input[@id='gvListePJ_rbTous']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Clic sur le bouton \"TOUS\"......."+MesFonctions.extractCurrentHeure());
			
			//clic sur le bouton recherche
			myXpath = "//span[@class='button-text' and contains(text(),'Rechercher')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("ClicK sur le bouton \"RECHERCHER\"....."+MesFonctions.extractCurrentHeure());
			
			System.out.println("Recherche en cours...");
			myXpath = "//span[@id='gvListePJ_gvPJ_ctl02_lblDate']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Liste des fichiers affichée......"+MesFonctions.extractCurrentHeure());
			
			//clic sur le bouton recherche
			myXpath = "//span[@class='button-text' and contains(text(),'Enregistrer')]";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Clic sur le bouton \"ENREGISTRER\"......"+MesFonctions.extractCurrentHeure());
			
			//une alerte devrait apparaître fonction du poids du dossier et du nombre de téléchargement de ce dossier
			//Clic sur l'alerte
			myXpath = "//div[@id='ui-id-2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//			Alert alert = driver.switchTo().alert();
			Thread.sleep(100);
			boolean verif = MesFonctions.objet(driver, myXpath).getText().contains(message);
			
			if(verif==true) {
				throw new Exception("Trop de téléchargements sur ce dossier");
			}
			
//			alert.accept();
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Confirmation du téléchargement......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(200);
			
	 		return null;
	 	}
	 	
	 	public static String refusReqTr (WebDriver driver) throws Throwable {
	 		String myXpath = "//input[@id='btEnregistrer']"; 
	 		MesFonctions.objet(driver,myXpath);		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,myXpath));
			Thread.sleep(1000);
			
			//Clic sur le bouton Refuser
			myXpath = "//input[@id='btRefuser']";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Clic sur le bouton REFUSER........"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Accepter l'alerte
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			
			//Changer de fenêtre et vérification
			Thread.sleep(2000);
			String chilWindow = MesFonctions.childWindow(driver);
			driver.switchTo().window(chilWindow);
			myXpath = "//th[@style and text()=\"Renseigner le motif du refus :\"]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			driver.manage().window().maximize();
			Thread.sleep(2000);
			System.out.println("Ouverture de la fenêtre de Refus......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Texte du motif
			String texteRefus = "Le Lorem Ipsum\n"
					+ "est simplement du faux texte employé dans la composition et la mise en page avant impression.\n Le Lorem"
					+ "Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assemble"
					+ "ensemble des morceaux de texte";
			
			myXpath = "//textarea[@id='txtMotifRefus']";
			MesFonctions.objet(driver,myXpath).sendKeys(texteRefus);
			System.out.println("Motif renseigné");
			
			//Clic sur le bouton de refus
			myXpath = "//input[@id='btRefuser']";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Refus validé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Retour sur la fenêtre principale
			String parentWindow = MesFonctions.parentWindow(driver);
			driver.switchTo().window(parentWindow);
			
			//Acceptation de la PopUp 
			myXpath = "//span[@class='ui-button-text' and text()='OK']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
	 		return null;
	 	}
	 	
	 	public	static String verifTextRefus (WebDriver driver, String dossier) throws Throwable {
		//Clic sur la checkbox Refusées
			String myXpath = "//span[@class and contains(text(),\"Requêtes\")]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			myXpath = "//input[@id='cbEtatEnvoyees']";
			String myXpath1 = "//input[@id='cbEtatRefuseesParJuridiction']";
			MesFonctions.objet(driver, myXpath).click();
			MesFonctions.objet(driver, myXpath1).click();
			Thread.sleep(2000);
			
			//Clic sur le bouton rechercher
			myXpath = "//a[@id='lbRecherche']";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Clic sur le bouton Rechercher......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			myXpath = "//a[@class='numDossier' and (text()='"+dossier+"')]";
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Clic sur le lien du dossier : "+dossier+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Vérification de la page
			myXpath = "//span[@id='lblTRC']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Page du dossier Refusé");
			
			//verification du texte
			myXpath = "//textarea[@id='txtcommentaireMotifRejet']";
			String texte = MesFonctions.objet(driver,myXpath).getText();
			int lg = texte.length();
			if(lg==256) {
			System.out.println("Le texte comporte les : "+lg+" caractères");
			}else
			{
			System.err.println("Le texte comporte : "+lg+" caractères");
			}
			
		 return null;
	 }
	 
	 	public static String adminConsultationAvantInscript (WebDriver driver, String mdp) throws Throwable {
		 String  myXpath = "//input[@id='ctl00_cphBody_btnInscription']";
		 String myXpath1 = "//input[@id='ctl00_cphBody_btnConsultCourrier']";
		 String myXpath2 = "//div[@id='headerMasterCommun' and contains(text(),\"Télérecours - Inscription aux Téléprocédures\")]";
		 boolean verif = false;
		 Robot robot = new Robot();
		 if(MesFonctions.isElementPresent(driver, myXpath2, verif)) {
			 robot.keyPress(KeyEvent.VK_ALT);
			 robot.keyPress(KeyEvent.VK_LEFT);
			 robot.keyRelease(KeyEvent.VK_ALT);
			 robot.keyRelease(KeyEvent.VK_LEFT);
			 
			//soumettre le mot de passe
			 String myXpath3 = "//input[@id='ctl00_cphBody_txtPassword']";
			 MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
		    	MesFonctions.objet(driver, myXpath3).sendKeys(mdp);
		    	
		    	//Valider
		    	String myXpath5 = "//input[@id='ctl00_cphBody_btnValider']";
		    	MesFonctions.objet(driver,myXpath5).click();
		    	Thread.sleep(1000);
		 }
		 MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
		 System.out.println("La page de consultation est disponible...."+MesFonctions.extractCurrentHeure());
	
		  while(!MesFonctions.isElementPresent(driver, myXpath1, verif)) {
			  
				 robot.keyPress(KeyEvent.VK_F5);
				 robot.keyRelease(KeyEvent.VK_F5);
				 System.out.println("Le bouton n'est pas encore présent...."+MesFonctions.extractCurrentHeure()); 
		  }
		  MesFonctions.objet(driver, myXpath1).click();
			 System.out.println("Clic bouton consulter mes courriers...."+MesFonctions.extractCurrentHeure()); 
			 
		 myXpath = "//h1[text()=\"Consulter vos messages\"]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("Page de consultation...."+MesFonctions.extractCurrentHeure());
		 
		 myXpath1 = "//a[contains(@id,'cphBody_gvMessages')]";
		 MesFonctions.objet(driver, myXpath1).click();
		 
		 myXpath = "//p[contains(@id,'cphBody_txtAccuse')]";
		 String texte = "Un accusé de réception a été généré, la date d’AR sera visible dans le dossier Skipper dans un délai de quelques minutes.";
		 
		 verif = false;
		 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("Liste des pièces");
		 
		 Thread.sleep(1000);
		 verif = texte.equals(MesFonctions.objet(driver,myXpath).getText());
		 System.out.println("Le message est bien affiché "+verif+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 }
		 
		 System.err.println("Pas d'accusé envoyé......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 Thread.sleep(1000);
		 myXpath1 = "//a[contains(@id,'cphBody_hlRetour')]";
		 MesFonctions.objet(driver,myXpath1).click();
		 System.out.println("Clic bouton Retour");
		 
		 myXpath = "//input[@id='ctl00_cphBody_btnInscription']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,myXpath).click();
		 System.out.println("Clic bouton d'inscription......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
		 return null;
	 }
		 
	 	public static String consultationOngletHistoDossier(WebDriver driver) {
		 //Click bouton historique
		 String myXpath ="//a[@id='Mstr_cpMain_lbHistorique']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver, myXpath).click();
		 myXpath = "//th[@id='Mstr_cpMain_thPj']/a[@class='no-busy-loader']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("Accès à l'onglet \"HISTORIQUE\" du dossier........"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
		 return null; 
		 }
		
	 	public static void telechgtDossierOngletHisto(WebDriver driver, String NUM_DOSSIER) throws Throwable {
	 	 //Consulter l'ensemble des pièces du dossier depeuis l'onglet historique
		 String myXpath = "span[@class='page-detail-dossier-histo-fichiers']";
		 List<WebElement> elements = driver.findElements(By.xpath("//"+myXpath));
		 Thread.sleep(1000);
		 
			 for(WebElement a: elements) {
						if(!a.getText().equals("+")) {
							System.out.println("Résultat du getText(): "+a.getText()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
								a.click();
								Thread.sleep(200);
								break;
							}
					 }
		 
		 //Déplacer le curseur vers la PopUp
	 	 String onglet =  MesFonctions.getWindow(driver, 2);
	 	 driver.switchTo().window(onglet);
			 
		 //vérification de la page
		 myXpath = "//a[@id='lbTelecharger']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver, myXpath).click();
		 System.out.println("la PopUp de téléchargement est ouverte......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //télécharger la pièce
		 myXpath = "//span[@class='ui-button-text' and text()='OK']";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 MesFonctions.objet(driver,myXpath).click();
		 System.out.println("Téléchargment en cours....."+MesFonctions.extractCurrentHeure());
		 
		 System.out.println("Fenêtre d'archive fermée......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Retourner sur la page principale
		 onglet =  MesFonctions.getWindow(driver, 1);
	 	 driver.switchTo().window(onglet);
		 
		//Vérification sur l'interface
			String myXpath3 = "//td[@id='Mstr_cpEntete_Entete2_MenuActeur1_im1_AR']";
			MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath3).click();
			Thread.sleep(100);
			
			boolean verif = false;
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
									String mot = MesFonctions.objet(driver, myXpath).getText();
									System.out.println("Le fichier est à l'état : "+mot);
								}
							}
			//vérification des données en table
			Thread.sleep(200);
			JdbcClass.telechargement(NUM_DOSSIER);
		 }
		 
	 	public static String chgtDossierOngletHisto(WebDriver driver, WebElement element) throws Throwable {
	 	 //Consulter l'ensemble des pièces du dossier depeuis l'onglet historique /span[text()='+']
		 String myXpath = "span[@class='page-detail-dossier-histo-fichiers']";
		 List<WebElement> elements = driver.findElements(By.xpath("//"+myXpath));
		 Thread.sleep(1000);
		 
			 for(WebElement a: elements) {
						if(a.getText().equals("+")) {
							System.out.println("Résultat du getText(): "+a.getText()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
								a.click();
								Thread.sleep(2000);
								break;
							}
					 }
		 
		 //Déplacer le curseur vers la PopUp
	 	 String chilWindow = MesFonctions.childWindow(driver);
	 	 driver.switchTo().window(chilWindow);
		 	 
	 	 //vérification de la page
		 myXpath = "//span[@class='button-text' and text()=\"Enregistrer\"]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 System.out.println("la PopUp de enregistrement de pièces est ouverte......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
		 //Ajouter un fichier
		 myXpath = "//input[@id='fuAjouterFichier']";
		 MesFonctions.objet(driver,myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
		 Thread.sleep(1000);
		 System.out.println("le fichier est chargé");
		 
		 myXpath = "//select[@id='ddlTypeFichier']";
		 String value = "MEM";
		 MesFonctions.selection(driver, myXpath, value);
		 System.out.println("le type est défini......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		 
		 //Joindre le fichier
		 myXpath = "//span[@class='button-text' and text()=\"Joindre\"]";
		 MesFonctions.objet(driver,myXpath).click();
		 
		 //Vérification de la présence du fichier
		 myXpath = "//a[contains(@id,'fileLinkFichier_hplFichier')]";
		 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		 
		 //Enregistrement
		 myXpath = "//span[@class='button-text' and text()=\"Enregistrer\"]";
		 MesFonctions.objet(driver,myXpath).click();
		 
		//Retourner sur la page principale
		 String parentWindow = MesFonctions.parentWindow(driver);
		 driver.switchTo().window(parentWindow);
		 Thread.sleep(1000);
		 
		 return null;
		 }
		 
	 	public static String accueilPageTrc(WebDriver driver, String env) {
			 switch (env) {
			case "rec":
				//aller vers l'url de TRC
				 driver.get("https://citoyens.recette.telerecours.fr/");
				 String myXpath = "//h1[text()=\"Télérecours citoyens\"]";
				 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				 System.out.println("Page TRC......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
				break;
				
			case "int1" :
				driver.get("https://citoyens.int1.telerecours.fr/");
				 myXpath = "//h1[text()=\"Télérecours citoyens\"]";
				 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				 System.out.println("Page TRC......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				 
				break;

			default:System.out.println("Aucun environnement sélectionné....."+MesFonctions.extractCurrentHeure());
				break;
			}
			 
			 return null;
		 }
		 
 		public static String accueilPageTrcInt(WebDriver driver) {
			 //aller vers l'url de TRC
			 driver.get("https://citoyens.int1.telerecours.fr/");
			 String myXpath = "//h1[text()=\"Télérecours citoyens\"]";
			 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 System.out.println("Page TRC2......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 return null;
		 }
		 
		public static String suppMailHog (WebDriver driver, String mail) throws Throwable {
			String myXpath = " //div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
			@SuppressWarnings("unused")
			int tr = 0;
			 boolean verif = false;
			 boolean turn = false;
			 while (!turn) {
				 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
					 MesFonctions.objet(driver,myXpath).click();
					 String myXpath1 = "//i[@class='glyphicon glyphicon-trash']//parent::button";
					 MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
					 MesFonctions.objet(driver,myXpath1).click();
					 System.out.println("Le mail a été supprimé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
//					 String myXpath2 = "//button[@title='Back to Inbox']";
//					 mesFonctions.objet(driver,myXpath1).click();
				 } 
				 else {
					 	turn |=	true;
				 		}
				tr++;
			 }
			 System.out.println("Tous les mails "+mail+" ont été supprimés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			return null;
		}
		
		
		public static String mailDepotDoc(WebDriver driver, String mail, String verifUrl) throws Throwable {
			//Accès à MailHog
			String urlInt1 = "https://mail.int1.conseil-etat.fr/"; 
			String url = "https://mail.recette.conseil-etat.fr/";
			String currentUlr = "int1";
			boolean verif = verifUrl.contains(currentUlr);
			System.out.println("l'actuel URL est INT1 : "+verif);
			if(verif) {
			driver.get(urlInt1);
			}else {
				driver.get(url);
			}
			String myXpath = "//a[@class='navbar-brand']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à MailHog......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Recherche du mail
			 myXpath = "//div[@class='msglist-message row ng-scope']//child::span[text()=\"[Télérecours citoyens] Dépôt de vos documents\"]"
				 		+ "//parent::div//preceding-sibling::div[@class='col-md-3 col-sm-4 ng-binding']//child::div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
			 @SuppressWarnings("unused")
			 int tr = 0;
			 verif = false;
			 boolean turn = false;
			 while (!turn) {
				 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
				 	turn = true;
				 }else {
					 String myXpath0 = "//button[@title='Refresh']";
				 	MesFonctions.objet(driver,myXpath0).click();
				 	System.out.println("Click bouton refresh....."+MesFonctions.extractCurrentHeure());
				 	}
				tr++;
			 }
			 
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Le mail est selectionné......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			 driver.switchTo().frame("preview-html");
//			 myXpath = "//p[contains(text(),\"Vous avez\")]";
			 myXpath = "//td//h2//following-sibling::p";
			 String myXpath1 = "//td//h2//following-sibling::p[2]";
			 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 System.out.println(MesFonctions.objet(driver,myXpath).getText()+"\r"+MesFonctions.objet(driver,myXpath1).getText()+"\r");
			 
			 driver.switchTo().parentFrame();
			 myXpath = "//a[contains(text(),'Inbox')]";
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Retour à la boite de réception MailHog......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			
			return null;
			
		}
		
		
		public static String mailEnregDoc(WebDriver driver, String mail, String verifUrl) throws Throwable {
			//Accès à MailHog
			String urlInt1 = "https://mail.int1.conseil-etat.fr/"; 
			String url = "https://mail.recette.conseil-etat.fr/";
			String currentUlr = "int1";
			boolean verif = verifUrl.contains(currentUlr);
			System.out.println("l'actuel URL est INT1 : "+verif);
			if(verif) {
			driver.get(urlInt1);
			}else {
				driver.get(url);
			}
			String myXpath = "//a[@class='navbar-brand']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à MailHog");
			
			//Recherche du mail
			 myXpath = "//div[@class='msglist-message row ng-scope']//child::span[text()=\"[Télérecours citoyens] Enregistrement de votre document\"]"
				 		+ "//parent::div//preceding-sibling::div[@class='col-md-3 col-sm-4 ng-binding']//child::div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
			 @SuppressWarnings("unused")
			 int tr = 0;
			 verif = false;
			 boolean turn = false;
			 while (!turn) {
				 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
				 	turn = true;
				 }else {
					 String myXpath0 = "//button[@title='Refresh']";
				 	MesFonctions.objet(driver,myXpath0).click();
				 	System.out.println("click bouton refresh......"+MesFonctions.extractCurrentHeure());
				 	}
				tr++;
			 }
			 
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Le mail est selectionné......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			 driver.switchTo().frame("preview-html");
//			 myXpath = "//p[contains(text(),\"Votre/vos\")]";
			 myXpath = "//td//h2//following-sibling::p";
			 String myXpath1 = "//td//h2//following-sibling::p[2]";
			 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 System.out.println(MesFonctions.objet(driver,myXpath).getText()+"\r"+MesFonctions.objet(driver,myXpath1).getText()+"\r");
			 
			 driver.switchTo().parentFrame();
			 myXpath = "//a[contains(text(),'Inbox')]";
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Retour à la boite de réception MailHog......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			return null;
			
		}
		
		public static String mailDepotReq(WebDriver driver, String mail, String verifUrl) throws Throwable {
			//Accès à MailHog
			String int1 = "https://mail.int1.conseil-etat.fr/"; 
			String rec = "https://mail.recette.conseil-etat.fr/";
			String currentUlr = "int1";
			boolean verif = verifUrl.contains(currentUlr);
			System.out.println("l'actuel URL est INT1 : "+verif);
			if(verif) {
			driver.get(int1);
			}else {
				driver.get(rec);
			}
			String myXpath = "//a[@class='navbar-brand']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à MailHog......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Recherche du mail
			 myXpath = "//div[@class='msglist-message row ng-scope']//child::span[text()=\"[Télérecours citoyens] Votre dépôt de requête sur Télérecours citoyens\"]"
				 		+ "//parent::div//preceding-sibling::div[@class='col-md-3 col-sm-4 ng-binding']//child::div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
			 verif = false;
			 boolean turn = false;
			 while (!turn) {
				 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
				 	turn = true;
				 }else {
					 String myXpath0 = "//button[@title='Refresh']";
				 	MesFonctions.objet(driver,myXpath0).click();
				 	System.out.println("Click bouton refresh......."+MesFonctions.extractCurrentHeure());
				 	}
			 }
			 
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Le mail est selectionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			 driver.switchTo().frame("preview-html");
			 myXpath = "//td//h2//following-sibling::p";
			 String myXpath1 = "//td//h2//following-sibling::p[2]";
			 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 System.out.println(MesFonctions.objet(driver, myXpath).getText()+"\r"+MesFonctions.objet(driver, myXpath1).getText()+"\r");
			 
			 driver.switchTo().parentFrame();
			 myXpath = "//a[contains(text(),'Inbox')]";
			 MesFonctions.objet(driver, myXpath).click();
			 System.out.println("Retour à la boite de réception MailHog......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			
			return null;
			
		}
		
		
		public static String mailEnregReq(WebDriver driver, String mail, String verifUrl) throws Throwable {
			//Accès à MailHog
			String urlInt1 = "https://mail.int1.conseil-etat.fr/"; 
			String url = "https://mail.recette.conseil-etat.fr/";
			String currentUlr = "int1";
			boolean verif = verifUrl.contains(currentUlr);
			System.out.println("l'actuel URL est INT1 : "+verif);
			if(verif) {
			driver.get(urlInt1);
			}else {
				driver.get(url);
			}
			String myXpath = "//a[@class='navbar-brand']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à MailHog......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Recherche du mail
			 myXpath = "//div[@class='msglist-message row ng-scope']//child::span[text()=\"[Télérecours citoyens] Enregistrement de votre requête\"]"
				 		+ "//parent::div//preceding-sibling::div[@class='col-md-3 col-sm-4 ng-binding']//child::div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
			 @SuppressWarnings("unused")
			 int tr = 0;
			 verif = false;
			 boolean turn = false;
			 while (!turn) {
				 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
				 	turn = true;
				 }else {
					 String myXpath0 = "//button[@title='Refresh']";
				 	MesFonctions.objet(driver,myXpath0).click();
				 	System.out.println("click bouton refresh......"+MesFonctions.extractCurrentHeure());
				 	}
				tr++;
			 }
			 
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Le mail est selectionné......"+MesFonctions.extractCurrentHeure());
			 
			 driver.switchTo().frame("preview-html");
//			 myXpath = "//p[contains(text(),\"Votre requête a été enregistrée\")]";
			 myXpath = "//td//h2//following-sibling::p";
			 String myXpath1 = "//td//h2//following-sibling::p[2]";
			 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 System.out.println(MesFonctions.objet(driver,myXpath).getText()+"\r"+MesFonctions.objet(driver,myXpath1).getText()+"\r");
			 
			 driver.switchTo().parentFrame();
			 myXpath = "//a[contains(text(),'Inbox')]";
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Retour à la boite de réception MailHog......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			
			return null;
			
		}
		
		public static String mailRefusReq(WebDriver driver, String mail, String MonUrl) throws Throwable {
			//Accès à MailHog
			String url = "";
			if(MonUrl.contains("int1")) {
				url = "https://mail.int1.conseil-etat.fr/";
			}
			else {
				url = "https://mail.recette.conseil-etat.fr/";
			}
			driver.get(url);
			String myXpath = "//a[@class='navbar-brand']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à MailHog......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Recherche du mail
			 myXpath = "//div[@class='msglist-message row ng-scope']//child::span[text()=\"[Télérecours citoyens] Votre requête a été refusée\"]"
				 		+ "//parent::div//preceding-sibling::div[@class='col-md-3 col-sm-4 ng-binding']//child::div[@class='ng-binding ng-scope' and contains(text(),'"+mail+"')]";
			 @SuppressWarnings("unused")
			 int tr = 0;
			 boolean verif = false;
			 boolean turn = false;
			 while (!turn) {
				 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true) {
				 	turn = true;
				 }else {
					 String myXpath0 = "//button[@title='Refresh']";
				 	MesFonctions.objet(driver,myXpath0).click();
				 	System.out.println("click bouton refresh......"+MesFonctions.extractCurrentHeure());
				 	}
				tr++;
			 }
			 
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Le mail est selectionné......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			 driver.switchTo().frame("preview-html");
			 myXpath = "//td//h2//following-sibling::p";
			 String myXpath1 = "//td//h2//following-sibling::p[2]";
			 MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			 System.out.println(MesFonctions.objet(driver,myXpath).getText()+"\r"+MesFonctions.objet(driver,myXpath1).getText()+"\r");
			 
			 driver.switchTo().parentFrame();
			 myXpath = "//a[contains(text(),'Inbox')]";
			 MesFonctions.objet(driver,myXpath).click();
			 System.out.println("Retour à la boite de réception MailHog......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			 
			return null;
			
		}
		
		public static String suppression_Mail_MailHog(WebDriver driver, String mail, String env) throws Throwable {
			//Vérification des mail
			MicroFonctions.suppMailHog(driver, mail);
			driver.close();
			MesFonctions.transitWindow(driver, 1);
			
			return null;
		}
		
		
		public static void compareList(List<String> lst, List<String> list) {
			try {

				if(lst.size() == list.size()) {
					for(int i=0;i<lst.size();i++) {
						if(!lst.get(i).equals(list.get(i))) {
							
							System.err.println("Elément différent : "+lst.get(i)+" **** "+list.get(i));
							}
						}

				}else {
					System.err.println("ERROR : la taille des listes est différente ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
				
				} catch (Exception e) {
				
			}
		}
		
		public static void authentification_OAE(WebDriver driver, String identifiant, String mdp) {
			//Accès à l'URL OAE : https://oaecnda.recette.conseil-etat.fr
			driver.get("https://oaecnda.recette.conseil-etat.fr/#/login");
			System.out.println("Accès à l'URL OAE : https://oaecnda.recette.conseil-etat.fr......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Identifiant
			String myXpath = "//input[@id='username']";
			String myXpath1 = "//input[@id='password']";
			String myXpath2 = "//button[@class='oae-button']";
			
			//
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(identifiant);
			MesFonctions.objet(driver, myXpath1).sendKeys(mdp);
			MesFonctions.objet(driver, myXpath2).click();
			
			System.out.println("Validation des identifiants Username : "+identifiant+" mot de passe : "+mdp+"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
			
		}
		
		public static void Verification_AvocatOAE_Inactif(WebDriver driver, List<String> lst) throws Throwable {
			//Verififier l'existence d'un avocat dans les listes de l'OAE
			String myXpath = "//input[contains(@id,'mat-input')]";
			
			//Insertion des nom avocat
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			if(lst.size()!=0) {
				for(int i=0; i<lst.size(); i++) {
					//Nom de l'avocat renseigné
					MesFonctions.objet(driver, myXpath).sendKeys(lst.get(i));
					Thread.sleep(100);
					System.out.println("Le nom de l'avocat est renseigné....."+MesFonctions.extractCurrentHeure());
					
					//Récupération du message d'erreur s'il existe
					String myXpath1 = "//mat-error[contains(@id,'mat-error')]";

					boolean verif = false;
						if(MesFonctions.isElementPresent(driver, myXpath1, verif) && MesFonctions.objet(driver, myXpath1).getText().trim().length()!=0) {
							System.out.println(MesFonctions.objet(driver, myXpath1).getText().trim());
							MesFonctions.objet(driver, myXpath).clear();
							}else {
								System.err.println("Aucun message présent pour l'utilisateur "+lst.get(i)+" qui est pourtant INACTIF....."+MesFonctions.extractCurrentHeure());
								MesFonctions.objet(driver, myXpath).clear();
							}
						}
					}else {
						System.err.println("La liste est vide...."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
					}
			}
		
		
		public static void Verification_AvocatOAE_Actif(WebDriver driver, List<String> lst) throws Throwable {
			//Verififier l'existence d'un avocat dans les listes de l'OAE
			String myXpath = "//input[contains(@id,'mat-input')]";
			
			//Insertion des nom avocat
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			if(lst.size()!=0) {
				for(int i=0; i<lst.size(); i++) {
					//Nom de l'avocat renseigné
					MesFonctions.objet(driver, myXpath).sendKeys(lst.get(i));
					Thread.sleep(100);
					System.out.println("Le nom de l'avocat est renseigné....."+MesFonctions.extractCurrentHeure());
					
					//Récupération du message d'erreur s'il existe
					String myXpath1 = "//mat-option[contains(@id,'mat-option')]//span";
					boolean verif = false;
					
					if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
							//Vérification que le nom de l'utilisateur est présent dans la liste de nom
							List<WebElement> myList = driver.findElements(By.xpath(myXpath1));
							int tailleListe = myList.size();
							
								for(int j=0;j<tailleListe;j++) {
									
									if(MesFonctions.isElementPresent(driver, "("+myXpath1+")"+"["+j+"]", verif) && MesFonctions.recuperation_Majuscule_String(myList.get(j).getText()).equals(lst.get(i))) {
										System.out.println("le nom "+lst.get(i)+" a bien été trouvé dans la liste : "+myList.get(j).getText());
										MesFonctions.objet(driver, myXpath).clear();
									}else {
										System.err.println("Aucun nom ne correspond à l'avocat "+lst.get(i)+" , il pourrait s'agir du prénom de l'avocat \""+myList.get(j).getText()+"\"....."+MesFonctions.extractCurrentHeure());
										MesFonctions.objet(driver, myXpath).clear();
											}
										}
								}else {
									System.out.println("Cet avocat n'est pas présent dans la liste..... "+MesFonctions.extractCurrentHeure());
									MesFonctions.objet(driver, myXpath).clear();
								}
							}
						}else {
							System.err.println("La liste est vide...."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
							}
					}
		
		public static void Verification_AvocatOAE_Inactif1(WebDriver driver, List<String> lst) throws Throwable {
			//Verififier l'existence d'un avocat dans les listes de l'OAE
			String myXpath = "//input[contains(@id,'mat-input')]";
			
			//Insertion des nom avocat
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			if(lst.size()!=0) {
				for(int i=0; i<lst.size(); i++) {
					//Nom de l'avocat renseigné
					MesFonctions.objet(driver, myXpath).sendKeys(lst.get(i));
					Thread.sleep(100);
					System.out.println("Le nom de l'avocat est renseigné....."+MesFonctions.extractCurrentHeure());
					
					//Récupération du message d'erreur s'il existe
					String myXpath1 = "//mat-error[contains(@id,'mat-error')]";

					boolean verif = false;
						if(MesFonctions.isElementPresent(driver, myXpath1, verif) && MesFonctions.objet(driver, myXpath1).getText().trim().length()!=0) {
							System.out.println(MesFonctions.objet(driver, myXpath1).getText().trim());
							MesFonctions.objet(driver, myXpath).clear();
							}else {
								String myXpath2 = "//mat-option[contains(@id,'mat-option')]//span";
								
								if(MesFonctions.isElementPresent(driver, myXpath2, verif)) {
									//Vérification que le nom de l'utilisateur est présent dans la liste de nom
									List<WebElement> myList = driver.findElements(By.xpath(myXpath2));
									int tailleListe = myList.size();
									
										for(int j=0;j<tailleListe;j++) {
											
											if(MesFonctions.isElementPresent(driver, "("+myXpath2+")"+"["+j+"]", verif) && myList.get(j).getText().trim().equals(lst.get(i))) {
												System.out.println("le nom "+lst.get(i)+" a bien été trouvé dans la liste : "+myList.get(j).getText());
												MesFonctions.objet(driver, myXpath).clear();
											}else {
												System.err.println("Le nom : "+lst.get(i)+" en BDD, est différent de celui affiché sur le site : \""+myList.get(j).getText()+"\"....."+MesFonctions.extractCurrentHeure());
												MesFonctions.objet(driver, myXpath).clear();
													}
												}
											}
								System.err.println("Aucun message présent pour l'utilisateur "+lst.get(i)+" qui est pourtant INACTIF....."+MesFonctions.extractCurrentHeure());
								MesFonctions.objet(driver, myXpath).clear();
							}
						}
					}else {
						System.err.println("La liste est vide...."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
					}
			}
		
		public static void Verification_AvocatOAE_Actif1(WebDriver driver, List<String> lst) throws Throwable {
			//Verififier l'existence d'un avocat dans les listes de l'OAE
			String myXpath = "//input[contains(@id,'mat-input')]";
			List<String> listAvocatNonPresent = new ArrayList<>();
			
			//Insertion des nom avocat
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			if(lst.size()!=0) {
				for(int i=0; i<lst.size(); i++) {
					//Nom de l'avocat renseigné
					MesFonctions.objet(driver, myXpath).sendKeys(lst.get(i));
					Thread.sleep(100);
					System.out.println("Le nom de l'avocat est renseigné....."+MesFonctions.extractCurrentHeure());
					
					//Récupération du message d'erreur s'il existe
					String myXpath1 = "//mat-option[contains(@id,'mat-option')]//span";
					String myXpath2 = "//mat-error[contains(@id,'mat-error')]";
					boolean verif = false;
					
					if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
							//Vérification que le nom de l'utilisateur est présent dans la liste de nom
							List<WebElement> myList = driver.findElements(By.xpath(myXpath1));
							int tailleListe = myList.size();
							
								for(int j=0;j<tailleListe;j++) {
									
									if(MesFonctions.isElementPresent(driver, "("+myXpath1+")"+"["+j+"]", verif) && myList.get(j).getText().equals(lst.get(i))) {
										System.out.println("le nom "+lst.get(i)+" a bien été trouvé dans la liste : "+myList.get(j).getText());
										MesFonctions.objet(driver, myXpath).clear();
									}else {
										System.err.println("Aucun nom ne correspond à l'avocat "+lst.get(i)+", il pourrait s'agir du prénom de l'avocat \""+myList.get(j).getText()+"\"....."+MesFonctions.extractCurrentHeure());
										MesFonctions.objet(driver, myXpath).clear();
											}
										}
								}else if(!MesFonctions.isElementPresent(driver, myXpath1, verif) && !MesFonctions.isElementPresent(driver, myXpath2, verif)) {
									System.out.println("le nom "+lst.get(i)+" a bien été trouvé");
									MesFonctions.objet(driver, myXpath).clear();
									}
									else {
										if(MesFonctions.isElementPresent(driver, myXpath2, verif)) {
											System.err.println("Cet avocat : "+lst.get(i)+" n'est pas présent dans la liste..... "+MesFonctions.extractCurrentHeure());
											
											listAvocatNonPresent.add(lst.get(i).trim());
											System.out.println(listAvocatNonPresent);
											MesFonctions.objet(driver, myXpath).clear();
										}
										
									}
							}
						}else {
							System.err.println("La liste est vide...."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
							}
					}
		
		public static void PDF_ecrire_decision(String dossier) throws DocumentException, ParseException {
			try {
				Document doc = new Document();
				PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Decision.pdf"));
			    
			    
			    //opens the PDF  
			    doc.open();
			    System.out.println("Le document est ouvert....."+MesFonctions.extractCurrentHeure()); 
			    
			    //Ajout de la date
			    doc.addCreationDate();
			    System.out.println("Le document est daté....."+MesFonctions.extractCurrentHeure()); 
			    
			    //Ajouter un titre
			    doc.addTitle("DECISION - "+dossier);
			    System.out.println("Le document est titré....."+MesFonctions.extractCurrentHeure()); 
			    
			    //adds paragraph to the PDF file  
			    doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at eros nisl. Suspendisse commodo congue felis eu molestie. Proin luctus dolor ac aliquam commodo. "
			    		+ "Integer consectetur neque in odio blandit condimentum. Suspendisse lacinia purus sit amet iaculis sollicitudin. Duis eleifend eu turpis eget ornare. "
			    		+ "Aenean in augue porta, sollicitudin nisl non, gravida justo. Morbi sagittis id dolor eget tristique. Proin sit amet venenatis augue, ut ornare mauris. "
			    		+ "Pellentesque leo urna, venenatis id eros id, mattis vestibulum turpis. Proin egestas nunc vitae lorem ultrices auctor. Nullam sit amet faucibus magna. "
			    		+ "In vel velit ante. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\r\r"+MesFonctions.currentTime()));
			    System.out.println("Le paragraphe est ajouté....."+MesFonctions.extractCurrentHeure()); 
			    
			  //close the PDF file  
			    doc.close();
			    System.out.println("Le document est fermé....."+MesFonctions.extractCurrentHeure()); 
			    
			    //close writer
			    writer.close();
			    
			    System.out.println("PDF est créé....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");  
				} catch (IOException e) {
			        e.printStackTrace();
			    }
		}
		
		public static void PDF_ecrire_requete(String dossier) throws DocumentException, ParseException {
			try {
				Document doc = new Document();
				
				//définition du chemin de la pièce
				String name = "5 Requete.pdf";
				ClassLoader classLoader = ClassLoader.getSystemClassLoader();
				File file = new File(classLoader.getResource(name).getFile());
				String absolutePath = file.getAbsolutePath().replace("%20", " ");
				
				PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(absolutePath));
			    
			    //opens the PDF  
			    doc.open();
			    System.out.println("Le document est ouvert....."+MesFonctions.extractCurrentHeure()); 
			    
			    //Ajout de la date
			    doc.addCreationDate();
			    System.out.println("Le document est daté....."+MesFonctions.extractCurrentHeure()); 
			    
			    //Ajouter un titre
//			    String str = "REQUÊTE "+dossier+"( numéro provisoire)";
//			    Font font = new Font(str, Font.ITALIC, 18);
			    doc.addTitle(dossier);
			    System.out.println("Le document est titré....."+MesFonctions.extractCurrentHeure()); 
			    
			    //adds paragraph to the PDF file  
			    doc.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at eros nisl. Suspendisse commodo congue felis eu molestie. Proin luctus dolor ac aliquam commodo. "
			    		+ "Integer consectetur neque in odio blandit condimentum. Suspendisse lacinia purus sit amet iaculis sollicitudin. Duis eleifend eu turpis eget ornare. "
			    		+ "Aenean in augue porta, sollicitudin nisl non, gravida justo. Morbi sagittis id dolor eget tristique. Proin sit amet venenatis augue, ut ornare mauris. "
			    		+ "Pellentesque leo urna, venenatis id eros id, mattis vestibulum turpis. Proin egestas nunc vitae lorem ultrices auctor. Nullam sit amet faucibus magna. "
			    		+ "In vel velit ante. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\r\r"+MesFonctions.currentTime()));
			    System.out.println("Le paragraphe est ajouté....."+MesFonctions.extractCurrentHeure()); 
			    
			  //close the PDF file  
			    doc.close();
			    System.out.println("Le document est fermé....."+MesFonctions.extractCurrentHeure()); 
			    
			    //close writer
			    writer.close();
			    
			    System.out.println("PDF est créé....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");  
				} catch (IOException e) {
			        e.printStackTrace();
			    }
		}
		
		public static void ajout_fichier_requete_page_verification(WebDriver driver) throws Throwable {
		//Click bouton "MODIFIER" 
		String myXpath = "//span[@class='button-text' and text()=\"Modifier la requête\"]";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Click bouton \"MODIFIER LA REQUETE\"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Retour page "Préparer l'envoi d'une requête"
		myXpath = "//h2[@class='depot-requete']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Retour à la page \"Préparer l'envoi d'une requête\"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Création de la pièce à ajouter
		myXpath = "//input[@id='Mstr_cpMain_txtNumDossier']";
		MicroFonctions.PDF_ecrire_requete(MesFonctions.objet(driver, myXpath).getDomAttribute("value"));
		
		//Modification du fichier de la requête 
		myXpath = "//input[@id='Mstr_cpMain_FileUploadRequeteFichier_fileUpload']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		String name = "5 Requete.pdf";
		MesFonctions.insertion_file(driver, myXpath, name);
//		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\5 Requete.pdf");
		System.out.println("La pièce est chargée....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//vérification de la pièce ajoutée
		myXpath =  "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
		MicroFonctions.pdfVerfication(driver, myXpath);
		}
		
		public static void date_picker_Tr(WebDriver driver, String date) throws InterruptedException {
			//Sélection de la date depuis le tableau datePicker
			String day = date.split("/")[0];
			String mois = date.split("/")[1];
			String year = date.split("/")[2];
			
			Integer myInt = MesFonctions.convertStringTo_Integer(mois);
			Integer nbr = myInt - 1;
			String month = nbr.toString();
			System.out.println("Sélection de la date de dépôt :\rVoici le jour choisi : "+day+"\rLe mois choisi : "+month+"\rL'année choisie : "+year);
			
			//Ouverture du calendrier
			String myXpath = "//input[@id='Mstr_cpMain_txtDateDecAttCAA']";
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Ouverture du calendrier....."+MesFonctions.extractCurrentHeure()+"\r");
			
			myXpath = "//select[@class='ui-datepicker-month']";
			String myXpath1 = "//select[@class='ui-datepicker-year']";
			String myXpath2 = "//div[@id='ui-datepicker-div']//a[@class='ui-state-default' and text()='"+day+"']";
			
			//Choix de la date
			MesFonctions.selection(driver, myXpath, month);
			System.out.println("Le MOIS est sélectionné "+MesFonctions.extractCurrentHeure());
			
			MesFonctions.selection(driver, myXpath1, year);
			System.out.println("L'ANNEE est sélectionnée "+MesFonctions.extractCurrentHeure());
			
			Thread.sleep(300);
			MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath2).click();
			System.out.println("Le JOUR est sélectionné "+MesFonctions.extractCurrentHeure());
			
		}
		
		public static void Verification_Alerte_Erreur_Compte_Desactive(WebDriver driver) throws Throwable {
			String myXpath = "//div[@class='alert alert-danger']";
			boolean verif = false;
			if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				myXpath = "//div[@class='alert alert-danger']//li";
				System.out.println("Alerte : "+MesFonctions.objet(driver, myXpath).getText());
			}
		}
}

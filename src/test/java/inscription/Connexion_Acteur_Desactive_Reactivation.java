package inscription;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class Connexion_Acteur_Desactive_Reactivation {
	WebDriver driver;
	   String password;
	   String browserName;
	   String identifiant;
	   String mdp;
	   String nom;
	   Integer ANJ_AEXID;
	   String env;
	   String jur;
	
	@Test (priority = 1)
	public void Initialisation_BD () throws SQLException {
		env = "rec";
		nom = "tr_commun";
		mdp = "tr_commun";
		ANJ_AEXID = 20658;
		jur = "TA";
		identifiant = "aja1XOV";//chaNC4d ; aja1XOV
		password = "Conseiletat123456*";//Conseiletat123456*
		
		JdbcClass.conDBTR(nom, mdp, env);
		JdbcClass.Desactivation_Compte(identifiant);
		
	}
	
	@Test (priority = 2)
	public void Connexion() throws Throwable {
		browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
	try {
		switch (jur) {
		case "TA":
			if(env.equals("rec")) {
				driver.get("https://authentification.recette.telerecours.fr/");
				String myXpath = "//a[@href='https://www.telerecours.recette.juradm.fr']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).click();
			}
			else {
				driver.get("https://authentification.int1.telerecours.fr/");
				String myXpath = "//a[@href='https://www.telerecours.int1.juradm.fr']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).click();
			}
			break;
			
		case "CTX":
			if(env.equals("rec")) {
				driver.get("https://authentification.recette.telerecours.fr/");
				String myXpath = "//a[@href='https://www.telerecours.recette.conseil-etat.fr']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).click();
			}
			else {
				driver.get("https://authentification.int1.telerecours.fr/");
				String myXpath = "//a[@href='https://www.telerecours.int1.conseil-etat.fr']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).click();
			}
			break;

		default:
			break;
		}
	} catch (Exception e) {
		My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
	}	  
		}
		
	   @Test (priority = 3)
	   public void Authentification () throws Throwable {
		   try {
			   MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
			   MicroFonctions.Verification_Alerte_Erreur_Compte_Desactive(driver);
		} catch (Exception e) {
			 My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
			} 
	   }
	   
	   
	   @Test (priority = 4)
	   public void Reactivation_Compte () throws Throwable {
		 
		JdbcClass.conDBTR(nom, mdp, env);
		JdbcClass.Activation_Compte(identifiant);
		   
	   try { 
			MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
			if(jur=="TA") {
				   MicroFonctions.choixJuridictionTA(driver); 
			   }
			MicroFonctions.deconnexionTrExt(driver);
		  }catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			   e.printStackTrace();
		  }
		
	   }
	   
	   
	   @Test(priority = 5)
	   public void Desactivation_Acteur() throws Throwable {
		   
		 JdbcClass.conDBTR(nom, mdp, env);
		 JdbcClass.Désactivation_Compte_Acteur(ANJ_AEXID);
		   
		  try {
			    MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
			    MicroFonctions.Verification_Alerte_Erreur_Compte_Desactive(driver);  
		   }catch (Exception e) {
				My_SreenShot.takeScreenshot(driver);
				   e.printStackTrace();
		   }
	   }
	   
	   
	   @Test(priority = 6)
	   public void Activation_Acteur() throws Throwable {
		   
		 JdbcClass.conDBTR(nom, mdp, env);
		 JdbcClass.Activation_Compte_Acteur(ANJ_AEXID);
		   
		  try {
			    MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
			    if(jur=="TA") {
					   MicroFonctions.choixJuridictionTA(driver); 
				   }
			    MicroFonctions.deconnexionTrExt(driver);
		   }catch (Exception e) {
				My_SreenShot.takeScreenshot(driver);
				   e.printStackTrace();
		   }
		  
		  driver.close();
	   }
}

package inscription;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import fonctionnalites.MicroFonctions;

public class Creation_Utilisateur_Structure {
	WebDriver driver;
	   String browserName;
	   String env;
	   String acteur;
	   String mdp;
	   Integer count;
	   String mail;
	   String jur;
	   String DB_id;
	   String DB_mdp;

   @Test(priority = 1)  
   public void connection_navigateur() throws IOException {
	   browserName = "firefox";
	   env = "rec";
	   jur = "TA";
	   acteur = "bacFa3C";
	   mdp = "Lhommeest2019*";
	   count = 0;
	   
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   driver.get("https://www.telerecours.recette.juradm.fr/");
   }
   
   @Test(priority = 2)
   public void connection_acteur() throws Throwable {
	  MicroFonctions.AuthentificationTaCaaCeExt(driver, acteur, mdp);
	  MicroFonctions.choixJuridictionTA(driver);
   }
	 
   @Test(priority = 3)
   public void ajout_nouvel_acteur() throws Throwable {
	 while(count<20) {
	 Inscription_menu_superviseur.gestion_utilisateur(driver);
	 mail = Inscription_menu_superviseur.création_nouvel_acteur(driver, acteur, count);
	  
	 MicroFonctions.mailYop(driver, mail); 
	 MicroFonctions.Inscription(driver, jur);
	 
	 MicroFonctions.deconnexionTrExt(driver);
	 
	 MicroFonctions.AuthentificationTaCaaCeExt(driver, acteur, mdp);
	 MicroFonctions.choixJuridictionTA(driver);
	 
	 count++;
	  }
  }
   
   @Test(priority = 4)
   public void suppression_compte() throws SQLException {
		//base de donnée
	   env ="rec";
	   JdbcClass.conDBTR("tr_commun", "tr_commun", env);
		
		//Suppression des utilisateurs
		JdbcClass.suppression_utilisateur();
   }
   
   @AfterSuite
   public void deconnexion() throws InterruptedException {
	   MicroFonctions.deconnexionTrExt(driver);
	   driver.close();
   }
	  	  
}

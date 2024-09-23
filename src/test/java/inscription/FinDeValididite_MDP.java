package inscription;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class FinDeValididite_MDP {
	
	WebDriver driver;
	   String password;
	   String password1;
	   String browserName;
	   String identifiant;
	   String mdp;
	   String nom;
	   String env;
	   String name;
	   int ANJ_AEXID;
	   int duree;
	   String jur;
	   
	   @Test(priority = 1)
		public void Initialisation () throws SQLException, Throwable {
			env = "rec";
			nom = "tr_commun";
			mdp = "tr_commun";
			name = "GIANIS";
			ANJ_AEXID = 20661;
			duree = 367;//{"WarningDelay": 10,"MaximumPasswordAge": 365}
			jur = "CTX";
			identifiant = "gia458f";
			password = "Lhommeest2019*";
			
			
			JdbcClass.conDBTR(nom, mdp, env);
			JdbcClass.mdpValidite(duree, name, ANJ_AEXID);
			Thread.sleep(300);
		}

	   @Test(priority = 2)
		public void updateDB () throws SQLException {
		   browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   switch (jur) {
			case "TACAA":
				if(env.equals("rec")) {
					driver.get("https://www.telerecours.recette.juradm.fr/");
				}
				else {
					driver.get("https://www.telerecours.int1.juradm.fr/");
				}
				break;
				
			case "CTX":
				if(env.equals("rec")) {
					driver.get("https://www.telerecours.recette.conseil-etat.fr/");
				}
				else {
					driver.get("https://www.telerecours.int1.conseil-etat.fr/");
				}
				break;
			default:System.err.println("Cette juridiction n'est pas connue....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
				break;
			}
		}
	   
	   @Test(priority = 3)
	   public void mot_de_passe_trop_long() throws Throwable {
		 //authentification
		   try {
		   password1 = "Jtbe3ox3pZ vFGOtAWWTa1L]R[4)89";//{"Letters": "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ","SpecialChars": "()-_éèà=*{}[]ç","Digits": "0123456789","MinLength": 12,"MaxLength": 30} exclure : ><$£¤%@+:/\.#~&²!?;€,
		   MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
		   MicroFonctions.mot_de_passe_passant_nonpassant(driver, password, password1);
		   }
		   catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		 }
	   }
		 
	   @Test(priority = 4)
	   public void mot_de_passe_trop_court() throws Throwable {
		 //authentification
		   try {
		   password1 = "Jtbe3ox3pZ";//{"Letters": "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ","SpecialChars": "()-_éèà=*{}[]ç","Digits": "0123456789","MinLength": 12,"MaxLength": 30} exclure : ><$£¤%@+:/\.#~&²!?;€,
		   MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
		   MicroFonctions.mot_de_passe_passant_nonpassant(driver, password, password1);
		   }
		   catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		 }  
	   }
	   
	   @Test(priority = 5)
	   public void mot_de_passe_caracteres_interdits() throws Throwable {
		 //authentification
		   try {
		   password1 = "Jtbe3ox3pZvFGOtAWWTa1L]R[4)89+";//{"Letters": "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ","SpecialChars": "()-_éèà=*{}[]ç","Digits": "0123456789","MinLength": 12,"MaxLength": 30} exclure : ><$£¤%@+:/\.#~&²!?;€,
		   MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
		   MicroFonctions.mot_de_passe_passant_nonpassant(driver, password, password1);
		   }
	       catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		 }
	   }
	   
	   @Test(priority = 6)
	   public void mot_de_passe_max_caracteres() throws Throwable {
		 //authentification
		   try {
		   password1 = "Q(D5YI6UlnZ53EV{)V}J0ymoUsZ*Xr";//{"Letters": "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ","SpecialChars": "()-_éèà=*{}[]ç","Digits": "0123456789","MinLength": 12,"MaxLength": 30} exclure : ><$£¤%@+:/\.#~&²!?;€,
		   MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, password);
		   MicroFonctions.mot_de_passe_passant_nonpassant(driver, password, password1);
		   }
		   catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		 }
	   }
	   
	   @Test(priority = 7)
	   public void authentification_nouveau_mdp() throws Throwable {
		 //authentification
		   try {
		   password = "Q(D5YI6UlnZ53EV{)V}J0ymoUsZ*Xr";
		   MicroFonctions.authentification_nouveau_Mdp(driver, jur, identifiant, password);
		   MicroFonctions.deconnexionTrExt(driver);
		   }
		   catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		 }
	   }
}

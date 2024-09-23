package inscription;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;

public class mdpValidite {
	WebDriver driver; 
	   String username;
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
	   String choixJur;
	   
 
	@Test(priority = 1)
	public void update_db () throws SQLException, Throwable {
		env = "rec";
		nom = "tr_commun";
		mdp = "tr_commun";
		name = "GIANIS";
		ANJ_AEXID = 20661;
		duree = 363;//{"WarningDelay": 10,"MaximumPasswordAge": 365}
		choixJur = "TACAA";
		identifiant = "gia458f"+"\t"+"\n"+"\0"+"\r"+"\b";
		password = "Lhommeest2019*";
		password1 = "Jtbe3ox3pZ vFGOtAWWTa1L]R[4)89";//{"Letters": "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ","SpecialChars": "()-_éèà=*{}[]ç","Digits": "0123456789","MinLength": 12,"MaxLength": 30} exclure : ><$£¤%@+:/\.#~&²!?;€,
		
		JdbcClass.conDBTR(nom, mdp, env);
		JdbcClass.mdpValidite(duree, name, ANJ_AEXID);
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void Initialisation () throws SQLException {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	}
	
	
	@Test(priority = 3)
	public void Authentification () throws Throwable {
		try {
		//Connexion avec un mot de passe expiré et changement de mot de passe
		MicroFonctions.mdpFinValidite(driver, identifiant, password, choixJur);
		
		//Changement de mot de passe depuis les préférences utilisateurs
		MicroFonctions.PrefUserChangeMdp(driver, password1, choixJur);
		
		}catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void déconnexion() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		System.out.println("Déconnexion réussie");
		Thread.sleep(2000);
	}
			
	@Test(priority = 5)
	public void fin() {
		System.out.println("LE TEST EST TERMINE !!!");
		driver.quit();
	}
	
}

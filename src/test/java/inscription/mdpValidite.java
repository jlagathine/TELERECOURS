package inscription;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;

public class mdpValidite {
	WebDriver driver;
	   DesiredCapabilities caps;
	   WebElement element; 
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
	   
 
	@BeforeSuite
	public void Initialisation () throws SQLException, Throwable {
		env = "rec";
		nom = "tr_commun";
		mdp = "tr_commun";
		name = "GIANIS";
		ANJ_AEXID = 20661;
		duree = 367;
		
		JdbcClass.conDBTR(nom, mdp, env);
		JdbcClass.mdpValidite(duree, name, ANJ_AEXID);
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void updateDB () throws SQLException {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	}
	
	@Test
	public void Authentification () throws Throwable {
		try {
		choixJur = "TACAA";
		identifiant = "gia458f";
		password = "Lhommeest2019*";
		password1 = "Lhommeest2019**";
		//Connexion avec un mot de passe expiré et changement de mot de passe
		MicroFonctions.mdpFinValidite(driver, identifiant, password, choixJur);
		
		//Changement de mot de passe depuis les préférences utilisateurs
		MicroFonctions.PrefUserChangeMdp(driver, password1, choixJur);
		
		}catch(Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void déconnexion() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		System.out.println("Déconnexion réussie");
		Thread.sleep(2000);
	}
			
	@AfterSuite
	public void fin() {
		System.out.println("LE TEST EST TERMINE !!!");
		driver.quit();
	}
	
}

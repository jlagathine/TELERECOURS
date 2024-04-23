package rpva;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import Juridictions.JurRpvaInscript;
import browser.NavigaChromHeader;

public class rpvaConexion {
	WebDriver driver;
	WebElement element;
	String cnbf;
	String value;
	String name;
	String env;
	String mdp;
	String choixJur;
	Integer ANJ_AEXID;
	Integer RPVA_AVOCAT_ID;
	
	
	@BeforeSuite
	public void Initialisation() throws Throwable {
		env = "rec";
		choixJur = "Conseil";
		name = "tr_commun";
		mdp = "tr_commun";
		cnbf = "CNBF";
		value = "00002";
		RPVA_AVOCAT_ID = 529196;
		ANJ_AEXID = 22701;
		
		//initialisation du navigateur
		driver = NavigaChromHeader.chromeHeader();
	   	System.out.println(driver);
		
		//conexion à la base de données
	   	JdbcClass.conDBTR(name, mdp, env);
	   	Thread.sleep(2000);
	   	
		//paramétrage extension modHeader  
	   	NavigaChromHeader.extension(driver, cnbf, value);	   
	}
	
	 @BeforeMethod
	   public void connexEdentitas() throws Throwable  {
		 //Connexion à TR
		 JurRpvaInscript.connexion(driver, element, choixJur); 
	   }
	 
	 @Test
	 public void connexionJur() throws Throwable {
		//Connexion à la plateforme Edentitas
		 JurRpvaInscript.edentitasIntegrerStruct(driver, element, choixJur);	 
	}
	 
	 @AfterMethod
		public void déconnexion() throws Exception {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
			System.out.println("Déconnexion réussie");
			Thread.sleep(2000);
		}
				
		@AfterSuite
		public void fin() throws SQLException, Throwable {
			System.out.println("LE TEST EST TERMINE !!!");
			driver.quit();
		}
}

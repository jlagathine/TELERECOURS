package rpva;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import fonctionnalites.MicroFonctions;

public class xmlFileLoadRPVA {
	   WebDriver driver;
	   DesiredCapabilities caps;
	   WebElement element; 
	   String username;
	   String password;
	   boolean verif;
	   String myXpath;
	   String browserName;
	
	
	
	 
	   @BeforeSuite
	   public void Initialisation () throws Throwable {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }
	
	   @BeforeMethod
	   public void authentificationAdmin() throws Throwable {
		   username = "testtr";
		   password ="UserTelerecours20@";
	   
	   MicroFonctions.AuthentificationAdmin(driver, username, password);
	   }
	   
	   @Test
	   public void traitementfile() throws ParseException, Throwable {
		   String heure = "08/09/2022 11:35";
		   MicroFonctions.PrépaTachSyncAnnRpva(driver, heure);
	   }
}

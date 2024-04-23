package trc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;

import browser.Navigateur;

public class Trc_Bout_En_Bout {
	
	WebDriver driver;
	   DesiredCapabilities caps;
	   ChromeOptions options;
	   WebElement element; 
	   String username;
	   String password;
	   String browserName;
	   boolean verif;
	   String myXpath;
	   String recours;
	   Select select;
	   String jur;
	   String mail;
	   String env;
	   String dossier;
	   String formulaire;


	@BeforeSuite
	   public void InitialisationDoc() {
		   browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
	   }
	//TO DO

}

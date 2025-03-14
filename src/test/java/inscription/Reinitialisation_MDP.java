package inscription;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurIdentMdpOublie;

public class Reinitialisation_MDP {

	WebDriver driver;
	String browserName;
	String mail;
	String jur;
	String env;
	
	@Test(priority = 1)
	public void Connexion () throws Throwable {
		browserName = "chrome";
		mail = "nathalie@yopmail.com";
		jur = "CTX";
		env ="rec";
		
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   try {
		   JurIdentMdpOublie.identMdpLink(driver, jur);
	   } catch (Exception e) {
		   My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
	   }
	}
	
	@Test(priority = 2)
	public void Demande_Reinitialisation() throws Throwable {
	try {
		JurIdentMdpOublie.recupIndentMdp(driver, jur, mail);
		MicroFonctions.deconnexionTrExt(driver);
	} catch (Exception e) {
		My_SreenShot.takeScreenshot(driver);
		   e.printStackTrace();
	}
	Thread.sleep(200);
	driver.close();
	}
}

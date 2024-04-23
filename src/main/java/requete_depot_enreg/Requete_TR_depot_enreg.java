package requete_depot_enreg;

import org.openqa.selenium.WebDriver;

import Juridictions.JurReqTr;
import browser.Navigateur;
import fonctionnalites.MicroFonctions;

public class Requete_TR_depot_enreg {
	static WebDriver driver;
	static String browserName;
	static String numreq;
	
	public static String TR_depot(String jur) throws Throwable {
	//Connection
	browserName = "chrome";
	driver = Navigateur.choixBrowser(browserName);
	
	//Choix juridiction
	JurReqTr.maJuridiction(driver, jur);
	
	//Depot de requête
	JurReqTr.reqDepot(driver, jur);
	
	//Enregistrement de la requête   
	numreq = JurReqTr.reqEnreg(driver, jur);
	
	//Deconnexion
	MicroFonctions.deconnexionTrInt(driver);
	driver.close();
	Thread.sleep(500);
	
		return numreq;
	}

}

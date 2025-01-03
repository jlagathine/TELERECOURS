package requete_depot_enreg;

import org.openqa.selenium.WebDriver;

import browser.Navigateur;
import fonctionnalites.MicroFonctions;
import juridictions.JurReqTr;

public class Requete_TR_depot_enreg {
	static WebDriver driver;
	static String browserName;
	static String numreq;
	static String depot;
	static String saisine;
	
	public static String TR_depot (String jur, String navigateur, String saisine, String env) throws Throwable {
	//Connection
//	browserName = "chrome";
	driver = Navigateur.choixBrowser(navigateur) ;
	try {
	//Choix juridiction
	JurReqTr.maJuridiction(driver, jur, env);
	
	//Depot de requête
	depot = JurReqTr.reqDepot(driver, jur, saisine, env);
	
	//Enregistrement de la requête   
	numreq = JurReqTr.reqEnreg(driver, jur, depot, env);
	
	//Deconnexion
	MicroFonctions.deconnexionTrInt(driver);
	driver.close();
	Thread.sleep(500);
	}catch (Exception e) {
		e.printStackTrace();
	}
	
		return numreq;
	}

}

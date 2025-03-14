package trc;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class TrcDepotReq_Brouillon {
	
	static boolean verif;
	static String recours;
	
	public static String authentification (WebDriver driver, String username, String password, String env) throws Throwable{
		switch (env) {
		case "int1": 
			String url = "https://citoyens.int1.telerecours.fr/";
			driver.get(url);
			Thread.sleep(2000);
			System.out.println("Accès page "+driver.getCurrentUrl()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "rec": 
			url = "https://citoyens.recette.telerecours.fr/";
			driver.get(url);
			Thread.sleep(2000);
			System.out.println("Accès page "+driver.getCurrentUrl()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		default: System.err.println("Pas d'environnement à ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		//Authentification
		String myXpath = "//input[@id='username']";
		
		if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
		MicroFonctions.AuthentificationTrc(driver, username, password);
		Thread.sleep(2000);
		}
		else {
			System.err.println("Authentification déjà effectuée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		return null;
	}
	
		public static String avertissement(WebDriver driver) throws Throwable {
		//Acceptation des CGU
		MicroFonctions.conditionsGeneralesTrcSansBrouillon(driver);
		System.out.println("TrcDepotReq_Brouillon.avertissement()"+"...."+"CGU validées......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
		}
		
		public static String informationRequerant(WebDriver driver) throws Throwable {
		//Informations requérant
		recours = "seulRequerant";//les types de recours = "seulRequerant"; "autresRequerant"; "mandataire"
		MicroFonctions.lesTypesRecoursTrc(driver, recours, verif);
		return null;
		}
		
		public static String juridiction(WebDriver driver, String juridiction) throws Throwable {
		//choix juridiction
			switch (juridiction) {
			case "TA":
				MicroFonctions.juridictionTATRC(driver);
				break;
				
			case "CAA":
				MicroFonctions.juridictionCAATRC(driver);
				break;
				
			case "CE":
				MicroFonctions.juridictionCTXTRC(driver);
				break;

			default:System.err.println("Aucune juridiction à ce nom...... "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				break;
			}
			
			
		return null;
		}
		
		public static String urgenceJuridiction(WebDriver driver, String juridiction, String select, String scn) throws Throwable {
			switch (juridiction) {
			case "TA":
				select = "Autre";
				scn = "";
				MicroFonctions.choixUrgenceTATRC(driver, select, scn);
				break;
				
			case "CAA":
				select = "Autre";
				MicroFonctions.choixUrgenceCAATRC(driver);
				break;
				
			case "CE":
				select = "Autre";
				MicroFonctions.choixUrgenceCTXTRC(driver);
				break;

			default:System.err.println("Aucune juridiction à ce nom...... "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				break;
			}
		return null;
		}
		

}


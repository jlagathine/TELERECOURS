package juridictions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import JDBC.JdbcClass;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurRpvaInscript {
	static String mail;
	static String env;
	
	public static String connexion(WebDriver driver, String choixJur) throws Throwable {
		switch (choixJur) {
		case "TACAA":
			env = "rec"; //rec ou int1
			JurInscripTr.maJuridiction(driver, choixJur, env);
			break;
			
		case "Conseil":
			env = "rec"; //rec ou int1
			JurInscripTr.maJuridiction(driver, choixJur, env);
			break;

		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		 
		return null;
	}
	
	public static String edentitasIntegrerStruct(WebDriver driver, String choixJur) throws Throwable {
		switch (choixJur) {
		case "TACAA":
			int RPVA_AVOCAT_ID = 529196;
			int ANJ_AEXID = 22701;
			//effacement des données des tables PREFERENCES_UTILISATEURS et UTI_EXT_TR (vérifier ANJ_AEXID )
			JdbcClass.deletUtiPref(RPVA_AVOCAT_ID, ANJ_AEXID);
			
				//Changement des données du cabinet RPVA depuis la RPVA_AVOCAT
			JdbcClass.changeCabinetRpva();
			Thread.sleep(2000);
			
				//Verification de la présence de structures externes
			Integer result = JdbcClass.sqlQuery();
			Thread.sleep(2000);
			
			if( result != null) {
				//Connexion à la page edentitas
				MicroFonctions.Edentitas(driver, choixJur);
				
				//Vérification page "Renseigner son mail principal"
				String myXpath = "//h1[@class='display-4']";
				boolean verif= false;
					if(MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
					//Inscription aux téléprocédures
					mail = "dj@yopmail.com";
					MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);
					
						//Choix juridiction
					MicroFonctions.choixJuridictionTA(driver);
					}else {throw new Exception("La page d'inscription a été proposée");}
			}else {
			//Connexion à la page edentitas
			MicroFonctions.Edentitas(driver, choixJur);

			String myXpath = "//h1[@class='display-4']";
			boolean verif= false;
					if(MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
						//Inscription aux téléprocédures
						mail = "dj@yopmail.com";
					MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);
					
						//Choix juridiction
					MicroFonctions.choixJuridictionTA(driver);
					}else {throw new Exception("La page d'inscription a été proposée");}
			}
			break;
			
		case "Conseil":
			RPVA_AVOCAT_ID = 529196;
			ANJ_AEXID = 22701;
			//effacement des données des tables PREFERENCES_UTILISATEURS et UTI_EXT_TR (vérifier ANJ_AEXID )
			JdbcClass.deletUtiPref(RPVA_AVOCAT_ID, ANJ_AEXID);
			
			//Changement des données du cabinet RPVA depuis la RPVA_AVOCAT
			JdbcClass.changeCabinetRpva();
			Thread.sleep(2000);
			
				//Verification de la présence de structures externes
			result = JdbcClass.sqlQuery();
			Thread.sleep(2000);
			
			if( result != null) {
				//Connexion à la page edentitas
				MicroFonctions.Edentitas(driver, choixJur);
				
				//Vérification page "Renseigner son mail principal"
				String myXpath = "//h1[@class='display-4']";
				boolean verif= false;
					if(MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
					//Inscription aux téléprocédures
					mail = "dj@yopmail.com";
				MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);

					}else {throw new Exception("La page d'inscription a été proposée");}
			}else {
				//Connexion à la page edentitas
				MicroFonctions.Edentitas(driver, choixJur);

			String myXpath = "//h1[@class='display-4']";
			boolean verif= false;
					if(MesFonctions.isElementPresent(driver, myXpath, verif)==false) {
						//Inscription aux téléprocédures
						mail = "dj@yopmail.com";
						MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);
						
					}else {throw new Exception("La page d'inscription a été proposée");}
			}
			break;
			
		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}	
		return null;
	}
	
	public static String edentitasInsciptStruct(WebDriver driver, WebElement element, String choixJur) throws Throwable {
		switch (choixJur) {
		case "TACAA":
			int RPVA_AVOCAT_ID = 596196;
			//Verification de la présence de structures externes
			Integer result = JdbcClass.sqlQuery();
			Thread.sleep(2000);
			
			if(result != null) {
				//Connexion à la page edentitas
				MicroFonctions.Edentitas(driver, choixJur);
				
				//Vérification puis click sur le bouton d'"Inscription"
				boolean verif = false;
				String myXpath = "//a[@class='btn btn-primary mr-3']";
				
						 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true){
							System.out.println("Présence de structure externe "+ verif);
							MesFonctions.objet(driver, myXpath).click(); 
							Thread.sleep(1000);
							
							mail = MicroFonctions.formulaireInscriptRPVA(driver, element);
						 }
						 else {
							 throw new Exception("L'inscription n'a pas été proposée");
						 		}
				//Renseigner mail utilisateur		 
				MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);
				
				//Choix de la juridiction
				MicroFonctions.choixJuridictionCAA(driver);
				}
				else{
					//Connexion à la page edentitas
					MicroFonctions.Edentitas(driver, choixJur);
					
					mail = MicroFonctions.formulaireInscriptRPVA(driver, element);
					
					//Renseigner mail utilisateur	
					MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);
					
					//Choix de la juridiction
					MicroFonctions.choixJuridictionCAA(driver);
					
					Thread.sleep(3000);
					int AEXID = JdbcClass.AEXID(RPVA_AVOCAT_ID);
					JdbcClass.cleanDataInscript(AEXID);
						}
			break;
			
		case "Conseil":
			RPVA_AVOCAT_ID = 596196;
			//Verification de la présence de structures externes
			result = JdbcClass.sqlQuery();
			Thread.sleep(2000);
			
			if(result != null) {
				//Connexion à la page edentitas
				MicroFonctions.Edentitas(driver, choixJur);
				
				//Vérification puis click sur le bouton d'"Inscription"
				boolean verif = false;
				String myXpath = "//a[@class='btn btn-primary mr-3']";
				
						 if(MesFonctions.isElementPresent(driver, myXpath, verif)==true){
							System.out.println("Présence de structure externe "+ verif);
							MesFonctions.objet(driver, myXpath).click();
							
							Thread.sleep(1000);
							mail = MicroFonctions.formulaireInscriptRPVA(driver, element);
						 }
						 else {
							 throw new Exception("L'inscription n'a pas été proposée");
						 		}
				//Renseigner mail utilisateur		 
				MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);
				}
				else{
					//Connexion à la page edentitas
					MicroFonctions.Edentitas(driver, choixJur);
					
					mail =MicroFonctions.formulaireInscriptRPVA(driver, element);
					
					//Renseigner mail utilisateur	
					MicroFonctions.mailPrefUtiRpva(driver, mail, choixJur);
					Thread.sleep(3000);
					int AEXID = JdbcClass.AEXID(RPVA_AVOCAT_ID);
					JdbcClass.cleanDataInscript(AEXID);
						}
				break;

		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
	return null;	
	}
}

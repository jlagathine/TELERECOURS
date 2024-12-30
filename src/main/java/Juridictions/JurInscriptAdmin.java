package juridictions;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurInscriptAdmin {
	
	static String nomCE;
	static boolean verif;
	static String name;
	static String myXpath;
	
	public static String inscription (WebDriver driver, String jur, String code, String mdp, String nom, String prenom) throws Throwable {
		switch (jur) {
		case "TACAA":
			
			//Connexion
			MicroFonctions.obtenirCodeTACAA(driver, code, mdp);
			Thread.sleep(1000);
			
			//Formulaire
			String mail = MicroFonctions.formulaireAdmin(driver, nom, prenom);
			
			//Mail
			MicroFonctions.mailYop(driver, mail);
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver, jur);
			
//			//Choix de la juridiction
//			MicroFonctions.choixJuridictionTA(driver);
//			Thread.sleep(1000);
//			
//			name = "Paris";
//			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
//			verif = name.contains(MesFonctions.objet(driver,  myXpath).getText());
//			Thread.sleep(1500);
//			System.out.println(verif);
//			if (verif==true) {
//				System.err.println("la redirection n'a pas bien fonctionné...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
//			}
//			Thread.sleep(3000);
			break;
			
		case "CE" :
			//Connexion
			MicroFonctions.obtenirCodeCE(driver, code, mdp);
			Thread.sleep(1000);
			
			//Formulaire
			mail = MicroFonctions.formulaireAdmin(driver, nom, prenom);
			
			//Mail
			MicroFonctions.mailYop(driver, mail);
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver, jur);
			
//			name = "Télérecours - Conseil d'Etat";
//			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
//			verif = name.equals(MesFonctions.objet(driver,  myXpath).getText());
//			Thread.sleep(1500);
//			System.out.println(verif);
//			if (!verif) {
//				System.err.println("la redirection n'a pas bien fonctionné...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
//			}else {
//				System.out.println("la redirection a pas bien fonctionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
//			}
//			Thread.sleep(3000);
			break;

		default: System.err.println("Cette juridiction n'existe pas...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		return null;
	}


}

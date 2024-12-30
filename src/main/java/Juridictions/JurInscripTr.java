package juridictions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurInscripTr {
	static String nomCE;
	static boolean verif;
	static String name;
	static String myXpath;
	
	public static String maJuridiction (WebDriver driver, String choixJur, String env) throws Throwable {
		switch (env) {
		case "int1":
			switch (choixJur) {
			case "TACAA":
				driver.get("https://www.telerecours.int1.juradm.fr/");
				String myXpath = "//h1[text()='Se connecter']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				System.out.println("Connexion réussie");
				break;
				
			case "Conseil":
				driver.get("https://www.telerecours.int1.conseil-etat.fr/");
				myXpath = "//h1[text()='Se connecter']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				System.out.println("Connexion réussie");
				break;

			default: System.err.println("Cette juridiction n'existe pas");
				break;
			}	
			
			break;
			
		case "rec":
			switch (choixJur) {
			case "TACAA":
				driver.get("https://www.telerecours.recette.juradm.fr/");
				String myXpath = "//h1[text()='Se connecter']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				System.out.println("Connexion réussie");
				break;
				
			case "Conseil":
				driver.get("https://www.telerecours.recette.conseil-etat.fr/");
				myXpath = "//h1[text()='Se connecter']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				System.out.println("Connexion réussie");
				break;

			default: System.err.println("Cette juridiction n'existe pas");
				break;
			}	
			
			break;

		default:System.err.println("Erreur environnement...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
		
		
	return null;
	}
	
	public static String obtenirCode (WebDriver driver, String jur, String code, String motpasse, String nom) throws Throwable {
		switch (jur) {
		case "TACAA":
			//Connexion
			MicroFonctions.obtenirCodeTACAA(driver, code, motpasse);
			Thread.sleep(1000);
			
			//Formulaire
			String mail = MicroFonctions.formulaireTACAA(driver);

			//Mail
			MicroFonctions.mailYop(driver, mail); 
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver, jur);
			
			//Choix de la juridiction
//			MicroFonctions.choixJuridictionTA(driver);
//			Thread.sleep(1000);
//			
//			name = "Paris";
//			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
//			verif = name.contains(MesFonctions.objet(driver, myXpath).getText());
//			Thread.sleep(1500);
//			System.out.println(verif);
//			if (verif==true) {
//				System.err.println("la redirection n\'a pas bien fonctionné");
//			}
//			Thread.sleep(3000);
			break;
			
		case "Conseil":
			//Connexion
			MicroFonctions.obtenirCodeCE(driver, code, motpasse);
			Thread.sleep(1000);
			
			//Formulaire
			mail = MicroFonctions.formulaireCE(driver, nom);

			//Mail
			MicroFonctions.mailYop(driver, mail);
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver, jur);
			
//			name = "Télérecours - Conseil d'Etat";
//			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
//			verif = name.equals(MesFonctions.objet(driver, myXpath).getText());
//			Thread.sleep(1500);
//			System.out.println(verif);
//			if (!verif) {
//				System.err.println("la redirection n\'a pas bien fonctionné");
//			}else {
//				System.out.println("la redirection a bien fonctionné");
//			}
//			Thread.sleep(3000);
			break;

		default: System.err.println("Cette juridiction n'existe pas");
			break;
			
		}
		return null;
	}
	
}

package Juridictions;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurInvitIsnscriptConsult {
	static String nomCE;
	static boolean verif;
	static String name;
	static String myXpath;
	
	public static String ConsultationInscription (WebDriver driver, String choixJur, String code, String mdp, String nom, String prenom) throws Throwable {
		
		switch (choixJur) {
		case "TACAA":
			//Connexion	
			MicroFonctions.obtenirCodeTACAA(driver, code, mdp);
			Thread.sleep(1000);

			//Consultation
			MicroFonctions.adminConsultationAvantInscript(driver);
			Thread.sleep(1000);
			
			//Formulaire
			String mail = MicroFonctions.formulaireAdmin(driver, nom, prenom);
			
			//Mail
			MicroFonctions.mailYop(driver, mail);
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver);
			
			//Choix de la juridiction
			MicroFonctions.choixJuridictionTA(driver);
			Thread.sleep(1000);
			
			name = "Paris";
			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			verif = name.contains(MesFonctions.objet(driver, myXpath).getText());
			Thread.sleep(1500);
			System.out.println(verif);
			if (verif==true) {
				System.err.println("la redirection n'a pas bien fonctionné");
			}
			Thread.sleep(3000);
			
			break;
			
		case "CE":
			//Connexion	
			MicroFonctions.obtenirCodeCE(driver, code, mdp);
			Thread.sleep(1000);
			
			//Consultation
			MicroFonctions.adminConsultationAvantInscript(driver);
			Thread.sleep(1000);
			
			//Formulaire
			mail = MicroFonctions.formulaireAdmin(driver, nom, prenom);
			
			//Mail
			MicroFonctions.mailYop(driver, mail);
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver);
			
			name = "Télérecours - Conseil d'Etat";
			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
			verif = name.equals(MesFonctions.objet(driver, myXpath).getText());
			Thread.sleep(1500);
			System.out.println(verif);
			if (!verif) {
				System.err.println("la redirection n'a pas bien fonctionné");
			}else {
				System.out.println("la redirection a pas bien fonctionné");
			}
			Thread.sleep(3000);
		
			break;
		
		default:
			break;
		}
		
	return null;
	}
}

package juridictions;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;

public class JurInvitIsnscriptConsult {
	static String nomCE;
	static boolean verif;
	static String name;
	static String myXpath;
	
	public static String ConsultationInscription (WebDriver driver, String jur, String code, String mdp, String nom, String prenom) throws Throwable {
		
		switch (jur) {
		case "TACAA":
			//Connexion	
			MicroFonctions.obtenirCodeTACAA(driver, code, mdp);
			Thread.sleep(3000);

			//Consultation
			MicroFonctions.adminConsultationAvantInscript(driver, mdp);
			Thread.sleep(300);
			
			//Formulaire
			String mail = MicroFonctions.formulaireAdmin(driver, nom, prenom);
			
			//Mail
			MicroFonctions.mailYop(driver, mail);
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver, jur);
			
//			//Choix de la juridiction
//			MicroFonctions.choixJuridictionTA(driver);
//			Thread.sleep(200);
//			
//			name = "Paris";
//			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
//			verif = name.contains(MesFonctions.objet(driver, myXpath).getText());
//			Thread.sleep(500);
//			System.out.println(verif);
//			if (verif==true) {
//				System.err.println("la redirection n'a pas bien fonctionné");
//			}
//			Thread.sleep(300);
			
			break;
			
		case "CE":
			//Connexion	
			MicroFonctions.obtenirCodeCE(driver, code, mdp);
			Thread.sleep(200);
			
			//Consultation
			MicroFonctions.adminConsultationAvantInscript(driver, mdp);
			Thread.sleep(200);
			
			//Formulaire
			mail = MicroFonctions.formulaireAdmin(driver, nom, prenom);
			
			//Mail
			MicroFonctions.mailYop(driver, mail);
			
			//Récupération de ses codes
			MicroFonctions.Inscription(driver, jur);
			
//			name = "Télérecours - Conseil d'Etat";
//			myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
//			verif = name.equals(MesFonctions.objet(driver, myXpath).getText());
//			Thread.sleep(300);
//			System.out.println(verif);
//			if (!verif) {
//				System.err.println("la redirection n'a pas bien fonctionné");
//			}else {
//				System.out.println("la redirection a pas bien fonctionné");
//			}
//			Thread.sleep(300);
		
			break;
		
		default:
			break;
		}
		
	return null;
	}
}

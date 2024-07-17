package requete_depot_enreg;

import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.WebDriver;

import Juridictions.JurReqTrc;
import browser.Navigateur;
import fonctionnalites.MicroFonctions;

public class Requete_TRC_depot_enreg {
	
	 static WebDriver driver;
	   static String recours;
	   static String mail;
	   static String dossier;
	   static String formulaire;
	   static String req;
	   
	   public static Pair<String, String> TRC_depot_enreg(String jur, String navigateur, String env) throws Throwable {
	   //Connection
		   driver = Navigateur.choixBrowser(navigateur);
		   System.out.println(driver);
		   
		   //Type de recours
		   recours = "seulRequerant";//les types de recours = "seulRequerant"; "autresRequerant"; "mandataire"
		   formulaire = "NoForm";
			   if(env == "int1") {
					mail = "zaire@yopmail.com";
				}else {
					mail = "martial@yopmail.com";
				}
	
		   //Authentification
		   JurReqTrc.firstSteps(driver, recours, env, mail);
			
		   //Dépôt de req
		   JurReqTrc.reqDepotTrc(driver, jur, formulaire);
		   
		   
		   //Vérification des mail
		   JurReqTrc.verification_Mail_Depot_Req_TRC(driver, mail, env);
				
		   //Suppression mail
		   MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
				
		   //Vérification de la notification de la requête
		   dossier = JurReqTrc.Verification_Req_Async_DB(env, jur, mail);
			
		   //Enregistrement de la req
		   req = JurReqTrc.reqEnrgTrc(driver, jur, dossier);
		 	   
		   //Vérification des mail
		   JurReqTrc.verification_Mail_Enreg_Req_TRC(driver, mail, env);
		  		
		   //Suppression mail
		   MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
		   
		   //Déconnexion
		   MicroFonctions.deconnexionTrInt(driver);
		   driver.close();
		   
		   Pair<String, String> dossier_req = new Pair<String, String>(dossier, req);

		   return dossier_req;
	   }
}

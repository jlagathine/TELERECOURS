package requete_depot_enreg;

import org.openqa.selenium.WebDriver;

import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurReqTrc;

public class Requete_TRC_depot_enreg {
	
	 static WebDriver driver;
	   static String recours;
	   static String mail;
	   static String dossier;
	   static String formulaire;
	   static String req;
	   static String select;
	   static String scn;
	   
	   public static String TRC_depot_enreg(String jur, String navigateur, String env) throws Throwable {
	   //Connection
		   driver = Navigateur.choixBrowser(navigateur);
		   System.out.println(driver);
		   
		   //Type de recours
		   recours = "seulRequerant";//les types de recours = "seulRequerant"; "autresRequerant"; "mandataire"
		   formulaire = "NoForm";
		   select = "Autre";
		   scn = "";
			   if(env == "int1") {
					mail = "zaire@yopmail.com";
				}else {
					mail = "martial@yopmail.com";
				}
			   
			   try {
				   
				 //Authentification
				   JurReqTrc.firstSteps(driver, recours, env, mail);
					
				   //Dépôt de req
				   JurReqTrc.reqDepotTrc(driver, jur, formulaire, select, scn);
				   
				   
				   //Vérification des mail
				   JurReqTrc.verification_Mail_Depot_Req_TRC(driver, mail, env);
						
				   //Suppression mail
				   MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
						
				   //Vérification de la notification de la requête
				   req = JurReqTrc.Verification_Req_Async_DB(env, jur, mail);
					
				   //Enregistrement de la req
				   dossier = JurReqTrc.reqEnrgTrc(driver, jur, req, env, scn);
				 	   
				   //Vérification des mail
				   JurReqTrc.verification_Mail_Enreg_Req_TRC(driver, mail, env);
				  		
				   //Suppression mail
				   MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
				   
				   //Déconnexion
				   MicroFonctions.deconnexionTrInt(driver);
				   driver.close();
				
			} catch (Exception e) {
				My_SreenShot.takeScreenshot(driver);
				e.printStackTrace();
			}
		   
		   
		   return dossier;
	   }
}

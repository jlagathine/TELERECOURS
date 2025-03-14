package document;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurDocTrc;
import lesFonctions.MesFonctions;
import requete_depot_enreg.Requete_TRC_depot_enreg;

	public class trcDoc {
		
		 WebDriver driver;
		   boolean verif;
		   String browserName;
		   String jur;
		   String dossier;
		   String mdp;
		   String mail;
		   String env;
		   String DB_id;
		   String DB_mdp;
		 

		   @Test(priority = 1)
		   public void Trc_creation_dossier() throws Throwable  {
		   //choix du dossier de dépôt de mémoires
		   jur = "CAA"; //"TA" ou "CAA" et "CTX"(solution de contournement quant aux numéros de dossiers à la fois présents dans les deux juridictions)
		   env = "rec";//int1 ou rec
		   browserName = "edge";
		   dossier = Requete_TRC_depot_enreg.TRC_depot_enreg(jur, browserName, env);//dossier : est le numéro de dossier 
		   }
		   
		   @Test(priority = 2)
		   public void verification_enregistrement_dossier() throws Throwable {
		   //Connexion base de donnée TR
				switch (jur) {
				
				case "TA":
				if(env=="rec") {
					DB_id = "tr2_ta75";
					DB_mdp = "tr2_ta75";
				}else {
					DB_id = "tr2_ta69";
					DB_mdp = "tr2_ta69";
				}
				JdbcClass.conDBTR(DB_id, DB_mdp, env);
				break;
				
				case "CAA":
				if(env=="rec") {
					DB_id = "tr2_caa75";
					DB_mdp = "tr2_caa75";
				}else {
					DB_id = "tr2_caa69";
					DB_mdp = "tr2_caa69";
				}
				JdbcClass.conDBTR(DB_id, DB_mdp, env);
				break;
				
				case "CTX":
					JdbcClass.conDBTR("telerecours", "telerecours", env);
					break;

				default:  System.err.println("Aucune juridiction à ce nom");
					break;
				}
			
		   //Connexion base de donnée TR
		   JdbcClass.conDBTRC(env);
		   JdbcClass.TRC_Verification_creation_dossier_BDTRC(dossier);
		   JdbcClass.TRC_Verification_creation_dossier_BDTR(dossier);
		   
		   }
				
		   @Test(priority = 3)
		   public void Trc_depot_documents() throws Throwable {
			
			driver = Navigateur.choixBrowser(browserName);
			  if(env == "int1") {
					mail = "zaire@yopmail.com";
				}else {
					mail = "martial@yopmail.com";
				}
		
		   try {
			JurDocTrc.authentification(driver, env, mail);
			
			//Dépôt de document
			JurDocTrc.docDepotMem(driver, dossier, jur);
			
			//Vérification des mail
			JurDocTrc.verification_Mail_Depot_Doc_TRC(driver, mail, env);
				
			//Suppression mail
			MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
			
		    }catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
			throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
		    }
				
			@Test(priority = 4)
			public void trc_enregistrement_doc() throws Throwable {
				try {
			//Enregistrement du documment
			JurDocTrc.docEnregTrc(driver, dossier, jur);	
			
			//Vérification des mail
			JurDocTrc.verification_Mail_Enreg_Doc_TRC(driver, mail, env);
	 		
	 		//Suppression mail
	 		MicroFonctions.suppression_Mail_MailHog(driver, mail, env);
			
				}catch (Exception e) {
					My_SreenShot.takeScreenshot(driver);
					e.printStackTrace();
					throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
			}		
			
		 	@Test(priority = 5)
		 	public void déconnexion() throws Throwable {
				MicroFonctions.deconnexionTrInt(driver);
				System.out.println("LE TEST EST TERMINE !!!....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				driver.quit();
			}
				
}
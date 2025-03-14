package document;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import fonctionnalites.MicroFonctions;
import juridictions.JurDocTr;
import requete_depot_enreg.Requete_TR_depot_enreg;

	public class trDoc {
		
	   WebDriver driver;
	   WebElement element; 
	   String browserName;
	   String choiJur;
	   String dossier;
	   String saisine;
	   String env;
	   String DB_id;
	   String DB_mdp;
	   
	   @BeforeSuite
	   public void InitialisationDoc () throws Throwable {
	   browserName = "edge";
	   env = "rec"; 
	   saisine = "Jugement";
	   choiJur = "TA"; //Ne pas oublier de mettre les autres juridiction en commentaire
		   dossier = Requete_TR_depot_enreg.TR_depot(choiJur, browserName, saisine, env);
		   
		   switch (choiJur) {
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
		   //Vérification de la création de l'événement en BD
		   JdbcClass.verification_creation_dossier(dossier);
//		   Thread.sleep(3000);
		  
		   //Ouverture du navigateur
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   }
		   
		   @BeforeMethod
		   public void connexionTr() throws Throwable  {
		   //Choix de la juridiction
		   JurDocTr.maJuridiction(driver, choiJur, env);
		   }
				
			@Test
			public void depotDoc() throws Throwable {
			//Dépôt de document
			JurDocTr.docDepotMem(driver, choiJur, dossier);
			Thread.sleep(200);
			
			//Enregistrement du document
			JurDocTr.docEnregMem(driver, choiJur, dossier, env);
			   }
			
			@AfterMethod
			public void déconnexion() throws Exception {
			MicroFonctions.deconnexionTrInt(driver);
			}
					
			@AfterSuite
			public void fin() {
				System.out.println("LE TEST EST TERMINE !!!");
				driver.quit();
			}
		
} 

package skipper;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import Juridictions.JurDocTr;
import Juridictions.JurDoc_Constitution;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import requete_depot_enreg.Requete_TR_depot_enreg;

public class TR_Constitution_Avocat {

	WebDriver driver;
	   String browserName;
	   String jur;
	   String dossier;
	   String saisine;
	   String qualite;
	   String type;
	   String nom;
	   String id;
	   String mdp;
	   String env;
	   String DB_id;
	   String DB_mdp;
	   
	   @Test(priority = 1)
	   public void Creation_dossier() throws Throwable {
	   browserName = "chrome";
	   env = "rec";
	   jur = "CTX";//CAA, CTX, TA
	   id = "lb";
	   mdp = "lb";
	   saisine = "Jugement"; //Premier ressort ; Jugement
	   try {
		   
		   dossier = "367945";//Requete_TR_depot_enreg.TR_depot(jur, browserName, saisine, env);
		   
			} catch (Exception e) {
				My_SreenShot.takeScreenshot(driver);
				e.printStackTrace();
			}
	   }
	   
	   @Test(priority = 2)
	   public void ajout_defendeur() throws Throwable {
		   try {
				//Ajout défendeur
				qualite = "defendeur"; //defendeur
				nom ="AEROPORTS";
				type = "Autres";
				
				//Authentification
				Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
				//Ouverture dossier
				Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, dossier);
				
				//Ajout de l'acteur
				Navigation_Skipper_Creation_Defendeur.selectionActeur_defendeur_requerant(jur);
				Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
				Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
				
				//Ajout de l'acteur
			    qualite = "avocat";
			    nom = "ANCELET";
			    Navigation_Skipper_Creation_Defendeur.selection_Acteur_defendeur_requerant_Constitution(jur);
			    Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			    Navigation_Skipper_Creation_Defendeur.fiche_acteur_constitution(jur, nom, type);
				
			} catch (Exception e) {
				My_SreenShot.screenshot();
				e.printStackTrace();
			} 
	   }
		   
	   @Test(priority = 3)
	   public void ajout_avocat_constitution_defendeur() throws Throwable {
		   
		   try {  
			   //Constituer
			   Navigation_Sk_Constitution_Avocat.selection_qualite(jur);
			   Navigation_Sk_Constitution_Avocat.selection_personne_representee(jur);
			   
			   
			   //SKIPPER_fermeture
			   Navigation_Sk_Fermeture_Application.fermeture_sk(jur);
			   
			} catch (Exception e) {
				My_SreenShot.screenshot();
				e.printStackTrace();
			}
	   }
	   
	   @Test(priority = 4)
	   public void replication_SKToTR() throws SQLException {
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
		   
		   JdbcClass.verification_replication_acteur(dossier, nom);
	   }
	   
	   @Test(priority = 5)
	   public void depot_lettre_constitution() throws Throwable {
		 //Identifiants
		   id = "ancQB44";
		   mdp = "Lhommeest2019*";
//		   browserName = "chrome";
//		   dossier = "2400650";
//		   jur = "TA";
//		   env = "rec";
		   
		   //Connexion
		   driver = Navigateur.choixBrowser(browserName);
		   JurDoc_Constitution.choix_url(driver, jur, env, id, mdp);
		   
		   try {
		   
		   //Dépot du document
		   JurDoc_Constitution.depot_lettre_constituton(driver, dossier);
		   
		   //Enregistrement
		   JurDocTr.Enregistrement_Doc_Constitution(driver, dossier, jur, env);
		   
		   //Fermeture de la page et du test
		   MicroFonctions.deconnexionTrInt(driver);
		   driver.quit();
		   
			} catch (Exception e) {
				My_SreenShot.takeScreenshot(driver);
				e.printStackTrace();
			} 
	   }
}

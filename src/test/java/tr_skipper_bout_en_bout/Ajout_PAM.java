package tr_skipper_bout_en_bout;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurDocTr;
import requete_depot_enreg.Requete_TR_depot_enreg;
import skipper.Navigation_Sk_Ajout_Mesure;
import skipper.Navigation_Sk_Authentification;
import skipper.Navigation_Sk_Fermeture_Application;
import skipper.Navigation_Sk_Ouverture_Dossier;
import skipper.Navigation_Skipper_Creation_Defendeur;
import transmissions.Transmission_TR_expediteur;

public class Ajout_PAM {
	String jur;
	String dossier;
	String browserName;
	String id;
	String type;
	String qualite;
	String nom;
	String mdp;
	String DB_id;
	String DB_mdp;
	String env;
	String saisine;
	String nom_fichier;
	WebDriver driver;
	
	@Test(priority=1)
	public void navigation_sk() throws Throwable {
	//Ajout de la mesure mémoire en défense
	try {
		browserName = "edge";
		jur = "TA";
		id = "lb";
		mdp = "lb";
		env = "rec";
		saisine = "Jugement";
		dossier = Requete_TR_depot_enreg.TR_depot(jur, browserName, saisine, env);
		qualite = "defendeur"; //defendeur
		nom ="AEROPORTS";//JUR_101 ; AEROPORTS
		type = "Autres";//Sociétes privées ; Autres
		
		//SKIPPER_ouverture
		Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
		
		//SKIPPER_ouverture_dossier
		Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, dossier);
		
		
		Navigation_Skipper_Creation_Defendeur.selectionActeur_defendeur_requerant(jur);
		Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
		Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
		
		//Ajout mesure
		Navigation_Sk_Ajout_Mesure.acces_onglet_historique();
		Navigation_Sk_Ajout_Mesure.menu_contextuel_Accuse_Recep_Req(jur, env);//jur

		Navigation_Sk_Ajout_Mesure.Mesure_Contextuelle_Communication_Req(jur);
		
		//Ajout de la mesure
		Navigation_Sk_Ajout_Mesure.mesure_ajout_memoire_defense(jur);
		
		//SKIPPER_fermeture
		Navigation_Sk_Fermeture_Application.fermeture_sk(jur);
		
		} catch (Exception e) {
			My_SreenShot.screenshot();
			e.printStackTrace();
		}	
	}
	
	@Test(priority=2)
	public void verification_table() throws SQLException {
		//verification 
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
		JdbcClass.sqlVerification_Recepetion_Memoire(dossier, jur);
	}
	
	@Test(priority=3)
	public void navigation_tr_transmission() throws Throwable {
		
		//Ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
		
	try {
		//Choix du site
		Transmission_TR_expediteur.choix_site_juridiction(driver, jur, id, mdp, env);
		
		//Selection du dossier
		Transmission_TR_expediteur.selection_dossier(driver, dossier);
		
		//Accès à l'onglet "HISTORIQUE" du dossier
		MicroFonctions.consultationOngletHistoDossier(driver);
		
		//Accès au dépôt manuel de pièces 
		JurDocTr.acces_PAM(driver);
		JurDocTr.Ajout_PAM(driver);
		nom_fichier = JurDocTr.selection_PAM_avant_enregistrment(driver);
		JurDocTr.enregister_PAM(driver);
		
		//Deconnexion
		MicroFonctions.deconnexionTrInt(driver);
		driver.close();
		
		}catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
			}	
	}
	
	@Test(priority=4)
	public void verification_table1() throws SQLException {
		//verification 
		JdbcClass.conDBSK(jur, env, id, mdp);
		JdbcClass.sqlVerification_Enregistrement_PAM(dossier, nom_fichier);
	}
}

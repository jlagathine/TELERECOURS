package tr_skipper_bout_en_bout;

import java.awt.AWTException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import requete_depot_enreg.Requete_TR_depot_enreg;
import skipper.Navigation_Sk_Authentification;
import skipper.Navigation_Sk_Fermeture_Application;
import skipper.Navigation_Skipper_creation_dossier;
import transmissions.Transmission_TR_expediteur;
import transmissions.Transmission_TR_reception;

public class Transmission_type_renvoi_creation_dossier_sk {
	String jur;
	String reqTransNum;
	String id;
	String mdp;
	String dossier;
	String type;
	String env;
	String jur_trans;
	String browserName;
	int mes;
	WebDriver driver;
	
	@Test(priority=1)
	public void transmettre_dossier() throws Throwable {
		
	try {
	//JDD - Environnement de test
	browserName = "chrome";
	env = "rec";
	
	//Identifiant de connexion juridiction émétrice
	id = "lb";
	mdp = "lb";
	jur = "TA";
	dossier = Requete_TR_depot_enreg.TR_depot(jur);
	
	//JDD - juridiction de transmission
	jur_trans = "CAA";
	type = "renvoi";
	
	
		switch (jur) {
		case "TA":
			JdbcClass.conDBTR("tr2_ta75", "tr2_ta75", env);
			break;
		case "CAA":
			JdbcClass.conDBTR("tr2_caa75", "tr2_caa75", env);
			break;
		case "CTX":
			JdbcClass.conDBTR("telerecours", "telerecours", env);
			break;

		default:  System.err.println("Aucune juridiction à ce nom");
			break;
		}
		JdbcClass.sqlVerificationNumeroRequete(dossier);
	
	
	
		//Ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
		
		//Choix du site
		Transmission_TR_expediteur.choix_site_juridiction(driver, jur, id, mdp);
		
		//Selection du dossier
		Transmission_TR_expediteur.selection_dossier(driver, dossier);
		
		//Accès à l'écran de transmission
		Transmission_TR_expediteur.acces_ecran_transmission(driver);
		
		//Formulaire de transmission
		Transmission_TR_expediteur.formulaire_ecran_transmission(driver, type, jur_trans, dossier);
		Transmission_TR_expediteur.ajout_piece_transmission(driver, 5);
		Transmission_TR_expediteur.btn_envoyer_transmission(driver);
		
		//Deconnexion
		MicroFonctions.deconnexionTrInt(driver);
		driver.quit();
		
	} catch (Exception e) {
		My_SreenShot.takeScreenshot(driver);
		e.printStackTrace();
	}	
	
	}

	@Test(priority=2)
	public void navigation_SK() throws AWTException, Throwable {
	//Identifiant de connexion juridiction_receptrice
	id = "cp";
	mdp = "cp";
	
	try {
		//Authentification
		Navigation_Sk_Authentification.authentification(jur_trans, id, mdp);
		
		//Création nouveau dossier - onglet générique
		Navigation_Skipper_creation_dossier.nouveau_recours_papier_sk(jur_trans);
		Navigation_Skipper_creation_dossier.champ_nature(jur_trans);
		Navigation_Skipper_creation_dossier.champ_saisine(jur_trans);
		Navigation_Skipper_creation_dossier.champ_dpt_ressort_TA(jur_trans);
		Navigation_Skipper_creation_dossier.champ_rapporteur_TA(jur_trans);
		Navigation_Skipper_creation_dossier.champ_date_TA(jur_trans);
		Navigation_Skipper_creation_dossier.champ_matiere(jur_trans);
		Navigation_Skipper_creation_dossier.valider_nouveau_dossier(jur_trans);
		
		//Création nouveau dossier - onglet acteur
		Navigation_Skipper_creation_dossier.création_acteur_physique(jur_trans);
		
		//finalisation de la création du dossier
		Navigation_Skipper_creation_dossier.finalisation_creation_dossier(jur_trans);
		
		//Passage au mode TR
		Navigation_Skipper_creation_dossier.passage_mode_TR(jur_trans);
		
		//Récupération du numéro de la requête
		reqTransNum = Navigation_Skipper_creation_dossier.num_dossier_cree(jur_trans);
		
		//fermeture de l'application
		Navigation_Sk_Fermeture_Application.fermeture_sk(jur_trans);
		
	} catch (Exception e) {
		My_SreenShot.screenshot();
		e.printStackTrace();
	}
	
	}
	
	@Test(priority=3)
	public void verification_table() throws SQLException {
		//verification 
		switch (jur_trans) {
		case "TA":
			JdbcClass.conDBTR("tr2_ta75", "tr2_ta75", env);
			break;
		case "CAA":
			JdbcClass.conDBTR("tr2_caa75", "tr2_caa75", env);
			break;
		case "CTX":
			JdbcClass.conDBTR("telerecours", "telerecours", env);
			break;

		default:  System.err.println("Aucune juridiction à ce nom");
			break;
		}
		JdbcClass.sqlVerificationNumeroRequete(reqTransNum);
	}
	
	@Test(priority=4)
	public void recceptionner_dossier() throws Throwable {
	try {
//		browserName = "chrome";
//		env = "rec";
//		id = "cp";
//		mdp = "cp";
//		jur = "CAA";
//		dossier = "2400240";
//		type = "renvoi";
//		req = "2400133";
		//Ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
		
		//Choix du site
		Transmission_TR_expediteur.choix_site_juridiction(driver, jur_trans, id, mdp);
		
		//accès onglet de renvoi
		Transmission_TR_reception.acces_onglet_renvoi_DPI_DPA(driver, jur_trans);
		
		//Rechercher la transmission
		Transmission_TR_reception.dossier_transmis(driver, dossier);
		Transmission_TR_reception.type_transmission(driver, type);
		Transmission_TR_reception.btn_rechercher_transmission_receptionnee(driver);
		
		//Selection du dossier de transmission
		Transmission_TR_reception.click_lien_transmission(driver, dossier);
		Transmission_TR_reception.dossier_destinantion(driver, type, reqTransNum);
		Transmission_TR_reception.choix_mesure_transmission(driver);
		
		//Selection du requérant si dossier TRC
		Transmission_TR_reception.transmission_trc_rattachement(driver);
		
		//Enregistrer la transmission
		Transmission_TR_reception.enregister_transmission(driver);
		
		//Deconnexion
		MicroFonctions.deconnexionTrInt(driver);
		driver.quit();
			
		} catch (Exception e) {
		My_SreenShot.takeScreenshot(driver);
		e.printStackTrace();
		}
	}
}

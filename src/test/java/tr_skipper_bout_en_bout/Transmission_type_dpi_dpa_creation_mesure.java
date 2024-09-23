package tr_skipper_bout_en_bout;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import requete_depot_enreg.Requete_TR_depot_enreg;
import skipper.Navigation_Sk_Ajout_Mesure;
import skipper.Navigation_Sk_Authentification;
import skipper.Navigation_Sk_Fermeture_Application;
import skipper.Navigation_Sk_Ouverture_Dossier;
import transmissions.Transmission_TR_expediteur;
import transmissions.Transmission_TR_reception;

public class Transmission_type_dpi_dpa_creation_mesure {
	String jur;
	String numReqDest;
	String dossier;
	String browserName;
	String jur_annuaire;
	String jur_dest;
	String id;
	String saisine;
	String DB_id;
	String DB_mdp;
	String mdp;
	String type;
	String type_jur;
	String env;
	WebDriver driver;
	
	
	/*La juridiction de destinantion "JUR_DEST" est la juridiction qui demande le dossier de première instance DPI/DPA
	 *La juridiction de transmission "JUR" est la juridiction qui transmet le dossier de première instance
	 * 
	 * Ensemble des mesures par juridiction pour la valeur de JUR_ANNUAIRE
	 * 
	 * ENV = REC
	 * TA : "Juridictions AJU CAA" (juridiction transmettrice CAA) ; "Juridictions  CE" (juridiction transmettrice CE)
	 * CAA : "TRIBUNAL ADMINISTRATIF DE PARIS" (juridiction transmettrice TA) ; "CONSEIL D'ETAT" (juridiction transmettrice CE)
	 * CTX : "TRIBUNAL ADMINISTRATIF DE PARIS" (juridiction transmettrice TA) ; "COUR ADMINISTRATIVE D'APPEL DE PARIS" (juridiction transmettrice CAA)
	 * 
	 * ENV = INT1
	 * TA : "Juridictions AJU CAA" (juridiction transmettrice CAA) ; "Juridictions  CE" (juridiction transmettrice CE)
	 * CAA : "TRIBUNAL ADMINISTRATIF DE PARIS" (juridiction transmettrice TA) ; "CONSEIL D'ETAT" (juridiction transmettrice CE)
	 * CTX : "JUR_121" (juridiction transmettrice TA) ; "JUR_597" (juridiction transmettrice CAA)
	 * 
	 * Le numéro de dossier "DOSSIER" correspond au dossier de première instance
	 * Le numéro de dossier "NUMREQDEST" correspond au dossier sur lequel est fait la transmission du dossier de première instance
	 * 
	 * Le type "TYPE" : "renvoi" ; "DPI/DPA" ; "decision" ; "decision" 
	 */
	
	@Test(priority=1)
	public void navigation_sk() throws Throwable {
		//Création de la mesure Réception PMI pour le dossier de DESTINATION sur SKIPPER
		try {
		browserName = "chrome";
		jur = "TA";
		jur_dest = "CAA";
		id = "lb";
		mdp = "lb";
		env = "rec";
		saisine = "Jugement";
		numReqDest = Requete_TR_depot_enreg.TR_depot(jur_dest, browserName, saisine, env); 
		dossier = Requete_TR_depot_enreg.TR_depot(jur, browserName, saisine, env);
		type = "DPI/DPA";
		type_jur = "Juridictions";
		jur_annuaire = "TRIBUNAL ADMINISTRATIF DE PARIS";
		
		
			//SKIPPER_ouverture
			Navigation_Sk_Authentification.authentification_env(jur_dest, id, mdp, env);
			
			//SKIPPER_ouverture_dossier
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur_dest, numReqDest);
			Navigation_Sk_Ajout_Mesure.ajout_mesure_reception_DPI(jur_dest, jur_annuaire, type_jur);
			
			//SKIPPER_fermeture
			Navigation_Sk_Fermeture_Application.fermeture_sk(jur_dest);
			
		} catch (Exception e) {
			My_SreenShot.screenshot();
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void verification_table() throws SQLException {
		//verification 
		switch (jur_dest) {
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
		JdbcClass.sqlVerification_ReceptionPMI_Requete(numReqDest, jur_dest);
	}
	
	@Test(priority=3)
	public void navigation_tr_transmission() throws Throwable {
	try {
		
		//Ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
		
		//Choix du site
		Transmission_TR_expediteur.choix_site_juridiction(driver, jur, id, mdp, env);
		
		//Selection du dossier
		Transmission_TR_expediteur.selection_dossier(driver, dossier);
		
		//Accès à l'écran de transmission
		Transmission_TR_expediteur.acces_ecran_transmission(driver);
		
		//Formulaire de transmission
		Transmission_TR_expediteur.formulaire_ecran_transmission(driver, type, jur_dest, numReqDest);
		Transmission_TR_expediteur.ajout_piece_transmission(driver, 5);
		Transmission_TR_expediteur.btn_envoyer_transmission(driver);
		
		//Deconnexion
		MicroFonctions.deconnexionTrInt(driver);
		driver.close();
		
		} catch (Exception e) {
		My_SreenShot.takeScreenshot(driver);
		e.printStackTrace();
		}	
	}
	
	@Test(priority=4)
	public void navigation_tr_recepetion() throws Throwable {	
	try {
//		browserName = "chrome";
		//Ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
			
		//Choix du site
		Transmission_TR_expediteur.choix_site_juridiction(driver, jur_dest, id, mdp, env);
		
		//accès onglet de renvoi
		Transmission_TR_reception.acces_onglet_renvoi_DPI_DPA(driver, jur_dest);
		
		//Rechercher la transmission
		Transmission_TR_reception.dossier_transmis(driver, dossier);
		Transmission_TR_reception.type_transmission(driver, type);
		Transmission_TR_reception.btn_rechercher_transmission_receptionnee(driver);
		
		//Selection du dossier de transmission
		Transmission_TR_reception.click_lien_transmission(driver, dossier);
		Transmission_TR_reception.dossier_destinantion(driver, type, numReqDest);
		Transmission_TR_reception.choix_mesure_transmission(driver);
		
		//Selection du requérant si dossier TRC
		Transmission_TR_reception.transmission_trc_rattachement(driver);
		
		//Enregistrer la transmission
		Transmission_TR_reception.enregister_transmission(driver);
		
		//Vérification de la transmission
		Transmission_TR_reception.Verification_Transmission_Enregistree(driver, type, dossier, numReqDest, jur, jur_dest);
		
		//Deconnexion
		MicroFonctions.deconnexionTrInt(driver);
		driver.close();;
			
		} catch (Exception e) {
			
		My_SreenShot.takeScreenshot(driver);
		e.printStackTrace();
		}
	}
}

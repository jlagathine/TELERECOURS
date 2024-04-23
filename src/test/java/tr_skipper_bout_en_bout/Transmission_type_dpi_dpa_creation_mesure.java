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
	String mdp;
	String type;
	String env;
	WebDriver driver;
	
	@Test(priority=1)
	public void navigation_sk() throws Throwable {
		try {
		//Création de la mesure Réception PMI pour le dossier de DESTINATION sur SKIPPER 
		jur = "CAA";
		jur_dest = "TA";
		id = "lb";
		mdp = "lb";
		numReqDest ="2400152";// Requete_TR_depot_enreg.TR_depot(jur_dest);//numéro de dossier 
		dossier = Requete_TR_depot_enreg.TR_depot(jur);
		type = "DPI/DPA";
		jur_annuaire = "AJUCAA";//TRIBUNAL ADMINISTRATIF DE PARIS-TAP ; COUR ADMINISTRATIVE D'APPEL DE PARIS ; CONSEIL D'ETAT ; Juridictions  AJUCAA (TA)
		env = "rec";
		
		
			//SKIPPER_ouverture
			Navigation_Sk_Authentification.authentification(jur_dest, id, mdp);
			
			//SKIPPER_ouverture_dossier
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur_dest, numReqDest);
			Navigation_Sk_Ajout_Mesure.ajout_mesure_reception_DPI(jur_dest, jur_annuaire);
			
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
		JdbcClass.sqlVerification_ReceptionPMI_Requete(numReqDest, jur_dest);
	}
	
	@Test(priority=3)
	public void navigation_tr_transmission() throws Throwable {
	try {
		browserName = "chrome";
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
		browserName = "chrome";
		//Ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
			
		//Choix du site
		Transmission_TR_expediteur.choix_site_juridiction(driver, jur_dest, id, mdp);
		
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
		Transmission_TR_reception.Verification_Transmission_Enregistree(driver, type, dossier, numReqDest);
		
		//Deconnexion
		MicroFonctions.deconnexionTrInt(driver);
		driver.close();;
			
		} catch (Exception e) {
			
		My_SreenShot.takeScreenshot(driver);
		e.printStackTrace();
		}
	}
}

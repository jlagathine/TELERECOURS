package tr_skipper_bout_en_bout;

import java.sql.SQLException;

import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurInscripTr;
import net.sourceforge.tess4j.TesseractException;
import pdfGeneration.PdfCreationEtEcriture;
import requete_depot_enreg.Requete_TRC_depot_enreg;
import requete_depot_enreg.Requete_TR_depot_enreg;
import skipper.Navigation_Sk_Authentification;
import skipper.Navigation_Sk_Fermeture_Application;
import skipper.Navigation_Sk_Ouverture_Dossier;
import skipper.Navigation_Skipper_Creation_Defendeur;
import skipper.Navigation_Skipper_InscriptionTR_Avocat;
import skipper.Reduction_fenetre_word;

public class Sk_transmission_code_inscription_avocat {

	String jur;
	String numdoc;
	String id;
	String mdp;
	String code;
	String password;
	String browserName;
	String type;
	String qualite;
	String nom;
	String env;
	String saisine;
	String DB_id;
	String DB_mdp;
	WebDriver driver;
	
	@Test(priority=1)
	public void ouverture_Skipper() throws TesseractException, Throwable {
		env = "rec";
		nom = "AUDUC";
		browserName = "chrome";
		saisine = "Jugement";
		jur = "TA";
		id = "lb";
		mdp = "lb";
		numdoc = "2400628";//Requete_TR_depot_enreg.TR_depot(jur, browserName, saisine, env);
		try {
			//SKIPPER
			Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
			
			qualite = "avocat"; //defendeur
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, numdoc);
			Navigation_Skipper_InscriptionTR_Avocat.selectionActeur_defendeur_requerant(jur);
			Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			Navigation_Skipper_InscriptionTR_Avocat.fiche_acteur(jur, nom);
			Navigation_Skipper_InscriptionTR_Avocat.constitutionMandataire(jur);
			Navigation_Skipper_InscriptionTR_Avocat.AccesMesure(jur);
			Navigation_Skipper_InscriptionTR_Avocat.validationCourrierDansTr(jur);
			Navigation_Skipper_InscriptionTR_Avocat.traitementDeTexte_courrier(jur);
			Navigation_Skipper_InscriptionTR_Avocat.selectionDestinataireCourrier();
			Navigation_Skipper_InscriptionTR_Avocat.genererFichierRTF(jur);
			
			Pair<String, String> temp = PdfCreationEtEcriture.convertionRTFtoPDF_codeInscription_avocat(jur);
			code = temp.getFirst();
			password = temp.getSecond();
			
			Navigation_Sk_Fermeture_Application.fermetureApplication(jur);
			Reduction_fenetre_word.fermeture_fenetre_word();
			Navigation_Sk_Fermeture_Application.fermetureLanceurBAMO();
			
		} catch (Exception e) {
			My_SreenShot.screenshot();
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void verification_BD() throws SQLException, InterruptedException {
		//Base de donnée
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
		JdbcClass.sqlVerificationCodeInscriptionTr(password);
		}
	
	@Test(priority=3)	
	public void navigation_TR() throws Throwable {
		//TR
		try {
//			env = "rec";
			if(jur=="TA" || jur=="CAA") {
			driver = Navigateur.choixBrowser("chrome");
			JurInscripTr.maJuridiction(driver, "TACAA", env);
			JurInscripTr.obtenirCode(driver, "TACAA", code, password, nom);
			}
			else {
				driver = Navigateur.choixBrowser("chrome");
				JurInscripTr.maJuridiction(driver, "Conseil", env);
				JurInscripTr.obtenirCode(driver, "Conseil", code, password, nom);
			}
		
			MicroFonctions.deconnexionTrExt(driver);
			driver.close();
			
		} catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
		}
		
	}
}

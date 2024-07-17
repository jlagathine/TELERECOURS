package tr_skipper_bout_en_bout;

import java.sql.SQLException;

import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import Juridictions.JurInscripTr;
import Juridictions.JurInvitIsnscriptConsult;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import pdfGeneration.PdfCreationEtEcriture;
import skipper.Navigation_Sk_Authentification;
import skipper.Navigation_Sk_Fermeture_Application;
import skipper.Navigation_Sk_Ouverture_Dossier;
import skipper.Navigation_Skipper_InscriptionTR_Adm;
import skipper.Reduction_fenetre_word;

public class Sk_transmission_code_inscription_adm {
	String jur;
	String numdoc;
	String id;
	String mdp;
	String code;
	String password;
	String type;
	String nom;
	String nomAdmin;
	String prenom;
	String DB_id;
	String DB_mdp;
	String env;
	WebDriver driver;
	
	@Test
	public void navigation_sk() throws Throwable {
		env = "int1"; 
		jur = "CTX";
		id = "sice";
		mdp = "sice";
		numdoc = "412056";//366478, 22478
		
		prenom = "Dominique";
		nomAdmin = "MAGLOIRE";
		
		try {
			//SKIPPER
			Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
		
			type = "defendeur"; //avocat
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, numdoc);
			Navigation_Skipper_InscriptionTR_Adm.selectionActeur_defendeur_requerant(jur);
			Navigation_Skipper_InscriptionTR_Adm.SelectionTypeActeur(type, jur);
			nom = Navigation_Skipper_InscriptionTR_Adm.fiche_acteur(jur);
			Navigation_Skipper_InscriptionTR_Adm.accesMesuresContextuelles(jur);
			Navigation_Skipper_InscriptionTR_Adm.validationCourrierDansTr(jur);
			Navigation_Skipper_InscriptionTR_Adm.traitementDeTexte_courrier(jur);
			Navigation_Skipper_InscriptionTR_Adm.selectionDestinataireCourrier(jur);
			Navigation_Skipper_InscriptionTR_Adm.genererFichierRTF(jur);
			
			Pair<String, String> temp = PdfCreationEtEcriture.convertionRTFtoPDF_codeInscription_adm(jur);
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
		
	public void navigation_TR() throws Throwable {
		try {
			//TR
			if(jur=="TA" || jur=="CAA") {
			driver = Navigateur.choixBrowser("chrome");
			JurInscripTr.maJuridiction(driver, "TACAA", env);
			JurInvitIsnscriptConsult.ConsultationInscription(driver, "TACAA", code, password, nomAdmin, prenom);
			}
			else {
				driver = Navigateur.choixBrowser("chrome");
				JurInscripTr.maJuridiction(driver, "Conseil", env);
				JurInvitIsnscriptConsult.ConsultationInscription(driver, "CE", code, password, nomAdmin, prenom);
			}
			MicroFonctions.deconnexionTrExt(driver);
		
		} catch (Exception e) {
			My_SreenShot.takeScreenshot(driver);
			e.printStackTrace();
		}
	}	
}

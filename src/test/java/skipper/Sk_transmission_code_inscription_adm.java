package skipper;

import java.sql.SQLException;

import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import Juridictions.JurInvitIsnscriptConsult;
import Juridictions.JurInscripTr;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;
import net.sourceforge.tess4j.TesseractException;
import pdfGeneration.PdfCreationEtEcriture;

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
	String env;
	WebDriver driver;
	
	@Test
	public void navigation_sk() throws Throwable {
		env = "rec"; 
		jur = "CTX";
		id = "fm";
		mdp = "fm";
		numdoc = "366478";//366478, 22478
		
		env = "rec";
		prenom = "Dominique";
		nomAdmin = "MAGLOIRE";
		
		try {
			//SKIPPER
			Navigation_Sk_Authentification.authentification(jur, id, mdp);
		
			type = "defendeur"; //avocat
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

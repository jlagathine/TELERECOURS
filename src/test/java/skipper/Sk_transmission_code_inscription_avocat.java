package skipper;

import java.sql.SQLException;

import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import Juridictions.JurInscripTr;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import net.sourceforge.tess4j.TesseractException;
import pdfGeneration.PdfCreationEtEcriture;

public class Sk_transmission_code_inscription_avocat {

	String jur;
	String numdoc;
	String id;
	String mdp;
	String code;
	String password;
	String type;
	String nom;
	String env;
	WebDriver driver;
	
	@Test
	public void ouverture_Skipper() throws TesseractException, Throwable {
		env = "rec";
		jur = "TA";
		id = "lb";
		mdp = "lb";
		numdoc = "22154";//366478, 22478
		try {
			//SKIPPER
			Navigation_Sk_Authentification.authentification(jur, id, mdp);
			
			type = "avocat"; //defendeur
			Navigation_Skipper_InscriptionTR_Avocat.selectionActeur_defendeur_requerant(jur);
			Navigation_Skipper_InscriptionTR_Avocat.SelectionTypeActeur(type, jur);
			nom = Navigation_Skipper_InscriptionTR_Avocat.fiche_acteur(jur);
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
		//TR
		try {
			env = "rec";
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

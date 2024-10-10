package trc;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class DepotEnregistrementBrouillon {
	
	WebDriver driver;
	String browserName;
	String env;
	String mail;
	String recours;
	String password;
	String etape;
	
	
	@BeforeSuite
	 public void InitialisationReqTrc() throws IOException {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }


	@BeforeMethod
	public void connexionTrc() throws Throwable  {
		password = "Lhommeest2019*";
//		mail = "zaire@yopmail.com";//"zaire@yopmail.com" pour l'INT1; "delvy@yopmail.com" pour la recette 
		env = "rec";//int1 ou rec
		if(env == "int1") {
			mail = "zaire@yopmail.com";
		}else {
			mail = "martial@yopmail.com";
		}
		TrcDepotReq_Brouillon.authentification(driver, mail, password, env);
	   }
	@Test
	public void Depot() throws Throwable {
	recours = "seulRequerant";//les types de recours = "seulRequerant"; "autresRequerant"; "mandataire"
	//Validation des CGU
//	TrcDepotReq_Brouillon.avertissement(driver);
	//Etape requérant
//	TrcDepotReq_Brouillon.informationRequerant(driver);
	//Etape choix de juridiction
//	TrcDepotReq_Brouillon.juridiction(driver, "TA");//TA ; CAA ; CE
	//Urgenge du dossier
//	TrcDepotReq_Brouillon.urgenceJuridiction(driver, "TA");//TA ; CAA ; CE
	//Etape justificatifs
//	microfonctions.depotFilesReqTrc(driver);
	
	//Enregistrement du brouillon
//	String step = microfonctions.enregistrerBrouillonTRC(driver, etape);
		//retour à l'accueil
//	microfonctions.boutonAccueilTrc(driver);
	//Récupération du brouillon
//	microfonctions.repriseBrouillonTRC(driver, step);
	//Récupération du brouillon(1)
//	microfonctions.enregistrerBrouillonTRC1(driver);
	
	MicroFonctions.repriseBrouillonTRC1(driver);
	
	MicroFonctions.pagePrecedentTrc(driver);
	
	MicroFonctions.depotFilesReqTrc_99Pieces(driver);
	
	}
	
	 @AfterMethod
	 public void déconnexion() throws Exception {
			MicroFonctions.deconnexionTrc(driver);
		}
		
	@AfterSuite
	public void fin() {
		System.out.println("LE TEST EST TERMINE !!!...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		driver.quit();
	}
	
	
}

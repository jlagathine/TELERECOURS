package trc;

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
	String select;
	String scn;
	
	@BeforeSuite
	 public void InitialisationReqTrc() throws Throwable {
	   browserName = "chrome";
	   driver = Navigateur.choixBrowser(browserName);
	   System.out.println(driver);
	   }


	@BeforeMethod
	public void connexionTrc() throws Throwable  {
		password = "Lhommeest2019*";
//		mail = "zaire@yopmail.com";//"zaire@yopmail.com" pour l'INT1; "delvy@yopmail.com" pour la recette 
		env = "rec";//int1 ou rec
		select = "Autre";
		scn = "";
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
	//Suppression brouillon
//	MicroFonctions.suppression_Brouillon_Trc(driver);//INUTILE
	//Validation des CGU
	TrcDepotReq_Brouillon.avertissement(driver);
	//Etape requérant
	TrcDepotReq_Brouillon.informationRequerant(driver);
	//Etape choix de juridiction
	TrcDepotReq_Brouillon.juridiction(driver, "TA");//TA ; CAA ; CE
	//Urgenge du dossier
	TrcDepotReq_Brouillon.urgenceJuridiction(driver, "TA", select, scn);//TA ; CAA ; CE
	//Etape justificatifs
	MicroFonctions.depotFilesReqTrc(driver, select, scn);
	
	//Enregistrement du brouillon
	String step = MicroFonctions.enregistrerBrouillonTRC(driver, etape);
		//retour à l'accueil
	MicroFonctions.boutonAccueilTrc(driver);
		//Récupération du brouillon
	MicroFonctions.repriseBrouillonTRC(driver, step);
		//Récupération du brouillon(1)
	step = MicroFonctions.enregistrerBrouillonTRC1(driver, etape);
		//retour à l'accueil
	MicroFonctions.boutonAccueilTrc(driver);
	
	MicroFonctions.repriseBrouillonTRC1(driver, step);
	
	MicroFonctions.pagePrecedentTrc(driver);
	
//	MicroFonctions.depotFilesReqTrc_99Pieces(driver);
	
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

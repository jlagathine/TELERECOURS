package trc;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import JDBC.JdbcClass;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class EntrerCodeRattachement {
	
	public static String rattachementTRC(WebDriver driver, String code, String jur, String env) throws Throwable {
		//Accès au bouton "Entrer un code reçu par courrier"
		String myXpath = " //span[contains(text(),\"Entrer un code reçu par courrier\")] ";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Accés à la page d'avertissement...."+MesFonctions.extractCurrentHeure()+"\r");
		
		//Validation des CGU
		MicroFonctions.conditionsGeneralesTrc(driver);
		
		//saisi du code
		myXpath = " //input[@id='secretCode'] ";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(code);
		System.out.println("Le code a été renseigné....."+MesFonctions.extractCurrentHeure());
		
		//verification en BASE TR
		String DB_id = "";
		String DB_mdp = "";
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
		JdbcClass.sqlVerificationCodeRattachementTr(code.replaceAll(" ", "").replaceAll("-", "").trim());			
	
		//Bouton rattacher dossier
		myXpath = " //span[contains(text(),\"Rattacher le dossier\")] ";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Le code a été validé....."+MesFonctions.extractCurrentHeure());
		
		//Confirmation rattachemet
		myXpath = "//button/span[contains(text(),\"Retourner à l'accueil\")]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		String myXpath1 = "//div/h2";
		System.out.println(MesFonctions.objet(driver, myXpath1).getText().trim()+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
		
	}

}

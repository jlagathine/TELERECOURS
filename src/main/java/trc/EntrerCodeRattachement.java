package trc;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import JDBC.JdbcClass;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class EntrerCodeRattachement {
	
	public static String rattachementTRC(WebDriver driver, String code, String jur) throws Throwable {
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
		String env = "rec";
		switch (jur) {
		
		case "TA":
			JdbcClass.conDBTR("tr2_ta75", "tr2_ta75", env);
			JdbcClass.sqlVerificationCodeRattachementTr(code.replaceAll(" ", "").replaceAll("-", "").trim());
			break;
		case "CAA":
			JdbcClass.conDBTR("tr2_caa75", "tr2_caa75", env);
			JdbcClass.sqlVerificationCodeRattachementTr(code.replaceAll(" ", "").replaceAll("-", "").trim());
			break;
		case "CTX":
			JdbcClass.conDBTR("telerecours", "telerecours", env);
			JdbcClass.sqlVerificationCodeRattachementTr(code.replaceAll(" ", "").replaceAll("-", "").trim());
			break;

		default:
			break;
		}
					
	
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

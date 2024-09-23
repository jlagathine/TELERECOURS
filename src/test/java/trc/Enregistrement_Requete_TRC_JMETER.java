package trc;

import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import Juridictions.JurReqTrc;
import browser.Navigateur;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class Enregistrement_Requete_TRC_JMETER {
	WebDriver driver;
	String DB_id;
	String DB_mdp;
	String env;
	String jur;
	String browserName;
	List<Integer> dossier = new ArrayList<>();
	
	@Test(priority = 1)
	public void Recuperation_requeteTRC_Jmeter()throws SQLException {
		jur = "TA";
		env = "rec";
		browserName = "chrome";
		
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
		dossier.addAll(JdbcClass.Recuperation_numRequeteTRC_Jmeter()) ;
	
	}
	
	@Test(priority = 2)
	public void Enregistrement_requeteTRC_Jmeter() throws Throwable {
		//ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
		
		//Enregistrement de la requête
		JurReqTrc.authentication_interne_TRCJmeter(driver, jur, env);
		
		//Click bouton requête
		MicroFonctions.bouton_requete_int(driver, jur);
		
		for(int i=0;i<dossier.size();) {
			String myXpath = "//a[@class='numDossier' and (text()='" + dossier.get(i) +" (TRC)')]";
			boolean verif = false;
			if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				JurReqTrc.reqEnrgTrcJmeter(driver, jur, dossier.get(i));
				i++;
			}
			else {
				String myXpath1 = "//img[@id='ibNavNext']";
				MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath1).click();
			}
			
		}
		
	}

}

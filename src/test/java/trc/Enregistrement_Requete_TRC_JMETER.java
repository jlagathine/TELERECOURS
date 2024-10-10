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
	String browserName;
	String jur;
	List<String> listJur = List.of("TA", "CAA", "CTX");
	List<Integer> dossier_TA = new ArrayList<>();
	List<Integer> dossier_CAA = new ArrayList<>();
	List<Integer> dossier_CTX = new ArrayList<>();
	
	@Test(priority = 1)
	public void Recuperation_requeteTRC_Jmeter() throws SQLException {
		browserName = "chrome";
		env = "rec";
		for(int i=0; i<listJur.size(); i++) {
		jur = listJur.get(i);
		if(jur.equals("TA")) {
			System.out.println(jur);
			if(env=="rec") {
				DB_id = "tr2_ta75";
				DB_mdp = "tr2_ta75";
			}else {
				DB_id = "tr2_ta69";
				DB_mdp = "tr2_ta69";
			}
			 JdbcClass.conDBTR(DB_id, DB_mdp, env);
			 dossier_TA.addAll(JdbcClass.Recuperation_numRequeteTRC_Jmeter());
			 System.out.println(dossier_TA+"\r");
				}	
				else if(jur.equals("CAA")) {
					System.out.println(jur);
					if(env=="rec") {
						DB_id = "tr2_caa75";
						DB_mdp = "tr2_caa75";
					}else {
						DB_id = "tr2_caa69";
						DB_mdp = "tr2_caa69";
						}
					JdbcClass.conDBTR(DB_id, DB_mdp, env);
					dossier_CAA.addAll(JdbcClass.Recuperation_numRequeteTRC_Jmeter());
					System.out.println(dossier_CAA+"\r");
					}
					else{
						JdbcClass.conDBTR("telerecours", "telerecours", env);
					}
		dossier_CTX.addAll(JdbcClass.Recuperation_numRequeteTRC_Jmeter());
		System.out.println(dossier_CTX+"\r");
		}
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
		
		for(int i=0;i<dossier_TA.size();) {
			String myXpath = "//a[@class='numDossier' and (text()='" + dossier_TA.get(i) +" (TRC)')]";
			boolean verif = false;
			if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				JurReqTrc.reqEnrgTrcJmeter(driver, jur, dossier_TA.get(i), env);
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

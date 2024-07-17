package skipper;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class SkAdm_Navigation_Annuaire_Avocat {
	String SID;
	String jur;
	String browserName;
	String id;
	String mdp;
	String id1;
	String mdp1;
	String env;
	String identifiant;
	String password;
	List<String> myList;
	List<String> myList1;
	List<String> myList2;
	WebDriver driver;
	
	@Test
	public void navigation_skipper() throws Throwable {
		browserName = "firefox";
		env = "rec";
		jur = "CNDA_ADM";
		id = "adminoae";
		mdp = "adminoae00";
		id1 = "sice";
		mdp1 = "sice";
		SID = "CNDA";
		identifiant = "test4_gda";
		password = "BetaENV2023@&";
		
		
//		//Skipper
//		Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
//		Navigation_Sk_Adm_TabledeReference.acces_table_referense();
//		myList = Navigation_Sk_Adm_TabledeReference.verification_Acteur_Statut_Actif();
//		System.out.println(myList.size());
//		
//		//Fermeture de l'application
//		Navigation_Sk_Fermeture_Application.fermetureApplication(jur);
//		Navigation_Sk_Fermeture_Application.fermetureLanceurBAMO();	
	}
	
	@Test
	public void jdbc_list_cnda() throws SQLException {
		SID = "CNDA";
		env = "rec";
		id1 = "sice";
		mdp1 = "sice";
		JdbcClass.conDBSK(SID, env, id1, mdp1);
		myList1 = JdbcClass.listActeurInactif_CNDA1();
		System.out.println(myList1);
		System.out.println(myList1.size());
		
		//comparaison des deux listes : inactif(SKIPPER) ; inactif(BDD-SKIPPER)
		MicroFonctions.compareList(myList, myList1);
		
		//Récupération de la liste des actifs (BDD-SKIPPER)
		myList2 = JdbcClass.listActeurActif_CNDA1();
		System.out.println(myList2);
		System.out.println(myList2.size());
	}
	
	@Test
	public void verif_avocat_oae() throws Throwable {
		
		//Ouverture du navigateur
		driver = Navigateur.choixBrowser(browserName);
		System.out.println(driver);
		
		//Authentification
		MicroFonctions.authentification_OAE(driver, identifiant, password);
		
		//Accès à l'onglet "Gestion des disponibilités des avocats - Inactif"
		MicroFonctions.Verification_AvocatOAE_Inactif1(driver, myList1);
		System.out.println("\"Gestion des disponibilités des avocats - Inactif\" - Traitement terminé...."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Accès à l'onglet "Gestion des disponibilités des avocats - Inactif"
		MicroFonctions.Verification_AvocatOAE_Actif1(driver, myList2);
		System.out.println("\"Gestion des disponibilités des avocats - Actif\" - Traitement terminé...."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
	}
	

}

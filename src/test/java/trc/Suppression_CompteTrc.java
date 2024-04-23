package trc;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import JDBC.JdbcClass;

public class Suppression_CompteTrc {
	String mail;
	int nbr;
	String date;
	
	@BeforeSuite
	public void connexion_BBD_TRC() throws Throwable {
	JdbcClass.conDBTRC("rec");//rec ou int1
	}
	 
	
	@Test(enabled=true)
	public void modification_compte_pour_suppression() throws Throwable {
	mail = "fargo@yopmail.com";
	nbr = 12;
		JdbcClass.modification_date_derniere_connexion_compteTRC(mail, nbr);
		Trc_Compte_Suppression.utilisateur_Trc_Sans_Dossier(mail);
	}
	

	@Test(enabled=true)
	public void modification_compte_pour_suppression2() throws Throwable{
	mail = "cahut@yopmail.com";
	nbr = 12;
	JdbcClass.modification_date_derniere_connexion_compteTRC(mail, nbr);
		Trc_Compte_Suppression.utilisateur_Trc_Avec_Dossiers(mail);
		JdbcClass.modification_date_dernier_rappel_compteTRC(mail);
	}
}

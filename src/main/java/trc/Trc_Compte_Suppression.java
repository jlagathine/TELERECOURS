package trc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import JDBC.JdbcClass;
import lesFonctions.MesFonctions;

public class Trc_Compte_Suppression {

	static boolean verif;
	static Date date;
	
	public static String utilisateur_Trc_Sans_Dossier(String mail) throws Throwable {
		//Verification du nombre de requête en cours
		verif = JdbcClass.verification_aucun_dossier(mail);
		System.out.println(verif);
		int nbrMoisAdd = 7;
			if(verif && Trc_Compte_Suppression.calcul_date_derniere_connexion(mail, nbrMoisAdd)) {
				//modifier la date de création de compte
				int nbr = 9;
				JdbcClass.change_date_mois_creation_compteTRC(mail, nbr);
				System.out.println("La date de création du compte a été modifiée....."+MesFonctions.extractCurrentHeure()+"\r");
				}else {
					System.err.println("Un ou plusieurs dossiers sont présents");
				}

		return null;
	}

	@SuppressWarnings("static-access")
	public static boolean calcul_date_derniere_connexion(String mail, int dernierConnexion) throws Throwable {
		//Vérification de la dernière connexion
		String myDate = JdbcClass.verification_derniere_connexion(mail);
		
		//Mise en forme de la date 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date date = sdf.parse(myDate.replaceAll("-", "/"));
		
		//Ajout d'un nombre de mois à la date de la dernière connexion
		calendar.setTime(date);
		calendar.add(calendar.MONTH, dernierConnexion);
		
		boolean verif = false;
		
		//Si le nombre de mois ajouté à la date de la dernière connexion (en ms) est inférieur à la date du jour en milliseconde alors l'acteur devrait être notifié
		if(calendar.getTimeInMillis()<System.currentTimeMillis()){
			System.out.println("L'utilisateur "+mail+" devra être prévenu de la prochaine fermeture de son compte"+"\r");
			verif = true;
		}else {
			System.err.println("L'utilisateur "+mail+" ne devra pas être prévenu de la prochaine fermeture de son compte"+"\r");
		}
		
		return verif;
	}
	
	public static String utilisateur_Trc_Avec_Dossiers(String mail) throws Throwable {
		//Verification du nombre de requête en cours
		verif = JdbcClass.verification_dossier_en_cour(mail);
		System.out.println(verif);
		int nbrMoisAdd = 8;
			if(/*verif &&*/ Trc_Compte_Suppression.calcul_date_derniere_connexion(mail, nbrMoisAdd)) {
				//modifier la date de création de compte
				int nbr = (4*12)+13;//date de création du compte des dossiers de l'utilisateur
				JdbcClass.change_date_mois_creation_compteTRC(mail, nbr);
				System.out.println("La date de création du compte a été modifiée....."+MesFonctions.extractCurrentHeure()+"\r");
				
				JdbcClass.modification_date_dossier(mail, (4*12)+13);//derniere date de modification des dossiers de l'utilisateur
				nbr = 12; //dernière connexion
				JdbcClass.modification_date_derniere_connexion_compteTRC(mail, nbr);
				}

		return null;
	}
	
}

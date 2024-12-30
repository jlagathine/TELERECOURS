package tr_skipper_bout_en_bout;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import juridictions.JurDocTr;
import lesFonctions.MesFonctions;
import requete_depot_enreg.Requete_TR_depot_enreg;
import skipper.Navigation_Sk_Authentification;
import skipper.Navigation_Sk_Fermeture_Application;
import skipper.Navigation_Sk_Fermeture_Dossier;
import skipper.Navigation_Sk_Ouverture_Dossier;
import skipper.Navigation_Sk_Seance_Jugement;
import skipper.Navigation_Skipper_Creation_Defendeur;
import transmissions.Transmission_TR_expediteur;

public class Decision_Envoi {
	WebDriver driver;
	String browserName;
	String jur;
	String id;
	String mdp;
	String env;
	String dossier;
	String qualite;
	String type;
	String nom;
	String mail;
	String saisine;
	String date;
	String heure;
	String role;
	List<String> lst = new ArrayList<>();

	@Test(priority = 1)
	public void navigation_skipper() throws Throwable {
		browserName = "chrome";
		jur = "CTX";
		env = "rec";
		id = "lb";
		mdp = "lb";
		saisine = "Jugement";
		date = MesFonctions.ajouter_jour_date(0); //nombre de jour ajouter à la décision
		heure = "1600";//horaire de mise à disposition de la décision (regarder la prochaine exécution du job DECISIONS_SAISIES depuis le AdminTR)
		
		dossier = "367947";//Requete_TR_depot_enreg.TR_depot(jur, browserName, saisine, env);
		
		try {
			//SKIPPER_ouverture
			Navigation_Sk_Authentification.authentification_env(jur, id, mdp, env);
			
			//Ouverture dossier
			Navigation_Sk_Ouverture_Dossier.selectDossierSk(jur, dossier);
			
			//Ajout défendeur
			qualite = "defendeur"; //defendeur
			type = "Sociétés privées";
			nom ="BERIM";
			Navigation_Skipper_Creation_Defendeur.selectionActeur_defendeur_requerant(jur);
			Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
			
			qualite = "requérant"; //defendeur
			type = "Administrations locales";
			nom ="ACADEMIE DE PARIS";
			Navigation_Skipper_Creation_Defendeur.selectionActeur_defendeur_requerant(jur);
			Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
			
			/*modifier l'ajout du deuxième acteur*/
			qualite = "defendeur"; //defendeur
			type = "Ministères";
			nom ="MINISTERE DE LA DEFENSE";
			Navigation_Skipper_Creation_Defendeur.click_Btn_Creer(jur);
			Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
			
			qualite = "observateur"; //defendeur
			type = "Autres";
			nom ="BANQUE";
			Navigation_Skipper_Creation_Defendeur.click_Btn_Creer(jur);
			Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
			
			qualite = "intervenant";
			type = "Préfets";
			nom ="PREFECTURE DE LA GIRONDE";
			Navigation_Skipper_Creation_Defendeur.click_Btn_Creer(jur);
			Navigation_Skipper_Creation_Defendeur.SelectionQualiteActeur(qualite, jur);
			Navigation_Skipper_Creation_Defendeur.fiche_acteur(jur, nom, type);
			
			//fermeture dossier
			Navigation_Sk_Fermeture_Dossier.fermerDossierSk(jur);
			
			//Création d'une séance de jugement
			role = Navigation_Sk_Seance_Jugement.creation_seance(jur, date, heure, dossier);
			
			//Saisie du sens de la décision
			Navigation_Sk_Seance_Jugement.saisie_sens_decision(jur, date, heure, dossier, role);
			
			//SKIPPER_fermeture
			Navigation_Sk_Fermeture_Application.fermeture_sk(jur);
			
		} catch (Exception e) {
			My_SreenShot.screenshot();
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void verification_table() throws SQLException {
		//Connexion BDD TR
		JdbcClass.conDBTR("telerecours", "telerecours", env);
		
		//Vérification réplications
		JdbcClass.replication_evt(dossier);
	}
	 
	@Test(priority = 3)
	public void navigation_tr_transmission() throws Throwable {
//		dossier = "367923";
//		browserName = "chrome";
//		jur = "CTX";
//		env = "rec";
//		id = "fm";
//		mdp = "fm";
		try {
			
			//Ouverture du navigateur
			driver = Navigateur.choixBrowser(browserName);
			System.out.println(driver);
			
			//Choix du site
			Transmission_TR_expediteur.choix_site_juridiction(driver, jur, id, mdp, env);
			
			//Selection du dossier
			Transmission_TR_expediteur.selection_dossier(driver, dossier);
			
			//Accès à l'onglet "HISTORIQUE" du dossier
			MicroFonctions.consultationOngletHistoDossier(driver);
			
			//Création de la pièce à ajouter
			MicroFonctions.PDF_ecrire_decision(dossier);
			
			//Accès au dépôt manuel de pièces 
			JurDocTr.acces_PAM_arret(driver);
			JurDocTr.Ajout_PAM_Decision(driver);
			JurDocTr.selection_PAM_avant_enregistrment_DECISION(driver);
			JurDocTr.enregister_PAM(driver);
			
			//Deconnexion
			MicroFonctions.deconnexionTrInt(driver);
			driver.close();
			
			}catch (Exception e) {
				My_SreenShot.takeScreenshot(driver);
				e.printStackTrace();
				throw new Exception("Test interrompu....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}	
		}
	
	@Test(priority = 4)
	public void recuperation_adresse_mail_acteur_dossier() throws SQLException {
		//Connexion BDD TR
		JdbcClass.conDBTR("telerecours", "telerecours", env);
		
		//Récuperation adresse mail acteur dossier
		lst = JdbcClass.recuperation_email(dossier);
		
	}
	
	@Test(priority = 5)
	public void verification_creation_job_decision() throws SQLException {
		if(date.equals(MesFonctions.extractCurrentDate())) {
		//Connexion BDD TR
		JdbcClass.conDBTR("telerecours", "telerecours", env);
		
		//vérification de la création du job décision
		mail = JdbcClass.Verification_job_decision(dossier);
		List<String> maillst = new ArrayList<>();
		
		int cnt = MesFonctions.count_caractere(mail, ';');
			for(int i=0;i<=cnt;i++) {
				System.out.println(mail.split(";")[i]); ;
				maillst.add(mail.split(";")[i]);
			}
		//ordonner la liste par orde alphabetique
			maillst.sort(Comparator.naturalOrder());	
			
		//comparaison de la liste d'envoi de mail avec la liste souhaitée
			if(maillst.equals(lst)) {
				System.out.println(maillst+"****"+lst);
				System.out.println("la liste des mails selectionnés pour l'envoi de la décision correspond à celle souhaitée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}else {
				System.err.println(maillst+"****"+lst);
				System.err.println("la liste des mails selectionnés pour l'envoi de la décision ne correspond pas à celle souhaitée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
		}
		System.out.println("La décision ne sera visible");
	}

}

package juridictions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurReqTr {
	
	static List<WebElement> elements;;
	static String username;
	static String password;
	static String myXpath;
	static WebElement element;
	static boolean verif;
	static String identifiant;
	static String mdp;
	static String value;
	static String mat;
	static String urg;
	static String juridiction;
	static String auteur;
	static String ref;
	static String numero;
	static String dateRecla;
	static String dateDec;
	static String nom;
	static String decAtt;
	static String req;
	static String Numreq ;
	static String caractSpec;
	static String inventaire;
	static String acteur;
	static String AJ;
	static String text;
	static String ChbrMatCatTA;
	static String ChbrMatCatCAA;
	static String ChbrMatCatCTX;
	static String dossier;
	static String URL;
	static int charge;
	static int nombre;
	static List<Integer> nbr = new ArrayList<Integer>();
	static List<String> str = new ArrayList<>();
	static List<String> str1 = new ArrayList<>();

	public static String maJuridiction(WebDriver driver, String choixJur, String env) throws Throwable {
//		nom = "tr2_ta75";
//		mdp = "tr2_ta75";
//		jdbcClass.conDBTR(nom, mdp);
		
		switch (choixJur) {
		case "TA":
			
			if(env=="rec") {
				URL = "https://www.telerecours.recette.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Accès page "+URL+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "marc617";//alfKT04 ; marc617 ; def8md0
				password = "Lhommeest2019*";
			}else {
				URL = "https://www.telerecours.int1.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Accès page "+URL+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "avotx32";//alfKT04 ; marc617
				password = "Lhommeest2019*";
			}
			
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			
			// Choix de la juridiction
			MicroFonctions.choixJuridictionTA(driver);
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			break;
			
		case "CAA":
			if(env=="rec") {
				URL = "https://www.telerecours.recette.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "bus5qtT";//aja8u1q//alfKT04 (administration ; retirer l'ajout du requérant )//bus5qtT
				password = "Lhommeest2019*";
			}else {
				URL = "https://www.telerecours.int1.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "avoq214";//aja8u1q//alfKT04 (administration ; retirer l'ajout du requérant )//bus5qtT
				password = "Lhommeest2019*";
			}
			
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			Thread.sleep(200);
			System.out.println("Authentification réussie; Username : "+username+" Mot de passe : "+password+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			// Choix de la juridiction
			MicroFonctions.choixJuridictionCAA(driver);
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			
			break;
			
		case "CTX":
			if(env=="rec") {
				URL = "https://www.telerecours.recette.conseil-etat.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie");
		
				username = "bilO1Et";//dai5mQr/aja8u1q/delM872
				password = "Lhommeest2019*";
			}else {
				URL = "https://www.telerecours.int1.conseil-etat.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie");
		
				username = "avoq214";//dai5mQr/aja8u1q/delM872
				password = "Lhommeest2019*";
			}
			
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			Thread.sleep(200);
			System.out.println("Authentification réussie; Username : "+username+" Mot de passe : "+password+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			// Choix de la juridiction
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			break;
	
		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		return null;
	}
	
	public static String maAdmJuridiction(WebDriver driver, String choixJur, String env) throws Throwable {
		
		switch (choixJur) {
		case "TA":
			
			if(env=="rec") {
				URL = "https://www.telerecours.recette.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Accès page "+URL+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "alfKT04";//alfKT04 ; marc617 ; def8md0
				password = "Lhommeest2019*";
			}else {
				URL = "https://www.telerecours.int1.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Accès page "+URL+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "jes7d2G";//alfKT04 ; marc617
				password = "Lhommeest2019*";
			}
			
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			
			// Choix de la juridiction
			MicroFonctions.choixJuridictionTA(driver);
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			break;
			
		case "CAA":
			if(env=="rec") {
				URL = "https://www.telerecours.recette.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "alfKT04";//aja8u1q//alfKT04 (administration ; retirer l'ajout du requérant )//bus5qtT
				password = "Lhommeest2019*";
			}else {
				URL = "https://www.telerecours.int1.juradm.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
				username = "jes7d2G";//aja8u1q//alfKT04 (administration ; retirer l'ajout du requérant )//bus5qtT
				password = "Lhommeest2019*";
			}
			
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			Thread.sleep(200);
			System.out.println("Authentification réussie; Username : "+username+" Mot de passe : "+password+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			// Choix de la juridiction
			MicroFonctions.choixJuridictionCAA(driver);
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			
			break;
			
		case "CTX":
			if(env=="rec") {
				URL = "https://www.telerecours.recette.conseil-etat.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie");
		
				username = "mat07Jz";//dai5mQr/aja8u1q/delM872
				password = "Lhommeest2019*";
			}else {
				URL = "https://www.telerecours.int1.conseil-etat.fr/";
				driver.get(URL);
				Thread.sleep(100);
				System.out.println("Connection réussie");
		
				username = "jes7d2G";//dai5mQr/aja8u1q/delM872
				password = "Lhommeest2019*";
			}
			
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			Thread.sleep(200);
			System.out.println("Authentification réussie; Username : "+username+" Mot de passe : "+password+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			// Choix de la juridiction
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			break;
	
		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		return null;
	}

	public static String reqDepot (WebDriver driver, String choixJur, String saisine, String env) throws Throwable {
		
		switch (choixJur) {
		case "CAA":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Click bouton \"PREPARER L'ENVOI D'UNE REQUETE\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Ajouter un requérant
			MicroFonctions.ajouterUnRequerant(driver, choixJur);

			// Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(200);
			value = "05";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(100);
			int nbrMem ;
			if(!saisine.equals("Premier ressort")) {
			value = "1";
			auteur = MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "22/06/2023";
//			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(dateDec);// Date de décision
			MicroFonctions.date_picker_Tr(driver, dateDec);
			
			if(env=="rec") {
				value = "11027";
				juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);	
			}else {
				value = "11074";
				juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);	
			}
			
			String myXpath = "//input[@id='Mstr_cpMain_txtNumeroDecision']";
			
			numero = "2300541";
			MesFonctions.goToDown(driver, myXpath);
			Thread.sleep(300);
			MesFonctions.objet(driver, myXpath).sendKeys(numero);// numéro
			
			
			//fichier de décision attaquée
			nbrMem = MicroFonctions.depotFilesReqTr_Dec(driver);
			nbr.add(nbrMem);
			
				}else if(saisine == "Premier ressort") {
				value = "13";
				auteur = MicroFonctions.choixSaisine(driver, value);
					}
			
			// Requête
			int nbrMem1 = MicroFonctions.depotFilesReqTr_req(driver);
			nbr.add(nbrMem1);

			// Pièces complémentaires
			int nbrMem2 = MicroFonctions.depotFilesReqTr_pics(driver);
			nbr.add(nbrMem2);

			// AJ
			int nbrMem3 = MicroFonctions.depotFilesReqTr_JA(driver);
			nbr.add(nbrMem3);

			// Inventaire
			int nbrMem4 = MicroFonctions.depotFilesReqTr_inv(driver);
			nbr.add(nbrMem4);
			
			//Verifier nombre de fichiers chargés
			charge = 8;
			MicroFonctions.nombreFichiersCharges(nbr, charge);
			
			// information par courriel
			MicroFonctions.actInfoCourriel(driver);
			
			// Conversion PDF
			MicroFonctions.conversionPDF(driver);

			// Verification du fichier
			myXpath =  "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
			MicroFonctions.pdfVerfication(driver, myXpath);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver, myXpath).click();// Vérification
			Thread.sleep(200);
			
			// Modification du fichier de la requête
			MicroFonctions.ajout_fichier_requete_page_verification(driver);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver, myXpath).click();// Vérification
			Thread.sleep(200);

			// Vérification des fichiers téléchargés
			System.out.println("Vérification des fichiers en cours......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			//Decision
			if(saisine != "Premier ressort") {
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(decAtt);
			Thread.sleep(200);
			}
			
			//Requête
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(req);
			Thread.sleep(200);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(AJ);
			Thread.sleep(200);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(inventaire);
			Thread.sleep(200);
			
			System.out.println(str);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			
			// Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(200);
			 
			//déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			break;
			
		case "TA":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Click bouton \"PREPARER L'ENVOI D'UNE REQUETE\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
			//Ajouter un requérant
			MicroFonctions.ajouterUnRequerant(driver, choixJur);

			// Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(200);
			value = "01";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(200);
			auteur = "PREFECTURE DE PARIS";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtAuteurDecAtt']")).sendKeys(auteur);// Auteur
			ref = "22PA2156";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtReferenceDecAtt']")).sendKeys(ref);// Référence
			dateRecla = "11/05/2021";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecRec']")).sendKeys(dateRecla);// Date de
																											// réclamation
			dateDec = "18/03/2020";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttTA']")).sendKeys(dateDec);// Date de décision

			nbrMem = MicroFonctions.depotFilesReqTr_Dec(driver);
			nbr.add(nbrMem);
			
			// Requête
			nbrMem1 =MicroFonctions.depotFilesReqTr_req(driver);
			nbr.add(nbrMem1);

			// Pièces complémentaires
			nbrMem2 =MicroFonctions.depotFilesReqTr_pics(driver);
			nbr.add(nbrMem2);

			// AJ
			nbrMem3 =MicroFonctions.depotFilesReqTr_JA(driver);
			nbr.add(nbrMem3);

			// Inventaire
			nbrMem4 =MicroFonctions.depotFilesReqTr_inv(driver);
			nbr.add(nbrMem4);
			
			//Verifier nombre de fichiers chargés
			charge = 8;
			MicroFonctions.nombreFichiersCharges(nbr, charge);
			
			// information par courriel
			MicroFonctions.actInfoCourriel(driver);
			
			// Conversion PDF
			MicroFonctions.conversionPDF(driver);

			// Verification du fichier
			myXpath =  "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
			MicroFonctions.pdfVerfication(driver, myXpath);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(200);
			
			//Modification du fichier de la requête
			MicroFonctions.ajout_fichier_requete_page_verification(driver);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(200);
			
			// Vérification des fichiers téléchargés
			//Decision
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(decAtt);
			Thread.sleep(200);
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(req);
			Thread.sleep(200);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(AJ);
			Thread.sleep(200);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(inventaire);
			Thread.sleep(200);
			
			System.out.println(str);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			
			// Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(200);
			
			// Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			Thread.sleep(200);
			
			break;
			
		case "CTX":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Click bouton \"PREPARER L'ENVOI D'UNE REQUETE\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Ajouter un requérant
			MicroFonctions.ajouterUnRequerant(driver, choixJur);

			// Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(200);
			value = "11";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(100);
			if(!saisine.equals("Premier ressort")) {
			value = "10";
			auteur = MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "17/06/2022";
			
//			MesFonctions.objet(driver, myXpath).sendKeys(dateDec);// Date de décision
			MicroFonctions.date_picker_Tr(driver, dateDec);
			
			value = "11074";
			juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);
			
			numero = "2002541";
			myXpath = "//input[@id='Mstr_cpMain_txtNumeroDecision']";
			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver, myXpath).sendKeys(numero);// numéro
			
			
			nbrMem = MicroFonctions.depotFilesReqTr_Dec(driver);
			nbr.add(nbrMem);
			}else if(saisine.equals("Premier ressort")) {
				value = "2";
				auteur = MicroFonctions.choixSaisine(driver, value);
					}
			
			// Requête
			nbrMem1 =MicroFonctions.depotFilesReqTr_req(driver);
			nbr.add(nbrMem1);

			// Pièces complémentaires
			nbrMem2 =MicroFonctions.depotFilesReqTr_pics(driver);
			nbr.add(nbrMem2);

			// AJ
			nbrMem3 =MicroFonctions.depotFilesReqTr_JA(driver);
			nbr.add(nbrMem3);

			// Inventaire
			nbrMem4 =MicroFonctions.depotFilesReqTr_inv(driver);
			nbr.add(nbrMem4);
			
			//Verifier nombre de fichiers chargés
			charge = 8;
			MicroFonctions.nombreFichiersCharges(nbr, charge);
			
			// information par courriel
			MicroFonctions.actInfoCourriel(driver);
			
			// Conversion PDF
			MicroFonctions.conversionPDF(driver);

			// Verification du fichier
			myXpath =  "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
			MicroFonctions.pdfVerfication(driver, myXpath);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(200);
			
			
			//Modification du fichier de la requête
			MicroFonctions.ajout_fichier_requete_page_verification(driver);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(200);
			

			// Vérification des fichiers téléchargés
			System.out.println("Vérification des fichiers en cours...");
			//Decision
			if(saisine != "Premier ressort") {
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(decAtt);
			Thread.sleep(200);
			}
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierRequete_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver,myXpath, caractSpec);
			str.add(req);
			Thread.sleep(200);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(AJ);
			Thread.sleep(200);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(inventaire);
			Thread.sleep(200);
			
			System.out.println(str);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			
			// Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(200);
			
			// Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			break;

		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		return dossier;
	}
	
public static String reqAdmDepot (WebDriver driver, String choixJur, String env) throws Throwable {
		
		switch (choixJur) {
		case "CAA":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Click bouton \"PREPARER L'ENVOI D'UNE REQUETE\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

			// Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(200);
			value = "05";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(100);
			value = "1";
			auteur = MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "22/06/2023";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(dateDec);// Date de décision
			
			if(env=="rec") {
				value = "11027";
				juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);	
			}else {
				value = "11074";
				juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);	
			}
			
			numero = "2300541";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumeroDecision']")).sendKeys(numero);// numéro
			
			int nbrMem = MicroFonctions.depotFilesReqTr_Dec(driver);
			nbr.add(nbrMem);
			
			// Requête
			int nbrMem1 =MicroFonctions.depotFilesReqTr_req(driver);
			nbr.add(nbrMem1);

			// Pièces complémentaires
			int nbrMem2 =MicroFonctions.depotFilesReqTr_pics(driver);
			nbr.add(nbrMem2);

			// AJ
			int nbrMem3 =MicroFonctions.depotFilesReqTr_JA(driver);
			nbr.add(nbrMem3);

			// Inventaire
			int nbrMem4 =MicroFonctions.depotFilesReqTr_inv(driver);
			nbr.add(nbrMem4);
			
			//Verifier nombre de fichiers chargés
			charge = 8;
			MicroFonctions.nombreFichiersCharges(nbr, charge);
			
			// information par courriel
			MicroFonctions.actInfoCourriel(driver);
			
			// Conversion PDF
			MicroFonctions.conversionPDF(driver);

			// Verification du fichier
			myXpath =  "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
			MicroFonctions.pdfVerfication(driver, myXpath);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(200);
			

			// Vérification des fichiers téléchargés
			System.out.println("Vérification des fichiers en cours......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			//Decision
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(decAtt);
			Thread.sleep(200);
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(req);
			Thread.sleep(200);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(AJ);
			Thread.sleep(200);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(inventaire);
			Thread.sleep(200);
			
			System.out.println(str);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			
			// Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(200);
			 
			//déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			break;
			
		case "TA":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Click bouton \"PREPARER L'ENVOI D'UNE REQUETE\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

			// Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(200);
			value = "01";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(200);
			auteur = "PREFECTURE DE PARIS";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtAuteurDecAtt']")).sendKeys(auteur);// Auteur
			ref = "22PA2156";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtReferenceDecAtt']")).sendKeys(ref);// Référence
			dateRecla = "11/05/2021";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecRec']")).sendKeys(dateRecla);// Date de
																											// réclamation
			dateDec = "18/03/2020";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttTA']")).sendKeys(dateDec);// Date de décision

			nbrMem = MicroFonctions.depotFilesReqTr_Dec(driver);
			nbr.add(nbrMem);
			
			// Requête
			nbrMem1 =MicroFonctions.depotFilesReqTr_req(driver);
			nbr.add(nbrMem1);

			// Pièces complémentaires
			nbrMem2 =MicroFonctions.depotFilesReqTr_pics(driver);
			nbr.add(nbrMem2);

			// AJ
			nbrMem3 =MicroFonctions.depotFilesReqTr_JA(driver);
			nbr.add(nbrMem3);

			// Inventaire
			nbrMem4 =MicroFonctions.depotFilesReqTr_inv(driver);
			nbr.add(nbrMem4);
			
			//Verifier nombre de fichiers chargés
			charge = 8;
			MicroFonctions.nombreFichiersCharges(nbr, charge);
			
			// information par courriel
			MicroFonctions.actInfoCourriel(driver);
			
			// Conversion PDF
			MicroFonctions.conversionPDF(driver);

			// Verification du fichier
			myXpath =  "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
			MicroFonctions.pdfVerfication(driver, myXpath);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(200);
			

			// Vérification des fichiers téléchargés
			//Decision
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(decAtt);
			Thread.sleep(200);
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(req);
			Thread.sleep(200);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(AJ);
			Thread.sleep(200);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(inventaire);
			Thread.sleep(200);
			
			System.out.println(str);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			
			// Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(200);
			
			// Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			Thread.sleep(200);
			
			break;
			
		case "CTX":
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,  myXpath).click();
			System.out.println("Click bouton \"PREPARER L'ENVOI D'UNE REQUETE\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

			// Urgence et Matière
			urg = MicroFonctions.choixUrgence(driver);
			
			Thread.sleep(200);
			value = "11";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(100);
			value = "10";
			auteur = MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "07/06/2020";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(dateDec);// Date de décision
			
			value = "11074";
			juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);
			
			numero = "2002541";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumeroDecision']")).sendKeys(numero);// numéro
			
			nbrMem = MicroFonctions.depotFilesReqTr_Dec(driver);
			nbr.add(nbrMem);
			
			// Requête
			nbrMem1 =MicroFonctions.depotFilesReqTr_req(driver);
			nbr.add(nbrMem1);

			// Pièces complémentaires
			nbrMem2 =MicroFonctions.depotFilesReqTr_pics(driver);
			nbr.add(nbrMem2);

			// AJ
			nbrMem3 =MicroFonctions.depotFilesReqTr_JA(driver);
			nbr.add(nbrMem3);

			// Inventaire
			nbrMem4 =MicroFonctions.depotFilesReqTr_inv(driver);
			nbr.add(nbrMem4);
			
			//Verifier nombre de fichiers chargés
			charge = 8;
			MicroFonctions.nombreFichiersCharges(nbr, charge);
			
			// information par courriel
			MicroFonctions.actInfoCourriel(driver);
			
			// Conversion PDF
			MicroFonctions.conversionPDF(driver);

			// Verification du fichier
			myXpath =  "//a[@id='Mstr_cpMain_FileUploadRequeteFichier_DlFileLink_hplFichier']";
			MicroFonctions.pdfVerfication(driver, myXpath);
			
			// Envoyer
			myXpath = "//input[@id='Mstr_cpMain_btDeposerRequete2']";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(200);
			

			// Vérification des fichiers téléchargés
			System.out.println("Vérification des fichiers en cours...");
			//Decision
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(decAtt);
			Thread.sleep(200);
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierRequete_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver,myXpath, caractSpec);
			str.add(req);
			Thread.sleep(200);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(AJ);
			Thread.sleep(200);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			str.add(inventaire);
			Thread.sleep(200);
			
			System.out.println(str);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			
			// Récupération du num de reqête
			dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
			Thread.sleep(200);
			
			// Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			break;

		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		return dossier;
	}
	
		public static String reqEnreg (WebDriver driver, String choixJur, String dossier, String env) throws Throwable {
			
			switch (choixJur) {
			case "TA":
				if(env=="rec") {
					identifiant = "lb";
					mdp = "lb";
					
					// Authentification
					driver.get("https://www.telerecours.recette.juradm.fr/TA75");
					Thread.sleep(200);
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				}else {
					identifiant = "sice";
					mdp = "sice";
					
					// Authentification
					driver.get("https://www.telerecours.int1.juradm.fr/TA75");
					Thread.sleep(200);
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				}
				
				
				// Enregistrer le document
				MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				
				//récupération du nom de l'utilisateur
				String avocat = MicroFonctions.formaterNomActeur(driver);
				
				// Rattachement
				MicroFonctions.rattachement(driver, verif, avocat);
				
				// vérification des informations transmises lors du dépôt
				MicroFonctions.verifUrgence(driver, urg);
				MicroFonctions.verifMatiere(driver, mat);
				
				driver.findElement(By.xpath("//input[@value ='" + auteur + "']"));
				System.out.println("Acteur trouvé : " + auteur);
				Thread.sleep(100);
				driver.findElement(By.xpath("//input[@value ='" + ref + "']"));
				System.out.println("Référence du dossier trouvée : " + ref);
				Thread.sleep(100);
				driver.findElement(By.xpath("//input[@value ='" + dateRecla + "']"));
				System.out.println("Date de la réclamation trouvée : " + dateRecla);
				Thread.sleep(100);
				driver.findElement(By.xpath("//input[@value ='" + dateDec + "']"));
				System.out.println("Date de la décision trouvée : " + dateDec);

				Thread.sleep(100);
				
				// Choix de la chambre
				ChbrMatCatTA = "chambre";
				value ="11";
				MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
				Thread.sleep(100);

				// Choix de la matière
				ChbrMatCatTA = "matiere";
				value ="31";
				MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
				Thread.sleep(100);
				
				ChbrMatCatTA = "ssmatiere";
				value ="3101";
				MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
				Thread.sleep(100);

				// Choix de la catégorie
				ChbrMatCatTA = "categorie";
				value ="FI";
				MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
				Thread.sleep(100);
				
				// Sauvegarde de la requête
				MicroFonctions.sauvReq(driver);
				
				// Retour sur la page d'enregistrement
				Thread.sleep(100);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
				
				//Vérification fichiers 
				myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
				caractSpec = "_";
				String verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile1);
				
				myXpath = "//a[@id='fileLinkFichierCourrier_hplFichier']";
				caractSpec = "_";
				String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile2);
				
				myXpath = "//a[contains(@id,'fileLinkFichierPJRequete_hplFichier')]";
				caractSpec = "_";
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
				Thread.sleep(200);
				
				myXpath = "//a[@id='fileLinkFichierAideJur_hplFichier']";
				caractSpec = "_";
				String verifFile3 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile3);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				String verifFile4 = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(verifFile4);
				str1.add(verifFile4);
				
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
			   else {
				   System.err.println("Les tableaux sont différents\rtableau actuel : "+str1+" \rtableau attendu :"+str+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   //throw new Exception("tableau actuel : "+str1+" \rtableau attendu :"+str);
			   }

				Thread.sleep(200);
				
				//Enregistrement de la requête
				Numreq = MicroFonctions.enrgReq(driver);
				
				str1.clear();
				str.clear();
				   
			   	System.out.println("Dépôt et enregistrement TA terminés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");  
				
				break;
				
			case "CAA":
				if(env=="rec") {
					identifiant = "lb";
					mdp = "lb";
					
					// Authentification
					driver.get("https://www.telerecours.recette.juradm.fr/CA75");
					Thread.sleep(200);
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				}else {
					identifiant = "sice";
					mdp = "sice";
					
					// Authentification
					driver.get("https://www.telerecours.int1.juradm.fr/CA75");
					Thread.sleep(200);
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				}
				
				// Enregistrer le document
				MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				avocat = MicroFonctions.formaterNomActeur(driver);
//				String CP = microfonctions.code_postal(driver, element);
				
				
				// Rattachement
				MicroFonctions.rattachement(driver, verif, avocat);
				
				// vérification des informations transmises lors du dépôt
				MicroFonctions.verifUrgence(driver, urg);
				MicroFonctions.verifMatiere(driver, mat);
				String sais = MicroFonctions.verifSaisine(driver);
				
				if(!sais.equals("Premier ressort")){
					driver.findElement(By.xpath("//input[@value ='" + auteur + "']"));
					System.out.println("trouvé : " + auteur);
					Thread.sleep(100);
					driver.findElement(By.xpath("//input[@value ='" + dateDec + "']"));
					System.out.println("trouvé : " + dateDec);
					Thread.sleep(100);
					driver.findElement(By.xpath("//input[@value =\"" + juridiction + "\"]"));
					System.out.println("trouvé : " + juridiction);
					Thread.sleep(100);
					driver.findElement(By.xpath("//input[@value ='" + numero + "']"));
					System.out.println("trouvé : " + numero);

					Thread.sleep(100);
				}
				
				
				// Choix de la chambre
				ChbrMatCatCAA = "chambre";
				value ="1";
				MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
				Thread.sleep(100);

				// Choix de la matière
				ChbrMatCatCAA = "matiere";
				value ="09";
				MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
				Thread.sleep(100);
				
				ChbrMatCatCAA = "ssmatiere";
				value ="0906";
				MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
				Thread.sleep(100);

				// Choix de la catégorie
				ChbrMatCatCAA = "categorie";
				value ="CGV";
				MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
				Thread.sleep(100);
				
				// Sauvegarde de la requête
				MicroFonctions.sauvReq(driver);
				
				// Retour sur la page d'enregistrement
				Thread.sleep(300);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
				
				//Vérification fichiers
				if(!sais.equals("Premier ressort")){
				myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
				caractSpec = "_";
				verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile1);
				}
				
				myXpath = "//a[@id='fileLinkFichierCourrier_hplFichier']";
				caractSpec = "_";
				verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile2);
				
				myXpath = "//a[contains(@id,'fileLinkFichierPJRequete_hplFichier')]";
				caractSpec = "_";
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
				Thread.sleep(500);
				
				myXpath = "//a[@id='fileLinkFichierAideJur_hplFichier']";
				caractSpec = "_";
				verifFile3 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile3);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				verifFile4 = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(verifFile4);
				str1.add(verifFile4);
				
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
			   else {
				   System.err.println("Les tableaux sont différents\rtableau actuel : "+str1+" \rtableau attendu :"+str+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   //throw new Exception("tableau actuel : "+str1+" \rtableau attendu :"+str);
			   }

				Thread.sleep(200);
				
				//Enregistrement de la requête
				Numreq = MicroFonctions.enrgReq(driver);
				
				str1.clear();
			   	str.clear();
				   
			   	System.out.println("Dépôt et enregistrement CAA terminés......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");  
				
				break;

			case "CTX":
				if(env=="rec") {
					identifiant = "fm";
					mdp = "fm";
					
					// Authentification
					driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
					Thread.sleep(200);
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				}else {
					identifiant = "sice";
					mdp = "sice";
					
					// Authentification
					driver.get("https://www.telerecours.int1.conseil-etat.fr/conseil");
					Thread.sleep(200);
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				}
				
				
				
				// Enregistrer le document
				MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				avocat = MicroFonctions.formaterNomActeur(driver);
				
				
				// Rattachement
				MicroFonctions.rattachement(driver, verif, avocat);
				
				// vérification des informations transmises lors du dépôt
				MicroFonctions.verifUrgence(driver, urg);
				MicroFonctions.verifMatiere(driver, mat);
				sais = MicroFonctions.verifSaisine(driver);
				
				if(!sais.equals("Premier ressort")){
				driver.findElement(By.xpath("//input[@value ='" + auteur + "']"));
				System.out.println("trouvé : " + auteur);
				Thread.sleep(100);
				driver.findElement(By.xpath("//input[@value ='" + dateDec + "']"));
				System.out.println("trouvé : " + dateDec);
				Thread.sleep(100);
					if(env=="rec") {
					driver.findElement(By.xpath("//input[@value =\""+juridiction+"\"]"));
					System.out.println("trouvé : " + juridiction); //En int1 la mention est JUR_597 au lieu de COUR ADMINISTRATIVE D'APPEL DE PARIS
					}else {
						driver.findElement(By.xpath("//input[@value ='JUR_597']"));
						System.out.println("trouvé : " + juridiction); //En int1 la mention est JUR_597 au lieu de COUR ADMINISTRATIVE D'APPEL DE PARIS
					}
					
				Thread.sleep(100);
				driver.findElement(By.xpath("//input[@value ='" + numero + "']"));
				System.out.println("trouvé : " + numero);
				}
				

				Thread.sleep(100);
				
				// Choix de la chambre
				ChbrMatCatCTX = "chambre";
				value ="1";
				MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
				Thread.sleep(100);

				// Choix de la matière
				ChbrMatCatCTX = "matiere";
				value ="11";
				MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
				Thread.sleep(100);
				
				ChbrMatCatCTX = "ssmatiere";
				value ="1101";
				MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
				Thread.sleep(100);

				// Choix de la catégorie
				ChbrMatCatCTX = "categorie";
				value ="OPC";
				MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
				Thread.sleep(100);
				
				// Sauvegarde de la requête
				MicroFonctions.sauvReq(driver);
				
				// Retour sur la page d'enregistrement
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
				
				//Vérification fichiers 
				if(!sais.equals("Premier ressort")) {
				myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
				caractSpec = "_";
				verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile1);
				}
				
				myXpath = "//a[@id='fileLinkFichierRequete_hplFichier']";
				caractSpec = "_";
				verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile2);
				
				myXpath = "//a[contains(@id,'fileLinkFichierPJRequete_hplFichier')]";
				caractSpec = "_";
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
				Thread.sleep(200);
				
				myXpath = "//a[@id='fileLinkFichierAideJur_hplFichier']";
				caractSpec = "_";
				verifFile3 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile3);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				verifFile4 = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(verifFile4);
				str1.add(verifFile4);
				
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   }
			   else {
				   System.err.println("Les tableaux sont différents\rtableau actuel : "+str1+" \rtableau attendu :"+str+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   //throw new Exception("tableau actuel : "+str1+" \rtableau attendu :"+str);
			   }

				Thread.sleep(2000);
				
				//Enregistrement de la requête
				Numreq = MicroFonctions.enrgReq(driver);
				
				str1.clear();
			   	str.clear();
				   
			   	System.out.println("Dépôt et enregistrement CE terminés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");  
				
				break;
	
			default: System.err.println("Aucune juridiction sélectionnée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				break;
			}
			return Numreq;
		}
		
		public static String refusEnrgReq (WebDriver driver, String choixJur) throws Throwable {
			switch (choixJur) {
			case "TA":
				// Récupération du num de reqête
				String dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
				Thread.sleep(2000);
				
				// Déconnexion
				MicroFonctions.deconnexionTrExt(driver);
				
				identifiant = "lb";
				mdp = "lb";
				
				// Authentification
				driver.get("https://www.telerecours.recette.juradm.fr/TA75");
				Thread.sleep(2000);
				MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				
				// Enregistrer le document
				MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				String myXpath = "//input[@id='btRefuser']";
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,  myXpath));
				MesFonctions.objet(driver,  myXpath).click();
				
				//Accepter l'alerte
				myXpath = "//span[@class='ui-button-text' and text()='OK']";
				MesFonctions.objet(driver,  myXpath).click();
				Thread.sleep(2000);
				System.out.println("Alerte acceptée");
				
				//Changer de fenêtre 
				String childWindow = MesFonctions.childWindow(driver);
				driver.switchTo().window(childWindow);
				Thread.sleep(1000);
				System.out.println("Changement de fenêtre "+ childWindow);
				
				myXpath = "//th[text()=\"Renseigner le motif du refus :\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				driver.manage().window().maximize();
				
				//Renseigner le motif du refus 
				myXpath = "//textarea[@id='txtMotifRefus']";
				String texte = "lement du faux texte employé dans la composition et la mise en page avant impression. "
						+ "Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, "
						+ "quand un imprimeur anonyme assembla ensemble des morceaux de text";
				
				MesFonctions.objet(driver,  myXpath).sendKeys(texte);
				System.out.println("Motif renseigné");
				
				//Valider le refus
				myXpath = "//input[@id='btRefuser']";
				MesFonctions.objet(driver,  myXpath).click();
				System.out.println("Refus validé");
				
				//Revenir à la fenêtre 
				String parentWindow = MesFonctions.parentWindow(driver);
				driver.switchTo().window(parentWindow);
				System.out.println("Changement de fenêtre "+parentWindow);
				Thread.sleep(1000);
				
				//Accepter l'alerte
				myXpath = "//div[@id='ui-id-2']";
				String mess = MesFonctions.objet(driver,  myXpath).getText();
				System.out.println(mess);
				
				Thread.sleep(1000);
				myXpath = "//span[@class='ui-button-text' and text()='OK']";
				MesFonctions.objet(driver,  myXpath).click();

				String message = "La requête a été refusée.";

				if (mess.equals(message)) {
					Thread.sleep(1000);

				} else {
					throw new Exception("ERREUR LORS DU REFUS : " + mess);
				}
				
				break;
				
			case "CAA":
				// Récupération du num de reqête
				dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
				System.out.println(dossier);
				Thread.sleep(2000);
				
				// Déconnexion
				MicroFonctions.deconnexionTrExt(driver);
				
				identifiant = "lb";
				mdp = "lb";
				
				// Authentification
				driver.get("https://www.telerecours.recette.juradm.fr/CA75");
				Thread.sleep(2000);
				MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				
				// Enregistrer le document
				MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				myXpath = "//input[@id='btRefuser']";
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,  myXpath));
				MesFonctions.objet(driver,  myXpath).click();
				
				//Accepter l'alerte
				myXpath = "//span[@class='ui-button-text' and text()='OK']";
				MesFonctions.objet(driver,  myXpath).click();
				Thread.sleep(2000);
				System.out.println("Alerte acceptée");
				
				//Changer de fenêtre 
				childWindow = MesFonctions.childWindow(driver);
				driver.switchTo().window(childWindow);
				Thread.sleep(1000);
				System.out.println("Changement de fenêtre "+ childWindow);
				
				myXpath = "//th[text()=\"Renseigner le motif du refus :\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				driver.manage().window().maximize();
				
				//Renseigner le motif du refus 
				myXpath = "//textarea[@id='txtMotifRefus']";
				texte = "lement du faux texte employé dans la composition et la mise en page avant impression. "
						+ "Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, "
						+ "quand un imprimeur anonyme assembla ensemble des morceaux de text";
				
				MesFonctions.objet(driver,  myXpath).sendKeys(texte);
				System.out.println("Motif renseigné");
				
				//Valider le refus
				myXpath = "//input[@id='btRefuser']";
				MesFonctions.objet(driver,  myXpath).click();
				System.out.println("Refus validé");
				
				//Revenir à la fenêtre 
				parentWindow = MesFonctions.parentWindow(driver);
				driver.switchTo().window(parentWindow);
				System.out.println("Changement de fenêtre "+parentWindow);
				Thread.sleep(1000);
				
				//Accepter l'alerte
				myXpath = "//div[@id='ui-id-2']";
				mess = MesFonctions.objet(driver,  myXpath).getText();
				System.out.println(mess);
				
				Thread.sleep(1000);
				myXpath = "//span[@class='ui-button-text' and text()='OK']";
				MesFonctions.objet(driver,  myXpath).click();

				message = "La requête a été refusée.";

				if (mess.equals(message)) {
					Thread.sleep(1000);

				} else {
					throw new Exception("ERREUR LORS DU REFUS : " + mess);
				}
				
				break;
				
			case "CTX":
				// Récupération du num de reqête
				dossier = MicroFonctions.recupEnvoiNumReqTr(driver);
				System.out.println(dossier);
				Thread.sleep(2000);
				
				// Déconnexion
				MicroFonctions.deconnexionTrExt(driver);
				
				identifiant = "fm";
				mdp = "fm";
				
				// Authentification
				driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
				Thread.sleep(2000);
				MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
				
				// Enregistrer le document
				MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				myXpath = "//input[@id='btRefuser']";
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver,  myXpath));
				MesFonctions.objet(driver,  myXpath).click();
				
				//Accepter l'alerte
				myXpath = "//span[@class='ui-button-text' and text()='OK']";
				MesFonctions.objet(driver,  myXpath).click();
				Thread.sleep(2000);
				System.out.println("Alerte acceptée");
				
				//Changer de fenêtre 
				childWindow = MesFonctions.childWindow(driver);
				driver.switchTo().window(childWindow);
				Thread.sleep(1000);
				System.out.println("Changement de fenêtre "+ childWindow);
				
				myXpath = "//th[text()=\"Renseigner le motif du refus :\"]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				driver.manage().window().maximize();
				
				//Renseigner le motif du refus 
				myXpath = "//textarea[@id='txtMotifRefus']";
				texte = "lement du faux texte employé dans la composition et la mise en page avant impression. "
						+ "Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, "
						+ "quand un imprimeur anonyme assembla ensemble des morceaux de text";
				
				MesFonctions.objet(driver,  myXpath).sendKeys(texte);
				System.out.println("Motif renseigné");
				
				//Valider le refus
				myXpath = "//input[@id='btRefuser']";
				MesFonctions.objet(driver,  myXpath).click();
				System.out.println("Refus validé");
				
				//Revenir à la fenêtre 
				parentWindow = MesFonctions.parentWindow(driver);
				driver.switchTo().window(parentWindow);
				Thread.sleep(1000);
				
				//Accepter l'alerte
				myXpath = "//div[@id='ui-id-2']";
				mess = MesFonctions.objet(driver,  myXpath).getText();
				System.out.println(mess);
				
				Thread.sleep(1000);
				myXpath = "//span[@class='ui-button-text' and text()='OK']";
				MesFonctions.objet(driver,  myXpath).click();

				message = "La requête a été refusée.";

				if (mess.equals(message)) {
					Thread.sleep(1000);

				} else {
					throw new Exception("ERREUR LORS DU REFUS : " + mess);
				}
				
				break;
				
			default: System.err.println("Aucune juridiction à ce nom");
				break;
			}
			return null;
		}
}
		

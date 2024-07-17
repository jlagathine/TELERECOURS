package Juridictions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurDocTr {
	
	static WebElement element;
	static List<WebElement> elements;
	static String myXpath;
	static Select select;
	static String value;
	static String username;
	static String password;
	static String identifiant;
	static boolean verif;
	static String mdp;
	static Set<String> tab;
	static Iterator<String> it;
	static String caractSpec;
	static String nom;
	static String URL;
	static String acteur;
	static String nomMem;
	static String nomInv;
	static String text;
	static int index;
	static int sum;
	static int charge;
	static List<Integer> nbr = new ArrayList<Integer>();
	static List<String> str = new ArrayList<>();
	static List<String> str1 = new ArrayList<>();
	
	
		public static String maJuridiction(WebDriver driver, String choixJur, String env) throws Throwable {
			
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
				Thread.sleep(200);
				System.out.println("Authentification réussie");
				
				// Choix de la juridiction
				MicroFonctions.choixJuridictionTA(driver);
				
				// Bouton Documents
				MicroFonctions.accesDepotDoc(driver);
				
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
				System.out.println("Authentification réussie");
				
				// Choix de la juridiction
				MicroFonctions.choixJuridictionCAA(driver);
				
				// Bouton Documents
				MicroFonctions.accesDepotDoc(driver);
				
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
				Thread.sleep(2000);
				System.out.println("Authentification réussie");
				
				// Bouton Documents
				MicroFonctions.accesDepotDoc(driver);
				
				break;

			default: System.err.println("Aucune juridiction sélectionnée");
				break;
			}
			
			return null;
		}
	
		public static String docDepotMem (WebDriver driver, String choixJur, String dossier) throws Throwable {
			
			switch (choixJur) {
			case "TA":
				
				//Préparer l'envoi d'un document
				myXpath = "//a[@id='btnDeposerDocument']";
				MesFonctions.objet(driver, myXpath).click();
				Thread.sleep(2000);
				
				//choix du dossier
				value = "value"; //nom de l'attribut
				MicroFonctions.saisirNumDossierDepoTr(driver, dossier);
				
				//Type de Document
				index = 0;
				text = MicroFonctions.typeDoc(driver, index);
				
				//type de mémoire
				value = "RECMEM"; 
				MicroFonctions.typeMem(driver, value);
				int nbrMem = MicroFonctions.depotFilesDocTr_mem(driver);
				nbr.add(nbrMem);
				
				//type de pièces
				int nbrMem1 = MicroFonctions.depotFilesDocTr_pics(driver);
				nbr.add(nbrMem1);
				
				//Inventaire
				int nbrMem2 = MicroFonctions.depotFilesDocTr_inv(driver);
				nbr.add(nbrMem2);
				
				//Verifier nombre de fichiers chargés
				charge = 5;
				MicroFonctions.nombreFichiersCharges(nbr, sum, charge);
				
				//Convertion des fichiers en PDF
				MicroFonctions.conversionPDF(driver);
				Thread.sleep(2000);
				
				//Verification du fichier
				myXpath = "//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']";
				MicroFonctions.pdfVerfication(driver, myXpath);
				
				// Envoyer
				myXpath = "//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]";
				MesFonctions.objet(driver, myXpath).click();// Vérification
				Thread.sleep(2000);
				
				// Vérification des fichiers téléchargés
					//mémoire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(nomMem);
				str.add(nomMem);
				Thread.sleep(2000);
				
					//pieces complémentaires
				myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
				caractSpec = "_";
				str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec)); 
					
					//Inventaire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(nomInv);
				str.add(nomInv);
				Thread.sleep(2000);
				
				System.out.println(str);
				
				// Vérification succès envoi
				MicroFonctions.envoiDepotTr(driver);
				break;
				
			case "CAA":
				
				//Préparer l'envoi d'un document
				myXpath = "//a[@id='btnDeposerDocument']";
				MesFonctions.objet(driver, myXpath).click();
				Thread.sleep(2000);
				
				//choix du dossier
				value = "value"; //nom de l'attribut
				MicroFonctions.saisirNumDossierDepoTr(driver, dossier);
				
				//Type de Document
				index = 0;
				text = MicroFonctions.typeDoc(driver, index);
				
				//type de mémoire
				value = "RECMEM"; 
				MicroFonctions.typeMem(driver, value);
				MicroFonctions.depotFilesDocTr_mem(driver);
				
				//type de pièces
				MicroFonctions.depotFilesDocTr_pics(driver);
				
				//Inventaire
				MicroFonctions.depotFilesDocTr_inv(driver);
				
				//Convertion des fichiers en PDF
				MicroFonctions.conversionPDF(driver);
				Thread.sleep(2000);
				
				//Verification du fichier
				myXpath = "//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']";
				MicroFonctions.pdfVerfication(driver, myXpath);
				
				// Envoyer
				myXpath = "//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]";
				MesFonctions.objet(driver, myXpath).click();// Vérification
				Thread.sleep(2000);
				
				// Vérification des fichiers téléchargés
					//mémoire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(nomMem);
				str.add(nomMem);
				Thread.sleep(2000);
				
					//pieces complémentaires
				myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
				caractSpec = "_";
				str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec)); 
					
					//Inventaire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(nomInv);
				str.add(nomInv);
				Thread.sleep(2000);
				
				System.out.println(str);
				
				// Vérification succès envoi
				MicroFonctions.envoiDepotTr(driver);
				break;
				
			case "CTX":
				
				//Préparer l'envoi d'un document
				myXpath = "//a[@id='btnDeposerDocument']";
				MesFonctions.objet(driver, myXpath).click();
				Thread.sleep(2000);
				
				//choix du dossier
				value = "value"; //nom de l'attribut
				MicroFonctions.saisirNumDossierDepoTr(driver, dossier);
				
				//Type de Document
				index = 0;
				text = MicroFonctions.typeDoc(driver, index);
				
				//type de mémoire
				value = "RECPMEMO"; 
				MicroFonctions.typeMem(driver, value);
				MicroFonctions.depotFilesDocTr_mem(driver);
				
				//type de pièces
				MicroFonctions.depotFilesDocTr_pics(driver);
				
				//Inventaire
				MicroFonctions.depotFilesDocTr_inv(driver);
				
				//Convertion des fichiers en PDF
				MicroFonctions.conversionPDF(driver);
				Thread.sleep(2000);
				
				//Verification du fichier
				myXpath = "//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']";
				MicroFonctions.pdfVerfication(driver, myXpath);
				
				// Envoyer
				myXpath = "//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]";
				MesFonctions.objet(driver, myXpath).click();// Vérification
				Thread.sleep(2000);
				
				// Vérification des fichiers téléchargés
					//mémoire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(nomMem);
				str.add(nomMem);
				Thread.sleep(2000);
				
					//pieces complémentaires
				myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
				caractSpec = "_";
				str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec)); 
					
					//Inventaire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(nomInv);
				str.add(nomInv);
				Thread.sleep(2000);
				
				System.out.println(str);
				
				// Vérification succès envoi
				MicroFonctions.envoiDepotTr(driver);
				break;
				
			default: System.err.println("Aucune juridiction sélectionnée");
				break;
			}
			
		return null;
		}
		
		public static String docEnregMem (WebDriver driver, String choixJur, String dossier, String env) throws Throwable {
			
			switch (choixJur) {
			case "TA" :
				// Récupération du num de reqête
				dossier = MicroFonctions.recupEnvoiNumDocTr(driver);
				Thread.sleep(2000);
				
				// Déconnexion
				MicroFonctions.deconnexionTrExt(driver);
				
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
				myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.verifyPresenceOfElement(driver, myXpath, choixJur);
				System.out.println(MesFonctions.objet(driver, myXpath).getText().trim());
				
				driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
				
				myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
				caractSpec = " ";
				String strg = MesFonctions.leNom(driver, myXpath, caractSpec);
				int fin = strg.indexOf(strg.split(" ")[2]);
				acteur = strg.substring(0, fin).trim();
				System.out.println(acteur);
				
				// Rattachement
				MicroFonctions.rattachement(driver, verif, acteur);
				
				//Vérification du texte
				myXpath = "//textarea[@id='txtMessage']";
				String verifText = driver.findElement(By.xpath(myXpath)).getText();
				if(text.equals(verifText)) {
					System.out.println("Les textes sont identiques");}
					else {
						System.err.println("Les textes sont différents : ");
						throw new Exception(verifText+" Texte attendu : " +text);
						}
				
				//Vérification fichiers 
				myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				String verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile1);
				
				myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
				caractSpec = "_";
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
				Thread.sleep(2000);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(verifFile2);
				str1.add(verifFile2);
				
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents");
			   }
			   else {
				   System.err.println("Les tableaux sont différents");
				   throw new Exception("tableau actuel : "+str1+" \rtableau attendu :"+str);
			   }
				   
			   //Enregistrement du document 
			   Thread.sleep(1000);
			   MicroFonctions.enrgDoc(driver);
			   
			   Thread.sleep(2000);
			   str1.clear();
			   str.clear();
			   
			   System.out.println("Dépôt et enregistrement TRC TA terminés");
			   break;
			   
			case "CAA" :
				// Récupération du num de reqête
				dossier = MicroFonctions.recupEnvoiNumDocTr(driver);
				Thread.sleep(2000);
				
				// Déconnexion
				MicroFonctions.deconnexionTrExt(driver);
				
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
				myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.verifyPresenceOfElement(driver, myXpath, choixJur);
				System.out.println(MesFonctions.objet(driver, myXpath).getText().trim());
				
				driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
				
				myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
				caractSpec = " ";
				strg = MesFonctions.leNom(driver, myXpath, caractSpec);
				fin = strg.indexOf(strg.split(" ")[2]);
				acteur = strg.substring(0, fin).trim();
				System.out.println(acteur);
				
				// Rattachement
				MicroFonctions.rattachement(driver, verif, acteur);
				
				//Vérification du texte
				myXpath = "//textarea[@id='txtMessage']";
				verifText = driver.findElement(By.xpath(myXpath)).getText();
				if(text.equals(verifText)) {
					System.out.println("Les textes sont identiques");
					}
					else {
						System.err.println("Les textes sont différents : ");
						throw new Exception(verifText+" Texte attendu : " +text);
						}
				
				//Vérification fichiers 
				myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile1);
				
				myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
				caractSpec = "_";
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
				Thread.sleep(2000);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(verifFile2);
				str1.add(verifFile2);
				
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents");
			   }
			   else {
				   System.err.println("Les tableaux sont différents");
				   throw new Exception("tableau actuel : "+str1+" \rtableau attendu :"+str);
			   }
				   
			   //Enregistrement du document 
			   Thread.sleep(100);
			   MicroFonctions.enrgDoc(driver);
			   
			   Thread.sleep(200);
			   str1.clear();
			   str.clear();
			   
			   System.out.println("Dépôt et enregistrement TRC CA terminés");
			   break;
			   
			case "CTX" :
				// Récupération du num de reqête
				dossier = MicroFonctions.recupEnvoiNumDocTr(driver).replace("  /  ", " / ").trim();
				Thread.sleep(2000);
				
				// Déconnexion
				MicroFonctions.deconnexionTrExt(driver);
				
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
				acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier);
				
				// Rattachement
				MicroFonctions.rattachement(driver, verif, acteur);
				
				//Vérification du texte
				myXpath = "//textarea[@id='txtMessage']";
				verifText = driver.findElement(By.xpath(myXpath)).getText();
				if(text.equals(verifText)) {
					System.out.println("Les textes sont identiques");}
					else {
						System.err.println("Les textes sont différents : ");
						throw new Exception(verifText+" Texte attendu : " +text);
						}
				
				//Vérification fichiers 
				myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
				str1.add(verifFile1);
				
				myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
				caractSpec = "_";
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
				Thread.sleep(2000);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
				System.out.println(verifFile2);
				str1.add(verifFile2);
				
			   if(str1.equals(str)) {
				   System.out.println("Tous les fichiers sont présents");
			   }
			   else {
				   System.err.println("Les tableaux sont différents");
				   throw new Exception("tableau actuel : "+str1+" \rtableau attendu :"+str);
			   }
				   
			   //Enregistrement du document 
			   Thread.sleep(1000);
			   MicroFonctions.enrgDoc(driver);
			   
			   Thread.sleep(2000);
			   str1.clear();
			   str.clear();
			   
			   System.out.println("Dépôt et enregistrement TRC CE terminés");
			   break;

			default: System.err.println("Aucune juridiction sélectionnée");
				break;
			}
			return dossier;
		}
		
		public static void acces_PAM(WebDriver driver) {
		//Accès à la ligne de la mesure "RECEPETION D'UN MEMEOIRE"
		String myXpath = "//td[text()=\"Réception d'un mémoire\"]//following-sibling::td/span";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		System.out.println("Affichage de la fenêtre de PAM....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		public static void Ajout_PAM(WebDriver driver) {
		//Accès à la fenêtre des pièces jointe"
		String onglet = MesFonctions.getWindow(driver, 2);
		driver.switchTo().window(onglet);
		String myXpath = "//span[text()='Fichiers']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Accès à la fenêtre des pièces jointe....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
			for(int i=0;i<5;i++) {
			//Ajout de pièces
			myXpath = "//input[@id='fuAjouterFichier']";
			int pcs = i+2;
			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 5\\Le Mémoire 5 - Copie ("+pcs+").pdf");
			
			System.out.println("La picèes est chargée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Renseigner le type de pièce
			myXpath = "//select[@id='ddlTypeFichier']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			String value = "MEM";
			MesFonctions.selection(driver, myXpath, value);
			System.out.println("Le type de pièce est renseigné....."+MesFonctions.extractCurrentHeure());
			
			//Joindre la pièce
			myXpath = "//a[@id='lbJoindreFichier']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			System.out.println("Le type de pièce "+pcs+" est jointe....."+MesFonctions.extractCurrentHeure());
			}
		
		}
		
		public static String selection_PAM_avant_enregistrment (WebDriver driver) {
		//Sélection des fichiers
		myXpath = "//input[contains(@id,'SelectCheckBox')]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elts = driver.findElements(By.xpath(myXpath));
		List<String> nom_fichier = new ArrayList<>();
		int nbr = elts.size()+1;
		for(int i=1;i<nbr;i++) {
			myXpath = "(//input[contains(@id,'SelectCheckBox')])["+i+"]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			
			myXpath = "(//input[contains(@id,'SelectCheckBox')])["+i+"]//ancestor::td//following-sibling::td//span/a";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Le ficher : "+MesFonctions.objet(driver, myXpath).getText().trim()+"...."+MesFonctions.extractCurrentHeure());
			 
			nom_fichier.add(MesFonctions.objet(driver, myXpath).getText().trim());
			}
		String str =  nom_fichier.get(1).split("_")[0];
		System.out.println("Toutes les pièces ont été ajoutées....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return str;
		}
		
		public static void enregister_PAM (WebDriver driver) throws InterruptedException {
		myXpath = "//a[@id='lbEnregistrer']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Toutes les pièces ont été enregistrées....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		String onglet = MesFonctions.getWindow(driver, 1);
		driver.switchTo().window(onglet);
		}
		
	}

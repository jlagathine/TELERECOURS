package juridictions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurReqTrFlechage {
	static List<WebElement> elements;;
	static String username;
	static String password;
	static String myXpath;
	static String parentWindow;
	static String childWindow;
	static WebElement element;
	static boolean verif;
	static String identifiant;
	static String mdp;
	static String value;
	static String mat;
	static String mat1;
	static String mat2;
	static String urg;
	static String urg1;
	static String urg2;
	static String juridiction;
	static String auteur;
	static String ref;
	static String numero;
	static String dateRecla;
	static String dateDec;
	static String nom;
	static String dossier;
	static String dossier1;
	static String dossier2;
	static String decAtt;
	static String req;
	static String caractSpec;
	static String inventaire;
	static String acteur;
	static String AJ;
	static String text;
	static String ChbrMatCatTA;
	static String ChbrMatCatCAA;
	static String ChbrMatCatCTX;
	static String requete;
	static String requete1;
	static String requete2;
	static int charge;
	static int nombre;
	static List<String> fil3 = new ArrayList<>(); 
	static List<String> fil2 = new ArrayList<>();
	static List<String> fil1 = new ArrayList<>(); 
	static List<String> fil = new ArrayList<>(); 
	static List<Integer> nbr = new ArrayList<Integer>();
	static List<String> str = new ArrayList<>();
	static List<String> str1 = new ArrayList<>();

	public static String maJuridiction(WebDriver driver, String choixJur) throws Throwable {
		
		switch (choixJur) {
		case "Tribunal":
			
			driver.get("https://www.telerecours.recette.juradm.fr/");
			Thread.sleep(2000);
			System.out.println("Connection réussie");
	
			username = "afl53e7";
			password = "Lhommeest2019*";
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			Thread.sleep(2000);
			System.out.println("Authentification réussie");
			
			// Choix de la juridiction
			MicroFonctions.choixJuridictionTA(driver);
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			break;
			
		case "Cour":
			
			driver.get("https://www.telerecours.recette.juradm.fr/");
			Thread.sleep(2000);
			System.out.println("Connection réussie");
	
			username = "bus5qtT";
			password = "Lhommeest2019*";
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			Thread.sleep(2000);
			System.out.println("Authentification réussie");
			
			// Choix de la juridiction
			MicroFonctions.choixJuridictionCAA(driver);
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			
			break;
			
		case "Conseil":
			
			driver.get("https://www.telerecours.recette.conseil-etat.fr/");
			Thread.sleep(2000);
			System.out.println("Connection réussie");
	
			username = "dai5mQr";
			password = "Lhommeest2019*";
			
			//Authentification
			myXpath = "//input[@id='Username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTaCaaCeExt(driver, username, password);
			Thread.sleep(2000);
			System.out.println("Authentification réussie");
			
			// Choix de la juridiction
			MicroFonctions.accesDepotReq(driver, choixJur);
			
			break;
	
		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		return null;
	}
	
	public static String reqDepotFlec (WebDriver driver, String choixJur) throws Throwable {
		
		switch (choixJur) {
		case "Tribunal":
			int loop = 3;
		for(int i = 0; i < loop ; i++) {
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();

			//Ajouter un requérant
			MicroFonctions.ajouterRequerantFlechTA(driver, i, loop);
			
			if(i == 1) { 
			// Urgence et Matière
			value = "15";
			urg1 = MicroFonctions.choixUrgence1(driver, value);
			}else {
				urg = MicroFonctions.choixUrgence(driver);
				}
			
			Thread.sleep(2000);
			value = "09";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			if(i == 1) {value = "03";
			mat1 = MicroFonctions.choixMatiere(driver, value);
			} else if(i==2 ) {
				value = "18";
				mat2 = MicroFonctions.choixMatiere(driver, value);
			}

			// Décision attaquée
			Thread.sleep(2000);
			auteur = "PREFECTURE DE PARIS";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtAuteurDecAtt']")).sendKeys(auteur);// Auteur
			ref = "22PA2156";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtReferenceDecAtt']")).sendKeys(ref);// Référence
			dateRecla = "11/05/2021";
			MesFonctions.echappe(driver);
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecRec']")).sendKeys(dateRecla);// Date de réclamation
			dateDec = "18/03/2020";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttTA']")).sendKeys(dateDec);// Date de décision
			MesFonctions.echappe(driver);
			
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
			charge = 8;//nombre de fichiers chargés
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
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(2000);
			
			// Vérification des fichiers téléchargés
			System.out.println("Vérification des fichiers en cours...");
			//Decision
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
			str.add(decAtt);	
			}else if(i==1) {
				fil.add(decAtt);
				}else if(i==2) {
					fil1.add(decAtt);
					}
			Thread.sleep(2000);
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(req);	
				}else if(i==1) {
					fil.add(req);
					}else if(i==2) {
						fil1.add(req);
						}
			Thread.sleep(2000);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			if(i==0) {
				str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
				}else if(i==1) {
					fil.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
					}else if(i==2) {
						fil1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}
			Thread.sleep(2000);
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(AJ);	
				}else if(i==1) {
					fil.add(AJ);
					}else if(i==2) {
						fil1.add(AJ);
						}
			Thread.sleep(2000);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(inventaire);	
				}else if(i==1) {
					fil.add(inventaire);
					}else if(i==2) {
						fil1.add(inventaire);
						}
			Thread.sleep(2000);
			
			if(i==0) {
				System.out.println(str);
				}else if(i==1) {
					System.out.println(fil);
					}else if(i==2) {
						System.out.println(fil1);
						}
			Thread.sleep(1000);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			nbr.clear();
			  
		}
			break;
		
		case "Cour":
			loop = 3;
		for(int i = 0; i < loop ; i++) {
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();

			//Ajouter un requérant
			MicroFonctions.ajouterRequerantFlechCAA(driver, i, loop);
			
			if(i == 1) { 
			// Urgence et Matière
			value = "2";
			urg1 = MicroFonctions.choixUrgence1(driver, value);
			}
			else {
				urg = MicroFonctions.choixUrgence(driver);
			}
			
			Thread.sleep(2000);
			value = "09";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(1000);
			value = "1";
			auteur = MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "22/06/2021";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(dateDec);// Date de décision
			MesFonctions.echappe(driver);
			
			value = "11027";
			juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);
			
			numero = "2100541";
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
			charge = 8;//nombre de fichiers chargés
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
			Thread.sleep(2000);

									// Vérification des fichiers téléchargés
			System.out.println("Vérification des fichiers en cours...");
			//Decision
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
			str.add(decAtt);	
			}else if(i==1) {
				fil.add(decAtt);
				}else if(i==2) {
					fil1.add(decAtt);
					}
			Thread.sleep(2000);
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(req);	
				}else if(i==1) {
					fil.add(req);
					}else if(i==2) {
						fil1.add(req);
						}
			Thread.sleep(2000);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			if(i==0) {
				str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
				}else if(i==1) {
					fil.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
					}else if(i==2) {
						fil1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}
			Thread.sleep(2000);
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(AJ);	
				}else if(i==1) {
					fil.add(AJ);
					}else if(i==2) {
						fil1.add(AJ);
						}
			Thread.sleep(2000);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(inventaire);	
				}else if(i==1) {
					fil.add(inventaire);
					}else if(i==2) {
						fil1.add(inventaire);
						}
			Thread.sleep(2000);
			
			if(i==0) {
				System.out.println(str);
				}else if(i==1) {
					System.out.println(fil);
					}else if(i==2) {
						System.out.println(fil1);
						}
			Thread.sleep(1000);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			nbr.clear();
			  
		}
			break;
			
		case "Conseil":
			loop = 3;
		for(int i = 0; i < loop ; i++) {
			//Préparer l'envoi d'une requête
			myXpath = "//input[@id='btNewRequete']";;
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();

			//Ajouter un requérant
			MicroFonctions.ajouterRequerantFlechCE(driver, i, loop);
			
			if(i == 1) { 
			// Urgence et Matière
			value = "2";
			urg1 = MicroFonctions.choixUrgence1(driver, value);
			}
			else {
				urg = MicroFonctions.choixUrgence(driver);
			}
			
			Thread.sleep(2000);
			value = "12";
			mat = MicroFonctions.choixMatiere(driver, value);
			
			// Décision attaquée
			Thread.sleep(1000);
			value = "10";
			auteur = MicroFonctions.choixSaisine(driver, value);
			
			dateDec = "22/06/2021";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(dateDec);// Date de décision
			MesFonctions.echappe(driver);
			
			value = "11074";
			juridiction = MicroFonctions.choixJuridiction(driver, value, choixJur);
			
			numero = "2100541";
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
			charge = 8;//nombre de fichiers chargés
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
			Thread.sleep(2000);
			
			// Vérification des fichiers téléchargés
			System.out.println("Vérification des fichiers en cours...");
			//Decision
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			decAtt = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
			str.add(decAtt);	
			}else if(i==1) {
				fil.add(decAtt);
				}else if(i==2) {
					fil1.add(decAtt);
					}
			Thread.sleep(2000);
			
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierRequete_hplFichier']";
			caractSpec = "_";
			req = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(req);	
				}else if(i==1) {
					fil.add(req);
					}else if(i==2) {
						fil1.add(req);
						}
			Thread.sleep(2000);
			
			//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPiecesJointe')]";
			caractSpec = "_";
			if(i==0) {
				str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
				}else if(i==1) {
					fil.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
					}else if(i==2) {
						fil1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}
			Thread.sleep(2000);
			
			//AJ
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			AJ = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(AJ);	
				}else if(i==1) {
					fil.add(AJ);
					}else if(i==2) {
						fil1.add(AJ);
						}
			Thread.sleep(2000);
				
			//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			inventaire = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(inventaire);	
				}else if(i==1) {
					fil.add(inventaire);
					}else if(i==2) {
						fil1.add(inventaire);
						}
			Thread.sleep(2000);
			
			if(i==0) {
				System.out.println(str);
				}else if(i==1) {
					System.out.println(fil);
					}else if(i==2) {
						System.out.println(fil1);
						}
			Thread.sleep(1000);
			
			// Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			nbr.clear();
			  
		}
			break;

		default: System.err.println("Aucune juridiction sélectionnée");
		break;
		
		}
		return null;
	}
	
	public static String reqEnreg (WebDriver driver, String choixJur, String env) throws Throwable {
		switch (choixJur) {
		case "Tribunal" :
			// Récupération du num de reqête
			Thread.sleep(2000);
			
			value = "3";
			dossier = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
			value = "2";
			dossier1 = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
			value = "1";
			dossier2 = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
		
			Thread.sleep(2000);
			// Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			int loop = 3;
			for(int i = 0; i < loop ; i++) {
				
				if(i==0) {
					identifiant = "cp";
					mdp = "cp";
						}else if (i==1) {
							identifiant = "cp2";
							mdp = "cp2";
							}else if  (i==2) {
								identifiant = "cp1";
								mdp = "cp1";
								}
			
			// Authentification
			driver.get("https://www.telerecours.recette.juradm.fr/TA75");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
						
			
			// Enregistrer le document
			if(i==0) {
			MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				}else if(i==1) {
				MicroFonctions.accesEnregReq(driver, choixJur, dossier1);
					}else if(i==2) {
						MicroFonctions.accesEnregReq(driver, choixJur, dossier2);
						}
			String avocat = MicroFonctions.formaterNomActeur(driver);
			
			
			// Rattachement
			MicroFonctions.rattachement(driver, verif, avocat);
			
			// vérification des informations transmises lors du dépôt
			if (i==1) {
				MicroFonctions.verifUrgence(driver, urg1);
				}else {
					MicroFonctions.verifUrgence(driver, urg);
						}
			
			if(i==0) {
				MicroFonctions.verifMatiere(driver, mat2);
				}else if(i==1) {
					MicroFonctions.verifMatiere(driver, mat1);
					}else if(i==2) {
						MicroFonctions.verifMatiere(driver, mat);
					}
				 
			driver.findElement(By.xpath("//input[@value ='" + auteur + "']"));
			System.out.println("trouvé : " + auteur);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + ref + "']"));
			System.out.println("trouvé : " + ref);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + dateRecla + "']"));
			System.out.println("trouvé : " + dateRecla);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + dateDec + "']"));
			System.out.println("trouvé : " + dateDec);

			Thread.sleep(1000);
			
			// Choix de la chambre
			ChbrMatCatTA = "chambre";
			if(i==0) {
				value ="41";
				MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
				}else if(i==1) {
					value ="1102";
					MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
					}else if(i==2) {
						value ="11";
						MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
					}
			Thread.sleep(1000);

			// Choix de la matière
			if(i==0) {
			ChbrMatCatTA = "matiere";
			value ="18";
			MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
			Thread.sleep(1000);
			}else if(i==1) {
					ChbrMatCatTA = "matiere";
					value ="03";
					MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
					Thread.sleep(1000);
				}else if(i==2) {
					ChbrMatCatTA = "matiere";
						value ="09";
						MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
						Thread.sleep(1000);
						}
			if(i==0) {	
			ChbrMatCatTA = "ssmatiere";
			value ="18010202";
			MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
			Thread.sleep(1000);
			}else if(i==1) {
				ChbrMatCatTA = "ssmatiere";
				value ="0302";
				MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
				Thread.sleep(1000);
				}else if(i==2) {
					ChbrMatCatTA = "ssmatiere";
					value ="0902";
					MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
					Thread.sleep(1000);
					}

			// Choix de la catégorie
			ChbrMatCatTA = "categorie";
			if(i==1) {
				value ="E14";
				MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
			}else {
					value ="NO";
					MicroFonctions.choixChbrMatCatTA(driver, ChbrMatCatTA, value);
				}

			Thread.sleep(1000);
			
			// Sauvegarde de la requête
			MicroFonctions.sauvReq(driver);
			
			// Retour sur la page d'enregistrement
			if(i==0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
			}else if(i==1) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier1 + "')]")).click();
				}else if(i==2) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier2 + "')]")).click();
					} 
			
			//Vérification fichiers 
			myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			String verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile1);	
				}else if(i==1) {
					fil2.add(verifFile1);
					}else if(i==2) {
						fil3.add(verifFile1);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile2);	
				}else if(i==1) {
					fil2.add(verifFile2);
					}else if(i==2) {
						fil3.add(verifFile2);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[contains(@id,'fileLinkFichierPJRequete_hplFichier')]";
			caractSpec = "_";
			if(i==0) {
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
				}else if(i==1) {
					fil2.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
					}else if(i==2) {
						fil3.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}
				Thread.sleep(2000);
		
			myXpath = "//a[@id='fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			String verifFile3 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile3);	
				}else if(i==1) {
					fil2.add(verifFile3);
					}else if(i==2) {
						fil3.add(verifFile3);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			String verifFile4 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile4);	
				}else if(i==1) {
					fil2.add(verifFile4);
					}else if(i==2) {
						fil3.add(verifFile4);
						}
				Thread.sleep(2000);
		if(i==0) {
			verif = str1.equals(str);
			if(!verif) {
				System.err.println("Les tableaux sont différents\rtableau actuel : "+str1+" \rtableau attendu :"+str);
			}
				}else if (i==1) {
						verif = fil.equals(fil2);
						if(!verif) {
							System.err.println("Les tableaux sont différents\rtableau actuel : "+fil+" \rtableau attendu :"+fil2);
						}
							}else if (i==2) {
								verif = fil1.equals(fil3);
									if(!verif) {
										System.err.println("Les tableaux sont différents\rtableau actuel : "+fil1+" \rtableau attendu :"+fil3);
									}
								}

			Thread.sleep(2000);
			
			//Enregistrement de la requête
			if(i==0) {
				requete = MicroFonctions.enrgReqFlech(driver);	
				}else if(i==1) {
					requete1 = MicroFonctions.enrgReqFlech(driver);	
					}else if(i==2) {
						requete2 = MicroFonctions.enrgReqFlech(driver);	
						}
			//réinitialisation des variables
			verif = false;
			}
			
			str1.clear();
		   	str.clear();
		   	fil.clear();
		   	fil1.clear();
		   	fil2.clear();
		   	fil3.clear();
			 
		   	System.out.println("Dépôt et enregistrement TA terminés");
		
		
		case "Cour" :
			// Récupération du num de reqête
			Thread.sleep(2000);
			
			value = "3";
			dossier = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
			value = "2";
			dossier1 = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
			value = "1";
			dossier2 = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
		
			Thread.sleep(2000);
	
			// Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			identifiant = "lb";
			mdp = "lb";
			
			// Authentification
			driver.get("https://www.telerecours.recette.juradm.fr/CA75");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
						
			loop = 3;
			for(int i = 0; i < loop ; i++) {
			
			// Enregistrer le document
			if(i==0) {
			MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				}else if(i==1) {
				MicroFonctions.accesEnregReq(driver, choixJur, dossier1);
					}else if(i==2) {
						MicroFonctions.accesEnregReq(driver, choixJur, dossier2);
						}
			String avocat = MicroFonctions.formaterNomActeur(driver);
			
			
			// Rattachement
			MicroFonctions.rattachement(driver, verif, avocat);
			
			// vérification des informations transmises lors du dépôt
			if (i==1) {
				MicroFonctions.verifUrgence(driver, urg1);
			}
			else {
				MicroFonctions.verifUrgence(driver, urg);
			}
			MicroFonctions.verifMatiere(driver, mat);
			
			driver.findElement(By.xpath("//input[@value ='" + auteur + "']"));
			System.out.println("trouvé : " + auteur);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + dateDec + "']"));
			System.out.println("trouvé : " + dateDec);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + juridiction + "']"));
			System.out.println("trouvé : " + juridiction);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + numero + "']"));
			System.out.println("trouvé : " + numero);

			Thread.sleep(1000);
			
			// Choix de la chambre
			ChbrMatCatCAA = "chambre";
			if(i==0) {
				value ="1";
				MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
				}else if(i==1) {
					value ="4";
					MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
					}else if(i==2) {
						value ="18";
						MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
					}
			Thread.sleep(1000);

			// Choix de la matière
			ChbrMatCatCAA = "matiere";
			value ="09";
			MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
			Thread.sleep(1000);
			
			ChbrMatCatCAA = "ssmatiere";
			value ="0906";
			MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
			Thread.sleep(1000);

			// Choix de la catégorie
			ChbrMatCatCAA = "categorie";
			if(i==1) {
				value ="CRF";
				MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
			}else {
					value ="NO";
					MicroFonctions.choixChbrMatCatCAA(driver, ChbrMatCatCAA, value);
				}
			
			Thread.sleep(1000);
			
			// Sauvegarde de la requête
			MicroFonctions.sauvReq(driver);
			
			// Retour sur la page d'enregistrement
			if(i==0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
			}else if(i==1) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier1 + "')]")).click();
				}else if(i==2) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier2 + "')]")).click();
					} 
			
			//Vérification fichiers 
			myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			String verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile1);	
				}else if(i==1) {
					fil2.add(verifFile1);
					}else if(i==2) {
						fil3.add(verifFile1);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierCourrier_hplFichier']";
			caractSpec = "_";
			String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile2);	
				}else if(i==1) {
					fil2.add(verifFile2);
					}else if(i==2) {
						fil3.add(verifFile2);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[contains(@id,'fileLinkFichierPJRequete_hplFichier')]";
			caractSpec = "_";
			if(i==0) {
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
				}else if(i==1) {
					fil2.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
					}else if(i==2) {
						fil3.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}
				Thread.sleep(2000);
		
			myXpath = "//a[@id='fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			String verifFile3 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile3);	
				}else if(i==1) {
					fil2.add(verifFile3);
					}else if(i==2) {
						fil3.add(verifFile3);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			String verifFile4 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile4);	
				}else if(i==1) {
					fil2.add(verifFile4);
					}else if(i==2) {
						fil3.add(verifFile4);
						}
				Thread.sleep(2000);
		if(i==0) {
			verif = str1.equals(str);
			if(!verif) {
				System.err.println("Les tableaux sont différents\rtableau actuel : "+str1+" \rtableau attendu :"+str);
			}
				}else if (i==1) {
						verif = fil.equals(fil2);
						if(!verif) {
							System.err.println("Les tableaux sont différents\rtableau actuel : "+fil+" \rtableau attendu :"+fil2);
						}
							}else if (i==2) {
								verif = fil1.equals(fil3);
									if(!verif) {
										System.err.println("Les tableaux sont différents\rtableau actuel : "+fil1+" \rtableau attendu :"+fil3);
									}
								}

			Thread.sleep(2000);
			
			//Enregistrement de la requête
			if(i==0) {
				requete = MicroFonctions.enrgReqFlech(driver);	
				}else if(i==1) {
					requete1 = MicroFonctions.enrgReqFlech(driver);	
					}else if(i==2) {
						requete2 = MicroFonctions.enrgReqFlech(driver);	
						}
			//réinitialisation des variables
			verif = false;
			}
			
			str1.clear();
		   	str.clear();
		   	fil.clear();
		   	fil1.clear();
		   	fil2.clear();
		   	fil3.clear();
			 
		   	System.out.println("Dépôt et enregistrement CAA terminés");
		   	
			break;
			
		case "Conseil" :
			// Récupération du num de reqête
			Thread.sleep(2000);
			
			value = "3";
			dossier = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
			value = "2";
			dossier1 = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
			value = "1";
			dossier2 = MicroFonctions.recupEnvoiNumReqTrFlch(driver, element, value);
		
			Thread.sleep(2000);
			
			// Déconnexion
			MicroFonctions.deconnexionTrExt(driver);
			
			identifiant = "fm";
			mdp = "fm";
			
			// Authentification
			driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
						
			loop = 3;
			for(int i = 0; i < loop ; i++) {
			
			// Enregistrer le document
			if(i==0) {
			MicroFonctions.accesEnregReq(driver, choixJur, dossier);
				}else if(i==1) {
				MicroFonctions.accesEnregReq(driver, choixJur, dossier1);
					}else if(i==2) {
						MicroFonctions.accesEnregReq(driver, choixJur, dossier2);
						}
			String avocat = MicroFonctions.formaterNomActeur(driver);
			
			
			// Rattachement
			MicroFonctions.rattachement(driver, verif, avocat);
			
			// vérification des informations transmises lors du dépôt
			if (i==1) {
				MicroFonctions.verifUrgence(driver, urg1);
			}
			else {
				MicroFonctions.verifUrgence(driver, urg);
			}
			MicroFonctions.verifMatiere(driver, mat);
			
			driver.findElement(By.xpath("//input[@value ='" + auteur + "']"));
			System.out.println("trouvé : " + auteur);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + dateDec + "']"));
			System.out.println("trouvé : " + dateDec);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value =\""+juridiction+"\"]"));
			System.out.println("trouvé : " + juridiction);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value ='" + numero + "']"));
			System.out.println("trouvé : " + numero);

			Thread.sleep(1000);
			
			// Choix de la chambre
			ChbrMatCatCTX = "chambre";
			if(i==0) {
				value ="1";
				MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
				}else if(i==1) {
					value ="7";
					MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
					}else if(i==2) {
						value ="3";
						MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
					}
			Thread.sleep(1000);

			// Choix de la matière
			ChbrMatCatCTX = "matiere";
			value ="12";
			MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
			Thread.sleep(1000);
			
			ChbrMatCatCTX = "ssmatiere";
			value ="1203";
			MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
			Thread.sleep(1000);

			// Choix de la catégorie
			ChbrMatCatCTX = "categorie";
			if(i==1) {
				value ="CR";
				MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
			}
				else {
					value ="CRC";
					MicroFonctions.choixChbrMatCatCTX(driver, ChbrMatCatCTX, value);
				}
		
			Thread.sleep(1000);
			
			// Sauvegarde de la requête
			MicroFonctions.sauvReq(driver);
			
			// Retour sur la page d'enregistrement
			if(i==0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
			}else if(i==1) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier1 + "')]")).click();
				}else if(i==2) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier2 + "')]")).click();
					} 
			
			//Vérification fichiers 
			myXpath = "//a[@id='fileLinkFichierDecAttq_hplFichier']";
			caractSpec = "_";
			String verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile1);	
				}else if(i==1) {
					fil2.add(verifFile1);
					}else if(i==2) {
						fil3.add(verifFile1);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierRequete_hplFichier']";
			caractSpec = "_";
			String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile2);	
				}else if(i==1) {
					fil2.add(verifFile2);
					}else if(i==2) {
						fil3.add(verifFile2);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[contains(@id,'fileLinkFichierPJRequete_hplFichier')]";
			caractSpec = "_";
			if(i==0) {
				str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
				}else if(i==1) {
					fil2.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
					}else if(i==2) {
						fil3.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}
				Thread.sleep(2000);
		
			myXpath = "//a[@id='fileLinkFichierAideJur_hplFichier']";
			caractSpec = "_";
			String verifFile3 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile3);	
				}else if(i==1) {
					fil2.add(verifFile3);
					}else if(i==2) {
						fil3.add(verifFile3);
						}
				Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			String verifFile4 = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str1.add(verifFile4);	
				}else if(i==1) {
					fil2.add(verifFile4);
					}else if(i==2) {
						fil3.add(verifFile4);
						}
				Thread.sleep(2000);
		if(i==0) {
			verif = str1.equals(str);
			if(!verif) {
				System.err.println("Les tableaux sont différents\rtableau actuel : "+str1+" \rtableau attendu :"+str);
			}
				}else if (i==1) {
						verif = fil.equals(fil2);
						if(!verif) {
							System.err.println("Les tableaux sont différents\rtableau actuel : "+fil+" \rtableau attendu :"+fil2);
						}
							}else if (i==2) {
								verif = fil1.equals(fil3);
									if(!verif) {
										System.err.println("Les tableaux sont différents\rtableau actuel : "+fil1+" \rtableau attendu :"+fil3);
									}
								}

			Thread.sleep(2000);
			
			//Enregistrement de la requête
			if(i==0) {
				requete = MicroFonctions.enrgReqFlech(driver);	
				}else if(i==1) {
					requete1 = MicroFonctions.enrgReqFlech(driver);	
					}else if(i==2) {
						requete2 = MicroFonctions.enrgReqFlech(driver);	
						}
			//réinitialisation des variables
			verif = false;
			}
			
			str1.clear();
		   	str.clear();
		   	fil.clear();
		   	fil1.clear();
		   	fil2.clear();
		   	fil3.clear();
			 
		   	System.out.println("Dépôt et enregistrement CE terminés");

		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		
		return null;	
	}
	
	public static String reqJurVer (WebDriver driver, String choixJur) throws Throwable {
		switch (choixJur) {
		case "Cour":

			// Déconnexion
			MicroFonctions.deconnexionTrInt(driver);
			
			int loop = 3;
			for(int i = 0; i < loop ; i++) {
				
				if(i==0) {
			identifiant = "cp1";
			mdp = "cp1";
				}else if (i==1) {
					identifiant = "cp2";
					mdp = "cp2";
					}else if  (i==2) {
						identifiant = "cp3";
						mdp = "cp3";
						}
			
			// Authentification
			driver.get("https://www.telerecours.recette.juradm.fr/CA75");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			Thread.sleep(2000);
			
			//Vérifier l'enregistrement de la requête
			if(i==0) {
				MicroFonctions.findReq(driver, requete);
				}else if(i==1) {
						MicroFonctions.findReq(driver, requete1);
						}else if(i==2) {
								MicroFonctions.findReq(driver, requete2);
								}
			
			
			// Déconnexion
			
			if(i<2) {
			driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
			Thread.sleep(2000);
			MicroFonctions.changeWindow(driver);
					}
			}
			break;
			
		case "Conseil":

			// Déconnexion
			MicroFonctions.deconnexionTrInt(driver);
			
			loop = 3;
			for(int i = 0; i < loop ; i++) {
				
				if(i==0) {
			identifiant = "jag";
			mdp = "jag";
				}else if (i==1) {
					identifiant = "jag1";
					mdp = "jag1";
					}else if  (i==2) {
						identifiant = "jag2";
						mdp = "jag2";
						}
			
			// Authentification
			driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			Thread.sleep(2000);
			
			//Vérifier l'enregistrement de la requête
			if(i==0) {
				MicroFonctions.findReq(driver, requete);
				}else if(i==1) {
						MicroFonctions.findReq(driver, requete1);
						}else if(i==2) {
								MicroFonctions.findReq(driver, requete2);
								}
			
			// Déconnexion
			
			if(i<2) {
			driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
			Thread.sleep(2000);
			MicroFonctions.changeWindow(driver);
					}
			}
			break;

		default: System.err.println("Aucune juridiction sélectionnée");
			break;
		}
		
		return null;
	}
}

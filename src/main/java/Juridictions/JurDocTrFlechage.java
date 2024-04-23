package Juridictions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurDocTrFlechage {
	
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
	static String nom;
	static String name;
	static String value;
	static String text;
	static String acteur;
	static String caractSpec;
	static String requerant;
	static String requerant1;
	static String requerant2;
	static int index;
	static String numDos;
	static int sum;
	static int charge;
	static String nomMem;
	static String nomInv;
	static String dossier;
	static String dossier1;
	static String dossier2;
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
				
				break;

			default: System.err.println("Aucune juridiction sélectionnée");
				break;
			}
		return null;
		
		}
		 public static String docDepotMem (WebDriver driver, String choixJur) throws Throwable {
		 switch (choixJur) {
		case "Tribunal":
			int loop = 3;
			for(int i = 0; i < loop ; i++) {
				if(i==0) {
					requerant = "Madame BONNAUD Delphine"; 
					}else if(i==1) {
						requerant1 = "Monsieur GARROUX Georges";
						}else if(i==2) {
							requerant2 = "Madame LECLERC Sonia"; 
							}
			
			//Recherche du dossier du requerant
				if(i==0) {
			numDos = MicroFonctions.searchDossierRequerant(driver, requerant);
				}else if(i==1) {
					numDos = MicroFonctions.searchDossierRequerant(driver, requerant1);
						}else if(i==2) {
							numDos = MicroFonctions.searchDossierRequerant(driver, requerant2);
								} 
			System.out.println("le dossier : "+numDos+" a été trouvé");
				
			//vérification du nom du requérant principal
			myXpath = "//input[@id='Mstr_cpMain_txtReqPrincip']";
			caractSpec = " ";
			index = 1 ;
			if(i==0) {
			name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant);
			Thread.sleep(2000);
				}else if(i==1) {
					name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant1);
					Thread.sleep(2000);
					}else if(i==2) {
						name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant2);
						Thread.sleep(2000);
						}
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
			charge = 5;//nombre de fichiers chargés
			MicroFonctions.nombreFichiersCharges(nbr, sum, charge);
			
			//Convertion des fichiers en PDF
			MicroFonctions.conversionPDF(driver);
			Thread.sleep(2000);	
			
			//Verification du fichier
			myXpath = "//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']";
			MicroFonctions.pdfVerfication(driver, myXpath);
			
			//Envoyer
			myXpath = "//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]";
			MesFonctions.objet(driver,  myXpath).click();// Vérification
			Thread.sleep(2000);
			
			//Vérification des fichiers téléchargés
				//mémoire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
			caractSpec = "_";
			nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(nomMem);	
				}else if(i==1) {
					fil.add(nomMem);
					}else if(i==2) {
						fil1.add(nomMem);
						}
			Thread.sleep(2000);
			
				//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
			caractSpec = "_";
			if(i==0) {
				str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
				}else if(i==1) {
					fil.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
					}else if(i==2) {
						fil1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}
				
				//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
			if(i==0) {
				str.add(nomInv);	
				}else if(i==1) {
					fil.add(nomInv);
					}else if(i==2) {
						fil1.add(nomInv);
						}
			Thread.sleep(2000);
			
			System.out.println(str);
			
			//Vérification succès envoi
			MicroFonctions.envoiDepotTr(driver);
			nbr.clear();
				if(i<2) {
				myXpath = "//td[@id='Entete1_MenuActeur1_im1_AA']";
				MesFonctions.objet(driver,  myXpath).click();
				}
			}
			break;
				
			case "Cour":
				loop = 3;
				for(int i = 0; i < loop ; i++) {
					if(i==0) {
						requerant = "Madame DUPUIS Ariette"; 
						}else if(i==1) {
							requerant1 = "Monsieur DELCOURT Fabrice";
							}else if(i==2) {
								requerant2 = "Madame VOLTAIRE Irène"; 
								}
				
				
				//Recherche du dossier du requerant
					if(i==0) {
				numDos = MicroFonctions.searchDossierRequerant(driver, requerant);
					}else if(i==1) {
						numDos = MicroFonctions.searchDossierRequerant(driver, requerant1);
							}else if(i==2) {
								numDos = MicroFonctions.searchDossierRequerant(driver, requerant2);
									} 
				System.out.println("le dossier : "+numDos+" a été trouvé");
					
				//vérification du nom du requérant principal
				myXpath = "//input[@id='Mstr_cpMain_txtReqPrincip']";
				caractSpec = " ";
				index = 1 ;
				if(i==0) {
				name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant);
				Thread.sleep(2000);
					}else if(i==1) {
						name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant1);
						Thread.sleep(2000);
						}else if(i==2) {
							name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant2);
							Thread.sleep(2000);
							}
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
				charge = 5;//nombre de fichiers chargés
				MicroFonctions.nombreFichiersCharges(nbr, sum, charge);
				
				//Convertion des fichiers en PDF
				MicroFonctions.conversionPDF(driver);
				Thread.sleep(2000);	
				
				//Verification du fichier
				myXpath = "//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']";
				MicroFonctions.pdfVerfication(driver, myXpath);
				
				//Envoyer
				myXpath = "//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]";
				MesFonctions.objet(driver,  myXpath).click();// Vérification
				Thread.sleep(2000);
				
				//Vérification des fichiers téléchargés
					//mémoire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
				if(i==0) {
					str.add(nomMem);	
					}else if(i==1) {
						fil.add(nomMem);
						}else if(i==2) {
							fil1.add(nomMem);
							}
				Thread.sleep(2000);
				
					//pieces complémentaires
				myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
				caractSpec = "_";
				if(i==0) {
					str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
					}else if(i==1) {
						fil.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}else if(i==2) {
							fil1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
							}
					
					//Inventaire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
				if(i==0) {
					str.add(nomInv);	
					}else if(i==1) {
						fil.add(nomInv);
						}else if(i==2) {
							fil1.add(nomInv);
							}
				Thread.sleep(2000);
				
				System.out.println(str);
				
				//Vérification succès envoi
				MicroFonctions.envoiDepotTr(driver);
				nbr.clear();
					if(i<2) {
					myXpath = "//td[@id='Entete1_MenuActeur1_im1_AA']";
					MesFonctions.objet(driver,  myXpath).click();
					}
				}
				break;
				
			case "Conseil":
				loop = 3;
				for(int i = 0; i < loop ; i++) {
					if(i==0) {
						requerant = "Mme Sandrine BOURGOIN"; 
						}else if(i==1) {
							requerant1 = "Mme Marie FAUDEL";
							}else if(i==2) {
								requerant2 = "Mme Aline QUERROT"; 
								}
				
				
				//Recherche du dossier du requerant
					if(i==0) {
				numDos = MicroFonctions.searchDossierRequerant(driver, requerant);
					}else if(i==1) {
						numDos = MicroFonctions.searchDossierRequerant(driver, requerant1);
							}else if(i==2) {
								numDos = MicroFonctions.searchDossierRequerant(driver, requerant2);
									} 
				System.out.println("le dossier : "+numDos+" a été trouvé");
					
				//vérification du nom du requérant principal
				myXpath = "//input[@id='Mstr_cpMain_txtReqPrincip']";
				caractSpec = " ";
				index = 1 ;
				if(i==0) {
				name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant);
				Thread.sleep(2000);
					}else if(i==1) {
						name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant1);
						Thread.sleep(2000);
						}else if(i==2) {
							name = MesFonctions.verifyPresenceOfAttribute(driver, myXpath, requerant2);
							Thread.sleep(2000);
							}
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
				charge = 5;//nombre de fichiers chargés
				MicroFonctions.nombreFichiersCharges(nbr, sum, charge);
				
				//Convertion des fichiers en PDF
				MicroFonctions.conversionPDF(driver);
				Thread.sleep(2000);	
				
				//Verification du fichier
				myXpath = "//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']";
				MicroFonctions.pdfVerfication(driver, myXpath);
				
				//Envoyer
				myXpath = "//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]";
				MesFonctions.objet(driver,  myXpath).click();// Vérification
				Thread.sleep(2000);
				
				//Vérification des fichiers téléchargés
					//mémoire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
				if(i==0) {
					str.add(nomMem);	
					}else if(i==1) {
						fil.add(nomMem);
						}else if(i==2) {
							fil1.add(nomMem);
							}
				Thread.sleep(2000);
				
					//pieces complémentaires
				myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
				caractSpec = "_";
				if(i==0) {
					str.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
					}else if(i==1) {
						fil.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
						}else if(i==2) {
							fil1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
							}
					
					//Inventaire
				myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
				if(i==0) {
					str.add(nomInv);	
					}else if(i==1) {
						fil.add(nomInv);
						}else if(i==2) {
							fil1.add(nomInv);
							}
				Thread.sleep(2000);
				
				System.out.println(str);
				
				//Vérification succès envoi
				MicroFonctions.envoiDepotTr(driver);
				nbr.clear();
					if(i<2) {
					myXpath = "//td[@id='Entete1_MenuActeur1_im1_AA']";
					MesFonctions.objet(driver,  myXpath).click();
						}
				}
				break;

			default: System.err.println("Aucune juridiction sélectionnée");
				break;
			}
			   return null;
		   }
		 
		 public static String docEnregMem (WebDriver driver, String choixJur) throws Throwable {
				
				switch (choixJur) {
				case "Tribunal" :
					// Récupération du num de reqête
					value = "3";
					dossier = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("/", " / ");
					value = "2";
					dossier1 = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("/", " / ");
					value = "1";
					dossier2 = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("/", " / ");
					Thread.sleep(2000);
					
					// Déconnexion
					MicroFonctions.deconnexionTrExt(driver);
					
					int loop = 3;
					for(int i = 0; i < loop ; i++) {
						
						if(i==0) {
							identifiant = "cp";
							mdp = "cp";
								}else if (i==1) {
									identifiant = "cp1";
									mdp = "cp1";
									}else if  (i==2) {
										identifiant = "cp2";
										mdp = "cp2";
										}
					
					
					// Authentification
					driver.get("https://www.telerecours.recette.juradm.fr/TA75");
					Thread.sleep(2000);
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
					
					// Enregistrer le document
					if(i==0) {
					acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier);
						}else if(i==1){
						acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier1);
								}else if(i==2){
							acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier2);
									}
					
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
					if(i==0) {
						str1.add(verifFile1);	
						}else if(i==1) {
							fil2.add(verifFile1);
							}else if(i==2) {
								fil3.add(verifFile1);
								}
					
					myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
					caractSpec = "_";
					if(i==0) {
						str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
						}else if(i==1) {
							fil2.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
							}else if(i==2) {
								fil3.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
								}
					Thread.sleep(2000);
					
					myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
					caractSpec = "_";
					String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
					if(i==0) {
						str1.add(verifFile2);	
						}else if(i==1) {
							fil2.add(verifFile2);
							}else if(i==2) {
								fil3.add(verifFile2);
								}
					
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
  
				   //Enregistrement du document 
				   Thread.sleep(1000);
				   MicroFonctions.enrgDoc(driver);
					}
				   Thread.sleep(2000);
				   str1.clear();
				   	str.clear();
				   	fil.clear();
				   	fil1.clear();
				   	fil2.clear();
				   	fil3.clear();
				   
				   System.out.println("Dépôt et enregistrement TA terminés");
				   break;
				   
				case "Cour" :
					// Récupération du num de reqête
					value = "3";
					dossier = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("/", " / ");
					value = "2";
					dossier1 = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("/", " / ");
					value = "1";
					dossier2 = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("/", " / ");
					Thread.sleep(2000);
					
					// Déconnexion
					MicroFonctions.deconnexionTrExt(driver);
					
					loop = 3;
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
					
					// Enregistrer le document
					if(i==0) {
						acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier);
							}else if(i==1){
							acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier1);
									}else if(i==2){
								acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier2);
										}
						
					// Rattachement
					if(i==0) {
						MicroFonctions.rattachement(driver, verif, acteur);
						};
					
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
					if(i==0) {
						str1.add(verifFile1);	
						}else if(i==1) {
							fil2.add(verifFile1);
							}else if(i==2) {
								fil3.add(verifFile1);
								}
					
					myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
					caractSpec = "_";
					if(i==0) {
						str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
						}else if(i==1) {
							fil2.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
							}else if(i==2) {
								fil3.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
								}
					Thread.sleep(2000);
					
					myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
					caractSpec = "_";
					String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
					if(i==0) {
						str1.add(verifFile2);	
						}else if(i==1) {
							fil2.add(verifFile2);
							}else if(i==2) {
								fil3.add(verifFile2);
								}
					
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
  
				   //Enregistrement du document 
				   Thread.sleep(1000);
				   MicroFonctions.enrgDoc(driver);
					}
				   Thread.sleep(2000);
				   str1.clear();
				   	str.clear();
				   	fil.clear();
				   	fil1.clear();
				   	fil2.clear();
				   	fil3.clear();
				   
				   System.out.println("Dépôt et enregistrement CA terminés");
				   break;
				   
				case "Conseil" :
					// Récupération du num de reqête
					value = "3"; 
					dossier = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("  /  ", " / ").trim();
					value = "2"; 
					dossier1 = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("  /  ", " / ").trim();
					value = "1"; 
					dossier2 = MicroFonctions.recupEnvoiNumDocTrFlch(driver, value).replace("  /  ", " / ").trim();
					Thread.sleep(2000);
					
					// Déconnexion
					MicroFonctions.deconnexionTrExt(driver);
					
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
					
					// Enregistrer le document
					if(i==0) {
						acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier);
							}else if(i==1){
							acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier1);
									}else if(i==2){
								acteur = MicroFonctions.accesEnrDoc(driver, choixJur, dossier2);
										}
						
					// Rattachement
					if(i==0) {
						MicroFonctions.rattachement(driver, verif, acteur);
						};
						
					
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
					if(i==0) {
						str1.add(verifFile1);	
						}else if(i==1) {
							fil2.add(verifFile1);
							}else if(i==2) {
								fil3.add(verifFile1);
								}
					
					myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
					caractSpec = "_";
					if(i==0) {
						str1.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));	
						}else if(i==1) {
							fil2.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
							}else if(i==2) {
								fil3.addAll(MesFonctions.fichier(driver, elements, myXpath, caractSpec));
								}
					Thread.sleep(2000);
					
					myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
					caractSpec = "_";
					String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
					if(i==0) {
						str1.add(verifFile2);	
						}else if(i==1) {
							fil2.add(verifFile2);
							}else if(i==2) {
								fil3.add(verifFile2);
								}
					
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
					   
				   //Enregistrement du document 
				   Thread.sleep(1000);
				   MicroFonctions.enrgDoc(driver);
					}
				   Thread.sleep(2000);
				   str1.clear();
				   	str.clear();
				   	fil.clear();
				   	fil1.clear();
				   	fil2.clear();
				   	fil3.clear();
				   
				   System.out.println("Dépôt et enregistrement CE terminés");
				   break;
				   
				default: System.err.println("Aucune juridiction sélectionnée");
				break;
			}
			   return null;
		   }
}

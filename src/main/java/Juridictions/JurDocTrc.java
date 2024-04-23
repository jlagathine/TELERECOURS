package Juridictions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class JurDocTrc {
	
	static String myXpath;
	static String myXpath0;
	static String myXpath1; 
	static String myXpath2; 
	static String myXpath3;
	static String myXpath4;
	static String myXpath5;
	static String myXpath6;
	static String myXpath60;
	static String myXpath7;
	static String myXpath70;
	static String myXpath8;
	static String myXpath80;
	static String myXpath9;
	static String myXpath90;
	static String myXpath10;
	static String myXpath11; 
	static String identifiant;
	static String caractSpec;
	static String email;
	static String password;
	static String mdp;
	static String nom;
	static String texte;
	static String acteur;
	static List<WebElement> elements;
	static List<String> str;
	static List<String> str1 = new ArrayList<>();
	
	
	public static String authentification (WebDriver driver, String monUrl, String mail) throws Throwable {
		
		//Choix de l'environnement
		switch (monUrl) {
		case "int1": 
			String url = "https://citoyens.int1.telerecours.fr/";
			driver.get(url);
			Thread.sleep(200);
			System.out.println("Accès page "+driver.getCurrentUrl());
//			mail = "zaire@yopmail.com";
			password = "Lhommeest2019*";
			System.out.println("Connexion réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "rec": 
			url = "https://citoyens.recette.telerecours.fr/";
			driver.get(url);
			Thread.sleep(200);
			System.out.println("Accès page "+driver.getCurrentUrl());
//			mail = "sorin@yopmail.com";
			password = "Lhommeest2019*";
			System.out.println("Connexion réussie......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		default: System.err.println("Pas d'environnement a ce nom......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
			//Authentification
			myXpath = "//input[@id='username']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(5));
			MicroFonctions.AuthentificationTrc(driver, mail, password);
			Thread.sleep(200);
		
		return null;
	}
	
	
	
	public static String docDepotMem (WebDriver driver, boolean verif, String dossier, String jur) throws Throwable {
 		myXpath = "//cdk-row//span[text()='"+dossier+"']//ancestor::cdk-cell//following-sibling::cdk-cell//span[@class='fa fa-eye']";

 		int nbr = driver.findElements(By.xpath(myXpath)).size();
 		System.out.println("Le nombre de dossier portant le numéro "+dossier+" est égale à : "+nbr);
 		
 		myXpath0 = "(//cdk-row//span[text()='"+dossier+"']//ancestor::cdk-cell//following-sibling::cdk-cell//span[@class='fa fa-eye'])["+nbr+"]";
 		myXpath1 = "//h1[contains(text(),\"Historique\")]"; //"//div[@class='titre-timeline']//jhi-abbreviate//span";
 		//String myXpath2 = "//jhi-abbreviate//span[contains(text(),'"+choix+"')]";
 		if(jur=="TA") {
 			myXpath2 = "//jhi-abbreviate//span[text()[contains(.,'Tribunal')]]";
 		}else if(jur=="CAA") {
 			myXpath2 = "//jhi-abbreviate//span[text()[contains(.,'Cour')]]";
 		}else {
 			myXpath2 = "//jhi-abbreviate//span[text()[contains(.,'Conseil')]]";
 		}
 		
 		myXpath3 = "//div[@class='btn btn-primary']";
 		myXpath4 = "//span[text()=\"Accueil\"]";
 		myXpath5 = "//jhi-file-uploader[@inputname='memoire']//input[@type='file']";
 		myXpath6 = "//jhi-file-uploader[@inputname='piece-adder']//input[@type='file']";
 		myXpath60 = "//div[@class='form-group required name']//label[(contains(text(),'Nommer la pièce n°1'))]//following-sibling::div/input";
 		myXpath7 = "//div[@class='form-group']/label[text()=\"Pièce complémentaire n°2\"]//parent::div//div/input[2]";
 		myXpath70 = "//div[@class='form-group required name']//label[(contains(text(),'Nommer la pièce n°2'))]//following-sibling::div/input";
 		myXpath8 = "//div[@class='form-group']/label[text()=\"Pièce complémentaire n°3\"]//parent::div//div/input[2]";
 		myXpath80 = "//div[@class='form-group required name']//label[(contains(text(),'Nommer la pièce n°3'))]//following-sibling::div/input";
 		myXpath9 = "//div[@class='form-group']/label[text()=\"Pièce complémentaire n°4\"]//parent::div//div/input[2]";
 		myXpath90 = "//div[@class='form-group required name']//label[(contains(text(),'Nommer la pièce n°4'))]//following-sibling::div/input";
 		myXpath10 = "//input[@id='conditionRenommage']//following-sibling::label";
 		myXpath11 = "//button[@type='button']//span[contains(text(),'Envoyer les documents complémentaires')]";
 		
 		switch (jur) {
		case "TA":
			
			if(driver.findElements(By.xpath(myXpath)).size() > 1) {
	 			MesFonctions.objet(driver,  myXpath).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
	 			
	 			if(MesFonctions.isElementPresent(driver, myXpath2, verif) == true) {
	 			System.out.println(MesFonctions.objet(driver,  myXpath2).getText().trim());
	 				MesFonctions.objet(driver,  myXpath3).click();
	 			}
	 			else {
 				MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
 				MesFonctions.objet(driver,  myXpath4).click();
 				
 				MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath0).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
	 			System.out.println(MesFonctions.objet(driver,  myXpath2).getText().trim());
	 			
	 			MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath3).click();
	 			}	
	 		}
	 		else {
	 			MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath4).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));;
	 			MesFonctions.objet(driver,  myXpath0).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
	 			System.out.println(MesFonctions.objet(driver,  myXpath2).getText().trim());
	 			
	 			MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath3).click();
	 		}
	 		
	 		Thread.sleep(300);
	 		
	 		//le mémoire
	 		MesFonctions.objet(driver,  myXpath5).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
	 		Thread.sleep(200);
	 		System.out.println("Insertion d'une pièce : Mémoire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		//pièces complémentaires
	 		
	 		MicroFonctions.depotMemCompDebray(driver);
	 		
//	 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  mesFonctions.objet(driver,  myXpath6));
//	 		Thread.sleep(1000);
//	 		mesFonctions.objet(driver,  myXpath6).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 1998 - 2012.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 1
//		 		mesFonctions.objet(driver,  myXpath60).sendKeys("pièce complémentaire 1");
//		 		Thread.sleep(1000);
//		 		
//	 		mesFonctions.objet(driver,  myXpath7).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 2
//		 		mesFonctions.objet(driver,  myXpath70).sendKeys("pièce complémentaire 2");
//		 		Thread.sleep(1000);	
//		 		
//	 		mesFonctions.objet(driver,  myXpath8).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 1.docx");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 3
//		 		mesFonctions.objet(driver,  myXpath80).sendKeys("pièce complémentaire 3");
//		 		Thread.sleep(1300);
//			 		
//	 		mesFonctions.objet(driver,  myXpath9).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 4
//		 		mesFonctions.objet(driver,  myXpath90).sendKeys("pièce complémentaire 4");
//		 		Thread.sleep(1000);
			 		
	 		//Cocher la case de vérification
//	 		mesFonctions.waiting2(driver, myXpath10, Duration.ofSeconds(3));
//	 		mesFonctions.goToDown(driver, myXpath10);
//		 	mesFonctions.objet(driver,  myXpath10).click();
//		 	
//		 	System.out.println("Vérification réalisée......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//			 	
//		 	//Valider (suivant)
//		 	mesFonctions.waiting2(driver, myXpath11, Duration.ofSeconds(3));
//		 	mesFonctions.goToDown(driver, myXpath11);
//			mesFonctions.objet(driver,  myXpath11).click();
//			
//			System.out.println("Tous les fichiers ont été chargés....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "CAA":
			
			if(driver.findElements(By.xpath(myXpath)).size() > 1) {
	 			MesFonctions.objet(driver,  myXpath).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
	 			
	 			if(MesFonctions.isElementPresent(driver, myXpath2, verif) == true) {
	 			System.out.println(MesFonctions.objet(driver,  myXpath2).getText().trim());
	 				MesFonctions.objet(driver,  myXpath3).click();
	 			}
	 			else {
 				MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
 				MesFonctions.objet(driver,  myXpath4).click();
 				
 				MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath0).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
	 			System.out.println(MesFonctions.objet(driver,  myXpath2).getText().trim());
	 			
	 			MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath3).click();
	 			}	
	 		}
	 		else {
	 			MesFonctions.waiting2(driver, myXpath4, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath4).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));;
	 			MesFonctions.objet(driver,  myXpath0).click();
	 			
	 			MesFonctions.waiting2(driver, myXpath2, Duration.ofSeconds(3));
	 			System.out.println(MesFonctions.objet(driver,  myXpath2).getText().trim());
	 			
	 			MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
	 			MesFonctions.objet(driver,  myXpath3).click();
	 		}
	 		
	 		Thread.sleep(300);
	 		
	 		//le mémoire
	 		MesFonctions.objet(driver,  myXpath5).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
	 		Thread.sleep(1200);
	 		System.out.println("Insertion d'une pièce : Mémoire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		//pièces complémentaires
	 		MicroFonctions.depotMemCompDebray(driver);
	 		
//	 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  mesFonctions.objet(driver,  myXpath6));
//	 		Thread.sleep(1000);
//	 		mesFonctions.objet(driver,  myXpath6).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 1998 - 2012.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 1
//		 		mesFonctions.objet(driver,  myXpath60).sendKeys("pièce complémentaire 1");
//		 		Thread.sleep(1000);
//		 		
//	 		mesFonctions.objet(driver,  myXpath7).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 2
//		 		mesFonctions.objet(driver,  myXpath70).sendKeys("pièce complémentaire 2");
//		 		Thread.sleep(1000);	
//		 		
//	 		mesFonctions.objet(driver,  myXpath8).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 1.docx");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 3
//		 		mesFonctions.objet(driver,  myXpath80).sendKeys("pièce complémentaire 3");
//		 		Thread.sleep(1300);
//			 		
//	 		mesFonctions.objet(driver,  myXpath9).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 4
//		 		mesFonctions.objet(driver,  myXpath90).sendKeys("pièce complémentaire 4");
//		 		Thread.sleep(1000);
			 		
	 		//Cocher la case de vérification
//	 		mesFonctions.waiting2(driver, myXpath10, Duration.ofSeconds(3));
//	 		mesFonctions.goToDown(driver, myXpath10);
//		 	mesFonctions.objet(driver,  myXpath10).click();
//		 	
//		 	System.out.println("Vérification réalisée......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//			 	
//		 	//Valider (suivant)
//		 	mesFonctions.waiting2(driver, myXpath11, Duration.ofSeconds(3));
//		 	mesFonctions.goToDown(driver, myXpath11);
//			mesFonctions.objet(driver,  myXpath11).click();
//			
//			System.out.println("Tous les fichiers ont été chargés....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
	 		
			break;
			
		case "CTX":
			
 			MesFonctions.objet(driver,  myXpath).click();
 			Thread.sleep(300);
 			
 			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
 			System.out.println(MesFonctions.objet(driver, myXpath2).getText().trim());
 			MesFonctions.objet(driver,  myXpath3).click();
	
	 		Thread.sleep(300);
	 		
	 		//le mémoire
	 		MesFonctions.objet(driver,  myXpath5).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
	 		Thread.sleep(200);
	 		System.out.println("Insertion d'une pièce : Mémoire......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	 		
	 		//pièces complémentaires
	 		MicroFonctions.depotMemCompDebray(driver);
	 		
//	 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  mesFonctions.objet(driver,  myXpath6));
//	 		Thread.sleep(1000);
//	 		mesFonctions.objet(driver,  myXpath6).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 1998 - 2012.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 1
//		 		mesFonctions.objet(driver,  myXpath60).sendKeys("pièce complémentaire 1");
//		 		Thread.sleep(1000);
//		 		
//	 		mesFonctions.objet(driver,  myXpath7).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 2
//		 		mesFonctions.objet(driver,  myXpath70).sendKeys("pièce complémentaire 2");
//		 		Thread.sleep(1000);	
//		 		
//	 		mesFonctions.objet(driver,  myXpath8).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 1.docx");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 3
//		 		mesFonctions.objet(driver,  myXpath80).sendKeys("pièce complémentaire 3");
//		 		Thread.sleep(1300);
//			 		
//	 		mesFonctions.objet(driver,  myXpath9).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
//	 		Thread.sleep(1200);
//	 		System.out.println("Insertion d'une pièce complémentaire......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//	 		
//	 			//nom de la pièce 4
//		 		mesFonctions.objet(driver,  myXpath90).sendKeys("pièce complémentaire 4");
//		 		Thread.sleep(1000);
			 		
	 		//Cocher la case de vérification
//	 		mesFonctions.waiting2(driver, myXpath10, Duration.ofSeconds(3));
//	 		mesFonctions.goToDown(driver, myXpath10);
//		 	mesFonctions.objet(driver,  myXpath10).click();
//		 	
//		 	System.out.println("Vérification réalisée......"+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
//			 	
//		 	//Valider (suivant)
//		 	mesFonctions.waiting2(driver, myXpath11, Duration.ofSeconds(3));
//		 	mesFonctions.goToDown(driver, myXpath11);
//			mesFonctions.objet(driver,  myXpath11).click();
//			
//			System.out.println("Tous les fichiers ont été chargés....."+mesFonctions.extractCurrentDate()+" à "+mesFonctions.extractCurrentHeure()+"\r");
	 		
			break;

		default: System.err.println("AUCUNE OPTION A CE NOM......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
		}
 				return null;
 	}
 	
		public static String docEnregTrc (WebDriver driver, String dossier, String choixJur) throws Throwable {
			switch (choixJur) {
			case "TA" :
				
				
				
				// Récupération du num du document et des noms des fichiers
				myXpath = "(//jhi-timeline-element)[1]//child::button//parent::a/span";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				
				str = MesFonctions.nbrEtNomsObjetBrut(driver, myXpath);
				 Thread.sleep(100);
				 System.out.println(str);
				 driver.findElement(By.xpath("//span[text()=\"Déconnexion\"]")).click();
				
				Thread.sleep(200);
				
				String TrUrl = "https://www.telerecours.recette.juradm.fr/TA75";
				String TrUrlInt = "https://www.telerecours.int1.juradm.fr/TA75"; 
				String currentUrl = "int1";
			   //Authentification TA
						
				boolean verif = driver.getCurrentUrl().contains(currentUrl);
				if(verif) {
					driver.get(TrUrlInt);
					identifiant = "sice";
					mdp = "sice";
					myXpath = "//input[@id='txtIdentifiant']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
					System.out.println("Connexion TA réussi....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}else {
					driver.get(TrUrl);
					identifiant = "lb";
					mdp = "lb";
					myXpath = "//input[@id='txtIdentifiant']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
					MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
					System.out.println("Connexion TA réussi....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
				
				
				// Enregistrer le document
				myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.verifyPresenceOfElement(driver, myXpath, choixJur);
				System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
				
				myXpath = "//a[@class='numDossier' and (contains(text(),'" + dossier + "'))]";
				driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
				System.out.println("Accès à l'onglet \"Document\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				driver.findElement(By.xpath("//a[@class='numDossier' and (contains(text(),'" + dossier + "'))]")).click();
				
				myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
				//nom = mesFonctions.objet(driver,  myXpath).getText();
				acteur = MesFonctions.leTexte(driver, texte, myXpath).replace("*", "").trim();
				System.out.println("Auteur du dépôt : "+acteur+"\r");
				Thread.sleep(300);
				
				//Vérification fichiers 
				System.out.println("vérification des fichiers en cours......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				myXpath = "//a[contains(@class,'hplGenFichier2') and contains(@id,'rptPiecesDocument')]";
				elements = driver.findElements(By.xpath(myXpath));
				caractSpec = "_";
				  int taille = elements.size();
				   for(int i=1; i<=taille; i++) {
			   	myXpath = "//a[contains(@class,'hplGenFichier2') and contains(@id,'"+i+"')]";
			   	String file = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
				str1.add(file);
				Thread.sleep(300);
					}
				   
			   myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				//nom = mesFonctions.objet(driver,  myXpath).getText();
				String verifFile1 = MesFonctions.leNom(driver, myXpath, caractSpec).replace("_", " ").trim();
				str1.add(verifFile1);
				Thread.sleep(200);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				 String invPcs = MesFonctions.leNom(driver, myXpath, caractSpec);
				   Thread.sleep(200);
				   
				   str1.add(invPcs);
				   Thread.sleep(200);
				   
				   if(str1.equals(str)) {
					   System.out.println("Tous les fichiers sont présents....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   }
				   else {
					   System.err.println("Les tableaux sont différents tableau actuel : "+str1+" \rtableau attendu :"+str+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
				   }
				   
				   //Enregistrement du document 
				   Thread.sleep(100);
				   MicroFonctions.enrgDoc(driver);
				   
				   Thread.sleep(000);
				   str1.clear();
				   str.clear();
				   
				   System.out.println("Dépôt et enregistrement TRC TA terminés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r"); 
   
				break;
				
				case "CAA" :
				
				
				// Récupération du num de requête et des noms des fichiers
				myXpath = "(//jhi-timeline-element)[1]//child::button//parent::a/span";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				
				str = MesFonctions.nbrEtNomsObjetBrut(driver, myXpath);
				 Thread.sleep(1000);
				 System.out.println(str);
				 driver.findElement(By.xpath("//span[text()=\"Déconnexion\"]")).click();
				
				Thread.sleep(2000);
				
				TrUrl = "https://www.telerecours.recette.juradm.fr/CA75";
				TrUrlInt = "https://www.telerecours.int1.juradm.fr/CA75"; 
				currentUrl = "int1";
				//Authentification CAA
				verif = driver.getCurrentUrl().contains(currentUrl);
					if(verif) {
						driver.get(TrUrlInt);
						identifiant = "sice";
						mdp = "sice";
						myXpath = "//input[@id='txtIdentifiant']";
						MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
						MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
						System.out.println("Connexion CA réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						
					}else {
						driver.get(TrUrl);
						identifiant = "lb";
						mdp = "lb";
						myXpath = "//input[@id='txtIdentifiant']";
						MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
						MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
						System.out.println("Connexion CA réussi......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
						
					}
					
				
				// Enregistrer le document
				myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.verifyPresenceOfElement(driver, myXpath, choixJur);
				System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
				
				myXpath = "//a[@class='numDossier' and (contains(text(),'" + dossier + "'))]";
				driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
				System.out.println("Accès à l'onglet \"Document\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				driver.findElement(By.xpath("//a[@class='numDossier' and (contains(text(),'" + dossier + "'))]")).click();
				
				
				myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
				//nom = mesFonctions.objet(driver,  myXpath).getText();
				acteur = MesFonctions.leTexte(driver, texte, myXpath).replace("*", "").trim();
				System.out.println("Auteur du dépôt : "+acteur+"\r");
				Thread.sleep(1000);
				
				//Vérification fichiers 
				System.out.println("Vérification des fichiers en cours......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				myXpath = "//a[contains(@id,'rptPiecesDocument_ctl0')]";
				elements = driver.findElements(By.xpath(myXpath));
				caractSpec = "_";
				int taille1 = elements.size();
				   for(int i=1; i<=taille1; i++) {
			   	myXpath = "//a[contains(@id,'rptPiecesDocument_ctl0"+i+"')]";
			   	String file = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
				str1.add(file);
				Thread.sleep(1000);
					}
				   
			   myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
				caractSpec = "_";
				String memoire = MesFonctions.leNom(driver, myXpath, caractSpec).replace("_", " ").trim();
				str1.add(memoire);
				Thread.sleep(1000);
				
				myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
				caractSpec = "_";
				 String invPcs1 = MesFonctions.leNom(driver, myXpath, caractSpec);
				   Thread.sleep(1000);
				   
				   str1.add(invPcs1);
				   Thread.sleep(1000);
				   
				   if(str1.equals(str)) {
					   System.out.println("Tous les fichiers sont présents....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   }
				   else {
					   System.err.println("Les tableaux sont différents tableau actuel : "+str1+" \rtableau attendu :"+str+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   }
				   
				   //Enregistrement de la requête 
				   Thread.sleep(1000);
				   MicroFonctions.enrgDoc(driver);
				   
				   Thread.sleep(2000);
				   str1.clear();
				   str.clear();
				   
				   System.out.println("Dépôt et enregistrement TRC CA terminés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r"); 

				   
				break;
				
				case "CTX" :
					
					// Récupération du num de requête et des noms des fichiers
					myXpath = "(//jhi-timeline-element)[1]//child::button//parent::a/span";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					
					str = MesFonctions.nbrEtNomsObjetBrut(driver, myXpath);
					 Thread.sleep(1000);
					 System.out.println(str);
					 driver.findElement(By.xpath("//span[text()=\"Déconnexion\"]")).click();
					
					Thread.sleep(2000);
					
					TrUrl = "https://www.telerecours.recette.conseil-etat.fr/conseil";
					TrUrlInt = "https://www.telerecours.int1.conseil-etat.fr/conseil"; 
					currentUrl = "int1";
				   //Authentification CE
					verif = driver.getCurrentUrl().contains(currentUrl);
					if(verif) {
						driver.get(TrUrlInt);
						identifiant = "sice";
						mdp = "sice";
						myXpath = "//input[@id='txtIdentifiant']";
						MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
						MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
						System.out.println("Connexion CE réussi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					}else {
						driver.get(TrUrl);
						identifiant = "fm";
						mdp = "fm";
						myXpath = "//input[@id='txtIdentifiant']";
						MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(10));
						MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
						System.out.println("Connexion CE réussi......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					}
					
					
					// Enregistrer le document
					myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					MesFonctions.verifyPresenceOfElement(driver, myXpath, choixJur);
					System.out.println(MesFonctions.objet(driver,  myXpath).getText().trim());
					
					myXpath = "//a[@class='numDossier' and (contains(text(),'" + dossier + "'))]";
					driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
					System.out.println("Accès à l'onglet \"Document\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
					driver.findElement(By.xpath("//a[@class='numDossier' and (contains(text(),'" + dossier + "'))]")).click();
					
					myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
					//nom = mesFonctions.objet(driver,  myXpath).getText();
					acteur = MesFonctions.leTexte(driver, texte, myXpath).replace("*", "").trim();
					System.out.println("Auteur du dépôt : "+acteur+"\r");
					Thread.sleep(1000);
					
					//Vérification fichiers 
					System.out.println("vérification des fichiers en cours....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					
					myXpath = "//a[contains(@id,'rptPiecesDocument_ctl0')]";
					elements = driver.findElements(By.xpath(myXpath));
					caractSpec = "_";
					int taille2 = elements.size();
					   for(int i=1; i<=taille2; i++) {
				   	myXpath = "//a[contains(@id,'rptPiecesDocument_ctl0"+i+"')]";
				   	String file = (MesFonctions.leNom(driver, myXpath, caractSpec)).replace("_", " ").trim();
					str1.add(file);
					Thread.sleep(1000);
						}
					   
				   myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
					caractSpec = "_";
					String memoire1 = MesFonctions.leNom(driver, myXpath, caractSpec).replace("_", " ").trim();
					str1.add(memoire1);
					Thread.sleep(1000);
					
					myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
					caractSpec = "_";
					 String invPcs2 = MesFonctions.leNom(driver, myXpath, caractSpec);
					   Thread.sleep(1000);
					   
					   str1.add(invPcs2);
					   Thread.sleep(1000);
					   
					   if(str1.equals(str)) {
						   System.out.println("Tous les fichiers sont présents......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					   }
					   else {
						   System.err.println("Les tableaux sont différents tableau actuel : "+str1+" \rtableau attendu :"+str+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
					   }
					   
					   //Enregistrement du document 
					   Thread.sleep(1000);
					   MicroFonctions.enrgDoc(driver);
					   
					   Thread.sleep(2000);
					   str1.clear();
					   str.clear();
					   
					   System.out.println("Dépôt et enregistrement TRC CE terminés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r"); 

					break;

			default:System.err.println("Aucune option correspondante");
				break;
			}
			
			return null;
		}
		
		public static String verification_Mail_Depot_Doc_TRC(WebDriver driver, String mail, String env) throws Throwable {
			//Vérification des mail
			MesFonctions.addTab(driver);
			MesFonctions.transitWindow(driver, 2);
			MicroFonctions.mailDepotDoc(driver, mail, env);
			
			return null;
		}
		
		public static String verification_Mail_Enreg_Doc_TRC(WebDriver driver, String mail, String env) throws Throwable {
			//Vérification des mail
			MesFonctions.addTab(driver);
	 		MesFonctions.transitWindow(driver, 2);
	 		MicroFonctions.mailEnregDoc(driver, mail, env);
			
			return null;
		}
}

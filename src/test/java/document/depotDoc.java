package document;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class depotDoc {
	
		   public WebDriver driver;
		   DesiredCapabilities caps;
		 
	
	@BeforeSuite
		public void InitialisationDoc () {
		String browserName = "firefox";
		
		switch (browserName) {
		case "chrome":
			caps = new DesiredCapabilities();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Driver\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.merge(caps);
			options.addArguments("--start-maximized");
			options.addArguments("--disable-popup-blocking");
			
			
			driver = new ChromeDriver(options);
			System.out.println("Initialisation réussie");
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Driver\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			System.out.println("Initialisation réussie");
			
			break;

		default:
			System.err.println("DRIVER ISSUE");
			break;
		}
				
	}
	//Variables déclarées 
		public String myXpath ;
		WebElement element;
		List<WebElement> elements;
		String value; 
		Set<String> tabs ;
		Iterator<String> it;
		String nom;
		String caractSpec;
		boolean verif ;
		Alert alert;
		String acteur;
		boolean boolSearch ;
		String lesFiles;
		String identifiant;
		String mdp;
		Select select;
		
		
		
		
		
	@BeforeMethod
	public void choixSiteTACAA() throws InterruptedException {
		
		driver.get("https://www.telerecours.recette.juradm.fr/");
		Thread.sleep(2000);
		System.out.println("Connection réussie");
		
	}
		
	@Test
	public void depoDoctCAA() throws Throwable {
		identifiant = "amaz4qk";
		mdp = "Lhommeest2019*";

		// Authentification
		MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, mdp);
		

		// Choix de la juridiction
		System.out.println("Authentification réussie");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='CAA Paris']")).click();
		System.out.println("Choix de juridiction CAA");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AD']")).click();
		Thread.sleep(1000);
		
		//Préparer l'envoi d'un document
		driver.findElement(By.xpath("//a[@id='btnDeposerDocument']")).click();
		Thread.sleep(2000);
			
			//choix du dossier
			String dossier = "2200653";
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumsaisi']")).sendKeys(dossier);
			driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btnRechercherDossier']")).click();
			Thread.sleep(1000);
			String verificat = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumDossier']")).getAttribute("value");
			boolean verif1 = verificat.equals(dossier);
			if (verif1 == false) {
				throw new Exception ("ERREUR SUR LE DOSSIER !!!");
			}
			System.out.println("Le dossier de dépôt est le : "+ verificat);
			
			
			//Type de Document
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_rbPj_0']")).click();
			Thread.sleep(1000);
			String text = "Ce dépôt doit être pris en compte dans les plus brefs délais.\nCordialement,\nMaître AMAR";
			driver.findElement(By.xpath("//textarea[@id='Mstr_cpMain_txtMessage']")).sendKeys(text);
			Thread.sleep(1000);
			String doc = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_rbPj_0']//following-sibling::label")).getText();
			System.out.println("Document : "+doc);
			
			//type de mémoire
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeDocument']";
			value = "RECMEM"; 
			MesFonctions.selection(driver, myXpath, value);
			Thread.sleep(3000);
			String typeMem = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlTypeDocument']//option[@value='"+value+"']")).getText();//la valeur selected n'et pas définie sur le bon attribut(value)
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadFichierMemoire_fileUpload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 1.docx");
			Thread.sleep(1000);
			int nbrMem = driver.findElements(By.xpath("//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']")).size();
			System.out.println("Nombre de fichier(s) mémoire, chargé(s) : "+nbrMem);
			System.out.println("Type de mémoire choisi : "+ typeMem);
			
			//type de pièces
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 1.docx" );
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 2.docx");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 3.docx"); 
			Thread.sleep(1000);
			int nbrPc = driver.findElements(By.xpath("//a[contains(@id,'fileLinkFichierPiecesMemoire_hplFichier')]")).size();
			System.out.println("Nombre de pièces complémentaires : "+ nbrPc);
			Thread.sleep(1000);
			
			//Inventaire
			myXpath = "//input[@id='Mstr_cpMain_FileUploadInventairePieces_fileUpload']";
			MesFonctions.objet(driver, myXpath);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadInventairePieces_fileUpload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Inventaire.pdf");
			Thread.sleep(1000);
			int nbrInv = driver.findElements(By.xpath("//a[(@id='Mstr_cpMain_FileUploadInventairePieces_DlFileLink_hplFichier')]")).size();
			System.out.println("Nombre de fichier(s) inventaire, chargé(s) : "+ nbrInv);
			Thread.sleep(2000);
			
			//Convertion des fichiers en PDF
			myXpath = "//a[@id='Mstr_cpMain_zonePDF_btConvertir']";
			MesFonctions.objet(driver, myXpath );
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='Mstr_cpMain_zonePDF_btConvertir']")).click();
			alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(4000);
			
			//Verification du fichier
			driver.findElement(By.xpath("//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']")).click();
			
			driver.switchTo().window(MesFonctions.childWindow(driver));
			Thread.sleep(5000);
			driver.close();
			Thread.sleep(1000);
			driver.switchTo().window(MesFonctions.parentWindow(driver));
			Thread.sleep(1000);
		
			myXpath ="//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']";
			MesFonctions.objet(driver, myXpath);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
			driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).click();
			Thread.sleep(1000);
			System.out.println("Vérification du fichier effectuée");
			
			// Envoyer
			driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]")).click();// Vérification
			Thread.sleep(2000);
			
			// Vérification des fichiers téléchargés
				//mémoire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
			caractSpec = "_";
			String nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
			System.out.println(nomMem);
			Thread.sleep(2000);
			
				//pieces complémentaires
			myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
			caractSpec = "_";
			MesFonctions.fichier(driver, elements, myXpath, caractSpec);
				
				//Inventaire
			myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			String nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
			System.out.println(nomInv);
			Thread.sleep(2000);
			
			myXpath = "//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]";
			MesFonctions.objet(driver, myXpath);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
			driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]")).click();
			Thread.sleep(3000);
			
			// Vérification succès envoi
				String mess = "";
					
						//alerte 1
					MesFonctions.PopUp(driver, alert);
					alert.accept();
					MesFonctions.waiting1(driver, Duration.ofSeconds(1));
					Thread.sleep(2000);
						//alerte 2
					mess = alert.getText();
					System.out.println(mess);
					alert.accept();

					Thread.sleep(1000);
						//Vérification de l'état de l'envoi
			String mess1 = "Opération effectuée avec succès !";

			if (mess.equals(mess1)) {
				Thread.sleep(3000);

			} else {
				throw new Exception("ERREUR LORS DE L\'ENVOI : " + mess);
			}
			
			// Récupération du num de reqête
			String numreq = driver.findElement(By.xpath("//td[contains(text(),'Envoyé')]//preceding-sibling::td/a[@class='numDossier']")).getText();
			String numDoc = numreq.replace("/"," / ");
			System.out.println(numDoc);

			// Déconnexion
			driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici')]")).click();
			Thread.sleep(1000);

			identifiant = "lb";
			mdp = "lb";
			
			// Authentification
			driver.get("https://www.telerecours.recette.juradm.fr/AuthentifierUtilisateur/AuthentifierUtilisateur.aspx?juridiction=CA75");
			Thread.sleep(2000);
			MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
			
			// Enregistrer le document
			driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numDoc + "')]")).click();
			
			myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
			caractSpec = " ";
			String str = MesFonctions.leNom(driver, myXpath, caractSpec);
			int fin = str.indexOf(str.split(" ")[2]);
			acteur = str.substring(0, fin).trim();
			System.out.println(acteur);
			
			// Rattachement
			MicroFonctions.rattachement(driver, boolSearch, myXpath);
			
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
			System.out.println(verifFile1);
			
			myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
			caractSpec = "_";
			MesFonctions.fichier(driver, elements, myXpath, caractSpec);
			Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			caractSpec = "_";
			String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
			System.out.println(verifFile2);
			
			//Enregistrement du document 
			myXpath = "//input[@id='btEnregistrer']";
			MesFonctions.objet(driver, myXpath);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
			
			MesFonctions.objet(driver, myXpath).click();
			Thread.sleep(2000);
			
				//alerte
			String message ="";
			
				MesFonctions.PopUp(driver, alert);
				alert.accept();
				MesFonctions.waiting1(driver, Duration.ofSeconds(2));
				
				Thread.sleep(2000);
				message = alert.getText();
				System.out.println(message);
				
				//Vérification de lalerte
				String alert1 = "Le document a été enregistré avec succès.";
				
				if (message.equals(alert1)) {
					Thread.sleep(1000);
					alert.accept();

				} else {
					throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
				}
				System.out.println("dépôt et enregistrement CAA terminés");
				Thread.sleep(5000);
		}
	
	@Test
	public void depotDocTA() throws Throwable {
		identifiant = "afl53e7";
		mdp = "Lhommeest2019*";
		
		//Authentification
		MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, mdp);
		
		Thread.sleep(2000);
		
		// Choix de la juridiction
		System.out.println("Authentification réussie");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='TA Paris']")).click();
		System.out.println("Choix de juridiction TA");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AD']")).click();
		Thread.sleep(1000);
		
		//Préparer l'envoi d'un document
		driver.findElement(By.xpath("//a[@id='btnDeposerDocument']")).click();
		Thread.sleep(2000);
					
		//choix du dossier
		String dossier = "2100693";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumsaisi']")).sendKeys(dossier);
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btnRechercherDossier']")).click();
		Thread.sleep(1000);
		String verificat = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumDossier']")).getAttribute("value");
		boolean verif1 = verificat.equals(dossier);
		if (verif1 == false) {
			throw new Exception ("ERREUR SUR LE DOSSIER !!!");
		}
		System.out.println("Le dossier de dépôt est le : "+ verificat);
		
		
		
		//Type de Document
		myXpath = "//input[@id='Mstr_cpMain_rbPj_0']";
		MesFonctions.objet(driver, myXpath).click();
		Thread.sleep(1000);
		String text = "Ce dépôt doit être pris en compte dans les plus brefs délais.\nCordialement,\nMaître AFLALO";
		myXpath = "//textarea[@id='Mstr_cpMain_txtMessage']";
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		Thread.sleep(1000);
		String doc = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_rbPj_0']//following-sibling::label")).getText();
		System.out.println("Document : "+doc);
		Thread.sleep(2000);
		
		
		//type de mémoire
		myXpath = "//select[@id='Mstr_cpMain_ddlTypeDocument']";
		value = "RECMEM"; 
		MesFonctions.selection(driver, myXpath, value);
		Thread.sleep(3000);
		String typeMem = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlTypeDocument']//option[@value='"+value+"']")).getText();//la valeur selected n'et pas définie sur le bon attribut(value)
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadFichierMemoire_fileUpload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 1.docx");
		Thread.sleep(1000);
		int nbrMem = driver.findElements(By.xpath("//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']")).size();
		System.out.println("Nombre de fichier(s) mémoire, chargé(s) : "+nbrMem);
		System.out.println("Type de mémoire choisi : "+ typeMem);
		
		//type de pièces
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 1.docx" );
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 2.docx");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 Mémoire 3.docx"); 
		Thread.sleep(1000);
		int nbrPc = driver.findElements(By.xpath("//a[contains(@id,'fileLinkFichierPiecesMemoire_hplFichier')]")).size();
		System.out.println("Nombre de pièces complémentaires : "+ nbrPc);
		Thread.sleep(1000);
		
		//Inventaire
		myXpath = "//input[@id='Mstr_cpMain_FileUploadInventairePieces_fileUpload']";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadInventairePieces_fileUpload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Inventaire.pdf");
		Thread.sleep(1000);
		int nbrInv = driver.findElements(By.xpath("//a[(@id='Mstr_cpMain_FileUploadInventairePieces_DlFileLink_hplFichier')]")).size();
		System.out.println("Nombre de fichier(s) inventaire, chargé(s) : "+ nbrInv);
		Thread.sleep(2000);
		
		//Convertion des fichiers en PDF
		myXpath = "//a[@id='Mstr_cpMain_zonePDF_btConvertir']";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_zonePDF_btConvertir']")).click();
		Thread.sleep(1000);
		MesFonctions.PopUp(driver, alert);
		alert.accept();
		Thread.sleep(4000);
		
		
		//Verification du fichier
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']")).click();
		
		driver.switchTo().window(MesFonctions.childWindow(driver));
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(MesFonctions.parentWindow(driver));
		Thread.sleep(1000);
	
		myXpath ="//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).click();
		Thread.sleep(1000);
		System.out.println("Vérification du fichier effectuée");
		
		// Envoyer
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]")).click();// Vérification
		Thread.sleep(2000);
		
		// Vérification des fichiers téléchargés
			//mémoire
		myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
		caractSpec = "_";
		String nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
		System.out.println(nomMem);
		Thread.sleep(2000);
		
			//pieces complémentaires
		myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
		caractSpec = "_";
		MesFonctions.fichier(driver, elements, myXpath, caractSpec);
			
			//Inventaire
		myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
		caractSpec = "_";
		String nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
		System.out.println(nomInv);
		Thread.sleep(2000);
		
		myXpath = "//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]")).click();
		Thread.sleep(3000);
		
		// Vérification succès envoi
			String mess = "";
				
					//alerte 1
				MesFonctions.PopUp(driver, alert);
				alert.accept();
				MesFonctions.waiting1(driver, Duration.ofSeconds(1));
				Thread.sleep(2000);
					//alerte 2
				mess = alert.getText();
				System.out.println(mess);
				alert.accept();

				Thread.sleep(1000);
					//Vérification de l'état de l'envoi
		String mess1 = "Opération effectuée avec succès !";

		if (mess.equals(mess1)) {
			Thread.sleep(3000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENVOI : " + mess);
		}
		
		// Récupération du num de reqête
		String numreq = driver.findElement(By.xpath("//td[contains(text(),'Envoyé')]//preceding-sibling::td/a[@class='numDossier']")).getText();
		String numDoc = numreq.replace("/"," / ");
		System.out.println(numDoc);

		// Déconnexion
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici')]")).click();
		Thread.sleep(1000);
		
		
		// Authentification
		driver.get("https://www.telerecours.recette.juradm.fr/AuthentifierUtilisateur/AuthentifierUtilisateur.aspx?juridiction=TA75");
		Thread.sleep(2000);
		
		identifiant = "lb";
		mdp = "lb";
		MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
		Thread.sleep(1000);
			
		// Enregistrer le document
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numDoc + "')]")).click();
		
		myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
		caractSpec = " ";
		String str = MesFonctions.leNom(driver, myXpath, caractSpec);
		int fin = str.indexOf(str.split(" ")[2]);
		acteur = str.substring(0, fin).trim();
		System.out.println(acteur);
		Thread.sleep(2000);
		
		// Rattachement
		myXpath = "//a[@id='btnCreerRattachement']/span[2]";
		MicroFonctions.rattachement(driver, boolSearch, myXpath);
		
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
		System.out.println(verifFile1);
		
		myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
		caractSpec = "_";
		MesFonctions.fichier(driver, elements, myXpath, caractSpec);
		Thread.sleep(2000);
		
		myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
		caractSpec = "_";
		String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
		System.out.println(verifFile2);
		
		//Enregistrement du document 
		myXpath = "//input[@id='btEnregistrer']";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
		
		MesFonctions.objet(driver, myXpath).click();
		Thread.sleep(2000);
		
			//alerte
		String message ="";
			MesFonctions.PopUp(driver, alert);
			alert.accept();
			MesFonctions.waiting1(driver, Duration.ofSeconds(2));
			
			Thread.sleep(2000);
			message = alert.getText();
			System.out.println(message);
			
			//Vérification de lalerte
			String alert1 = "Le document a été enregistré avec succès.";
			
			if (message.equals(alert1)) {
				Thread.sleep(1000);
				alert.accept();

			} else {
				throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
			}
			System.out.println("dépôt et enregistrement TA terminés");
			Thread.sleep(5000);
	}
	
	
	@Test
	public void depotDocCE() throws Throwable {
		driver.get("https://www.telerecours.recette.conseil-etat.fr/");
		
		Thread.sleep(2000);
		identifiant = "dai5mQr";
		mdp = "Lhommeest2019*";
		
		//Authentification
		MicroFonctions.AuthentificationTaCaaCeExt(driver, identifiant, mdp);
		
		System.out.println("Authentification réussie");
		Thread.sleep(2000);
	
		System.out.println("Choix de juridiction CE");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AD']")).click();
		Thread.sleep(1000);
		
		//Préparer l'envoi d'un document
		driver.findElement(By.xpath("//a[@id='btnDeposerDocument']")).click();
		Thread.sleep(2000);
		
		//Selection du dossier
		String dossier = "366351";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumsaisi']")).sendKeys(dossier);
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btnRechercherDossier']")).click();
		Thread.sleep(1000);
		String verificat = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtNumDossier']")).getAttribute("value");
		boolean verif1 = verificat.equals(dossier);
		if (verif1 == false) {
			throw new Exception ("ERREUR SUR LE DOSSIER !!!");
		}
		System.out.println("Le dossier de dépôt est le : "+ verificat);
		
		//Type de Document
		myXpath = "//input[@id='Mstr_cpMain_rbPj_0']";
		MesFonctions.objet(driver, myXpath).click();
		Thread.sleep(1000);
		String text = "Ce dépôt doit être pris en compte dans les plus brefs délais.\nCordialement,\nMaître DAILLET";
		myXpath = "//textarea[@id='Mstr_cpMain_txtMessage']";
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		Thread.sleep(1000);
		String doc = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_rbPj_0']//following-sibling::label")).getText();
		System.out.println("Document : "+doc);
		Thread.sleep(2000);
		
		//type de mémoire
		myXpath = "//select[@id='Mstr_cpMain_ddlTypeDocument']";
		value = "RECAMP"; 
		MesFonctions.selection(driver, myXpath, value);
		Thread.sleep(3000);
		String typeMem = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlTypeDocument']//option[@value='"+value+"']")).getText();//la valeur selected n'et pas définie sur le bon attribut(value)
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadFichierMemoire_fileUpload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 1.docx");
		Thread.sleep(2000);
		int nbrMem = driver.findElements(By.xpath("//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']")).size();
		System.out.println("Nombre de fichier(s) mémoire, chargé(s) : "+nbrMem);
		System.out.println("Type de mémoire choisi : "+ typeMem);
		
		//type de pièces
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 Mémoire 1.docx" );
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 Mémoire 2.docx");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 Mémoire 3.docx"); 
		Thread.sleep(2000);
		int nbrPc = driver.findElements(By.xpath("//a[contains(@id,'fileLinkFichierPiecesMemoire_hplFichier')]")).size();
		System.out.println("Nombre de pièces complémentaires : "+ nbrPc);
		Thread.sleep(2000);
		
		//Inventaire
		myXpath = "//input[@id='Mstr_cpMain_FileUploadInventairePieces_fileUpload']";
		MesFonctions.objet(driver, myXpath );
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadInventairePieces_fileUpload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Inventaire.pdf");
		Thread.sleep(1000);
		int nbrInv = driver.findElements(By.xpath("//a[(@id='Mstr_cpMain_FileUploadInventairePieces_DlFileLink_hplFichier')]")).size();
		System.out.println("Nombre de fichier(s) inventaire, chargé(s) : "+ nbrInv);
		Thread.sleep(2000);
		
		//Convertion des fichiers en PDF
		myXpath = "//a[@id='Mstr_cpMain_zonePDF_btConvertir']";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_zonePDF_btConvertir']")).click();
		//alert = driver.switchTo().alert();
		MesFonctions.PopUp(driver, alert);
		alert.accept();
		Thread.sleep(4000);
		
		//Verification du fichier
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_FileUploadFichierMemoire_DlFileLink_hplFichier']")).click();
		
		driver.switchTo().window(MesFonctions.childWindow(driver));
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(MesFonctions.parentWindow(driver));
		Thread.sleep(1000);
	
		myXpath ="//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).click();
		Thread.sleep(1000);
		System.out.println("Vérification du fichier effectuée");
		
		// Envoyer
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btDeposerDocument']/span[@class='button-text' and (text()='Envoyer')]")).click();// Vérification
		Thread.sleep(2000);
		
		// Vérification des fichiers téléchargés
			//mémoire
		myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierDocument_hplFichier']";
		caractSpec = "_";
		String nomMem = MesFonctions.leNom(driver, myXpath, caractSpec);
		System.out.println(nomMem);
		Thread.sleep(2000);
		
			//pieces complémentaires
		myXpath = "//a[contains(@id,'Mstr_cpMain_rptPieces')]";
		caractSpec = "_";
		MesFonctions.fichier(driver, elements, myXpath, caractSpec);
			
			//Inventaire
		myXpath = "//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']";
		caractSpec = "_";
		String nomInv = MesFonctions.leNom(driver, myXpath, caractSpec);
		System.out.println(nomInv);
		Thread.sleep(2000);
		
		myXpath = "//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]")).click();
		Thread.sleep(3000);
		
		// Vérification succès envoi
			String mess = "";
				
					//alerte 1
				MesFonctions.PopUp(driver, alert);
				alert.accept();
				MesFonctions.waiting1(driver, Duration.ofSeconds(1));
				Thread.sleep(2000);
					//alerte 2
				mess = alert.getText();
				System.out.println(mess);
				alert.accept();

				Thread.sleep(1000);
					//Vérification de l'état de l'envoi
		String mess1 = "Opération effectuée avec succès !";

		if (mess.equals(mess1)) {
			Thread.sleep(3000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENVOI : " + mess);
		}
		
		// Récupération du num de reqête
		String numreq = driver.findElement(By.xpath("//td[contains(text(),'Envoyé')]//preceding-sibling::td/a[@class='numDossier']")).getText();
		//String numDoc = numreq.replace(" / ","/");
		System.out.println(numreq);

		// Déconnexion
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici')]")).click();
		Thread.sleep(1000);

		identifiant = "lb";
		mdp = "lb";
		
		// Authentification
		driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
		Thread.sleep(2000);
		MicroFonctions.AuthentificationTaCaaCeInt(driver, identifiant, mdp);
		
		// Enregistrer le document
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numreq + "')]")).click();
		
		myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
		caractSpec = " ";
		String str = MesFonctions.leNom(driver, myXpath, caractSpec);
		int fin = str.indexOf(str.split(" ")[2]);
		acteur = str.substring(0, fin).trim();
		System.out.println(acteur);
		
		// Rattachement
		MicroFonctions.rattachement(driver, boolSearch, myXpath);
		
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
		System.out.println(verifFile1);
		
		myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
		caractSpec = "_";
		MesFonctions.fichier(driver, elements, myXpath, caractSpec);
		Thread.sleep(2000);
		
		myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
		caractSpec = "_";
		String verifFile2 = MesFonctions.leNom(driver, myXpath, caractSpec);
		System.out.println(verifFile2);
		
		//Enregistrement du document 
		myXpath = "//input[@id='btEnregistrer']";
		MesFonctions.objet(driver, myXpath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  MesFonctions.objet(driver, myXpath));
		
		MesFonctions.objet(driver, myXpath).click();
		Thread.sleep(2000);
		
			//alerte
		String message ="";
		
			MesFonctions.PopUp(driver, alert);
			alert.accept();
			MesFonctions.waiting1(driver, Duration.ofSeconds(2));
			
			Thread.sleep(2000);
			message = alert.getText();
			System.out.println(message);
			
			//Vérification de lalerte
			String alert1 = "Le document a été enregistré avec succès.";
			
			if (message.equals(alert1)) {
				Thread.sleep(1000);
				alert.accept();

			} else {
				throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
			}
			System.out.println("dépôt et enregistrement CE terminés");
			Thread.sleep(5000);
		
	}
			
	
	@AfterMethod
	public void déconnexion() throws Exception {
		Thread.sleep(1000);


		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		System.out.println("Déconnexion réussie");
		Thread.sleep(2000);
	}
			
	@AfterSuite
	public void fin() {
		System.out.println("LE TEST EST TERMINE !!!");
		driver.quit();
	}
}

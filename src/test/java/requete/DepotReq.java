
package requete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DepotReq {

	WebDriver driver;

	@BeforeSuite
	public void InitialisationReq() {
		// WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Driver\\chromedriver.exe");
		// caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
		// UnexpectedAlertBehaviour.IGNORE);
		ChromeOptions options = new ChromeOptions();
		options.merge(caps);
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		
		
		driver = new ChromeDriver(options);
		System.out.println("Initialisation réussie");
	}

	@BeforeMethod
	public void choixSiteTACAA() throws InterruptedException {
		
		driver.get("https://www.telerecours.recette.juradm.fr/");
		Thread.sleep(2000);
		System.out.println("Connection réussie");

//		Set<String> Tab = driver.getWindowHandles();
//		
//		int count = Tab.size();
//		System.out.println(count);
//		Iterator<String> it = Tab.iterator();
//		String parentWindow = it.next();
//		System.out.println("parent window : " + parentWindow);
	}

	@Test
	public void depotReqCAA() throws Exception {
		String identifiant = "amaz4qk";
		String mdp = "Lhommeest2019*";


		// Authentification
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(mdp);
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();

		// Choix de la juridiction
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='CAA Paris']")).click();
		System.out.println("Choix de juridiction CAA");

		// Préparer une requête
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AB']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='btNewRequete2']")).click();

		Thread.sleep(1000);

//		//Ajouter un requérant
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]"))
				.click();
		Thread.sleep(1000);
//		Set<String> Tab1 = driver.getWindowHandles();
//				
//				int count0 = Tab1.size();
//				System.out.println(count0);
//				Iterator<String> it0 = Tab1.iterator();
//				String parentWindow0 = it0.next();
//				String childWindow0 = it0.next();
//				driver.switchTo().window(childWindow0);

		WebElement civilite = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_requerantCivilite']"));
		Select select = new Select(civilite);
		select.selectByValue("1");
		Thread.sleep(1000);

		// ((Select)
		// driver.findElement(By.xpath("//select[@id='Mstr_cpMain_requerantCivilite']"))).selectByValue("1");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys("ECHILE");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys("François");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys("12 rue des Chevaliers");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("94500");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("CHAMPIGNY-SUR-MARNE");
		Thread.sleep(1000);
		// Valider
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ui-button-text' and text()='Ajouter']")).click();
//		driver.switchTo().window(parentWindow0);

		// Urgence et Matière
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_RadioButtonUrgence_0']")).click();
		String urg = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_RadioButtonUrgence_0']"))
				.getAttribute("value");
		WebElement matiere = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlMatiere']"));
		Select select1 = new Select(matiere);
		String value = "01";
		select1.selectByValue(value);
		Thread.sleep(1000);
		String mat = driver
				.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlMatiere']//option[@value=" + value + "]"))
				.getText();

		// Décision attaquée
		WebElement saisine = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlSaisine']"));// Saisine
		String value1 = "1";
		Select select2 = new Select(saisine);
		select2.selectByValue(value1);
		String sais = driver
				.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlSaisine']//option[@value=" + value1 + "]"))
				.getText();
		Thread.sleep(1000);

		String date = "12/05/2021";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(date);// Date

		String value2 = "11027";// CAA
		// String value ="11074";
		WebElement auteur = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlJuridictionsDecision']"));// Auteur
																												// CAA
		// WebElement auteur =
		// driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlAuteurDecAtt']"));//Auteur
		// CE
		Select select3 = new Select(auteur);
		select3.selectByValue(value2);
		String juridiction = driver.findElement(By.xpath("//select[@id=\'Mstr_cpMain_ddlJuridictionsDecision\']//option[@value=" + value2 + "]")).getText();

		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadDecAttq_fileUpload']")).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Acte attaqué.pdf");
		Thread.sleep(1000);// Fichier

		// Requête
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadRequeteFichier_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.docx");
		Thread.sleep(1000);

		// Pièces complémentaires
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\4 Jugement.pdf");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 1998 - 2012.pdf");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Courrrier greffe.docx");
		Thread.sleep(1000);

		// AJ
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadAideJur_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
		Thread.sleep(1000);

		// Inventaire
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadInv_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\L\'inventaire manuel.pdf");
		Thread.sleep(1000);

		// information par courriel
		driver.findElement(By.xpath(
				"//a[@id='Mstr_cpMain_ucContactDossier_personneCourrielAdd']/span[@class='button-text' and (text()='Ajouter')]"))
				.click();
		Thread.sleep(1000);
		Set<String> onglets = driver.getWindowHandles();
		int count1 = onglets.size();
		System.out.println("***" + count1 + "***" + onglets + "***");
		Iterator<String> it1 = onglets.iterator();
		String parentdWindow1 = it1.next();
		String childWindow = it1.next();
		driver.switchTo().window(childWindow);

		List<WebElement> qte = driver.findElements(By.xpath("//select[@id='ddlContactsASelectionner']/option"));

		int opt = qte.size();
		System.out.println(qte);
		boolean verif = opt > 0;
		//System.out.println(opt);
		System.out.println(verif);

		if (verif == true) {
			// System.out.println("hello");
			WebElement name = driver.findElement(By.xpath("//select[@id='ddlContactsASelectionner']"));
			System.out.println(name);
			Select select4 = new Select(name);
//			List<WebElement> allSelect = select4.getAllSelectedOptions();
//			int nbr = allSelect.size();
//			System.out.println(nbr);

			for (int i = 1; i <= opt; i++) {
				select4.selectByIndex(0);
				driver.findElement(By.xpath("//input[@id='btnFlecheDroite']")).click();
				Thread.sleep(1000);
			}

			driver.findElement(By.xpath("//input[@id='btnValider']")).click();
		} else {
			driver.findElement(By.xpath("//input[@id='btnAnnuler']")).click();
		}
		Thread.sleep(1000);
		driver.switchTo().window(parentdWindow1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='Mstr_cpMain_txtCourrielsComplementaires']"))
				.sendKeys("johan.agathine@conseil-etat.fr");

		// Conversion PDF
		driver.findElement(By.xpath(
				"//a[@id='Mstr_cpMain_zonePDF_btConvertir']/span[@class='button-text' and (text()='Convertir au format PDF')]"))
				.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(4000);

		// Verification du fichier
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_FileUploadDecAttq_DlFileLink_hplFichier']")).click();
		Thread.sleep(5000);
		Set<String> onglets1 = driver.getWindowHandles();
		System.out.println(onglets1.size());
		Iterator<String> it2 = onglets1.iterator();
		String parentWindow2 = it2.next();
		String childWindow1 = it2.next();
		driver.switchTo().window(childWindow1);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow2);
		Thread.sleep(1000);
		Point dim = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).getLocation();
		System.out.println(dim);
		WebElement element = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		js.executeScript("window.scrollBy()",dim);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).click();
		Thread.sleep(1000);

		// Envoyer
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btDeposerRequete2']/span[@class='button-text' and (text()='Envoyer')]"))
				.click();// Vérification
		Thread.sleep(2000);

		// Vérification des fichiers téléchargés
		String decAtt = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']"))
				.getText();
		int deb1 = decAtt.indexOf(decAtt.split("_")[1]);
		String nomDecAtt = decAtt.substring(deb1, decAtt.length()).trim();
		System.out.println(nomDecAtt);
		boolean verifdecAtt = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifdecAtt, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String req = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']"))
				.getText();
		int deb2 = req.indexOf(req.split("_")[1]);
		String nomReq = req.substring(deb2, req.length()).trim();
		System.out.println(nomReq);
		boolean verifReq = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifReq, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ1 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl01')]")).getText();
		int deba = PJ1.indexOf(PJ1.split("_")[1]);
		String nomPJ1 = PJ1.substring(deba, PJ1.length());
		System.out.println(nomPJ1);
		boolean verifPJ1 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl01')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ1, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ2 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl02')]")).getText();
		int debb = PJ2.indexOf(PJ2.split("_")[1]);
		String nomPJ2 = PJ2.substring(debb, PJ2.length());
		System.out.println(nomPJ2);
		boolean verifPJ2 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl02')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ2, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ3 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl03')]")).getText();
		int debc = PJ3.indexOf(PJ3.split("_")[1]);
		String nomPJ3 = PJ3.substring(debc, PJ3.length());
		System.out.println(nomPJ3);
		boolean verifPJ3 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl03')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ3, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ4 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl04')]")).getText();
		int debd = PJ4.indexOf(PJ4.split("_")[1]);
		String nomPJ4 = PJ4.substring(debd, PJ4.length());
		System.out.println(nomPJ4);
		boolean verifPJ4 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl04')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ4, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String AJ = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']")).getText();
		int deb3 = AJ.indexOf(AJ.split("_")[1]);
		String nomAJ = AJ.substring(deb3, AJ.length()).trim();
		System.out.println(nomAJ);
		boolean verifAJ = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifAJ, "Erreur ! Pas de fichier");;
		Thread.sleep(1000);

		String inventaire = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']"))
				.getText();
		int deb4 = inventaire.indexOf(inventaire.split("_")[1]);
		String nomInventaire = inventaire.substring(deb4, inventaire.length()).trim();
		System.out.println(nomInventaire);

		boolean verifInventaire = driver
				.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']")).isDisplayed();
		
		Assertions.assertTrue(verifInventaire, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]"))
				.click();
		Thread.sleep(3000);
		
		// Vérification succès envoi
			String mess = "";
				
					//alerte
				alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(9000);
				try 
					{
					mess = alert.getText();
					}catch (UnhandledAlertException e) {
					mess = e.getAlertText();	
					System.out.println(mess);
					alert.accept();
					}
				
				
				Thread.sleep(1000);

//
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
				
		String mess1 = "Opération effectuée avec succès !";

		if (mess.equals(mess1)) {
			Thread.sleep(3000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENVOI : " + mess);
		}
		
		// Récupération du num de reqête
		String numreq = driver.findElement(By.xpath("//td[contains(text(),'Envoyée')]//preceding-sibling::td/a[@class='numDossier']")).getText();
		System.out.println(numreq);

		// Déconnexion
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici')]")).click();
		Thread.sleep(1000);

		String identifiant1 = "lb";
		String mdp1 = "lb";

		// Authentification
		driver.get("https://www.telerecours.recette.juradm.fr/AuthentifierUtilisateur/AuthentifierUtilisateur.aspx?juridiction=CA75");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtIdentifiant']")).sendKeys(identifiant1);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(mdp1);
		driver.findElement(By.xpath("//a[@id='ibOk']/span[@class='button-text' and (text()='Valider')]")).click();
		Thread.sleep(1000);

		// Enregistrer la requête
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AC']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numreq + "')]")).click();
		String acteur = driver
				.findElement(By.xpath("//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td"))
				.getText();
		System.out.println(acteur);

		int deb = acteur.indexOf(acteur.split(" ")[1]);
		int fin = acteur.indexOf(acteur.split(" ")[2]);

		// vérification des informations transmises lors du dépôt
		String verifMat = driver.findElement(By.xpath("//span[@id='txtMatiereRequerant']")).getText();
		System.out.println(verifMat);
		String verifUrg = driver.findElement(By.xpath("//span[@id='txtUrgence']")).getText().toLowerCase();
		System.out.println(verifUrg);

		boolean verif1 = verifMat.equals(mat);
		if (verif1 == false) {
			throw new Exception("LA MATIERE EST DIFFERENTE" + verifMat + "/" + mat);
		} else {
			Thread.sleep(1000);
		}

		boolean verif2 = verifUrg.equals(urg);
		if (verif2 == false) {
			throw new Exception("L\'URGENCE EST DIFFERENTE : " + verifUrg + "/" + urg);
		} else {
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//input[@value ='" + sais + "']"));
		System.out.println("trouvé : " + sais);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value ='" + date + "']"));
		System.out.println("trouvé : " + date);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value ='" + juridiction + "']"));
		System.out.println("trouvé : " + juridiction);
		Thread.sleep(1000);

		// Rattachement

		boolean test = true;

		try {
			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).isDisplayed();
			test = true;
			System.out.println(test);
		} catch (NoSuchElementException l) {
			test = false;
			System.out.println(test);
		}

		if (test == false) {
			Thread.sleep(1000);
		} else {
			String avocatnom = acteur.substring(deb, fin).trim();
			System.out.println(avocatnom);
			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).click();
			Thread.sleep(1000);

			Set<String> onglet2 = driver.getWindowHandles();
			Iterator<String> it3 = onglet2.iterator();
			String parentWindow3 = it3.next();
			String childWindow3 = it3.next();
			driver.switchTo().window(childWindow3);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='searchNom']")).sendKeys(avocatnom);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value='Rechercher']")).click();
			Thread.sleep(1000);

			boolean boolSearch = false;

			if (boolSearch == false) {
				try {
					driver.findElement(By.xpath("//td[text()='Aucun résultat trouvé pour cette recherche.']"))
							.isDisplayed();
					System.out.println(boolSearch);
				} catch (NoSuchElementException s) {
					driver.findElement(By.xpath("//input[@name='cbxSel']")).click();

					driver.findElement(By.xpath("//input[@id='btRattacher']")).click();

					Thread.sleep(1000);
					alert.accept();
				}
			} else {
				driver.findElement(By.xpath("//input[@id='btCreerEntreeSkipper']")).click();
				alert.accept();
				Thread.sleep(1000);
				driver.switchTo().window(parentWindow3);
				Thread.sleep(1000);
			}
		}

		// Choix de la chambre
		WebElement chambre = driver.findElement(By.xpath("//select[@id='ddlChambre']"));
		Select select5 = new Select(chambre);
		String value4 = "1";
		select5.selectByValue(value4);
		Thread.sleep(1000);

		// Choix de la matière
		WebElement matiere1 = driver.findElement(By.xpath("//select[@id='DdlMatierePrincipale']"));
		Select select6 = new Select(matiere1);
		String value5 = "09";
		select6.selectByValue(value5);
		Thread.sleep(1000);

		WebElement matiere11 = driver.findElement(By.xpath("//select[@id='DdlMatiereSecondaire']"));
		Select select7 = new Select(matiere11);
		String value6 = "0901";
		select7.selectByValue(value6);
		Thread.sleep(1000);

		// Choix de la catégorie
		WebElement categ = driver.findElement(By.xpath("//select[@id='DdlCategorie']"));
		Select select8 = new Select(categ);
		String value7 = "NO";
		select8.selectByValue(value7);
		Thread.sleep(1000);

		// Sauvegarde de la requête
		WebElement element2 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='btSauvegarder']")).click();
		Thread.sleep(1000);
		
		
		//Première alerte
		alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(9000);
		String messa = "";
	
		//deuxième alerte
		try
		{
		messa = alert.getText();
		}catch(UnhandledAlertException e) {
			messa = alert.getText();
			System.out.println(messa);
			alert.accept();
		}
	
	
		String mess2 = "Requête sauvegardée";

		if (messa.equals(mess2)) {
			Thread.sleep(1000);

		} else {
			throw new Exception("ERREUR LORS DE LA SAUVEGARDE : " + messa);
		}

		// Retour sur la page d'enregistrement
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numreq + "')]")).click();

		Thread.sleep(2000);

		// Vérification des fichiers
		boolean file = driver
				.findElement(By.xpath(
						"//a[@id='fileLinkFichierDecAttq_hplFichier' and (contains(text(),'" + nomDecAtt + "'))]"))
				.isDisplayed();// fichier décision attaquée
		Thread.sleep(1000);
		String nomFile = driver.findElement(By.xpath("//a[@id='fileLinkFichierDecAttq_hplFichier']")).getText();
		int start = nomFile.indexOf(nomFile.split("_")[1]);
		String nomFile00 = nomFile.substring(start, nomFile.length());
		Assertions.assertTrue(file, "ERREUR ! Le nom de fichier est différent : " + nomFile00);
		Thread.sleep(1000);

		boolean file1 = driver
				.findElement(By
						.xpath("//a[@id='fileLinkFichierCourrier_hplFichier' and (contains(text(),'" + nomReq + "'))]"))
				.isDisplayed();// fichier requête
		Thread.sleep(1000);
		String nomFile1 = driver.findElement(By.xpath("//a[@id='fileLinkFichierCourrier_hplFichier']")).getText();
		int start1 = nomFile1.indexOf(nomFile1.split("_")[1]);
		String nomFile11 = nomFile1.substring(start1, nomFile1.length());
		Assertions.assertTrue(file1, "ERREUR ! Le nom de fichier est différent : " + nomFile11);
		Thread.sleep(1000);

		boolean multipleFiles = driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
		multipleFiles = true;

		try {
			driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
			multipleFiles = true;
		} catch (NoSuchElementException a) {
			multipleFiles = false;
			System.out.println("PAS DE PIECES COMPLEMENTAIRES");
		}

		if (multipleFiles == true) {
			List<WebElement> files = driver.findElements(By.xpath("//a[contains(@id,'rptPiecesJointe_')]"));

			List<String> listA = new ArrayList<>();
			listA.add(PJ1);
			listA.add(PJ2);
			listA.add(PJ3);
			listA.add(PJ4);
			System.out.println(listA);

			int nbr1 = files.size();
			System.out.println(nbr1);

			// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
			// element2);
			Thread.sleep(1000);

			for (WebElement a : files) {
				System.out.println(a.getText());
				final boolean verifnom = listA.contains(a.getText());

				if (!verifnom) {
					throw new Exception("ERREUR SUR CE FICHIER : " + a.getText());
				}
			}
		}
		boolean file2 = driver
				.findElement(
						By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier' and (contains(text(),'" + nomAJ + "'))]"))
				.isDisplayed();// fichier AJ
		Thread.sleep(1000);
		String nomFile2 = driver.findElement(By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier']")).getText();
		int start2 = nomFile2.indexOf(nomFile2.split("_")[1]);
		String nomFile22 = nomFile2.substring(start2, nomFile2.length());
		Assertions.assertTrue(file2, "ERREUR ! Le nom de fichier est différent : " + nomFile22);
		Thread.sleep(1000);

		boolean file3 = driver.findElement(By.xpath(
				"//a[@id='fileLinkFichierInventaire_hplFichier' and (contains(text(),'" + nomInventaire + "'))]"))
				.isDisplayed();// fichier inventaire
		Thread.sleep(1000);
		String nomFile3 = driver.findElement(By.xpath("//a[@id='fileLinkFichierInventaire_hplFichier']")).getText();
		int start3 = nomFile3.indexOf(nomFile3.split("_")[1]);
		String nomFile33 = nomFile3.substring(start3, nomFile3.length());
		Assertions.assertTrue(file3, "ERREUR ! Le nom de fichier est différent : " + nomFile33);
		Thread.sleep(1000);

		// Enregistrer de la requête
		WebElement element3 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='btEnregistrer']")).click();
	
				Thread.sleep(2000);
				String messb = "";
				String message = "";
				
			//Alerte
				try
				{
				alert.accept();
				Thread.sleep(8000);
				messb = alert.getText();
				}
				catch (UnhandledAlertException e) 
				{
				messb =e.getAlertText();
				int longueur = messb.length();
				System.out.println(longueur);
				System.out.println(messb);
				message = messb.substring(0, 32);
				}
					
		System.out.println(message);
		String mess3 = "Requête enregistrée dans Skipper";

		if (message.equals(mess3)) {
			Thread.sleep(1000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
		}
		System.out.println("dépôt et enregistrement CAA terminés");
		Thread.sleep(5000);

	}

	@Test
	public void depotReqTA() throws Exception {

		String identifiant = "afl53e7";
		String mdp = "Lhommeest2019*";

		// Authentification
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(mdp);
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();

		// Choix de la juridiction
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='TA Paris']")).click();
		System.out.println("Choix de juridiction TA");

		// Préparer une requête
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AB']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='btNewRequete2']")).click();
		Thread.sleep(1000);

		// Ajouter un requérant
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]"))
				.click();
		Thread.sleep(1000);

		WebElement civilite = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_requerantCivilite']"));
		Select select = new Select(civilite);
		select.selectByValue("1");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys("CHEVINOT");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys("Françoise");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']"))
				.sendKeys("12 avenue du 8 mai 1945");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("75003");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("PARIS");
		Thread.sleep(1000);
		// Valider
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ui-button-text' and text()='Ajouter']")).click();

		// Urgence et Matière
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_RadioButtonUrgence_0']")).click();
		String urg = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_RadioButtonUrgence_0']"))
				.getAttribute("value");
		WebElement matiere = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlMatiere']"));
		Select select1 = new Select(matiere);
		String value = "31";
		select1.selectByValue(value);
		Thread.sleep(1000);
		String mat = driver
				.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlMatiere']//option[@value=" + value + "]"))
				.getText();

		// Décision attaquée
		Thread.sleep(2000);
		String auteur = "PREFECTURE DE PARIS";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtAuteurDecAtt']")).sendKeys(auteur);// Auteur
		String ref = "22PA2156";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtReferenceDecAtt']")).sendKeys(ref);// Référence
		String dateRecla = "11/05/2021";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecRec']")).sendKeys(dateRecla);// Date de
																										// réclamation
		String dateDec = "18/03/2020";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttTA']")).sendKeys(dateDec);// Date de décision

		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadDecAttq_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Acte attaqué.pdf");
		Thread.sleep(1000);// Fichier

		// Requête
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadRequeteFichier_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.docx");
		Thread.sleep(1000);

		// Pièces complémentaires
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\4 Jugement.pdf");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 1998 - 2012.pdf");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Courrrier greffe.docx");
		Thread.sleep(1000);

		// AJ
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadAideJur_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
		Thread.sleep(1000);

		// Inventaire
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadInv_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\L\'inventaire manuel.pdf");
		Thread.sleep(1000);

		// information par courriel
		driver.findElement(By.xpath(
				"//a[@id='Mstr_cpMain_ucContactDossier_personneCourrielAdd']/span[@class='button-text' and (text()='Ajouter')]"))
				.click();
		Thread.sleep(1000);
		Set<String> onglets = driver.getWindowHandles();
		int count1 = onglets.size();
		System.out.println("***" + count1 + "***" + onglets + "***");
		Iterator<String> it1 = onglets.iterator();
		String parentdWindow1 = it1.next();
		String childWindow = it1.next();
		driver.switchTo().window(childWindow);

		List<WebElement> qte = driver.findElements(By.xpath("//select[@id='ddlContactsASelectionner']/option"));

		int opt = qte.size();
		System.out.println(qte);
		boolean verif = opt > 0;
		System.out.println(opt);
		System.out.println(verif);

		if (verif == true) {
			// System.out.println("hello");
			WebElement name = driver.findElement(By.xpath("//select[@id='ddlContactsASelectionner']"));
			System.out.println(name);
			Select select4 = new Select(name);
//				List<WebElement> allSelect = select4.getAllSelectedOptions();
//				int nbr = allSelect.size();
//				System.out.println(nbr);

			for (int i = 1; i <= opt; i++) {
				select4.selectByIndex(0);
				driver.findElement(By.xpath("//input[@id='btnFlecheDroite']")).click();
				Thread.sleep(1000);
			}

			driver.findElement(By.xpath("//input[@id='btnValider']")).click();
		} else {
			driver.findElement(By.xpath("//input[@id='btnAnnuler']")).click();
		}
		Thread.sleep(1000);
		driver.switchTo().window(parentdWindow1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='Mstr_cpMain_txtCourrielsComplementaires']"))
				.sendKeys("johan.agathine@conseil-etat.fr");

		// Conversion PDF
		driver.findElement(By.xpath(
				"//a[@id='Mstr_cpMain_zonePDF_btConvertir']/span[@class='button-text' and (text()='Convertir au format PDF')]"))
				.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);

		// Verification du fichier
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_FileUploadDecAttq_DlFileLink_hplFichier']")).click();
		Thread.sleep(5000);
		Set<String> onglets1 = driver.getWindowHandles();
		System.out.println(onglets1.size());
		Iterator<String> it2 = onglets1.iterator();
		String parentWindow2 = it2.next();
		String childWindow1 = it2.next();
		driver.switchTo().window(childWindow1);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow2);
		Thread.sleep(1000);
		Point dim = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).getLocation();
		System.out.println(dim);
		WebElement element = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']"));
//			JavascriptExecutor js = (JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//			js.executeScript("window.scrollBy()",dim);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).click();
		Thread.sleep(1000);

		// Envoyer
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btDeposerRequete2']/span[@class='button-text' and (text()='Envoyer')]"))
				.click();// Vérification
		Thread.sleep(2000);

		// Vérification des fichiers téléchargés
		String decAtt = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']"))
				.getText();
		int deb1 = decAtt.indexOf(decAtt.split("_")[1]);
		String nomDecAtt = decAtt.substring(deb1, decAtt.length()).trim();
		System.out.println(nomDecAtt);
		boolean verifdecAtt = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifdecAtt, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String req = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']"))
				.getText();
		int deb2 = req.indexOf(req.split("_")[1]);
		String nomReq = req.substring(deb2, req.length()).trim();
		System.out.println(nomReq);
		boolean verifReq = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierCourrier_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifReq, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ1 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl01')]")).getText();
		int deba = PJ1.indexOf(PJ1.split("_")[1]);
		String nomPJ1 = PJ1.substring(deba, PJ1.length());
		System.out.println(nomPJ1);
		boolean verifPJ1 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl01')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ1, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ2 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl02')]")).getText();
		int debb = PJ2.indexOf(PJ2.split("_")[1]);
		String nomPJ2 = PJ2.substring(debb, PJ2.length());
		System.out.println(nomPJ2);
		boolean verifPJ2 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl02')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ2, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ3 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl03')]")).getText();
		int debc = PJ3.indexOf(PJ3.split("_")[1]);
		String nomPJ3 = PJ3.substring(debc, PJ3.length());
		System.out.println(nomPJ3);
		boolean verifPJ3 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl03')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ3, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ4 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl04')]")).getText();
		int debd = PJ4.indexOf(PJ4.split("_")[1]);
		String nomPJ4 = PJ4.substring(debd, PJ4.length());
		System.out.println(nomPJ4);
		boolean verifPJ4 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl04')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ4, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String AJ = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']")).getText();
		int deb3 = AJ.indexOf(AJ.split("_")[1]);
		String nomAJ = AJ.substring(deb3, AJ.length()).trim();
		System.out.println(nomAJ);
		boolean verifAJ = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifAJ, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String inventaire = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']"))
				.getText();
		int deb4 = inventaire.indexOf(inventaire.split("_")[1]);
		String nomInventaire = inventaire.substring(deb4, inventaire.length()).trim();
		System.out.println(nomInventaire);
		boolean verifInventaire = driver
				.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']")).isDisplayed();
		Assertions.assertTrue(verifInventaire, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]"))
				.click();
		Thread.sleep(3000);

		// Vérification succès envoi
		String mess = "";

		
			// Première alerte
		alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(9000);
		try 
			{
			mess = alert.getText();
			}catch (UnhandledAlertException e) {
			mess = e.getAlertText();	
			System.out.println(mess);
			alert.accept();
			}
		
		Thread.sleep(1000);
	
		String mess1 = "Opération effectuée avec succès !";

		if (mess.equals(mess1)) {
			Thread.sleep(3000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENVOI : " + mess);
		}
		// Récupération du num de reqête
		Thread.sleep(1000);
		String numreq = driver
				.findElement(By.xpath("//td[contains(text(),'Envoyée')]//preceding-sibling::td/a[@class='numDossier']"))
				.getText();
		System.out.println(numreq);

		// Déconnexion
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici')]")).click();
		Thread.sleep(1000);

		// Authentification TR interne

		String identifiant1 = "lb";
		String mdp1 = "lb";

		driver.get(
				"https://www.telerecours.recette.juradm.fr/AuthentifierUtilisateur/AuthentifierUtilisateur.aspx?juridiction=TA75");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtIdentifiant']")).sendKeys(identifiant1);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(mdp1);
		driver.findElement(By.xpath("//a[@id='ibOk']/span[@class='button-text' and (text()='Valider')]")).click();
		Thread.sleep(1000);

		// Enregistrer la requête
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AC']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numreq + "')]")).click();
		String acteur = driver
				.findElement(By.xpath("//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td"))
				.getText();
		System.out.println(acteur);

		int deb = acteur.indexOf(acteur.split(" ")[1]);
		int fin = acteur.indexOf(acteur.split(" ")[2]);

		// vérification des informations transmises lors du dépôt
		String verifMat = driver.findElement(By.xpath("//span[@id='txtMatiereRequerant']")).getText();
		System.out.println(verifMat);
		String verifUrg = driver.findElement(By.xpath("//span[@id='txtUrgence']")).getText().toLowerCase();
		System.out.println(verifUrg);

		boolean verif1 = verifMat.equals(mat);
		if (verif1 == false) {
			throw new Exception("LA MATIERE EST DIFFERENTE" + verifMat + "/" + mat);
		} else {
			Thread.sleep(1000);
		}

		boolean verif2 = verifUrg.equals(urg);
		if (verif2 == false) {
			throw new Exception("L\'URGENCE EST DIFFERENTE : " + verifUrg + "/" + urg);
		} else {
			Thread.sleep(1000);
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

		// Rattachement

		boolean test = true;

		try {
			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).isDisplayed();
			test = true;
			System.out.println(test);
		} catch (NoSuchElementException l) {
			test = false;
			System.out.println(test);
		}

		if (test == false) {
			Thread.sleep(1000);
		} else {
			String avocatnom = acteur.substring(deb, fin).trim();
			System.out.println(avocatnom);
			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).click();
			Thread.sleep(1000);

			Set<String> onglet2 = driver.getWindowHandles();
			Iterator<String> it3 = onglet2.iterator();
			String parentWindow3 = it3.next();
			String childWindow3 = it3.next();
			driver.switchTo().window(childWindow3);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='searchNom']")).sendKeys(avocatnom);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value='Rechercher']")).click();
			Thread.sleep(1000);

			boolean boolSearch = false;

			if (boolSearch == false) {
				try {
					driver.findElement(By.xpath("//td[text()='Aucun résultat trouvé pour cette recherche.']"))
							.isDisplayed();
					System.out.println(boolSearch);
				} catch (NoSuchElementException s) {
					driver.findElement(By.xpath("//input[@name='cbxSel']")).click();

					driver.findElement(By.xpath("//input[@id='btRattacher']")).click();

					Thread.sleep(1000);
					alert.accept();
				}
			} else {
				driver.findElement(By.xpath("//input[@id='btCreerEntreeSkipper']")).click();
				alert.accept();
				Thread.sleep(1000);
				driver.switchTo().window(parentWindow3);
				Thread.sleep(1000);
			}
		}

		// Choix de la chambre
		WebElement chambre = driver.findElement(By.xpath("//select[@id='ddlChambre']"));
		Select select5 = new Select(chambre);
		String value4 = "11";
		select5.selectByValue(value4);
		Thread.sleep(1000);

		// Choix de la matière
		WebElement matiere1 = driver.findElement(By.xpath("//select[@id='DdlMatierePrincipale']"));
		Select select6 = new Select(matiere1);
		String value5 = "31";
		select6.selectByValue(value5);
		Thread.sleep(1000);

		WebElement matiere11 = driver.findElement(By.xpath("//select[@id='DdlMatiereSecondaire']"));
		Select select7 = new Select(matiere11);
		String value6 = "3101";
		select7.selectByValue(value6);
		Thread.sleep(1000);

		// Choix de la catégorie
		WebElement categ = driver.findElement(By.xpath("//select[@id='DdlCategorie']"));
		Select select8 = new Select(categ);
		String value7 = "AG";
		select8.selectByValue(value7);
		Thread.sleep(1000);

		// Sauvegarde de la requête
		WebElement element2 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='btSauvegarder']")).click();
		Thread.sleep(1000);
		
		
				//Première alerte
				alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(9000);
				String messa = "";
			
				//deuxième alerte				
				try
				{
				messa = alert.getText();
				}catch(UnhandledAlertException e) {
					messa = alert.getText();
					System.out.println(messa);
					alert.accept();
				}
			
			
		
		String mess2 = "Requête sauvegardée";

		if (messa.equals(mess2)) {
			Thread.sleep(1000);

		} else {
			throw new Exception("ERREUR LORS DE LA SAUVEGARDE : " + messa);
		}

		// Retour sur la page d'enregistrement
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numreq + "')]")).click();

		Thread.sleep(2000);

		// Vérification des fichiers
		boolean file = driver
				.findElement(By.xpath(
						"//a[@id='fileLinkFichierDecAttq_hplFichier' and (contains(text(),'" + nomDecAtt + "'))]"))
				.isDisplayed();// fichier décision attaquée
		Thread.sleep(1000);
		String nomFile = driver.findElement(By.xpath("//a[@id='fileLinkFichierDecAttq_hplFichier']")).getText();
		int start = nomFile.indexOf(nomFile.split("_")[1]);
		String nomFile00 = nomFile.substring(start, nomFile.length());
		Assertions.assertTrue(file, "ERREUR ! Le nom de fichier est différent : " + nomFile00);
		Thread.sleep(1000);

		boolean file1 = driver
				.findElement(By
						.xpath("//a[@id='fileLinkFichierCourrier_hplFichier' and (contains(text(),'" + nomReq + "'))]"))
				.isDisplayed();// fichier requête
		Thread.sleep(1000);
		String nomFile1 = driver.findElement(By.xpath("//a[@id='fileLinkFichierCourrier_hplFichier']")).getText();
		int start1 = nomFile1.indexOf(nomFile1.split("_")[1]);
		String nomFile11 = nomFile1.substring(start1, nomFile1.length());
		Assertions.assertTrue(file1, "ERREUR ! Le nom de fichier est différent : " + nomFile11);
		Thread.sleep(1000);

		boolean multipleFiles = driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
		multipleFiles = true;

		try {
			driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
			multipleFiles = true;
		} catch (NoSuchElementException a) {
			multipleFiles = false;
			System.out.println("PAS DE PIECES COMPLEMENTAIRES");
		}

		if (multipleFiles == true) {
			List<WebElement> files = driver.findElements(By.xpath("//a[contains(@id,'rptPiecesJointe_')]"));

			List<String> listA = new ArrayList<>();
			listA.add(PJ1);
			listA.add(PJ2);
			listA.add(PJ3);
			listA.add(PJ4);
			System.out.println(listA);

			int nbr1 = files.size();
			System.out.println(nbr1);

			// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
			// element2);
			Thread.sleep(1000);

			for (WebElement a : files) {
				System.out.println(a.getText());
				final boolean verifnom = listA.contains(a.getText());

				if (!verifnom) {
					throw new Exception("ERREUR SUR CE FICHIER : " + a.getText());
				}
			}
		}
		boolean file2 = driver
				.findElement(
						By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier' and (contains(text(),'" + nomAJ + "'))]"))
				.isDisplayed();// fichier AJ
		Thread.sleep(1000);
		String nomFile2 = driver.findElement(By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier']")).getText();
		int start2 = nomFile2.indexOf(nomFile2.split("_")[1]);
		String nomFile22 = nomFile2.substring(start2, nomFile2.length());
		Assertions.assertTrue(file2, "ERREUR ! Le nom de fichier est différent : " + nomFile22);
		Thread.sleep(1000);

		boolean file3 = driver.findElement(By.xpath(
				"//a[@id='fileLinkFichierInventaire_hplFichier' and (contains(text(),'" + nomInventaire + "'))]"))
				.isDisplayed();// fichier inventaire
		Thread.sleep(1000);
		String nomFile3 = driver.findElement(By.xpath("//a[@id='fileLinkFichierInventaire_hplFichier']")).getText();
		int start3 = nomFile3.indexOf(nomFile3.split("_")[1]);
		String nomFile33 = nomFile3.substring(start3, nomFile3.length());
		Assertions.assertTrue(file3, "ERREUR ! Le nom de fichier est différent : " + nomFile33);
		Thread.sleep(1000);

		// Enregistrer de la requête
		WebElement element3 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='btEnregistrer']")).click();
			//Première alerte
		
//		alert.accept();
		
		Thread.sleep(1000);
		String messb = "";
		String message = "";
				
			//Alerte
		try
		{
		alert.accept();
		Thread.sleep(8000);
		messb = alert.getText();
		}
		catch (UnhandledAlertException e) 
		{
		messb = e.getAlertText();
		int longueur = messb.length();
		System.out.println(longueur);
		System.out.println(messb);
		message = messb.substring(0, 32);
		}
		
		System.out.println(message);
		String mess3 = "Requête enregistrée dans Skipper";

		if (message.equals(mess3)) {
			Thread.sleep(1000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
		}
		System.out.println("Dépôt et enregistrement TA terminés");
		Thread.sleep(5000);

	}

	@Test
	public void depotReqCE() throws Exception {
		driver.get("https://www.telerecours.recette.conseil-etat.fr/");
		Thread.sleep(2000);
		String identifiant = "dai5mQr";
		String mdp = "Lhommeest2019*";

		// Authentification
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(mdp);
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();

		Thread.sleep(1000);
		System.out.println("Choix de juridiction CE");

		// Préparer une requête
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AB']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='btNewRequete']")).click();// Conseil d'Etat
		Thread.sleep(1000);

		// Ajouter un requérant
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_requerantAdd']/span[@class='button-text' and (text()='Ajouter')]"))
				.click();
		Thread.sleep(1000);

		WebElement civilite = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_requerantCivilite']"));
		Select select = new Select(civilite);
		select.selectByValue("1");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantNom']")).sendKeys("BRIVET");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantPrenom']")).sendKeys("karine");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantAdresse1']")).sendKeys("12 rue de Vanves");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantCodePostal']")).sendKeys("75014");
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_requerantVille']")).sendKeys("PARIS");
		Thread.sleep(1000);
		// Valider
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ui-button-text' and text()='Ajouter']")).click();

		// Urgence et Matière
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_RadioButtonUrgence_0']")).click();
		String urg = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_RadioButtonUrgence_0']"))
				.getAttribute("value");
		WebElement matiere = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlMatiere']"));
		Select select1 = new Select(matiere);
		String value = "06";
		select1.selectByValue(value);
		Thread.sleep(1000);
		String mat = driver
				.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlMatiere']//option[@value=" + value + "]"))
				.getText();

		// Décision attaquée
		WebElement saisine = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlSaisine']"));// Saisine
		String value1 = "10";
		Select select2 = new Select(saisine);
		select2.selectByValue(value1);
		String sais = driver
				.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlSaisine']//option[@value=" + value1 + "]"))
				.getText();
		Thread.sleep(1000);

		String date = "12/05/2021";
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_txtDateDecAttCAA']")).sendKeys(date);// Date

		String value2 = "11074";
		WebElement auteur = driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlAuteurDecAtt']"));// Auteur CAA
		// WebElement auteur =
		// driver.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlAuteurDecAtt']"));//Auteur
		// CE
		Select select3 = new Select(auteur);
		select3.selectByValue(value2);
		String juridiction = driver
				.findElement(By.xpath("//select[@id='Mstr_cpMain_ddlAuteurDecAtt']//option[@value=" + value2 + "]"))
				.getText();

		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadDecAttq_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Acte attaqué.pdf");
		Thread.sleep(1000);// Fichier

		// Requête
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadRequeteFichier_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.docx");
		Thread.sleep(1000);

		// Pièces complémentaires

		// System.out.println("je suis avant");
		WebElement element0 = driver.findElement(By.xpath("//span[@id='btAjouterFichiersContenantPiece']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element0);
		// System.out.println("je suis après");

		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\4 Jugement.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 1998 - 2012.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Dossier Expertise.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fileupload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Courrrier greffe.docx");
		Thread.sleep(2000);

		// AJ
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadAideJur_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Aide_Juridictionnelle.pdf");
		Thread.sleep(1000);

		// Inventaire
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_FileUploadInv_fileUpload']"))
				.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\L\'inventaire manuel.pdf");
		Thread.sleep(1000);

		// information par courriel
		driver.findElement(By.xpath(
				"//a[@id='Mstr_cpMain_ucContactDossier_personneCourrielAdd']/span[@class='button-text' and (text()='Ajouter')]"))
				.click();
		Thread.sleep(1000);
		Set<String> onglets = driver.getWindowHandles();
		int count1 = onglets.size();
		System.out.println("***" + count1 + "***" + onglets + "***");
		Iterator<String> it1 = onglets.iterator();
		String parentdWindow1 = it1.next();
		String childWindow = it1.next();
		driver.switchTo().window(childWindow);

		List<WebElement> qte = driver.findElements(By.xpath("//select[@id='ddlContactsASelectionner']/option"));

		int opt = qte.size();
		System.out.println(qte);
		boolean verif = opt > 0;
		System.out.println(opt);
		System.out.println(verif);

		if (verif == true) {
			// System.out.println("hello");
			WebElement name = driver.findElement(By.xpath("//select[@id='ddlContactsASelectionner']"));
			System.out.println(name);
			Select select4 = new Select(name);
//    				List<WebElement> allSelect = select4.getAllSelectedOptions();
//    				int nbr = allSelect.size();
//    				System.out.println(nbr);

			for (int i = 1; i <= opt; i++) {
				select4.selectByIndex(0);
				driver.findElement(By.xpath("//input[@id='btnFlecheDroite']")).click();
				Thread.sleep(1000);
			}

			driver.findElement(By.xpath("//input[@id='btnValider']")).click();
		} else {
			driver.findElement(By.xpath("//input[@id='btnAnnuler']")).click();
		}
		Thread.sleep(1000);
		driver.switchTo().window(parentdWindow1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='Mstr_cpMain_txtCourrielsComplementaires']"))
				.sendKeys("johan.agathine@conseil-etat.fr");

		// Conversion PDF
		driver.findElement(By.xpath(
				"//a[@id='Mstr_cpMain_zonePDF_btConvertir']/span[@class='button-text' and (text()='Convertir au format PDF')]"))
				.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);

		// Verification du fichier
		driver.findElement(By.xpath("//a[@id='Mstr_cpMain_FileUploadDecAttq_DlFileLink_hplFichier']")).click();
		Thread.sleep(5000);
		Set<String> onglets1 = driver.getWindowHandles();
		System.out.println(onglets1.size());
		Iterator<String> it2 = onglets1.iterator();
		String parentWindow2 = it2.next();
		String childWindow1 = it2.next();
		driver.switchTo().window(childWindow1);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow2);
		Thread.sleep(1000);
		Point dim = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).getLocation();
		System.out.println(dim);
		WebElement element = driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']"));
//    			JavascriptExecutor js = (JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    			js.executeScript("window.scrollBy()",dim);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Mstr_cpMain_zonePDF_chkVerifPDF']")).click();
		Thread.sleep(1000);

		// Envoyer
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btDeposerRequete2']/span[@class='button-text' and (text()='Envoyer')]"))
				.click();// Vérification
		Thread.sleep(2000);

		// Vérification des fichiers téléchargés
		String decAtt = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']"))
				.getText();
		int deb1 = decAtt.indexOf(decAtt.split("_")[1]);
		String nomDecAtt = decAtt.substring(deb1, decAtt.length()).trim();
		System.out.println(nomDecAtt);
		boolean verifdecAtt = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierDecAttq_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifdecAtt, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String req = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierRequete_hplFichier']")).getText();
		int deb2 = req.indexOf(req.split("_")[1]);
		String nomReq = req.substring(deb2, req.length()).trim();
		System.out.println(nomReq);
		boolean verifReq = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierRequete_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifReq, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ1 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl00')]")).getText();
		int deba = PJ1.indexOf(PJ1.split("_")[1]);
		String nomPJ1 = PJ1.substring(deba, PJ1.length());
		System.out.println(nomPJ1);
		boolean verifPJ1 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl00')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ1, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ2 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl01')]")).getText();
		int debb = PJ2.indexOf(PJ2.split("_")[1]);
		String nomPJ2 = PJ2.substring(debb, PJ2.length());
		System.out.println(nomPJ2);
		boolean verifPJ2 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl01')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ2, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ3 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl02')]")).getText();
		int debc = PJ3.indexOf(PJ3.split("_")[1]);
		String nomPJ3 = PJ3.substring(debc, PJ3.length());
		System.out.println(nomPJ3);
		boolean verifPJ3 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl02')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ3, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String PJ4 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl03')]")).getText();
		int debd = PJ4.indexOf(PJ4.split("_")[1]);
		String nomPJ4 = PJ4.substring(debd, PJ4.length());
		System.out.println(nomPJ4);
		boolean verifPJ4 = driver.findElement(By.xpath("//a[contains(@id,'Mstr_cpMain_rptPiecesJointe_ctl03')]"))
				.isDisplayed();
		Assertions.assertTrue(verifPJ4, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String AJ = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']")).getText();
		int deb3 = AJ.indexOf(AJ.split("_")[1]);
		String nomAJ = AJ.substring(deb3, AJ.length()).trim();
		System.out.println(nomAJ);
		boolean verifAJ = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierAideJur_hplFichier']"))
				.isDisplayed();
		Assertions.assertTrue(verifAJ, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		String inventaire = driver.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']"))
				.getText();
		int deb4 = inventaire.indexOf(inventaire.split("_")[1]);
		String nomInventaire = inventaire.substring(deb4, inventaire.length()).trim();
		System.out.println(nomInventaire);
		boolean verifInventaire = driver
				.findElement(By.xpath("//a[@id='Mstr_cpMain_fileLinkFichierInventaire_hplFichier']")).isDisplayed();
		Assertions.assertTrue(verifInventaire, "Erreur ! Pas de fichier");
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.findElement(
				By.xpath("//a[@id='Mstr_cpMain_btSignerEnvoyer']/span[@class='button-text' and (text()='Envoyer')]"))
				.click();
		Thread.sleep(3000);

		// Vérification succès envoi
		String mess = "";
		
		//alerte
		alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(9000);
		try 
		{
		mess = alert.getText();
		}catch (UnhandledAlertException e) {
		mess = e.getAlertText();	
		System.out.println(mess);
		alert.accept();
		}
	
		Thread.sleep(1000);

		String mess1 = "Opération effectuée avec succès !";

		if (mess.equals(mess1)) {
			Thread.sleep(3000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENVOI : " + mess);
		}
		// Récupération du num de reqête
		String numreq = driver
				.findElement(By.xpath("//td[contains(text(),'Envoyée')]//preceding-sibling::td/a[@class='numDossier']"))
				.getText();
		System.out.println(numreq);

		// Déconnexion
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici')]")).click();
		Thread.sleep(2000);

		// Authentification
		String identifiant1 = "fm";
		String mdp1 = "fm";

		driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtIdentifiant']")).sendKeys(identifiant1);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(mdp1);
		driver.findElement(By.xpath("//a[@id='ibOk']/span[@class='button-text' and (text()='Valider')]")).click();
		Thread.sleep(1000);

		// Enregistrer la requête
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AC']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numreq + "')]")).click();
		String acteur = driver
				.findElement(By.xpath("//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td"))
				.getText();
		System.out.println(acteur);

		int deb = acteur.indexOf(acteur.split(" ")[1]);
		int fin = acteur.indexOf(acteur.split(" ")[2]);

		// vérification des informations transmises lors du dépôt
		String verifMat = driver.findElement(By.xpath("//span[@id='txtMatiereRequerant']")).getText();
		System.out.println(verifMat);
		String verifUrg = driver.findElement(By.xpath("//span[@id='txtUrgence']")).getText().toLowerCase();
		System.out.println(verifUrg);

		boolean verif1 = verifMat.equals(mat);
		if (verif1 == false) {
			throw new Exception("LA MATIERE EST DIFFERENTE" + verifMat + "/" + mat);
		} else {
			Thread.sleep(1000);
		}

		boolean verif2 = verifUrg.equals(urg);
		if (verif2 == false) {
			throw new Exception("L\'URGENCE EST DIFFERENTE : " + verifUrg + "/" + urg);
		} else {
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//input[@value ='" + sais + "']"));
		System.out.println("trouvé : " + sais);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value ='" + date + "']"));
		System.out.println("trouvé : " + date);
		Thread.sleep(1000);
		String myXpath = driver.findElement(By.xpath("//input[@name ='txtAuteurDecAtt']")).getAttribute("value");
		boolean xpathTrue = juridiction.equals(myXpath);
		System.out.println(xpathTrue);
		System.out.println("trouvé : " + juridiction + "/" + myXpath);
		Thread.sleep(1000);

		// Rattachement

		boolean test = true;

		try {
			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).isDisplayed();
			test = true;
			System.out.println(test);
		} catch (NoSuchElementException l) {
			test = false;
			System.out.println(test);
		}

		if (test == false) {
			Thread.sleep(1000);
		} else {
			String avocatnom = acteur.substring(deb, fin).trim();
			System.out.println(avocatnom);
			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).click();
			Thread.sleep(1000);

			Set<String> onglet2 = driver.getWindowHandles();
			Iterator<String> it3 = onglet2.iterator();
			String parentWindow3 = it3.next();
			String childWindow3 = it3.next();
			driver.switchTo().window(childWindow3);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='searchNom']")).sendKeys(avocatnom);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value='Rechercher']")).click();
			Thread.sleep(1000);

			boolean boolSearch = false;

			if (boolSearch == false) {
				try {
					driver.findElement(By.xpath("//td[text()='Aucun résultat trouvé pour cette recherche.']"))
							.isDisplayed();
					System.out.println(boolSearch);
				} catch (NoSuchElementException s) {
					driver.findElement(By.xpath("//input[@name='cbxSel']")).click();

					driver.findElement(By.xpath("//input[@id='btRattacher']")).click();

					Thread.sleep(1000);
					alert.accept();
				}
			} else {
				driver.findElement(By.xpath("//input[@id='btCreerEntreeSkipper']")).click();
				alert.accept();
				Thread.sleep(1000);
				driver.switchTo().window(parentWindow3);
				Thread.sleep(1000);
			}
		}

		// Choix de la chambre
		WebElement chambre = driver.findElement(By.xpath("//select[@id='ddlSousSection']"));
		Select select5 = new Select(chambre);
		String value4 = "1";
		select5.selectByValue(value4);
		Thread.sleep(1000);

		// Choix de la matière
		WebElement matiere1 = driver.findElement(By.xpath("//select[@id='DdlMatierePrincipale']"));
		Select select6 = new Select(matiere1);
		String value5 = "06";
		select6.selectByValue(value5);
		Thread.sleep(1000);

		WebElement matiere11 = driver.findElement(By.xpath("//select[@id='DdlMatiereSecondaire']"));
		Select select7 = new Select(matiere11);
		String value6 = "060102";
		select7.selectByValue(value6);
		Thread.sleep(1000);

		// Choix de la catégorie
		WebElement categ = driver.findElement(By.xpath("//select[@id='DdlCategorie']"));
		Select select8 = new Select(categ);
		String value7 = "FI";
		select8.selectByValue(value7);
		Thread.sleep(1000);

		// Sauvegarde de la requête
		WebElement element2 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='btSauvegarder']")).click();
		Thread.sleep(1000);
		
		
				//Première alerte
				alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(9000);
				String messa = "";
			
				//deuxième alerte
				try
				{
				messa = alert.getText();
				}catch(UnhandledAlertException e) {
					messa = alert.getText();
					System.out.println(messa);
					alert.accept();
				}
			
			
		String mess2 = "Requête sauvegardée";

		if (messa.equals(mess2)) {
			Thread.sleep(1000);
			

		} else {
			throw new Exception("ERREUR LORS DE LA SAUVEGARDE : " + messa);
		}

		// Retour sur la page d'enregistrement
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + numreq + "')]")).click();

		Thread.sleep(2000);

		// Vérification des fichiers
		boolean file = driver.findElement(By.xpath("//a[@id='fileLinkFichierDecAttq_hplFichier' and (contains(text(),'" + nomDecAtt + "'))]")).isDisplayed();// fichier décision attaquée
		Thread.sleep(1000);
		String nomFile = driver.findElement(By.xpath("//a[@id='fileLinkFichierDecAttq_hplFichier']")).getText();
		int start = nomFile.indexOf(nomFile.split("_")[1]);
		String nomFile00 = nomFile.substring(start, nomFile.length());
		Assertions.assertTrue(file, "ERREUR ! Le nom de fichier est différent : " + nomFile00);
		Thread.sleep(1000);

		boolean file1 = driver
				.findElement(By
						.xpath("//a[@id='fileLinkFichierRequete_hplFichier' and (contains(text(),'" + nomReq + "'))]"))
				.isDisplayed();// fichier requête
		Thread.sleep(1000);
		String nomFile1 = driver.findElement(By.xpath("//a[@id='fileLinkFichierRequete_hplFichier']")).getText();
		int start1 = nomFile1.indexOf(nomFile1.split("_")[1]);
		String nomFile11 = nomFile1.substring(start1, nomFile1.length());
		Assertions.assertTrue(file1, "ERREUR ! Le nom de fichier est différent : " + nomFile11);
		Thread.sleep(1000);

		boolean multipleFiles = driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
		multipleFiles = true;

		try {
			driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
			multipleFiles = true;
		} catch (NoSuchElementException a) {
			multipleFiles = false;
			System.out.println("PAS DE PIECES COMPLEMENTAIRES");
		}

		if (multipleFiles == true) {
			List<WebElement> files = driver.findElements(By.xpath("//a[contains(@id,'rptPiecesJointe_')]"));

			List<String> listA = new ArrayList<>();
			listA.add(PJ1);
			listA.add(PJ2);
			listA.add(PJ3);
			listA.add(PJ4);
			System.out.println(listA);

			int nbr1 = files.size();
			System.out.println(nbr1);

			// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
			// element2);
			Thread.sleep(1000);

			for (WebElement a : files) {
				System.out.println(a.getText());
				final boolean verifnom = listA.contains(a.getText());

				if (!verifnom) {
					throw new Exception("ERREUR SUR CE FICHIER : " + a.getText());
				}
			}
		}
		boolean file2 = driver
				.findElement(
						By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier' and (contains(text(),'" + nomAJ + "'))]"))
				.isDisplayed();// fichier AJ
		Thread.sleep(1000);
		String nomFile2 = driver.findElement(By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier']")).getText();
		int start2 = nomFile2.indexOf(nomFile2.split("_")[1]);
		String nomFile22 = nomFile2.substring(start2, nomFile2.length());
		Assertions.assertTrue(file2, "ERREUR ! Le nom de fichier est différent : " + nomFile22);
		Thread.sleep(1000);

		boolean file3 = driver.findElement(By.xpath(
				"//a[@id='fileLinkFichierInventaire_hplFichier' and (contains(text(),'" + nomInventaire + "'))]"))
				.isDisplayed();// fichier inventaire
		Thread.sleep(1000);
		String nomFile3 = driver.findElement(By.xpath("//a[@id='fileLinkFichierInventaire_hplFichier']")).getText();
		int start3 = nomFile3.indexOf(nomFile3.split("_")[1]);
		String nomFile33 = nomFile3.substring(start3, nomFile3.length());
		Assertions.assertTrue(file3, "ERREUR ! Le nom de fichier est différent : " + nomFile33);
		Thread.sleep(1000);

		// Enregistrer de la requête
		WebElement element3 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='btEnregistrer']")).click();
		
		Thread.sleep(2000);
		String messb = "";
		String message = "";
		
		try
		{
		alert.accept();
		Thread.sleep(8000);
		messb = alert.getText();
		}
		catch (UnhandledAlertException e) 
		{
		messb =e.getAlertText();
		int longueur = messb.length();
		System.out.println(longueur);
		System.out.println(messb);
		message = messb.substring(0, 32);
		}
			

		System.out.println(message);
		String mess3 = "Requête enregistrée dans Skipper";

		if (message.equals(mess3)) {
			Thread.sleep(1000);

		} else {
			throw new Exception("ERREUR LORS DE L\'ENREGISTREMENT : " + message);
		}

		System.out.println("Dépôt et enregistrement CE terminés");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void déconnexion() throws Exception {
		Thread.sleep(1000);

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (UnhandledAlertException e) {
			System.out.println(e);
		}

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

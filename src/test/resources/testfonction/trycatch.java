package testfonction;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class trycatch {

	public static void main(String[] args) throws Throwable {
		
		//WebDriverManager.chromedriver().setup();
				DesiredCapabilities caps = new DesiredCapabilities();
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagathine\\Downloads\\chromedriver_win32\\chromedriver.exe");
				//caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				ChromeOptions options = new ChromeOptions();
				options.merge(caps);
				options.addArguments("--start-maximized");
				options.addArguments("--disable-popup-blocking");
				
				WebDriver driver = new ChromeDriver(options);
				
				
				String mess = "";
				Robot robot = new Robot();
		

		
		String identifiant1 = "lb";
		String mdp1 = "lb";
		
		//Authentification
		driver.get("https://www.telerecours.recette.juradm.fr/AuthentifierUtilisateur/AuthentifierUtilisateur.aspx?juridiction=CA75");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtIdentifiant']")).sendKeys(identifiant1);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(mdp1);
		driver.findElement(By.xpath("//a[@id='ibOk']/span[@class='button-text' and (text()='Valider')]")).click();
		Thread.sleep(1000);
		
		//Enregistrer la requête
		driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AC']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='numDossier']")).click();
		String acteur = driver.findElement(By.xpath("//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td")).getText();
		System.out.println(acteur);
		
		int deb = acteur.indexOf(acteur.split(" ")[1]);
		int fin = acteur.indexOf(acteur.split(" ")[2]);
		
//			//vérification des informations transmises lors du dépôt
//		String verifMat = driver.findElement(By.xpath("//span[@id='txtMatiereRequerant']")).getText();
//			System.out.println(verifMat);
//		String verifUrg = driver.findElement(By.xpath("//span[@id='txtUrgence']")).getText().toLowerCase();
//		System.out.println(verifUrg);
//		
//		boolean verif1 = verifMat.equals(mat);
//		if (verif1==false) {
//			throw new Exception("LA MATIERE EST DIFFERENTE" + verifMat+"/"+mat);
//		}else {
//			Thread.sleep(1000);
//		}
//		
//		boolean verif2 = verifUrg.equals(urg);
//		if (verif2==false) {
//			throw new Exception("L\'URGENCE EST DIFFERENTE : " + verifUrg+"/"+urg);
//		}else {
//			Thread.sleep(1000);
//		}
//		driver.findElement(By.xpath("//input[@value ='"+sais+"']"));
//		driver.findElement(By.xpath("//input[@value ='"+date+"']"));
//		driver.findElement(By.xpath("//input[@value ='"+juridiction+"']"));
//		Thread.sleep(1000);
		
		//Rattachement
		
		boolean test = true;
		 
			try {
				driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).isDisplayed();
				test = true;
			}
			catch(NoSuchElementException l){
				test = false;
				System.out.println(test);
			}
				
			
		if(test == false) {
			Thread.sleep(1000);
		}else {
			String avocatnom = acteur.substring(deb, fin).trim();
			System.out.println(avocatnom);
			driver.findElement(By.xpath("//a[@id='btnCreerRattachement']/span[2]")).click();
			
						Set<String> onglet2 = driver.getWindowHandles();
						Iterator<String> it3 = onglet2.iterator();
						String parentWindow3 = it3.next();
						String childWindow3 = it3.next();
						driver.switchTo().window(childWindow3);
						
			driver.findElement(By.xpath("//input[@id='searchNom']")).sendKeys(avocatnom);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value='Rechercher']")).click();
			Thread.sleep(1000);
				if(!(driver.findElement(By.xpath("//td[text()='Aucun résultat trouvé pour cette recherche.']")).isDisplayed())) {
					driver.findElement(By.xpath("//input[@name='cbxSel']")).click();
					driver.findElement(By.xpath("//input[@id='btRattacher']")).click();
					Thread.sleep(1000);
					Alert alert = driver.switchTo().alert();
					alert.accept();
				}else {
					driver.findElement(By.xpath("//input[@id='btCreerEntreeSkipper']")).click();
					Alert alert = driver.switchTo().alert();
					alert.accept();
					driver.switchTo().window(parentWindow3);
				}
		}
				
		//Choix de la chambre
			WebElement chambre =  driver.findElement(By.xpath("//select[@id='ddlChambre']"));
			Select select5 = new Select(chambre);
			String value4 = "1";
			select5.selectByValue(value4);
				
		//Choix matière
			WebElement matiere1 =  driver.findElement(By.xpath("//select[@id='DdlMatierePrincipale']"));
			Select select6 = new Select(matiere1);
			String value5 = "09";
			select6.selectByValue(value5);	
			
			WebElement matiere11 =  driver.findElement(By.xpath("//select[@id='DdlMatiereSecondaire']"));
			Select select7 = new Select(matiere11);
			String value6 = "0901";
			select7.selectByValue(value6);
			
		//Choix de la catégorie
			WebElement categ =  driver.findElement(By.xpath("//select[@id='DdlCategorie']"));
			Select select8 = new Select(categ);
			String value7 = "NO";
			select8.selectByValue(value7);
			
		//Sauvegarde de la requête 
			WebElement element2 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element2);
			
			driver.findElement(By.xpath("//input[@id='btSauvegarder']")).click();
			//Première alerte
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(2000);
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
				Thread.sleep(3000);

			} else {
				throw new Exception("ERREUR LORS DE LA SAUVEGARDE : " + messa);
			}
			
				//Retour sur la page d'enregistrement
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@class='numDossier']")).click();
				
				Thread.sleep(2000);
					
				
//			//Vérification des fichiers
//				boolean file = driver.findElement(By.xpath("//a[@id='fileLinkFichierDecAttq_hplFichier' and (contains(text(),'"+nomDecAtt+"'))]")).isDisplayed();//fichier décision attaquée
//				Thread.sleep(1000);
//				String nomFile = driver.findElement(By.xpath("//a[@id='fileLinkFichierDecAttq_hplFichier']")).getText();
//				int start = nomFile.indexOf(nomFile.split("_")[1]);
//				String nomFile00 = nomFile.substring(start , nomFile.length());
//				Assertions.assertTrue(file , "ERREUR ! Le nom de fichier est différent : " + nomFile00);
//				Thread.sleep(1000);
//						
//				boolean file1 = driver.findElement(By.xpath("//a[@id='fileLinkFichierCourrier_hplFichier' and (contains(text(),'"+nomReq+"'))]")).isDisplayed();//fichier requête
//				Thread.sleep(1000);
//				String nomFile1 = driver.findElement(By.xpath("//a[@id='fileLinkFichierCourrier_hplFichier']")).getText();
//				int start1 = nomFile1.indexOf(nomFile1.split("_")[1]);
//				String nomFile11 = nomFile1.substring(start1 , nomFile1.length());
//				Assertions.assertTrue(file1 , "ERREUR ! Le nom de fichier est différent : " + nomFile11);
//				Thread.sleep(1000);
//					
//					boolean multipleFiles = driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
//					multipleFiles = true;
//					
//					try {
//						driver.findElement(By.xpath("//a[contains(@id,'rptPiecesJointe_')]")).isDisplayed();
//						multipleFiles = true ;
//					}catch(NoSuchElementException a){
//						multipleFiles = false;
//						System.out.println("PAS DE PIECES COMPLEMENTAIRES");
//					}
//					
//							if(multipleFiles==true) {
//								List<WebElement> files = driver.findElements(By.xpath("//a[contains(@id,'rptPiecesJointe_')]"));
//								
//								List<String> listA = new ArrayList<>();
//								listA.add(PJ1);
//								listA.add(PJ2);
//								listA.add(PJ3);
//								listA.add(PJ4);
//								System.out.println(listA);
//								
//								int nbr1 = files.size();
//										System.out.println(nbr1);
//										
//										//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element2);
//										Thread.sleep(1000);
//										
//										for(WebElement a : files) {
//											System.out.println(a.getText());
//											final boolean verifnom = listA.contains(a.getText());
//			
//												if(!verifnom) {
//													throw new Exception("ERREUR SUR CE FICHIER : " + a.getText());
//														}
//													}
//												}
//				boolean file2 = driver.findElement(By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier' and (contains(text(),'"+nomAJ+"'))]")).isDisplayed();//fichier AJ
//				Thread.sleep(1000);
//				String nomFile2 = driver.findElement(By.xpath("//a[@id='fileLinkFichierAideJur_hplFichier']")).getText();
//				int start2 = nomFile2.indexOf(nomFile2.split("_")[1]);
//				String nomFile22 = nomFile2.substring(start2 , nomFile2.length());
//				Assertions.assertTrue(file2 , "ERREUR ! Le nom de fichier est différent : " + nomFile22);
//				Thread.sleep(1000);
//				
//				boolean file3 = driver.findElement(By.xpath("//a[@id='fileLinkFichierInventaire_hplFichier' and (contains(text(),'"+nomInventaire+"'))]")).isDisplayed();//fichier inventaire
//				Thread.sleep(1000);
//				String nomFile3 = driver.findElement(By.xpath("//a[@id='fileLinkFichierInventaire_hplFichier']")).getText();
//				int start3 = nomFile3.indexOf(nomFile3.split("_")[1]);
//				String nomFile33 = nomFile3.substring(start3 , nomFile3.length());
//				Assertions.assertTrue(file3 , "ERREUR ! Le nom de fichier est différent : " + nomFile33);
//				Thread.sleep(1000);
//				
			//Enregistrer de la requête 
				WebElement element3 = driver.findElement(By.xpath("//input[@id='btSauvegarder']"));	
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element3);	
					Thread.sleep(1000);
				
				driver.findElement(By.xpath("//input[@id='btEnregistrer']")).click();
				Thread.sleep(1000);
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
				
					Thread.sleep(3000);
					System.out.println("LE TEST EST UN SUCCES !!!");
					
					driver.quit();	
		
	}

}

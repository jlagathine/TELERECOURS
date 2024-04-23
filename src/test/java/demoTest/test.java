package demoTest;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.StopWatch;
import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import JDBC.JdbcClass;
import Juridictions.JurAnnulEnrgDocTr;
import Juridictions.JurDocTrFlechage;
import Juridictions.JurTelechargementTr;
import browser.Navigateur;
import captureTool.CaptureIcone;
import fonctionnalites.MicroFonctions;
import io.github.rafal.laskowski.wait.ExpectedCondition;
import io.github.rafal.laskowski.wait.Wait;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;
import trc.Trc_Compte_Suppression;



public class test {

	static WebDriver driver;
	static WebElement element;
	static DesiredCapabilities caps;
	static String browserName;
	static String choixJur;
	static List<WebElement> elements;;
	static String username;
	static String password;
	static String myXpath;
	static String parentWindow;
	static String childWindow;
	static boolean verif;
	static String identifiant;
	static String mdp;
	static String nom;
	static String name;
	static String mail;
	static String cnbf;
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
	static Integer RPVA_AVOCAT_ID;
	static int ANJ_AEXID;
	static String nomMem;
	static String nomInv;
	static String dossier;
	static String url;
	static String dossier1;
	static String dossier2;
	static List<String> fil3 = new ArrayList<>(); 
	static List<String> fil2 = new ArrayList<>();
	static List<String> fil1 = new ArrayList<>(); 
	static List<String> fil = new ArrayList<>(); 
	static List<Integer> nbr = new ArrayList<Integer>();
	static List<String> str = new ArrayList<>();
	static List<String> str1 = new ArrayList<>();
	

	public static void main(String[] args) throws Throwable {

//		nom = "telerecours";
//		mdp = "telerecours";
//			jdbcClass.conDBTR(nom, mdp);
			
			
			
//			
//			jdbcClass.test();
//		dossier = "2201305";
		
//		 browserName = "chrome";
//		   driver = navigateur.choixBrowser(browserName);
//		   System.out.println(driver);
			
//		choixJur = "Tribunal";
//		jurTelechargementTr.actIntConnexion(driver, element, choixJur);
//		
//		microfonctions.rechercheSimple(driver, element, dossier);
//		
//		microfonctions.consultationOngletHistoDossier(driver, element);
//		
//		microfonctions.telechgtDossierOngletHisto(driver, element);
		
//		jdbcClass.conDBTRC();
//		CreationCompte.delUser();
//		jdbcClass.resSqlTrc();
//		jdbcClass.listTable();
//		jdbcClass.listColumns();
		
//		 microfonctions.accueilPageTrc(driver, element);
//		 
//		 
//		 String myXpath = "//a[contains(text(),'passe')]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 Thread.sleep(1200);
//		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",  mesFonctions.objet(driver,  myXpath));
//		 mesFonctions.objet(driver,  myXpath).click();//pas de clic réalisé---à corriger
//		 System.out.println("Click sur le lien mot de passe oublié");
		 
//		 mesFonctions.objet(driver,  myXpath).click();
//		 System.out.println("Le mail est selectionné");
		
//		username = "zaire@yopmail.com";
//		password = "Lhommeest2019*";
//		microfonctions.accueilPageTrcInt(driver, element);
//		microfonctions.AuthentificationTrc(driver, element, username, password);
		
		
//		for(int i = 1; i<=2 ; i++) {
//			myXpath = "//button//span[contains(text(),'session')]";
//			mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//			mesFonctions.objet(driver,  myXpath).click();
//			System.out.println("nombre d'apparition de la modale : "+i);
//			Thread.sleep(3000);
//			String myXpath = "//a//span[text()=\"Mon Compte\"]";
//			mesFonctions.objet(driver,  myXpath).click();
//		}
	
//		driver.get("https://avocats-ng.int1.telerecours.fr/");
//		System.out.println("Connection réussie");
//		
//		username = "9";
//		password = "tr2019";
//		
//		//Authentification
//		myXpath = "//input[@id='Username']";
//		mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		microfonctions.AuthentificationTaCaaCeExt(driver, element, username, password);
//		Thread.sleep(2000);
//		System.out.println("Authentification réussie");
//		
//		myXpath = "//a[text()='https://www.telerecours.int1.juradm.fr']";
//		mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		mesFonctions.objet(driver,  myXpath).click();
//		
//		// Choix de la juridiction
//		microfonctions.choixJuridictionCAA(driver, element);
//		microfonctions.accesDepotReq(driver, element, choixJur);
//		
//		//redirection vers TR-AVO
//		myXpath = "//a[@id='pavoLink']";
//		mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		mesFonctions.objet(driver,  myXpath).click();
//		System.out.println("Redirection vers TR-AVO");
//		
//		//Accès page TR AVO
//		myXpath = "//h1[@class='travo-page-title']";
//		mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		System.out.println("Redirection vers TR-AVO réussi");
//		
//		//Consultation d'un dépôt
//		myXpath = "//div[@class='card-edit']";//"//a[@id='dropdownPageList']";//dropdownPageList1 en CE
//		mesFonctions.objet(driver,  myXpath).click();
//		System.out.println("clic sur le menu de la card");
		
		   
	
//		   driver.get("https://avocats.telerecours.fr/ ");
//		   
//		   String myXpath1 = "//input[@id='Username']";
//		   String myXpath2 = "//input[@id='password-field']";
//		   String myXpath3 = "//button[@id='login-submit']";
//		   
//		   
//		   url = "https://www.telerecours.int1.juradm.fr/ ";
//		   driver.get(url);
//		   identifiant = "decBl5t";
//		   mdp = "Conseildétat52546*";
//		   dossier = "2300042";
//		   
//		  
//		   mesFonctions.objet(driver,  myXpath1).sendKeys(identifiant);
//		   mesFonctions.objet(driver,  myXpath2).sendKeys(mdp);
//		   mesFonctions.objet(driver,  myXpath3).click();
//		   System.out.println("Validation des identifiants...");
		   
	

	
//	name = "Rouafa";
//	mail = "rouafa@yopmail.com";
//	System.out.println(name+"  "+mail);
//	jdbcClass.conDBTRC(driver);
//	jdbcClass.deleteUserTrc(name, mail);
		
		   
		   
//		 microfonctions.AuthentificationTaCaaCeExt(driver, identifiant, mdp);  
//		 microfonctions.choixJuridictionCAA(driver);
//		 
//		 myXpath = "//td[@id='Entete1_MenuActeur1_im1_AD']";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 
//		 myXpath = "//a[@id='hlPadm']";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 Thread.sleep(3000);
//		 
//		 mesFonctions.transitWindow(driver, 2);
//		 myXpath = "//a[contains(text(),\"Dossiers\")]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 System.out.println("ici problème");
//		 
//		 myXpath = "//span[contains(text(),\""+dossier+"\")]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 
//		 myXpath = "//button[contains(text(),\" Envoyer un document \")]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 
//		 myXpath = "//div[contains(text(),\"Pièces\")]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 
//		 myXpath = "//div[@class='ng-value-container']";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 
//		 myXpath = "(//div[@class='ng-option ng-star-inserted'])[1]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 mesFonctions.objet(driver,  myXpath).click();
//		 Thread.sleep(1000);
		 
		 
//		 myXpath = "(//div[@class='paju-file-input-button ng-star-inserted']//button)[1]";
//		 mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", mesFonctions.objet(driver,  myXpath));
////		 mesFonctions.objet(driver,  myXpath).click();
//		 Thread.sleep(1000);
		 
//		 myXpath = "//paju-file-input[@class='paju-file-input ng-untouched ng-pristine ng-invalid']";
//		 myXpath = "//input[@type='file']";
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myXpath))).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
//		 System.out.println("arrivé!!!!");

//		 mesFonctions.transitWindow(driver, 2);
		  
//		 actions.moveToElement(mesFonctions.objet(driver,  myXpath)).click(); //sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
//		 String filePath = System.getProperty("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
//		 System.load("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
//		 Actions actions = new Actions(driver);
		 
//		 myXpath = "//div[@class='paju-file-input-drop ng-star-inserted']";
//		 actions.click(mesFonctions.objet(driver,  myXpath)).click().perform();
//		 Thread.sleep(2000);
//		 actions.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx");
//		 actions.sendKeys(mesFonctions.objet(driver,  myXpath),"C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx", Keys.ENTER).perform(); 
//		 actions.dragAndDrop(mesFonctions.objet(driver,  myXpath), mesFonctions.objet(driver,  myXpath));
		 
//		 System.out.println("arrivé!!!!");
		   
//		   "C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 1.docx"
		
//		//positionnnement souris
//	    System.out.println("10 secondes pour cliquer sur l'icone choisie");
//	    Thread.sleep(10000);
//	    System.out.println("le temps imparti est terminé");
//	    PointerInfo pointer = MouseInfo.getPointerInfo();
//	    Point point = pointer.getLocation();
//	    int v = (int) point.getX();
//	    int w = (int) point.getY();
//	    System.out.println(v+" , "+w);
//	    
//	    int x = 0;
//	    int y = 0;
//	    Robot bot = new Robot();
//        bot.mouseMove(x, y);
		
//		String mail = "bba@yopmail.com";
//		jdbcClass.conDBTR("tr2_caa75", "tr2_caa75", "rec");
//		jdbcClass.conDBTRC("rec");
//		int chf = 10;
//		jdbcClass.change_date_mois_creation_compteTRC(mail, chf);
//		System.out.println("La date de création du compte a été modifiée....."+mesFonctions.extractCurrentHeure()+"\r");
//		jdbcClass.modification_date_dossier(mail, 5);
//		jdbcClass.modification_date_derniere_connexion_compteTRC(mail, chf);
//		jdbcClass.verification_etat_req_TRC_Async(mail);
		
//		java.sql.Date date = java.sql.Date.valueOf("2022-01-10");
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.add(Calendar.MONTH, 2);
//		System.out.println(new java.sql.Date(c.getTimeInMillis()));
		
		nom = "Monsieur\r\n"
				+ "DELBOSCO\r\n"
				+ "45 rue d'Alésia\r\n"
				+ "75014 PARIS";
		
		System.out.println(nom);
//		String caractSpec = " ";
		
		int fin = nom.indexOf(nom.split("\r\n")[2]);
		int deb = nom.indexOf(nom.split("\r\n")[1]);
		String acteur = nom.substring(deb, fin).trim();
		System.out.println("\r"+acteur);
			
	}
			
}
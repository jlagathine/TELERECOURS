package demoTest;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import JDBC.JdbcClass;
import browser.Navigateur;
import captureTool.CaptureIcone;
import document.trDoc;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;
import requete.TR_Req;
import skipper.Navigation_Sk_Ajout_Mesure;

public class brouillon {

	static String browserName;
	static WebDriver driver;
	static WebElement element;
	static String ID;
	static String mdp;
	static String myXpath;
	static BufferedImage image;
	static String fileImage;
	static String result;
	static String nom;
	static Rectangle bounds;
	static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>  coords;
		
	public static void main(String[] args) throws Throwable {
		
		browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   
		driver.get("https://www.telerecours.recette.juradm.fr/");//attention URL
//		ID = "aja1XOV";
//		mdp = "Conseiletat123456*";
//		
//		MicroFonctions.AuthentificationTaCaaCeExt(driver, ID, mdp);
//		MicroFonctions.choixJuridictionTA(driver);
//		
//		myXpath = "//td[@id='Entete1_MenuActeur1_im1_AB']";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		MesFonctions.objet(driver, myXpath).click();
//		System.out.println("Page TR legacy");
//		
//		myXpath = "//a[@id='pavoLink']";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		MesFonctions.objet(driver, myXpath).click();
//		System.out.println("clic pavoLink");
//		
//		myXpath = "//button[text()=\" Déposer une requête \"]";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		MesFonctions.objet(driver, myXpath).click();
//		System.out.println("clic \"Déposer une requête\"");
//		
//		myXpath = "//a[text()=\"Objet de la requête\"]";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		MesFonctions.objet(driver, myXpath).click();
//		System.out.println("clic \"Objet de la requête\"");
//		
//		myXpath = "//pavo-select-item-form[@ng-reflect-title='Matière']//div";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		MesFonctions.objet(driver, myXpath).click();
//		System.out.println("clic \"Sélectionner\"");
//		
//		myXpath = "//pavo-select-item-form[@ng-reflect-title='Matière']//div[@class='ng-option'][5]";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		MesFonctions.objet(driver, myXpath).click();
//		System.out.println("clic \"Collectivités locales et établissements publics locaux\"");
//		
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\notePad-Window.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		MesFonctions.doubleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
//		
//		Thread.sleep(1500);
//		Keyboard.maStringToKeyboard("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Acte attaque.pdf");
//		Thread.sleep(1000);
//		
//		fileImage = "C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\croix - Notepad++.png";
//		coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
//		coords = MesFonctions.waitObject(fileImage);
//		MesFonctions.singleClick(coords.getFirst().getFirst() + coords.getSecond().getFirst()/2, coords.getFirst().getSecond() + coords.getSecond().getSecond()/2);
		
//		JdbcClass.conDBTR("telerecours", "telerecours", "rec");
		
//		String sr = "Le_Memoire_5_-_Copie_6_1200143129.pdf";
//		
//				System.out.println(sr.split("_")[6]);
//			String str = sr.substring(sr.indexOf(sr.split("_")[6]), sr.indexOf("."));
//		System.out.println(str);
		
		//formatter un fichier de log ligne par ligne en conservant l'information du numéro TR
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jagathine\\Desktop\\test.txt"));
//		try {
//
//			String line = br.readLine().trim();
//		
//			while(line != null) {
////				System.out.println(line.replace(line, "'"+line+"',"));
//				System.out.println(line.replace(",","', '"));
//				line = br.readLine();
//			}
//		} finally {
//			br.close();
//		}	
		
		driver.get("https://google.com");
	}
}




package lesFonctions;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import captureTool.CaptureIcone;
import myKeyboard.Keyboard;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class MesFonctions {
	
	
		//Fonction alert
		public static Alert PopUp (WebDriver driver, Alert alert) {
			alert = driver.switchTo().alert();
			return null;
		}
		
		static public String sansAccents (String accent) {
			String strTemp = Normalizer.normalize(accent, Normalizer.Form.NFD);
	        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	        return pattern.matcher(strTemp).replaceAll("");
		}
		
		//Fonction de changement de window 1/3
		public static String childWindow (WebDriver driver) {
			Set<String> tab = driver.getWindowHandles();
			Iterator<String> it = tab.iterator();
			String onglet = it.next();
			String onglet1 = it.next();
			return onglet1;
		}

		//Fonction de changement de window 2/3
		public static String parentWindow (WebDriver driver) {
			Set<String> tab = driver.getWindowHandles();
			Iterator<String> it = tab.iterator();
			String onglet2 = it.next();
			return onglet2;
		}
		
		//Fonction de changement de window 3/3
		public static String getWindow(WebDriver driver, int tr) {
			Set<String> tab = driver.getWindowHandles();
			Iterator<String> it = tab.iterator();
		  
			String onglet="";
		   
		   	for(int i=1 ; tr>=i; i++){
			   onglet = it.next();
			   System.out.println(onglet);
		   }
		   return onglet;
		}
			
		//fonction de recherche d'élément
		public static WebElement objet (WebDriver driver, String myXpath) {
			WebElement element =  driver.findElement(By.xpath(myXpath));
			return element;
		}
		
		//fonction de recherche d'élément
		public static WebElement objetcss (WebDriver driver, WebElement element, String css) {
			element = driver.findElement(By.cssSelector(css));
			return element;
		}

		//fonction de recherche d'éléments
		public static List<String> fichier (WebDriver driver, List<WebElement> elements, String myXpath, String caractSpec) {
		elements = driver.findElements(By.xpath(myXpath));
		List<String> files = new ArrayList<>();
		for(WebElement a : elements) {
			String lesFiles = a.getText();
			int deb1 = lesFiles.indexOf(lesFiles.split(caractSpec)[1]);
			files.add(lesFiles.substring(deb1, lesFiles.length()).trim());
			//System.out.println(files);
			}
		return files;
		}
		
		//fonction de recherche d'éléments
		public static List<WebElement> objets (WebDriver driver, String myXpath) {
		List<WebElement> elements = driver.findElements(By.xpath(myXpath));
		return elements;
		}
		
	
		//fonction d'attente de chargement 1
		public static WebDriverWait waiting1 (WebDriver driver, Duration duree) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
		return null;	
		}
		
		//fonction d'attente de chargement 2
		public static WebDriverWait waiting2 (WebDriver driver, String myXpath, Duration duree) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myXpath)));
		return null;	
	}
		
		//fonction d'attente de chargement 2
		public static WebDriverWait waiting3 (WebDriver driver, String tag, Duration duree) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(190));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tag)));
		return null;
		}
	
		//fonction de séléction d'option par valeur
		public static Select selection(WebDriver driver, String myXpath, String value) {
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		driver.findElement(By.xpath(myXpath));
		Select select = new Select(objet(driver, myXpath));
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		select.selectByValue(value);
		return select;
	}
		
		//fonction de séléction d'option par valeur
		public static Select selection_byIndex(WebDriver driver, String myXpath, int index) {
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		driver.findElement(By.xpath(myXpath));
		Select select = new Select(objet(driver, myXpath));
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		select.selectByIndex(index);
		return select;
			}
		
		//fonction de séléction d'option pour multiples valeurs
		public static Select selection1(WebDriver driver, String myXpath, List<String> value) {
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		driver.findElement(By.xpath(myXpath));
		Select select = new Select(objet(driver, myXpath));
		for(String v : value) {
			System.out.println(value);
		select.selectByValue(v);}
		return select;
	}
	
		//fonction de vérification d'élément présent
		public static boolean isElementPresent(WebDriver driver, String myXpath, boolean verif) throws Throwable {
		try {Thread.sleep(500);
			verif = driver.findElement(By.xpath(myXpath)).isDisplayed();
			System.out.println("IS DISPLAYED : "+verif);
			return verif;
		}catch (NoSuchElementException l) {
			Thread.sleep(500);
			System.out.println("IS DISPLAYED : "+verif);
			return verif;
		}
		
	}
		
		//fonction de création de nom
		public static String leNom(WebDriver driver, String myXpath, String caractSpec) {
			
			String nom = driver.findElement(By.xpath(myXpath)).getText().trim();
			int deb = nom.indexOf(nom.split(caractSpec)[1]);
			String nomNew = nom.substring(deb , nom.length()).trim();
		
		return nomNew;
	}
		
		//Fonction de getText	
		public static String leTexte (WebDriver driver, String texte, String myXpath) {
		texte = driver.findElement(By.xpath(myXpath)).getText();
		return texte;
	}
		
//		//Fonction de string générique
//		private String numReq;
//
//		public mesFonctions(String numReq) {
//			super();
//			this.numReq = numReq;
//		}
//
//		public String getNumReq() {
//			return numReq;
//		}
//
//		public String setNumReq(String numReq) {
//			return this.numReq = numReq;
//		}
		
		//Compter et afficher un liste d'objets non-formatés
		public static List<String> nbrEtNomsObjetBrut (WebDriver driver, String myXpath) throws InterruptedException{
		List<WebElement> lesfichiers = driver.findElements(By.xpath(myXpath));
		  int nbr = lesfichiers.size();
		  System.out.println("Le nombre de fichiers trouvés est : "+nbr);
		  Thread.sleep(1000);
		  List<String> fichiers = new ArrayList<>();
		  for(WebElement e:lesfichiers) {
			  Thread.sleep(500);
			  fichiers.remove(",");
			  fichiers.add(StringUtils.stripAccents(e.getText()));
		  }
//		  System.out.println(fichiers);
		   return fichiers;
		}
		
		public static JavascriptExecutor addTab (WebDriver driver) {
			((JavascriptExecutor)driver).executeScript("window.open();");
			
			return null;
		}
		
		public static JavascriptExecutor clickOn (WebDriver driver, String myXpath) {
			WebElement element =  MesFonctions.objet(driver, myXpath);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			return null;
		}
		
		public static String verifyPresenceOfElement (WebDriver driver, String myXpath, String texte) throws Throwable {
			
			String str = driver.findElement(By.xpath(myXpath)).getText().trim();
				boolean verif = str.contains(texte);
			if(verif == true) {
				Thread.sleep(1000);
			}
			else {
				System.err.println("L'element n'est pas présent : "+str+" / " +texte);
			}
			return str;
		}
		
		public static String verifyPresenceOfAttribute (WebDriver driver, String myXpath, String nomAttr) throws Throwable {
				Thread.sleep(1000);
			String str = driver.findElement(By.xpath(myXpath)).getAttribute("value").trim();
				boolean verif = str.contains(nomAttr);
			if(verif == true) {
				Thread.sleep(1000);
			}
			else {
				System.err.println("L'element n'est pas présent : "+str+" / " +nomAttr);
			}
			return str;
		}
		
		public static String verifyPresenceOfAttribute1 (WebDriver driver, String myXpath, String nomAttr, String valueAttr) throws Throwable {
			Thread.sleep(1000);
		String str = driver.findElement(By.xpath(myXpath)).getAttribute(nomAttr).trim();
			boolean verif = str.contains(valueAttr);
		if(verif == true) {
			Thread.sleep(1000);
		}
		else {
			System.err.println("L'element n'est pas présent : "+str+" / " +nomAttr);
		}
		return str;
	}
		
		public static Actions echappe (WebDriver driver) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).perform();
			return null;
		}
		
		public static String formatNameObject (String name, String caractSpec, int index) throws Throwable {
			Thread.sleep(1000);
			int deb = name.indexOf(name.split(caractSpec)[index]);
			String nomNew = name.substring(deb , name.length()).trim();
			Thread.sleep(1000);
			System.out.println(nomNew);
			return nomNew;
		}
		
		public static Action souriOver (WebDriver driver, String myXpath) {
			Actions action = new Actions(driver);
			WebElement element  = MesFonctions.objet(driver, myXpath);
			action.moveToElement(element).build().perform();
			
			return null;
		}
		
		
		public static String time (String str, String pattern) throws ParseException {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date date = simpleDateFormat.parse(str);
			String dt = simpleDateFormat.format(date);
			return dt;
		}
		
		public static String currentTime () throws ParseException {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm");
			Date date = new Date(System.currentTimeMillis());
			return formatter.format(date);
		}
		
		public static boolean isAlertPresent (WebDriver driver) {
			if(MesFonctions.waiting1(driver, Duration.ofSeconds(3))!=null) {
			return true;}
			else {
			return false;
			}
		}
		
		public static String transitWindow(WebDriver driver, int nbr){
			//String url = driver.getCurrentUrl();
			String onglet = MesFonctions.getWindow(driver, nbr);
			driver.switchTo().window(onglet);
			
			return null;
		}
		
		public static String loadingTime(WebDriver driver, String myXpath) throws Throwable {
			//Estimation du temps de chargement d'un élément ou objet
			String pattern = "ss.SSS";
		    String pattern1 = "mm:ss.SSS";
		    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		    SimpleDateFormat sdf1 = new SimpleDateFormat(pattern1);
			
			long starttime = System.currentTimeMillis();
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			long stoptime = System.currentTimeMillis();
			long logintime = stoptime -  starttime;
			Date loadingPage = new Date(logintime);
			   
			   
			   if(logintime>999){
				   System.out.println("Temps de chargement de la page " + sdf1.format(loadingPage)+"ms");
				   return sdf1.format(loadingPage); 
			   }else {
				   System.out.println("Temps de chargement de la page  " + sdf.format(loadingPage)+"ms");
				   return sdf.format(loadingPage);
			   }

		}
		
		
		
		public static String extractCurrentDate() {
			//récupération de la date du jour
			String pattern = "dd/MM/yyyy";
			Date date2 = new Date(System.currentTimeMillis());
			DateFormat sdf = new SimpleDateFormat(pattern);
			String dateActuelle = sdf.format(date2);
			
			return dateActuelle;
		}
		
		public static String extractCurrentHeure() {
			//récupération de l'heure actuelle
			String pattern = "HH:mm:ss.SSS";
			Date date2 = new Date(System.currentTimeMillis());
			DateFormat sdf = new SimpleDateFormat(pattern);
			String dateActuelle = sdf.format(date2);
			
			return dateActuelle;
		}
		
		//Rendre visible un élément en haut de page
		public static Object goToUp(WebDriver driver, String myXpath) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", MesFonctions.objet(driver, myXpath));
			return null;
		}
		
		//Rendre visible un élément en haut de page
		public static Object goToDown(WebDriver driver, String myXpath) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MesFonctions.objet(driver, myXpath));
			return null;
		}
		
		//capture d'écran 
		public static BufferedImage capturePluscreationFichier(String str) throws AWTException, IOException  {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);

	    File file = new File(str);
	    ImageIO.write(capture, "png", file );
	    
	    return capture;
		}
		
		public static String rewriteDigits(int number, int nbDigits){
		    String res = "";
		    res += number;
		    while(res.length() < nbDigits){
		       res = "0".concat(res);
		    }
		    return res;
		}
		
		public static Pair<Integer, Integer> doubleClick(int x, int y) throws AWTException {
			Pair<Integer, Integer> coords = new Pair<Integer, Integer>(x, y);
	        Robot bot = new Robot();
	        bot.mouseMove(x, y);
	        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	        
	        return coords;
		}
		
		public static Pair<Integer, Integer> singleClick(int x, int y) throws AWTException {
			Pair<Integer, Integer> coords = new Pair<Integer, Integer>(x, y);
	        Robot bot = new Robot();
	        bot.mouseMove(x, y);
	        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	        
	        return coords;
		}
		
		
		public static String OCR_decryptage(BufferedImage image) throws TesseractException, IOException, AWTException {
		//Création de l'objet
//	    	BufferedImage image = ImageIO.read(url);
	    Tesseract tessInt = new Tesseract();
	    //paramétrage de la langue
        tessInt.setDatapath("C:\\Users\\jagathine\\Tesseract-OCR\\tessdata");
        tessInt.setLanguage("fra");
        //transformation du mot en string
        String result = tessInt.doOCR(image);
        System.out.println(result);
    	return result;
	    }
		
		public static BufferedImage screenshot(Rectangle bounds) throws TesseractException, IOException, AWTException, Throwable {
		//cature de l'emplacement
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(bounds);		
		return image;
		}
		
		public static Rectangle setRectangle(String fileImage) throws IOException, AWTException, InterruptedException{
		//Récupération des coordonnées
		Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		coords = MesFonctions.waitObject(fileImage);
		
		//Définition des bornes du rectangle 
		Rectangle bounds = new Rectangle(coords.getFirst().getFirst(), coords.getFirst().getSecond(), coords.getSecond().getFirst(), coords.getSecond().getSecond());
		System.out.println(bounds);
		
		return bounds;
		
		}
		
		//Definition des coordonnées du rectangle
		public static Rectangle setNewRectangle(int coordx, int coordy, int dimx, int dimy) {
			Rectangle bounds = new Rectangle(coordx, coordy, dimx, dimy);	
			return bounds;
		}
		
		//Fonction d'attente d'affichage d'une image
		public static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> waitObject(String fileImage) throws InterruptedException, IOException, AWTException {
			
		Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords1 = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
		Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords = new Pair<Pair<Integer,Integer>, Pair<Integer,Integer>>(new Pair<>(-1, -1), new Pair<>(0,0));
		long t = System.currentTimeMillis();
		long end = t+190000;
		
		while(System.currentTimeMillis() < end && coords.equals(coords1)){
			System.err.println("l'élément n'est pas encore présent : "+coords+"....."+coords1);
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
		}
		Thread.sleep(50);
		System.out.println("l'élément est affiché...."+MesFonctions.extractCurrentHeure());
		return coords;	
		}
		
		//Déplacement de la souris en un point x,y
		public static void mouveSouris(int x, int y) throws AWTException{
			Robot robot = new Robot();
			robot.mouseMove(x, y);
		}
		
		//Lire le message d'un champ dans SKIPPER à chaque déplacement du curseur
		public static Object OCR_champ_text_down(String fileImage, Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords, Rectangle bounds, 
				BufferedImage image, String result, String nom, Integer X, int x, int y) throws Throwable {
			//définir un rectangle d'observation
			coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
			coords = MesFonctions.waitObject(fileImage);
			bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+X, coords.getFirst().getSecond(), x, y);
			image = MesFonctions.screenshot(bounds);
			result = MesFonctions.OCR_decryptage(image);
			
			//Accéder à la liste des destinataires
			while(!result.contains(nom)) {
				//Déplacement du curseur
				Keyboard.keyBoard(KeyEvent.VK_DOWN);
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+X, coords.getFirst().getSecond(), x, y);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				Thread.sleep(50);
			}
			return null;
		}
		
		//Lire le message d'un champ dans SKIPPER à chaque déplacement du curseur
			public static Object OCR_champ_text_up(String fileImage, Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> coords, Rectangle bounds, 
					BufferedImage image, String result, String nom, Integer X, int x, int y) throws Throwable {
				//définir un rectangle d'observation
				coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
				coords = MesFonctions.waitObject(fileImage);
				bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+X, coords.getFirst().getSecond(), x, y);
				image = MesFonctions.screenshot(bounds);
				result = MesFonctions.OCR_decryptage(image);
				
				//Accéder à la liste des destinataires
				while(!result.contains(nom)) {
					//Déplacement du curseur
					Keyboard.keyBoard(KeyEvent.VK_UP);
					coords = (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>) CaptureIcone.capture(fileImage);
					bounds = MesFonctions.setNewRectangle(coords.getFirst().getFirst()+X, coords.getFirst().getSecond(), x, y);
					image = MesFonctions.screenshot(bounds);
					result = MesFonctions.OCR_decryptage(image);
					Thread.sleep(50);
				}
				Thread.sleep(300);
				return null;
				}
	
}


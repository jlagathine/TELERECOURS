package browser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import captureTool.My_SreenShot;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class NavigaChromHeader {
	
	static DesiredCapabilities caps;
	static WebDriver driver;
	
	public static WebDriver chromeHeader() throws Throwable {
	try {
		
		
		
//		ChromeOptions options = new ChromeOptions();
		
//		ChromeDriver driver = new ChromeDriver(options);
		
		
		
		
		caps = new DesiredCapabilities();
		   System.setProperty("webdriver.chrome.driver", "C:\\APPLIS\\drivers\\chromedriver-win64\\chromedriver.exe");

		   ChromeOptions options = new ChromeOptions();
//		   options.addExtensions(new File("C:\\ChromeExtensions\\idgpnmonknjnojddfkpgkljpfnnfcklj.crx"));
		   Path currentRelativePath = Paths.get("chrome-modheader/modheader.crx");
		   options.merge(caps);
//		   options.addArguments("--headless");
		   options.addArguments("--start-maximized");
		   options.addArguments("--disable-popup-blocking");
		   options.addArguments("--remote-allow-origins=*");
		   options.addArguments("--incognito");//navigation privée
		   options.addArguments("--disable-search-engine-choice-screen");
		   options.addExtensions(new File(currentRelativePath.toAbsolutePath().toString()));
		   System.out.println(options);

		   driver = new ChromeDriver(options);
		   driver.manage().deleteAllCookies();
		   driver.get("https://webdriver.modheader.com/add?test=ModHeader%20Test");
		   new WebDriverWait(driver, Duration.ofSeconds(500)).until(ExpectedConditions.titleIs("Done"));
		   System.out.println("Initialisation réussie");
		   
		   
	} catch (Exception e) {
		My_SreenShot.takeScreenshot(driver);
		e.printStackTrace();
	}
		return driver;
	}
	
	public static String extension (WebDriver driver, String cnbf, String value) throws Throwable {
		//Installation 
//	   	String myXpath = "//a[@class='navbar-brand']";
//	   	mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	   	mesFonctions.objet(driver,  myXpath).click();
//		   
//	   	myXpath = "//a[@class='my-1 install-button btn btn-danger btn-lg']";
//	   	mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	   	mesFonctions.objet(driver,  myXpath).click();
//		   
//	   	System.out.println("Installation réussie");
		   
	   	driver.get("chrome-extension://idgpnmonknjnojddfkpgkljpfnnfcklj/app.html?product=ModHeader");
		   
		//Paramétrage
		Thread.sleep(200);
	   	String myXpath = "(//input[@class='mdc-text-field__input'])[2]";
	   	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	   	MesFonctions.objet(driver,  myXpath).sendKeys(cnbf);
	   	Thread.sleep(100);  
	   	myXpath = "(//input[@class='mdc-text-field__input'])[3]";
	   	MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	   	MesFonctions.objet(driver,  myXpath).sendKeys(value);
	   	Thread.sleep(100);
	   			//la coche est déjà cochée décommenter que si cell-ci ne l'est pas par défaut
//	   	myXpath = "(//input[@class='mdc-checkbox__native-control'])[2]";
//	   	mesFonctions.objet(driver,  myXpath).click();
//	   	Thread.sleep(1000); 
		   
	   	System.out.println("Les paramètre du header sont renseignés "+cnbf+" "+value);
		  
	   	Thread.sleep(2000);
	   	MicroFonctions.changeWindow(driver);
		   
	   	return null;
	}
	
}

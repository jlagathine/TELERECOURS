package browser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class NavigaChromHeader {
	static DesiredCapabilities caps;
	   static WebElement element;
	
	public static WebDriver chromeHeader() throws Throwable {
		caps = new DesiredCapabilities();
		   System.setProperty("webdriver.chrome.driver",
				   "C:\\Driver\\chromedriver.exe");

		   ChromeOptions options = new ChromeOptions();
		   options.addExtensions(new File("C:\\ChromeExtensions\\idgpnmonknjnojddfkpgkljpfnnfcklj.crx"));
		   options.merge(caps);
		   options.addArguments("--start-maximized");
		   options.addArguments("--disable-popup-blocking");


		   WebDriver driver = new ChromeDriver(options);
		   driver.manage().deleteAllCookies();
		   System.out.println("Initialisation réussie");
		   
		   Thread.sleep(4000);
		   driver.close();
		   Thread.sleep(2000);
		   String parentWindow = MesFonctions.parentWindow(driver);
		   driver.switchTo().window(parentWindow);
		   
		   
	
		return null;//driver;
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
		Thread.sleep(2000);
	   	String myXpath = "(//input[@class='mdc-text-field__input'])[2]";
	   	MesFonctions.objet(driver,  myXpath).sendKeys(cnbf);
	   	Thread.sleep(1000);  
	   	myXpath = "(//input[@class='mdc-text-field__input'])[3]";
	   	MesFonctions.objet(driver,  myXpath).sendKeys(value);
	   	Thread.sleep(1000);
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

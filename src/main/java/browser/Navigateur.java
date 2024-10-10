package browser;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import captureTool.My_SreenShot;
import lesFonctions.MesFonctions;

public class Navigateur {
	
	   static DesiredCapabilities caps;
	   public static WebDriver driver;
	   
	   
	   public static WebDriver choixBrowser(String browserName) throws IOException {

		   switch (browserName) {
		   case "chrome":
			   try {
				   caps = new DesiredCapabilities();
				   System.setProperty("webdriver.chrome.driver",
						   "C:\\APPLIS\\drivers\\chromedriver-win64\\chromedriver.exe");

				   ChromeOptions options = new ChromeOptions();
				   options.merge(caps);
//				   options.addArguments("--headless");
				   options.addArguments("--start-maximized");
				   options.addArguments("--disable-popup-blocking");
				   options.addArguments("--remote-allow-origins=*");
				   options.addArguments("--incognito");//navigation privée
				   options.addArguments("--disable-search-engine-choice-screen");

				   driver = new ChromeDriver(options);
				   System.out.println("Initialisation réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   
				   System.out.println("Début Testcase......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			} catch (Exception e) {
				My_SreenShot.takeScreenshot(driver);
				e.printStackTrace();
			}
			   
			   

			   break;
			   

		   case "firefox":
			   caps = new DesiredCapabilities();
			   System.setProperty("webdriver.gecko.driver",
					   "C:\\APPLIS\\drivers\\geckodriver\\geckodriver.exe");
			   caps.setCapability("marionette", true);
			   
			   FirefoxOptions option = new FirefoxOptions();
			   caps.setCapability("moz:firefoxOptions", option);
//			   option.addArguments("--headless");
			   option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			   option.addArguments("-private");
			   
			   driver = new FirefoxDriver(option);
			   
			   driver.manage().window().maximize();
			   System.out.println("Initialisation réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			   System.out.println("Début Testcase......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   break;
			
			   
			   
		   case "edge":
			   caps = new DesiredCapabilities();
			   System.setProperty("webdriver.edge.driver",
					   "C:\\Driver\\msedgedriver.exe");

			  
			   EdgeOptions opt = new EdgeOptions();;
			   opt.merge(caps);
			   opt.addArguments("--start-maximized");
			   opt.addArguments("--disable-popup-blocking");


			   driver = new EdgeDriver (opt);
			   
			   System.out.println("Initialisation réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			   System.out.println("Début Testcase......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   break;

		   default:
			   System.err.println("DRIVER ISSUE");
			   break;
		   }
		return driver;
		    
	   }
	   
	   
}
package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import captureTool.My_SreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import lesFonctions.MesFonctions;

public class Navigateur {
	
	   static DesiredCapabilities caps;
	   static WebDriver driver;
	   
	   
	   public static WebDriver choixBrowser(String browserName) throws Throwable {
		   
		   switch (browserName) {
		   case "chrome":
			   try {
				   caps = new DesiredCapabilities();
				   System.setProperty("webdriver.chrome.driver", "C:\\APPLIS\\drivers\\chromedriver-win64\\chromedriver.exe");
				   
				   ChromeOptions options = new ChromeOptions();
				   
				   options.merge(caps);
//				   options.addArguments("--headless");
				   options.addArguments("--start-maximized");
				   options.addArguments("--disable-popup-blocking");
				   options.addArguments("--remote-allow-origins=*");
				   options.addArguments("--incognito");//navigation privée
				   options.addArguments("--disable-search-engine-choice-screen");
				   System.out.println(options);
				   
				   driver = new ChromeDriver(options);
				   System.out.println("Initialisation réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				   
				   System.out.println("Début Testcase......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			} catch (Exception e) {
				My_SreenShot.screenshot();
				e.printStackTrace();
			}

			   break;
			   

		   case "firefox":
			   caps = new DesiredCapabilities();
			   System.setProperty("webdriver.gecko.driver", "C:\\APPLIS\\drivers\\firefoxdriver\\geckodriver.exe");
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
			   System.setProperty("webdriver.edge.driver", "C:\\APPLIS\\drivers\\edge_chrome\\msedgedriver.exe");

			  
			   EdgeOptions options = new EdgeOptions();;
			   options.merge(caps);
//			   options.addArguments("--headless");
			   options.addArguments("--start-maximized");
			   options.addArguments("--disable-popup-blocking");
			   options.addArguments("--remote-allow-origins=*");
			   options.addArguments("--incognito");//navigation privée
			   options.addArguments("--disable-search-engine-choice-screen");
			   System.out.println(options);


			   driver = new EdgeDriver (options);
			   
			   System.out.println("Initialisation réussie....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   
			   System.out.println("Début Testcase......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			   break;
			   
		   case "chrome_git":
			   caps = new DesiredCapabilities();
			   WebDriverManager.chromedriver().setup();

			  
			   ChromeOptions option_gits = new ChromeOptions();
			   option_gits.merge(caps);
			   option_gits.addArguments("--headless");
			   option_gits.addArguments("--start-maximized");
			   option_gits.addArguments("--disable-popup-blocking");
			   option_gits.addArguments("--remote-allow-origins=*");
			   option_gits.addArguments("--incognito");//navigation privée
			   option_gits.addArguments("--disable-search-engine-choice-screen");
			   System.out.println(option_gits);


			   driver = new ChromeDriver (option_gits);
			   
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
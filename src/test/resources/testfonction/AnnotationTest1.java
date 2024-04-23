package testfonction;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class AnnotationTest1 {
	WebDriver driver ;
	
	
  @BeforeSuite
  public void beforeTest() {
	  
	  //WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagathine\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.merge(caps);
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		
		driver = new ChromeDriver(options); 
  }
   
  
  @BeforeMethod
  public void browserTACAA() {
	  driver.get("https://www.telerecours.recette.juradm.fr/");
  }
  
  
  @Test
  public void CAA() throws InterruptedException {
	  String identifiant1 = "gia458f";
		String mdp = "Lhommeest2019*";
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant1);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(mdp);
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='CAA Paris']")).click();
			Thread.sleep(3000);
	  
  }
  
  
  @Test
  public void TA() throws InterruptedException {
	  String identifiant1 = "gia458f";
		String mdp = "Lhommeest2019*";
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant1);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(mdp);
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='TA Paris']")).click();
			Thread.sleep(3000);
	  
  }
  
  
  @BeforeMethod
  public void browserCE() {
	  driver.get("https://www.telerecours.recette.conseil-etat.fr/");
  }
  
  
  @Test
  public void CE() throws InterruptedException {
	  String identifiant1 = "gia458f";
		String mdp = "Lhommeest2019*";
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant1);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(mdp);
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
		Thread.sleep(1000);
	  
  }

  @AfterMethod
  public void afterTest() throws InterruptedException {
	  
	    driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici')]")).click();
		Thread.sleep(5000);
		
  }	
		
   @AfterSuite
	public void fin () {
	   System.out.println("LE TEST EST UN SUCCES !!!");
		driver.quit();
	} 
	  
  }

  



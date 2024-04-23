package testfonction;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class Testconnection {

	public static WebDriver driver;
	
	@BeforeAll
	public void Setup () {
		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagathine\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.get("https://www.telerecours.recette.juradm.fr/");
		driver.manage().window().maximize();
	}

		@Test
		public void Ta() throws Throwable {
			String identifiant1 = "gia458f";
			String mdp = "Lhommeest2019*";
			
				driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant1);
				driver.findElement(By.id("//input[@id='password-field']")).sendKeys(mdp);
				driver.findElement(By.id("//button[@id='login-submit]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='CAA Paris']")).click();
				Thread.sleep(1000);
		}
		@AfterEach
		public void deconnection() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici']")).click();
		}
		
	@AfterAll
	public void quit() {
		driver.quit();
		}
}


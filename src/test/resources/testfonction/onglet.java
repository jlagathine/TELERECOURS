package testfonction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class onglet {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
				DesiredCapabilities caps = new DesiredCapabilities();
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagathine\\Downloads\\chromedriver_win32\\chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				options.merge(caps);
				options.addArguments("--start-maximized");
				options.addArguments("--disable-popup-blocking");
				WebDriver driver = new ChromeDriver(options);
				
				driver.get("https://www.google.com/");
				driver.findElement(By.xpath("//button[@id='L2AGLb']//div")).click();
				Thread.sleep(1000);
				
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open();");
				
				Thread.sleep(1000);
				Set<String> Tab = driver.getWindowHandles();
				
				int count = Tab.size();
				System.out.println(count);
				Iterator<String> it = Tab.iterator();
				String parentWindow = it.next();
				String childWindow = it.next();
				
				System.out.println("child window : " + childWindow);
				
				System.out.println("parent window : " + parentWindow);
				driver.switchTo().window(childWindow);
				driver.close();
				Thread.sleep(1000);
				driver.switchTo().window(parentWindow);
				

	}

}

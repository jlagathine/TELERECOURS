package inscription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import browser.Navigateur;



	 public class Authentification_deprecated {
				
			WebDriver driver;
			public String browserName;
		
			@BeforeSuite
			public void connection() throws IOException{
				browserName = "chrome";
				   driver = Navigateur.choixBrowser(browserName);
				   System.out.println(driver);
			}
			
			@BeforeMethod
			public void goToSite() {
				driver.get("https://www.telerecours.recette.juradm.fr/");	
			}
			
			@Test
			public void caracmaxCA() throws InterruptedException{
			String identifiant1 = "gia458f";
			String mdp = "Lhommeest2019*";
			
				driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(identifiant1);
				driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys(mdp);
				driver.findElement(By.xpath("//button[@id='login-submit']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='CAA Paris']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
				String newmdpwrong = "Lemotdepassedoitavoirunpetit*91";
				String newmdp = "Lemotdepassedoitavoirunpetit*9";
				//driver.switchTo().window(Tabs.get(count));
				driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
				Thread.sleep(1000);
				//driver.switchTo().window(Tabs.get(count));
				Thread.sleep(1000);
				
				//Insertion d'un mdp trop long
				driver.findElement(By.xpath("txtMotDePasseActuel")).sendKeys(mdp);
				driver.findElement(By.xpath("txtNouveauMotDePasse")).sendKeys(newmdpwrong);
				driver.findElement(By.xpath("txtConfirmation")).sendKeys(newmdpwrong);
				driver.findElement(By.xpath("//input[@value='Valider']")).click(); //valider
				String alert = driver.findElement(By.xpath("//span[@id='labelValiditeMdp']")).getText();

				System.out.println(alert);
				
				Thread.sleep(1000);
				
				//Insertion d'un mdp respectant le format des mdp
				driver.findElement(By.xpath("txtMotDePasseActuel")).sendKeys(mdp);
				driver.findElement(By.xpath("txtNouveauMotDePasse")).sendKeys(newmdp);
				driver.findElement(By.xpath("txtConfirmation")).sendKeys(newmdp);
				driver.findElement(By.xpath("//input[@value='Valider']")).click(); //valider
				
				Thread.sleep(1000);
			}
			@Test	
		public void caracmaxTA() throws InterruptedException{
				String identifiant1 = "gia458f";
				String mdp = "Lhommeest2019*";
				String newmdp = "Lemotdepassedoitavoirunpetit*9";
				Set<String> Tabu1 = driver.getWindowHandles();
				 int count = Tabu1.size();
				ArrayList<String> Tabs = new ArrayList<>(Tabu1);
					driver.findElement(By.id("Username")).sendKeys(identifiant1);
					driver.findElement(By.id("password-field")).sendKeys(newmdp);
					driver.findElement(By.id("login-submit")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[text()='TA Paris']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
					
					driver.switchTo().window(Tabs.get(count));
					driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
					Thread.sleep(1000);
					driver.switchTo().window(Tabs.get(count));
					Thread.sleep(1000);
					driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(newmdp);
					driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(mdp);
					driver.findElement(By.id("txtConfirmation")).sendKeys(mdp);
					driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
			
			} 
			@Test
		public void caracmaxCE() throws Throwable{
				String identifiant2 = "hol2db5";
				String mdp = "Lhommeest2019*";
				String newmdpwrong = "Lemotdepassedoitavoirunpetit*91";
				String newmdp = "Lemotdepassedoitavoirunpetit*9";
				Set<String> Tabu1 = driver.getWindowHandles();
				 int count = Tabu1.size();
				ArrayList<String> Tabs = new ArrayList<>(Tabu1);
				driver.findElement(By.xpath("//a[@href='https://www.telerecours.recette.conseil-etat.fr']")).click();
				Thread.sleep(1000);
					driver.findElement(By.id("Username")).sendKeys(identifiant2);
					driver.findElement(By.id("password-field")).sendKeys(mdp);
					driver.findElement(By.id("login-submit")).click();
		
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
					
					driver.switchTo().window(Tabs.get(count));
					driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
					Thread.sleep(1000);
					driver.switchTo().window(Tabs.get(count));
					Thread.sleep(1000);
					driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(mdp);
					driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(newmdpwrong);
					driver.findElement(By.id("txtConfirmation")).sendKeys(newmdpwrong);
					driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
					String alert = driver.findElement(By.xpath("//span[@id='labelValiditeMdp]")).getText();
					String verifAlert = "Votre nouveau mot de passe doit contenir au minimum 12 caratères. Les caractères autorisés sont les lettres de A à Z en miniscules ou majuscules, les chiffres de 0 à 9 et les caractères spéciaux ()-_éèà=*{}[]ç";

					System.out.println(alert);
					boolean verif = alert.equals(verifAlert);
					if(verif==false) {
						throw new Exception(verifAlert + " Le text est différent " + alert);
					}
					Thread.sleep(1000);
					driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(mdp);
					driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(newmdp);
					driver.findElement(By.id("txtConfirmation")).sendKeys(newmdp);
					driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
			} 
			@Test
			public void caracmaxCE1() throws Throwable{
				String identifiant2 = "hol2db5";
				String mdp = "Lhommeest2019*";
				String newmdp = "Lemotdepassedoitavoirunpetit*9";
				Set<String> Tabu1 = driver.getWindowHandles();
				 int count = Tabu1.size();
				ArrayList<String> Tabs = new ArrayList<>(Tabu1);
				driver.findElement(By.xpath("//a[@href='https://www.telerecours.recette.conseil-etat.fr']")).click();
				Thread.sleep(1000);
					driver.findElement(By.id("Username")).sendKeys(identifiant2);
					driver.findElement(By.id("password-field")).sendKeys(mdp);
					driver.findElement(By.id("login-submit")).click();
		
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
					
					driver.switchTo().window(Tabs.get(count));
					driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
					Thread.sleep(1000);
					driver.switchTo().window(Tabs.get(count));
					Thread.sleep(1000);
					driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(newmdp);
					driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(mdp);
					driver.findElement(By.id("txtConfirmation")).sendKeys(mdp);
					driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
			}
			@Test	
			public void caracspecTA() throws InterruptedException{
					String identifiant1 = "audaJKD";
					String mdp = "Lhommeest2019*";
					String newmdp = "Lhommeest2019()-_éèà=*{}[]ç";
					Set<String> Tabu1 = driver.getWindowHandles();
					 int count = Tabu1.size();
					ArrayList<String> Tabs = new ArrayList<>(Tabu1);
						driver.findElement(By.id("Username")).sendKeys(identifiant1);
						driver.findElement(By.id("password-field")).sendKeys(mdp);
						driver.findElement(By.id("login-submit")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//a[text()='TA Paris']")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
						
						driver.switchTo().window(Tabs.get(count));
						driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
						Thread.sleep(1000);
						driver.switchTo().window(Tabs.get(count));
						Thread.sleep(1000);
						driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(mdp);
						driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(newmdp);
						driver.findElement(By.id("txtConfirmation")).sendKeys(newmdp);
						driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
				
				}
			@Test
			public void caracspec_CAA() throws InterruptedException{
				String identifiant1 = "audaJKD";
				String mdp = "Lhommeest2019*";
				String newmdp = "Lhommeest2019()-_éèà=*{}[]ç";
				Set<String> Tabu1 = driver.getWindowHandles();
				 int count = Tabu1.size();
				ArrayList<String> Tabs = new ArrayList<>(Tabu1);
					driver.findElement(By.id("Username")).sendKeys(identifiant1);
					driver.findElement(By.id("password-field")).sendKeys(newmdp);
					driver.findElement(By.id("login-submit")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[text()='TA Paris']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
					
					driver.switchTo().window(Tabs.get(count));
					driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
					Thread.sleep(1000);
					driver.switchTo().window(Tabs.get(count));
					Thread.sleep(1000);
					driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(newmdp);
					driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(mdp);
					driver.findElement(By.id("txtConfirmation")).sendKeys(mdp);
					driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
			}
			@Test
			public void caracspec_CE() throws InterruptedException{
				//changement de site - vers le site CE
				String identifiant2 = "hol2db5";
				String mdp = "Lhommeest2019*";
				Set<String> Tabu1 = driver.getWindowHandles();
				 int count = Tabu1.size();
				ArrayList<String> Tabs = new ArrayList<>(Tabu1);
			
				String newmdp = "Lhommeest2019()-_éèà=*{}[]ç";
				driver.findElement(By.xpath("//a[@href='https://www.telerecours.recette.conseil-etat.fr']")).click();
				Thread.sleep(1000);
					driver.findElement(By.id("Username")).sendKeys(identifiant2);
					driver.findElement(By.id("password-field")).sendKeys(mdp);
					driver.findElement(By.id("login-submit")).click();
		
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
					
					driver.switchTo().window(Tabs.get(count));
					driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
					Thread.sleep(1000);
					driver.switchTo().window(Tabs.get(count));
					Thread.sleep(1000);
					driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(mdp);
					driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(newmdp);
					driver.findElement(By.id("txtConfirmation")).sendKeys(newmdp);
					driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
			}
			@Test
			public void caracspec_CE1() throws InterruptedException{
			String identifiant2 = "hol2db5";
			String mdp = "Lhommeest2019*";
			Set<String> Tabu1 = driver.getWindowHandles();
			 int count = Tabu1.size();
			ArrayList<String> Tabs = new ArrayList<>(Tabu1);
			
			String newmdp = "Lhommeest2019()-_éèà=*{}[]ç";
			
			driver.findElement(By.linkText("www.telerecours.recette.conseil-etat.fr")).click();
			Thread.sleep(1000);
				driver.findElement(By.id("Username")).sendKeys(identifiant2);
				driver.findElement(By.id("password-field")).sendKeys(mdp);
				driver.findElement(By.id("login-submit")).click();
	
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@id='lnkpref']")).click(); 
				
				driver.switchTo().window(Tabs.get(count));
				driver.findElement(By.xpath("//a[@id='linkChamgementMotDePasse']")).click();
				Thread.sleep(1000);
				driver.switchTo().window(Tabs.get(count));
				Thread.sleep(1000);
				driver.findElement(By.id("txtMotDePasseActuel")).sendKeys(newmdp);
				driver.findElement(By.id("txtNouveauMotDePasse")).sendKeys(mdp);
				driver.findElement(By.id("txtConfirmation")).sendKeys(mdp);
				driver.findElement(By.xpath("//input[@value='Valider]")).click(); //valider
				
			}
			
			@AfterEach
			public void deconnection() throws InterruptedException{
				Set<String> Tabu1 = driver.getWindowHandles();
				 int count = Tabu1.size();
				ArrayList<String> Tabs = new ArrayList<>(Tabu1);
				driver.switchTo().window(Tabs.get(count));
				driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@class='alert-link ' and (text()='ici']")).click();
			}
			@AfterAll
			public void fin () {
				driver.quit();
			}
		}
	
	
	

	
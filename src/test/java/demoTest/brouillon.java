package demoTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browser.Navigateur;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class brouillon {

	static String browserName;
	static WebDriver driver;
	static WebElement element;
	static String ID;
	static String mdp;
	static String myXpath;
		
	public static void main(String[] args) throws Throwable {
		
		browserName = "chrome";
		   driver = Navigateur.choixBrowser(browserName);
		   System.out.println(driver);
		   
		driver.get("https://www.telerecours.recette.juradm.fr/");//attention URL
		ID = "aja1XOV";
		mdp = "Conseiletat123456*";
		
		MicroFonctions.AuthentificationTaCaaCeExt(driver, ID, mdp);
		MicroFonctions.choixJuridictionTA(driver);
		
		myXpath = "//td[@id='Entete1_MenuActeur1_im1_AB']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Page TR legacy");
		
		myXpath = "//a[@id='pavoLink']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("clic pavoLink");
		
		myXpath = "//button[text()=\" Déposer une requête \"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("clic \"Déposer une requête\"");
		
		myXpath = "//a[text()=\"Objet de la requête\"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("clic \"Objet de la requête\"");
		
		myXpath = "//pavo-select-item-form[@ng-reflect-title='Matière']//div";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("clic \"Sélectionner\"");
		
		myXpath = "//pavo-select-item-form[@ng-reflect-title='Matière']//div[@class='ng-option'][5]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("clic \"Collectivités locales et établissements publics locaux\"");
		
	}
}




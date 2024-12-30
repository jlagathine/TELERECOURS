package referentiel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import lesFonctions.MesFonctions;

public class Authentication {
	
	public static Object seConnecter_referentiel(WebDriver driver, String username, String mdp) throws Throwable {
		String url = "https://referentiels.int2.conseil-etat.fr/";
		driver.get(url);
		Thread.sleep(100);
		System.out.println("Accès page "+driver.getCurrentUrl()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
//		//Clic paramètres avancés
//		String myXpath = "//button[@id='details-button']";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	    MesFonctions.objet(driver,  myXpath).click();
//	    
//	    myXpath = "//a[@id='proceed-link']";
//	    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//	    MesFonctions.objet(driver,  myXpath).click();
//	    
//	    System.out.println("Accès page "+driver.getCurrentUrl()+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	    
	    //Entrer username
	    String myXpath = "//input[@id='user_0_login']";
	    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	    MesFonctions.objet(driver,  myXpath).sendKeys(username);
	    System.out.println("le login est renseigné....."+MesFonctions.extractCurrentHeure());
	    
	    //Entrer mdp
	    myXpath = "//input[@id='user_0_password']";
	    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	    MesFonctions.objet(driver,  myXpath).sendKeys(mdp);
	    System.out.println("le mot de passse est renseigné....."+MesFonctions.extractCurrentHeure());
	    
	    //Click bouton "Se connecter"
	    myXpath = "//button[@id='btn_submit']";
	    MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	    MesFonctions.objet(driver,  myXpath).click();
	    System.out.println("Click bouton \"Se connecter\"...."+MesFonctions.extractCurrentHeure());
	    
	    System.out.println("Validation des identifiants Username : "+username+" mot de passe : "+mdp+"....."+MesFonctions.extractCurrentDate()+" a "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}

}

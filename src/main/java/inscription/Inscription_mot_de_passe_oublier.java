package inscription;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import lesFonctions.MesFonctions;

public class Inscription_mot_de_passe_oublier {
	
	public static void click_lien_mot_de_passe_oublie(WebDriver driver, String jur, String env) {
		//Clic "dentifiant et/ou mot de passe oublié ?"
		switch (jur) {
		case "TA":
			if(env=="rec") {
				driver.get("https://www.telerecours.recette.juradm.fr/");
			}else {
				driver.get("https://www.telerecours.int1.juradm.fr/");
			}
			String myXpath = "//div[@id='recovery-link']//a";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			
			System.out.println("Le lien : "+MesFonctions.objet(driver, myXpath).getText()+" a été cliqué ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
		//Accès à la page de récupérartion de ses identifiants
			myXpath = "//h1";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à la page : "+MesFonctions.objet(driver, myXpath).getText()+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "CAA":
			if(env=="rec") {
				driver.get("https://www.telerecours.recette.juradm.fr/");
			}else {
				driver.get("https://www.telerecours.int1.juradm.fr/");
			}
			myXpath = "//div[@id='recovery-link']//a";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			
			System.out.println("Le lien : "+MesFonctions.objet(driver, myXpath).getText()+" a été cliqué ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Accès à la page de récupérartion de ses identifiants
			myXpath = "//h1";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à la page : "+MesFonctions.objet(driver, myXpath).getText()+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "CTX":
			if(env=="rec") {
				driver.get("https://www.telerecours.recette.conseil-etat.fr/");
			}else {
				driver.get("https://www.telerecours.int1.conseil-etat.fr/");
			}
			myXpath = "//div[@id='recovery-link']//a";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).click();
			
			System.out.println("Le lien : "+MesFonctions.objet(driver, myXpath).getText()+" a été cliqué ...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Accès à la page de récupérartion de ses identifiants
			myXpath = "//h1";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			System.out.println("Accès à la page : "+MesFonctions.objet(driver, myXpath).getText()+"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;

		default:System.err.println("Cette juridiction n'est pas reconnue");
			break;
		}
	}
}

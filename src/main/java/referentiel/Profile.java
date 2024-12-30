package referentiel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lesFonctions.MesFonctions;

public class Profile {
	
	public static void verification_profile(WebDriver driver, String profile) throws Throwable {
		switch (profile) {
		case "lect":
			//Identifier la liste des référentiels
			String myXpath = "//a[@data-allowed='true']//span[@id='ref_name']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			List<WebElement> elt = driver.findElements(By.xpath(myXpath));
			int nbr = elt.size();
			
			for(int i=1;i<=nbr;i++) {
				//Accéder à un référentiel
				String myXpath0 = "(//a[@data-allowed='true']//span[@id='ref_name'])["+i+"]";
				Thread.sleep(300);
				String nom = MesFonctions.objet(driver, myXpath0).getText();//elt.get(i).getText();
				MesFonctions.objet(driver, myXpath0).click();//elt.get(i).click();
				System.out.println("Accès au référentiel : "+nom+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				//Vérifier le paramétrage par défaut de la pagination
				String myXpath1 = "//span[text()='Brouillon']";
				boolean verif = false;
				Thread.sleep(300);
				
				//Accès et restrictions
				if(!MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Absence de la coche \"BROUILLON\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile lecteur ne peut créer de brouillon....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),'Créer')]";
				if(!MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Absence du bouton \"CREER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile lecteur ne peut créer une nouvelle donnée de référence ....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),'Télécharger')]";
				if(!MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Absence du bouton \"TELECHARGER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile lecteur ne peut faire de téléchargement....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//button[contains(text(),'Rechercher')]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"RECHERCHER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Absence du bouton \"RECHERCHER\"....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),\"Consulter l'audit\")]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"CONSULTER L'AUDIT\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Absence du bouton \"CONSULTER L'AUDIT\"....."+MesFonctions.extractCurrentHeure());
				}
				
				//Retour à la liste des référentiels
				String myXpath3 = "//a[contains(text(),\"Liste des référentiels\")]";
				MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath3).click();
				System.out.println("Retour à la liste des référentiels....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				Thread.sleep(500);
				}
			break;
			
		case "admin_tech":
			//Identifier la liste des référentiels
			myXpath = "//a[@data-allowed='true']//span[@id='ref_name']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			elt = driver.findElements(By.xpath(myXpath));
			nbr = elt.size();
			
			for(int i=1;i<=nbr;i++) {
				//Accéder à un référentiel
				String myXpath0 = "(//a[@data-allowed='true']//span[@id='ref_name'])["+i+"]";
				Thread.sleep(300);
				String nom = MesFonctions.objet(driver, myXpath0).getText();//elt.get(i).getText();
				MesFonctions.goToDown(driver, myXpath0);
				Thread.sleep(300);
				MesFonctions.objet(driver, myXpath0).click();//elt.get(i).click();
				System.out.println("Accès au référentiel : "+nom+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				//Vérifier le paramétrage par défaut de la pagination
				String myXpath1 = "//span[text()='Brouillon']";
				boolean verif = false;
				Thread.sleep(300);
				
				//Accès et restrictions
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence de la coche \"BROUILLON\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile administrateur-technique peut créer un brouillon....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),'Créer')]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"CREER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile administrateur-technique peut créer une nouvelle donnée de référence ....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),'Télécharger')]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"TELECHARGER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile administrateur-technique peut télécharger des fichier CSV....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//button[contains(text(),'Rechercher')]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"RECHERCHER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Absence du bouton \"RECHERCHER\"....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),\"Consulter l'audit\")]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"CONSULTER L'AUDIT\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Absence du bouton \"CONSULTER L'AUDIT\"....."+MesFonctions.extractCurrentHeure());
				}
				
				//Retour à la liste des référentiels
				String myXpath3 = "//a[contains(text(),\"Liste des référentiels\")]";
				MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath3).click();
				System.out.println("Retour à la liste des référentiels....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				Thread.sleep(500);
				}
			break;
			
		case "admin_loc":
			//Identifier la liste des référentiels
			myXpath = "//a[@data-allowed='true']//span[@id='ref_name']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			elt = driver.findElements(By.xpath(myXpath));
			nbr = elt.size();
			
			for(int i=1;i<=nbr;i++) {
				//Accéder à un référentiel
				String myXpath0 = "(//a[@data-allowed='true']//span[@id='ref_name'])["+i+"]";
				Thread.sleep(300);
				String nom = MesFonctions.objet(driver, myXpath0).getText();//elt.get(i).getText();
				MesFonctions.goToDown(driver, myXpath0);
				Thread.sleep(300);
				MesFonctions.objet(driver, myXpath0).click();//elt.get(i).click();
				System.out.println("Accès au référentiel : "+nom+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
				//Vérifier le paramétrage par défaut de la pagination
				String myXpath1 = "//span[text()='Brouillon']";
				boolean verif = false;
				Thread.sleep(300);
				
				//Accès et restrictions
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence de la coche \"BROUILLON\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile administrateur-local peut créer un brouillon....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),'Créer')]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"CREER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile administrateur-local peut créer une nouvelle donnée de référence ....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),'Télécharger')]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"TELECHARGER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Le profile administrateur-local peut télécharger des fichier CSV....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//button[contains(text(),'Rechercher')]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"RECHERCHER\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Absence du bouton \"RECHERCHER\"....."+MesFonctions.extractCurrentHeure());
				}
				
				myXpath1 = "//a[contains(text(),\"Consulter l'audit\")]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
					System.out.println("Présence du bouton \"CONSULTER L'AUDIT\"....."+MesFonctions.extractCurrentHeure());
				}else {
					System.err.println("Absence du bouton \"CONSULTER L'AUDIT\"....."+MesFonctions.extractCurrentHeure());
				}
				
				//Retour à la liste des référentiels
				String myXpath3 = "//a[contains(text(),\"Liste des référentiels\")]";
				MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath3).click();
				System.out.println("Retour à la liste des référentiels....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				Thread.sleep(500);
				}
			break;

		default:
			break;
		}
	}

}

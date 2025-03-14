package referentiel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lesFonctions.MesFonctions;

public class Referentiels_Verification_Nombre_Enregistrements {
	
	
	public static List<Integer> recuperation_nombre_enregistre_page_accueil(WebDriver driver) throws Throwable{
		List<Integer> chf = new ArrayList<>();
		
		//Identifier la liste des référentiels
		String myXpath = "//span[@id='ref_name']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));
		int nbr = elt.size();
		
		for(int i=1;i<=nbr;i++) {
			//Accéder à un référentiel
			String myXpath0 = "(//span[@id='ref_name'])["+i+"]";
			MesFonctions.waiting2(driver, myXpath0, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath0);
			Thread.sleep(300);
			String nom = MesFonctions.objet(driver, myXpath0).getText();
			System.out.println("Accès au référentiel : "+nom+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Vérifier le nombre de données actives
			String myXpath1 = "(//span[@id='num_active_jur'])["+i+"]";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			String activRef = MesFonctions.objet(driver, myXpath1).getText().split(" ")[0].trim();
			chf.add(MesFonctions.convertStringTo_Integer(activRef));
			System.out.println("Le nombre de données actives a été ajouté : "+chf);
			
			MesFonctions.objet(driver, myXpath0).click();
			int record = Referentiels_Verification_Nombre_Enregistrements.nbr_de_donnees_actives_egale_nombre_enreg_actif_par_ref(driver);
				if(record==chf.get(i-1)) {
					System.out.println("Le nombre d'enregistrements est égale au chiffre/nombre affiché sur l'application......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}else {
					System.err.println("Le nombre d'enregistrements ne correspond pas au chiffre/nombre affiché sur l'application......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				}
				
			myXpath = "//a[contains(text(),\"Liste des référentiels\")]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToUp(driver, myXpath);
			Thread.sleep(300);
			MesFonctions.objet(driver, myXpath).click();
			}
		
		return chf;
	}
	
	public static Integer nbr_de_donnees_actives_egale_nombre_enreg_actif_par_ref(WebDriver driver) throws Throwable {
		Integer mySum = 0;
		
		//click bouton "Actif"
		String myXpath = "//input[@id='actif-check']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();//elt.get(i).click();
		System.out.println("La check-box \"Actif\" a été cochée...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Comptage des enregistrements
		int i = 1;
		myXpath = "(//a[contains(@href,'page="+i+"')])[2]";

		boolean verif = false;
		boolean turn = false;
		if(MesFonctions.isElementPresent(driver, myXpath, verif)) {	
			turn = true;
			}else {
				String myXpath1 = "//tr[@id]";
				if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
				MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
				List<WebElement> elt = driver.findElements(By.xpath(myXpath1));
				int nbrEnregistrement = elt.size();
				
				//Nombre d'enregistrement sur la page
				List<Integer> sum = new ArrayList<>();
				sum.add(nbrEnregistrement);
				System.out.println(sum);
				
					//Somme du nombre d'enregistrement
					for(Integer j:sum) {
						mySum += j;
					}
					System.out.println(mySum);
				}else {
					mySum = 0;
					System.out.println("Aucune ligne enregistrée : "+mySum);
				}
			}
		
		while(turn) {
		String myXpath1 = "//tr[@id]";
		if(MesFonctions.isElementPresent(driver, myXpath1, verif)) {
			List<WebElement> elt = driver.findElements(By.xpath(myXpath1));
			int nbrEnregistrement = elt.size();
			
			//Nombre d'enregistrement sur la page
			List<Integer> sum = new ArrayList<>();
			sum.add(nbrEnregistrement);
			System.out.println(sum);
			
				//Somme du nombre d'enregistrement
				for(Integer j:sum) {
					mySum += j;
				}
			System.out.println(mySum);
			
			i++;
//			String myXpath2 = "(//li//a[@title='Suivant' and contains(text(),'"+i+"')])[2]";
			String myXpath2 = "(//li//a[contains(text(),'"+i+"')])[2]";
			if(MesFonctions.isElementPresent(driver, myXpath2, verif)) {
			MesFonctions.goToDown(driver, myXpath2);
			Thread.sleep(300);
			MesFonctions.objet(driver, myXpath2).click();
			System.out.println("Click page : "+myXpath2+"....."+MesFonctions.extractCurrentHeure());
			turn |= MesFonctions.isElementPresent(driver, myXpath, verif);
				}else {
					turn = false;
				}
			}
		}
		
		//Total d'enregistrement actifs
		System.out.println("Le total d'enregistrement(s) actif(s) est égale à : "+mySum+"......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

		return mySum;
	}
}

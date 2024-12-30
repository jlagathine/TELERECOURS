package referentiel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lesFonctions.MesFonctions;

public class Verification_element_page_accueil {
	
	public static Object verification_nomRef_nbrRef_actRef(WebDriver driver) {
		//Sélection des données de référence du tableau
		String myXpath = "//span[@id='ref_name']";
		String myXpath1 = "//span[@id='num_active_jur']";
		String myXpath2 = "//span[@id='ref_state']";
		
		List<WebElement> elts = driver.findElements(By.xpath(myXpath));
		List<WebElement> elts1 = driver.findElements(By.xpath(myXpath1));
		List<WebElement> elts2 = driver.findElements(By.xpath(myXpath2));
		int nbr = elts.size();
		
		//Collecte : nom de la référence; nombre de reférences créées, référence active/inactive
		List<String> tab = new ArrayList<>();
		for(int i=0; i<nbr; i++) {
			tab.add(elts.get(i).getText().trim());
			tab.add(elts1.get(i).getText().trim());
			tab.add(elts2.get(i).getText().trim());
			
			//Vérification de la présence de toutes les données
			if(tab.size()<=3) {
				System.out.println(tab);
			}else {
				System.out.println("Des informations sont manquantes......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			}
			tab.clear();
		}
		System.out.println("\r");
		return null;
	}
}

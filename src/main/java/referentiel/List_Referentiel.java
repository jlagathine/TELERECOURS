package referentiel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lesFonctions.MesFonctions;

public class List_Referentiel {
	
	public static Object Classement_ordre_alphabetique(WebDriver driver) {
		//Identifier la liste des référentiels
		String myXpath = "//span[@id='ref_name']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));
		List<String> str = new ArrayList<>();
		int nbr = elt.size();
		
		//Vérification du classement par ordre alphabétique
		for(int i=0; i<nbr;  i++) {
			str.add(elt.get(i).getText().trim());
		}
		
		List<String> sortedString = str.stream().sorted().collect(Collectors.toList());
		int nb = sortedString.size();
		boolean value = false;
		for (int i=0; i<nb; i++) {
			if(sortedString.get(i).equals(str.get(i))) {
				System.out.println("Le référentiel : "+sortedString.get(i)+" correspond bien : "+str.get(i)+" ;");
				value = true;
			}else {
				System.err.println("Le référentiel : "+sortedString.get(i)+" ne correspond pas : "+str.get(i)+" ;");
				value = false;
				break;
			}
		}
		if(value == true) {
			System.out.println("\rLe classement par odre alphabétique a été controlé sans erreur......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
			System.err.println("Le classement par odre alphabétique a été controlé avec des erreurs......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		
		return null;
	}

}

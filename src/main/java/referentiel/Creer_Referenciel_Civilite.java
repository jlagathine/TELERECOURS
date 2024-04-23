package referentiel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import lesFonctions.MesFonctions;

public class Creer_Referenciel_Civilite {
	
	public static Object click_civilite(WebDriver driver) {
		//Click "Civilité"
		String myXpath = "//span[@id='ref_name' and text()='Civilités']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Click \"Civilité\""+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Vérification de la page civilité
		myXpath = "//span[contains(text(),\"Civilité\")]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Accès à la page de consultation des référentiels liés à la CIVILITE ......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object clickBtn_CREER(WebDriver driver) {
		//Click bouton CREER
		String myXpath = "//a[@title=\"Créer un nouvelle donnée de réference\"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Click bouton CREER......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object libelle_civilite_CREATION(WebDriver driver) {
		//Libellé masculin
		String libMasc = "Monsieur le Directeur";
		String libFem = "Madame la Directrice";
		String libMascCourt = "Mr le Directeur";
		String libFemCourt = "Mme la Directrice";
		
		//Libellé masculin 
		String myXpath = "//input[@id='civilite_0_male_label']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(libMasc);
		System.out.println("Libellé masculin renseigné......"+MesFonctions.extractCurrentHeure());
		
		//Libellé féminin
		myXpath = "//input[@id='civilite_0_female_label']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(libFem);
		System.out.println("Libellé féminin renseigné......"+MesFonctions.extractCurrentHeure());
		
		//Libellé court masculin
		myXpath = "//input[@id='civilite_0_male_short_label']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(libMascCourt);
		System.out.println("Libellé court masculin renseigné......."+MesFonctions.extractCurrentHeure());
		
		//Libellé court féminin
		myXpath = "//input[@id='civilite_0_female_short_label']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(libFemCourt);
		System.out.println("Libellé court masculin renseigné......."+MesFonctions.extractCurrentHeure()+"\r");
		
		System.out.println("Libellés renseignés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object libelle_civilite_SUIVI(WebDriver driver) {
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur hendrerit lorem id erat gravida, at volutpat dui molestie. "
				+ "Praesent fringilla molestie imperdiet. Proin lacinia ipsum vitae mi tincidunt, sed luctus leo fringilla. "
				+ "Donec ornare lacus non tempor sodales. Pellentesque pellentesque orci in nulla egestas mattis. Maecenas dui ipsum, imperdiet id nisl sit amet, malesuada imperdiet elit. "
				+ "Donec at posuere nulla. Morbi tincidunt eu ligula a ultrices. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.";
		String myXpath = "//textarea[@id='civilite_0_comment']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		return null;
	}
	
	public static Object choix_juridiction_CE(WebDriver driver) {
		//Sélection juridiction CE
		String myXpath = "//input[@id='type_juridiction_CE']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Sélection juridiction CE......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Définition de la validité
		String debVal = "22/06/2021";
		String finVal = "22/06/2024";
		
		//Date de début de validité du référentiel
		myXpath = "//input[@id='civilite_0_juridictions_-1_validity_start_date']//following-sibling::input[contains(@class,\"icon-calendar form\")]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(debVal);
		System.out.println("Date de début de validité du référentiel renseignée......."+MesFonctions.extractCurrentHeure());
		
		//Date de fin de validité du référentiel 
		myXpath = "//input[@id='civilite_0_juridictions_-1_validity_end_date']//following-sibling::input[contains(@class,\"icon-calendar form\")]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(finVal);
		System.out.println("Date de fin de validité du référentiel renseignée......."+MesFonctions.extractCurrentHeure());
		
		myXpath = "//input[@id='type_juridiction_CE']//following-sibling::label";
		System.out.println("La validité du référentiel pour cette juridiction : "+MesFonctions.objet(driver, myXpath).getText().trim()+"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static Object clkBtn_VALIDER(WebDriver driver) {
		String myXpath = "//input[@id='new_valider_form_submit']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Le référentiel a été créé......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
}

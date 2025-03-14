package referentiel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lesFonctions.MesFonctions;

public class Referentiels_Pagination {
	
	
	public static void verification_pagination (WebDriver driver) throws Throwable {
		//Identifier la liste des référentiels
		String myXpath = "//span[@id='ref_name']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));
		int nbr = elt.size();
		
		for(int i=1;i<=nbr;i++) {
			//Accéder à un référentiel
			String myXpath0 = "(//span[@id='ref_name'])["+i+"]";
			String nom = MesFonctions.objet(driver, myXpath0).getText();//elt.get(i).getText();
			MesFonctions.goToDown(driver, myXpath);
			Thread.sleep(300);
			MesFonctions.objet(driver, myXpath0).click();//elt.get(i).click();
			System.out.println("Accès au référentiel : "+nom+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Vérifier le paramétrage par défaut de la pagination
			String myXpath1 = "//form[@id='form-pagination']//select[@id='per_page']//option[@selected='selected']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			Integer pge = MesFonctions.convertStringTo_Integer(MesFonctions.objet(driver, myXpath1).getText());
			if(pge==20) {
				System.out.println("La pagination est par défaut réglée sur : 20 enregistrements.... "+MesFonctions.extractCurrentHeure());
			}
			
			//Nombre d'élément de la liste
			boolean verif = false;
			String myXpath2 = "//tr[contains(@class,'table-row')]";//"//tr[contains(@class,'table-row actif-ref')]";
			Thread.sleep(300);
			
			if(MesFonctions.isElementPresent(driver, myXpath2, verif)) {
				
			List<WebElement> elt_1 = driver.findElements(By.xpath(myXpath2));
			int nbr_1 = elt_1.size();
			
			String myXpath21 ="(//ul[@class='pagination'])[2]//a[contains(@href,'page=') and text()]";
				if(MesFonctions.isElementPresent(driver, myXpath21, verif)) {
					System.out.println("Présence d'une pagination");
					if(nbr_1==pge) {
						System.out.println("Nombre d'élément(s) de la liste : "+nbr_1+" ( égal à la "+pge+".....)"+MesFonctions.extractCurrentHeure()+"\r");
					}else {
						System.err.println("Nombre d'élément(s) de la liste : "+nbr_1+" ( inférieur à la "+pge+".....)"+MesFonctions.extractCurrentHeure()+"\r");
							}
						}
						else {
						if(nbr_1<=pge) {
							System.out.println("Aucune pagination");
							System.out.println("Nombre d'élément(s) de la liste : "+nbr_1+" (inférieur ou égal à "+pge+".....)"+MesFonctions.extractCurrentHeure()+"\r");
						}else {
							System.out.println("Nombre d'élément(s) de la liste : "+nbr_1+" (supérieur à "+pge+".......)"+MesFonctions.extractCurrentHeure()+"\r");
						}
					}
				}else {
					String myXpath01 = "//label[@id='total']";
					MesFonctions.waiting2(driver, myXpath01, Duration.ofSeconds(3));
					System.out.println(MesFonctions.objet(driver, myXpath01).getText()+" résultat(s) trouvé(s)....."+MesFonctions.extractCurrentHeure()+"\r");
				}
			
			//Retour à la liste des référentiels
			String myXpath3 = "//a[contains(text(),\"Liste des référentiels\")]";
			MesFonctions.waiting2(driver, myXpath3, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath3).click();
			System.out.println("Retour à la liste des référentiels....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
		}
	}
	
	static public void modification_pagination(WebDriver driver) {
		
	}

}

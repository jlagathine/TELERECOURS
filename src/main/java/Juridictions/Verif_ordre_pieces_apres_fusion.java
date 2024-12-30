package juridictions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import lesFonctions.MesFonctions;

public class Verif_ordre_pieces_apres_fusion {
	
	public static void conglet_telechargement(WebDriver driver) {
		//Accéder à l'onglet de téléchargement 
		String myXpath = "//td[@id='Entete1_MenuActeur1_im1_AR']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Accès à l'onglet de téléchargement....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	}
	
	public static void telechargement_de_la_fusion_des_pieces(WebDriver driver) throws InterruptedException {
		//Accès à l'archive créée
		String myXpath = "//a[text()='Disponible']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Accès à l'archive créée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Téléchargement de l'archive
		myXpath = "//a[@id='rptPiecesJointe_ctl01_lnkFichierArchive_hplFichier']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Téléchargement de l'archive....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//changement de fenêtre
		String onglet = MesFonctions.getWindow(driver, 2);
		driver.switchTo().window(onglet);
		myXpath = "/html/body";
		
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Accès au téléchargement....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		Thread.sleep(5000);
		
		driver.close();
		onglet = MesFonctions.getWindow(driver, 1);
		driver.switchTo().window(onglet);	
	}

}

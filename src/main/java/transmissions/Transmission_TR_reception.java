package transmissions;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;

public class Transmission_TR_reception {

	public static Object type_transmission(WebDriver driver, String type) {
		//Selection du type de réception de transmission
		switch (type) {
		case "renvoi":
			String myXpath = "//input[@id='2']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			myXpath = "//input[@id='2']//following-sibling::label";
			System.out.println("Le type de transmission : "+MesFonctions.objet(driver,myXpath).getText().trim()+" a été sélectionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "decision":
			myXpath = "//input[@id='3']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			myXpath = "//input[@id='3']//following-sibling::label";
			System.out.println("Le type de transmission : "+MesFonctions.objet(driver,myXpath).getText().trim()+" a été sélectionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
			
		case "DPI/DPA":
			myXpath = "//input[@id='1']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			myXpath = "//input[@id='3']//following-sibling::label";
			System.out.println("Le type de transmission : "+MesFonctions.objet(driver,myXpath).getText().trim()+" a été sélectionné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;

		default:
			break;
		}
		
		return null;
	}
	
	public static Object acces_onglet_renvoi_DPI_DPA(WebDriver driver, String jur) {
		//Accès onglet renvoi_DPI/DPA
		String myXpath = "//td[@id='Entete1_MenuActeur1_im1_AL']";//Mstr_cpEntete_Entete1_MenuActeur1_im1_AL
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("Click onglet \"RENVOI_DPI\\DPA\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Vérification de l'accès à l'écran de transmission
		myXpath = "//h2[@id='txtTitrePage']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Ecran de réception d'une transmission....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object dossier_transmis(WebDriver driver, String dossier) {
		//Définir le dossier transmission
		String myXpath = "//input[@id='Mstr_cpMain_txtDossierTransmis']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver,myXpath).sendKeys(dossier);
		
		System.out.println("Le dossier transmis a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object btn_rechercher_transmission_receptionnee(WebDriver driver) {
		//Click bouton "RECHERCHER"
		String myXpath = "//a[@id='Mstr_cpMain_lbRecherche']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver,myXpath).click();
		System.out.println("Click bouton \"RECHERCHER\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static Object click_lien_transmission(WebDriver driver, String dossier) {
		//Click lien "DOSSIER"
		String myXpath = "//a[contains(@id,'Mstr_cpMain_gvTransmissions_') and contains(text(),'"+dossier+"')]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver,myXpath).click();
		System.out.println("Click lien \"DOSSIER\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object dossier_destinantion(WebDriver driver, String type, String req) throws Throwable {
		if(type!="DPI/DPA") {
			//Renseigner le dossier de destinantion 
			String myXpath = "//input[@id='Mstr_cpMain_txtDossierDest']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).clear();
			MesFonctions.objet(driver, myXpath).sendKeys(req);
			Keyboard.keyBoard(KeyEvent.VK_ENTER);
			System.out.println("Le dossier de destination est renseigné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			Thread.sleep(500);
		}
		
		return null;
	}
	
	public static Object choix_mesure_transmission(WebDriver driver) {
		//Sélection de la mesure
		String myXpath = "//select[@id='Mstr_cpMain_ddlMesure']";
		int index = 1;
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.selection_byIndex(driver, myXpath, index);
		
		//Vérification de la mesure sélectionnée
		myXpath = "(//select[@id='Mstr_cpMain_ddlMesure']//option)[2]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("La mesure : \""+MesFonctions.objet(driver,myXpath).getText().trim()+"\" a été sélectionnée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static Object transmission_trc_rattachement(WebDriver driver) throws Throwable {
		//gestion des acteur dans le cas d'un dossier TRC
		String myXpath = "//span[@class='legend' and contains(text(),'Rattachement des acteurs Télérecours Citoyens du dossier transmis')]";
		boolean verif = false;
		if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
			System.out.println("La transmission concerne un dossier TRC....."+MesFonctions.extractCurrentHeure()+"\r");
			
			//Sélection des acteurs du dossier à rattacher à l'acteur TRC
			myXpath = "//a[@title='Créer']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Création du rattachement....."+MesFonctions.extractCurrentHeure()+"\r");
			
			//Ecran de séletion du rattachement
			//Accès à la fenêtre
			String onglet =  MesFonctions.getWindow(driver, 2);
			driver.switchTo().window(onglet);
			myXpath = "//h3";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			
			//Sélection du requérant
			myXpath = "//td[text()='Requérant']";
			if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
				myXpath = "(//input[contains(@id,'cbx')])[2]";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver,myXpath).click();
				System.out.println("Le requérant a été sélectionné....."+MesFonctions.extractCurrentHeure()+"\r");
				
			//valider la sélection
			myXpath = "//input[@id='btValider']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver,myXpath).click();
			System.out.println("Le rattachement a été validé....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			//Retour à fenêtre principale
			onglet = MesFonctions.getWindow(driver, 1);
			driver.switchTo().window(onglet);
			
			}else {
				System.err.println("Pas de requérant présent");
			}
		}else {
			System.err.println("Cette transmission ne concerne pas un dossier TRC....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
	
	public static Object enregister_transmission(WebDriver driver) throws Throwable {
		//Vérifier la préssence du fichier de transmission
		String myXpath = "//a[contains(@id,'Mstr_cpMain_rptFichier')]";
		boolean verif = false;
		if(MesFonctions.isElementPresent(driver, myXpath, verif)) {
			System.out.println("Le fichier de transmission est bien présent....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
			System.err.println("Le fichier de transmission n'est pas présent....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		//Enregistrer la transmission 
		myXpath = "//a[(@id='Mstr_cpMain_lbEnregistrer')]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		System.out.println("La transmission a été enregistrée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Confirmation de la transmission
		myXpath = "//span[@class='ui-button-text' and text()='OK']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver,myXpath).click();
		System.out.println("Confirmation de l'enregistrement......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Vérification de l'accès à l'écran de transmission
		myXpath = "//h2[@id='txtTitrePage']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Retour à l'écran de réception d'une transmission....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		return null;
	}
	
	public static Object Verification_Transmission_Enregistree(WebDriver driver, String type, String req_trans, String req_dest) {
		//Choix du type de la transmission
		Transmission_TR_reception.type_transmission(driver, type);
		
		//Click bouton rechercher
		Transmission_TR_reception.btn_rechercher_transmission_receptionnee(driver);
		
		//Verification état de la transmission après traitement
		String myXpath = "//a[contains(@id,'Mstr_cpMain_gvTransmissions') and text()='"+req_trans+"']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		myXpath = "//a[contains(@id,'Mstr_cpMain_gvTransmissions')]";
		System.out.println("Dossier transmis : "+MesFonctions.objet(driver, myXpath).getText().trim());
		
		myXpath = "//a[contains(@id,'Mstr_cpMain_gvTransmissions') and text()='"+req_trans+"']//parent::td//following-sibling::td[text()='"+req_dest+"']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		myXpath = "//a[contains(@id,'Mstr_cpMain_gvTransmissions') and text()='"+req_trans+"']//parent::td//following-sibling::td";
		System.out.println("Dossier de destinantion : "+MesFonctions.objet(driver, myXpath).getText().trim());
		
		myXpath = "//a[contains(@id,'Mstr_cpMain_gvTransmissions') and text()='"+req_trans+"']//parent::td//following-sibling::td[text()='"+req_dest+"']//following-sibling::td";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		
		
		if(MesFonctions.objet(driver, myXpath).getText().trim().equals("Enregistré")) {
			System.out.println("Etat du dossier : "+MesFonctions.objet(driver, myXpath).getText().trim());
		}else {
			System.err.println("Etat du dossier : "+MesFonctions.objet(driver, myXpath).getText().trim()+"\r");
		}
		
		return null;
	}
}

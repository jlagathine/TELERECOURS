package transmissions;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;
import myKeyboard.Keyboard;

public class Transmission_TR_expediteur {
	
	static String value;
	
	public static Object selection_dossier(WebDriver driver, String num_doss) throws Throwable {
		MicroFonctions.rechercheSimple(driver, num_doss);
		return null;
	}
	
	
	public static Object choix_site_juridiction(WebDriver driver, String jur, String id, String mdp, String env) {
		switch (jur) {
		
		case "TA":
			if(env=="rec") {
				driver.get("https://www.telerecours.recette.juradm.fr/TA75");
				MicroFonctions.AuthentificationTaCaaCeInt(driver, id, mdp);
			}else {
				driver.get("https://www.telerecours.int1.juradm.fr/TA75");
				MicroFonctions.AuthentificationTaCaaCeInt(driver, id, mdp);
			}
			
			break;
			
		case "CAA":
			if(env=="rec") {
				driver.get("https://www.telerecours.recette.juradm.fr/CA75");
				MicroFonctions.AuthentificationTaCaaCeInt(driver, id, mdp);
			}else {
				driver.get("https://www.telerecours.int1.juradm.fr/CA75");
				MicroFonctions.AuthentificationTaCaaCeInt(driver, id, mdp);
			}
			
			break;
			
		case "CTX":
			if(env=="rec") {
				driver.get("https://www.telerecours.recette.conseil-etat.fr/conseil");
				MicroFonctions.AuthentificationTaCaaCeInt(driver, id, mdp);
			}else {
				driver.get("https://www.telerecours.int1.conseil-etat.fr/conseil");
				MicroFonctions.AuthentificationTaCaaCeInt(driver, id, mdp);
			}
			break;

		default:
			break;
		}
		return null;
	}
	
	public static Object type_transmission(WebDriver driver, String type) throws InterruptedException {
		switch (type) {
		
		case "renvoi":
			String myXpath = "//select[@id='Mstr_cpMain_ddlTypeTransmission']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			value= "2";
			MesFonctions.selection(driver, myXpath, value);
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeTransmission']//option[@value='"+value+"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			System.out.println("La valeur : \""+MesFonctions.objet(driver, myXpath).getText().trim()+"\" a été sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "DPI/DPA":
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeTransmission']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			value= "1";
			MesFonctions.selection(driver, myXpath, value);
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeTransmission']//option[@value='"+value+"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			System.out.println("La valeur : \""+MesFonctions.objet(driver, myXpath).getText().trim()+"\" a été sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "decision":
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeTransmission']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			value= "3";
			MesFonctions.selection(driver, myXpath, value);
			myXpath = "//select[@id='Mstr_cpMain_ddlTypeTransmission']//option[@value='"+value+"']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			System.out.println("La valeur : \""+MesFonctions.objet(driver, myXpath).getText().trim()+"\" a été sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;

		default:
			break;
		}
		return null;
	}
	
	public static Object choix_juridiction(WebDriver driver, String jur) throws InterruptedException {
		switch (jur) {
		
		case "TA":
			String myXpath = "//select[@id='Mstr_cpMain_ddlJuridiction']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			value= "TA75";
			MesFonctions.selection(driver, myXpath, value);
			myXpath = "//select[@id='Mstr_cpMain_ddlJuridiction']//option[@value='"+value+"']";
			Thread.sleep(70);
			System.out.println("La valeur : \""+MesFonctions.objet(driver, myXpath).getText().trim()+"\" a été sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "CAA":
			myXpath = "//select[@id='Mstr_cpMain_ddlJuridiction']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			value= "CA75";
			MesFonctions.selection(driver, myXpath, value);
			myXpath = "//select[@id='Mstr_cpMain_ddlJuridiction']//option[@value='"+value+"']";
			Thread.sleep(70);
			System.out.println("La valeur : \""+MesFonctions.objet(driver, myXpath).getText().trim()+"\" a été sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;
			
		case "CTX":
			myXpath = "//select[@id='Mstr_cpMain_ddlJuridiction']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			Thread.sleep(70);
			value= "CE";
			MesFonctions.selection(driver, myXpath, value);
			myXpath = "//select[@id='Mstr_cpMain_ddlJuridiction']//option[@value='"+value+"']";
			Thread.sleep(70);
			System.out.println("La valeur : \""+MesFonctions.objet(driver, myXpath).getText().trim()+"\" a été sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			
			break;

		default:
			break;
		}
		return null;
	}

	public static Object acces_ecran_transmission(WebDriver driver) throws Throwable {
		//Click bouton transmettre
		String myXpath = "//a[@id='Mstr_cpMain_hlTransmission']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver,myXpath).click();
		System.out.println("Click bouton \"TRANSMETTRE\"....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Ecran de transmission
		myXpath = "//h2[@id='txtTitrePage']";
		if(MesFonctions.objet(driver, myXpath).getText().trim().equals("Transmission du dossier")) {
			System.out.println("Accès à l'écran de transmission...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r"); 
		}else {
			throw new Exception("Erreur d'accès à l'écran de transmission......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
	
	public static Object formulaire_ecran_transmission(WebDriver driver, String type, String jur, String req) throws Throwable {
		//Choix du type de transmission
		Transmission_TR_expediteur.type_transmission(driver, type);
		
		//Choix de la juridiction
		Transmission_TR_expediteur.choix_juridiction(driver, jur);
		System.out.println("La juridiction a été sélectionnée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Dossier de destinantion
		if(type.equals("DPI/DPA")) {
			String myXpath ="//input[@id='Mstr_cpMain_txtDossierDestination']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(req);
			Thread.sleep(200);
			Keyboard.keyBoard(KeyEvent.VK_ENTER); 
			
			Thread.sleep(200);
			String myXpath1 = "//label[@id='Mstr_cpMain_ucDetailDossierDestination_labelRequerant']";
			myXpath = "//span[@id='Mstr_cpMain_ucDetailDossierDestination_splitRequerant']";
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			System.out.println("Le dossier de destination est renseigné : "+MesFonctions.objet(driver, myXpath1).getText()+""+MesFonctions.objet(driver, myXpath).getText().trim());
		}
		
		//Courriel de l'expéditeur
		String myXpath = "//input[@id='Mstr_cpMain_txtEmailExp']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).clear();
		MesFonctions.objet(driver, myXpath).sendKeys("johan.agathine@conseil-etat.fr");
		System.out.println("Le courriel a été renseignée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Message
		String texte = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi massa risus, porttitor id sapien id, vestibulum ullamcorper lacus. "
				+ "Donec sodales rhoncus neque, sit amet facilisis augue tristique a. "
				+ "In vehicula turpis eu lobortis dapibus. Sed tristique scelerisque porttitor. "
				+ "Ut suscipit varius urna, quis tincidunt mauris gravida iaculis. Ut in erat at dui efficitur faucibus. "
				+ "Aenean pellentesque purus arcu, vitae sodales mauris congue sed. In at efficitur nibh. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Cras at ipsum vitae ipsum posuere tincidunt eu quis tortor. Sed non imperdiet ipsum. Sed sit amet leo in velit tempus vestibulum consectetur id nisi. Praesent a augue est.\r\n"
				+ "\r\n"
				+ "Interdum et malesuada fames ac ante ipsum primis in faucibus. "
				+ "Integer consequat semper laoreet. Nullam pellentesque, lectus eget dictum eleifend, lacus mi consequat ipsum, sit amet volutpat nisi sapien dictum sapien. "
				+ "Duis non augue nisl. Praesent eu metus eu sapien pulvinar elementum. Suspendisse eget egestas felis. Fusce dictum faucibus orci a tincidunt. "
				+ "Ut malesuada placerat semper. Integer luctus nibh ut efficitur interdum. Quisque varius cursus sapien egestas cursus. Interdum et malesuada fames ac ante ipsum primis in faucibus. "
				+ "Maecenas a tempus sem. In euismod ipsum enim, eu ultricies ex ultricies ut. Pellentesque euismod laoreet scelerisque. Nulla porta faucibus enim.\r\n"
				+ "\r\n"
				+ "Sed vestibulum erat quis sem varius, vel aliquet lorem posuere. Curabitur porttitor egestas ligula commodo facilisis. "
				+ "Praesent tristique erat sit amet massa gravida egestas. Praesent nec risus euismod, fringilla mauris nec, efficitur turpis. "
				+ "Ut sit amet mauris at ante ultrices bibendum sit amet sit amet nisl. Cras blandit dapibus tellus, condimentum sodales neque imperdiet sodales. "
				+ "Sed eu nisi sollicitudin, ultrices quam et, sollicitudin velit. Aenean efficitur magna ac justo ullamcorper scelerisque. "
				+ "Quisque rutrum venenatis erat eget blandit. Phasellus condimentum mollis elit vel venenatis. Praesent eget velit blandit, lacinia nisi nec, blandit odio. "
				+ "Etiam nec augue ac ante dignissim laoreet in in leo. Vestibulum at suscipit urna. In massa mi, consectetur ac consequat in, aliquet vitae ex. "
				+ "Quisque ut ex fermentum, varius mauris sed, facilisis ex.\r\n"
				+ "\r\n"
				+ "Nam porta, purus sit amet vestibulum eleifend, massa ipsum porttitor velit, non mattis ante ex sed dolor. "
				+ "Integer id lacus vitae justo condimentum pharetra feugiat ac odio. Aliquam porta ornare turpis, eget molestie augue placerat bibendum. "
				+ "Fusce convallis ac ligula in iaculis. Curabitur in velit nec neque imperdiet congue. Nam rhoncus, magna vel mattis egestas, lorem ipsum eleifend lorem, non faucibus massa nisl quis velit. "
				+ "Nam dictum felis at lectus ultrices consectetur. Fusce est nunc, ornare ut vehicula sed, iaculis ut diam. Nulla in erat ligula. Praesent tincidunt sapien quis faucibus viverra.";
		
		myXpath = "//textarea[@id='Mstr_cpMain_txtMessage']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(texte);
		System.out.println("Le motif de transmission a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static Object ajout_piece_transmission(WebDriver driver, int nbr_file) throws Throwable {
		String myXpath = "//input[@id='fileupload']";
		Thread.sleep(500);
		for(int i=0; i<nbr_file; i++) {
			int pcs = i+2;
			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Le mémoire 5\\00"+pcs+" Le Mémoire.pdf");
			Thread.sleep(200);
			System.out.println("La pièce : "+pcs+"....."+MesFonctions.extractCurrentHeure());
		}
		System.out.println("Toutes les pièces ont été rajoutées......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static Object btn_envoyer_transmission(WebDriver driver) throws Throwable {
		//Click bouton "ENVOYER"
		Thread.sleep(700);
		String myXpath = "//a[@id='Mstr_cpMain_lbEnvoyer']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver,myXpath).click();
		
		System.out.println("Click bouton \"ENVOYER\"......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//confirmation de l'envoi
		myXpath = "//span[@class='ui-button-text' and text()='OK']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver,myXpath).click();
		System.out.println("Confirmation de l'envoi......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Message lié à l'envoi
		myXpath = "//div[@id='ui-id-2']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		String mess = MesFonctions.objet(driver,myXpath).getText();
		
		//Valider le message
		System.out.println(mess+"...."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		myXpath = "//span[@class='ui-button-text' and text()='OK']";
		MesFonctions.objet(driver,myXpath).click();
		return null;
	}
	
}

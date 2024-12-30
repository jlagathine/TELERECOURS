package trc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lesFonctions.MesFonctions;




public class Trc_depot_formulaire {
	
	
	public static String Trc_formulaire_2_requete_DALO(WebDriver driver) throws Throwable {
		String texte = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
	
		//Votre requête concerne-t-elle un contentieux social ? 
   		String myXpath = "//input[@id='csr-oui']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.goToDown(driver, myXpath);
   		Thread.sleep(800);
   		MesFonctions.objet(driver, myXpath).click();
   		System.out.println("La requête concerne un contentieux social......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//accepter la fenêtre
   		myXpath = "//span[contains(text(),\"OK\")]";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.objet(driver,  myXpath).click();
   		System.out.println("L'avertissement a été accepté......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Ajout du document RAPO
   		myXpath = "//input[@id='rapo']";
   		MesFonctions.goToDown(driver, myXpath);
   		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 - RAPO.pdf");
   		System.out.println("Le fichier RAPO a été ajouté dans la partie 3......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Avez-vous le document comprenant la décision que vous contestez?
   		myXpath = "//input[@id='has-document']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.goToDown(driver, myXpath);
   		Thread.sleep(800);
   		MesFonctions.objet(driver, myXpath).click();
   		System.out.println("Bouton radio \"oui\" sélectionné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Ajout de la décision attaquée
   		for(int i=0;i<3;i++) {
   			myXpath = "//input[@id='acte-attaque-document-"+i+"1']";
   			MesFonctions.goToDown(driver, myXpath);
   			Thread.sleep(300);
   			if(i==0) {
   				Thread.sleep(100);
   				MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La décision.pdf");
   			}else if(i==1) {
   				MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\4 Avis_impot.pdf");
   			}else if(i==2) {
   				MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Acte attaquée 1.pdf");
   			}
   			Thread.sleep(100);
   		}
   		
   		System.out.println("Les fichiers de la décision attaquée ont été ajoutés dans la partie 4......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Quelle administration a pris cette décision ?
   		myXpath = "//input[@id='nom-administration']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.goToDown(driver, myXpath);
   		Thread.sleep(800);
   		MesFonctions.objet(driver, myXpath).sendKeys("PREFECTURE 94");
   		System.out.println("Champ administration de la partie 5 renseigné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Objet de votre demande
   		myXpath = "//textarea[@id='objet-demande']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.goToDown(driver, myXpath);
   		Thread.sleep(800);
   		MesFonctions.objet(driver, myXpath).sendKeys("Revenu de solidarité active (RSA)");
   		System.out.println("Champ de la partie 6 renseigné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Précisez votre demande
   		myXpath = "//textarea[@id='motifs-demande']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.goToDown(driver, myXpath);
   		Thread.sleep(800);
   		MesFonctions.objet(driver,  myXpath).sendKeys(texte);
   		System.out.println("Champ motif de la demande de la partie 7 renseigné......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Indiquez les motifs de votre demande
   		myXpath = "//textarea[@id='conclusionDALO-demande']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.goToDown(driver, myXpath);
   		Thread.sleep(800);
   		MesFonctions.objet(driver,  myXpath).sendKeys(texte);//erreur créée du fait du nombre de catractères trop important dans le champ
   		System.out.println("Champ de la conclusion de la partie 8 renseigné......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
		return null;

	}
	
	
	public static String Trc_formulaire_3_decision_administration (WebDriver driver) throws Throwable {
		//Vérification de la présence du titre 3
		String myXpath = "//h2[text()=\"Vous souhaitez : \"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		System.out.println("le titre 3 : "+MesFonctions.objet(driver, myXpath).getText()+" est affiché......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Click sur la première option de la partie 3
   		myXpath = "//input[@id='radio-souhait 1']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.objet(driver,  myXpath).click();
   		
   		//Vérification de la présence des autres partie du formulaire
   		myXpath = "//h2[@class='ng-star-inserted']";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		int nbr = titre.size();
   		if(nbr!=9) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   	   		for(WebElement a: titre) {
   	   			System.out.println(a.getText());
   	   		}
   		}
//   		assertEquals(9, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+mesFonctions.extractCurrentHeure());
   		
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		
   		
   		Trc_depot_formulaire.remplissage_question_4(driver, "non");
   		Trc_depot_formulaire.remplissage_question_5(driver);
   		Trc_depot_formulaire.remplissage_question_6(driver);
   		Trc_depot_formulaire.remplissage_question_7(driver);
   		Trc_depot_formulaire.remplissage_question_8(driver);
   		Trc_depot_formulaire.remplissage_question_9(driver);
   		
   		
   		//Valider (suivant)
	   myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	   List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	   nbr = elements.size();
	   if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath).click();
		  Thread.sleep(500);
	   }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
	   
	   	//Cocher la case de vérification
	 	String	myXpath3 = "//input[@id='conditionRenommageCheckbox']//following-sibling::label";
	 	MesFonctions.objet(driver, myXpath3).click();
	 	Thread.sleep(1000);
	 	
	 	//Valider (suivant)
	 	String myXpath4 = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivant\"))]";
		MesFonctions.objet(driver,myXpath4).click();
		Thread.sleep(2000);
		System.out.println("Validation de l'envoi avant vérification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	   
		return null;
	}
	
	
	public static String Trc_formulaire_3_somme_argent(WebDriver driver, String opt) throws Throwable {
		//Vérification de la présence du titre 3
		String myXpath = "//h2[text()=\"Vous souhaitez : \"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		System.out.println("le titre 3 : "+MesFonctions.objet(driver, myXpath).getText()+" est affiché......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Click sur la deuxieme option de la partie 3
   		myXpath = "//input[@id='radio-souhait 2']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.objet(driver,  myXpath).click();
   		
   		//Vérification de la présence de la question 4 et ses trois options
   		myXpath = "//input[contains(@id,'radio-type')]//following-sibling::label";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		List<WebElement> list = MesFonctions.objets(driver, myXpath);
   		
   		for(WebElement a:list) {
   			System.out.println("L'option "+a.getText().trim()+" est présente");
   		}
   		
   		//Selection de l'option dans la partie 4
   		switch (opt) {
		case "option1"://Vous réclamez une somme d'argent à l'administration
			Trc_depot_formulaire.trc_titre4_choix_1(driver);
			break;
			
		case "option2"://Vous contester une somme d'argent réclamée par l'administration
			String opt_9 = "option2";
			Trc_depot_formulaire.trc_titre4_choix_2(driver, opt_9);
			break;
			
		case "option3"://Vous réclamez une indemnisation pour une faute commise par l'administration 
			Trc_depot_formulaire.trc_titre4_choix_3(driver);
			break;

		default:System.err.println("option introuvable....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
   		
   		//Cocher la case de vérification
	 	String	myXpath3 = "//input[@id='conditionRenommageCheckbox']//following-sibling::label";
	 	MesFonctions.objet(driver,myXpath3).click();
	 	Thread.sleep(1000);
	 	
	 	//Valider (suivant)
	 	String myXpath4 = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivant\"))]";
		MesFonctions.objet(driver,myXpath4).click();
		Thread.sleep(2000);
		System.out.println("Validation de l'envoi avant vérification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		return null;
	}
	
	
	public static String Trc_formulaire_3_requete_redige_sois_meme(WebDriver driver) throws Throwable {
		//Vérification de la présence du titre 3
		String myXpath = "//h2[text()=\"Vous souhaitez : \"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		System.out.println("le titre 3 : "+MesFonctions.objet(driver, myXpath).getText()+" est affiché......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Click sur la première option de la partie 3
   		myXpath = "//input[@id='radio-souhait 3']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.objet(driver,  myXpath).click();
   		
   		//Vérification de la présence des autres partie du formulaire
   		myXpath = "//h2[@class='ng-star-inserted']";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		int nbr = titre.size();
   		if(nbr!=7) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   	   		for(WebElement a: titre) {
   	   			System.out.println(a.getText());
   	   		}
   		}
//   		assertEquals(7, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Remplissage du formulaire
   		Trc_depot_formulaire.remplissage_question_4quinter(driver);
   		Trc_depot_formulaire.remplissage_question_5bis(driver);
   		Trc_depot_formulaire.remplissage_question_6ter(driver);
   		Trc_depot_formulaire.remplissage_question_7ter(driver);
   		
   		//Valider (suivant)
		myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	    nbr = elements.size();
	    if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver,  myXpath).click();
		  Thread.sleep(1000);
	     }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
	    
	    //Cocher la case de vérification
	 	String	myXpath3 = "//input[@id='conditionRenommageCheckbox']//following-sibling::label";
	 	MesFonctions.objet(driver,myXpath3).click();
	 	Thread.sleep(1000);
	 	
	 	//Valider (suivant)
	 	String myXpath4 = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivant\"))]";
		MesFonctions.objet(driver,myXpath4).click();
		Thread.sleep(2000);
		System.out.println("Validation de l'envoi avant vérification......."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
		return null;
	}
	
	
	public static String Trc_formulaire_ctx_2_requete_redige_sois_meme(WebDriver driver) throws Throwable {
		//Vérification de la présence du titre 3
		String myXpath = "//h2[text()=\"Vous souhaitez : \"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		System.out.println("le titre 2 : "+MesFonctions.objet(driver, myXpath).getText()+" est affiché......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Click sur la première option de la partie 3
   		myXpath = "//input[@id='radio-souhait 3']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.objet(driver,  myXpath).click();
   		
   		//Vérification de la présence des autres partie du formulaire
   		myXpath = "//h2[@class='ng-star-inserted']";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		int nbr = titre.size();
   		if(nbr!=5) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   	   		for(WebElement a: titre) {
   	   			System.out.println(a.getText());
   	   		}
   		}
//   		assertEquals(5, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(WebElement a: titre) {
//   			System.out.println(a.getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Remplissage du formulaire
   		Trc_depot_formulaire.remplissage_question_4quinter(driver);
   		Trc_depot_formulaire.remplissage_question_5ter(driver);
   		Trc_depot_formulaire.remplissage_question_6ter(driver);
   		Trc_depot_formulaire.remplissage_question_7ter(driver);
   		
   		//Valider (suivant)
		myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	    nbr = elements.size();
	    if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver,  myXpath).click();
		  Thread.sleep(1000);
	     }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
   		
		return null;
	}
	
	
	public static String remplissage_question_4(WebDriver driver, String chx) throws Throwable {
		switch (chx) {
		//Click OUI => L'utilisateur dispose de l'acte attaqué
		case "oui":
			String myXpath = "//input[@id='has-document']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath);
	   		MesFonctions.objet(driver,  myXpath).click();
	   		System.out.println("Avez-vous la décision attaquée ? "+MesFonctions.objet(driver,  myXpath+"//following-sibling::label").getText().trim()+"....."+MesFonctions.extractCurrentHeure());
	   		
	   		Thread.sleep(2000);
	   		myXpath = "//input[@id='acte-attaque-document-01']";
			WebElement element = MesFonctions.objet(driver, myXpath);
			element.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Acte attaqué.pdf");
	   		System.out.println("Le document de la décision attaquée a été ajouté....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	   		
			break;
		
		//Click NON => L'utilisateur ne dispose pas de l'acte attaqué
		case "non":
			myXpath = "//input[@id='no-document']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath);
	   		MesFonctions.objet(driver,  myXpath).click();
	   		System.out.println("Avez-vous la décision attaquée ? "+MesFonctions.objet(driver,  myXpath+"//following-sibling::label").getText().trim()+"....."+MesFonctions.extractCurrentHeure());
	   		
	   		Thread.sleep(2000);
	   		myXpath = "//input[contains(@id,'acte-attaque-document')]";
	   		element = MesFonctions.objet(driver, myXpath);
			element.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Acte attaqué.pdf");
	   		System.out.println("Le document de la décision attaquée a été ajouté....."+MesFonctions.extractCurrentHeure());
	   		
	   		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
					+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
					+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
					+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl. "
					+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
	   		
	   		myXpath = "//textarea[@id='raison-no-document']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(text);
			System.out.println("La raison de l'absence de décision attaquée a été renseignée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	   		
			break;

		default:
			break;
		}
		
		return null;
	}
	
	
	public static String remplissage_question_4bis(WebDriver driver) {
		//Sélection de la checkbox
		String myXpath = "//input[@id='radio-type 1']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		//Vérification de l'ensemble des champs du formulaire à remplir
		myXpath = "//h2[@class='ng-star-inserted']";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		int nbr = titre.size();
   		if(nbr!=11) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   	   		for(WebElement a: titre) {
   	   			System.out.println(a.getText());
   	   		}
   		}
//   		assertEquals(11, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
//		   		System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+mesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(WebElement a: titre) {
//   			System.out.println(a.getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");

		System.out.println("La checkbox est cochée dans la partie 4......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String remplissage_question_ctx_3(WebDriver driver) {
		//Sélection de la checkbox
		String myXpath = "//input[@id='radio-type 1']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		//Vérification de l'ensemble des champs du formulaire à remplir
		myXpath = "//h2[@class='ng-star-inserted']";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		int nbr = titre.size();
   		if(nbr!=10) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   	   		for(WebElement a: titre) {
   	   			System.out.println(a.getText());
   	   		}
   		}
//   		assertEquals(10, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
//		   		System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+mesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(WebElement a: titre) {
//   			System.out.println(a.getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");

		System.out.println("La checkbox est cochée dans la partie 4......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String remplissage_question_4ter(WebDriver driver) {
		//Sélection de la checkbox
		String myXpath = "//input[@id='radio-type 2']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		//Vérification de l'ensemble des champs du formulaire à remplir
		myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=9) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(9, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");

		System.out.println("La checkbox est cochée dans la partie 4......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String remplissage_question_ctx_3bis(WebDriver driver) {
		//Sélection de la checkbox
		String myXpath = "//input[@id='radio-type 2']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		//Vérification de l'ensemble des champs du formulaire à remplir
		myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=8) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(8, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");

		System.out.println("La checkbox est cochée dans la partie 4......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String remplissage_question_4quater(WebDriver driver) {
		//Sélection de la checkbox
		String myXpath = "//input[@id='radio-type 3']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		//Vérification de l'ensemble des champs du formulaire à remplir
		myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=12) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(12, nbr, "Le nombre de partie attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");

		System.out.println("La checkbox est cochée dans la partie 4......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String remplissage_question_ctx_3ter(WebDriver driver) {
		//Sélection de la checkbox
		String myXpath = "//input[@id='radio-type 3']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		//Vérification de l'ensemble des champs du formulaire à remplir
		myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=11) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(11, nbr, "Le nombre de partie attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");

		System.out.println("La checkbox est cochée dans la partie 4......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_4quinter(WebDriver driver) throws Throwable {
		//Renseigner le champ 5
		Thread.sleep(2000);
   		String myXpath = "//input[@id='acte-attaque-document-01']";
		WebElement element = MesFonctions.objet(driver, myXpath);
		element.sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Acte attaqué.pdf");
		System.out.println("Le champ de la partie 4 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		myXpath = "//button/i[@title='supprimer']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		return null;
	}

	public static String remplissage_question_5(WebDriver driver) {
		//Renseigner le champ 5
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
				+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
				+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
				+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl. "
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
		
		String myXpath = "//input[@id='nom-administration']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		System.out.println("Le champ de la partie 5 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		MesFonctions.goToDown(driver, myXpath);
		
		return null;
	}
	
	public static String remplissage_question_5bis(WebDriver driver) throws Throwable {
		//Renseigner le champ 5 ; utilisé aussi pourle champ 4 dans le cadre du formulaire question 3 option 3
		String myXpath = "//input[@id='reclamation-prealable-document-01']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 - document_REP.pdf");
		
		myXpath = "//input[@id='reclamation-prealable-piece-01-view']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Le champ de la partie 5 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_5ter(WebDriver driver) throws Throwable {
		//Renseigner le champ 5
		String myXpath = "//input[@id='requeteRedigee']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.docx");
		
		myXpath = "//input[@id='requeteRedigee-view']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Le champ de la partie 5 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String remplissage_question_6(WebDriver driver) {
		//Renseigner le champ 6
				String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
						+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
						+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
						+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl. "
						+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
				
				String myXpath = "//textarea[@id='objet-demande']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).sendKeys(text);
				System.out.println("Le champ de la partie 6 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				MesFonctions.goToDown(driver, myXpath);
				
		return null;
	}
	
	public static String remplissage_question_6bis(WebDriver driver) {
		//Renseigner le champ 6
				String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
						+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
						+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
						+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl. "
						+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
				
				String myXpath = "//input[@id='nom-administration']";
				MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
				MesFonctions.objet(driver, myXpath).sendKeys(text);
				System.out.println("Le champ de la partie 6 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				MesFonctions.goToDown(driver, myXpath);
				
		return null;
	}
	
	public static String remplissage_question_6ter(WebDriver driver) throws Throwable {
		//Renseigner le champ 6
		String myXpath = "//input[@id='requeteRedigee' and @type='file']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.docx");
		
//		myXpath = "//input[@id='requeteRedigee-view']";
//		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		System.out.println("Le champ de la partie 6 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		myXpath = "//input[@id='requeteRedigee-view']";
		boolean verif = false;
		while(!MesFonctions.isElementPresent(driver, myXpath, verif)) {
			myXpath = "//input[@id='requeteRedigee' and @type='file']";
			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.docx");
			System.out.println("tentative d'insertion de la pièce");
			Thread.sleep(1000);
			myXpath = "//input[@id='requeteRedigee-view']";
		}
		
		System.out.println("Le champ de la partie 6 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String remplissage_question_7(WebDriver driver) {
		//Renseigner le champ 7
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
						+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
						+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
						+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
						+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
						+ "\r\n"
						+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
						+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
						+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
						+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
						+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
						+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
						+ "\r\n"
						+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
						+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
						+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
						+ "\r\n"
						+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
						+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
						+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
						+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
						+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
				
			String myXpath = "//textarea[@id='contexte-intervention-decision']";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath).sendKeys(text);
			System.out.println("Le champ de la partie 7 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			MesFonctions.goToDown(driver, myXpath);
				
		return null;
	}
	
	public static String remplissage_question_7bis(WebDriver driver) {
		//Renseigner le champ 6
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
				+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
				+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
				+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl. "
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
		
		String myXpath = "//textarea[@id='objet-demande']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		System.out.println("Le champ de la partie 7 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		MesFonctions.goToDown(driver, myXpath);
				
		return null;
	}
	
	public static String remplissage_question_8(WebDriver driver) {
		//Sélectionner les raisons de la contestation dans la partie 8
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		String myXpath = "//input[contains(@id,'checkbox-rc-')]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
				
				//Choix des raisons contestées 
				List<Integer> used = new ArrayList<>();
				List<WebElement> chx = MesFonctions.objets(driver, myXpath);
				int nbr = chx.size();
				Random random = new Random();
				while (used.size()<3) {
					int i = random.nextInt(nbr+1);
					if(!used.contains(i)&&i!=0) {
						myXpath = "//input[@id='checkbox-rc-"+i+"']";
						MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
						MesFonctions.goToDown(driver, myXpath);
						MesFonctions.objet(driver,  myXpath).click();
						
						//Ajouter le texte justificatif
						if(i==6 || i==7) {
							myXpath = "//textarea[@id='raison-contestation-detail-"+i+"']";
							MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
							MesFonctions.objet(driver, myXpath).sendKeys(text);
								 if(i==6) {
									myXpath = "//input[@id='piece-complementaire-mi-adder-01']";
//									mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.pdf");
									text = "Justificatif_0"+i+"";
									myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
									MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									MesFonctions.goToDown(driver, myXpath);
									MesFonctions.objet(driver, myXpath).sendKeys(text);
									System.out.println("Le texte justificatif et la pièce ont été ajoutés pour la raison : "+i+"....."+MesFonctions.extractCurrentHeure());
								}else if(i==7) {
									myXpath = "//input[@id='piece-complementaire-ma-adder-01']";
//									mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\La requête.pdf");
									text = "Justificatif_0"+i+"";
									myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
									MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
									MesFonctions.goToDown(driver, myXpath);
									MesFonctions.objet(driver, myXpath).sendKeys(text);
									System.out.println("Le texte justificatif et la pièce ont été ajoutés pour la raison : "+i+"....."+MesFonctions.extractCurrentHeure());
								}
						}else {
							myXpath = "//textarea[@id='raison-contestation-detail-"+i+"']";
							MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
							MesFonctions.objet(driver, myXpath).sendKeys(text);
							System.out.println("Le texte justificatif est ajouté pour la raison : "+i+"....."+MesFonctions.extractCurrentHeure());
						}
						
					myXpath = "//input[@id='checkbox-rc-"+i+"']//following-sibling::label";
					System.out.println("la raison : \""+MesFonctions.objet(driver, myXpath).getText()+"\" a été sélectionnée et complétée....."+MesFonctions.extractCurrentHeure());
					
					used.add(i);
					System.out.println(used);
					}
				}
				
				System.out.println("La partie 8 est complétée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
		return null;
	}
	
	public static String remplissage_question_7ter(WebDriver driver) throws Throwable {
		//Renseigner le champ 6
		for(int i=0;i<5;i++) {
		String myXpath = "//input[@id='piece-complementaire-requete-redigee-just-adder-"+i+"1']";
		
		String myXpath1 = "//label[@class='nommer-piece-label']//following-sibling::div/input";
		MesFonctions.goToDown(driver, myXpath);
		if(i==0) {
			String text = "Justificatif_impôt";
			Thread.sleep(1000);
			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\Avis d'imposition 2020 - 2022.pdf");
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).sendKeys(text);
		}else if(i==1) {
			String text = "Justificatif_CAF";

			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\4 - Relevé_CAF.pdf");
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).sendKeys(text);
		}else if(i==2) {
			String text = "Justificatif_REP";

			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 - Document_Prealable_REP.pdf");
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).sendKeys(text);
		}else if(i==3) {
			String text = "Mémoire";

			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 Mémoire 3.docx");
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).sendKeys(text);
		}else if(i==4) {
			String text = "Justificatif_RAPO";

			MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\1 - RAPO.pdf");
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.objet(driver, myXpath1).sendKeys(text);
			}
		}
		System.out.println("Le champ de la partie 7 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");

		return null;
	}
	
	public static String remplissage_question_8bis(WebDriver driver) {
		//Sélection de la partie 8 correspondant à l'option du 2ème choix de la question 3 et du 1er choix de la question 4 
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		String myXpath = "//textarea[@id='contexte-intervention-decision']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		System.out.println("Le champ de la partie 8 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_8ter(WebDriver driver) {
		//Sélection de la partie 8 correspondant à l'option du 2ème choix de la question 3 et du 1er choix de la question 4 
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		String myXpath = "//textarea[@id='fait-conduit-au-litige']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		System.out.println("Le champ de la partie 8 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_8quater(WebDriver driver) {
		//Sélection de la partie 8 correspondant à l'option du 2ème choix de la question 3 et du 1er choix de la question 4 
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		String myXpath = "//textarea[@id='fait-conduit-situation-reparation']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		System.out.println("Le champ de la partie 8 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_9(WebDriver driver) {
		//Renseigner le champ 9
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
				+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
				+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
				+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl. "
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
		
		String myXpath = "//input[@id='conclusion-litige-admin-checkbox']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver,  myXpath).click();
		
		myXpath = "//textarea[@id='conclusion-litige-admin-autre']";
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		System.out.println("Le champ de la partie 9 a été renseigné....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
				
		return null;
	}
	
	public static String remplissage_question_9bis(WebDriver driver) throws Throwable {
		//Renseigner le champ 9
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
				+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
				+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
				+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl. "
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
		
		String myXpath = "//textarea[@id='pourquoi-somme-due']";
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		Thread.sleep(500);
		//Ajout de la pièce
		myXpath = "//input[@id='piece-complementaire-somme-due-adder-01']";
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 - Justificatif_somme_due.pdf");
		Thread.sleep(500);
		
		//Nommage de la pièce
		myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys("Ma somme due");
		System.out.println("Le texte justificatif et la pièce ont été ajoutés pour la partie 9 ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
		return null;
	}
	
	
	public static String remplissage_question_9ter(WebDriver driver, String opt_9) throws Throwable {
		//Renseigner le champ 9
		String myXpath = "//input[contains(@id,'radio-acte')]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elements = MesFonctions.objets(driver, myXpath);
		int nbr = elements.size();
		if(nbr!=2) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}
//		assertEquals(2, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
		
		
		switch (opt_9) {
		case "option1":
			//Click bouton radio opt 1
			myXpath = "//input[@id=\"radio-acte 1\"]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver, myXpath).click();
			
			//Vérification du nombre d'option sur la question 10
			myXpath = "//input[contains(@id,'checkbox-radi')]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			elements = MesFonctions.objets(driver, myXpath);
			nbr = elements.size();
			if(nbr!=3) {
	   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
	   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
	   			}
//			assertEquals(3, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
			
			//Insertion des pièces
			for(int i=0;i<2;i++) {
				myXpath = "//input[@id='acte-attaque-document-"+i+"1']";
				MesFonctions.goToDown(driver, myXpath);
				if(i==0) {
					MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\4 Avis_impot.pdf");
				}else {
					MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\5 Taxe_habitation.pdf");
				}
				Thread.sleep(500);
			}
			
			break;
			
		case "option2":
			//Click bouton radio opt 1
			myXpath = "//input[@id=\"radio-acte 2\"]";
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver, myXpath).click();
			
			//Ajout de la pièce
			for(int i=0;i<5;i++) {
				myXpath = "//input[@id='acte-attaque-document-"+i+"1']";
				MesFonctions.goToDown(driver, myXpath);

					int j=i+1;
					MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\TestTRC\\PJ000"+j+" pièces"+j+".pdf");
				
				Thread.sleep(500);
			}
			
			//vérification de l'affichage des titres
			myXpath = "//h2[@class='ng-star-inserted']";
			String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
	   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
	   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
	   		nbr = titre.size();
	   		if(nbr!=11) {
	   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
	   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
	   		}else {
	   			System.out.println("Ensemble des titres des parties affichées : \r");
	   			for(int i=0;i<nbr;i++) {
	   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
	   	   		}
	   		}
//	   		assertEquals(11, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//	   		System.out.println("Ensemble des titres des parties affichées : \r");
//	   		for(int i=0;i<nbr;i++) {
//	   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//	   		}
	   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
			
			
			break;

		default:
			break;
		}
		
		System.out.println("Les éléments demandés ont été ajoutés pour la partie 9 ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	
		return null;
	}
	
	public static String remplissage_question_9quater(WebDriver driver) throws Throwable {
		//Renseigner le champ 9
		String myXpath = "//input[contains(@id,'checkbox-prej-')]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elements = MesFonctions.objets(driver, myXpath);
		int nbr = elements.size();
		for(int i=1;i<=nbr;i++) {
			MesFonctions.objet(driver, "//input[contains(@id,'checkbox-prej-"+i+"')]").click();	
		}
		System.out.println("Les checkbox de la partie 9 sont cochées ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return myXpath;
	}
	
	public static String remplissage_question_10(WebDriver driver) {
		//Sélection de la partie 8 correspondant à l'option du 2ème choix de la question 3 et du 1er choix de la question 4 
		String text = "12035.21";
		
		String myXpath = "//input[@id='montant-du']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		
		//texte justificatif---remove
//		text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. Sed sit amet purus at sem eleifend malesuada. "
//				+ "Duis accumsan imperdiet ante, ac suscipit neque condimentum in. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; "
//				+ "Nulla id ligula nec urna tincidunt efficitur. Curabitur ultricies fringilla gravida. "
//				+ "Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
//				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.";
//		
//		myXpath = "//textarea[@id='explication-calcul-montant']";
//		mesFonctions.goToDown(driver, myXpath);
//		mesFonctions.objet(driver, myXpath).sendKeys(text);
		
		//Ajout de la 1ère pièce justificative
		myXpath = "//input[@id='piece-complementaire-montant-du-adder-01']";
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 - Justificatif_somme_due.pdf");
		
		text = "Ma pièce 1";
		myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		
		//justificatif ----remove
//		text = "Justificatif_Impôt";
//		myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
//		mesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
//		mesFonctions.goToDown(driver, myXpath);
//		mesFonctions.objet(driver, myXpath).sendKeys(text);
		
		
		System.out.println("Le montant ont été ajoutés pour la partie 10 ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String remplissage_question_10bis(WebDriver driver) {
		//Selection du premier choix de la partie 10
		String myXpath = "//input[@id=\"checkbox-radi-1\"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		//vérification de l'affichage des 
		myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=12) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(12, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Vérification du titre de la partie 11 fonction du bouton radio selectionné dans la partie 10
		if(titre.get(10).getText().equals("Expliquez l'erreur dans le calcul du montant *")) {
			System.out.println("Le titre "+titre.get(10).getText()+" est celui attendu lors du click de la première option de la partie 10....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
			System.err.println("Le titre "+titre.get(10).getText()+" n'est pas le bon....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		//Selection du deuxième choix de la partie 10
		myXpath = "//input[@id=\"checkbox-radi-2\"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		//vérification de l'affichage des 
		myXpath = "//h2[@class='ng-star-inserted']";
		myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		titre = MesFonctions.objets(driver, myXpath);
   		titre1 = MesFonctions.objets(driver, myXpath1);
   		nbr = titre.size();
   		if(nbr!=12) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(12, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Vérification du titre de la partie 11 fonction du bouton radio selectionné dans la partie 10
		if(titre.get(10).getText().equals("Expliquez en quoi vous considérez que vous ne devriez pas payer cet impôt *")) {
			System.out.println("Le titre "+titre.get(10).getText()+" est celui attendu lors du click de la première option de la partie 10");
		}else {
			System.err.println("Le titre "+titre.get(10).getText()+" n'est pas le bon....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
	
	
	public static String remplissage_question_ctx_9(WebDriver driver) {
		//Selection du premier choix de la partie 10
		String myXpath = "//input[@id=\"checkbox-radi-1\"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		//vérification de l'affichage des 
		myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=11) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(11, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Vérification du titre de la partie 11 fonction du bouton radio selectionné dans la partie 10
		if(titre.get(10).getText().equals("Expliquez l'erreur dans le calcul du montant *")) {
			System.out.println("Le titre "+titre.get(10).getText()+" est celui attendu lors du click de la première option de la partie 10....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}else {
			System.err.println("Le titre "+titre.get(10).getText()+" n'est pas le bon....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		//Selection du deuxième choix de la partie 10
		myXpath = "//input[@id=\"checkbox-radi-2\"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.objet(driver, myXpath).click();
		
		//vérification de l'affichage des 
		myXpath = "//h2[@class='ng-star-inserted']";
		myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		titre = MesFonctions.objets(driver, myXpath);
   		titre1 = MesFonctions.objets(driver, myXpath1);
   		nbr = titre.size();
   		if(nbr!=11) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(11, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Vérification du titre de la partie 11 fonction du bouton radio selectionné dans la partie 10
		if(titre.get(9).getText().equals("Expliquez en quoi vous considérez que vous ne devriez pas payer cet impôt *")) {
			System.out.println("Le titre "+titre.get(9).getText()+" est celui attendu lors du click de la première option de la partie 10");
		}else {
			System.err.println("Le titre "+titre.get(9).getText()+" n'est pas le bon....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
	
	public static String remplissage_question_10ter(WebDriver driver) {
		//Sélection de la partie 8 correspondant à l'option du 2ème choix de la question 3 et du 1er choix de la question 4 
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		
		String myXpath = "//textarea[@id='precision-prejudice']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		
		//Ajout de la 1ère pièce justificative
		myXpath = "//input[@id='piece-complementaire-precision-prejudice-adder-01']";
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 - Justificatif_somme_due.pdf");
		
		text = "Justificatif_Impôt";
		myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		
		//Ajout de la 2ème pièce justificative
		myXpath = "//input[@id='piece-complementaire-precision-prejudice-adder-11']";
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\3 - Sommes_versées.pdf");
		
		text = "Justificatif_sommes_dues";
		myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		
		System.out.println("Le montant, le texte justificatif et la pièce ont été ajoutés pour la partie 10 ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		
		System.out.println("Le texte justificatif et les pièces ont été ajoutés pour la partie 10 ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String remplissage_question_10quater(WebDriver driver) {
		//Sélection de la partie 8 correspondant à l'option du 2ème choix de la question 3 et du 1er choix de la question 4 
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		String myXpath = "//input[contains(@id,'checkbox-rit-')]";
		List<WebElement> chckbx = MesFonctions.objets(driver, myXpath);
		List<Integer> used = new ArrayList<>();
		int nbr = chckbx.size();
		Random random = new Random();
		while (used.size()<2) {
			int i = random.nextInt(nbr+1);
			if(!used.contains(i) && i!=0) {
			myXpath = "//input[contains(@id,'checkbox-rit-"+i+"')]";
			String myXpath1 = "//textarea[contains(@id,'raison-contestation-validation-titre-"+i+"')]";
			
			//Sélection de la checkbox
			MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath);
			MesFonctions.objet(driver, myXpath).click();
			
			//Ajout du texte justificatif
			MesFonctions.waiting2(driver, myXpath1, Duration.ofSeconds(3));
			MesFonctions.goToDown(driver, myXpath1);
			MesFonctions.objet(driver, myXpath1).sendKeys(text);;
			used.add(i);
			}
		}
	
		System.out.println("Le texte justificatif a été ajouté pour la partie 10 ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_11(WebDriver driver) {
		//Sélection de la première checkbox
		String myXpath = "//input[@id='conclusion-reclamer-somme-condamner-admin-checkbox']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();

		//Sélection de la deuxime checkbox
		myXpath = "//input[@id='conclusion-reclamer-somme-majoree-checkbox']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		System.out.println("Les checkbox de la partie 11 sont cochées ....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_11bis(WebDriver driver) {
		//Remplissage du champ 11
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		String myXpath = "//textarea[@id='raison-pas-payer-impot']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);

		//Sélection de la deuxime checkbox
		myXpath = "//input[@id='piece-complementaire-avis-imposition-infondee-et-autre-adder-01']";
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys("C:\\Users\\jagathine\\Desktop\\Cas de tets et JDD\\2 - Justificatif_somme_due.pdf");
		
		text = "Justificatif_Impôt";
		myXpath = "//label[@class='nommer-piece-label']//following-sibling::div/input";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		
		System.out.println("Le texte justificatif et la pièce ont été ajoutés pour la partie 11....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_11ter(WebDriver driver) {
		//Remplissage du champ 11
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend nibh a sagittis ullamcorper. S"
				+ "ed sit amet purus at sem eleifend malesuada. Duis accumsan imperdiet ante, ac suscipit neque condimentum in."
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla id ligula nec urna tincidunt efficitur. "
				+ "Curabitur ultricies fringilla gravida. Aliquam consectetur elit a eros viverra, nec dictum libero vulputate. Etiam id tortor interdum, aliquam libero at, venenatis nisl."
				+ "Ut dictum euismod magna, ac sagittis arcu condimentum vitae.\r\n"
				+ "\r\n"
				+ "Sed venenatis, lacus in bibendum semper, nisl dolor auctor sapien, et accumsan magna lacus ut eros. "
				+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
				+ "Suspendisse mollis ac nunc vel vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Sed luctus turpis ac eros iaculis, quis maximus elit elementum. Vestibulum porta malesuada odio, quis pellentesque nisl porttitor quis. "
				+ "Sed sed ipsum et nulla bibendum ornare id id diam. In ac ex venenatis, placerat nulla a, tincidunt urna. Proin convallis eros vitae rutrum ultricies. "
				+ "Fusce faucibus libero eget erat auctor placerat. Nullam suscipit nulla vitae eleifend commodo. Morbi iaculis auctor tristique.\r\n"
				+ "\r\n"
				+ "Fusce sed tempor nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi interdum sagittis convallis. "
				+ "Duis sed risus efficitur felis lobortis pellentesque vel id justo. Integer pharetra lorem eget suscipit fringilla. Nam non tellus eu massa luctus vestibulum vel a odio. "
				+ "Vestibulum eleifend ex eget enim sollicitudin fermentum.\r\n"
				+ "\r\n"
				+ "Aenean venenatis sapien urna, vitae condimentum orci lobortis et. Integer fringilla tempus sem, vel viverra lorem blandit quis. "
				+ "Praesent pellentesque purus purus, quis accumsan nisi vestibulum et. Morbi eget tortor dapibus, rutrum justo eget, cursus ligula. Morbi mollis risus sit amet laoreet facilisis. "
				+ "Aenean porttitor laoreet nisl, scelerisque suscipit dui rutrum sed. Sed non libero libero. Ut et enim a lacus pretium tristique. "
				+ "Praesent sagittis dui elit, vitae hendrerit odio consequat eu. Nunc pellentesque, eros vitae porta finibus, dui lorem facilisis dui, ac blandit sapien dui in justo. "
				+ "Maecenas pellentesque eu magna luctus lacinia. Nam sit amet nulla quam. Nullam blandit arcu sapien, in molestie justo egestas eu.";
		
		String myXpath = "//textarea[@id='origine-prejudice']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);
		
		System.out.println("Le texte justificatif a été ajoutés pour la partie 11....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String remplissage_question_11quater(WebDriver driver) {
		//Click checbox
		String myXpath = "//input[@id='conclusion-contester-somme-titre-emis-irregulier-checkbox']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();;
		
		//Ajout du montant
		String somme = "145231.32";
		
		myXpath = "//input[@id='conclusion-contester-somme-titre-emis-irregulier-montant']";//conclusion-reclamer-somme-condamner-admin-checkbox --élément précédent
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(somme);;

		System.out.println("La somme est renseignée dans la partie 11......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_12(WebDriver driver) {
		//Sélection de la checkbox
		String myXpath = "//input[@id='conclusion-reclamer-somme-condamner-admin-checkbox']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();

		System.out.println("La checkbox est cochée dans la partie 12......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String remplissage_question_12bis(WebDriver driver) {
		//Sélection de la 1ère checkbox
		String myXpath = "//input[@id='conclusion-indemnisation-condamner-admin-checkbox']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();
		
		//Insertion du montant
		String text = "45000.32";
		myXpath = "//input[@id='conclusion-indemnisation-montant']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).sendKeys(text);;
		
		//Sélection de la 2ème checkbox
		myXpath = "//input[@id='conclusion-indemnisation-majoree-checkbox']";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MesFonctions.goToDown(driver, myXpath);
		MesFonctions.objet(driver, myXpath).click();

		System.out.println("La checkbox est cochée dans la partie 12......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		return null;
	}
	
	
	public static String trc_titre4_choix_1(WebDriver driver) throws Throwable {
		//Vérification de l'ensemble des champs du formulaire à remplir
		String myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=4) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(4, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
		
   		//Autres parties du formulaire
   		Trc_depot_formulaire.remplissage_question_4bis(driver);
   		Trc_depot_formulaire.remplissage_question_5bis(driver);
   		Trc_depot_formulaire.remplissage_question_6bis(driver);
   		Trc_depot_formulaire.remplissage_question_7bis(driver);
   		Trc_depot_formulaire.remplissage_question_8bis(driver);
   		Trc_depot_formulaire.remplissage_question_9bis(driver);
   		Trc_depot_formulaire.remplissage_question_10(driver);
   		Trc_depot_formulaire.remplissage_question_11(driver);
   		
   	//Valider (suivant)
	myXpath = "//div[contains(@class,\"alert alert-danger\")]";
    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
    nbr = elements.size();
    if(nbr<2) {
	  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
	  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
	  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
	  MesFonctions.objet(driver,  myXpath).click();
	  Thread.sleep(1000);
     }else {
	   System.out.println("Des alertes sont présentes : \r");
	   for(int i=0;i<nbr;i++) {
		  System.err.println(elements.get(i).getText().trim()+"\r");
	   }
   }
   		
		return null;
	}
	
	
	public static String trc_ctx_titre3_choix_1(WebDriver driver) throws Throwable {
		//Vérification de l'ensemble des champs du formulaire à remplir
		String myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=3) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(3, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
		
   		//Autres parties du formulaire
   		Trc_depot_formulaire.remplissage_question_ctx_3(driver);
   		Trc_depot_formulaire.remplissage_question_5bis(driver);
   		Trc_depot_formulaire.remplissage_question_6bis(driver);
   		Trc_depot_formulaire.remplissage_question_7bis(driver);
   		Trc_depot_formulaire.remplissage_question_8bis(driver);
   		Trc_depot_formulaire.remplissage_question_9bis(driver);
   		Trc_depot_formulaire.remplissage_question_10(driver);
   		Trc_depot_formulaire.remplissage_question_11(driver);
   		
   		//Valider (suivant)
		myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	    nbr = elements.size();
	    if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath).click();
		  Thread.sleep(1000);
	     }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
   		
		return null;
	}
	
	
	public static String trc_titre4_choix_2(WebDriver driver, String opt) throws Throwable {
		//Vérification de l'ensemble des champs du formulaire à remplir
		String myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=4) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(4, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Autres parties du formulaire
   		Trc_depot_formulaire.remplissage_question_4ter(driver);
   		Trc_depot_formulaire.remplissage_question_5bis(driver);
   		Trc_depot_formulaire.remplissage_question_6bis(driver);
   		Trc_depot_formulaire.remplissage_question_7bis(driver);
   		Trc_depot_formulaire.remplissage_question_8ter(driver);
   		if(opt=="option1") {
   			Trc_depot_formulaire.remplissage_question_9ter(driver, opt);
   	   		Trc_depot_formulaire.remplissage_question_10bis(driver);
   	   		Trc_depot_formulaire.remplissage_question_11bis(driver);
   	   		Trc_depot_formulaire.remplissage_question_12(driver);	
   		}
   		else {
   			Trc_depot_formulaire.remplissage_question_9ter(driver, opt);
   			Trc_depot_formulaire.remplissage_question_10quater(driver);
   	   		Trc_depot_formulaire.remplissage_question_11quater(driver);
   		}
   		
   		//Valider (suivant)
		myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	    nbr = elements.size();
	    if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver,  myXpath).click();
		  Thread.sleep(1000);
	     }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
   		
		return null;
	}
	
	
	public static String trc_ctx_titre3_choix_2(WebDriver driver, String opt) throws Throwable {
		//Vérification de l'ensemble des champs du formulaire à remplir
		String myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=3) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(3, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Autres parties du formulaire
   		Trc_depot_formulaire.remplissage_question_ctx_3bis(driver);
   		Trc_depot_formulaire.remplissage_question_5bis(driver);
   		Trc_depot_formulaire.remplissage_question_6bis(driver);
   		Trc_depot_formulaire.remplissage_question_7bis(driver);
   		Trc_depot_formulaire.remplissage_question_8ter(driver);
   		if(opt=="option1") {
   			Trc_depot_formulaire.remplissage_question_9ter(driver, opt);
   	   		Trc_depot_formulaire.remplissage_question_ctx_9(driver);
   	   		Trc_depot_formulaire.remplissage_question_11bis(driver);
   	   		Trc_depot_formulaire.remplissage_question_12(driver);	
   		}
   		else {
   			Trc_depot_formulaire.remplissage_question_9ter(driver, opt);
   			Trc_depot_formulaire.remplissage_question_10quater(driver);
   	   		Trc_depot_formulaire.remplissage_question_11quater(driver);
   		}
   		
   		//Valider (suivant)
		myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	    nbr = elements.size();
	    if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath).click();
		  Thread.sleep(1000);
	     }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
   		
		return null;
	}
	
	
	public static String trc_titre4_choix_3(WebDriver driver) throws Throwable {
		//Vérification de l'ensemble des champs du formulaire à remplir
		String myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=4) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(4, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Autres parties du formulaire
   		Trc_depot_formulaire.remplissage_question_4quater(driver);
   		Trc_depot_formulaire.remplissage_question_5bis(driver);
   		Trc_depot_formulaire.remplissage_question_6bis(driver);
   		Trc_depot_formulaire.remplissage_question_7bis(driver);
   		Trc_depot_formulaire.remplissage_question_8quater(driver);
   		Trc_depot_formulaire.remplissage_question_9quater(driver);
   		Trc_depot_formulaire.remplissage_question_10ter(driver);
   		Trc_depot_formulaire.remplissage_question_11ter(driver);
   		Trc_depot_formulaire.remplissage_question_12bis(driver);
   		
   		//Valider (suivant)
		myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	    nbr = elements.size();
	    if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver,  myXpath).click();
		  Thread.sleep(1000);
	     }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
   		
		return null;
	}
	
	
	public static String trc_ctx_titre3_choix_3(WebDriver driver) throws Throwable {
		//Vérification de l'ensemble des champs du formulaire à remplir
		String myXpath = "//h2[@class='ng-star-inserted']";
		String myXpath1 = "//h2[@class='ng-star-inserted']//preceding-sibling::div";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		List<WebElement> titre1 = MesFonctions.objets(driver, myXpath1);
   		int nbr = titre.size();
   		if(nbr!=3) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   			for(int i=0;i<nbr;i++) {
   	   		System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
   	   		}
   		}
//   		assertEquals(3, nbr, "Le nombre de partie attendue ne correspond pas au nombre de partie dénombrée....."+MesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(int i=0;i<nbr;i++) {
//   			System.out.println(titre1.get(i).getText()+"."+titre.get(i).getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Autres parties du formulaire
   		Trc_depot_formulaire.remplissage_question_ctx_3ter(driver);
   		Trc_depot_formulaire.remplissage_question_5bis(driver);
   		Trc_depot_formulaire.remplissage_question_6bis(driver);
   		Trc_depot_formulaire.remplissage_question_7bis(driver);
   		Trc_depot_formulaire.remplissage_question_8quater(driver);
   		Trc_depot_formulaire.remplissage_question_9quater(driver);
   		Trc_depot_formulaire.remplissage_question_10ter(driver);
   		Trc_depot_formulaire.remplissage_question_11ter(driver);
   		Trc_depot_formulaire.remplissage_question_12bis(driver);
   		
   		//Valider (suivant)
		myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	    List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	    nbr = elements.size();
	    if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver,  myXpath).click();
		  Thread.sleep(1000);
	     }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
   		
		return null;
	}
	
	
	public static String Trc_formulaire_ctx_2_decision_administration (WebDriver driver) throws Throwable {
		//Vérification de la présence du titre 3
		String myXpath = "//h2[text()=\"Vous souhaitez : \"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		System.out.println("le titre 2 : "+MesFonctions.objet(driver, myXpath).getText()+" est affiché......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
   		
   		//Click sur la première option de la partie 3
   		myXpath = "//input[@id='radio-souhait 1']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.objet(driver,  myXpath).click();
   		
   		//Vérification de la présence des autres partie du formulaire
   		myXpath = "//h2[@class='ng-star-inserted']";
   		List<WebElement> titre = MesFonctions.objets(driver, myXpath);
   		int nbr = titre.size();
   		if(nbr!=8) {
   			System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+MesFonctions.extractCurrentHeure());
   			System.err.println("Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
   		}else {
   			System.out.println("Ensemble des titres des parties affichées : \r");
   	   		for(WebElement a: titre) {
   	   			System.out.println(a.getText());
   	   		}
   		}
//   		assertEquals(8, nbr, "Le nombre de parties attendues ne correspond pas au nombre de parties dénombrées....."+MesFonctions.extractCurrentHeure());
//		   		System.out.println("Le nombre de partie affichée pour ce formulaire est de : "+nbr+"....."+mesFonctions.extractCurrentHeure());
//   		System.out.println("Ensemble des titres des parties affichées : \r");
//   		for(WebElement a: titre) {
//   			System.out.println(a.getText());
//   		}
   		System.out.println("\rFin de la liste...."+MesFonctions.extractCurrentHeure()+"\r");
   		
   		Trc_depot_formulaire.remplissage_question_4(driver, "non");
   		Trc_depot_formulaire.remplissage_question_5(driver);
   		Trc_depot_formulaire.remplissage_question_6(driver);
   		Trc_depot_formulaire.remplissage_question_7(driver);
   		Trc_depot_formulaire.remplissage_question_8(driver);
   		Trc_depot_formulaire.remplissage_question_9(driver);
   		
   		
   		//Valider (suivant)
	   myXpath = "//div[contains(@class,\"alert alert-danger\")]";
	   List<WebElement> elements = MesFonctions.objets(driver, myXpath);
	   nbr = elements.size();
	   if(nbr<2) {
		  System.out.println("Tous les champs ont été renseignés......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		  myXpath = "//button[@type='button']//span[contains(@class,'label') and (contains(text(),\"Page suivante\"))]";
		  MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
		  MesFonctions.objet(driver, myXpath).click();
		  Thread.sleep(500);
	   }else {
		   System.out.println("Des alertes sont présentes : \r");
		   for(int i=0;i<nbr;i++) {
			  System.err.println(elements.get(i).getText().trim()+"\r");
		   }
	   }
	   
	   

		return null;
	}
	
	public static String Trc_formulaire_ctx_2_somme_argent(WebDriver driver, String opt) throws Throwable {
		//Vérification de la présence du titre 3
		String myXpath = "//h2[text()=\"Vous souhaitez : \"]";
		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		System.out.println("le titre 2 : "+MesFonctions.objet(driver, myXpath).getText()+" est affiché......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
		
		//Click sur la deuxieme option de la partie 3
   		myXpath = "//input[@id='radio-souhait 2']";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		MesFonctions.objet(driver,  myXpath).click();
   		
   		//Vérification de la présence de la question 4 et ses trois options
   		myXpath = "//input[contains(@id,'radio-type')]//following-sibling::label";
   		MesFonctions.waiting2(driver, myXpath, Duration.ofSeconds(3));
   		List<WebElement> list = MesFonctions.objets(driver, myXpath);
   		
   		for(WebElement a:list) {
   			System.out.println("L'option "+a.getText().trim()+" est présente");
   		}
   		
   		//Selection de l'option dans la partie 4
   		switch (opt) {
		case "option1"://Vous réclamez une somme d'argent à l'administration
			Trc_depot_formulaire.trc_ctx_titre3_choix_1(driver);
			break;
			
		case "option2"://Vous contester une somme d'argent réclamée par l'administration
			String opt_9 = "option1";
			Trc_depot_formulaire.trc_ctx_titre3_choix_2(driver, opt_9);
			break;
			
		case "option3"://Vous réclamez une indemnisation pour une faute commise par l'administration 
			Trc_depot_formulaire.trc_ctx_titre3_choix_3(driver);
			break;

		default:System.err.println("option introuvable....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure()+"\r");
			break;
		}
   		
   		return null;

	}
	
}

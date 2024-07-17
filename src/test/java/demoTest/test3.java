package demoTest;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.jgrapht.alg.util.Pair;
import org.openqa.selenium.WebDriver;

import browser.Navigateur;
import captureTool.Recuper_Coleur_pixel;
import fonctionnalites.MicroFonctions;
import lesFonctions.MesFonctions;

public class test3 {
	static WebDriver driver;
	static String browser;
	
	public static void main(String[] args) throws Throwable {
		
		
//		comparaisonPixel();
//		
//		BufferedImage image = ImageIO.read(new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\"));
//		
//		Robot robot = new Robot();
//		BufferedImage current = robot.createScreenCapture(
//		  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//		boolean match = true;
//		boolean finalMatch = false;
//		int X = -1;
//        int Y = -1;
//
//		System.out.println("début : "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
//		
//		for(int x=0; x<current.getWidth()-image.getWidth(); x++) {
//			for(int y=0; y<current.getHeight()-image.getHeight(); y++) {
//				
//				match = true;
//				if(!finalMatch) {
//				for(int a=0; a<image.getWidth(); a++) {
//					if(match) {
//					for(int b=0; b<image.getHeight(); b++) {
//						if(current.getRGB(x + a, y + b) != image.getRGB(a, b)) {
//							match = false;
//							break;
//							}
//						}	
//					}
//				}
//				if(match) {
//					X = x;
//					Y = y;
//					
//					finalMatch = true;
//					}
//				}
//			}
//		}
//		if(finalMatch) {
//		System.out.println("matched "+finalMatch);
//		System.out.println(image.getWidth()+" , "+image.getHeight());
//		System.out.println("Fin : "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
//		}else {
//			System.out.println("It's not matched "+finalMatch);
//			System.out.println("Fin : "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
//		}
////		click(X + image.getWidth()/2, Y + image.getHeight()/2);
//	    }
//	
//	
//	public static void doubleClick(int x, int y) throws AWTException {
//        Robot bot = new Robot();
//        bot.mouseMove(x, y);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//	}
//		
//	public static Pair<BufferedImage, BufferedImage> capture() throws Throwable {
//		//première capture d'écran
//	    String file = "C:\\Users\\jagathine\\Desktop\\Images\\Image bugs\\myScreen.bmp";
//	    BufferedImage image = MesFonctions.capturePluscreationFichier(file);
//	    System.out.println("Première capture d'écran réalisée");
//	    
//	    //positionnnement souris
//	    System.out.println("10 secondes pour cliquer sur l'icone choisie");
//	    Thread.sleep(10000);
//	    System.out.println("le temps imparti est terminé");
//	    PointerInfo pointer = MouseInfo.getPointerInfo();
//	    Point point = pointer.getLocation();
//	    int v = (int) point.getX();
//	    int w = (int) point.getY();
//	    System.out.println(v+" , "+w);
//	    
//	    int x = 0;
//	    int y = 0;
//	    Robot bot = new Robot();
//        bot.mouseMove(x, y);
//       
//        //deuxième capture d'écran
//        Thread.sleep(500);
//        file = "C:\\Users\\jagathine\\Desktop\\Images\\Image bugs\\myScreen1.bmp";
//        BufferedImage image1 = MesFonctions.capturePluscreationFichier(file); 
//	    System.out.println("deuxième capture d'écran réalisée");
//	    Pair<BufferedImage, BufferedImage> images = new Pair<BufferedImage, BufferedImage>(image, image1);
//	    
//	    return images;
//	    
//	}
//	    
//	    public static Pair<Pair<Integer, Integer>, Pair<Integer,Integer>> coordinatesPixels(Pair<BufferedImage,BufferedImage> images) throws Throwable {
//	    //Recherche des pixels différents sur l'image
//	    Pair<Integer, Integer> coords = new Pair<Integer, Integer>(-1, -1);
//	    
//	    boolean match = true;
//	    int heightIcon = -1;
//	    int widthIcon = -1;
//	   
//	    
//	    for(int a=0; a<images.getFirst().getWidth(); a++) {
//	    	if(match) {
//	    	for( int b=0; b<images.getFirst().getHeight() ; b++) {	
//				if(images.getFirst().getRGB(a, b) != images.getSecond().getRGB(a, b)) {
//					match = false;
//					coords.setFirst(a);
//					coords.setSecond(b);
//					break;
//					}
//				}
//			}
//		}
//	    
//	    if(!match) {
//		    for(int a = 0; a<images.getFirst().getWidth() - coords.getFirst(); a++) {
//		    	if(images.getFirst().getRGB(coords.getFirst() +a, coords.getSecond()) == images.getSecond().getRGB(coords.getFirst() +a, coords.getSecond())) {
//		    		widthIcon = a;
//		    		break;
//		    	}
//		    }
//
//		    for(int b = 0; b<images.getFirst().getHeight()-coords.getSecond(); b++) {
//		    	if(images.getFirst().getRGB(coords.getFirst(), coords.getSecond() + b) == images.getSecond().getRGB(coords.getFirst(), coords.getSecond() + b)) {
//		    		heightIcon = b;
//		    		break;
//		    	}
//		    }
//		    
//		    
//		}
//	    if(!match) {
//	    System.out.println(widthIcon+" , "+heightIcon);
//	    }else {
//	    	System.err.println("les images sont identiques");
//	    }
//	    Pair <Integer, Integer> dim = new Pair<Integer, Integer>(widthIcon, heightIcon);
//	    return new Pair<>(coords, dim);
//	}
//	    
//	    public static List<Integer> comparaisonPixel () throws Throwable{
//	    	Pair<BufferedImage, BufferedImage> captures = capture();
//	    	Pair<Pair<Integer, Integer>, Pair<Integer,Integer>> coords = coordinatesPixels(captures);
//	    	
//	    	int coodX = coords.getFirst().getFirst();
//	    	int coodY = coords.getFirst().getSecond();
//	    	
//	    	int dimX = coords.getSecond().getFirst();
//	    	int dimY = coords.getSecond().getSecond();
//	    
//	    	List<Integer> pixel = new ArrayList<>();
//	    	boolean matched = false;
//	    	
//	    	if(!matched) {
//	    	for(int a=0; a<dimX; a++) {
//	    		for(int b=0; b<dimY; b++) {
//	    			if(captures.getFirst().getRGB(coodX + a, coodY + b) == captures.getSecond().getRGB(coodX + a, coodY + b)) {
//	    				pixel.add(captures.getFirst().getRGB(coodX + a, coodY + b));
//	    				matched = true;
//	    				System.out.println(pixel.get(pixel.size()-1));
//	    				System.out.println(matched);
//	    			}
//	    			else {
//	    				pixel.add(null);
//	    			}
//	    		}
//	    	}
//	    }
//	    	
//	    	BufferedImage icone = new BufferedImage(dimX, dimY, BufferedImage.TYPE_INT_RGB);
//	    	for (int x = 0; x < dimX; x++) {
//	    	     for (int y = 0; y < dimY; y++) {
//	    	        icone.setRGB(x, y, pixel.get(x * dimY +y));
//	    	     }
//	    	  }
//
//	    	  File outputFile = new File("C:\\Users\\jagathine\\Desktop\\Images\\Image bugs\\myIcone.bmp");
//	    	  ImageIO.write(icone, "bmp", outputFile);
//	    	  System.out.println("Fichier créé");
//
//	    	return null;
		
		
//		File file = new File("C:\\Users\\jagathine\\Desktop\\Images_Capture_script\\exemple_annuaire des avocats.png") ; //exemple_annuaire des avocats.png ; z-blanc
//		BufferedImage image = ImageIO.read(file);
//        boolean verif = Recuper_Coleur_pixel.color(image);
//        System.out.println(verif);
		
		List<String> lst = new ArrayList<>(); 
		List<String> list = new ArrayList<>();
		List<String> lst1 = new ArrayList<>();
		String[] str = {"ABDELLATIF allan", "ABIVENSardr", "ABSENT INERECS", "AITALIS", "AIT-TALEBS", "MARTIN", "CARO"};
		String[] str1 = {"ABDELLATIF", "ABIVEN", "ABSENT INEREC", "AITALI", "AIT-TALEB", "MARTIN", "CARO"};

		for(String s : str) {
			String res = "";
			for(int i = 0; i < s.length(); i++) {
				if(Character.isUpperCase(s.charAt(i)) || (s.charAt(i) == ' ' || s.charAt(i) == '-' && res.length() != 0)) {
					//System.out.println(String.valueOf(s.charAt(i)));
					res += (String.valueOf(s.charAt(i)));
				}
			}
			while(res.charAt(res.length() - 1) == ' ') {
				res = res.substring(0, res.length() - 1);
			}
			System.out.println(res);
		}
		
		
//		System.out.println(Character.isUpperCase(str[1].charAt(0)));		
		for(int i=0; i<str1.length; i++) {
			lst.add(str[i]);
			list.add(str1[i]);
				}
		
		lst1 = MesFonctions.recuperation_Majuscule_List_String(lst);
//			list.add("AJOUT");
			MicroFonctions.compareList(lst, list);
			String pat = "\\p{Upper}";
			Pattern pattern = Pattern.compile(pat);
			
			int cnt = 0;
			for(int i=0;i<lst1.size();i++) {
				Matcher matcher = pattern.matcher(lst.get(i));
				StringBuilder text = new StringBuilder();

				while(matcher.find()) {

					text.append(matcher.group()); 
				}
				
				System.out.println(cnt);		
				String concat = text.toString();
				System.out.println(concat);
				//text.delete(0, 9);
				cnt++;
			}
			
			String strg ="UPPER Lower";
			MesFonctions.recuperation_Majuscule_String(strg);
			
			String identifiant = "test4_gda";
			String password = "BetaENV2023@&";
			String browser = "chrome";
			
			//Ouverture du navigateur
			driver = Navigateur.choixBrowser(browser);
			System.out.println(driver);
			
			//Authentification
			MicroFonctions.authentification_OAE(driver, identifiant, password);
			
			
			//Accès à l'onglet "Gestion des disponibilités des avocats"
			MicroFonctions.Verification_AvocatOAE_Inactif(driver, lst1);
			System.out.println("\r"+"===================================="+"\r");
			MicroFonctions.Verification_AvocatOAE_Actif(driver, lst1);
		}
	      	
}

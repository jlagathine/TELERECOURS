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

import javax.imageio.ImageIO;

import org.jgrapht.alg.util.Pair;

import lesFonctions.MesFonctions;

public class test3 {
	
	
	public static void main(String[] args) throws Throwable {
		
		
		comparaisonPixel();
		
		BufferedImage image = ImageIO.read(new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\"));
		
		Robot robot = new Robot();
		BufferedImage current = robot.createScreenCapture(
		  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		boolean match = true;
		boolean finalMatch = false;
		int X = -1;
        int Y = -1;

		System.out.println("début : "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
		
		for(int x=0; x<current.getWidth()-image.getWidth(); x++) {
			for(int y=0; y<current.getHeight()-image.getHeight(); y++) {
				
				match = true;
				if(!finalMatch) {
				for(int a=0; a<image.getWidth(); a++) {
					if(match) {
					for(int b=0; b<image.getHeight(); b++) {
						if(current.getRGB(x + a, y + b) != image.getRGB(a, b)) {
							match = false;
							break;
							}
						}	
					}
				}
				if(match) {
					X = x;
					Y = y;
					
					finalMatch = true;
					}
				}
			}
		}
		if(finalMatch) {
		System.out.println("matched "+finalMatch);
		System.out.println(image.getWidth()+" , "+image.getHeight());
		System.out.println("Fin : "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
		}else {
			System.out.println("It's not matched "+finalMatch);
			System.out.println("Fin : "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
		}
//		click(X + image.getWidth()/2, Y + image.getHeight()/2);
	    }
	
	
	public static void doubleClick(int x, int y) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
		
	public static Pair<BufferedImage, BufferedImage> capture() throws Throwable {
		//première capture d'écran
	    String file = "C:\\Users\\jagathine\\Desktop\\Images\\Image bugs\\myScreen.bmp";
	    BufferedImage image = MesFonctions.capturePluscreationFichier(file);
	    System.out.println("Première capture d'écran réalisée");
	    
	    //positionnnement souris
	    System.out.println("10 secondes pour cliquer sur l'icone choisie");
	    Thread.sleep(10000);
	    System.out.println("le temps imparti est terminé");
	    PointerInfo pointer = MouseInfo.getPointerInfo();
	    Point point = pointer.getLocation();
	    int v = (int) point.getX();
	    int w = (int) point.getY();
	    System.out.println(v+" , "+w);
	    
	    int x = 0;
	    int y = 0;
	    Robot bot = new Robot();
        bot.mouseMove(x, y);
       
        //deuxième capture d'écran
        Thread.sleep(500);
        file = "C:\\Users\\jagathine\\Desktop\\Images\\Image bugs\\myScreen1.bmp";
        BufferedImage image1 = MesFonctions.capturePluscreationFichier(file); 
	    System.out.println("deuxième capture d'écran réalisée");
	    Pair<BufferedImage, BufferedImage> images = new Pair<BufferedImage, BufferedImage>(image, image1);
	    
	    return images;
	    
	}
	    
	    public static Pair<Pair<Integer, Integer>, Pair<Integer,Integer>> coordinatesPixels(Pair<BufferedImage,BufferedImage> images) throws Throwable {
	    //Recherche des pixels différents sur l'image
	    Pair<Integer, Integer> coords = new Pair<Integer, Integer>(-1, -1);
	    
	    boolean match = true;
	    int heightIcon = -1;
	    int widthIcon = -1;
	   
	    
	    for(int a=0; a<images.getFirst().getWidth(); a++) {
	    	if(match) {
	    	for( int b=0; b<images.getFirst().getHeight() ; b++) {	
				if(images.getFirst().getRGB(a, b) != images.getSecond().getRGB(a, b)) {
					match = false;
					coords.setFirst(a);
					coords.setSecond(b);
					break;
					}
				}
			}
		}
	    
	    if(!match) {
		    for(int a = 0; a<images.getFirst().getWidth() - coords.getFirst(); a++) {
		    	if(images.getFirst().getRGB(coords.getFirst() +a, coords.getSecond()) == images.getSecond().getRGB(coords.getFirst() +a, coords.getSecond())) {
		    		widthIcon = a;
		    		break;
		    	}
		    }

		    for(int b = 0; b<images.getFirst().getHeight()-coords.getSecond(); b++) {
		    	if(images.getFirst().getRGB(coords.getFirst(), coords.getSecond() + b) == images.getSecond().getRGB(coords.getFirst(), coords.getSecond() + b)) {
		    		heightIcon = b;
		    		break;
		    	}
		    }
		    
		    
		}
	    if(!match) {
	    System.out.println(widthIcon+" , "+heightIcon);
	    }else {
	    	System.err.println("les images sont identiques");
	    }
	    Pair <Integer, Integer> dim = new Pair<Integer, Integer>(widthIcon, heightIcon);
	    return new Pair<>(coords, dim);
	}
	    
	    public static List<Integer> comparaisonPixel () throws Throwable{
	    	Pair<BufferedImage, BufferedImage> captures = capture();
	    	Pair<Pair<Integer, Integer>, Pair<Integer,Integer>> coords = coordinatesPixels(captures);
	    	
	    	int coodX = coords.getFirst().getFirst();
	    	int coodY = coords.getFirst().getSecond();
	    	
	    	int dimX = coords.getSecond().getFirst();
	    	int dimY = coords.getSecond().getSecond();
	    
	    	List<Integer> pixel = new ArrayList<>();
	    	boolean matched = false;
	    	
	    	if(!matched) {
	    	for(int a=0; a<dimX; a++) {
	    		for(int b=0; b<dimY; b++) {
	    			if(captures.getFirst().getRGB(coodX + a, coodY + b) == captures.getSecond().getRGB(coodX + a, coodY + b)) {
	    				pixel.add(captures.getFirst().getRGB(coodX + a, coodY + b));
	    				matched = true;
	    				System.out.println(pixel.get(pixel.size()-1));
	    				System.out.println(matched);
	    			}
	    			else {
	    				pixel.add(null);
	    			}
	    		}
	    	}
	    }
	    	
	    	BufferedImage icone = new BufferedImage(dimX, dimY, BufferedImage.TYPE_INT_RGB);
	    	for (int x = 0; x < dimX; x++) {
	    	     for (int y = 0; y < dimY; y++) {
	    	        icone.setRGB(x, y, pixel.get(x * dimY +y));
	    	     }
	    	  }

	    	  File outputFile = new File("C:\\Users\\jagathine\\Desktop\\Images\\Image bugs\\myIcone.bmp");
	    	  ImageIO.write(icone, "bmp", outputFile);
	    	  System.out.println("Fichier créé");

	    	return null;
	    }
   	
}

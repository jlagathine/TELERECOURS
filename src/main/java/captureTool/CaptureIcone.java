package captureTool;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jgrapht.alg.util.Pair;

import lesFonctions.MesFonctions;

public class CaptureIcone {
	
	static File myFile;
	
	public static Pair<Pair<Integer, Integer>, Pair<Integer,Integer>> capture(String str) throws IOException, AWTException {
	File file = new File(str) ; 
	BufferedImage image = ImageIO.read(file);
	
	Robot robot = new Robot();
	BufferedImage current = robot.createScreenCapture(
	  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	boolean match = true;
	boolean finalMatch = false;
	int X = -1;
    int Y = -1;
    int a = 0;
    int b = 0;
    int dimA = 0;
    int dimB = 0;

	System.out.println("début : "+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
	int compt = 0;
	int seuilMax = (int) ((image.getWidth() * image.getHeight()) * 0.02);//0.0 seuil de tolérance auquel si le système détecte qu'il y a un pixel en défaut il continue de vérifier l'image jusqu'a 2%
	for(int x=0; x<current.getWidth()-image.getWidth(); x++) {
		for(int y=0; y<current.getHeight()-image.getHeight(); y++) {
			
			match = true;
			if(!finalMatch) {
				for(a=0; a<image.getWidth(); a++) {
					if(match) {
						for( b=0; b<image.getHeight(); b++) {
							if(current.getRGB(x + a, y + b) != image.getRGB(a, b)) {
								compt++;
								if(compt > seuilMax) {
								match = false;
								break;
								}
							}
						}	
					}
				}
				if(match) {
					X = x;
					Y = y;
					dimA = a;
					dimB = b;
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
	Pair<Integer, Integer> coords = new Pair<Integer, Integer>(X, Y);
	Pair <Integer, Integer> dim = new Pair<Integer, Integer>(dimA, dimB);
	System.out.println(coords+"....."+dim);
	return new Pair<>(coords, dim);
    }
	

	public static Pair<BufferedImage, BufferedImage> captureSceen(String urlfile) throws Throwable {
		//positionnnement souris
	    PointerInfo pointer = MouseInfo.getPointerInfo();
	    Point point = pointer.getLocation();
	    int v = (int) point.getX();
	    int w = (int) point.getY();
	    System.out.println(v+" , "+w);
	    int x = 1920;
	    int y = 1080;
	    Robot bot = new Robot();
        bot.mouseMove(x, y);
        Thread.sleep(100);
        
		
		//Capture d'écran
        Thread.sleep(100);
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
	    System.out.println("Capture d'écran réalisée....."+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
       
	    File file = new File(urlfile) ; 
		BufferedImage image = ImageIO.read(file);
	    Pair<BufferedImage, BufferedImage> images = new Pair<BufferedImage, BufferedImage>(capture, image);
	    
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
}

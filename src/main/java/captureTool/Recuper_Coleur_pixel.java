package captureTool;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Recuper_Coleur_pixel {

	public static boolean color(BufferedImage image) {
		for(int x=0; x<image.getWidth(); x++) {
			for (int y=0; y<image.getHeight(); y++) {
				int color = -65536;//-65536 couleur rouge [r=255,g=0,b=0]
				int imgcolor = image.getRGB(x,y);
				Color coloris = new Color(imgcolor);
					if(imgcolor==color) {
						System.out.println(imgcolor+" VS "+coloris);
						return true;
						}
//					else {
//						Color coloris = new Color(imgcolor);
//						System.out.println(coloris);
//						System.out.println(image.getRGB(x,y));
//						}
				}
			}
		return false;
		} 	
}

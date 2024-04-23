package captureTool;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import lesFonctions.MesFonctions;

public class My_SreenShot {
	
	public static Object screenshot() throws Throwable {
		//Capture d'écran
        Thread.sleep(100);
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
	    System.out.println("Capture d'écran réalisée......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
	    
	    //Vérifier existance d'un fichier existant
	    File file = new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot.png");
	    int i = 0;
	    if(file.exists()) {
	    while(file.exists()) {
	    	i++;
	    	file = new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot"+i+".png");
	    	}
	    	ImageIO.write(capture, "png", new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot"+i+".png"));
	    }else {
	    	ImageIO.write(capture, "png", new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot.png"));
	    }
	    
	    System.out.println("Création du fichier : capture d'écran (index "+i+")......"+MesFonctions.extractCurrentDate()+" à "+MesFonctions.extractCurrentHeure());
	    
	    return null;
	}

	public static Object takeScreenshot(WebDriver driver) throws IOException {
		//réalisation du screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot.png");
	    int i = 0;
	    if(file.exists()) {
	    while(file.exists()) {
	    	i++;
	    	file = new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot"+i+".png");
	    }
	    System.out.println("Une capture d'écran a été créée dans le répertoire : \"C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot"+i+".png\"");
	    FileUtils.copyFile(src, new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot"+i+".png"));
	    }else {
	    	FileUtils.copyFile(src, new File("C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot.png"));
	    	System.out.println("Une capture d'écran a été créée dans le répertoire : \"C:\\Users\\jagathine\\Desktop\\Image bugs\\myScreechot.png\"");
	    }
	    
	    return null;
	}
}

package rpva;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import JDBC.JdbcClass;
import browser.NavigaChromHeader;
import juridictions.JurRpvaInscript;

public class rpvaConexion {
	WebDriver driver;
	String cnbf;
	String value;
	String name;
	String env;
	String mdp;
	String jur;
	Integer ANJ_AEXID;
	Integer RPVA_AVOCAT_ID;
	
	
	@Test (priority = 1)
	public void Initialisation() throws Throwable {
		env = "rec";
		jur = "TA";
		name = "tr_commun";
		mdp = "tr_commun";
		cnbf = "CNBF";
		value = "00002";
		RPVA_AVOCAT_ID = 529196;
		ANJ_AEXID = 22701;
		
		//initialisation du navigateur
		driver = NavigaChromHeader.chromeHeader();
	   	System.out.println(driver);
		
		//conexion à la base de données
	   	JdbcClass.conDBTR(name, mdp, env);
	   	Thread.sleep(200);
	   	
		//paramétrage extension modHeader  
	   	NavigaChromHeader.extension(driver, cnbf, value);	   
	}
	
	 @Test(priority = 2)
	   public void connexEdentitas() throws Throwable  {
		 //Connexion à TR
		 JurRpvaInscript.connexion(driver, jur); 
	   }
	 
	 @Test(priority = 3)
	 public void connexionJur() throws Throwable {
		//Connexion à la plateforme Edentitas
		 JurRpvaInscript.edentitasIntegrerStruct(driver, jur);	 
	}
	 
//	 @AfterMethod
//		public void déconnexion() throws Exception {
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//a[@id='lnkdeconnecter']")).click();
//			System.out.println("Déconnexion réussie");
//			Thread.sleep(2000);
//		}
//				
//		@AfterSuite
//		public void fin() throws SQLException, Throwable {
//			System.out.println("LE TEST EST TERMINE !!!");
//			driver.quit();
//		}
}

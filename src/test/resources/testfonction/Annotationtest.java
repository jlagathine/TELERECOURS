package testfonction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class Annotationtest {

	
	@Test
	public void test1() {
		System.out.println("Method test1");
	}

	@Test
	public void test2() {
		System.out.println("Method test2");
	}
	
	@Test
	public void test3() {
		System.out.println("Method test3");
	}

	@BeforeMethod
	public void beforeTest2() {
		System.out.println("Avant chaque test");
	}
	
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("Lire avant des tests");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("Après chaque test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Lire Après des tests");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Avant tous les tests");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Après tous les tests,\nLE TEST EST UN SUCCES !!!");
	}

}

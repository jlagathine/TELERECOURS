package testfonction;

import org.testng.annotations.Test;

public class Junittest {
	private final String tr1 = "Test1"; 
	private final String tr2 = "Test2"; 
	private final String tr3 = "Test3"; 
@Test
	public void test1() {
		System.out.println(tr1);
	}
@Test	
	public void test2() {
		System.out.println(tr2);
	}
@Test	
	public void test3() {
		System.out.println(tr3);
	}
}

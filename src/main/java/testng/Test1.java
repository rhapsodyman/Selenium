package testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Test1 : before suite");
	}
	
	public Test1(){
		System.out.println("Test1 : inside constructor");
	}

	@Test
	public void test() {
		System.out.println("Test1 : inside test");
	}

}

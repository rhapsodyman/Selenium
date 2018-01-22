package testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners( value = {KillProcessListener.class })
public class BaseTest {

	static {
		System.out.println("BaseTest : inside static");
	}

	@BeforeSuite
	public void beforeSuiteBase() {
		System.out.println("BaseTest : before suite");
	}
	
	public BaseTest(){
		System.out.println("BaseTest : inside constructor");
	}

}

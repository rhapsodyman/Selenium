package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingGoogleSearchPage {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com/");

		//GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
		
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.searchFor("Cheese");
	}
}     
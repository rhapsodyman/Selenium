package webtest.headless;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class PhantomJSTest {
	public void test() {

		File file = new File("D:/Selenium/phantomjs-2.1.1/bin/phantomjs.exe");
		System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();

		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium");

		element.submit();

		System.out.println("Page title is: " + driver.getTitle());

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("selenium");
			}
		});

		System.out.println("Page title is: " + driver.getTitle());
		driver.quit();
	}
}
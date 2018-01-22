package webtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverTest {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(130, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.last.fm/user/rhapsodyman");

		Thread.sleep(1000);
		// driver.switchTo().frame("result");

		hoverJS(driver, driver.findElement(By.xpath("//button[contains(., \"Play rhapsodyman's library\")]")));
		Thread.sleep(8000);
		driver.quit();
	}

	private static void hoverJS(WebDriver driver, WebElement element) {

		String script = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";

		((JavascriptExecutor) driver).executeScript(script, element);
	}

	private static void hover(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
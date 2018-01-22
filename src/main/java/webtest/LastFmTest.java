package webtest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webtest.LastFmPage.ListenedItem;

public class LastFmTest {
	public static void main(String[] args) throws InterruptedException {

		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.timeouts.implicitlywait", "3");


		//System.out.println(System.getProperty("webdriver.timeouts.implicitlywait"));
		//System.clearProperty("webdriver.timeouts.implicitlywait");
		//System.out.println(System.getProperty("webdriver.timeouts.implicitlywait"));

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.last.fm/user/rhapsodyman");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		LastFmPage page = new LastFmPage(driver);
		//page.listened.size();

		
		System.out.println(page.listened.get(0).artist.getText());
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(page.listened.get(0).getWrappedElement()));


		System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));

		/*	try {
			page.link.getText();
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
		 */
		System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));


		Thread.sleep(2000);
		/*page.element.sayHello(); // Typified element itselt is not a Proxy, proxy is his wrapped element

		String text = page.link.getText();
		page.listened.size();


		page.element.findElement(By.xpath("//abx"));

		// if we want to sort the list of HTMLElements, simple sort of the member list will not work,
		// we need to store references to the list elements in another list - and then sort the new list
		List<ListenedItem> listened = new ArrayList<>();
		for (ListenedItem item : page.listened) { listened.add(item); }

		Collections.sort(listened, (e1, e2) -> {
			return e1.artist.getText().compareTo(e2.artist.getText());

		});

		listened.size();
		listened.size();

		for (ListenedItem item : listened) {
			System.out.println(item.artist.getText());

		}*/
		driver.quit();
	}
}
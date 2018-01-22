package webtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import webtest.LastFmPage.ListenedItem;

public class LastFmTestGrid {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName(BrowserType.IE);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		
		driver.get("http://www.last.fm/user/rhapsodyman");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		LastFmPage page = new LastFmPage(driver);
		Thread.sleep(2000);
		
		// REMINDER change something here

		for (ListenedItem item : page.listened) {
			System.out.println(item.artist.getText());
		}
		driver.quit();
	}
}
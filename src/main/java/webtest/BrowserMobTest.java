package webtest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class BrowserMobTest {

	@Test
	public void test() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.start(0);

		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

		WebDriver driver = new ChromeDriver(capabilities);

		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

		proxy.newHar("lastfm.com");

		driver.get("http://www.google.com");
		 
		// Find the search edit box on the Google page.
		WebElement searchBox = driver.findElement(By.name("q"));
 
		// Type in Selenium.
		searchBox.sendKeys("Selenium");
 
		// Find the search button.
		WebElement button = driver.findElement(By.name("btnG"));
 
		// Click the button.
		button.click();

		// get the HAR data
		Har har = proxy.getHar();
		har.writeTo(new File("D:\\Browsermob\\file.txt"));

		driver.quit();

	}
}

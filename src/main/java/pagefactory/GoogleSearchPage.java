package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class GoogleSearchPage {
	@FindBy(name = "q")

	public TextInput q;

	public void searchFor(String text) {
		q.isDisplayed();
		q.sendKeys(text);
	}

	public GoogleSearchPage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}
}
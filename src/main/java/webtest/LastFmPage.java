package webtest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import elements.CustomElement;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class LastFmPage {

	@FindBy(xpath = "//section[@id='recent-tracks-section']//table[contains(@class,'chartlist')]//tr[contains(@class, 'js-link')]")
	public List<ListenedItem> listened;

	//@Timeout(2)
	//@FindBy(xpath = "//a[.='rhapsodyman111']")   // wrong one
	//public Link link;


	public LastFmPage(WebDriver driver) {
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}

	public static class ListenedItem extends HtmlElement {

		@FindBy(xpath = ".//span[@class='chartlist-artists']/a")
		public Link artist;

		public ListenedItem() {
			System.out.println("Inside constructor");
		};
	}
}
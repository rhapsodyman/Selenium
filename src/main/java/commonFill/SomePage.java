package commonFill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.element.Radio;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SomePage {
	@FindBy(name = "q")
	public TextInput q;
	
	@FindBy(name = "q1")
	public Select q1;
	
	@FindBy(name = "q2")
	public Radio q2;


	public SomePage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}
}
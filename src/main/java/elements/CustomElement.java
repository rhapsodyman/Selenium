package elements;

import org.openqa.selenium.WebElement;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class CustomElement  extends TypifiedElement{

	public CustomElement(WebElement wrappedElement) {
		super(wrappedElement);
	}
	
	public void sayHello(){
		System.out.println("Hello");
	} 

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class DynamicLoadingPage extends BaseClass {

	@FindBy(tagName = "button")
	public WebElement startButton;

	@FindBy(id = "finish")
	public WebElement HelloWorld;

	public DynamicLoadingPage() {
		PageFactory.initElements(driver, this);
	}

}

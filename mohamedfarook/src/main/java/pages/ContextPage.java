package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextPage extends BaseClass {

	@FindBy(id = "hot-spot")
	public WebElement Context;

	public ContextPage() {

		PageFactory.initElements(driver, this);
	}
}
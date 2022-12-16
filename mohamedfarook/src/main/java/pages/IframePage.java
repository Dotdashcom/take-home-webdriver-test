package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage extends BaseClass {

	@FindBy(tagName = "p")
	public WebElement text;

	public IframePage() {
		PageFactory.initElements(driver, this);
	}
}

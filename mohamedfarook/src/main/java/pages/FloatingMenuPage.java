package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends BaseClass {

	@FindBy(tagName = "h3")
	public WebElement floatingMenu;

	public FloatingMenuPage() {
		PageFactory.initElements(driver, this);
	}

}
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class OpenNewTabPage extends BaseClass {

	@FindBy(xpath = "//a[text()='Click Here']")
	public WebElement clickHereButton;

	public OpenNewTabPage() {
		PageFactory.initElements(driver, this);

	}
}

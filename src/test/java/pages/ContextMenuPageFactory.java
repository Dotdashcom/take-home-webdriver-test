package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class ContextMenuPageFactory extends CommonMethods {

	@FindBy (xpath = "//div[@id='hot-spot']")
	public WebElement contextBox;

	public ContextMenuPageFactory() {
		PageFactory.initElements(driver, this);
	}

}

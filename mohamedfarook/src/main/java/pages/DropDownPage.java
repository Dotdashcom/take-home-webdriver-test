package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPage extends BaseClass {

	@FindBy(id = "dropdown")
	public WebElement dropDownElement;

	public DropDownPage() {
		PageFactory.initElements(driver, this);
	}

}
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.GenericPage;

public class DropDownPage extends GenericPage {

	@FindBy(id = "dropdown")
	private WebElement dropDown;

	public DropDownPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String selectDropDown(String str) {
		Select element = new Select(dropDown);
		element.selectByVisibleText(str);
		return element.getFirstSelectedOption().getText();
	}
}
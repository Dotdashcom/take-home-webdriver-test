package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import BasePackage.BaseClass;

public class DropDown extends BaseClass{
	@FindBy(id = "dropdown")
	public WebElement dropDown;

	public DropDown() {
		PageFactory.initElements(driver, this);
	}

	public String dropDown(String str) {
		Select element = new Select(dropDown);
		element.selectByVisibleText(str);
		return element.getFirstSelectedOption().getText();
	}
	
}

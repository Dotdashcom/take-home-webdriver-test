package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class DropDownPageFactory extends CommonMethods {
	
	@FindBy (id = "dropdown")
	public WebElement dropDown;
	
	@FindBy (xpath = "//select[@id='dropdown']/option")
	public WebElement dropDownOption;
	
	public DropDownPageFactory() {
		PageFactory.initElements(driver, this);
	}

}

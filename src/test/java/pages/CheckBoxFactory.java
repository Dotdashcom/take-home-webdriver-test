package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class CheckBoxFactory extends CommonMethods {

	@FindBy(xpath = "//form[@id='checkboxes' ]/input[1]")
	public WebElement checkbox1;
	
	@FindBy(xpath = "//form[@id='checkboxes' ]/input[2]")
	public WebElement checkbox2;
	
	public CheckBoxFactory() {
		PageFactory.initElements(driver, this);
	}
}

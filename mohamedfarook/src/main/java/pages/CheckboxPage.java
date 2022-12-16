package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class CheckboxPage extends BaseClass {
	@FindBy(xpath = "(//form[@id='checkboxes']/input)[1]")
	public WebElement checkBox1;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement checkBox2;

	public CheckboxPage() {
		PageFactory.initElements(driver, this);
	}
}

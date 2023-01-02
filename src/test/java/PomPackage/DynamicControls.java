package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class DynamicControls extends BaseClass {
	@FindBy(id = "checkbox")
    public WebElement checkBox;

	@FindBy(xpath = "//button[.='Remove']")
	public WebElement removeBtn;

	@FindBy(xpath = "//button[.='Add']")
	public WebElement addBtn;

	@FindBy(xpath = "//button[.='Enable']")
	public WebElement enableBtn;

	@FindBy(xpath = "//button[.='Disable']")
	public WebElement disableBtn;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement textBox;

	public DynamicControls() {
		PageFactory.initElements(driver, this);
	}

}

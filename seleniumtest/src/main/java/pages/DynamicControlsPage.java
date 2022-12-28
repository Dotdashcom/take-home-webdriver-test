package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class DynamicControlsPage extends GenericPage {
	
	@FindBy(id = "checkbox")
    public WebElement checkBox;
	
	@FindBy(xpath = "//button[.='Remove']")
	public WebElement removeButton;

	@FindBy(xpath = "//button[.='Add']")
	public WebElement addButton;

	@FindBy(xpath = "//button[.='Enable']")
	public WebElement enableButton;
	
	@FindBy(xpath = "//button[.='Disable']")
	public WebElement disableButton;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement textBox;

	public DynamicControlsPage() {
		PageFactory.initElements(driver, this);
	}
}
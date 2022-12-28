package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class DynamicLoadingPage extends GenericPage {

	@FindBy(xpath = "//button[.='Start']")
	public WebElement startButton;

	@FindBy(id = "finish")
	public WebElement message;

	public DynamicLoadingPage() {
		PageFactory.initElements(driver, this);
	}
}
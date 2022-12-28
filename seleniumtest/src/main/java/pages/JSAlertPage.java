package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class JSAlertPage extends GenericPage {

	@FindBy(xpath = "(//button)[1]")
	public WebElement jsAlert;

	@FindBy(xpath = "(//button)[2]")
	public WebElement jsConfirm;

	@FindBy(xpath = "(//button)[3]")
	public WebElement jsPrompt;
	
	@FindBy(xpath = "//p[@id='result']")
    public WebElement message;

	public JSAlertPage() {
		PageFactory.initElements(driver, this);
	}
}
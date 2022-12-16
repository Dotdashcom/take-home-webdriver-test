package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class JSPage extends BaseClass {
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[1]/button")
	public WebElement jsAlert;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[2]/button")
	public WebElement jsConfirm;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[3]/button")
	public WebElement jsPrompt;

	public JSPage() {
		PageFactory.initElements(driver, this);
	}

}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	private WebElement searchRemoveButton;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	private WebElement searchAddButton;
	
	@FindBy(xpath="//p[@id='message']")
	private WebElement searchmessage;
	
	@FindBy(xpath="//button[contains(text(),'Enable')]")
	private WebElement searchEnableButton;
	
	@FindBy(xpath="//button[contains(text(),'Disable')]")
	private WebElement searchDisableButton;
	
	@FindBy(xpath="//form[@id='input-example']//p[@id='message']")
	private WebElement searchmessage2;

	
	public DynamicControlsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	public void clickremovebutton() {
		searchRemoveButton.click();
	}
	public WebElement removebuttonelement() {
		return searchRemoveButton;
	}
	
	public void clickaddbutton() {
		searchAddButton.click();
	}
	public WebElement addbutton() {
		return searchAddButton;
	}
	
	public String getmessage() {
		return searchmessage.getText();
	}
	
	public void clickenablebutton() {
		searchEnableButton.click();
	}
	public WebElement enablebutton() {
		return searchEnableButton;
	}
	
	public void clickdisablebutton() {
		searchDisableButton.click();
	}
	public WebElement disablebutton() {
		return searchDisableButton;
	}
	public String getmessage2() {
		return searchmessage2.getText();
	}

}

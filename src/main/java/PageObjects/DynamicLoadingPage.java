package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
	@FindBy(xpath="//button[contains(text(),'Start')]")
	private WebElement selectStartButton;
	
	@FindBy(xpath="//h4[text()='Hello World!']")
	private WebElement selectgetText;
	
	public DynamicLoadingPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void startbutton() {
		selectStartButton.click();
	}
	
	public WebElement selectgettext() {
		return selectgetText;
	}

}

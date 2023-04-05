package dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

public WebDriver driver;
	
	

	@FindBy(css="div[class='flash success']")
	private WebElement successMessage;
	
	@FindBy(xpath="//a[@class='button secondary radius']/i")
	private WebElement logout;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	public WebElement getSuccessMessage() {
		return successMessage;
	}
	
	public WebElement getLogoutButton() {
		return logout;
	}

}

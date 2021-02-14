package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends BaseDriver{
	public SecurePage(WebDriver driver){
        super(driver);
    }

	@FindBy(xpath="//a[@href='/logout']")
	public WebElement logoutBtn;
	
	public boolean isSecuredPageDisplayed() {
		return logoutBtn.isDisplayed();
	}
}

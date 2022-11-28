package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class IFramePage extends BrowserUtilities {

	public IFramePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "mce_0_ifr")
	WebElement iFrame;
	
	@FindBy(how = How.ID, using = "tinymce")
	WebElement iFrameElement;	

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'create an account')]")
	WebElement createAccountLink;

	public void getUrl() {
		driver.get(BaseTest.getURL("iframe"));
	}
	
	public String switchToFrame() {
		driver.switchTo().frame("mce_0_ifr");
		iFrameElement.clear();
		iFrameElement.sendKeys("testSample");
		return iFrameElement.getText();
	}
	
	public void clickCreateAccountLink() {
		createAccountLink.click();
	}
}

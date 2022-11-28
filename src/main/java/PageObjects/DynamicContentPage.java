package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class DynamicContentPage extends BrowserUtilities {
	public DynamicContentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'click here')]")
	WebElement clickHereLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id='content']/div[3]/div[2]")
	WebElement dynamicContentElement;
	
	public void getUrl() {
		driver.get(BaseTest.getURL("dynamic_content"));
	}
	public void refeshPage() {
		Click(clickHereLink);
	}
	public String getText() {
		return getText(dynamicContentElement);
	}
}

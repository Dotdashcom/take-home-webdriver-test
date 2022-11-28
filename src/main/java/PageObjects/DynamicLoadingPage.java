package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class DynamicLoadingPage extends BrowserUtilities {
	public DynamicLoadingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Start')]")
	WebElement btn_Start;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Hello World!')]")
	WebElement dynamiclaodText;
	
	public void getUrl() {
		driver.get(BaseTest.getURL("dynamic_loading/2"));
	}
	public void clickStart() {
		Click(btn_Start);
	}
	public String getDynamicElementText() {
		return getText(dynamiclaodText);
	}
	public void explicitWaitOfElement() {
		fnExplictWaitOfElement(driver,dynamiclaodText);
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utilities.TestUtility;

public class DynamicLoadingPage {

	WebDriver driver;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(css = "#start > button")
	WebElement btnStart;

	@FindBy(css = "#finish > h4")
	WebElement textMessage;

	public String getMessage() {
		btnStart.click();
		TestUtility.waitForElement(textMessage, 15);
		return textMessage.getText();
	}

	// get url
	public DynamicLoadingPage getUrl() {
		driver.navigate().to(TestBase.url + "/dynamic_loading/2");
		return this;
	}
}

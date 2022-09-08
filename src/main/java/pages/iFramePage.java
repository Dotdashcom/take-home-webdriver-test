package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class iFramePage {
	static WebDriver driver;

	public iFramePage(WebDriver driver) {
		iFramePage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//div[@id = 'menu']")
	WebElement FLOATING_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//body[@id = 'tinymce']")
	WebElement INPUT_BOX_IN_iFRAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@class= 'tox-notification__dismiss tox-button tox-button--naked tox-button--icon']")
	WebElement TINY_CLOUD_REGRISTRATION_ALERT_ELEMENT;

//	Methods
	public void handlingJavaScriptAlert() {
		TINY_CLOUD_REGRISTRATION_ALERT_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switctToiFrame() {
		driver.switchTo().frame("mce_0_ifr");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sendingTextToiFrame() {
		INPUT_BOX_IN_iFRAME_ELEMENT.clear();
		INPUT_BOX_IN_iFRAME_ELEMENT.sendKeys("I'm Batman!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateTextIsPresentInInputBoxOfiFrame() {
		String actuatext = INPUT_BOX_IN_iFRAME_ELEMENT.getText();
		Assert.assertEquals(actuatext, "I'm Batman!!", "Text does not match the expected text!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

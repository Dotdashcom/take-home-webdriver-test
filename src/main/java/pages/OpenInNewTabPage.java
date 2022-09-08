package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OpenInNewTabPage {
	static WebDriver driver;

	public OpenInNewTabPage(WebDriver driver) {
		OpenInNewTabPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//a[@href = '/windows/new']")
	WebElement CLICK_HERE_HYPERLINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h3[contains(text(), 'New Window')]")
	WebElement NEW_TAB_TEXT_ELEMENT;

//	Methods
	public void clickClickHereHyperlink() {
		CLICK_HERE_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switchtingToTheNewTab() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateNewTabIsOpenWithNewWindowTextPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(NEW_TAB_TEXT_ELEMENT));
		Assert.assertTrue(NEW_TAB_TEXT_ELEMENT.isDisplayed(),
				"'New Window' text is not present in the new tab or the test is not in the new tab");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

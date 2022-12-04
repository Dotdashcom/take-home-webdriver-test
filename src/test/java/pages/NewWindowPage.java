package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.AbstractE2E;

public class NewWindowPage {

	WebDriver driver;

	public NewWindowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Click Here']")
	WebElement linkClickHere;

	@FindBy(xpath = "//h3[contains(text(),'New Window')]")
	WebElement textNewWindow;

	public String getNewWindowMessage() {
		return textNewWindow.getText();
	}

	public NewWindowPage switchToNewTab() {
		String parentWindowHandle = driver.getWindowHandle();
		linkClickHere.click();

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		tabs.remove(parentWindowHandle);
		driver.switchTo().window(tabs.get(0).toString());
		return this;
	}

	// get url
	public NewWindowPage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/windows");
		return this;
	}
}

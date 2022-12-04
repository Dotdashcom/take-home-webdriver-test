package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.AbstractE2E;
import utilities.TestHandler;

public class ContextMenuPage {

	WebDriver driver;

	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(id = "hot-spot")
	WebElement hotSpot;

	public ContextMenuPage rightClickHotSpotBox() {
		TestHandler.contextClick(hotSpot);
		return this;
	}

	public String getAlertMessage() {
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}

	public ContextMenuPage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/context_menu");
		return this;
	}
}
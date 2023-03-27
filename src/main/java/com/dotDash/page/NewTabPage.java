package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.ReportUtil;
import com.dotDash.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class NewTabPage extends BasePage {
	private WebDriver driver;

	public NewTabPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Opening a new window']")
	private WebElement newTabHeader;
	@FindBy(tagName = "h3")
	private WebElement newTabElement;
	@FindBy(linkText = "Click Here")
	private WebElement clickHereLink;
	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToNewTabPage() {
		navigateTo(TestProperties.getProperty("NEW_TAB_URL"));
		assertEquals("Hover Page Elements Header",checkWebElementExist(newTabHeader), true);
	}
	/**
	 * To Validate JS Error functionality
	 * @author Seb Geb
	 */
	
	public void validateNewTabFunctionality() {
		clickOnElement(clickHereLink);
		for(String window:driver.getWindowHandles()){
			driver.switchTo().window(window);
		}
		assertEquals("Validate New Window Page",newTabElement.getText(),"New Window");
	}
}

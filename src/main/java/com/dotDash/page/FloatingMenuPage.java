package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.ReportUtil;
import com.dotDash.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class FloatingMenuPage extends BasePage {
	private WebDriver driver;

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Floating Menu']")
	private WebElement floatingMenuHeader;
	@FindBy(css = "#menu")
	private WebElement floatingMenu;

	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToFloatinMenuPage() {
		navigateTo(TestProperties.getProperty("FLOATING_MENU_URL"));
		assertEquals("File Upload Page Elements Header",checkWebElementExist(floatingMenuHeader), true);
	}
	/**
	 * To Validate Floating Menu functionality
	 * @author Seb Geb
	 */
	
	public void validateFloatingMenuFeature() {
		waitForElementExistance(floatingMenu);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		ReportUtil.logMessage(LogStatus.INFO,"Scroll Down","Scroll Down Successfully");
		waitForElementExistance(floatingMenu);
	}
}

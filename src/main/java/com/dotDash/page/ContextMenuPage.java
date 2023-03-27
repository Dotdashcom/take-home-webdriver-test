package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.ReportUtil;
import com.dotDash.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * This Class is have Context Menu related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class ContextMenuPage extends BasePage {
	private WebDriver driver;

	public ContextMenuPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Context Menu']")
	private WebElement contextMenuHeader;
	@FindBy(css = "#hot-spot")
	private WebElement hotSpotArea;
	/**
	 * To check Checkbox page
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToContextMenuPage() {
		navigateTo(TestProperties.getProperty("CONTEXTMENU_URL"));
		Assert.assertEquals(checkWebElementExist(contextMenuHeader), true);
	}
	/**
	 * To Validate Context Menu functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateContextMenuFeature() {
		rightClick(hotSpotArea);
		String alertText=driver.switchTo().alert().getText();
		Assert.assertEquals(alertText,"You selected a context menu");
		driver.switchTo().alert().accept();
		ReportUtil.logMessage(LogStatus.PASS,"Pop up closed","Pop up closed");
	}
}

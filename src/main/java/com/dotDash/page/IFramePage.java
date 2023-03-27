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
public class IFramePage extends BasePage {
	private WebDriver driver;

	public IFramePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")
	private WebElement iFrameHeader;
	@FindBy(css = "#mce_0_ifr")
	private WebElement iFrame;
	@FindBy(css = "#tinymce")
	private WebElement iFrameTextArea;

	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToIFramePage() {
		navigateTo(TestProperties.getProperty("IFRAME_URL"));
		assertEquals("File Upload Page Elements Header",checkWebElementExist(iFrameHeader), true);
	}
	/**
	 * To Validate Floating Menu functionality
	 * @author Seb Geb
	 */
	
	public void validateFloatingMenuFeature() {
		driver.switchTo().frame(iFrame);
		String textToEnter = "DUMMY TEXT";
		setData(iFrameTextArea, textToEnter);
		assertEquals("Asserts Text present",iFrameTextArea.getText(),textToEnter);
	}
}

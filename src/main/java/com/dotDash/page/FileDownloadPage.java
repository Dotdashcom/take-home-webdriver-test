package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class FileDownloadPage extends BasePage {
	private WebDriver driver;

	public FileDownloadPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='File Downloader']")
	private WebElement fileDownloadHeader;
	@FindBy(linkText = "some-file.txt")
	private WebElement someFileLink;

	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToFileDowloadPage() {
		navigateTo(TestProperties.getProperty("FILE_DOWNLOAD_URL"));
		assertEquals("File Download Page Elements Header",checkWebElementExist(fileDownloadHeader), true);
	}
	/**
	 * To Validate DYNAMIC CONTROL functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateDynamicLoadingFeature() {
		clickOnElement(someFileLink);
		waitForFileToDownload(someFileLink.getText());
	}
}

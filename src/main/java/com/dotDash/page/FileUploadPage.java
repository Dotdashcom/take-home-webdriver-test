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
public class FileUploadPage extends BasePage {
	private WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='File Uploader']")
	private WebElement fileUploadHeader;
	@FindBy(xpath = "//h3[text()='File Uploaded!']")
	private WebElement fileUploadedHeader;
	@FindBy(css = "#file-upload")
	private WebElement fileChooseButton;
	@FindBy(css = "#file-submit")
	private WebElement fileUploadButton;

	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToFileUploadPage() {
		navigateTo(TestProperties.getProperty("FILE_UPLOAD_URL"));
		assertEquals("File Upload Page Elements Header",checkWebElementExist(fileUploadHeader), true);
	}
	/**
	 * To Validate File Upload functionality
	 * @author Seb Geb
	 *
	 */
	
	public void validateFileUploadFeature() {
		setData(fileChooseButton,System.getProperty("user.dir")+"/src/resources/UploadSampleFile.txt");
		clickOnElement(fileUploadButton);
		waitForElementExistance(fileUploadedHeader);
	}
}

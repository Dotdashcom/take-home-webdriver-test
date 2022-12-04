package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.AbstractE2E;
import utilities.TestHandler;

public class FileUploadPage {

	WebDriver driver;
	String filePath = System. getProperty("user.dir") + "/data/";

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators

	@FindBy(xpath = "//*[@id='file-upload']")
	WebElement chooseFileButton;

	@FindBy(id = "file-submit")
	WebElement uploadButton;

	@FindBy(id = "uploaded-files")
	WebElement uploadedFileMessage;

	@FindBy(xpath = "//div[@id='drag-drop-upload']/descendant::div[@class='dz-filename']/span")
	WebElement dragAndDropFieldFileName;

	@FindBy(xpath = "//div[@id='drag-drop-upload']")
	WebElement dragAndDropField;

	public String uploadFileUsingButton(String fileName) {
		chooseFileButton.sendKeys(filePath + fileName);
		uploadButton.click();
		return uploadedFileMessage.getText();
	}

	public String uploadFileUsingDragAndDrop(String fileName) {
		TestHandler.DropFile(new File(filePath + fileName), dragAndDropField, 0, 0);
		return dragAndDropField.getText();
	}

	// get url
	public FileUploadPage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/upload");
		return this;
	}
}

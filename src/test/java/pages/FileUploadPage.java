package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utilities.TestUtility;

public class FileUploadPage {

	WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(id = "file-upload")
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
		String filePath = "C:\\Users\\shiva\\Downloads\\" + fileName;
		chooseFileButton.sendKeys(filePath);
		uploadButton.click();
		return uploadedFileMessage.getText();
	}

	public String uploadFileUsingDragAndDrop(String fileName) {
		String filePath = "C:\\Users\\shiva\\Downloads\\" + fileName;
		TestUtility.DropFile(new File(filePath), dragAndDropField, 0, 0);
		return dragAndDropField.getText();
	}

	// get url
	public FileUploadPage getUrl() {
		driver.navigate().to(TestBase.url + "/upload");
		return this;
	}
}

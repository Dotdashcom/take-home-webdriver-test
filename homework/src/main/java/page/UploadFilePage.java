package page;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UploadFilePage {

	WebDriver driver;
	private static String filePath = "C:\\Users\\13136\\Downloads\\";
	private static String fileName = "some-file.txt";

	public UploadFilePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'File Upload')]")
	WebElement FILEUPLOAD_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='file-upload']")
	WebElement CHOOSEFILE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='file-submit']")
	WebElement FILESUBMIT_ELEMENT;

	// goint to upload link
	public void uploadFileMenu() {
		FILEUPLOAD_MENU_ELEMENT.click();
	}

	// downloading text file
	public void uploadFile() throws InterruptedException {

		CHOOSEFILE_ELEMENT.sendKeys(filePath + fileName);

		System.out.println("Before upload file exists:" + isFileExists(filePath + fileName));
		FILESUBMIT_ELEMENT.click();
		Thread.sleep(4000);
		System.out.println("After upload file exists:" + isFileExists(filePath + fileName));

	}

	// checking if the file exists
	public boolean isFileExists(String filePath) {
		File newFile = new File(filePath);
		if (newFile.exists()) {
			return true;
		} else
			return false;

	}

}

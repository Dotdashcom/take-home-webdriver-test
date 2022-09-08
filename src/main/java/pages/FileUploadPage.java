package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadPage {
	static WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		FileUploadPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//input[@id = 'file-upload']")
	WebElement CHOOSE_FILE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id = 'file-submit']")
	WebElement UPLOAD_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'FileUpload.txt')]")
	WebElement FILE_UPLOADED_NAME_ELEMENT;

//	Methods
	public void uploadFile() {
		CHOOSE_FILE_BUTTON_ELEMENT.sendKeys("C:\\Users\\amado\\Downloads\\FileUpload.txt");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickUploadButton() {
		UPLOAD_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateFileIsUploaded() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(FILE_UPLOADED_NAME_ELEMENT));
		Assert.assertEquals(FILE_UPLOADED_NAME_ELEMENT.getText(), "FileUpload.txt", "The file is not uploaded!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

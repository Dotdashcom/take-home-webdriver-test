package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FileUploadPage extends BaseTemplate{

	public FileUploadPage(WebDriver driver) {
		super(driver);
	}
	
	   private final By chooseFileButton = By.cssSelector("#file-upload");
	   private final By submitButton = By.cssSelector("#file-submit");
	   private final By uploadStatus = By.cssSelector("div[class='example'] h3");
	
	public void uploadFile(String path) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(chooseFileButton));
		driver.findElement(chooseFileButton).sendKeys(path);
	}
	
	public void uploadButtonClick() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(submitButton));
		driver.findElement(submitButton).click();
	}
	
	public boolean isFileUploaded(String message) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(uploadStatus));
		return driver.findElement(uploadStatus).getText().equals(message);
	}

}

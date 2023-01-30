package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class UploadPage extends BaseTest {

	private By chooseFileBtn = By.id("file-upload");
	private By uploadBtn = By.id("file-submit");
	private By uploadedFilesDiv = By.id("uploaded-files");
	

	public void fileUpload() {
		driver.findElement(chooseFileBtn).sendKeys("/home/andriy/Downloads/some-file.txt");;
		driver.findElement(uploadBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Assert.assertTrue(wait.until(ExpectedConditions.textToBe(uploadedFilesDiv, "some-file.txt")));
		
	}

	

}

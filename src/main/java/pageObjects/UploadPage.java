package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadPage {

	public WebDriver driver;
	By fileuploadLocator = By.id("file-upload");
	By uploadButtonLoc = By.id("file-submit");
	public UploadPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getFileUploadLocator()
	{
		return driver.findElement(fileuploadLocator);
	}
	public WebElement getUploadButtonLoc()
	{
		return driver.findElement(uploadButtonLoc);
	}
}

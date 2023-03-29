package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage
{
	WebDriver driver;
	public FileUploadPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By fileUploadElement = By.id("file-upload");
	By uploadButtonElement = By.id("file-submit");
	By sucessMessageElement = By.xpath("//h3[contains(text(),'File Uploaded!')]");
	
	public void clickBrowseButton()
	{
		driver.findElement(fileUploadElement);
	}
	public void clickUploadButton()
	{
		driver.findElement(uploadButtonElement);
	}
	public String getSuccessMessage()
	{
		return driver.findElement(sucessMessageElement).getText();
	}
	public void uploadTheFile()
	{
		driver.findElement(fileUploadElement).sendKeys("C:\\Users\\priya\\Desktop\\some-file.txt");
	}
}

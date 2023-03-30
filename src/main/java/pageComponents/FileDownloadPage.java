package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloadPage
{
	WebDriver driver;
	public FileDownloadPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By downloadLinkElement = By.xpath("//a[contains(text(),'some-file.txt')]");
	
	public void clickDownloadLink()
	{
		driver.findElement(downloadLinkElement).click();
	}
}

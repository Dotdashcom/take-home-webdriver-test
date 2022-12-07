package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloadPage extends BasePage {
	
	private String page = "download";
	private By file = By.cssSelector(".example > a");

	public FileDownloadPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	public String getFileName() {
		return driver.findElement(file).getText();
	}
	
	public void downloadFile() {
		driver.findElement(file).click();
	}

}

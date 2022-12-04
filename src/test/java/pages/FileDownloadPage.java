package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseTest.AbstractE2E;

public class FileDownloadPage {

	WebDriver driver;

	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(xpath = "//a[contains(text(),'some-file.txt')]")
	WebElement fileLink;

	public void clickLink() {
		fileLink.click();
	}

	public Boolean isFileDownloaded(String fileName) {
		String userHome = System.getProperty("user.home");
		File downloadedFile = new File(userHome + "/Downloads/" + fileName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(d -> downloadedFile.exists());
		boolean fileSuccessfullyDownloaded = downloadedFile.exists();
		if(downloadedFile.exists())
			downloadedFile.delete();
		return fileSuccessfullyDownloaded;
	}

	// get url
	public FileDownloadPage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/download");
		return this;
	}
}

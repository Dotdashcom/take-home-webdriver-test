package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

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
		File downloadedFilePath = new File("C:\\Users\\shiva\\Downloads\\" + fileName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(d -> downloadedFilePath.exists());
		return downloadedFilePath.exists();
	}

	// get url
	public FileDownloadPage getUrl() {
		driver.navigate().to(TestBase.url + "/download");
		return this;
	}
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DownloadNewFilePage;
import util.BrowserFactory;

public class DownloadNewFileTest {

	WebDriver driver;

	@Test
	public void downloadFilecheck() throws InterruptedException {

		driver = BrowserFactory.init();

		DownloadNewFilePage downloadFile = PageFactory.initElements(driver, DownloadNewFilePage.class);
		downloadFile.downloadMenu();
		downloadFile.downloadFile();

		// closing browser
		BrowserFactory.tearDown();

	}

}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.UploadFilePage;
import util.BrowserFactory;

public class UploadFileTest {

	WebDriver driver;

	@Test
	public void uploadFileCheck() throws InterruptedException {

		driver = BrowserFactory.init();
		UploadFilePage uploadfile = PageFactory.initElements(driver, UploadFilePage.class);
		uploadfile.uploadFileMenu();
		uploadfile.uploadFile();

		// closing browser
		BrowserFactory.tearDown();

	}

}

package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.FileDownloadPage;

public class FileDownloadTest extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/upload");//to launch the browser
	}

	@Test
	public void Download(){
		FileDownloadPage download = new FileDownloadPage(driver);
		download.download();
	}
	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}

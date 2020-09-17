package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.FileDownloadPage;
import com.POM.FileUploadPage;

public class FileUploadTest extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/upload");//to launch the browser
	}

	@Test
	public void upload(){
		FileUploadPage upload = new FileUploadPage(driver);
		upload.Upload("/Users/ismailfarouqe/Desktop/Hello dot dash.docx");
	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}

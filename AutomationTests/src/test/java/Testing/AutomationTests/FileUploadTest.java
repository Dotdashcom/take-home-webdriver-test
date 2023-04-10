package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.FileUploadPage;
import resources.base;

public class FileUploadTest extends base{
	

		public WebDriver driver;
		FileUploadPage upload;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("uploadUrl"));

		}


		@Test
		public void validateFileUpload() throws IOException, InterruptedException {	

			upload= new FileUploadPage(driver);
				String uploadMessage=upload.uploadFile("some-file.txt");
				Assert.assertEquals(uploadMessage, "File Uploaded!");
			
		}


		@AfterMethod
		public void closeBrowser() {

			driver.quit();
		}
}


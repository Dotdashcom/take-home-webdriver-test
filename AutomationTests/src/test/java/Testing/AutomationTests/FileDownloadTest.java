package Testing.AutomationTests;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import pageobjects.FileDownloadPage;
import resources.base;

public class FileDownloadTest extends base {
	
		public WebDriver driver;
		FileDownloadPage downloadpage;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("downloadUrl"));

		}


		@Test
		public void validateFileDownload() throws IOException, InterruptedException, AWTException {	
			downloadpage= new FileDownloadPage(driver);
			 downloadpage.downloadFileAndVerifyFileExists();	 
		}
		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}

}

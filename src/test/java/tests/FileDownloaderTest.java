package tests;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.FileDownloaderPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class FileDownloaderTest extends InternetWebBaseTest{
	@Test
	public void testClickForJSAlert() throws IOException {
			driver.get(loadProperties().getProperty("BASE_URL")+"download");
			FileDownloaderPage link=new FileDownloaderPage(driver);
			link.selectsomefile();
			File file1=new File(loadProperties().getProperty("FILEPATH")+"some-file.txt");
			Assert.assertTrue(file1.exists());
			link.selectsomefile();
			File file2=new File(loadProperties().getProperty("FILEPATH")+"Sample.txt");
			Assert.assertTrue(file2.exists());
			
	}

}

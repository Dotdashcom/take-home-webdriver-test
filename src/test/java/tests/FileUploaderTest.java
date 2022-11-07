package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import PageObjects.FileUploaderPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class FileUploaderTest extends InternetWebBaseTest{
	@Test
	public void testFileUploader() throws IOException {
		driver.get(loadProperties().getProperty("BASE_URL")+"upload");
		FileUploaderPage filepath=new FileUploaderPage(driver);
		filepath.fileuploader();
		Assert.assertEquals("File not Uploaded",filepath.gettext(),"File Uploader");
		
	}
	

}

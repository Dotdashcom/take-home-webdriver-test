package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class FileUploadTest extends TestBase {
	
	BrowseData data;
	BaseUrl urlvalues;
	public FileUploadTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}

	@Test  
	public void verifyFileUpload()
	{
		driver.get(urlvalues.url_fileupload);
		
		//uploading the file from one location to other 
		data.fileupload.sendKeys("C:\\Selenium_MyPractise\\KevalDotDash\\src\\main\\java\\testdata\\some-file.txt");
		data.fileuploadbutton.click();
		String s1 = data.uploadtext.getText();
		String s2 = "File Uploaded!";
		Assert.assertEquals(s1, s2);
		System.out.println("file uploaded successfully....");	
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}

package testcases;

import java.io.File;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class FileDownloadTest extends TestBase {
	BrowseData data;
	BaseUrl urlvalues;
	public FileDownloadTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test 
	public void verifyFileDownload() throws InterruptedException, IOException
	{		
		driver.get(urlvalues.url_filedownload);	
		data.filedownload.click();
		Thread.sleep(2000);	
		
		//store the file on specific location 
		File listOfFile[] = folder.listFiles();
		
		Assert.assertTrue(listOfFile.length>0);
		for(File file :listOfFile ) {
			Assert.assertTrue(file.length()>0);
			System.out.println("file successfully downloaded");
		}
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

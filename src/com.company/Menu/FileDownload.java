package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownload {

	WebDriver driver;
	String downloadPath="C:\\Users\\16475\\Downloads";
	@Test
	public void VerifyDownloadWithFileName() throws Exception
	{
		BrowseFactory.setUp();
		
		driver=BrowseFactory.StartBrowser(BaseUrl.file_DownloadPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		  baseObjectClass.filedownload().click();
		  Thread.sleep(5000);
		  Assert.assertTrue(BrowseFactory.isFileDownloaded(downloadPath, "some-file.txt"), "Failed to download Expected document");
		
		  
		BrowseFactory.tearDown();
		
	}
	
	
   

	
}

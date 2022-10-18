package webtests.Testlayers;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_009_FileDownload_POM;

public class WT_09_FileDownload_Test extends WT_BaseClass{

	WT_009_FileDownload_POM filedownload;
	
	//Constructor
	public WT_09_FileDownload_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
	
		filedownload = new WT_009_FileDownload_POM();
		
		driver.get(pr.getProperty("baseurl")+"/download");
		logg.info("****FileDownload url opened****");
		
    }
	
	@Test
	public void FileDownloadTest() throws InterruptedException {

		filedownload.FileLink();
		Thread.sleep(2000);
		logg.info("****Test downloads file****");
	
	}
	
	@Test
	public void VerifyFile() {
			
		filedownload.verifyDownload();
			
			Assert.assertTrue(filedownload.verifyDownload());
			logg.info("****File has been downloaded****");
	}   
     
}
	

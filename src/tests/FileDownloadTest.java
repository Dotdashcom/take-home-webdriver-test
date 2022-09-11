package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.TestBase;
import pages.FileDownloadPage;

public class FileDownloadTest extends TestBase {
	
	FileDownloadPage fp=new FileDownloadPage();
	
	@BeforeClass
	public void openBrowser() {
		fp.Initialization();
		fp.landingPage();
	}
	@Test
	public void clickLink() {
		fp.clickOnLink();
	}
	@Test 
	public void verifyDownload() {
		Assert.assertTrue(fp.verifyDownload());
	}
	
	@AfterClass
	public void afterClass() {
		fp.closeBrowser();
	}
	}


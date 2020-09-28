import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FileDownloadPage;


public class FileDownload_Test extends BaseTest{
	FileDownloadPage page=null;
	
@Test
public void validateFileDownload() {
	page=new FileDownloadPage(driver);
	try {
		page.downloadFile();
	Assert.assertEquals(page.ifFileDownloaded("some-file.txt"), true);	
	}
	catch(Exception e) {
		e.getLocalizedMessage();
		Assert.assertTrue(false);
	}
}
}


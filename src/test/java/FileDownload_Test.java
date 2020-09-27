import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckBoxPage;
import pages.DropDownPage;
import pages.FileDownloadPage;


public class FileDownload_Test extends BaseTest{
	FileDownloadPage page=null;
	
@Test
public void validateOptionOne() {
	page=new FileDownloadPage(driver);
	try {
		page.downloadFile();
	Assert.assertEquals(page.ifFileDownloaded("some-file.txt"), true);	
	}
	catch(Exception e) {
		Assert.assertTrue(false);
		e.getLocalizedMessage();
	}
}
}


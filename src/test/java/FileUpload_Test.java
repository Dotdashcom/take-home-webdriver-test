import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.WebLink;
import pages.CheckBoxPage;
import pages.DropDownPage;
import pages.FileUploadPage;


public class FileUpload_Test extends BaseTest{
	FileUploadPage page=null;
	
@Test
public void validateOptionOne() {
	page=new FileUploadPage(driver);
	driver.get(WebLink.file_UploadPageUrl);
	try {
	page.uploadFile();
	Assert.assertEquals(page.isFileUploaded(), true);	
	}
	catch(Exception e) {
		e.printStackTrace();
		Assert.assertTrue(false);
		e.getLocalizedMessage();
	}
}


}

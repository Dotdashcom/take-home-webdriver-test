package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.FileUploadPage;

public class FileUploadTest {
	
	@Test
	public void fileUpload() {
		Page.initConfiguration("upload");
		FileUploadPage fp = new FileUploadPage();
		fp.verifyUploadFile();	
		Page.quitBrowser();
	}

}

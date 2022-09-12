package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.FileDownloadPage;

public class FileDownloadTest {
	
	@Test
	public void checkFileDownload() {
		Page.initConfiguration("download");
		FileDownloadPage fp = new FileDownloadPage();
		fp.verifyFileDownlaod();
		Page.quitBrowser();
	}

}

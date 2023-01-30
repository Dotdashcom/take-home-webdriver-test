package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DownloadPage;

public class Test10_Download extends DownloadPage{
	
	Logger logger = LogManager.getLogger(Test10_Download.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/download");
		logger.info("The browser opened and navigated to " + URL + "/download");
	}

	@Test(priority = 0)
	void fileDownload_() {
		fileDownload();
		logger.info("fileDownload_() Test successfully passed");
	}

}

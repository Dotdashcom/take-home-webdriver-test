package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UploadPage;

public class Test11_Upload extends UploadPage{
	
	Logger logger = LogManager.getLogger(Test11_Upload.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/upload");
		logger.info("The browser opened and navigated to " + URL + "/upload");
	}

	@Test(priority = 1)
	void fileDownload_() {
		fileUpload();
		logger.info("fileUpload_() Test successfully passed");
	}

}

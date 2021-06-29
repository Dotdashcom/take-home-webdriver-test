import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.FileUpload;

public class FileUploadTest {

	private WebDriver driver = null;
	
	@Before
	public void init() throws IOException {
		Browser browser = Browser.valueOf(
				PropertyReader.getPropertiesFromFile(
						"src/test/resources/config.properties",
						"browser"));
		
		driver = DriverFactory.getDriver(browser);
		driver.manage().window().maximize();		
	}
	
	/**
	 * Check that file was uploaded
	 * Note:  We are only testing the upload function
	 * This doesn't cover the drag and drop, nor the File Open dialog.
	 * Those can be tested manually (for now). 
	 */
	@Test
	public void uploadFileIsAccepted() {
		FileUpload fileUploadPage = new FileUpload(driver);
		String file = System.getProperty("user.dir") + "/resources/blah";
		System.out.println("Will try to upload file: " + file);
		fileUploadPage.uploadFile(file);		
		assertTrue("File did not upload", fileUploadPage.isUploaded());
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}

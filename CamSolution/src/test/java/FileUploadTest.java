import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FileUpload;

public class FileUploadTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
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
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}

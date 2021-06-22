import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FileDownload;

public class FileDownloadTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	/*
	 * Test file download
	 * This method would fail if other processes are modifying the downloads directory
	 */
	@Test
	public void checkFileAppearsInDownloadDirectory() {
		
		// Choose this to be large enough to allow the file to finish
		final int FILE_DOWNLOAD_DELAY_S = 5;
		
		// Record the file count in the downloads directory before starting
		File downloadsDirectory = new File(System.getProperty("user.home") + File.separator + "Downloads");
		int numFiles = downloadsDirectory.listFiles().length;

		FileDownload downloadPage = new FileDownload(driver);
		downloadPage.clickDownloadLink();
		
		// Allow sufficient time for the file to finish downloading
		try {
			Thread.sleep(FILE_DOWNLOAD_DELAY_S * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// The file count should have increased by 1
		int numFilesAfter = downloadsDirectory.listFiles().length;
		assertTrue( numFilesAfter == numFiles + 1);
		
	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}


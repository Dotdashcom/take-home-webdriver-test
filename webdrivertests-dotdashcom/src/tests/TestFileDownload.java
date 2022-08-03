/**
 * 
 */
package tests;

import org.openqa.selenium.By;

/**
 * @author connorparnell
 *
 */
     
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.io.File;


public class TestFileDownload {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/download");
		
	}
	
	@Test
	public void fileDownloadSuccess() {
		// click on file download link
		WebElement downloadLink = driver.findElement(By.xpath("//*[@id='content']/div/a"));
		downloadLink.click();
		// wait
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// check if file is in downloads (deletes file after ensuring it is there)
		String userdir = System.getProperty("user.home");
		assertTrue(isFileDownloaded(userdir + "/Downloads", "some-file.txt"));
		
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] contents = dir.listFiles();

		for (int i = 0; i < contents.length; i++) {
			if (contents[i].getName().equals(fileName)) {
		        contents[i].delete();
		        return true;
		    }
		}
		      return false;
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Download {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/download");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void DownloadTest() throws InterruptedException {

		String downloadPath = "C:\\Users\\Jagseer\\Downloads";
		driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();
		Thread.sleep(2000);
		assertTrue(isFileDownloaded(downloadPath, "some-file.txt"));

	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}

}

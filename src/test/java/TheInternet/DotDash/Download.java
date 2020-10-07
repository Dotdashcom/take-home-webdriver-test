package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import java.io.File;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Download extends base{
	
	@Test
	public void DownloadTest() throws InterruptedException {
		driver.get(URL + "download ");

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

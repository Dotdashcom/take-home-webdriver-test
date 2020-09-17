package Scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.Base;

public class fileDownload extends Base {

	boolean check = false;

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		if (dir != null) {
			File[] dirContents = dir.listFiles();

			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().equals(fileName)) {
					// File has been found, it can now be deleted:
					dirContents[i].delete();
					return true;
				}
			}

		}
		return false;
	}

	@Test
	public void logger() {

		try {
			driver.get("http://localhost:7080/download");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");
			WebElement download = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
			download.click();

			check = isFileDownloaded("/Users/pitiasfessahaie/Downloads", "some-file.txt");
			assertTrue(check);

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

package tests;

import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.FileDownloadUploadPage;

public class FileDownloadTest extends BaseClass {
	FileDownloadUploadPage fileDownUpLoadPageObj;

	public FileDownloadTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/download");
		fileDownUpLoadPageObj = new FileDownloadUploadPage();
	}

	@Test
	public void Download() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("download.some-file.txt", false);
		option.setExperimentalOption("prefs", prefs);
		fileDownUpLoadPageObj.TextFile.click();
		Thread.sleep(15000);
		String downloadPath = "C:\\Users\\Farook\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		Assert.assertTrue(fileName.equals("some-file.txt"), "File Downloaded");
	}

	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.DownloadPage;

public class DownloadTest extends GenericPage {
	DownloadPage downloadPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/download");
		downloadPage = new DownloadPage();
	}

	@Test
	public void tcDownload() throws InterruptedException {
		downloadPage.downloadFile.click();
		Thread.sleep(5000);
		Assert.assertEquals(getDownloadedFile(downloadPage.downloadFile.getText()), "some-file.txt");
	}
	
	private String getDownloadedFile(String fileName) {
        File fileLocation = new File("C:\\Users\\neera\\Downloads");
        File[] files = fileLocation.listFiles();
        
        for (File file: files) {
            if (file.getName().equals(fileName)) {
                return file.getName();
            }
        }
        return null;
    }
}
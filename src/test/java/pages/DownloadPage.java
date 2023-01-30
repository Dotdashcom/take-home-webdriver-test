package pages;

import java.io.File;
import org.openqa.selenium.By;
import org.testng.Assert;
import base.BaseTest;

public class DownloadPage extends BaseTest {

	private By startBtn = By.xpath("//a[contains(text(),'some-file.txt')]");
	String downloadPath = prw.getProperties("downloadPath");

	public void fileDownload() {
		driver.findElement(startBtn).click();
		Assert.assertTrue(isFileDownloaded("some-file.txt"));

	}

	public Boolean isFileDownloaded(String fileName) {
		boolean flag = false;
		String dirPath = downloadPath;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files.length == 0 || files == null) {
			flag = false;
		} else {
			for (File listFile : files) {
				if (listFile.getName().contains(fileName)) {
					break;
				}
				flag = true;
			}
		}
		return flag;
	}

}

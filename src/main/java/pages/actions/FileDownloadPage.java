package pages.actions;

import java.io.File;

import org.testng.Assert;

import base.Page;

public class FileDownloadPage extends Page {

	public void verifyFileDownlaod() {
		String downloadPath = "C:\\Users\\Mihir\\Downloads";

		click(locators.fileDownload);

		Assert.assertTrue(isFileDownloaded(downloadPath, "some-file.txt"), "failed to download expected document");

	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
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

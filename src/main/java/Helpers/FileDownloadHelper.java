package Helpers;
import java.io.File;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.FileDownloadPage;
public class FileDownloadHelper extends Helper {
	FileDownloadPage fileDownloadPage;
	public FileDownloadHelper (Config testConfig) {
		super(testConfig);
		openFileDownloadPage();
	}
	public void openFileDownloadPage() {
		String FileDownloadPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("FileDownloadPage");
		Browser.openPageUrl(testConfig, FileDownloadPageUrl);
		fileDownloadPage = new FileDownloadPage(testConfig);
	}
	public void downloadFile() {
		fileDownloadPage.downloadFile();
	}
	public void verifyFile(String fileName) {
		String path = System.getProperty("user.home");
		String downloadPath = path + "/Downloads/";
		File folder = new File(downloadPath);
		for (File file : folder.listFiles()) {
			if (file.isFile() && file.getName().equals(fileName)) {
				Logger.AssertEqualAndLog("Verifying downloaded file - " + fileName + " - is present", file.getName().equals(fileName), true);
				break;
			}
		}
	}
}

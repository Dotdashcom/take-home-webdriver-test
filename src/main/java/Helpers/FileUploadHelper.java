package Helpers;
import java.io.File;
import Common.Browser;
import Common.Config;
import Common.Logger;
import PageObjects.FileUploadPage;
public class FileUploadHelper extends Helper {
	FileUploadPage fileUploadPage;
	public FileUploadHelper (Config testConfig) {
		super(testConfig);
		openFileUploadPage();
	}
	public void openFileUploadPage() {
		String FileUploadPageUrl = testConfig.getProperty("BasePageUrl") + testConfig.getProperty("FileUploadPage");
		Browser.openPageUrl(testConfig, FileUploadPageUrl);
		fileUploadPage = new FileUploadPage(testConfig);
	}
	public void uploadFile(String fileName) {
		File file = new File("Parameters/" + fileName);
		fileUploadPage.uploadFile(file.getAbsolutePath());
	}
	public void verifyUploadSuccessMessage(String fileName) {
		Logger.AssertEqualAndLog("Verifying upload success message - " + fileName, fileUploadPage.getSuccessMessage(), fileName);
	}
}

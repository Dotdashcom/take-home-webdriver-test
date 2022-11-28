package Test_Cases;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.FileDownloadPage;
import TestBase.BaseTest;

public class FileDownloadPageTest extends BaseTest {
	FileDownloadPage fileDownload;

	public FileDownloadPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		fileDownload = new FileDownloadPage();
	}

	@Test
	public void fileUploadTest() throws Exception {

		// logging into application
		fileDownload.getUrl();

		fileDownload.file_Download();
		Thread.sleep(2000);
		File listOfFiles[] = folder.listFiles();
		// make sure the directory is Empty
		Assert.assertTrue(listOfFiles.length > 0);

		for (File file : listOfFiles) {
			Assert.assertTrue(file.length() > 0);
		}
	}

}
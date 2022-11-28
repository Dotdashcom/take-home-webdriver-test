package Test_Cases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.FileUploadPage;
import TestBase.BaseTest;

public class FileUploadPageTest extends BaseTest {
	FileUploadPage fileUpload;

	public FileUploadPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		fileUpload = new FileUploadPage();
	}

	@Test
	public void fileUploadTest() {

		// logging into application
		fileUpload.getUrl();

		fileUpload.file_Upload();
	}

}
package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.FileUploadHelper;
public class TestFileUpload extends TestBase {
	@TestData ({"some-file.txt"})
	@Test (description = "Test file upload", dataProvider = "GetTestData")
	public void testFileUpload(Config testConfig, String fileName) {
		FileUploadHelper fileUploadHelper = new FileUploadHelper(testConfig);
		fileUploadHelper.uploadFile(fileName);
		fileUploadHelper.verifyUploadSuccessMessage(fileName);
	}
}

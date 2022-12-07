package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Helpers.FileDownloadHelper;
public class TestFileDownload extends TestBase {
	@Test (description = "Test file download", dataProvider = "GetTestConfig")
	public void testFileDownload(Config testConfig) {
		FileDownloadHelper fileDownloadHelper = new FileDownloadHelper(testConfig);
		fileDownloadHelper.downloadFile();
		fileDownloadHelper.verifyFile("some-file.txt");
	}
}

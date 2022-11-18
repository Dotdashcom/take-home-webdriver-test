package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FileDownloadPage;

public class FileDownloadTest extends TestBaseAssignment{
	
	@Test
	@Parameters({"FileDownloadUrl"})
	public void DownLoadFileAndVerifyFileNameTextTestCase(String FileDownloadUrl) throws InterruptedException{
		this.helper.getDriver().get(FileDownloadUrl);
		this.helper.maximizeWindows();
		
		
		FileDownloadPage fd = new FileDownloadPage(this.helper.getDriver());
		
		fd.ClickFile();
		Thread.sleep(10000);
		helper.VerifyFileName("some-file");
		
		
		}

}

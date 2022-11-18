package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FileUploadPage;

public class FileUploadTest extends TestBaseAssignment{
	@Test
	@Parameters({"UploadFileUrl"})
	public void FileUploadTestTestCase(String UploadFileUrl) throws InterruptedException{
		this.helper.getDriver().get(UploadFileUrl);
		this.helper.maximizeWindows();
		
		FileUploadPage dl = new FileUploadPage(this.helper.getDriver());		
	
		String path = helper.GetFilePath("SampleImage.png");
		dl.UploadFile(path);
		Thread.sleep(5000);
		dl.ClickButton("Upload");
		dl.VerifyFileUploaded("SampleImage.png");
		}

}

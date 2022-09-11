package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import graphql.Assert;
import pages.FileUploadPage;

public class FileUploadTest extends TestBase{
	
	FileUploadPage fp=new FileUploadPage();
	
	@BeforeClass
	public void openBrowser() {
		fp.Initialization();
		fp.landingPage();////Navigate to landing page
	}
	@Test
	public void VerifyFileUploaded() {

		fp.uploadFile();// upload the file 
		Assert.assertTrue(fp.verifyFile().contains("File Uploaded!"));//verify file uploaded successfully
	}
	@AfterClass
	public void afterClass() {
		fp.closeBrowser();//Close the Browser
	}
}

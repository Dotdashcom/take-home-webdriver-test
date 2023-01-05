package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.FileDownloadPage;
import java.Pages.FileUploadPage;
import basePack.BaseClass;

public class FileUploadTestcase extends BaseClass{

	public FileUploadTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	FileUploadPage fileupload;
	
	@BeforeMethod
	@Parameters("upload")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		fileupload = new FileUploadPage(driver);
		
		
	
	}
	
	@Test
	public void fileUploadingFunctionality() throws IOException
	{
		
		fileupload.uploadingFile();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}

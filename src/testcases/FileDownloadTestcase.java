package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.DynamicLoading;
import java.Pages.FileDownloadPage;
import basePack.BaseClass;

public class FileDownloadTestcase extends BaseClass{

	public FileDownloadTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	FileDownloadPage download;
	
	@BeforeMethod
	@Parameters("download")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		
		download = new FileDownloadPage(driver);
		
	
	}
		
	
	@Test
	public void fileDownloadingFunctionality() throws InterruptedException
	{
		download.validateDownloadingFile();
	}
		
		
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}

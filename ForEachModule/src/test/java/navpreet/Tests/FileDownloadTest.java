package navpreet.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.FileDownloadPageObjects;
import navpreet.util.ObjectsOfClasses;



public class FileDownloadTest extends ObjectsOfClasses{

ObjectsOfClasses base_instance;
FileDownloadPageObjects fdpo;
	
	@Test(description="Test clicks on the file.Test asserts that the file is downloaded.")
	public void File_Download_Test() throws IOException, AWTException{
		fdpo=fileDownloadApplication();
		fdpo.Click_FileDownload();
		fdpo.Click_FileName();
		boolean download=fdpo.VerifyFileDownload();
		Assert.assertTrue(download,"File Downloaded Successfully");
	}

}

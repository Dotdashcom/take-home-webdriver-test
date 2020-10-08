package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class FileUploadTest extends TestBase {
	
	public FileUploadTest() throws IOException {
		super();	
	}
	
	@Test  
	public void verifyFileUpload()
	{
		driver.get(urlvalues.url_fileupload);
		
		//uploading the file from one location to other 
		data.fileupload.sendKeys("C:\\Selenium_MyPractise\\KevalDotDash\\src\\main\\java\\testdata\\some-file.txt");
		data.fileuploadbutton.click();
		String s1 = data.uploadtext.getText();
		String s2 = "File Uploaded!";
		Assert.assertEquals(s1, s2);
		System.out.println("file uploaded successfully....");	
	}
}

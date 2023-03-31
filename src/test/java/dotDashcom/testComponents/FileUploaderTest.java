package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import dotDashcom.pageObjects.FileUploaderPage;

public class FileUploaderTest extends BaseTest{
	FileUploaderPage fileUploader;
	
	@Before
	public void setup() throws IOException {
		setup("/upload");
		fileUploader=new FileUploaderPage(driver);
	}
	
	@Test
	public void checkFileUpload() {
		String uploadMessage=fileUploader.uploadFile("some-file.txt");
		Assert.assertEquals(uploadMessage, "File Uploaded!");
	}
	
}

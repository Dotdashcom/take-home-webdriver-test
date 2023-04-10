package navpreet.Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import navpreet.pageobjects.FileUploadPageObjects;
import navpreet.util.ObjectsOfClasses;

public class FileUploadTest extends ObjectsOfClasses{

ObjectsOfClasses base_instance;
FileUploadPageObjects fupo;

	
	
	@Test(description="Test uses Upload Button or Drag and Drop to upload a file.Test asserts that the file is uploaded.")
	public void File_Upload_Test() throws IOException, InterruptedException{
		fupo=fileUploadApplication();
		fupo.Click_FileUpload();
		fupo.Choose_File();
		fupo.UploadingFile();
		String upload_message=fupo.Get_Message();
		Assert.assertEquals(upload_message, "File Uploaded!");
		
	}

}

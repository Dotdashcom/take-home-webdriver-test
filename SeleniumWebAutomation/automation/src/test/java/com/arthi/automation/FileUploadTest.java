
package com.arthi.automation;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.FileUploadPage;


/**
 * 
 * @author Arthina Kumar
 *
 */
public class FileUploadTest extends TestBase {
	private static final String FILE_NAME = "test_file.txt";

	@Test
	public void test_Upoad_files() throws URISyntaxException {
		URL resource = getClass().getClassLoader().getResource("ToUpload/" + FILE_NAME);		
		File file = new File(resource.toURI());
		
		FileUploadPage fileuploadpage = new FileUploadPage(getDriver());
		fileuploadpage.navigateToFileUploadPage()
		.verifyUploadFile(file.getPath())
		.verifyFileUploadedSuccessPage(file.getName());
	}
	
}

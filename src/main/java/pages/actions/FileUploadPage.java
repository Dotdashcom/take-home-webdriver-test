package pages.actions;

import org.testng.Assert;

import base.Page;

public class FileUploadPage extends Page{
	
	public void verifyUploadFile() {
		type(locators.fileUpload,"C:\\Users\\Mihir\\Downloads");
		click(locators.uploadBtn);
		System.out.println("file name: "+ locators.uploadedFile.getText());
		Assert.assertTrue(locators.uploadedFile.isDisplayed(), "file is not upload");
		
	}

}

package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.FileUpload;

public class FilleUpload_Test extends BaseClass{
	 FileUpload fu;
	public  FilleUpload_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		fu=new  FileUpload();
		
	}
	@Test
	public void Upload_TC() throws InterruptedException {
		String path = "C:\\\\Users\\\\rushi\\\\Downloads";
		fu.chooseFileBtn.sendKeys(path);
		fu.uploadBtn.click();
		Thread.sleep(2000);
		Assert.assertEquals(fu.msg.getText(), "File Uploaded!");
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}

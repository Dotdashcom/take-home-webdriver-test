package testcases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.FileDownloadAndUpload;

public class TC_FileDownloadUpload extends BaseClass {

	@Test
	public void VerifyFileDownload(){
		FileDownloadAndUpload fd = new FileDownloadAndUpload(driver);
		fd.FileDownload();
		File fileLocation = new File("C:\\Users\\arath\\Downloads");
		File[] Allfile = fileLocation.listFiles();
		assert Allfile != null;
		for ( File file : Allfile ) {
			if(file.getName().equals("some-file.txt")){
				System.out.println("Downloaded");
			}
		}

	}

	@Test
	public void VerifyFileUpload() {
		FileDownloadAndUpload fu = new FileDownloadAndUpload(driver);
		Assert.assertEquals(fu.FileUpload(),"File Uploaded!");
	}




}


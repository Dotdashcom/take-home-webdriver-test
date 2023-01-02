package TestLayer;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.DownloadFile;

public class DownloadFile_Test  extends BaseClass  {
	
	DownloadFile df;
	public DownloadFile_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		df=new DownloadFile();
		
	}
	@Test
	public void Download_TC() throws InterruptedException {
		df.downloadFile.click();
		Thread.sleep(5000);
		Assert.assertEquals(getDownloadedFile(df.downloadFile.getText()), "some-file.txt");
	}

	private String getDownloadedFile(String fileName) {
        File fileLocation = new File("C:\\Users\\rushi\\Downloads");
        File[] files = fileLocation.listFiles();

        for (File file: files) {
            if (file.getName().equals(fileName)) {
                return file.getName();
            }
        }
        return null;
    }
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}

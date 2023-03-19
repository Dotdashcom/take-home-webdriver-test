package test;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class FileDownload extends BaseClass {

	public FileDownload() {
		super();
	}
	  String fileName;
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("	#content > ul > li:nth-child(17) > a")).click();
	}
	
	@Test
	
	public void download() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		
		String downloadPath = getSystemDownloadPath();
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < 3; i++) {
          
			if (dirContents[i].getName().equalsIgnoreCase(fileName)) {
                break;
            }
			else {
                long timeWait = 30;
				Thread.sleep(timeWait);
            }
        }
        
        
	} 
	

	private String getSystemDownloadPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Test (dependsOnMethods = {"download"})
	
	public void verify() {
		Assert.assertEquals(fileName, "some-file.txt");
	}


	@AfterMethod
	
	public void close() {
		driver.quit();
	}
	
}

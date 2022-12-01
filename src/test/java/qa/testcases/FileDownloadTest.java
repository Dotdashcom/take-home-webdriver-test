package qa.testcases;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class FileDownloadTest extends TestBase{
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void fileDownloadTest() {
		
		driver.get(prop.getProperty("baseurl")+"/download");
		
		driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();
		boolean flag = isFileDownloaded("some-file");
		//System.out.println(flag);
		Assert.assertEquals(flag , true);
		
	}
	
	public static Boolean isFileDownloaded(String fileName) {
        
		boolean flag = false;
        String dirPath = "C:\\Users\\Sonal Patel\\Downloads"; 
       
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
            flag = false;
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                    System.out.println(fileName + " is present");
                    break;
                }
                flag = true;
            }
        }
        return flag;
    }
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
	

}

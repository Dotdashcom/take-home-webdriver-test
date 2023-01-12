package staffitsolution.qa.wlctointernet.test;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class FileDownloadTest extends BaseTest{
	String currentFile;
    static  String name;
    boolean result = false;
	
    @Test
	public void fileDownLoadTest() throws InterruptedException
	{
		driver.get(prop.getProperty("fileDownLoadurl"));
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[contains(@href,'download/some-file.txt')and text()='some-file.txt']")).click();
		
		boolean isFileAvailable = isFileDownloaded("some-file","txt");
		System.out.println(isFileAvailable);
	}
	
    @Test
    public boolean isFileDownloaded(String expectedFileName, String fileExtension)
    {
        // Download Folder Path
    	String folderName = "C:\\Users\\harsha\\Downloads";
        // Array to Store List of Files in Directory
        File[] listOfFiles;
    		
        // Store File Name
        String fileName;   
            
        //  Consider file is not downloaded
        boolean fileDownloaded = false;      
            
        // capture time before looking for files in directory
        // last modified time of previous files will always less than start time
        // this is basically to ignore previous downloaded files
        long startTime = Instant.now().toEpochMilli();
        listOfFiles = new File(folderName).listFiles();
                
            // iterate through each file
            for (File file : listOfFiles) 
            {
                fileName = file.getName().toLowerCase();
                
                if (fileName.contains(expectedFileName.toLowerCase()) 
                	&& fileName.contains(fileExtension.toLowerCase())) 
               {
                   // File Found
                   fileDownloaded = true;   
                  Assert.assertEquals(fileDownloaded, true);               
               }
            }
           
        return fileDownloaded;
    }
	
	

}

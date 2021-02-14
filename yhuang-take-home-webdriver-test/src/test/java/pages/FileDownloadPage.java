package pages;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BaseDriver{
	
	public FileDownloadPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(linkText="some-file.txt")
	public WebElement downloadLink;
	
	public boolean isFileDownloaded(String downloadPath) throws InterruptedException {
		downloadLink.click();
		Thread.sleep(5000);
		
		File dir = new File(downloadPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return false;
	    }
	    
	    for (int i = 0; i < files.length; i++) {
	    	if(files[i].getName().contains("some-file.txt")) {
	    		return true;
	    	}
	    }
	    return false;
	}
}

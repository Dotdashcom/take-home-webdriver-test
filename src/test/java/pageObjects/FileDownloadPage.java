package pageObjects;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FileDownloadPage extends BaseTemplate
{

	public FileDownloadPage(WebDriver driver) {
		super(driver);
	}
	
	public final By downloadLink = By.cssSelector("div[class='example'] a");
	
	public void downloadFile(String filename) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(downloadLink));
		List<WebElement>filenames = driver.findElements(downloadLink);
		for(WebElement w : filenames) {
			if(w.getText().equals(filename))
			{
				w.click();
			}
			
		}
		
	}
	
	public boolean isFileDownloaded(String path) {
		  File file = new File(path);
		 String[] flist = file.list();
		 if(flist==null)
		 {
			 return false; 
		 }
		 else {
			
			 for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                System.out.println(filename);
	                if (filename.equalsIgnoreCase("some-file.txt")) {
	                    return true;
	                }
			 		}	
		 		}
		 return false;
		}

}

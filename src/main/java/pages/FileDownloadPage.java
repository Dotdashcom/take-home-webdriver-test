/**
 * 
 */
package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class FileDownloadPage extends BasePage {

	public FileDownloadPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id='content']/div/a")
	WebElement download;
	
public void downloadFile() {
	driver.get(WebLink.file_DownloadPageUrl);
	download.click();
	
}

public boolean ifFileDownloaded(String filename) throws Exception{
	String downloadPath=System.getProperty("user.dir")+"\\downloadfiles\\";
	boolean flag = false;
    File dir = new File(downloadPath);
    File[] dir_contents = dir.listFiles();
  	    
    for (int i = 0; i < dir_contents.length; i++) {
        if (dir_contents[i].getName().equals(filename))
            return flag=true;
            }

    return flag;
}


	

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.FileUtils;

public class FileDownloadPage extends BaseClass {
	
	FileUtils fileUtils = new FileUtils();
	
	
	public FileDownloadPage(){
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//*[@id='content']/div/a")
 private WebElement fileLink;
 
 public boolean downloadFile() {
	 fileLink.click();
	
	 boolean downloadFlag = fileUtils.isFileDownload("some-file", "txt", 5000);
	 System.out.println("Download flag is: "+downloadFlag);
	 return downloadFlag;
 }
 
}

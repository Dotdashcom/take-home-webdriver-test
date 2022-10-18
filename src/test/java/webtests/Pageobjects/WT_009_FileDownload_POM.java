package webtests.Pageobjects;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_009_FileDownload_POM extends WT_BaseClass{

	//Locator
	@FindBy(xpath= "//a[contains(text(),'some-file.txt')]")
	WebElement Filelink;
	
    String path = "C:\\Users\\gotid\\Downloads";
    String FileName = "some-file.txt";
	
     //Constructor
	public WT_009_FileDownload_POM() {
		PageFactory.initElements(driver,this );		
	}
	
	public void FileLink() {
		Filelink.click();
	}
	
	public boolean verifyDownload() {
		
		return isFileDownloaded(path,FileName);
	}

	private boolean isFileDownloaded(String path, String fileName) {
	 
		boolean flag = false;
		
	    File dir = new File(path);
	    File[] contents = dir.listFiles();

	    for (int i = 0; i < contents.length; i++) {
	        if (contents[i].getName().contains(FileName))

	            return flag=true;
	            }

		return flag;
		
	
	}
	
	
}

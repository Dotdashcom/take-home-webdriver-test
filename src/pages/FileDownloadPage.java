package pages;
import java.io.File;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class FileDownloadPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'some-file.txt')]")
	WebElement link;
	private static String Path="C:\\Users\\bhavi\\Downloads";
	String FileName="some-file.txt";
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/download");
		
	}
	public void clickOnLink() {
		link.click();
	}
	public boolean verifyDownload() {
		return isFileDownloaded(Path,FileName);
	}
	
	private boolean isFileDownloaded(String Path, String FileName) {
		boolean flag = false;
	    File dir = new File(Path);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(FileName))
	        	
	            return flag=true;
	            }

		return flag;
	}
	public void closeBrowser() {
		driver.quit();
	}
}
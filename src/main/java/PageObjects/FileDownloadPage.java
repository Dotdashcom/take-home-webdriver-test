package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class FileDownloadPage extends BrowserUtilities {

	public FileDownloadPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'some-file.txt')]")
	WebElement downloadFileLink1;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'TestFile.txt')]")
	WebElement downloadFileLink2;
	
	public void getUrl() {
		driver.get(BaseTest.getURL("download"));
	}
	
	public void file_Download() {
		
		downloadFileLink2.click();
		
	}
	
}

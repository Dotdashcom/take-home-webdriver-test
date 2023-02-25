package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class FileDownloadPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public FileDownloadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//loactor for file
	@FindBy (linkText = "some-file.txt")
	WebElement lnkFile;
	
	//method to download
	public String fileDownload() {
		bu.clickOnElement(lnkFile, "File");
		String fileName = bu.getMessageText(lnkFile, "file");
		return fileName;
	}

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class FileUploadPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public FileUploadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locator for chooseFile
	@FindBy (xpath = "//input[@id='file-upload']")
	WebElement btnChoose;
	

	//locator for upload
	@FindBy (xpath = "//input[@id='file-submit']")
	WebElement btnSubmit;
	
	//locator for uploaded file
	@FindBy (xpath = "//div[@id='uploaded-files']")
	WebElement fileUploaded;
	
	
	
	//method to upload file
	public String uploadFile() {
		btnChoose.sendKeys("C:\\\\Users\\\\rarav\\\\eclipse-workspace\\\\Dotdashcom_shobanaAssessment\\\\some-file.txt");
		System.out.println("File is uploaded into the page");
		bu.clickOnElement(btnSubmit, "Upload button");
		//bu.waitForElement(driver, fileUploaded);
		String fileName = bu.getMessageText(fileUploaded, "File name");
		return fileName;
	}
	

}

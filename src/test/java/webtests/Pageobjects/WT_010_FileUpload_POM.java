package webtests.Pageobjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_010_FileUpload_POM extends WT_BaseClass {

	//Locators
	@FindBy (id="file-upload")
	WebElement choosefile;
	
	@FindBy (xpath= "//input[@id='file-submit']")
	WebElement Uploadbtn;
	
	@FindBy (xpath= "//div[@id='drag-drop-upload']")
	WebElement Dragdropoupload;
	
	@FindBy (xpath= "//h3[contains(text(),'File Uploaded!')]")
	WebElement Uploadedtxt;
	
	@FindBy (xpath= "//div[@id='uploaded-files']")
	WebElement Fileupload;
	
	//Constructor
	public WT_010_FileUpload_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public WebElement Uploadefile(String filepath) {
		
	    choosefile.sendKeys(filepath);
		return choosefile ;			
	}
	
	public void ClickUploadBtn() {
		Uploadbtn.click();	
	}
	
	public String verifyuploadedfile() {
		return Fileupload.getText();
	}
	
	public String Uploadedtext() {
		return Uploadedtxt.getText();
	}
		
}

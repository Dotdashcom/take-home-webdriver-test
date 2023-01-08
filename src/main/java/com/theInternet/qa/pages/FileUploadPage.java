package com.theInternet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FileUploadPage {
	
	WebDriver driver;
	
	@FindBy(css="input#file-upload")
	WebElement chooseFile; 
	
	@FindBy(id="file-submit")
	WebElement Upload;
	
	@FindBy(css="div.example")
	WebElement FileUpload_msg;
	
	public FileUploadPage(WebDriver driver)
	 {
		 this.driver = driver;
			PageFactory.initElements(driver, this);
	 }
	
	public void VerifyFileUpLoad()
	{
		chooseFile.sendKeys(System.getProperty("user.dir") + "/src/some-file.txt");
		Upload.click();
		Assert.assertEquals(FileUpload_msg.getText(), "File Uploaded!" + "\n" + "some-file.txt");
	}

}

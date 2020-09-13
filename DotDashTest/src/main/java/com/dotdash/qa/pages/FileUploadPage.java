package com.dotdash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class FileUploadPage extends TestBase {
	
	@FindBy(id="file-upload")
	WebElement chooseFile;
	
	@FindBy(xpath="//h3[contains(text(),'File Uploaded!')]")
	WebElement displayedText;
	
	@FindBy(xpath="//input[@id='file-submit']")
	WebElement submitBtn;
	
	public FileUploadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String uploadFileTest() {
		chooseFile.sendKeys("C:\\Users\\Administrator\\Downloads\\some-file.txt");
		submitBtn.click();
		return displayedText.getText();
	}

}

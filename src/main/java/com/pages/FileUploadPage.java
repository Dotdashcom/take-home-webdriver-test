package com.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class FileUploadPage extends Base {
	
	@FindBy(id="file-upload")
	WebElement browseBtn;
	
	@FindBy(id="file-submit")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='example']//h3")
	WebElement fileUploaded;
	
	public FileUploadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void uploadAfile() {
		String fileName="C:\\Users\\yasar\\eclipse-workspace\\DockerSeleniumProjectTest\\TestFile\\some-file(1).txt";
		File file=new File(fileName);
		String filePath=file.getAbsolutePath();
		browseBtn.sendKeys(filePath);
	}
	public void clickOnUploadBtn() {
		submitBtn.click();
	}
	
	public boolean fileUploadedMessage() {
		boolean flag=fileUploaded.isDisplayed();
		return flag;
	}

}

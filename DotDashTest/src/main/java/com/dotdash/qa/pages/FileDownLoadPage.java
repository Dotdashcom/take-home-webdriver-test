package com.dotdash.qa.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class FileDownLoadPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'some-file.txt')]")
	WebElement linkText;
	
	public FileDownLoadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean downloadFileTest(){
		linkText.click();
		File fileLocation = new File("C:\\Users\\Administrator\\Downloads");
		File[] totalFiles = fileLocation.listFiles();
		for(File fileName : totalFiles) {
			if(fileName.getName().equals("some-file.txt")) {
				return true;
			}
		}
		return false;
	}	

}

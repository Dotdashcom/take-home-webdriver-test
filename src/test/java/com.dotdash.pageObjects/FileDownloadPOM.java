package com.dotdash.pageObjects;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.testUtils.TestBase;

public class FileDownloadPOM extends TestBase {

	@FindBy(css="div.example>a")
	WebElement filename;

	public FileDownloadPOM() {
		PageFactory.initElements(driver,this);
	}
	public void userfileDownload() {
		filename.click();
	}
	
	public boolean userverifyfiledownload() {
		String fname=filename.getText();
		String FileLocation=System.getProperty("user.dir")+"\\Downloads\\"+fname;
		System.out.println(FileLocation);
		File f = new File(FileLocation);
		return f.exists();
	}
}

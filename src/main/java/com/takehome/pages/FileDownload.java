package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownload {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/a") WebElement fileLink;
	
	
	public FileDownload(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" +"download";
		driver.get(url);
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getFileLink()
	{
		return fileLink;
	}

}

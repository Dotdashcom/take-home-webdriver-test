package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

	public WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}

	public void Upload(String filePath){
		WebElement element;
		element = driver.findElement(By.id("file-upload"));
		element.sendKeys(filePath);
		element  = driver.findElement(By.xpath("//input[@id='file-submit']"));
		element.click();

	}
}


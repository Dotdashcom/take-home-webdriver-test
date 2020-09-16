package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage {
	public WebDriver driver;
	String Status;

	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}

	public void download(){
		WebElement element;
		element = driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]"));
		element.click();

	}

}

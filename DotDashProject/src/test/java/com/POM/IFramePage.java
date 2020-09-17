package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {
	public WebDriver driver;
	String status;

	public IFramePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}

	public void iFrame(){
		WebElement element;
		element = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		// element.click();
		driver.switchTo().frame(element);

	}
	public String Bodytext(){
		WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
		status = body.getText();
		return status;
	}

}

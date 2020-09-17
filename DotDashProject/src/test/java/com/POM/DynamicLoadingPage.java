package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {
	public WebDriver driver;
	String Status;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}

	public void dynamic(){

		WebElement element;
		element = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
		element.click();

		//element = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));
		//	element.getText();
	}

	public void loading () {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Start')]")));
	}

	/*public String getText() {
	    			return Status;
	    		}*/

}

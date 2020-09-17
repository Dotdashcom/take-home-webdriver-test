package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenu {
	public WebDriver driver;


	public FloatingMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}

	public void Menu(){
		WebElement element;
		element = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
		element.click();

		//the is to check even if i scroll down, does the menus still visible or not. 
		//So to perform scroll down i am using javaScrpt executer. 
		JavascriptExecutor js = ( JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // here i am scroll down all the way down		 

	}
}

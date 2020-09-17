package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTabPage {
	public WebDriver driver;
	WebElement we;
	String newTab;	



	public NewTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// paageObjectModel using selenium pagefactory

	}

	public void newTab() {

		String currentTab = driver.getCurrentUrl();

		System.out.println("Current tab:"+currentTab);//will print the current window name 

		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));

		we.click();// i am clicking the "click here option from the page"

		driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");// here i am moving to a new tab
		System.out.println("After switching titile is:"+ currentTab); //this won't print any page title, because new tab is blank

		driver.get("http://localhost:7080/windows/new");
		System.out.println("Current tab:"+ newTab);//this will print the current tab


	}

	public String newtab(){
		return newTab;
	}
}

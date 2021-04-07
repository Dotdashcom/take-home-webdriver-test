package com.theInternetApp.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.theInternetApp.qa.Utilities.BaseClass;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class HoversPage extends BaseClass{

	// The following Initialization of the Page factory
		public HoversPage(WebDriver driver) {

			PageFactory.initElements(driver, this);
		}

		// The following are Declaration the web elements

		@FindBy(xpath = "//a[contains(text(),'Hovers')]")
		@CacheLookup
		WebElement HoverLink;
		
		@FindBy(xpath = "//div[@class='figure']")
		@CacheLookup
		List<WebElement> ListOfUsers;


		// The following are the Utilizations by creating methods for each of the
		// components.

		// get URL
		public void getUrl() {
			driver.get(Base_URL);
			HoverLink.click();
		}
		
		// get list of users
		public void getListOfUsers() {
			for (int i = 0; i < ListOfUsers.size(); i++) {
				Actions action = new Actions(driver);
				action.moveToElement(ListOfUsers.get(i)).perform();
				
				WebElement UserName = ListOfUsers.get(i).findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
				Assert.assertTrue(UserName.isDisplayed());
			}
		}
			

}

package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	  WebDriver driver;

	    By homePageUserName = By.xpath("//*[@id=\"content\"]/div/h2");

	    

	    public HomePage(WebDriver driver){

	        this.driver = driver;

	    }

	    //Get the User name from Home Page

	        public String getHomePageDashboardUserName(){

	         return  driver.findElement(homePageUserName).getText();

	        }

	}


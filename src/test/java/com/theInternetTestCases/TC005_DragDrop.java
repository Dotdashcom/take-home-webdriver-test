package com.theInternetTestCases;

import org.testng.annotations.Test;

import com.theInternetPages.LoginPage;
import com.theInternetUtilities.ConfigProvider;
import com.theInternetUtilities.DriverScript;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC005_DragDrop extends DriverScript {

	/*This approach is not working for this drag and drop*/
	
	@Test(priority = 1)
	public void login() throws InterruptedException {

		getDriver().get(ConfigProvider.getConfigProp("DragDropURL"));

		getPageObject().getDragDropPage().isDisplayedPage();

	}

	@Test(priority = 2)
	public void dragDrop() throws InterruptedException

	{
		getPageObject().getDragDropPage().dragDrop();

	}

	@BeforeTest

	public void setUp() {
		try {
			launchBrowser();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to Launch the browser");
		}

	}

	@AfterTest
	public void afterTest() {
		getDriver().close();
		getDriver().quit();
	}

}

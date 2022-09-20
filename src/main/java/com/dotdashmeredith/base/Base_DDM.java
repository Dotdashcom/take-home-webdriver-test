package com.dotdashmeredith.base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;


public class Base_DDM {

	protected WebDriver driver;

	public Base_DDM(WebDriver driver) {
		this.driver = driver;
	}

	public void reporter(String log) {
		Reporter.log(log);
	}

	public WebDriver chromeDriver() {
		System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		return driver;
	}

	public void implicitlyWait() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.GENERAL_IMPLICITLY_TIMEOUT));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public void launchBrowser(String url) {
		reporter("Launching Browser..." + url);
		driver.get(url);
		driver.manage().window().maximize();
		implicitlyWait();
	}

	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void sendKeys(By locator, String input) {
		try {
			driver.findElement(locator).sendKeys(input);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void textAssert(String input1, String input2) {
		Assert.assertEquals(input1, input2);
	}	
	
}
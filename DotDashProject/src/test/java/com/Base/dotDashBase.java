package com.Base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dotDashBase {

	public static WebDriver driver;

	@BeforeTest
	//@Parameters("setup")

	public static WebDriver setupDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//return driver;
		return driver;


	}

	/*
	@AfterTest
	public void quit() {
		driver.quit();

	}*/
}



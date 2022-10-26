package com.TakeHomeTest.testCases;

import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.TakeHomeTest.utilities.ReadConfig;


public class BaseClass {

	public static WebDriver driver;
	static ReadConfig readconfig=new ReadConfig();
	public static  String url= readconfig.getApplicationURL();


	@BeforeSuite
	public void setup()
	{

			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
	}
@AfterSuite
public void tearDown()
 {
	// driver.quit();
 }
}

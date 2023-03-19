package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pom.PomLogin;
import data.Excel;

public class LoginTest {
	
	WebDriver driver;
	PomLogin login;
	SoftAssert success;

	
	public LoginTest() {
		super();	
	}
	
	@BeforeSuite
	
	public void maximize() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Service 1\\eclipse-workspace\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod		
	
	public void openUrl() {
		driver.get("http://localhost:7080/login");
	}
	
	@DataProvider
	public Object[][] Details(){
		Object result [][] = Excel.read("Sheet1");
		return result;
	}
	
	@Test (dataProvider = "Details", priority = 1)
	
	public void login(String name, String password) {
		login.typeusername(name);
		login.password(password);	
		login.submit();
	}
	
	@Test (priority = 2)
	
	public void alert() {
		String alert = login.verify();
		
		success.assertEquals(alert, "You logged into a secure area!");
		System.out.println(alert);
		
	}
	
	@AfterSuite
	
	public void close() {
		driver.quit();
	}

}

package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.FileDownloadPage;
import basePack.BaseClass;

public class FloatingMenuTestcase extends BaseClass{

	public FloatingMenuTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@BeforeMethod
	@Parameters("floatingMenu")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
	
	}
		
	@Test
	public void toTestFloatingMenu()
	{
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Boolean menu = driver.findElement(By.id("menu")).isDisplayed();
			Assert.assertTrue(menu);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}

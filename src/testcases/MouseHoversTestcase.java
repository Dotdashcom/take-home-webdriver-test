package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.Pages.MouseHoversPage;
import basePack.BaseClass;

public class MouseHoversTestcase extends BaseClass{

	public MouseHoversTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	MouseHoversPage mousehoverpgae;
	
	
	@BeforeMethod
	@Parameters("mousehovers")
	public void initializationMethod(String endpoint) throws IOException, InterruptedException
	{
		toIntialize(endpoint);
		mousehoverpgae=new MouseHoversPage(driver);
		
	}
	
	
	@Test
	public void mouseHover() throws InterruptedException
	{
		
		mousehoverpgae.mouseHovers();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}

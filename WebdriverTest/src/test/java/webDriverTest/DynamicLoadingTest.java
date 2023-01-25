package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.PomDynamicLoading;

public class DynamicLoadingTest extends BaseClass {
	PomDynamicLoading load;
	
	public DynamicLoadingTest() {
		super();
	}
	
	@BeforeMethod
	
	 public void initsetup() {
		
		 initiation();
	
		
		load = new PomDynamicLoading(); 
		
		driver.get("http://localhost:7080/dynamic_loading/2");	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	
	@Test
	
	public void verifyDaynamicloadingTest() throws InterruptedException {
		
	String endmessage=	load.clickonstartbutton();
	
	Assert.assertEquals(endmessage, "Hello World!");
		
	}
	 
	 @AfterMethod
    
		public void teardown() {
  		
  		driver.quit();
  	}
  	
	 
	
	

}

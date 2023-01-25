package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import basePackage.BaseClass;
import pomPackage.PomDynamicContent;

public class DyanamicContentTest extends BaseClass {
	PomDynamicContent dynamictext;
	
	
	public DyanamicContentTest() {
		
		super();
		
	}
	
	 @BeforeMethod
		
	   public void initsetup() {
		
		 initiation();
	
		
		dynamictext = new PomDynamicContent(); 
		
		driver.get("http://localhost:7080/dynamic_content");	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	 @Test
	 
	 public void varifyDynamictextTest() throws InterruptedException {
		 String dyanamictext1= dynamictext.dyanamictextcheck();
		 String dyanamictext2 =dynamictext.dynamictextafterrefresh();
		 
		 System.out.println(dyanamictext1);
		 System.out.println(dyanamictext2);
		 
		 Assert.assertNotSame(dyanamictext1, dyanamictext2, "Test case pass because text not matching");
		 
		 
		 
	 }
	 
	 
	 @AfterMethod
     
		public void teardown() {
		
		driver.quit();
	}
	
	 
	

}

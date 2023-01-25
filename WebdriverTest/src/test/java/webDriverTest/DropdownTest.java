package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import basePackage.BaseClass;
import pomPackage.PomContextMenu;
import pomPackage.PomDropDown;

public class DropdownTest extends BaseClass {
	
	 PomDropDown dropselect;
	public DropdownTest() {
		
		super();
		
	}
	 @BeforeMethod
		
	   public void initsetup() {
		
		 initiation();
	
		
		dropselect = new PomDropDown(); 
		
		driver.get("http://localhost:7080/dropdown");	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	 
	 @Test
	 
	 public void varifydropdownTest() throws InterruptedException {
		 
		 dropselect.selectdropdown();
		 
	String op1= dropselect.option1displayed();
	Assert.assertEquals(op1, "Option 2", "Option 2 displayed");
	
	 }
	 
	 
	 @AfterMethod
     
		public void teardown() {
   		
   		driver.quit();
   	}
   	
	 
}

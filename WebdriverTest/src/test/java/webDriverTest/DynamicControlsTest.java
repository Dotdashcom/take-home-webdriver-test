package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import basePackage.BaseClass;
import pomPackage.PomDropDown;
import pomPackage.PomDynamicControls;

public class DynamicControlsTest extends BaseClass{
	
	PomDynamicControls control;
	
	public DynamicControlsTest() {
		
		super();
		
	}
	
	 @BeforeMethod
		
	   public void initsetup() {
		
		 initiation();
	
		
		control = new PomDynamicControls(); 
		
		driver.get("http://localhost:7080/dynamic_controls");	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	 
	 @Test(priority =1)
	 
	 public void varifycheckboxtest() {
		 
		 String messageafterclick =control.varifycheckbox();
		 control.takeScreenshot("DynamicControls");
		 
		 Assert.assertEquals(messageafterclick, "It's gone!");
		 
	 }
	 
	 @Test(priority =2)
	 
	 public void varifyenablebuttonTest() {
		 
		 String messageenablebox =control.varifyenableButton();
		 
		 control.takeScreenshot("messageenablebox");
		 
		 Assert.assertEquals(messageenablebox, "It's enabled!");
	 }
	
 @Test(priority =3)
	 
	 public void varifydisablebuttonTest() {
		 
		 String messagedisablebox =control.varifydisableButton();
		 
		 control.takeScreenshot("messagedisablebox");
		 
		 Assert.assertEquals(messagedisablebox, "It's disabled!");
	 }
	 @AfterMethod
     
		public void teardown() {
		
		driver.quit();
	}
	

}

package webDriverTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import basePackage.BaseClass;
import pomPackage.PomCheckbox;

public class CheckboxTest extends BaseClass{
	
	PomCheckbox checking;
	
	public CheckboxTest() {
		super();
		
	}
	
	@BeforeMethod
	
		public void initsetup() {
		
		initiation();
		
		checking = new PomCheckbox();
		driver.get("http://localhost:7080/checkboxes");	
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	
	public void Testchechboxes() throws InterruptedException {
		
		checking.checkbothbox();
		
		checking.takeScreenshot("checkbox");
		
		
		boolean check1= checking.varifycheckbox1();
		
		Assert.assertTrue(check1, "checkbox 1 is checked");
		
		boolean check2 = checking.varifycheckbox2();
		
		Assert.assertTrue(check2, "checkbox 2 is cheched");
		
		checking.uncheckbothbox();
		
		checking.takeScreenshot("uncheckbothbox");
		
		boolean check3= checking.varifycheckbox1();
		
		Assert.assertTrue(check3, "checkbox 1 is checked");
		
		boolean check4 = checking.varifycheckbox2();
		
		Assert.assertTrue(check4, "checkbox 2 is cheched");
		
	}
	
	@AfterMethod
   	
   	public void teardown() {
   		
   		driver.quit();
   	}
	
	
}

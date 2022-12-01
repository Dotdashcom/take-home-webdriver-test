package qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class CheckboxTest extends TestBase {
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test  
    public void checkboxSelectionTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/checkboxes");
		Thread.sleep(1000);
		boolean checkbox_1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected();
		System.out.println("checkbox 1 is selected? : "+ checkbox_1);
		Assert.assertEquals(checkbox_1, false);
	
		boolean checkbox_2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected();
		System.out.println("checkbox 2 is selected? : "+ checkbox_2);
		Assert.assertEquals(checkbox_2, true);
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}

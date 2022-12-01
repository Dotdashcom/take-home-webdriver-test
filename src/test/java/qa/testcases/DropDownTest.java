package qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class DropDownTest extends TestBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void dropDownTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/dropdown");
		
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select s = new Select(dropdown);
		
		System.out.println("Select Option 1");
		s.selectByValue("1");
		System.out.println("Option 1 is selected : " + s.getFirstSelectedOption().isSelected());
		Assert.assertEquals(s.getFirstSelectedOption().isSelected(), true);

		Thread.sleep(1000);
		System.out.println("Select Option 2");
		s.selectByVisibleText("Option 2");
		System.out.println("Option 2 is selected : " + s.getFirstSelectedOption().isSelected());

		Assert.assertEquals(s.getFirstSelectedOption().isSelected(), true);
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}

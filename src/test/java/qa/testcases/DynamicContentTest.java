package qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class DynamicContentTest extends TestBase{

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void dynamicContentTest() throws InterruptedException  {
		
		driver.get(prop.getProperty("baseurl")+"/dynamic_content");
		
		String oldContent = driver.findElement(By.xpath("//div[@class='row'][1]/div[2]")).getText();
		Thread.sleep(500);
		driver.navigate().refresh();
		driver.navigate().refresh();

		String newContent = driver.findElement(By.xpath("//div[@class='row'][1]/div[2]")).getText();
		
		if(oldContent.equals(newContent)) 
			System.out.println("Dynamic content Test Fail");
		else
			System.out.println("Dynamic content Test Pass");

		Assert.assertNotEquals(oldContent, newContent);
		
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}

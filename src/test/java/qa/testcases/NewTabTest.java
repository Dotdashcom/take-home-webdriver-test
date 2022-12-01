package qa.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class NewTabTest extends TestBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void newTabTest() throws InterruptedException  {
		
		driver.get(prop.getProperty("baseurl")+"/windows");
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size());
		
		Iterator<String> iter = allwindows.iterator();
		String mainwindow = iter.next();
		String childwindow = iter.next();
		
		System.out.println(mainwindow);
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		Thread.sleep(1000);
		String childwindow_text = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		Assert.assertEquals(childwindow_text, "New Window");
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}

}

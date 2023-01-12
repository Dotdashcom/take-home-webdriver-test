package staffitsolution.qa.wlctointernet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class FloatingMenuTest extends BaseTest{

	@Test
	public void floatingMenuTest() throws InterruptedException 
	{
		driver.get(prop.getProperty("floatingMenuurl"));
		Thread.sleep(2000);
		By menu= By.xpath("//div[@id='menu']");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		 js.executeScript("window.scrollBy(0,1000)");
		 
		 boolean flag=driver.findElement(menu).isDisplayed();
		 Assert.assertTrue(flag);
	}
}

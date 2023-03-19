package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class NewTab extends BaseClass {

	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(33) > a")).click();
	}
	
	
	@Test
	
	public void newTab() throws InterruptedException {
		driver.findElement(By.cssSelector("#content > div > a")).click();
		Thread.sleep(3000);
		 String mainWindow = driver.getWindowHandle();
		Set<String> browserTabs = driver.getWindowHandles();
		for (String windowHandle : browserTabs) {
			if (!windowHandle.equals(mainWindow)){
				driver.switchTo().window(windowHandle);
			}
		}
		String body =driver.getTitle();
		
		Assert.assertEquals(body, "New Window");
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}
}

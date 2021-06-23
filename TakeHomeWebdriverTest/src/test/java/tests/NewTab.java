package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class NewTab extends TestBase {
	@BeforeTest
	public void beforeNewTabTest() {
		setup();
		driver.get("http://localhost:7080/windows");
	}

	@AfterTest
	public void afterNewTabTest() {
		teardown();
	}
	
	@Test
	public void newTabTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		driver.switchTo().window(it.next()); //Switches to parent/original tab
		System.out.println("Parent/Original Tab Handle: "+driver.getWindowHandle());
		driver.switchTo().window(it.next()); //Switches to child/new tab
		System.out.println("Child/New Tab Handle: "+driver.getWindowHandle());
		String newWindowTxt = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		Assert.assertEquals(newWindowTxt, "New Window");
	}

}

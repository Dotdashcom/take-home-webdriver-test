package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class DynamicContent extends TestBase {
	
	@BeforeTest
	public void beforeDynamicContentTest() {
		setup();
		driver.get("http://localhost:7080/dynamic_content");
	}

	@AfterTest
	public void afterDynamicContentTest() {
		teardown();
	}
	
	@Test
	public void dynamicContentTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'Dynamic Content')]")).click();
		for (int i = 0; i < 3; i++) {
			  String old1stTxtBlock = driver.findElement(By.xpath("//div[@id='content']")).getText();
			  driver.navigate().refresh();
			  String new1stTxtBlock = driver.findElement(By.xpath("//div[@id='content']")).getText();
			  Assert.assertNotEquals(old1stTxtBlock, new1stTxtBlock);
			}
		}

}

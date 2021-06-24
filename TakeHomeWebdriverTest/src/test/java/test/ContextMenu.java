package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class ContextMenu extends TestBase {
	
	@BeforeTest
	public void BeforeContextMenuTest() {
		setup();
		driver.get("http://localhost:7080/context_menu");
	}
	
	@AfterTest
	public void afterContextMenuTest() {
		teardown();
	}
	
	@Test
	public void contextMenuTest()  {
		//WebElement contextMenuOption = driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]"));
		//contextMenuOption.click();
		Actions action = new Actions(driver);
		WebElement contextMenu = driver.findElement(By.id("hot-spot"));
		action.contextClick(contextMenu).build().perform();
		Alert alert = driver .switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "You selected a context menu");
	}

}

package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class MouseHover extends TestBase {
	@BeforeTest
	public void beforeMouseOverTest() {
		setup();
		driver.get("http://localhost:7080/hovers");
	}

	@AfterTest
	public void afterMouseOverTest() {
		teardown();
	}
	
	@Test
	public void mouseOverTest() {
	//driver.findElement(By.xpath("//a[contains(text(),'Hovers')]")).click();
	Actions act = new Actions(driver);
	WebElement img1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
	WebElement img2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]"));
	WebElement img3 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]"));
	act.moveToElement(img1).build().perform();
	String user1Txt = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).getText();
	Assert.assertEquals(user1Txt, "name: user1");
	act.moveToElement(img2).build().perform();
	String user2Txt = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).getText();
	Assert.assertEquals(user2Txt, "name: user2");
	act.moveToElement(img3).build().perform();
	String user3Txt = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).getText();
	Assert.assertEquals(user3Txt, "name: user3");
	}
	
}

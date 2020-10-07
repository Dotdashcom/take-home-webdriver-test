package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class iframeTest  extends base {

	@Test()
	public void iframeTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/iframe");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		
		WebElement iframe, editor_body;
		
		iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
		//switching driver focus to frame
		driver.switchTo().frame(iframe);
		
		editor_body = driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]"));
		//sending text to frame
		editor_body.sendKeys("Check text");
		String expectedText = "Your content goes here.Check text";
		//checking if text is displayed as expected or not
		Assert.assertEquals(editor_body.getText(), expectedText);
		
	}

}
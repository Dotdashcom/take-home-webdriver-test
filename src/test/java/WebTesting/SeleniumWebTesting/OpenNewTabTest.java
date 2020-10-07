package WebTesting.SeleniumWebTesting;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class OpenNewTabTest extends base {

	@Test()
	public void OpenNewTabTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/windows");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement newWindow;
		WebElement clickHere= driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		//click here element clicking
		clickHere.click();
		//getting all tabs into array list
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		//switching to new tab
	    driver.switchTo().window(tabs2.get(1));
		newWindow = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/h3[1]"));
		//checking if the driver focus is changed to new tab
		Assert.assertEquals(driver.getTitle(), "New Window");
		Assert.assertEquals(newWindow.getText(), "New Window");
	    driver.close();
	    //switching to back to first tab
	    driver.switchTo().window(tabs2.get(0));
	}

}

package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class DropdownTest extends base {

	@Test()
	public void DropdownTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/dropdown");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		//Saving dropdown in a variable
		Select dropdown = new Select(dropDown);
		//selecting first indexed item from drop down
		dropdown.selectByIndex(1);
		String selected = dropdown.getFirstSelectedOption().getText();
		//Asserting if the correct item is being selected
		Assert.assertEquals(selected, "Option 1");
		//selecting second indexed item from drop down
		dropdown.selectByIndex(2);
		selected = dropdown.getFirstSelectedOption().getText();
		//Asserting if the correct item is being selected
		Assert.assertEquals(selected, "Option 2");
		
	}

}

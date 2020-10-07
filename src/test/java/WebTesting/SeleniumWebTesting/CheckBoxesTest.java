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

public class CheckBoxesTest extends base {
	
	
	@Test()
	public void CheckBoxesTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/checkboxes");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//Saving check boxes in variables
		WebElement checkBox1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]"));
		WebElement checkBox2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
		//Asserting when landed on page the check boxes are as expected or not
		Assert.assertFalse(checkBox1.isSelected());
		Assert.assertTrue(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected());
		Assert.assertTrue(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox2.click();
		Assert.assertTrue(checkBox1.isSelected());
		Assert.assertFalse(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox1.click();
		Assert.assertFalse(checkBox1.isSelected());
		Assert.assertFalse(checkBox2.isSelected());
		//clicking the checkbox and asserting if it is as expected
		checkBox2.click();
		Assert.assertFalse(checkBox1.isSelected());
		Assert.assertTrue(checkBox2.isSelected());
		
	}
	
	
}

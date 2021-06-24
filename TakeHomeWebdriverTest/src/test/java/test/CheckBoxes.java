package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class CheckBoxes extends TestBase {
	
	@BeforeTest
	public void beforeCheckBoxesTests() {
		setup();
		driver.get("http://localhost:7080/checkboxes");
	}
	
	@AfterTest
	public void afterCheckBoxesTests() {
		teardown();
	}
	
	@Test
	public void checkBox1Test() {
		//driver.findElement(By.xpath("//a[contains(text(),'Checkboxes')]")).click();
		WebElement checkbox1 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]"));
		checkbox1.click(); //checkbox 1 "checked" click
		Assert.assertEquals(true, checkbox1.isSelected());
		checkbox1.click(); // checkbox 1 "unchecked click;
		Assert.assertEquals(false, checkbox1.isSelected());
	}
	
	@Test
	public void checkBox2Test() {
		WebElement checkbox2 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
		checkbox2.click(); //checkbox 2 "unchecked" click
		Assert.assertEquals(false, checkbox2.isSelected());
		checkbox2.click(); // checkbox 2 "checked click;
		Assert.assertEquals(true, checkbox2.isSelected());
}
}

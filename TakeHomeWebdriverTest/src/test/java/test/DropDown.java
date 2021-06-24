package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class DropDown extends TestBase {
	
	@BeforeTest
	public void beforeDropDownTest() {
		setup();
		driver.get("http://localhost:7080/dropdown");
	}

	@AfterTest
	public void afterDropDownTest() {
		teardown();
	}
	
	@Test(priority = 1)
	public void option2Test() {
	//driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]")).click();
	WebElement selectOption = driver.findElement(By.id("dropdown"));
	Select select = new Select(selectOption);
	select.selectByVisibleText("Option 2");
	String SelectedOptionText = select.getFirstSelectedOption().getText();
	Assert.assertEquals(SelectedOptionText, "Option 2");
	
	
	}
	
	@Test(priority = 2)
	public void option1Test() {
	WebElement selectOption = driver.findElement(By.id("dropdown"));
	Select select = new Select(selectOption);
	select.selectByVisibleText("Option 1");
	String SelectedOptionText = select.getFirstSelectedOption().getText();
	select.selectByVisibleText("Option 1");
	Assert.assertEquals(SelectedOptionText, "Option 1");
	}
}
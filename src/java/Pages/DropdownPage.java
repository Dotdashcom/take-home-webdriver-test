package java.Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DropdownPage {

	
	WebDriver driver;
	
	public DropdownPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='dropdown']")
	WebElement dropdown;
	
	
	
	public void selectOptionsfromDropdown()
	{
		  Select s=new Select(dropdown);
		  
		  s.selectByVisibleText("Option 1");
		String selectedOption =  s.getFirstSelectedOption().getText();
		System.out.println(selectedOption);
		  Assert.assertEquals(selectedOption, "Option 1");
		  
		// s.deselectByVisibleText(selectedOption);
		  
		  s.selectByVisibleText("Option 2");
		  String selectedOption2 =  s.getFirstSelectedOption().getText();
		  Assert.assertEquals(selectedOption2, "Option 2");
		  System.out.println(selectedOption2);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

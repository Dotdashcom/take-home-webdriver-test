package Doctest;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CheckBoxPage;
import PageObjects.ContextPage;
import PageObjects.DragDropPage;
import PageObjects.Dropdown;
import PageObjects.LoginPage;
import resources.BaseDr;

public class LoginTest extends BaseDr {
	
	
	
public  WebDriver driver;

@BeforeTest

	public void initialize() throws IOException
	{
	driver = intializeDriver();
		

	}

	@Test ( priority = 1 )
	
	public void loginPassTest() throws IOException
	{
		
		driver.get(prop.getProperty("loginurl"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.getLogin().click();
		
		
	}
	
	@Test ( priority = 2 )
	
	public void loginFailTest() throws IOException
	{
		driver.get(prop.getProperty("loginurl"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(prop.getProperty("username"));
		lp.getLogin().click();
	}
	 
	@Test ( priority = 3 )
	
	 public void checkboxTest() 
	 {
		driver.get(prop.getProperty("checkboxesurl"));
		
		CheckBoxPage ch = new CheckBoxPage(driver);
		ch.getCheckBox().click();
		
		if (ch.getCheckBox2().isSelected())
		{
			ch.getCheckBox2().click();
		}
		
		}
	
@Test (priority = 4)
	
	public void dragAndDrop()
	{
		driver.get(prop.getProperty("dragdropurl"));
		
		DragDropPage dp = new DragDropPage(driver);
		
		Actions a1 = new Actions(driver);
		a1.dragAndDrop(dp.getSourceLocator(), dp.getDestinationLocator()).perform();
				
		
	} 

	
	
	@Test (priority = 5 )
	public void dropDown()
	{
		driver.get(prop.getProperty("dropdown"));
		Dropdown dd = new Dropdown(driver);
		
		dd.getDropDownLocator().click();
		Select s = new Select(dd.getDropDownLocator());
		
		s.selectByVisibleText("Option 1");
	}
	

	
	@Test ( priority = 6 )
	
	public void contextCheck()
	{
		driver.get(prop.getProperty("contexturl"));
		ContextPage cp = new ContextPage(driver);
		Actions a = new Actions(driver);
		a.contextClick(cp.getContext()).perform();
		
				
	}

	 
}

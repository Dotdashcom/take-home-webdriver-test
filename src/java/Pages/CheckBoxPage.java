package java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckBoxPage {

	WebDriver driver;
	public CheckBoxPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath = "//form//input[1]")
	WebElement checkbox1;
	
	@FindBy(xpath = "//form//input[2]")
	WebElement checkbox2;
	
	
	
	public void toCheck()
	{
		
		if(!checkbox1.isSelected())
		{
		checkbox1.click();
		}
		else
		{
		checkbox2.click();
		}
	
		if(!checkbox2.isSelected())
		{
			Assert.assertTrue(checkbox2.isSelected(),"checkbox 1 is selcted");
		}
		else
		{
			checkbox2.click();
			Assert.assertTrue(!checkbox2.isSelected(),"checkbox 2 is selected");
		}
		
		
	}
	
	
	
	
	
	
	
	
}

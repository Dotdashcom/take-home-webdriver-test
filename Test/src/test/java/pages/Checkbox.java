package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Checkbox {
	
	WebDriver driver;

	//constructor
	public Checkbox(WebDriver d)
	{
		driver = d;
		

		PageFactory.initElements(d, this);
	}
	
	
	
	@FindBy(xpath="//*[@id=\"checkboxes\"]/input[2]")
	WebElement checkbox2;

	@FindBy(xpath= "//input[@type='checkbox']/parent::form")
	List<WebElement> checkboxess;
	
	
	
	
	public void SelectCheckbox2()
	{
		
		checkbox2.click();
	}
	
	public List<WebElement> getWebElement()
    {
        return checkboxess;
    }
	
	public int GetCheckboxesize() 
	
	{
		
		 int si = checkboxess.size();
		 return si;
		 
		
	 }
		 	
		        
	}



		
	
	


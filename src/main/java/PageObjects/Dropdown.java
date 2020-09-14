package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown {
	
	
	public WebDriver driver;
	By dropdownlocator = By.xpath("//*[@id=\'dropdown\']");
	By selectdrop = By.xpath("//*[@id=\'dropdown\']/option[2]");
	
	
	 public Dropdown (WebDriver driver) {
			// TODO Auto-generated constructor stub
			
			this.driver=driver;
			
		}
	    
	
	public  WebElement getDropDownLocator()
	{
		return driver.findElement(dropdownlocator);
	}
	
	public WebElement getSelectdrop()
	{
		return driver.findElement(selectdrop);
	}
	
	
	

}

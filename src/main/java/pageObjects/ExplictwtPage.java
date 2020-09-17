package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExplictwtPage {
	public WebDriver driver;
	
	By removeBtnLocator = By.xpath("//*[@id=\'checkbox-example\']/button"); 
	By checkboxLocator = By.xpath("//*[@id=\'checkbox\']/input"); ////*[@id="checkbox"]/input
	By addButtonLocator = By.xpath("//*[@id=\'checkbox-example\']/button");
	By enableBtnLocator = By.xpath("//*[@id=\'input-example\']/button");
	By disableBtnLocator = By.xpath("//*[@id=\'input-example\']/button");
	
	public  ExplictwtPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public WebElement getRemoveBtnLocator()
	{
		return driver.findElement(removeBtnLocator);
	}
	public WebElement getCheckboxLocator()
	{
		return driver.findElement(checkboxLocator);
	}
	
	public WebElement getEnableLocator()
	{
		return driver.findElement(enableBtnLocator);
	}
	public By getAddButtonLocator()
	{
		return addButtonLocator;
	}
	public By getdisableBtnLocator()
	{
		return disableBtnLocator; 
	}
	
	

}

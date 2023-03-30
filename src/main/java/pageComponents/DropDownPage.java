package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage
{
	WebDriver driver;
	public DropDownPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By dropDownMenu = By.id("dropdown");
	
	public void selectOptionOne()
	{
		Select option = new Select(driver.findElement(dropDownMenu));
		option.selectByValue("1");
	}
	public void selectOptionTwo()
	{
		Select option = new Select(driver.findElement(dropDownMenu));
		option.selectByValue("2");
	}
	
	public String getSelectedValue()
	{
		Select select = new Select(driver.findElement(dropDownMenu));
		return select.getFirstSelectedOption().getText();
	}
	
}

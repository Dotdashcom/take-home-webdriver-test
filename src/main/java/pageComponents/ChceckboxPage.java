package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChceckboxPage
{
	WebDriver driver;
	public ChceckboxPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By firstCheckboxElement = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
	By secondCheckboxElement = By.xpath("//*[@id=\"checkboxes\"]/input[2]");
	
	public void setFirstCheckbox()
	{
		driver.findElement(firstCheckboxElement).click();
	}
	
	public void setSecondCheckbox()
	{
		driver.findElement(secondCheckboxElement).click();
	}
	
	public boolean getFirstCheckbox()
	{
		return driver.findElement(firstCheckboxElement).isSelected();
	}
	
	public boolean getSecondCheckbox()
	{
		return driver.findElement(secondCheckboxElement).isSelected();
	}
}

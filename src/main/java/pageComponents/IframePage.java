package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage
{	
	WebDriver driver;
	public IframePage(WebDriver driver)
	{
		this.driver = driver;
	}
	By tinyMceEditor = By.id("tinymce");
	
	public void clickOnMceEditor()
	{
		driver.findElement(tinyMceEditor).click();
	}
	
	public void inputText(String text)
	{
		driver.findElement(tinyMceEditor).clear();
		driver.findElement(tinyMceEditor).sendKeys(text);
	}
	public String getValueFromEditor()
	{
		return driver.findElement(tinyMceEditor).getText();
	}
}

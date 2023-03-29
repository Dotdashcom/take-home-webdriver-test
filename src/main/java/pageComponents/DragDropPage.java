package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragDropPage
{
	WebDriver driver;
	public DragDropPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By columnAElement = By.id("column-a");
	By columnBElement = By.id("column-b");
	By columnAHeader = By.xpath("//*[@id=\"column-a\"]/header");
	By columnBHeader = By.xpath("//*[@id=\"column-b\"]/header");
	public WebElement getColumnA()
	{
		return driver.findElement(columnAElement);
	}
	public WebElement getColumnB()
	{
		return driver.findElement(columnBElement);
	}
	
	public String getColumnAHeader()
	{
		return driver.findElement(columnAHeader).getText();
	}
	public String getColumnBHeader()
	{
		return driver.findElement(columnBHeader).getText();
	}
}

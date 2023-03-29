package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicControlPage
{
	WebDriver driver;
	public DynamicControlPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By checkBoxElement = By.xpath("//*[@id=\"checkbox\"]/input");
	By removeButtonElement = By.xpath("//button[contains(text(),'Remove')]");
	By addButtonElement = By.xpath("//button[contains(text(),'Add')]");
	By messageElement = By.id("message");
	By textBoxElement = By.xpath("//*[@id=\"input-example\"]/input");
	By enableButtonElement = By.xpath("//button[contains(text(),'Enable')]");
	By disableButtonElement = By.xpath("//button[contains(text(),'Disable')]");
	public void clickRemoveButton()
	{
		driver.findElement(removeButtonElement).click();
	}
	public void clickAddButton()
	{
		driver.findElement(addButtonElement).click();
	}
	public void clickEnableButton()
	{
		driver.findElement(enableButtonElement).click();
	}
	public void clickDisableButton()
	{
		driver.findElement(disableButtonElement).click();
	}
	public String getMessage()
	{
		return driver.findElement(messageElement).getText();
	}
	public WebElement getMessageElement()
	{
		return driver.findElement(messageElement);
	}
	
	public By getByMessageElement()
	{
		return messageElement;
	}
	public boolean isTextBoxEnabled()
	{
		return driver.findElement(textBoxElement).isEnabled();
	}
}

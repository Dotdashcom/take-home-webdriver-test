package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class loginPage 
{
	Baseclass bs;
	private final By textbox_username = By.id("username");
	private final By textbox_password = By.id("password");
	private final By button_submit = By.xpath("//button[@type = 'submit']");
	private final By button_logout = By.xpath("//a[@href = '/logout']");
	private final By text_ErrorMessage = By.xpath("//div[@id = 'flash']");
	private final By text_ErrorMessage_Close = By.xpath("//div[@id = 'flash']/a");
	public loginPage(Baseclass bs)
	{
		this.bs = bs;
	}
	
	public void loginToApplication(String username, String password)
	{
		bs.sendKeys(textbox_username,username);
		bs.sendKeys(textbox_password,password);
		bs.click(button_submit);
	}
	
	public void logout()
	{
		bs.click(button_logout);
	}
	
	public String getErrorMessage()
	{
		String value = bs.getText(text_ErrorMessage);
		String value2 = bs.getText(text_ErrorMessage_Close);
		value = value.replaceAll(value2,"").trim();
		System.out.println(value);
		return value;
	}
	
}

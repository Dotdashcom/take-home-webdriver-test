package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
public WebDriver driver;
	
	By Username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By loginButton=By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]/i[1]");
	By Text=By.xpath("//body/div[2]/div[1]/div[1]/h4[1]");
	By LogOut=By.xpath("//body/div[2]/div[1]/div[1]/a[1]");
	By flashMessage=By.xpath("//div[@id='flash']");
	
	
	public PageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement UserName()
	{
		return driver.findElement(Username);
	}
	

	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
	public WebElement LogInButton()
	{
		return driver.findElement(loginButton);
	}
	public String text()
	{
		return driver.findElement(Text).getText();
	}
	public WebElement LogOutButton()
	{
		return driver.findElement(LogOut);
	}
	public String FlashMessages()
	{
		return driver.findElement(flashMessage).getText();
	}
	public String username1()
	{
		String user="ABCDE";
		return user;
	}
	public String Password1()
	{
		String pass="123445667";
		return pass;
	}
	public String username2()
	{
		String user2="tomsmith";
		return user2;
	}
	public String Password2()
	{
		String pass2="SuperSecretPassword!";
		return pass2;
	}
}



package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPO {

	WebDriver driver;
		
	public LoginPO(WebDriver driver) {
		this.driver= driver;
	}
	
	By username= By.id("username");
	By password= By.id("password");
	By submit= By.xpath("//button[@class='radius']");
	By success= By.xpath("//h4[@class='subheader']");
	
	
	public void Validusername()
	{
		driver.findElement(username).sendKeys("tomsmith");	
	}
	
	public void Validpassword()
	{
		driver.findElement(password).sendKeys("SuperSecretPassword!");	
	}
	
	public void Invalidusername()
	{
		driver.findElement(username).sendKeys("Mikeholmes");	
	}
	
	public void Invalidpassword()
	{
		driver.findElement(password).sendKeys("tvhoststar");	
	}
	public void clicksubmit ()
	{
		driver.findElement(submit).click();	
	}
		
	public void validatesuccessmessage ()
	{
		boolean Message =driver.findElement(success).isDisplayed();
		Assert.assertEquals(Message,true);	
	}
	
	public void validatefailuremessage ()
	{
		boolean Message =driver.findElement(success).isDisplayed();
		Assert.assertEquals(Message,true);	
	}

	 
}


package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By username = By.id("username");
    By password = By.id("password");
    By Login = By.xpath("//*[@id=\"login\"]/button/i");
     

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(Login);
	}
	
}

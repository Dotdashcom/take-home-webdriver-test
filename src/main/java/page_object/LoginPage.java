package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public  WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement passWord;
	@FindBy(className="radius")
	private WebElement loginButton;
	
	public WebElement userName()
	{
		return userName;
	}
	public WebElement passWord()
	{
		return passWord;
	}
	public WebElement loginButton()
	{
		return loginButton;
	}
	
}

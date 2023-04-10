package navpreet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import navpreet.util.AbstractComponent;


public class SignInPageObjects extends AbstractComponent  {

	WebDriver driver;
	
	public SignInPageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href='/login']")
	private WebElement sign_in;
	
	@FindBy(id="username")
	private WebElement user_name;
	
	@FindBy(id="password")
	private WebElement pass_word;
	
	@FindBy(css="button[type='submit']")
	private WebElement login;
	
	@FindBy(id="flash")
	private WebElement message;
	
	
	public void Auth_Sign_in()
	{
		 sign_in.click();
	}
	
	public void enterUsername(String username)
	{
		user_name.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		pass_word.sendKeys(password);
	}
	
	public void ClickLogin()
	{
		login.click();
	}
	
	public String ValidateMessage()
	{
		return message.getText().split("!")[0];
	}
}

package pages;

import org.openqa.selenium.By;


public class LoginPage extends Driver {
	

	//Locators
	 public static By Username = By.id("username");
	 public static By Password = By.id("password");
	 public static By LoginBttn = By.className("radius");
	 public static By FlashSuccess = By.id("flash");
	 public static By FlashFail = By.xpath("//div[@class='flash error']");
	
	
	 // Navigate to Login page
	
	public static void NavigateTologinPage()
	{

		Driver.Instance.get(Baseurl+"//login");
		
	}
	
	// Enter login credentials 
	public static void EnterLoginCredentials(String user ,String passwd)
	{
		
		Driver.Instance.findElement(Username).sendKeys(user);
		Driver.Instance.findElement(Password).sendKeys(passwd);
		
	}
	
	//Click Login
	public static void ClickLoginButton() 
	{
		
		Driver.Instance.findElement(LoginBttn).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Get text after suuccesful login
	public static String GetSuccessText()
	{
		
		 return Driver.Instance.findElement(FlashSuccess).getText();
		
	}
	
	
	//Get Text if login fails
	public static String GetFailureText()
	{
		
		 return Driver.Instance.findElement(FlashFail).getText();
		
	}
	
	
}

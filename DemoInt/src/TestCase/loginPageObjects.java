package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObjects {
	

		 WebDriver driver;
		
		  @FindBy(id="username")
		  WebElement username;
		  
		  @FindBy(name="password")
		  WebElement password;
		  
		  @FindBy(xpath="//*[@id=\"login\"]/button/i")
		  WebElement Login;
	
		  public loginPageObjects(WebDriver d){
			  
			  driver =d;
			  PageFactory.initElements(d,this);
		  }

	 
	
}

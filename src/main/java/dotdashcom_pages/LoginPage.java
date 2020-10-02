package dotdashcom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;

   

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"login\"]/button")
	WebElement btn_login;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div/a")
	WebElement logout_button;
	//*[@id="content"]/div/a	
 

   public WebElement username()
   {
	return username;
	   
   }
   
   
   public WebElement password()
   {
	return password;
	   
   }
   
   public WebElement btn_login()
   {
	return btn_login;
	   
   }
   
   
   public WebElement logout_button()
   {
	return logout_button;
	   
   }
}

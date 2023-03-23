package pages;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
	 @FindBy(xpath="//*[@id='username']")
	 private WebElement enterUserName;
	 
	 @FindBy(xpath="//*[@id='password']")
	 private WebElement enterPassword;
	 
	 @FindBy(xpath="//*[@id='login']/button")
	 private WebElement clickLoginButton;
	 
	 @FindBy(xpath="//*[@id='flash']")
	 private WebElement loginValidationText;
	 
	 public void enterUserName(String username) {
		 enterUserName.sendKeys(username);
	 }
	 
	 public void enterPassword(String password) {
		 enterPassword.sendKeys(password);
	 }
	
	 public void clickLoginButton() {
		 clickLoginButton.click();
	 }
	 
	 public String loginValidationText() {
		 String successMessage=loginValidationText.getText();
		 String val=successMessage.substring(0, successMessage.indexOf("!")+1);
		
		 return val;
	 }
	}

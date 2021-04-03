package DotDashGithubChallenge.githubChallenge;


import static org.junit.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends TestBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "username")
	private WebElement userName;
	
	@FindBy (id = "password")
	private WebElement passWord;
	
	@FindBy (xpath = "//button[@type = 'submit']")
	private WebElement loginBtn;
	
	@FindBy (xpath = "//h4[@class = 'subheader']")
	private WebElement loginMessage;
	
	@FindBy (xpath = "//*[@id='content']/div/h2")
	private WebElement loginPageHeader;

	
	public void sendUserCredentials(String userID, String userPassword) {
		userName.sendKeys(userID);
		passWord.sendKeys(userPassword);
	}
	
	public void loginSuccess() {
	loginBtn.click();
	assertEquals("Welcome to the Secure Area. When you are done click logout below.",loginMessage.getText());
	System.out.println("User has successfully login");
	
	}
	
	public void loginFailure() {
		loginBtn.click();
		assertEquals("Login Page",loginPageHeader.getText());
		System.out.println("User has failed to login");
		
		}
	
	
	
}

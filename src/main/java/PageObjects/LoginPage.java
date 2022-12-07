package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class LoginPage extends BasePage {
	@FindBy (css = "a[class*=\"button\"][href*=\"logout\"]")
	WebElement logout;
	@FindBy (id = "flash")
	WebElement message;
	@FindBy (id = "password")
	WebElement password;
	@FindBy (css = "button[type=\"submit\"]")
	WebElement submit;
	@FindBy (id = "username")
	WebElement username;
	public LoginPage (Config testConfig) {
		super(testConfig);
	}
	public String getLoginFailedMessage() {
		return this.message.getText();
	}
	public Boolean isLoginSuccessful() {
		return this.logout.isDisplayed();
	}
	public void login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.submit.click();
	}
}

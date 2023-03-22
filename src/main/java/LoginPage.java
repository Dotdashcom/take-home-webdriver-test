import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends PageBase {
	// Declaring WebElements
	@FindBy(id = "username")
	private WebElement userNameInputBox;
	@FindBy(id = "password")
	private WebElement passwordInputBox;
	@FindBy(css = "button[type='submit']")
	private WebElement loginBtn;
	
    @FindBy(css="div[class='flash success']")
    private WebElement successMessage;
    @FindBy(id="flash")
    private WebElement errorMessage;


	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void login(String userName, String password) {
		waitTillElementVisible(userNameInputBox);
		userNameInputBox.sendKeys(userName);
		waitTillElementVisible(passwordInputBox);
		passwordInputBox.sendKeys(password);
		loginBtn.click();
	}
	
	public boolean successLoginMessageDisplayed() {
		return successMessage.isDisplayed();
	}
	
	public boolean failureLoginMessageDisplayed() {
		return errorMessage.isDisplayed();
	}
}

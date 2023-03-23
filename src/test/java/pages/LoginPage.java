package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import main.Hooks;
import utils.Constants;


public class LoginPage extends Constants {
	// variables
	

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logout;

	@FindBy(id = "flash-messages")
	WebElement flashMessage;

	// page constructor
	public LoginPage(WebDriver driver) {
		// purpose of initElements() is to initialize all the WebObjects that we created
		// above
		PageFactory.initElements(driver, this);
	}

	// methods
	

	public void enterUsername(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}


	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	
	public void clickLogin() {
		loginBtn.click();
	}

	public String getFlashMessage() {
		return flashMessage.getText();
	}
}


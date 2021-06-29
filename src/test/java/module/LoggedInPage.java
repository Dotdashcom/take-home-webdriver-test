package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPage {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.CLASS_NAME, using="button")
	private WebElement logoutButton;
		
	public LoggedInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getFlashMessage() {		
		WebElement flashMessage = driver.findElement(By.id("flash"));
		return flashMessage.getText();
	}
	
	/**
	 * Log out of the secure area
	 * Returns user back to login page
	 * @return LoginPage object
	 */
	public LoginPage clickLogout() {
		logoutButton.click();
		return new LoginPage(driver);
	}
}

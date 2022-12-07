package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage {
	
	private String page = "secure";
	
	private By flashMessage = By.id("flash-messages");

	public SecurePage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	public String getFlashMessage() {
		return driver.findElement(flashMessage).getText().toString();
	}
	
	public void openPage(String url) {
		driver.get(url);
	}
	
}

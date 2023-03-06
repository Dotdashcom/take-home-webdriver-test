package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTemplate {
	
	WebDriver driver;
	WebDriverWait wait;
	public BaseTemplate(WebDriver driver) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver = driver;
	}

	public void navigateToUrl(String url)
	{
		driver.navigate().to(driver.getCurrentUrl().toString()+url);
	}
}

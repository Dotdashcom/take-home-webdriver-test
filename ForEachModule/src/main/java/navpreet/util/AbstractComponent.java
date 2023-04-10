package navpreet.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class AbstractComponent {

	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}


	public void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
}

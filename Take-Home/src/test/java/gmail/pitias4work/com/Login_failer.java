package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class Login_failer extends Base {
	Logger logger = Logger.getLogger(Base.class);
	
	String url;

	public void login_fail() {

		try {
			
			driver.get("http://localhost:7080/login");
			logger.info("Title is :"+driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");
			// put the user name
			WebElement name = driver.findElement(By.cssSelector("#username"));
			name.sendKeys("tomsmith");
			// put the password
			WebElement password = driver.findElement(By.cssSelector("#password"));
			password.sendKeys("Password");
			// Submit click
			WebElement submit = driver.findElement(By.xpath("//button[@class=\"radius\"]"));
			lib.click(submit);

			
			// Assert the success page
			url = "http://localhost:7080/secure";
			String URL = driver.getCurrentUrl();

			assertEquals(URL, url);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}

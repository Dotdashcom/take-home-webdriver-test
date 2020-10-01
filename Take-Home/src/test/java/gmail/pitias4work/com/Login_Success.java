package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;



public class Login_Success extends Base {
	Logger logger = Logger.getLogger(Base.class);

	String url;

	public void logger() {

		try {
			driver.get(prop.readProperties("login_url"));
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");
			// put the user name
			WebElement name = driver.findElement(By.cssSelector(prop.readProperties("user_name")));
			name.sendKeys("tomsmith");
			// put the password
			WebElement password = driver.findElement(By.cssSelector(prop.readProperties("pass")));
			password.sendKeys("SuperSecretPassword!");
			// Submit click
			WebElement submit = driver.findElement(By.xpath(prop.readProperties("submit")));
			submit.click();

			
			lib.customWait(2);
			// Assert the success page
			url = "http://localhost:7080/secure";
			String URL = driver.getCurrentUrl();

			assertEquals(URL, url);
			test.log(Status.INFO, "Login Assertion Success!!");

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}

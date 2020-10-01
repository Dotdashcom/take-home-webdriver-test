package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class Login_failer extends Base {
	Logger logger = Logger.getLogger(Base.class);

	String url;

	public void login_fail() {

		try {

			driver.get(prop.readProperties("login_url"));
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");
			// put the user name
			WebElement name = driver.findElement(By.cssSelector(prop.readProperties("user_name")));
			name.sendKeys("tomsmith");
			// put the password
			WebElement password = driver.findElement(By.cssSelector(prop.readProperties("pass")));
			password.sendKeys("Password");
			// Submit click
			WebElement submit = driver.findElement(By.xpath(prop.readProperties("submit")));
			lib.click(submit);

			// Assert the success page or not
			url = "http://localhost:7080/secure";
			String URL = driver.getCurrentUrl();

			if(!(URL == url)) {
				assertTrue(true);
				test.log(Status.INFO, "User Logging Fail  Assertion Success!!");
			} 
			else {
				assertTrue(false);
				test.log(Status.FAIL, "User Logging Sucess Assertion Fail !!");
			}

			

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}

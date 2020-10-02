package dotdashcom_testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dotdashcom_pages.LoginPage;

public class TC02_Login_failure {
	public static WebDriver driver;

	// browser start method to start browser
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/login");

		// maximixed browser
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getdata")
	public void login_failed(String login_username, String login_password) {
		// object is created to call LoginPage class(POM class)
		LoginPage login = new LoginPage(driver);

		// username is given to textbox
		login.username().sendKeys(login_username);

		// password is given to textbox
		login.password().sendKeys(login_password);

		// login button clicked
		login.btn_login().click();

		// assertion to check if login button is displayed. if displayed login failure
		// as expected
		Assert.assertEquals(login.btn_login().isDisplayed(), true);

		Boolean result = login.btn_login().isDisplayed();
		if (result.equals(true)) {
			System.out.println("Login Failed as expected with incorrect username and password");

		} else {
			System.out.println("User loggedin with incorrectusername and password");
		}

	}

	@DataProvider
	public Object[][] getdata() {
		// 1 set of data with 2 values are passed
		Object data[][] = new Object[1][2];
		data[0][0] = "akalya";
		data[0][1] = "Super";
		return data;

	}

	@AfterMethod
	public void teardown() {
		// browser closer
		driver.close();
	}

}

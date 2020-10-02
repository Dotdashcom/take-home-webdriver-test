package dotdashcom_testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dotdashcom_pages.LoginPage;

public class TC01_Login_Successful {

	public static WebDriver driver;

	//browser starting method
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getdata")
	public void login_success(String login_username, String login_password) {
		//object is created to call LoginPage class(POM class)
		LoginPage login = new LoginPage(driver);
		
		//username is given to textbox
		login.username().sendKeys(login_username);
		
		//password is given to password textbox
		login.password().sendKeys(login_password);
		
		//login button is clicked
		login.btn_login().click();

		//assertion pass if login in successful and able to find logout button 
		
		Boolean result = login.logout_button().isDisplayed();
		if (result.equals(true)) {
			System.out.println("Login successful with correct username and password");

		} else {
			System.out.println("Login failed with correct username and password");
		}

	}

	@DataProvider
	public Object[][] getdata() {
		//1set of data and 2 values are used
		Object data[][] = new Object[1][2];
		data[0][0] = "tomsmith";
		data[0][1] = "SuperSecretPassword!";
		return data;

	}

	@AfterMethod
	public void teardown() {
		//closed the browser as only 1 browser is open
		driver.close();
	}

}

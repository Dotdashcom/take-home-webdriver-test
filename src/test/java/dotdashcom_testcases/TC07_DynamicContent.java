package dotdashcom_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC07_DynamicContent {
	public static WebDriver driver;

	// method to start browser with browser configurations
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// getting the url
		driver.get("http://localhost:7080/dynamic_content");

		// maximizing window
		driver.manage().window().maximize();
	}

	@Test
	public void refresh() {
		// received intial page load text in gettext
		String before_refresh_text = driver.findElement(By.xpath("//div[starts-with(@class,'large-10')]")).getText();

		// page is refreshed
		driver.navigate().refresh();

		// received 1st refresh text in gettext method
		String after_refresh_text = driver.findElement(By.xpath("//div[starts-with(@class,'large-10')]")).getText();

		// page is refreshed
		driver.navigate().refresh();

		// received 1st refresh text in gettext method
		String after_2ndrefresh_text = driver.findElement(By.xpath("//div[starts-with(@class,'large-10')]")).getText();

		// test asserts contents of text are not same for each refresh
		if (before_refresh_text != after_refresh_text) {
			System.out.println("Different content available after refresh");
		}

		if ((after_refresh_text != after_2ndrefresh_text) && (before_refresh_text != after_2ndrefresh_text)) {
			System.out.println("Different content available after 2nd refresh");
		}

	}

	@AfterMethod
	public void teardown() {
		// browser closed
		driver.close();
	}

}

package dotdashcom_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC09_DynamicLoading {
	public static WebDriver driver;
	WebDriverWait wait;

	// browser starting method
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// receiving url to browser
		driver.get("http://localhost:7080/dynamic_loading/2");

		// maximixing window
		driver.manage().window().maximize();
	}

	@Test
	public void dynamic_loading() {
		// Test clicks the start button and uses explicit wait.
		wait = new WebDriverWait(driver, 20);
		WebElement start_button_ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/button")));
		start_button_ele.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Test asserts that “Hello World!” text is displayed.
		String text = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
		System.out.println("Text available after clicking start button: " + text);
		Assert.assertEquals(text, "Hello World!");

	}

	@AfterMethod
	public void teardown() {
		// browser is closed
		driver.close();
	}

}

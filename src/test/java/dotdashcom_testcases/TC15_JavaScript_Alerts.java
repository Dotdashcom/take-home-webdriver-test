package dotdashcom_testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC15_JavaScript_Alerts {

	public static WebDriver driver;

	// browser staring method
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// receiving url to the browser
		driver.get("http://localhost:7080/javascript_alerts");

		// maximizing window
		driver.manage().window().maximize();
	}

	// JS Alert
	@Test
	public void a_js_alert() {
		// Test Clicks on JS Alert Button.
		WebElement js_alert_element = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		js_alert_element.click();

		// Test asserts text present in JS alert
		String js_alert_text = driver.switchTo().alert().getText();
		System.out.println("js Alert message is :" + js_alert_text);
		Assert.assertEquals(js_alert_text, "I am a JS Alert");

		// Test asserts accepts alert message.
		driver.switchTo().alert().accept();

	}

	// JS Confirm Alert
	@Test
	public void b_js_confirm_alert() {
		// Test Clicks on JS Confirm Alert Button.
		WebElement js_alert_ele_con = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		js_alert_ele_con.click();

		// Test asserts text present in JS confirm alert
		String js_confirm_alert_text = driver.switchTo().alert().getText();
		System.out.println("js_confirm Alert message is :" + js_confirm_alert_text);
		Assert.assertEquals(js_confirm_alert_text, "I am a JS Confirm");

		// Test asserts accepts alert message
		driver.switchTo().alert().accept();

	}

	// JS Prompt Alert
	@Test
	public void c_js_prompt_alert() throws InterruptedException {
		// Test Clicks on JS Prompt Alert Button.
		WebElement js_alert_ele_prompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		js_alert_ele_prompt.click();

		// sending some text to prompt alert input box
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("akalya");
		// accepts prompt alert
		prompt.accept();

		//// Test asserts text present in JS prompt alert
		String result = driver.findElement(By.id("result")).getText();
		System.out.println("prompt alert result is: " + result);

		Assert.assertEquals(result, "You entered: akalya");

	}

	@AfterMethod
	public void teardown() {
		// browser closed
		driver.close();
	}
}

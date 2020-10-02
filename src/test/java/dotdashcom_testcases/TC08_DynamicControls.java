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

public class TC08_DynamicControls {

	public static WebDriver driver;
	WebDriverWait wait;

	// method to start browser
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// receiving url to the browser
		driver.get("http://localhost:7080/dynamic_controls");

		// maximixing window
		driver.manage().window().maximize();
	}

	@Test
	public void a_remove_and_add_button() throws InterruptedException {
		// implicitly waiting for every element on this method
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 20);

		// Test clicks on the Remove Button and uses explicit wait.
		WebElement remover_button_ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='swapCheckbox()']")));
		remover_button_ele.click();

		// get the text of "its gone" and aseert for expected
		String checkbox_removed_text = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
		System.out.println("Text available after removing checkbox : " + checkbox_removed_text);
		Assert.assertEquals(checkbox_removed_text, "It's gone!");

		// Test clicks on Add Button and uses explicit wait.
		WebElement addr_button_ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='swapCheckbox()']")));
		addr_button_ele.click();

		// Test asserts that the checkbox is present.
		String checkbox_rece_text = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
		System.out.println("Text available after adding checkbox : " + checkbox_rece_text);
		Assert.assertEquals(checkbox_rece_text, "It's back!");

	}

	@Test
	public void enable_and_disable() {
		wait = new WebDriverWait(driver, 20);

		// Test clicks on the enable Button and uses explicit wait.
		WebElement enable_button = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
		enable_button.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get the text of "its gone" and aseert for expected
		String textbox_enabled_text = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")).getText();
		System.out.println("Text available after removing checkbox : " + textbox_enabled_text);
		Assert.assertEquals(textbox_enabled_text, "It's enabled!");

		// Test clicks on the disable Button and uses explicit wait.
		WebElement disable_button = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button")));
		disable_button.click();

		// get the text of "its gone" and aseert for expected
		String textbox_disabled_text = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")).getText();
		System.out.println("Text available after removing checkbox : " + textbox_disabled_text);
		Assert.assertEquals(textbox_disabled_text, "It's disabled!");
	}

	@AfterMethod
	public void teardown() {
		// browser closed
		driver.close();
	}

}

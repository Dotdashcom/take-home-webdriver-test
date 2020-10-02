package dotdashcom_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC06_Dropdown {

	public static WebDriver driver;

	// browser starting method
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();

		// received url to the browser
		driver.get("http://localhost:7080/dropdown");

		// maximized the window
		driver.manage().window().maximize();
	}

	@Test
	public void dropdown_option2() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// element of dropdown stored in webelement
		WebElement dropdown_element1 = driver.findElement(By.id("dropdown"));

		// Option 1
		// option 1 is selected
		Select dropdown1 = new Select(dropdown_element1);
		dropdown1.selectByIndex(1);

		// printing selected option in console
		String option1_selected = dropdown1.getFirstSelectedOption().getText();
		System.out.println("Selected option for test 2 is : " + option1_selected);

		// test assert is option 1 is selected
		Assert.assertEquals(option1_selected, "Option 1");

		// Option 2
		// option 2 is selected
		WebElement dropdown_element = driver.findElement(By.id("dropdown"));
		Select dropdown = new Select(dropdown_element);
		dropdown.selectByIndex(2);

		// printing selected option in console
		String option2_selected = dropdown.getFirstSelectedOption().getText();
		System.out.println("Selected option for test 2 is : " + option2_selected);

		// test assert is option 1 is selected
		Assert.assertEquals(option2_selected, "Option 2");

	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}

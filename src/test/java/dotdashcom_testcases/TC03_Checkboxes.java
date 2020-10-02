package dotdashcom_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC03_Checkboxes {

	public static WebDriver driver;

	// method to invoke browser
	@BeforeMethod
	public void BrowserInvoking() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();
		// getting url
		driver.get("http://localhost:7080/checkboxes");

		// maximizing browser
		driver.manage().window().maximize();

	}

	@Test
	public void checkboxes() {
		// clicked(selected-checked checkbox1)
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		checkbox1.click();

		// Asserting is checkbox 1 is selected as expected
		System.out.println("Is checkbox1 selected: " + checkbox1.isSelected());
		Assert.assertEquals(true, checkbox1.isSelected());

		// clicked(Unselected-checked checkbox2) which is selected by default
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		checkbox2.click();

		// Asserting is checkbox 2 is unselected as expected which is selected by
		// default
		System.out.println("Is checkbox2 selected: " + checkbox2.isSelected());
		Assert.assertEquals(false, checkbox2.isSelected());
	}

	@AfterMethod
	public void teardown() {
		// blowser is closed as only 1 browser will be open
		driver.close();
	}

}

package newtab;


import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTap {

	static String url = "http://localhost:7080/windows";
	static WebDriver driver;

	@BeforeTest
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void Newtap() {
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/a"));
		element.click();

		Set<String> windows = driver.getWindowHandles();

		for (String win : windows) {
			driver.switchTo().window(win);
		}

		String actualTitle = driver.getTitle();
		String expectedTitle = "New Window";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}

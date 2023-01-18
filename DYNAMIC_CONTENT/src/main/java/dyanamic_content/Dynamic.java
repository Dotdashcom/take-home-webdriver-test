package dyanamic_content;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dynamic {

	static String url = "http://localhost:7080/dynamic_content ";
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
	public void dyanamicContent() {

		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);

		Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement loadingIcon = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]/a"));
				String displayValue = loadingIcon.getCssValue("display");
				loadingIcon.click();
				if (displayValue.equals("none")) {
					return true;
				}
				return false;
			}
		};

		fw.until(func);

	}

//    @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}

package jst_alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class Js_alert {

	static String url = "http://localhost:7080/javascript_alerts";
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

	@Test(priority = 2)
	public void checkAlert() throws InterruptedException {
		WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		jsAlert.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		Assert.assertEquals(true, driver.getPageSource().contains("You successfuly clicked an alert"));
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void checkToJsComfirm() throws InterruptedException {
		WebElement jsComfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		jsComfirm.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		
		Assert.assertEquals(true,driver.getPageSource().contains("You clicked: Cancel"));
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void checkToJsPrompt() throws InterruptedException {
		WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		jsPrompt.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello I am jsAlert");
		alert.accept();
		
		Assert.assertEquals(true,driver.getPageSource().contains("You entered: Hello I am jsAlert") );
		Thread.sleep(2000);

	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}

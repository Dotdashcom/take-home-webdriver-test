package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMessage {

	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/notification_message_rendered");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void NotificationMessageTest() throws InterruptedException {

		for (int i = 0; i <= 6; i++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
			String FlashMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
			if (FlashMessage.contains("please try again")) {
				System.out.println(FlashMessage);
				assertTrue(FlashMessage.contains("please try again"));
				driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
			} else

			{
				System.out.println(FlashMessage);
				assertTrue(FlashMessage.contains("Action successful"));
				driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
			}
		}

	}

}

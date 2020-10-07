package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NotificationMessage extends base {

	@Test
	public void NotificationMessageTest() throws InterruptedException {
		driver.get(URL + "notification_message_rendered");
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

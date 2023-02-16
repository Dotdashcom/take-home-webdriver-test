import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Notification {

	@Test
	public static void notificationsTest() throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/notification_message_rendered");
		
		String winHandleBefore = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Click here")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.id("flash")).getText());
		
		
		
		

	}

}

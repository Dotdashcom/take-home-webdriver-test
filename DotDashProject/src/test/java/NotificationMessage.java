import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationMessage {
		
		@Test	
		public void NotificationMessage() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:7080/notification_message_rendered");
		
		driver.findElement(By.linkText("Click here")).click();
		
        WebElement Text= driver.findElement(By.xpath("//div[@id='flash']"));
        String s = Text.getText();
       
        Assert.assertEquals(s, "Action successful"); //if it finds the same message it will execute, otherwise the execution will fail
        
        

		
		
		
		
		
		}
}

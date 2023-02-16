import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptAlerts {

	@Test
	public static void javaScriptAlertsTest() {
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/javascript_alerts");
		
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		
		driver.switchTo().alert().accept();
		
		
		
		

	}

}

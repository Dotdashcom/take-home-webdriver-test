import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailure {

	@Test
	public static void loginFailureTest() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/login");
		
		driver.findElement(By.id("username")).sendKeys("smith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPa!");
		driver.findElement(By.className("radius")).click();
		
		String expected=driver.findElement(By.id("flash")).getText();
		
		Assert.assertEquals("Your username is invalid!", expected);
		
		driver.quit();

	}

}

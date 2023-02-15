import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSuccess {
	
	
	@Test
	public void loginSuccessTest() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/login");
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
		
		String expected=driver.findElement(By.cssSelector("#flash")).getText();
		
		System.out.println(expected);
		
		Assert.assertEquals("You logged into a secure area!", expected);
		
		
		driver.quit();
	}

}
